package com.example.hobbie.atpsController;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;

import com.example.hobbie.config.UserInterceptor;
import com.example.hobbie.model.binding.TestBindingModel;

@Controller
public class AtpsTestController {


    @GetMapping("/atpstestlogin")
    public String showTest(Model model) {
        if (UserInterceptor.isUserLogged()) {
            if (!model.containsAttribute("testBindingModel")) {
                model.addAttribute("testBindingModel", new TestBindingModel());
            }
            return "atps_login/login";
        } else {
            return "atps_login/login";
        }
    }
    

}
