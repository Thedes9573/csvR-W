package com.examen.ExamenS.service;

import java.util.ArrayList;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.examen.ExamenS.model.Usuario;
import com.examen.ExamenS.repository.UsuarioRepository;

@Service
public class UsuarioService {
	@Autowired
	private UsuarioRepository UsuarioRepository;
	
	public void guardar (Usuario user) {
		UsuarioRepository.save(user);
	}
	
	public List<Usuario> obtenerTodos(){
		List<Usuario> usuarios=UsuarioRepository.findAll();
		List<Usuario> us2=new ArrayList<>();
		for(Integer i=0;i<usuarios.size();i++) {
			if(usuarios.get(i).isEstado()) {
				us2.add(usuarios.get(i));
			}
		}
		return us2;
	}
	public Usuario obtenerUsuario(Integer id) {
		if(UsuarioRepository.getOne(id).isEstado())
		return UsuarioRepository.getOne(id);
		else
			return null;
	}
	public boolean editarUsuario(Usuario user, Integer id) {
		if(UsuarioRepository.existsById(id)&&UsuarioRepository.getOne(id).isEstado()) {
			user.setId(id);
			user.setEstado(true);
			System.out.println(user.isEstado());
		UsuarioRepository.save(user);
		return true;
		}
		else {
			return false;
		}
	}
	public boolean eliminarUsuario(Integer id) {
		if(UsuarioRepository.existsById(id)&&UsuarioRepository.getOne(id).isEstado()) {
			Usuario user=UsuarioRepository.getOne(id);
			user.setEstado(false);
		UsuarioRepository.save(user);
		return true;
		}
		return false;
	}
}