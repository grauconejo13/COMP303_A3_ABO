package com.drop.bloodbank.VanessaVictorino_COMP303A3_ABO.services;

import com.drop.bloodbank.VanessaVictorino_COMP303A3_ABO.entities.BloodStock;
import jakarta.annotation.PostConstruct;
import org.springframework.stereotype.Service;

import java.time.LocalDate;
import java.util.*;

@Service
public class BloodStockService {

    private final Map<Integer, BloodStock> bloodStocks = new HashMap<>();  // In-memory storage for blood stocks
    private int currentId = 1;  // Auto-increment ID for each new blood stock entry

    // Initialize with sample blood stock data
    @PostConstruct
    public void initData() {
    	  bloodStocks.put(currentId, new BloodStock(currentId++, "A+", 50, LocalDate.now().plusMonths(1), "Available", "New York"));
          bloodStocks.put(currentId, new BloodStock(currentId++, "O-", 30, LocalDate.now().plusMonths(2), "Available", "Los Angeles"));
          bloodStocks.put(currentId, new BloodStock(currentId++, "B+", 20, LocalDate.now().plusWeeks(3), "Low Stock", "Chicago"));
    }

    /**
     * Get all blood stock records.
     * @return List of all BloodStock records.
     */
    public List<BloodStock> getAllBloodStocks() {
        return new ArrayList<>(bloodStocks.values());
    }

    /**
     * Get a blood stock record by ID.
     * @param id ID of the BloodStock to retrieve.
     * @return The BloodStock object if found, otherwise null.
     */
    public BloodStock getBloodStockById(int id) {
        return bloodStocks.get(id);
    }

    /**
     * Add a new blood stock record.
     * @param bloodStock The BloodStock object to add.
     * @return The newly added BloodStock object.
     */
    public BloodStock addBloodStock(BloodStock bloodStock) {
        bloodStock.setId(currentId++);
        bloodStocks.put(bloodStock.getId(), bloodStock);
        return bloodStock;
    }

    /**
     * Update an existing blood stock record.
     * @param id The ID of the BloodStock record to update.
     * @param bloodStock The updated BloodStock object.
     * @return The updated BloodStock object, or null if not found.
     */
    public BloodStock updateBloodStock(int id, BloodStock bloodStock) {
        if (bloodStocks.containsKey(id)) {
            bloodStock.setId(id);
            bloodStocks.put(id, bloodStock);
            return bloodStock;
        }
        return null;  // Return null if the blood stock is not found
    }

    /**
     * Delete a blood stock record by ID.
     * @param id The ID of the BloodStock record to delete.
     * @return true if deletion was successful, false otherwise.
     */
    public boolean deleteBloodStock(int id) {
        return bloodStocks.remove(id) != null;
    }

    /**
     * Find all blood stock records for a specific blood group.
     * @param bloodGroup The blood group to filter by.
     * @return List of BloodStock records matching the specified blood group.
     */
    public List<BloodStock> findByBloodGroup(String bloodGroup) {
        List<BloodStock> result = new ArrayList<>();
        for (BloodStock stock : bloodStocks.values()) {
            if (stock.getBloodGroup().equalsIgnoreCase(bloodGroup)) {
                result.add(stock);
            }
        }
        return result;
    }

    /**
     * Check the availability of a specific blood group.
     * @param bloodGroup The blood group to check.
     * @param minimumQuantity The minimum quantity required.
     * @return true if the blood group is available in the specified quantity, false otherwise.
     */
    public boolean isBloodGroupAvailable(String bloodGroup, int minimumQuantity) {
        return bloodStocks.values().stream()
                .anyMatch(stock -> stock.getBloodGroup().equalsIgnoreCase(bloodGroup) && stock.getQuantity() >= minimumQuantity);
    }
}
