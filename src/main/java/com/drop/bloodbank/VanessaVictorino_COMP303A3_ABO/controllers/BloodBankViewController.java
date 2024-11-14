package com.drop.bloodbank.VanessaVictorino_COMP303A3_ABO.controllers;

import com.drop.bloodbank.VanessaVictorino_COMP303A3_ABO.entities.BloodBank;
import com.drop.bloodbank.VanessaVictorino_COMP303A3_ABO.services.BloodBankService;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
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

    @GetMapping
    public String viewBloodBankPage(Model model) {
        model.addAttribute("bloodBanks", bloodBankService.getAllBloodBanks());
        return "bloodbanks";  // Renders the bloodbanks.html template
    }

    @PostMapping("/add")
    public String addBloodBank(@RequestParam("name") String name,
                               @RequestParam("address") String address,
                               @RequestParam("city") String city,
                               @RequestParam("phone") String phone) {
        BloodBank newBloodBank = new BloodBank();
        newBloodBank.setName(name);
        newBloodBank.setAddress(address);
        newBloodBank.setCity(city);
        newBloodBank.setPhone(phone);

        bloodBankService.addBloodBank(newBloodBank);

        return "redirect:/bloodbanks";  // Redirects to GET /bloodbanks to refresh the data
    }
    
    @GetMapping("/add")
    public String showAddSeekerForm(Model model) {
        model.addAttribute("bloodbanks", new BloodBank());
        return "bloodbanks-add";  // Render the add bloodbanks page
    }
    
    @PostMapping("/edit/{id}")
    public String updateBloodBank(@PathVariable int id,
                                  @RequestParam("name") String name,
                                  @RequestParam("address") String address,
                                  @RequestParam("city") String city,
                                  @RequestParam("phone") String phone) {
        BloodBank updatedBloodBank = new BloodBank(id, name, address, city, phone);
        bloodBankService.updateBloodBank(id, updatedBloodBank);
        return "redirect:/bloodbanks";
    }

    @GetMapping("/delete/{id}")
    public String deleteBloodBank(@PathVariable int id) {
        bloodBankService.deleteBloodBank(id);
        return "redirect:/bloodbanks";
    }
}
