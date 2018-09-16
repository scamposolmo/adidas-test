package adidas.entities;


import javax.persistence.*;
import javax.validation.constraints.NotEmpty;
import java.util.Set;

@Entity
public class City {
    @Id
    @GeneratedValue(strategy= GenerationType.AUTO)
    private Integer id;

    @NotEmpty
    private String name;

    @OneToMany(mappedBy = "destination", cascade = CascadeType.ALL)
    private Set<Itinerary> itinerariesDestination;

    @OneToMany(mappedBy = "origin", cascade = CascadeType.ALL)
    private Set<Itinerary> itinerariesOrigin;


    public Set<Itinerary> getItinerariesDestination() {
        return itinerariesDestination;
    }

    public Set<Itinerary> getItinerariesOrigin() {
        return itinerariesOrigin;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public void setName(String name) {
        this.name = name;
    }

    public Integer getId() {
        return id;
    }

    public String getName() {
        return name;
    }
}
