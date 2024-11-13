package com.drop.bloodbank.VanessaVictorino_COMP303A3_ABO.controllers;

import com.drop.bloodbank.VanessaVictorino_COMP303A3_ABO.entities.Seeker;
import com.drop.bloodbank.VanessaVictorino_COMP303A3_ABO.services.SeekerService;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api/seekers")
public class SeekerRestController {

    private final SeekerService seekerService;

    public SeekerRestController(SeekerService seekerService) {
        this.seekerService = seekerService;
    }

    @GetMapping
    public ResponseEntity<List<Seeker>> getAllSeekers() {
        return ResponseEntity.ok(seekerService.getAllSeekers());
    }

    @PostMapping
    public ResponseEntity<Seeker> addSeeker(@RequestBody Seeker seeker) {
        Seeker createdSeeker = seekerService.addSeeker(seeker);
        return ResponseEntity.status(HttpStatus.CREATED).body(createdSeeker);
    }
}
