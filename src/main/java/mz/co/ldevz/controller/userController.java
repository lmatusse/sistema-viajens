package mz.co.ldevz.controller;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.validation.Valid;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.propertyeditors.StringTrimmerEditor;
import org.springframework.security.authentication.AnonymousAuthenticationToken;
import org.springframework.security.core.Authentication;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.security.web.authentication.logout.SecurityContextLogoutHandler;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.WebDataBinder;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.InitBinder;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import mz.co.ldevz.services.UserService;
import mz.co.ldevz.temp.CurrentUser;

@Controller
public class userController {

	private UserService userService;

	
	@Autowired
	public userController(UserService userService) {
		this.userService = userService;
		
	}

	
	@InitBinder
	public void initBinder(WebDataBinder dataBinder) {
		StringTrimmerEditor stringTrimmerEditor = new StringTrimmerEditor(true);
		dataBinder.registerCustomEditor(String.class, stringTrimmerEditor);
	}

	
	@RequestMapping("/")
	public String homePage() {

		return "index";
	}

	
	@GetMapping("/login")
	public String loginPage(Model model) {

		
		Authentication auth = SecurityContextHolder.getContext().getAuthentication();
		if (!(auth instanceof AnonymousAuthenticationToken)) {
			return "redirect:/";
		}
		
		
		model.addAttribute("newUser", new CurrentUser());

		return "/login";
	}

	
	@PostMapping("/processRegistration")
	public String processRegistrationForm(@Valid @ModelAttribute("newUser") CurrentUser currentUser,
			BindingResult theBindingResult, Model model) {

		
		if (userService.findUserByEmail(currentUser.getEmail()) != null) {
			model.addAttribute("newUser", new CurrentUser());
			model.addAttribute("registrationError", "Email already exists.");

			return "/login";
		}

	
		userService.saveUser(currentUser);
		model.addAttribute("registrationSuccess", "registration Success.");

		return "redirect:/login";

	}

	
	

	
	

	
	
	
	
	
	// log out
	@RequestMapping(value = "/logout", method = RequestMethod.GET)
	public String logoutPage(HttpServletRequest request, HttpServletResponse response) {
		
		// handle logout for logged user  
		Authentication auth = SecurityContextHolder.getContext().getAuthentication();
		if (auth != null) {
			new SecurityContextLogoutHandler().logout(request, response, auth);
		}

		return "redirect:/login-form-page?logout";
	}

}
