package com.drop.bloodbank.VanessaVictorino_COMP303A3_ABO.services;

import com.drop.bloodbank.VanessaVictorino_COMP303A3_ABO.entities.BloodBank;
import jakarta.annotation.PostConstruct;
import org.springframework.stereotype.Service;

import java.util.*;

@Service
public class BloodBankService {

    private final Map<Integer, BloodBank> bloodBanks = new HashMap<>();
    private int currentId = 1;  // Auto-increment ID for new blood banks

    @PostConstruct
    public void initData() {
        // Sample blood bank data
        bloodBanks.put(currentId, new BloodBank(currentId++, "Central Blood Bank", "123 Main St", "City Center", "123-456-7890"));
        bloodBanks.put(currentId, new BloodBank(currentId++, "City Blood Center", "456 Elm St", "Uptown", "098-765-4321"));
        
    }

    public List<BloodBank> getAllBloodBanks() {
        return new ArrayList<>(bloodBanks.values());
    }

    public BloodBank addBloodBank(BloodBank bloodBank) {
        bloodBank.setId(currentId++);
        bloodBanks.put(bloodBank.getId(), bloodBank);
        return bloodBank;
    }
    
    /**
     * Update an existing blood bank by ID.
     * @param id The ID of the BloodBank to update.
     * @param bloodBank The updated BloodBank object.
     * @return The updated BloodBank object if found, otherwise null.
     */
    public BloodBank updateBloodBank(int id, BloodBank bloodBank) {
        if (bloodBanks.containsKey(id)) {
            bloodBank.setId(id);  // Preserve the original ID
            bloodBanks.put(id, bloodBank);  // Update the record in the map
            return bloodBank;
        }
        return null;  // Return null if the blood bank entry is not found
    }

    /**
     * Delete a blood bank by ID.
     * @param id The ID of the BloodBank to delete.
     * @return true if deletion was successful, false otherwise.
     */
    public boolean deleteBloodBank(int id) {
        return bloodBanks.remove(id) != null;
    }
}
