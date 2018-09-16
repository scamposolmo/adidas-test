package adidas.controllers;

import adidas.entities.Itinerary;
import adidas.repositories.ItineraryRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.*;

import java.util.Optional;

@Controller
@RequestMapping(path="/itinerary")
public class ItineraryController {
    @Autowired
    private ItineraryRepository itineraryRepository;

    @RequestMapping(
            method = RequestMethod.POST
    )
    public @ResponseBody
    Itinerary addNewItinerary (@RequestBody Itinerary itinerary) {

        return itineraryRepository.save(itinerary);
    }


    @RequestMapping(
            method = RequestMethod.GET
    )
    public @ResponseBody
    Iterable<Itinerary> getAllItineraries(@RequestParam(value="destination", required=false)Integer destination,
                                          @RequestParam(value="origin", required=false)Integer origin){

          if(origin == null && destination == null){
                return itineraryRepository.findAll();
            }
            else if(destination == null){
                return itineraryRepository.findAllByOriginId(origin);
            }else if (origin == null){
                return itineraryRepository.findAllByDestinationId(destination);
            }else return itineraryRepository.findAllByOriginIdAndDestinationId(origin,destination);

    }

    @RequestMapping(
            method = RequestMethod.GET,
            path = "/{id}"
    )
    public @ResponseBody
    Optional<Itinerary> getCityById(@PathVariable Integer id){
        return itineraryRepository.findById(id);
    }


}
