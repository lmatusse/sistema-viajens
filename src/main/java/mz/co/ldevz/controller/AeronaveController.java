package mz.co.ldevz.controller;


import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.servlet.ModelAndView;
import org.springframework.web.servlet.mvc.support.RedirectAttributes;

import mz.co.ldevz.entity.Aeronave;
import mz.co.ldevz.services.AeronaveService;
import mz.co.ldevz.services.CompanhiaAereaService;





@Controller
@RequestMapping("/aeronaves")
public class AeronaveController 
{
	@Autowired
	private AeronaveService aeronaveService;
	@Autowired
	private CompanhiaAereaService companhiaAereaService;
	
	@GetMapping("/novo")
	public ModelAndView novo(Aeronave aeronave)
	{
		return new ModelAndView("aeronaves/cadastro").addObject("companhiaAereas",companhiaAereaService.listar());
	}
	
	@PostMapping("/novo")
	public ModelAndView salvar(Aeronave aeronave, RedirectAttributes attributes)
	{
		aeronaveService.salvar(aeronave);
		attributes.addFlashAttribute("mensagem", String.format("Aeronave de nome %s cadastrado com sucesso", aeronave.getReferencia()));
		return new ModelAndView("redirect:/aeronaves/novo");
	}
	
	@GetMapping
	public ModelAndView listar()
	{
		return new ModelAndView("aeronaves/pesquisa").addObject("aeronaves", aeronaveService.listar());
		
	}
	
	@GetMapping("/{codigo}")
	public ModelAndView editar(@PathVariable("codigo") Aeronave aeronave, RedirectAttributes attributes)
	{
		attributes.addFlashAttribute("aeronave", aeronave);
		return new ModelAndView("redirect:/aeronaves/novo");
	}

	@GetMapping("/remover/{codigo}")
	public ModelAndView remover(@PathVariable("codigo") Long codigo)
	{
		aeronaveService.remover(codigo);
		return new ModelAndView("redirect:/aeronaves");
	}
	
	

}





