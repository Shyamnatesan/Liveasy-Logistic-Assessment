package com.example.liveeasylogisticassessment.controller;

import com.example.liveeasylogisticassessment.Entity.Loads;
import com.example.liveeasylogisticassessment.repository.LoadRepository;
import org.springframework.beans.BeanUtils;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.UUID;

@RestController
@RequestMapping("api/v1/loads")
public class LoadContoller {

    private final LoadRepository loadRepository;

    public LoadContoller(LoadRepository loadRepository) {
        this.loadRepository = loadRepository;
    }

    // Get Request => gets all the records in the database
    @GetMapping
    public List<Loads> getAllLoads(){
        return loadRepository.findAll();
    }


    // Post Request => creates a new record in our database
    @PostMapping
    public String createLoad(@RequestBody Loads loadEntity){
        Loads load = new Loads();
        BeanUtils.copyProperties(loadEntity, load);
        loadRepository.save(load);
        return "Loads details added successfully";
    }

    //  Delete Request => deletes all the records in our database
    @DeleteMapping
    public String deleteAllLoads(){
        loadRepository.deleteAll();
        return "All load record had been deleted successfully";
    }

    // Get Request (by specific id) => gets the records with the matching id
    @GetMapping("/{shipperId}")
    public ResponseEntity<Loads> getLoadById(@PathVariable UUID shipperId){
        Loads loads = loadRepository.findById(shipperId).get();
        return ResponseEntity.ok(loads);
    }

    // Put Request => Updates the record with the given shipping id
    @PutMapping("/{shipperId}")
    public ResponseEntity<Loads> updateLoadById(@PathVariable UUID shipperId, @RequestBody Loads loads){
        Loads updatedLoad = loadRepository.findById(shipperId).get();
        updatedLoad.setLoadingPoint(loads.getLoadingPoint());
        updatedLoad.setUnloadingPoint(loads.getUnloadingPoint());
        updatedLoad.setProductType(loads.getProductType());
        updatedLoad.setTruckType(loads.getTruckType());
        updatedLoad.setNoOfTrucks(loads.getNoOfTrucks());
        updatedLoad.setWeight(loads.getWeight());
        updatedLoad.setComment(loads.getComment());
        updatedLoad.setDate(loads.getDate());
        loadRepository.save(updatedLoad);
        return ResponseEntity.ok(updatedLoad);
    }


    // Delete Request (by specific id) => deletes only the records with the matching id
    @DeleteMapping("/{shipperId}")
    public String deleteLoadById(@PathVariable UUID shipperId){
        Loads load = loadRepository.findById(shipperId).get();
        loadRepository.delete(load);
        return "Successfully deleted";
    }

}
