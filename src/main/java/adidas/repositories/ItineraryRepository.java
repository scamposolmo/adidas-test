package adidas.repositories;

import adidas.entities.Itinerary;
import org.springframework.data.repository.CrudRepository;

import java.util.List;

// This will be AUTO IMPLEMENTED by Spring into a Bean called userRepository
// CRUD refers Create, Read, Update, Delete
public interface ItineraryRepository extends CrudRepository<Itinerary, Integer>{
    List<Itinerary> findAllByDestinationId(Integer id);
    List<Itinerary> findAllByOriginId(Integer id);
    List<Itinerary> findAllByOriginIdAndDestinationId(Integer origin, Integer destination);
}
