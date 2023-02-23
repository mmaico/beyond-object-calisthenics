package examples.repository.infrastructure;


import org.springframework.hateoas.Link;

public class LinksHelper {
    public static Long extractId(Link link) {
        if (link == null) return null;
        return Long.valueOf(link.getHref().replaceAll("\\D+", ""));
    }
}