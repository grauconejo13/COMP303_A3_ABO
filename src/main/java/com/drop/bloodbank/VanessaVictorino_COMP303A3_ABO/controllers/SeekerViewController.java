package com.drop.bloodbank.VanessaVictorino_COMP303A3_ABO.controllers;

import com.drop.bloodbank.VanessaVictorino_COMP303A3_ABO.entities.Seeker;
import com.drop.bloodbank.VanessaVictorino_COMP303A3_ABO.services.SeekerService;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;

@Controller
@RequestMapping("/seekers")
public class SeekerViewController {

    private final SeekerService seekerService;

    public SeekerViewController(SeekerService seekerService) {
        this.seekerService = seekerService;
    }

    @GetMapping
    public String viewSeekerPage(Model model) {
        model.addAttribute("seekers", seekerService.getAllSeekers());
        return "seekers";  // Maps to seekers.html
    }

    @PostMapping("/add")
    public String addSeeker(@RequestParam("firstName") String firstName,
                            @RequestParam("lastName") String lastName,
                            @RequestParam("age") int age,
                            @RequestParam("bloodGroup") String bloodGroup,
                            @RequestParam("phone") String phone,
                            @RequestParam("email") String email) {
        Seeker newSeeker = new Seeker();
        newSeeker.setFirstName(firstName);
        newSeeker.setLastName(lastName);
        newSeeker.setAge(age);
        newSeeker.setBloodGroup(bloodGroup);
        newSeeker.setPhone(phone);
        newSeeker.setEmail(email);

        seekerService.addSeeker(newSeeker);
        return "redirect:/seekers";  // Refreshes the view
    }
}
