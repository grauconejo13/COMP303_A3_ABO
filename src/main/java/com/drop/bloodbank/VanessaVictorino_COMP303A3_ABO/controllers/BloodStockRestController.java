package com.drop.bloodbank.VanessaVictorino_COMP303A3_ABO.controllers;

import com.drop.bloodbank.VanessaVictorino_COMP303A3_ABO.entities.BloodStock;
import com.drop.bloodbank.VanessaVictorino_COMP303A3_ABO.services.BloodStockService;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api/bloodstocks")
public class BloodStockRestController {

    private final BloodStockService bloodStockService;

    public BloodStockRestController(BloodStockService bloodStockService) {
        this.bloodStockService = bloodStockService;
    }

    @GetMapping
    public ResponseEntity<List<BloodStock>> getAllBloodStocks() {
        return ResponseEntity.ok(bloodStockService.getAllBloodStocks());
    }

    @PostMapping
    public ResponseEntity<BloodStock> addBloodStock(@RequestBody BloodStock bloodStock) {
        BloodStock createdBloodStock = bloodStockService.addBloodStock(bloodStock);
        return ResponseEntity.status(HttpStatus.CREATED).body(createdBloodStock);
    }
}
