package com.example.hobbie.atpsController;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;

import com.example.hobbie.model.binding.AtpsSignupModel;
import com.example.hobbie.model.entities.enums.AtpsUserRoleEnum;
import com.example.hobbie.service.AtpsUserService;


import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;

@Controller
public class AtpsUserController {
	@Autowired
    private final AtpsUserService signupService;

    @Autowired
    public AtpsUserController(AtpsUserService signupService) {
        this.signupService = signupService;
    }

    @GetMapping("/atpstestregister")
    public String showSignupForm() {
        return "atps_signup/register"; // Replace "signup" with the name of your signup HTML template
    }

    @PostMapping("/register")
    public String processSignupForm(@ModelAttribute  AtpsSignupModel signupModel) {
    	//signupModel.setUserRole(AtpsUserRoleEnum.USER);
        signupService.saveAtpsSignup(signupModel);
        return "redirect:/atpstestlogin"; 
    }

    // Add other controller methods as needed
}


