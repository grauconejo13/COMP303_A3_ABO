package com.drop.bloodbank.VanessaVictorino_COMP303A3_ABO.controllers;

import com.drop.bloodbank.VanessaVictorino_COMP303A3_ABO.entities.BloodBank;
import com.drop.bloodbank.VanessaVictorino_COMP303A3_ABO.entities.BloodStock;
import com.drop.bloodbank.VanessaVictorino_COMP303A3_ABO.services.BloodStockService;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;

import java.time.LocalDate;
import java.time.format.DateTimeParseException;

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

    @GetMapping("/add")
    public String showAddSeekerForm(Model model) {
        model.addAttribute("bloodstocks", new BloodStock());
        return "bloodstocks-add";  // Render the add bloodstocks page
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
    
 // GET method to show the form for editing a BloodBank
    @GetMapping("/edit/{id}")
    public String editBloodStockForm(@PathVariable int id, Model model) {
        BloodStock bloodStock = bloodStockService.getBloodStockById(id);
        if (bloodStock == null) {
            return "redirect:/bloodstocks"; // Redirect if blood bank not found
        }
        model.addAttribute("bloodStock", bloodStock);
        return "bloodstocks-edit";  // Render the bloodstocks-edit.html form
    }
    
    @PostMapping("/edit/{id}")
    public String updateBloodStock(@PathVariable int id,
                                   @RequestParam("bloodGroup") String bloodGroup,
                                   @RequestParam("quantity") int quantity,
                                   @RequestParam("bestBefore") String bestBefore,
                                   @RequestParam("status") String status,
                                   @RequestParam("city") String city) {
	  LocalDate parsedBestBefore;
	    try {
	        parsedBestBefore = LocalDate.parse(bestBefore);  // Parse the date from the string
	    } catch (DateTimeParseException e) {
	        // Handle parsing error (e.g., return an error page or redirect with error)
	        return "redirect:/bloodstocks?error=invalidDate";
	    }
        BloodStock updatedBloodStock = new BloodStock(id, bloodGroup, quantity, parsedBestBefore, status, city);
        bloodStockService.updateBloodStock(id, updatedBloodStock);
        return "redirect:/bloodstocks";
    }

    @GetMapping("/delete/{id}")
    public String deleteBloodStock(@PathVariable int id) {
        bloodStockService.deleteBloodStock(id);
        return "redirect:/bloodstocks";
    }
}
