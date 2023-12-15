package com.artur.assignment.controllers.patternControllers;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;

@Controller
@RequestMapping("/chain")
public class LoginChainController {

	@GetMapping("/checkpass")
	public String checkPassword() {
		return "chain/insertPassword";
	}
}
