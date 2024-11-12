package com.drop.bloodbank.VanessaVictorino_COMP303A3_ABO.services;

import com.drop.bloodbank.VanessaVictorino_COMP303A3_ABO.entities.BloodBank;
import org.springframework.stereotype.Service;

import java.util.*;

@Service
public class BloodBankService {
    private final Map<Integer, BloodBank> bloodBanks = new HashMap<>();
    private int currentId = 1;  // To auto-increment BloodBank ID

    // Get all blood banks
    public List<BloodBank> getAllBloodBanks() {
        return new ArrayList<>(bloodBanks.values());
    }

    // Get a blood bank by ID
    public BloodBank getBloodBankById(int id) {
        return bloodBanks.get(id);
    }

    // Add a new blood bank
    public BloodBank addBloodBank(BloodBank bloodBank) {
        bloodBank.setId(currentId++);
        bloodBanks.put(bloodBank.getId(), bloodBank);
        return bloodBank;
    }

    // Update an existing blood bank
    public BloodBank updateBloodBank(int id, BloodBank bloodBank) {
        if (bloodBanks.containsKey(id)) {
            bloodBank.setId(id);
            bloodBanks.put(id, bloodBank);
            return bloodBank;
        }
        return null;  // Returns null if the blood bank is not found
    }

    // Delete a blood bank by ID
    public boolean deleteBloodBank(int id) {
        return bloodBanks.remove(id) != null;
    }
}
