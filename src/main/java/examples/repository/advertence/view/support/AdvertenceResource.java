package examples.repository.advertence.view.support;

import com.fasterxml.jackson.annotation.JsonInclude;
import com.fasterxml.jackson.annotation.JsonPropertyOrder;
import org.springframework.hateoas.RepresentationModel;
import org.springframework.hateoas.server.core.Relation;

@JsonPropertyOrder({
        "id",
        "_links"
})
@JsonInclude(JsonInclude.Include.NON_NULL)
@Relation(collectionRelation = "advertences")
public class AdvertenceResource extends RepresentationModel<AdvertenceResource> {


}
