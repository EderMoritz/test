package at.htlleonding;

import at.htlleonding.control.ArztRepository;
import at.htlleonding.entity.Arzt;
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

    @Inject
    ArztRepository arztRepository;

    public SomePage(Template page) {
        this.page = requireNonNull(page, "page is required");
    }

    @GET
    @Produces(MediaType.TEXT_HTML)
    public TemplateInstance get(@QueryParam("name") String name) {

        return page.data("name", name);
        //List<Arzt> arztList = arztRepository.listAll();

        //return page.data(arztList);
    }

}
