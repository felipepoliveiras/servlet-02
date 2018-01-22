package br.senai.sp.informatica.servlet02.servlets;

import java.io.IOException;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

public class ServletMelhorado extends HttpServlet {
	
	public void forward(HttpServletRequest req, HttpServletResponse resp, String jsp) throws ServletException, IOException {
		String caminho = "/WEB-INF/jsp/" + jsp + ".jsp";
		getServletContext()
			.getRequestDispatcher(caminho)
			.forward(req, resp);
	}
	
	public void redirect(HttpServletResponse resp, String url) throws IOException {
		url = getServletContext().getContextPath() + "/" + url; 
		resp.sendRedirect(url);
	}
}
