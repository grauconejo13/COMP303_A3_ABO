package com.drop.bloodbank.VanessaVictorino_COMP303A3_ABO.controllers;

import com.drop.bloodbank.VanessaVictorino_COMP303A3_ABO.entities.Seeker;
import com.drop.bloodbank.VanessaVictorino_COMP303A3_ABO.services.SeekerService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api/seekers")  // Base URL for Seeker API
public class SeekerRestController {

    @Autowired
    private SeekerService seekerService;

    @GetMapping("/test")
    public String test() {
        return "Basic test works!";
    }
    
    // Retrieve all seekers
    @GetMapping
    public List<Seeker> getAllSeekers() {
        return seekerService.getAllSeekers();
    }

    // Retrieve a seeker by ID
    @GetMapping("/{id}")
    public ResponseEntity<Seeker> getSeekerById(@PathVariable int id) {
        Seeker seeker = seekerService.getSeekerById(id);
        if (seeker != null) {
            return new ResponseEntity<>(seeker, HttpStatus.OK);
        } else {
            return new ResponseEntity<>(HttpStatus.NOT_FOUND);
        }
    }

    // Add a new seeker
    @PostMapping
    public ResponseEntity<Seeker> addSeeker(@RequestBody Seeker seeker) {
        Seeker createdSeeker = seekerService.addSeeker(seeker);
        return new ResponseEntity<>(createdSeeker, HttpStatus.CREATED);
    }

    // Update an existing seeker by ID
    @PutMapping("/{id}")
    public ResponseEntity<Seeker> updateSeeker(@PathVariable int id, @RequestBody Seeker seeker) {
        Seeker updatedSeeker = seekerService.updateSeeker(id, seeker);
        if (updatedSeeker != null) {
            return new ResponseEntity<>(updatedSeeker, HttpStatus.OK);
        } else {
            return new ResponseEntity<>(HttpStatus.NOT_FOUND);
        }
    }

    // Delete a seeker by ID
    @DeleteMapping("/{id}")
    public ResponseEntity<Void> deleteSeeker(@PathVariable int id) {
        boolean deleted = seekerService.deleteSeeker(id);
        if (deleted) {
            return new ResponseEntity<>(HttpStatus.NO_CONTENT);
        } else {
            return new ResponseEntity<>(HttpStatus.NOT_FOUND);
        }
    }
}
