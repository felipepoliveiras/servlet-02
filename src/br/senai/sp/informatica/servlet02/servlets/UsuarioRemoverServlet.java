package br.senai.sp.informatica.servlet02.servlets;

import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import br.senai.sp.informatica.servlet02.dao.UsuarioDAO;
import br.senai.sp.informatica.servlet02.models.Usuario;

@WebServlet(value = "/remover")
public class UsuarioRemoverServlet extends ServletMelhorado{
	
	private UsuarioDAO usuarioDAO;
	
	public UsuarioRemoverServlet() {
		usuarioDAO = new UsuarioDAO();
	}
	
	@Override
	protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
	
		//Par�metros da requisi��o
		String idValue = req.getParameter("id");
		
		//Campos
		long id = 0;
		
		//Valida��es
		try {
			id = Integer.parseInt(idValue);
		} catch (NumberFormatException e) {
			redirect(resp, "listar?erro=1");
			return;
		}
		
		Usuario usuarioRemovido = usuarioDAO.pegar(id);
		
		//Se o usu�rio que ser� removido n�o existir
		if(usuarioRemovido == null) {
			redirect(resp, "listar?erro=2");
			return;
		}
		
		//Remove o usu�rio e redireciona pra lista
		usuarioDAO.remover(usuarioRemovido.getId());
		redirect(resp, "listar");
		
	}
	
}
