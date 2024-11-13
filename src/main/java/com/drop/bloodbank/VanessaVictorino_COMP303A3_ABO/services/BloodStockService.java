package com.drop.bloodbank.VanessaVictorino_COMP303A3_ABO.services;

import com.drop.bloodbank.VanessaVictorino_COMP303A3_ABO.entities.BloodStock;
import jakarta.annotation.PostConstruct;
import org.springframework.stereotype.Service;

import java.time.LocalDate;
import java.util.*;

@Service
public class BloodStockService {

    private final Map<Integer, BloodStock> bloodStocks = new HashMap<>();
    private int currentId = 1;  // ID auto-increment

    @PostConstruct
    public void initData() {
        // Sample data
        bloodStocks.put(currentId, new BloodStock(currentId++, "A+", 50, LocalDate.now().plusDays(30), "Available", "City Center"));
        bloodStocks.put(currentId, new BloodStock(currentId++, "O-", 30, LocalDate.now().plusDays(20), "Available", "Uptown"));
    }

    public List<BloodStock> getAllBloodStocks() {
        return new ArrayList<>(bloodStocks.values());
    }

    public BloodStock addBloodStock(BloodStock bloodStock) {
        bloodStock.setId(currentId++);
        bloodStocks.put(bloodStock.getId(), bloodStock);
        return bloodStock;
    }
    
    // Additional methods for update, delete, etc., if needed
}
