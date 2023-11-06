package com.artur.assignment.controllers;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;

import com.artur.assignment.model.UserP;
import com.artur.assignment.service.UserService;

@Controller
@RequestMapping("/users")
public class UserPController {
	private final UserService uService;

	@Autowired
	public UserPController(UserService uService) {
		this.uService = uService;
	}
	
	@GetMapping("/all")
	public String index(Model model) {
		model.addAttribute("users", uService.findAll());
		return ("/users/all");
	}
	
	@GetMapping("/{id}")
	public String getUser(@PathVariable("id") int id, Model model) {
		model.addAttribute("user", uService.getUser(id));
		return ("/users/profile");
	}
	
	@GetMapping("/new")
	public String newUSer(@ModelAttribute("user") UserP userP) {
		return ("/users/new");
	}
	
	@PostMapping("/create")
	public String createNewUser(@ModelAttribute("user") UserP userP, BindingResult bindingResult) {
		if(bindingResult.hasErrors()) {
			return "/users/new";
		}
		uService.save(userP);
		return "/users/all";
	}
	
	@GetMapping("/{id}/edit")
	public String edit(Model model, @PathVariable("id") int id){
		model.addAttribute("user", uService.getUser(id));
		return "/users/edit";
	}
	
	@PostMapping("/{id}/update")
	public String update(@ModelAttribute("userP") UserP userP, BindingResult bindingResult,
						@PathVariable("id") int id){
		if(bindingResult.hasErrors())
			System.out.println("Error");
		
		uService.update(id, userP);
		return "/users/all";
	}
	
	@PostMapping("/{id}/delete")
	public String deltete(@PathVariable("id") int id) {
		uService.delete(id);
		return "/users/all";
	}
	
	
	
	
}
