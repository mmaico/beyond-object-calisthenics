package examples.dao.rest;

import examples.dao.entity.AdvertenceEntity;
import examples.dao.service.AdvertenceService;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.*;

@RestController("advertenceEndpointModuleDAO")
public class AdvertenceEndpoint {

    private AdvertenceService service;

    public AdvertenceEndpoint(AdvertenceService service) {
        this.service = service;
    }


    @ResponseStatus(HttpStatus.CREATED)
    @RequestMapping(value = "/dao/advertences", method = RequestMethod.POST)
    public @ResponseBody AdvertenceEntity save(@RequestBody AdvertenceEntity entity) {
        return service.save(entity);
    }

    @RequestMapping(value = "/dao/advertences", method = RequestMethod.GET)
    public @ResponseBody Iterable<AdvertenceEntity> findAll() {
        return service.findAll();
    }
}
