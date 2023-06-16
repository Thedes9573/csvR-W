package com.examen.ExamenS.controller;

import java.util.ArrayList;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

import com.examen.ExamenS.model.Usuario;
import com.examen.ExamenS.model.status;
import com.examen.ExamenS.model.data;
import com.examen.ExamenS.service.UsuarioService;
import com.examen.ExamenS.CsvService.CsvService;

@RestController
public class UsuarioController {
	@Autowired
	private UsuarioService usuarioservice;
	@Autowired
	private CsvService csvS;
	private status status;
	private data data;

	@PostMapping("api/v1/usuario")
	public status guardarUsuario(@RequestBody Usuario usuario) {
		status = new status();
		data = new data();
		List<String> errors = new ArrayList<String>();
		if (usuario.getId() != null) {
			errors.add("¡NO se requiere ID!");
		}
		if (usuario.getNombre() == null) {
			errors.add("¡Se requiere Nombre!");
		}
		if (usuario.getApellidoP() == null) {
			errors.add("¡Se requiere Apellido Paterno!");
		}
		if (usuario.getApellidoM() == null) {
			errors.add("¡Se requiere Apellido Materno!");
		}
		if (usuario.getEdad() == null) {
			errors.add("¡Se requiere Edad!");
		}
		if (usuario.getEmail() == null) {
			errors.add("¡Se requiere Email!");
		}
		if (usuario.getTelefono() == null) {
			errors.add("¡Se requiere Telefono!");
		}
		if (errors.isEmpty()) {
			usuario.setEstado(true);
			usuarioservice.guardar(usuario);
			data.setErrors(errors);
			status.setSucess(true);
			status.setMsg("Correcto");
			status.setData(data);
			return status;
		} else {
			data.setErrors(errors);
			status.setSucess(false);
			status.setMsg("Error");
			status.setData(data);
			return status;
		}
	}

	@GetMapping({ "api/v1/usuario", "api/v1/usuario/" })
	public List<Usuario> obtener() {
		csvS.leector();
		csvS.escritor(usuarioservice.obtenerTodos());
		return usuarioservice.obtenerTodos();
	}

	@GetMapping("api/v1/usuario/{id}")
	public Usuario obtenerUsuario(@PathVariable("id") Integer id) {
		return usuarioservice.obtenerUsuario(id);
	}

	@PutMapping("api/v1/usuario/{id}")
	public status actualizarUsuario(@RequestBody Usuario usuario, @PathVariable("id") Integer id) {
		status = new status();
		data = new data();
		List<String> errors = new ArrayList<String>();
		if (id == null) {
			errors.add("¡Se requiere ID!");
		}
		if (usuario.getNombre() == null) {
			errors.add("¡Se requiere Nombre!");
		}
		if (usuario.getApellidoP() == null) {
			errors.add("¡Se requiere Apellido Paterno!");
		}
		if (usuario.getApellidoM() == null) {
			errors.add("¡Se requiere Apellido Materno!");
		}
		if (usuario.getEdad() == null) {
			errors.add("¡Se requiere Edad!");
		}
		if (usuario.getEmail() == null) {
			errors.add("¡Se requiere Email!");
		}
		if (usuario.getTelefono() == null) {
			errors.add("¡Se requiere Telefono!");
		}
		if (errors.isEmpty()) {
			if (usuarioservice.editarUsuario(usuario, id)) {
				data.setErrors(errors);
				status.setSucess(true);
				status.setMsg("Correcto");
				status.setData(data);
				return status;
			} else {
				errors.add("¡El ID no coincide!");
				data.setErrors(errors);
				status.setSucess(false);
				status.setMsg("Error");
				status.setData(data);
				return status;
			}
		} else {
			data.setErrors(errors);
			status.setSucess(false);
			status.setMsg("Error");
			status.setData(data);
			return status;
		}

	}

	@DeleteMapping("api/v1/usuario/{id}")
	public boolean eliminarUsuario(@PathVariable("id") Integer id) {
		return usuarioservice.eliminarUsuario(id);
	}

}
