package com.drop.bloodbank.VanessaVictorino_COMP303A3_ABO.controllers;

import com.drop.bloodbank.VanessaVictorino_COMP303A3_ABO.entities.Seeker;
import com.drop.bloodbank.VanessaVictorino_COMP303A3_ABO.services.SeekerService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;
import java.util.List;

@RestController
@RequestMapping("/seekers")
public class SeekerController {

    @Autowired
    private SeekerService seekerService;

    @GetMapping("/seekers")  // Maps this method to /seekers
    public String viewSeekersPage(Model model) {
        model.addAttribute("seekers", seekerService.getAllSeekers());
        return "seeker";  // Corresponds to seeker.html in the templates folder
    }
    
    // GET all seekers
    @GetMapping
    public List<Seeker> getAllSeekers() {
        return seekerService.getAllSeekers();
    }

    // GET a seeker by ID
    @GetMapping("/{id}")
    public ResponseEntity<Seeker> getSeekerById(@PathVariable int id) {
        Seeker seeker = seekerService.getSeekerById(id);
        return seeker != null ? ResponseEntity.ok(seeker) : ResponseEntity.notFound().build();
    }

    // POST a new seeker
    @PostMapping
    public ResponseEntity<Seeker> addSeeker(@RequestBody Seeker seeker) {
        Seeker createdSeeker = seekerService.addSeeker(seeker);
        return ResponseEntity.status(HttpStatus.CREATED).body(createdSeeker);
    }

    // PUT (update) a seeker by ID
    @PutMapping("/{id}")
    public ResponseEntity<Seeker> updateSeeker(@PathVariable int id, @RequestBody Seeker seeker) {
        Seeker updatedSeeker = seekerService.updateSeeker(id, seeker);
        return updatedSeeker != null ? ResponseEntity.ok(updatedSeeker) : ResponseEntity.notFound().build();
    }

    // DELETE a seeker by ID
    @DeleteMapping("/{id}")
    public ResponseEntity<Void> deleteSeeker(@PathVariable int id) {
        boolean isDeleted = seekerService.deleteSeeker(id);
        return isDeleted ? ResponseEntity.noContent().build() : ResponseEntity.notFound().build();
    }
}
