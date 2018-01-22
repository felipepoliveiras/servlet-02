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
		
		//Campos não String
		Sexos sexo = null;
		Boolean temFilhos = temFilhosValue != null;
		
		//Validações
		List<String> erros = new ArrayList<>();
		if(nomeValue == null || nomeValue.trim().isEmpty()) {
			erros.add("O campo nome é obrigatório");
		}
		
		if(enderecoValue == null || enderecoValue.trim().isEmpty()) {
			erros.add("O campo endereço é obrigatório");
		}
		
		if(sexoValue == null) {
			erros.add("O campo sexo é obrigatório.");
		}else if(Sexos.valueOf(sexoValue) == null) {
			erros.add("Informe um sexo valido. Valores possíveis: "  + Sexos.values());
		}

		//Se a lista de errors não estiver vazia, abre a tela de cadastro novamente
		//e envia os erros na requisição
		if(! erros.isEmpty()) {
			req.setAttribute("erros", erros);
			forward(req, resp, "form-novo");
			return;
		}
		
		//Caso contrário, aplica todos os valores no modelo
		Usuario usuario = new Usuario();
		usuario.setEndereco(enderecoValue);
		usuario.setNome(nomeValue);
		usuario.setSexo(sexo);
		usuario.setTemFilhos(temFilhos);
		usuarioDAO.cadastrar(usuario);
		
		redirect(resp, "/listar");

		
		
	}
	
}
