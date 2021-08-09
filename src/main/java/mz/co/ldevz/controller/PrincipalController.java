package mz.co.ldevz.controller;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.servlet.ModelAndView;

@Controller
@RequestMapping("/principal")
public class PrincipalController 
{
	@GetMapping
	public ModelAndView getIndex()
	{
		return new ModelAndView("principal");
	}
}

