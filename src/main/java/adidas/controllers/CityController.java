package adidas.controllers;


import adidas.entities.City;
import adidas.repositories.CityRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.*;

import java.util.Optional;

@Controller
@RequestMapping(path ="/city")
public class CityController {
    @Autowired
    private CityRepository cityRepository;

    @RequestMapping(
            method = RequestMethod.GET
    )
    public @ResponseBody Iterable<City> getAllCities(){
        return cityRepository.findAll();
    }

    @RequestMapping(
            method = RequestMethod.GET,
            path = "/{id}"
    )
    public @ResponseBody
    Optional<City> getCityById(@PathVariable Integer id){
        return cityRepository.findById(id);
    }

    @RequestMapping(
            method = RequestMethod.POST,
            path = ""
    )
    public @ResponseBody City addNewCity(@RequestBody City city) {
        return cityRepository.save(city);
    }
}
