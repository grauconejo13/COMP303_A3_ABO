package com.drop.bloodbank.VanessaVictorino_COMP303A3_ABO.controllers;

import com.drop.bloodbank.VanessaVictorino_COMP303A3_ABO.entities.BloodBank;
import com.drop.bloodbank.VanessaVictorino_COMP303A3_ABO.services.BloodBankService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/bloodbanks")
public class BloodBankController {

    @Autowired
    private BloodBankService bloodBankService;

    // GET all blood banks
    @GetMapping
    public List<BloodBank> getAllBloodBanks() {
        return bloodBankService.getAllBloodBanks();
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
