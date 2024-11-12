package com.drop.bloodbank.VanessaVictorino_COMP303A3_ABO.services;

import com.drop.bloodbank.VanessaVictorino_COMP303A3_ABO.entities.BloodStock;
import org.springframework.stereotype.Service;

import java.util.*;

@Service
public class BloodStockService {
    private final Map<Integer, BloodStock> bloodStocks = new HashMap<>();
    private int currentId = 1;  // To auto-increment BloodStock ID

    // Get all blood stock records
    public List<BloodStock> getAllBloodStocks() {
        return new ArrayList<>(bloodStocks.values());
    }

    // Get a blood stock record by ID
    public BloodStock getBloodStockById(int id) {
        return bloodStocks.get(id);
    }

    // Add new blood stock
    public BloodStock addBloodStock(BloodStock bloodStock) {
        bloodStock.setId(currentId++);
        bloodStocks.put(bloodStock.getId(), bloodStock);
        return bloodStock;
    }

    // Update an existing blood stock record
    public BloodStock updateBloodStock(int id, BloodStock bloodStock) {
        if (bloodStocks.containsKey(id)) {
            bloodStock.setId(id);
            bloodStocks.put(id, bloodStock);
            return bloodStock;
        }
        return null;  // Returns null if the blood stock is not found
    }

    // Delete a blood stock rec
