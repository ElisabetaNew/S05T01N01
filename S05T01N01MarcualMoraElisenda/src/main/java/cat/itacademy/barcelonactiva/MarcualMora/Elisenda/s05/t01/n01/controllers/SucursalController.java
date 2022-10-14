package cat.itacademy.barcelonactiva.MarcualMora.Elisenda.s05.t01.n01.controllers;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.servlet.ModelAndView;

import cat.itacademy.barcelonactiva.MarcualMora.Elisenda.s05.t01.n01.model.dto.SucursalDTO;
import cat.itacademy.barcelonactiva.MarcualMora.Elisenda.s05.t01.n01.model.services.SucursalServicioImpl;

@Controller
@RequestMapping("/sucursal")
public class SucursalController {
	
	@GetMapping({"","/"})
	public String mostrarprueba(Model model) {
		model.addAttribute("nombre","Elisenda Marcual");
		return"homePrueba";
	}
	
	@Autowired
	private SucursalServicioImpl sucursalService;

	// http://localhost:9000/sucursal/add ---- crear fruta
	@GetMapping("/add")
	public ModelAndView addSucursal(ModelAndView modelAndView) {
		SucursalDTO sucursal = new SucursalDTO(3, "Hotel Paris", "Francia", "UE");
		modelAndView.addObject("Nueva_Sucursal", sucursalService.addSucursal(sucursal));
		modelAndView.setViewName("sucursal/addSucursal");
		return modelAndView;
	}

	// http://localhost:9000/sucursal/getAll ---- recuperar todas las sucursales
	@GetMapping("/getAll")
	public ModelAndView listaAll(ModelAndView modelAndView) {
		List<SucursalDTO> sucursales = sucursalService.getAllSucursal();
		modelAndView.addObject("Lista_Sucursales", sucursales);
		modelAndView.setViewName("sucursal/getAllSucursal");
		return modelAndView;
	}

	// http://localhost:9000/sucursal/getOne/{id} ----- recuperar sucursal por id
	//@GetMapping("/getOne/{id}")
	@GetMapping("/getOne")
	public ModelAndView getOneSucursal(ModelAndView modelAndView, @PathVariable("id") Integer id) {
		SucursalDTO sucursal = sucursalService.getOneSucursal(id);
		modelAndView.addObject("Sucursal", sucursal);
		modelAndView.setViewName("sucursal/getOneSucursal");
		return new ModelAndView ("redirect:/getAll"); //para redirigir la salida al recurso de getAll para volver a lista el resto de sucursales
	}

	// http://localhost:9000/sucursal/update ---- actualizar o modificar sucursal
	//@PostMapping("/update/{id}")
	@PostMapping("/update")
	public ModelAndView updateSucursal(ModelAndView modelAndView, @PathVariable("id") Integer id) {
		SucursalDTO sucursalDTO = new SucursalDTO();
		modelAndView.addObject("Sucursal", sucursalDTO);
		modelAndView.setViewName("sucursal/updateSucursal");
		return modelAndView;
	}

	// http://localhost:9000/sucursal/delete/{id} ---- borrar sucursal por id
	@DeleteMapping("/delete")
	public ModelAndView deleteSucursal(ModelAndView modelAndView, @PathVariable("id") Integer id) {
		sucursalService.deleteSucursal(id);
		//return new ModelAndView ("redirect:/getAll");
		modelAndView.setViewName("sucursal/deleteSucursal");
		return modelAndView;
	}
	
}
