package at.htlleonding;

import at.htlleonding.control.ArztRepository;
import at.htlleonding.entity.Arzt;
import io.quarkus.qute.CheckedTemplate;
import io.quarkus.qute.Template;
import io.quarkus.qute.TemplateInstance;

import jakarta.inject.Inject;
import jakarta.ws.rs.GET;
import jakarta.ws.rs.Path;
import jakarta.ws.rs.Produces;
import jakarta.ws.rs.QueryParam;
import jakarta.ws.rs.core.MediaType;

import java.util.List;

import static java.util.Objects.requireNonNull;

@Path("/some-page")
public class SomePage {

    private final Template page;

    @CheckedTemplate
    public static class Templates {
        public static native TemplateInstance arzt(
                String title,
                List<Arzt> arztList
        );
    }

    @Inject
    ArztRepository arztRepository;

    public SomePage(Template page) {
        this.page = requireNonNull(page, "page is required");
    }

    @GET
    @Produces(MediaType.TEXT_HTML)
    public String get(@QueryParam("name") String name) {

        //return page.data("name", name);
        var arztList = arztRepository.listAll();

        return Templates.arzt("title", arztList).render();
    }

}
