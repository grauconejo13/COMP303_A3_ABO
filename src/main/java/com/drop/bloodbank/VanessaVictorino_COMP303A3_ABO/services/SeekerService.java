package com.drop.bloodbank.VanessaVictorino_COMP303A3_ABO.services;

import com.drop.bloodbank.VanessaVictorino_COMP303A3_ABO.entities.Seeker;

import jakarta.annotation.PostConstruct;

import org.springframework.stereotype.Service;

import java.util.*;

@Service
public class SeekerService {
    private final Map<Integer, Seeker> seekers = new HashMap<>();
    private int currentId = 1;  // To auto-increment Seeker ID

    @PostConstruct
    public void initData() {
        // Add sample data
        seekers.put(currentId, new Seeker(currentId++, "John", "Doe", 30, "A+", "123-456-7890", "john.doe@example.com"));
        seekers.put(currentId, new Seeker(currentId++, "Jane", "Smith", 25, "O-", "987-654-3210", "jane.smith@example.com"));
    }

    public List<Seeker> getAllSeekers() {
        return new ArrayList<>(seekers.values());
    }

    // Get a seeker by ID
    public Seeker getSeekerById(int id) {
        return seekers.get(id);
    }

    // Add a new seeker
    public Seeker addSeeker(Seeker seeker) {
        seeker.setId(currentId++);
        seekers.put(seeker.getId(), seeker);
        return seeker;
    }

    // Update an existing seeker
    public Seeker updateSeeker(int id, Seeker seeker) {
        if (seekers.containsKey(id)) {
            seeker.setId(id);
            seekers.put(id, seeker);
            return seeker;
        }
        return null;  // Returns null if the seeker is not found
    }

    // Delete a seeker by ID
    public boolean deleteSeeker(int id) {
        return seekers.remove(id) != null;
    }
}
