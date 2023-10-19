package at.htlleonding.control;

import at.htlleonding.entity.Arzt;
import io.quarkus.hibernate.orm.panache.PanacheRepository;
import jakarta.enterprise.context.ApplicationScoped;

@ApplicationScoped
public class ArztRepository implements PanacheRepository<Arzt> {

}
