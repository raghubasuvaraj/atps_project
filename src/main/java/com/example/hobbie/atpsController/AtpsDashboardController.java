package com.example.hobbie.atpsController;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
@Controller

public class AtpsDashboardController {
	@GetMapping("/dashboard")
	public String Register() {
		
            return "atps_index/index";
        
}
}
