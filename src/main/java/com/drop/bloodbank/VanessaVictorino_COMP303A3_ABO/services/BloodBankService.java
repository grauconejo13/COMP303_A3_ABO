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
    
    // Additional methods for update, delete, etc. if needed
}
