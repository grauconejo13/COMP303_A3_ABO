package com.drop.bloodbank.VanessaVictorino_COMP303A3_ABO.controllers;

import com.drop.bloodbank.VanessaVictorino_COMP303A3_ABO.entities.Seeker;
import com.drop.bloodbank.VanessaVictorino_COMP303A3_ABO.services.SeekerService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@Controller
@RequestMapping("/")  // Base path for HTML views related to Seeker
public class SeekerViewController {

    @Autowired
    private SeekerService seekerService;

    @GetMapping("/simple")
    public String testTemplate() {
        return "simple";  // This should load test.html
    }
    
    @GetMapping("/seekers")
    public String viewSeekerPage() {
        return "seekers";  // This should load test.html
    }
    
    // Display a list of all seekers
    @GetMapping
    public String showSeekerList(Model model) {
        List<Seeker> seekers = seekerService.getAllSeekers();
        model.addAttribute("seekers", seekers);
        return "seekers";  // This should match the template name (seekers.html)
    }

    // Display a form for adding a new seeker
    @GetMapping("/new")
    public String showAddSeekerForm(Model model) {
        model.addAttribute("seeker", new Seeker());
        return "seeker-form";  // This should match the template name for the form (seeker-form.html)
    }

    // Handle form submission for creating a new seeker
    @PostMapping
    public String addSeeker(@ModelAttribute Seeker seeker) {
        seekerService.addSeeker(seeker);
        return "redirect:/seekers";  // Redirects to the seekers list page
    }

    // Display a form for editing an existing seeker
    @GetMapping("/edit/{id}")
    public String showEditSeekerForm(@PathVariable int id, Model model) {
        Seeker seeker = seekerService.getSeekerById(id);
        if (seeker != null) {
            model.addAttribute("seeker", seeker);
            return "seeker-form";  // Use the same form template for editing
        } else {
            return "redirect:/seekers";  // Redirect if the seeker is not found
        }
    }

    // Handle form submission for updating an existing seeker
    @PostMapping("/update/{id}")
    public String updateSeeker(@PathVariable int id, @ModelAttribute Seeker seeker) {
        seekerService.updateSeeker(id, seeker);
        return "redirect:/seekers";  // Redirects to the seekers list page
    }

    // Handle deleting a seeker
    @GetMapping("/delete/{id}")
    public String deleteSeeker(@PathVariable int id) {
        seekerService.deleteSeeker(id);
        return "redirect:/seekers";  // Redirects to the seekers list page
    }
}
