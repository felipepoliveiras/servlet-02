package br.senai.sp.informatica.servlet02.servlets;

import java.io.IOException;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import br.senai.sp.informatica.servlet02.models.Sexos;

@WebServlet(value = "/novo")
public class UsuarioNovoServlet extends ServletMelhorado{
	
	@Override
	protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		
		req.setAttribute("sexos", Sexos.values());
		forward(req, resp, "form");
	}
	
}
