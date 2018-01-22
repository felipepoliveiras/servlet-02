package br.senai.sp.informatica.servlet02.dao;

import java.util.ArrayList;
import java.util.List;

import br.senai.sp.informatica.servlet02.models.Usuario;

public class UsuarioDAO {
	
	private static final List<Usuario> usuarios = new ArrayList<>();
	
	public static long ultimoId = 0;
	
	public Usuario pegar(Long id) {
		for (Usuario usuario : usuarios) {
			if(usuario.getId() == id) {
				return usuario;
			}
		}
		
		return null;
	}
	
	public List<Usuario> listar(){
		return usuarios;
	}
	
	public void cadastrar(Usuario usuario) {
		usuario.setId(ultimoId);
		ultimoId++;
		usuarios.add(usuario);
	}
	
	public void remover(Long id) {
		Usuario usuarioRemovido = pegar(id);
		if(usuarioRemovido != null) {
			usuarios.remove(usuarioRemovido);
		}
	}
}
