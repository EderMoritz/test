package at.htlleonding.entity;

import jakarta.enterprise.context.ApplicationScoped;

@ApplicationScoped
public class ArztMapper {

    public Arzt fromDtoToArzt(ArztDto arztDto) {
        var arzt = new Arzt();
        arzt.setName(arztDto.name());
        arzt.setProfession(arztDto.profession());
        return arzt;
    }
}
