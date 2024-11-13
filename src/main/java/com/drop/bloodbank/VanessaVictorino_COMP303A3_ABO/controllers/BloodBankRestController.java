package com.drop.bloodbank.VanessaVictorino_COMP303A3_ABO.controllers;

import com.drop.bloodbank.VanessaVictorino_COMP303A3_ABO.entities.BloodBank;
import com.drop.bloodbank.VanessaVictorino_COMP303A3_ABO.services.BloodBankService;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api/bloodbanks")
public class BloodBankRestController {

    private final BloodBankService bloodBankService;

    // Constructor-based injection is preferred for better testing and immutability
    public BloodBankRestController(BloodBankService bloodBankService) {
        this.bloodBankService = bloodBankService;
    }

    // GET all blood banks
    @GetMapping
    public ResponseEntity<List<BloodBank>> getAllBloodBanks() {
        List<BloodBank> bloodBanks = bloodBankService.getAllBloodBanks();
        return ResponseEntity.ok(bloodBanks);
    }

    // GET a blood bank by ID
    @GetMapping("/{id}")
    public ResponseEntity<BloodBank> getBloodBankById(@PathVariable int id) {
        BloodBank bloodBank = bloodBankService.getBloodBankById(id);
        return bloodBank != null ? ResponseEntity.ok(bloodBank) : ResponseEntity.notFound().build();
    }

    // POST a new blood bank
    @PostMapping
    public ResponseEntity<BloodBank> addBloodBank(@RequestBody BloodBank bloodBank) {
        BloodBank createdBloodBank = bloodBankService.addBloodBank(bloodBank);
        return ResponseEntity.status(HttpStatus.CREATED).body(createdBloodBank);
    }

    // PUT (update) a blood bank by ID
    @PutMapping("/{id}")
    public ResponseEntity<BloodBank> updateBloodBank(@PathVariable int id, @RequestBody BloodBank bloodBank) {
        BloodBank updatedBloodBank = bloodBankService.updateBloodBank(id, bloodBank);
        return updatedBloodBank != null ? ResponseEntity.ok(updatedBloodBank) : ResponseEntity.notFound().build();
    }

    // DELETE a blood bank by ID
    @DeleteMapping("/{id}")
    public ResponseEntity<Void> deleteBloodBank(@PathVariable int id) {
        boolean isDeleted = bloodBankService.deleteBloodBank(id);
        return isDeleted ? ResponseEntity.noContent().build() : ResponseEntity.notFound().build();
    }
}
