package com.drop.bloodbank.VanessaVictorino_COMP303A3_ABO.controllers;

import com.drop.bloodbank.VanessaVictorino_COMP303A3_ABO.entities.BloodBank;
import com.drop.bloodbank.VanessaVictorino_COMP303A3_ABO.services.BloodBankService;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;

@Controller
@RequestMapping("/bloodbanks")
public class BloodBankViewController {

    private final BloodBankService bloodBankService;

    public BloodBankViewController(BloodBankService bloodBankService) {
        this.bloodBankService = bloodBankService;
    }

    // GET method to show the blood bank list
    @GetMapping
    public String viewBloodBankPage(Model model) {
        model.addAttribute("bloodbanks", bloodBankService.getAllBloodBanks());
        return "bloodbanks";  // Renders the bloodbank.html template
    }
    
    // POST method to add a new blood bank
    @PostMapping("/add")
    public String addBloodBank(@RequestParam("name") String name,
                               @RequestParam("address") String address,
                               @RequestParam("city") String city,
                               @RequestParam("phone") String phone) {
        // Create a new BloodBank entity
        BloodBank newBloodBank = new BloodBank();
        newBloodBank.setName(name);
        newBloodBank.setAddress(address);
        newBloodBank.setCity(city);
        newBloodBank.setPhone(phone);

        // Save the new blood bank using the service
        bloodBankService.addBloodBank(newBloodBank);

        // Redirect back to the blood bank list page
        return "redirect:/bloodbanks";
    }
}
