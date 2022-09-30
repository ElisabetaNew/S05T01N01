package cat.itacademy.barcelonactiva.MarcualMora.Elisenda.s05.t01.n01.controllers;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import cat.itacademy.barcelonactiva.MarcualMora.Elisenda.s05.t01.n01.model.dto.SucursalDTO;
import cat.itacademy.barcelonactiva.MarcualMora.Elisenda.s05.t01.n01.model.services.SucursalServicioImpl;

@RestController
@RequestMapping("/sucursal")
public class SucursalController {

	@Autowired
	SucursalServicioImpl sucursalService;


	//http://localhost:9000/sucursal/add ---- crear fruta	
	@PostMapping("/add")
	public ResponseEntity<SucursalDTO> add(@RequestBody SucursalDTO sucursalDto) {
		try {
			return new ResponseEntity<>(sucursalService.addSucursal(sucursalDto), HttpStatus.CREATED);
		} catch (Exception e) {
			return new ResponseEntity<>(null, HttpStatus.INTERNAL_SERVER_ERROR);
		}
	}

	 
	// http://localhost:9000/sucursal/getAll ---- recuperar todas las sucursales
	@GetMapping("/getAll")
	public ResponseEntity<SucursalDTO> getAll() {
		try {
			return new ResponseEntity(sucursalService.getAllSucursal(), HttpStatus.OK);
		} catch (Exception e) {
			return new ResponseEntity<>(null, HttpStatus.INTERNAL_SERVER_ERROR);
		}
	}
	

	//http://localhost:9000/sucursal/getOne/{id} ----- recuperar sucursal por id
	@GetMapping("/getOne/{id}")
	public ResponseEntity<SucursalDTO> getById(@PathVariable("id") int pk_SucursalID) {
		try {
			return new ResponseEntity(sucursalService.getOneSucursal(pk_SucursalID), HttpStatus.OK);
		} catch (Exception e) {
			return new ResponseEntity<>(null, HttpStatus.INTERNAL_SERVER_ERROR);
		}
	}
	

	// http://localhost:9000/sucursal/update ---- actualizar o modificar sucursal
	@PutMapping("/update/{id}")
	public ResponseEntity<SucursalDTO> updateTutorial(@PathVariable("id") int pk_SucursalID, @RequestBody SucursalDTO sucursalDto) {
		try {
			return new ResponseEntity<SucursalDTO>(sucursalService.updateSucursal(pk_SucursalID, sucursalDto), HttpStatus.OK);
		} catch (Exception e) {
			return new ResponseEntity<>(null, HttpStatus.INTERNAL_SERVER_ERROR);
		}
	}


	// http://localhost:9000/sucursal/delete/{id} ---- borrar sucursal por id
	@DeleteMapping("/delete/{id}")
	public ResponseEntity<HttpStatus> deleteId(@PathVariable("id") int pk_SucursalID) {
		try {
			boolean respuesta = sucursalService.deleteSucursal(pk_SucursalID);
			if (respuesta == true) {
				return new ResponseEntity<HttpStatus>(HttpStatus.OK);
			} else {
				return new ResponseEntity<HttpStatus>(HttpStatus.NOT_FOUND);
			}
		} catch (Exception e) {
			return new ResponseEntity<>(null, HttpStatus.INTERNAL_SERVER_ERROR);
		}
	}

}
