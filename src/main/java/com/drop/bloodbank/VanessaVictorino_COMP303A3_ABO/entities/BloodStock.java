package com.drop.bloodbank.VanessaVictorino_COMP303A3_ABO.entities;

import java.time.LocalDate;

public class BloodStock {
    private int id;
    private String bloodGroup;
    private int quantity;
    private LocalDate bestBefore;
    private String status;
    private String city;

    // Constructors
    public BloodStock() {
    }

    public BloodStock(int id, String bloodGroup, int quantity, LocalDate bestBefore, String status, String city) {
        this.id = id;
        this.bloodGroup = bloodGroup;
        this.quantity = quantity;
        this.bestBefore = bestBefore;
        this.status = status;
        this.city = city;
    }

    // Getters and Setters
    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getBloodGroup() {
        return bloodGroup;
    }

    public void setBloodGroup(String bloodGroup) {
        this.bloodGroup = bloodGroup;
    }

    public int getQuantity() {
        return quantity;
    }

    public void setQuantity(int quantity) {
        this.quantity = quantity;
    }

    public LocalDate getBestBefore() {
        return bestBefore;
    }

    public void setBestBefore(LocalDate bestBefore) {
        this.bestBefore = bestBefore;
    }

    public String getStatus() {
        return status;
    }

    public void setStatus(String status) {
        this.status = status;
    }

    public String getCity() {
        return city;
    }

    public void setCity(String city) {
        this.city = city;
    }
}
