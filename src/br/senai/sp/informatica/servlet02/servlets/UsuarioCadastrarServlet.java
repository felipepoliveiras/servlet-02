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

@WebServlet(value = "/cadastrar")
public class UsuarioCadastrarServlet extends ServletMelhorado{
	
	private UsuarioDAO usuarioDAO;
	
	public UsuarioCadastrarServlet() {
		usuarioDAO = new UsuarioDAO();
	}
	
	@Override
	protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		
		//Pegar dados
		String nomeValue = req.getParameter("nome");
		String enderecoValue = req.getParameter("endereco");
		String sexoValue = req.getParameter("sexo");
		String temFilhosValue = req.getParameter("temFilhos");
		
		//Campos n�o String
		Sexos sexo = null;
		Boolean temFilhos = temFilhosValue != null;
		
		//Valida��es
		List<String> erros = new ArrayList<>();
		if(nomeValue == null || nomeValue.trim().isEmpty()) {
			erros.add("O campo nome � obrigat�rio");
		}
		
		if(enderecoValue == null || enderecoValue.trim().isEmpty()) {
			erros.add("O campo endere�o � obrigat�rio");
		}
		
		if(sexoValue == null) {
			erros.add("O campo sexo � obrigat�rio.");
		}else if(Sexos.valueOf(sexoValue) == null) {
			erros.add("Informe um sexo valido. Valores poss�veis: "  + Sexos.values());
		}

		//Se a lista de errors n�o estiver vazia, abre a tela de cadastro novamente
		//e envia os erros na requisi��o
		if(! erros.isEmpty()) {
			req.setAttribute("erros", erros);
			forward(req, resp, "form-novo");
			return;
		}
		
		//Caso contr�rio, aplica todos os valores no modelo
		Usuario usuario = new Usuario();
		usuario.setEndereco(enderecoValue);
		usuario.setNome(nomeValue);
		usuario.setSexo(sexo);
		usuario.setTemFilhos(temFilhos);
		usuarioDAO.cadastrar(usuario);
		
		redirect(resp, "/listar");

		
		
	}
	
}
