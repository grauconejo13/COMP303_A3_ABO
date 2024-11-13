package com.drop.bloodbank.VanessaVictorino_COMP303A3_ABO.controllers;

import com.drop.bloodbank.VanessaVictorino_COMP303A3_ABO.entities.BloodStock;
import com.drop.bloodbank.VanessaVictorino_COMP303A3_ABO.services.BloodStockService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api/bloodstocks")
public class BloodStockRestController {

    @Autowired
    private BloodStockService bloodStockService;
    
    // GET all blood stocks
    @GetMapping
    public List<BloodStock> getAllBloodStocks() {
        return bloodStockService.getAllBloodStocks();
    }

    // GET a blood stock by ID
    @GetMapping("/{id}")
    public ResponseEntity<BloodStock> getBloodStockById(@PathVariable int id) {
        BloodStock bloodStock = bloodStockService.getBloodStockById(id);
        return bloodStock != null ? ResponseEntity.ok(bloodStock) : ResponseEntity.notFound().build();
    }

    // POST a new blood stock record
    @PostMapping
    public ResponseEntity<BloodStock> addBloodStock(@RequestBody BloodStock bloodStock) {
        BloodStock createdBloodStock = bloodStockService.addBloodStock(bloodStock);
        return ResponseEntity.status(HttpStatus.CREATED).body(createdBloodStock);
    }

    // PUT (update) a blood stock record by ID
    @PutMapping("/{id}")
    public ResponseEntity<BloodStock> updateBloodStock(@PathVariable int id, @RequestBody BloodStock bloodStock) {
        BloodStock updatedBloodStock = bloodStockService.updateBloodStock(id, bloodStock);
        return updatedBloodStock != null ? ResponseEntity.ok(updatedBloodStock) : ResponseEntity.notFound().build();
    }

    // DELETE a blood stock record by ID
    @DeleteMapping("/{id}")
    public ResponseEntity<Void> deleteBloodStock(@PathVariable int id) {
        boolean isDeleted = bloodStockService.deleteBloodStock(id);
        return isDeleted ? ResponseEntity.noContent().build() : ResponseEntity.notFound().build();
    }
}
