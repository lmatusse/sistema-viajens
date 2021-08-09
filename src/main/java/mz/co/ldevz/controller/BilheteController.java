package mz.co.ldevz.controller;


import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.servlet.ModelAndView;
import org.springframework.web.servlet.mvc.support.RedirectAttributes;

import mz.co.ldevz.entity.Bilhete;
import mz.co.ldevz.entity.Usuario;
import mz.co.ldevz.entity.Voo;
import mz.co.ldevz.services.BilheteService;
import mz.co.ldevz.services.UserService;
import mz.co.ldevz.services.UserServiceImpl;
import mz.co.ldevz.services.VooService;





@Controller
@RequestMapping("/bilhetes")
public class BilheteController 
{
	@Autowired
	private VooService vooService;
	@Autowired
	private BilheteService bilheteService;
	@Autowired
	private UserServiceImpl service;
	@GetMapping("/novo")
	public ModelAndView novo(Bilhete bilhete)
	{
		return new ModelAndView("bilhetes/cadastro").addObject("voos",vooService.listar());
	}
	/*@GetMapping("/novoo")
	public ModelAndView novoN(Bilhete bilhete)
	{
		ModelAndView modelAndView= new ModelAndView("bilhetes/usuaro");
		modelAndView.addObject("usuarios", service.listar());
		return modelAndView;
	}*/
	@PostMapping("/novo")
	public ModelAndView salvar(Bilhete bilhete, RedirectAttributes attributes, Usuario usuario)
	{
		
		bilheteService.salvar(bilhete);
		attributes.addFlashAttribute("mensagem", String.format("Bilhete da data %s cadastrado com sucesso", bilhete.getId()));
		return new ModelAndView("redirect:/bilhetes");
	}
	
	@GetMapping
	public ModelAndView listar()
	{
		return new ModelAndView("bilhetes/pesquisa").addObject("bilhetes", bilheteService.listar());
		
	}
	
	@GetMapping("/{codigo}")
	public ModelAndView editar(@PathVariable("codigo") Bilhete bilhete, RedirectAttributes attributes)
	{
		attributes.addFlashAttribute("bilhete", bilhete);
		return new ModelAndView("redirect:/bilhetes/novo");
	}

	@GetMapping("/remover/{codigo}")
	public ModelAndView remover(@PathVariable("codigo") Long codigo)
	{
		bilheteService.remove(codigo);
		return new ModelAndView("redirect:/bilhetes");
	}
	
	

}

