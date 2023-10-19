package at.htlleonding.boundary;

import at.htlleonding.control.ArztRepository;
import at.htlleonding.entity.Arzt;
import at.htlleonding.entity.ArztDto;
import at.htlleonding.entity.ArztMapper;
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

    @Inject
    ArztMapper arztMapper;

    @GET
    @Produces(MediaType.APPLICATION_JSON)
    public List<Arzt> getAll() {
        return arztRepository.listAll();
    }

    @POST
    @Consumes(MediaType.APPLICATION_JSON)
    @Transactional
    public Response saveArzt(@Valid ArztDto dto) {
        var arzt = arztMapper.fromDtoToArzt(dto);
        arztRepository.persist(arzt);
        return Response.created(null).build();
    }

}
