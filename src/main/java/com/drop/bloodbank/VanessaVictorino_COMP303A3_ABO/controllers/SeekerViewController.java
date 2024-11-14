package com.drop.bloodbank.VanessaVictorino_COMP303A3_ABO.controllers;

import com.drop.bloodbank.VanessaVictorino_COMP303A3_ABO.entities.Seeker;
import com.drop.bloodbank.VanessaVictorino_COMP303A3_ABO.services.SeekerService;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
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
    
    @GetMapping("/add")
    public String showAddSeekerForm(Model model) {
        model.addAttribute("seeker", new Seeker());
        return "seekers-add";  // Render the add seeker page
    }
    
    @GetMapping("/edit/{id}")
    public String editSeekerForm(@PathVariable int id, Model model) {
        Seeker seeker = seekerService.getSeekerById(id);
        if (seeker == null) {
            return "redirect:/seekers";  // Redirect to seekers list if the ID is not found
        }
        model.addAttribute("seeker", seeker);
        return "seekers-edit";  // This template should contain a form to edit seeker details
    }

    @PostMapping("/edit/{id}")
    public String updateSeeker(@PathVariable int id,
                               @RequestParam("firstName") String firstName,
                               @RequestParam("lastName") String lastName,
                               @RequestParam("age") int age,
                               @RequestParam("bloodGroup") String bloodGroup,
                               @RequestParam("phone") String phone,
                               @RequestParam("email") String email) {
        Seeker updatedSeeker = new Seeker(id, firstName, lastName, age, bloodGroup, phone, email);
        seekerService.updateSeeker(id, updatedSeeker);
        return "redirect:/seekers";
    }

    @GetMapping("/delete/{id}")
    public String deleteSeeker(@PathVariable int id) {
        seekerService.deleteSeeker(id);
        return "redirect:/seekers";
    }
}
