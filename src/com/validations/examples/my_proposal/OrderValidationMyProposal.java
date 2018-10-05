package com.validations.examples.my_proposal;

import com.validations.infra.*;

import java.math.BigDecimal;
import java.util.HashMap;
import java.util.Map;
import java.util.Optional;

public class OrderValidationMyProposal {

    private static final BigDecimal MINIMUM_VALUE = new BigDecimal(4);

    private CustomerRepository customerRepository;
    private SellerRepository sellerRepository;
    private CouponRepository couponRepository;


    public OrderValidationMyProposal() {
        this.customerRepository = new CustomerRepository();
        this.sellerRepository = new SellerRepository();
        this.couponRepository = new CouponRepository();
    }

    private Map<String, CheckRule> rules = new HashMap<>();

    {
        rules.put("Order cannot be less than $4", order ->
                NumberHelper.INSTANCE.isLessThan(order.getTotal(), MINIMUM_VALUE) );

        rules.put("customer is required", order -> order.getCustomer() == null);
        rules.put("informed customer was not found", order -> customerRepository.findOne(order.getCustomer().getId()) == null);
        rules.put("seller is required", order -> order.getSeller() == null);
        rules.put("informed seller was not found", order -> sellerRepository.findOne(order.getSeller().getId()) == null);
        rules.put("seller is not active", order -> !sellerRepository.findOne(order.getSeller().getId()).isActive());
        rules.put("coupon was not found", order -> order.getCoupon() != null && couponRepository.findOne(order.getCoupon().getId()) == null);
    }


    public void checkRules(Order order) {

        Optional<String> violations = rules.entrySet().stream()
                .filter(rule -> rule.getValue().check(order)).map(rule -> rule.getKey()).findFirst();

        if (violations.isPresent()) {
            throw new RuntimeException(violations.get());
        }
    }

    private interface CheckRule {
        Boolean check(Order order);
    }

    public static void main(String[] args) {
        Order order =  new Order("", BigDecimal.TEN, new Customer("1"), new Seller("2", true), new Coupon("2"));
        new OrderValidationMyProposal().checkRules(order);
    }
}


