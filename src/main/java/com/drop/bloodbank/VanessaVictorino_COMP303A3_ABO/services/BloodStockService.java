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
   
    public BloodStock getBloodStockById(int id) {
        return bloodStocks.get(id); // Retrieves the blood bank by ID or returns null if not found
    }
    
    /**
     * Update an existing blood stock record by ID.
     * @param id The ID of the BloodStock to update.
     * @param bloodStock The updated BloodStock object.
     * @return The updated BloodStock object if found, otherwise null.
     */
    public BloodStock updateBloodStock(int id, BloodStock bloodStock) {
        if (bloodStocks.containsKey(id)) {
            bloodStock.setId(id);  // Preserve the ID
            bloodStocks.put(id, bloodStock);  // Update the record in the map
            return bloodStock;
        }
        return null;  // Return null if the blood stock entry is not found
    }

    /**
     * Delete a blood stock record by ID.
     * @param id The ID of the BloodStock to delete.
     * @return true if deletion was successful, false otherwise.
     */
    public boolean deleteBloodStock(int id) {
        return bloodStocks.remove(id) != null;
    }
}
