package com.drop.bloodbank.VanessaVictorino_COMP303A3_ABO.controllers;

import com.drop.bloodbank.VanessaVictorino_COMP303A3_ABO.entities.BloodStock;
import com.drop.bloodbank.VanessaVictorino_COMP303A3_ABO.services.BloodStockService;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;

import java.time.LocalDate;

@Controller
@RequestMapping("/bloodstocks")
public class BloodStockViewController {

    private final BloodStockService bloodStockService;

    public BloodStockViewController(BloodStockService bloodStockService) {
        this.bloodStockService = bloodStockService;
    }

    @GetMapping
    public String viewBloodStockPage(Model model) {
        model.addAttribute("bloodStocks", bloodStockService.getAllBloodStocks());
        return "bloodstocks";  // Maps to bloodstocks.html
    }

    @PostMapping("/add")
    public String addBloodStock(@RequestParam("bloodGroup") String bloodGroup,
                                @RequestParam("quantity") int quantity,
                                @RequestParam("bestBefore") String bestBefore,
                                @RequestParam("status") String status,
                                @RequestParam("city") String city) {
        BloodStock newBloodStock = new BloodStock();
        newBloodStock.setBloodGroup(bloodGroup);
        newBloodStock.setQuantity(quantity);
        newBloodStock.setBestBefore(LocalDate.parse(bestBefore));
        newBloodStock.setStatus(status);
        newBloodStock.setCity(city);

        bloodStockService.addBloodStock(newBloodStock);
        return "redirect:/bloodstocks";  // Refreshes the view
    }
}
