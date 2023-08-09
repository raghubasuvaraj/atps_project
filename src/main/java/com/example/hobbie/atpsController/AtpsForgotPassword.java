package com.example.hobbie.atpsController;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
@Controller
public class AtpsForgotPassword {
	
	@GetMapping("/atpsPassword")
	public String Register() {
		
            return "atps_forgotpassword/forgotpassword";
        
    }
	}
		

