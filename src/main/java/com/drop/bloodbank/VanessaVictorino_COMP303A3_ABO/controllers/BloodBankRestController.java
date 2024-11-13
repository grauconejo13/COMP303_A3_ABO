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

    public BloodBankRestController(BloodBankService bloodBankService) {
        this.bloodBankService = bloodBankService;
    }

    @GetMapping
    public ResponseEntity<List<BloodBank>> getAllBloodBanks() {
        return ResponseEntity.ok(bloodBankService.getAllBloodBanks());
    }

    @PostMapping
    public ResponseEntity<BloodBank> addBloodBank(@RequestBody BloodBank bloodBank) {
        BloodBank createdBloodBank = bloodBankService.addBloodBank(bloodBank);
        return ResponseEntity.status(HttpStatus.CREATED).body(createdBloodBank);
    }
    
    // Additional methods for update and delete could go here
}
