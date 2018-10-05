package com.validations.examples.object_calisthenics;

import com.validations.examples.common.OrderValidationCommon;
import com.validations.infra.*;

import java.math.BigDecimal;
import java.util.HashMap;
import java.util.Map;
import java.util.Optional;

public class OrderValidationObjectCalisthenics {

    private static final BigDecimal MINIMUM_VALUE = new BigDecimal(4);

    private CustomerRepository customerRepository;
    private SellerRepository sellerRepository;
    private CouponRepository couponRepository;


    public OrderValidationObjectCalisthenics() {
        this.customerRepository = new CustomerRepository();
        this.sellerRepository = new SellerRepository();
        this.couponRepository = new CouponRepository();
    }

    public void validate(Order order) {

        if (NumberHelper.INSTANCE.isLessThan(order.getTotal(), MINIMUM_VALUE)) {
            throw new RuntimeException("Order cannot be less than $4");
        }

        if(order.getCustomer() == null) {
            throw new RuntimeException("customer is required");
        }

        Customer customer = customerRepository.findOne(order.getCustomer().getId());

        if (customer == null) {
            throw new RuntimeException("informed customer was not found");
        }

        if (order.getSeller() == null) {
            throw new RuntimeException("seller is required");
        }

        Seller seller = sellerRepository.findOne(order.getSeller().getId());

        if (seller == null) {
            throw new RuntimeException("informed seller was not found");
        }

        if (!seller.isActive()) {
            throw new RuntimeException("seller is not active");
        }

        if (order.getCoupon() != null) {
            Coupon coupon = couponRepository.findOne(order.getCoupon().getId());
            if (coupon == null) {
                throw new RuntimeException("coupon was not found");
            }
        }
    }

    public static void main(String[] args) {
        Order order =  new Order("", BigDecimal.TEN, new Customer("1"), new Seller("2", true), new Coupon("2"));

        new OrderValidationObjectCalisthenics().validate(order);
    }
}


