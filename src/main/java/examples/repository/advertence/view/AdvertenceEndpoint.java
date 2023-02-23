package examples.repository.advertence.view;

import examples.repository.advertence.application.AdvertenceFacade;
import examples.repository.advertence.domain.model.director.Director;
import examples.repository.advertence.view.support.AdvertenceAssembler;
import examples.repository.advertence.view.support.AdvertenceResource;
import org.springframework.data.domain.PageImpl;
import org.springframework.data.domain.PageRequest;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.*;

@RestController
public class AdvertenceEndpoint {

    private AdvertenceAssembler assembler;
    private AdvertenceFacade facade;

    public AdvertenceEndpoint(AdvertenceAssembler assembler, AdvertenceFacade facade) {
        this.assembler = assembler;
        this.facade = facade;
    }

    @ResponseStatus(HttpStatus.CREATED)
    @RequestMapping(value = "/advertences", method = RequestMethod.POST)
    public @ResponseBody AdvertenceResource save(@RequestBody AdvertenceResource resource) {
        var advertence = assembler.fromResource(resource);
        return assembler.toModel(facade.apply(advertence));
    }

    @RequestMapping(value = "/advertences", method = RequestMethod.GET)
    public @ResponseBody Iterable<AdvertenceResource> findAll() {
        //Director e page tem que ser passado como parametro
        return assembler.toCollectionModel(facade.findAll(new Director(3l), null));
    }

}
