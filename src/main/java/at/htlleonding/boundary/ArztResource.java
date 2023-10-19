package at.htlleonding.boundary;

import at.htlleonding.control.ArztRepository;
import at.htlleonding.entity.Arzt;
import jakarta.inject.Inject;
import jakarta.transaction.Transactional;
import jakarta.validation.Valid;
import jakarta.ws.rs.*;
import jakarta.ws.rs.core.MediaType;
import jakarta.ws.rs.core.Response;

import java.util.List;

@Path("/api/arzt")
public class ArztResource {

    @Inject
    ArztRepository arztRepository;

    @GET
    @Produces(MediaType.APPLICATION_JSON)
    public List<Arzt> getAll() {
        return arztRepository.listAll();
    }

    @POST
    @Consumes(MediaType.APPLICATION_JSON)
    @Transactional
    public Response saveArzt(@Valid Arzt ar) {
        arztRepository.persist(ar);
        return Response.created(null).build();
    }

}
