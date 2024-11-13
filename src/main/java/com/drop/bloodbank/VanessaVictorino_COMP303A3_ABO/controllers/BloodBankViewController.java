package com.drop.bloodbank.VanessaVictorino_COMP303A3_ABO.controllers;

import com.drop.bloodbank.VanessaVictorino_COMP303A3_ABO.services.BloodBankService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;

@Controller
@RequestMapping("/bloodbanks")
public class BloodBankViewController {

    @Autowired
    private BloodBankService bloodBankService;

    // Handles GET requests to "/bloodbanks"
    @GetMapping
    public String viewBloodBankPage(Model model) {
        model.addAttribute("bloodbanks", bloodBankService.getAllBloodBanks());
        return "bloodbanks";  // Maps to bloodbanks.html template in src/main/resources/templates
    }
}
