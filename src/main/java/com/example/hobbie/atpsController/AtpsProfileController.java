package com.example.hobbie.atpsController;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
@Controller

public class AtpsProfileController {
	@GetMapping("/profile")
	public String Register() {
		
            return "atps_index/profile";
        

}
}
