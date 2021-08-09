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
import org.springframework.web.servlet.ModelAndView;
import org.springframework.web.servlet.mvc.support.RedirectAttributes;

import mz.co.ldevz.entity.Bilhete;
import mz.co.ldevz.entity.Perfil;
import mz.co.ldevz.entity.Usuario;
import mz.co.ldevz.services.BilheteService;
import mz.co.ldevz.services.PerfilService;
import mz.co.ldevz.services.UserService;
import mz.co.ldevz.temp.CurrentUser;

@Controller
public class userController {

	private UserService userService;
	private PerfilService perfilService;
	private BilheteService service;
	

	@Autowired
	public userController(UserService userService, PerfilService perfilService, BilheteService service) {
		this.userService = userService;
		this.perfilService=perfilService;
		this.service=service;
		
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
	public String loginPage(ModelAndView modell, Model  model,Bilhete bilhete, RedirectAttributes attributes, Usuario usuario) {
		
		//modell.addObject("usuarios", userService.getLoggedUserId());
		Authentication auth = SecurityContextHolder.getContext().getAuthentication();
		System.out.println(auth.toString());
		
		if (!(auth instanceof AnonymousAuthenticationToken)) {
			service.salvar(bilhete);
			attributes.addFlashAttribute("mensagem", String.format("Bilhete da data %s cadastrado com sucesso", bilhete.getId()));
			return "redirect:/bilhetes";
		}
		
		
		model.addAttribute("newUser", new CurrentUser());
		return "/login";

	}

	
	@PostMapping("/processRegistration")
	public String processRegistrationForm(@Valid @ModelAttribute("newUser") CurrentUser currentUser,
			BindingResult theBindingResult, Model model, Perfil perfil) {

		
		if (userService.findUserByEmail(currentUser.getEmail()) != null) {
			model.addAttribute("newUser", new CurrentUser());
			model.addAttribute("registrationError", "Email already exists.");

			return "/login";
		}

	
		userService.saveUser(currentUser);
		perfilService.salvar(perfil);
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

		return "redirect:/?logout";
	}

}
