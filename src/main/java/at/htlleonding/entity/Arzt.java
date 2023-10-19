package at.htlleonding.entity;

import jakarta.persistence.*;
import jakarta.validation.constraints.NotEmpty;
import jakarta.validation.constraints.NotNull;

@Entity
@Table(name = "TEST_ARZT")
public class Arzt {

    @Id
    @GeneratedValue(strategy = GenerationType.SEQUENCE)
    @Column(name = "DOC_ID")
    private Long id;
    @Column(name = "DOC_NAME")
    @NotEmpty
    @NotNull
    private String name;
    @Column(name = "DOC_PROFESSION")
    @NotEmpty
    @NotNull
    private String profession;

    public Arzt() {
    }

    public Arzt(String name, String profession) {
        this.name = name;
        this.profession = profession;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getProfession() {
        return profession;
    }

    public void setProfession(String profession) {
        this.profession = profession;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public Long getId() {
        return id;
    }
}
