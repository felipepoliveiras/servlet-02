package br.senai.sp.informatica.servlet02.servlets;

import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import br.senai.sp.informatica.servlet02.dao.UsuarioDAO;
import br.senai.sp.informatica.servlet02.models.Sexos;
import br.senai.sp.informatica.servlet02.models.Usuario;

@WebServlet(value = "/listar")
public class UsuarioListarServlet extends ServletMelhorado{
	
	private UsuarioDAO usuarioDAO;
	
	public UsuarioListarServlet() {
		usuarioDAO = new UsuarioDAO();
	}
	
	@Override
	protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		
		//Aplica a lista de usuários na requisição
		req.setAttribute("usuarios", usuarioDAO.listar());
		
		//Faz um forward (abre um recurso) para o lista.jsp
		forward(req, resp, "lista");
	}
	
}
