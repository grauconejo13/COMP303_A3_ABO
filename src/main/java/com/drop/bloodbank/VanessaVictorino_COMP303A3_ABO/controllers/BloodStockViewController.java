package com.drop.bloodbank.VanessaVictorino_COMP303A3_ABO.controllers;

import com.drop.bloodbank.VanessaVictorino_COMP303A3_ABO.entities.BloodStock;
import com.drop.bloodbank.VanessaVictorino_COMP303A3_ABO.services.BloodStockService;

import java.time.LocalDate;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;

@Controller
@RequestMapping("/bloodstocks")
public class BloodStockViewController {
	
    private final BloodStockService bloodStockService;

    
    public BloodStockViewController(BloodStockService bloodStockService) {
        this.bloodStockService = bloodStockService;
    }

    // GET method to show blood stock list
    @GetMapping
    public String viewBloodStockPage(Model model) {
        model.addAttribute("bloodstocks", bloodStockService.getAllBloodStocks());
        return "bloodstocks"; // Should match bloodstock.html template
    }
    
 // POST method to add a new blood stock entry
    @PostMapping("/add")
    public String addBloodStock(@RequestParam("bloodGroup") String bloodGroup,
                                @RequestParam("quantity") int quantity,
                                @RequestParam("bestBefore") String bestBefore,  // Date in 'yyyy-MM-dd' format
                                @RequestParam("status") String status,
                                @RequestParam("city") String city) {
        // Parse the bestBefore date
        LocalDate parsedBestBefore = LocalDate.parse(bestBefore);
        
        // Create a new BloodStock entry
        BloodStock newStock = new BloodStock();
        newStock.setBloodGroup(bloodGroup);
        newStock.setQuantity(quantity);
        newStock.setBestBefore(parsedBestBefore);
        newStock.setStatus(status);
        newStock.setCity(city);

        // Save the new stock entry using the service
        bloodStockService.addBloodStock(newStock);

        // Redirect back to the blood stock list page
        return "redirect:/bloodstocks";
    }
}
