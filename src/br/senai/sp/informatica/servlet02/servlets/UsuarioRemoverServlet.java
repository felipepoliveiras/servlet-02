package br.senai.sp.informatica.servlet02.servlets;

import java.io.IOException;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

@WebServlet(value = "/remover")
public class UsuarioRemoverServlet extends ServletMelhorado{
	
	@Override
	protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
	
		String idValue = req.getParameter("id");
		
		
		
	}
	
}
