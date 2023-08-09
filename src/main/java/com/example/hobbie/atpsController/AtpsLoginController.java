package com.example.hobbie.atpsController;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.servlet.view.RedirectView;

import com.example.hobbie.handler.InvalidCredentialsException;
import com.example.hobbie.model.binding.AtpsLoginModel;
import com.example.hobbie.service.AtpsLoginService;
@Controller
public class AtpsLoginController {
@Autowired
    private final AtpsLoginService atpsLoginService;

    @Autowired
    public AtpsLoginController(AtpsLoginService atpsLoginService) {
        this.atpsLoginService = atpsLoginService;
    }

    @GetMapping("/atpstestlogin")
    public String showAllLogins(Model model) {
        List<AtpsLoginModel> loginModels = atpsLoginService.getAll();
        model.addAttribute("logins", loginModels);
        return "atps_login/login"; // Return the view name for listing logins (e.g., login-list.html)
    }

    @GetMapping("/atpstestlogin{username}")
    public String showLoginByUsername(@PathVariable String username, Model model) {
        AtpsLoginModel loginModel = atpsLoginService.getByUsername(username);
        model.addAttribute("login", loginModel);
        return "redirect:/dashboard"; // Return the view name for showing login details (e.g., login-details.html)
    }

    @GetMapping("/create")
    public String showCreateForm(Model model) {
        model.addAttribute("login", new AtpsLoginModel());
        return "/dashboard"; // Return the view name for the create form (e.g., login-form.html)
    }

    @PostMapping("/login")
    public String submitLoginForm(@ModelAttribute("login") AtpsLoginModel loginModel, Model model) {
        try {
            atpsLoginService.validateLogin(loginModel.getUsername(), loginModel.getPassword());
            atpsLoginService.save(loginModel);
           
            return "redirect:/dashboard";
        } catch (InvalidCredentialsException e) {
            // Login failed
            model.addAttribute("error", e.getMessage());
            return "redirect:/atpstestregister"; // Return the login form with the error message
        }
    }
  

   
}


