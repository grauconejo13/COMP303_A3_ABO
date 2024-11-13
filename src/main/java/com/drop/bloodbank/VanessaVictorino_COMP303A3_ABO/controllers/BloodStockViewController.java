package com.drop.bloodbank.VanessaVictorino_COMP303A3_ABO.controllers;

import com.drop.bloodbank.VanessaVictorino_COMP303A3_ABO.services.BloodStockService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;

@Controller
@RequestMapping("/bloodstocks")
public class BloodStockViewController {

    @Autowired
    private BloodStockService bloodStockService;

    // Handles GET requests to "/bloodstocks"
    @GetMapping
    public String viewBloodStockPage(Model model) {
        model.addAttribute("bloodstocks", bloodStockService.getAllBloodStocks());
        return "bloodstocks";  // Maps to bloodstocks.html template in src/main/resources/templates
    }
}
