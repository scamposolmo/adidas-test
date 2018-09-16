package adidas.entities;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;

import javax.persistence.*;

@Entity
public class Itinerary {

    @Id
    @GeneratedValue(strategy= GenerationType.AUTO)
    private Integer id;

    @ManyToOne
    @JoinColumn(name = "origin_city_id")
    @JsonIgnoreProperties({"itinerariesDestination","itinerariesOrigin"})
    private City origin;

    @ManyToOne
    @JoinColumn(name = "destination_city_id")
    @JsonIgnoreProperties({"itinerariesDestination","itinerariesOrigin"})
    private City destination;

    private Integer departureTime;
    private Integer arrivalTime;

    public Integer duration(){
        return this.arrivalTime - this.departureTime;
    }

    public void setOrigin(City origin) {
        this.origin = origin;
    }

    public void setDestination(City destination) {
        this.destination = destination;
    }

    public void setDepartureTime(Integer departureTime) {
        this.departureTime = departureTime;
    }

    public void setArrivalTime(Integer arrivalTime) {
        this.arrivalTime = arrivalTime;
    }

    public Integer getId() {
        return id;
    }

    public City getOrigin() {
        return origin;
    }

    public City getDestination() {
        return destination;
    }

    public Integer getDepartureTime() {
        return departureTime;
    }

    public Integer getArrivalTime() {
        return arrivalTime;
    }
}
