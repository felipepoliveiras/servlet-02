package br.senai.sp.informatica.servlet02.servlets;

import java.io.IOException;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import br.senai.sp.informatica.servlet02.dao.UsuarioDAO;
import br.senai.sp.informatica.servlet02.models.Sexos;
import br.senai.sp.informatica.servlet02.models.Usuario;

@WebServlet(value = "/editar")
public class UsuarioEditarServlet extends ServletMelhorado{
	
private UsuarioDAO usuarioDAO;
	
	public UsuarioEditarServlet() {
		usuarioDAO = new UsuarioDAO();
	}
	
	@Override
	protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
	
		//Parâmetros da requisição
		String idValue = req.getParameter("id");
		
		//Campos
		long id = 0;
		
		//Validações
		try {
			id = Integer.parseInt(idValue);
		} catch (NumberFormatException e) {
			redirect(resp, "listar?erro=3");
			return;
		}
		
		Usuario usuarioEditado = usuarioDAO.pegar(id);
		
		//Se o usuário que será removido não existir
		if(usuarioEditado == null) {
			redirect(resp, "listar?erro=4");
			return;
		}
		
		//Exibe o form com os dados do usuário
		req.setAttribute("usuario", usuarioEditado);
		req.setAttribute("sexos", Sexos.values());
		forward(req, resp, "form");
		
	}
	
}
