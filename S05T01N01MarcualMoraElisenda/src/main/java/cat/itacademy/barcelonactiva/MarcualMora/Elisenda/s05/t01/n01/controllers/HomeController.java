package cat.itacademy.barcelonactiva.MarcualMora.Elisenda.s05.t01.n01.controllers;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;

@Controller
public class HomeController {
	
	@GetMapping({"/sucursal", "/"})
	public String mostrarprueba(Model model) {
		model.addAttribute("nombre","Elisenda Marcual");
		return"homePrueba";
}
}
