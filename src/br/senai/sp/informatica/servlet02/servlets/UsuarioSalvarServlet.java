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

@WebServlet(value = "/salvar")
public class UsuarioSalvarServlet extends ServletMelhorado{
	
	private UsuarioDAO usuarioDAO;
	
	public UsuarioSalvarServlet() {
		usuarioDAO = new UsuarioDAO();
	}
	
	@Override
	protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		
		//Pegar dados
		String idValue = req.getParameter("id");
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
		}else {
			sexo = Sexos.valueOf(sexoValue);
		}
		
		//Caso contr�rio, aplica todos os valores no modelo
		Usuario usuario = new Usuario();
		usuario.setEndereco(enderecoValue);
		usuario.setNome(nomeValue);
		usuario.setSexo(sexo);
		usuario.setTemFilhos(temFilhos);
		
		//Se a lista de errors n�o estiver vazia, abre a tela de cadastro novamente
		//e envia os erros na requisi��o
		if(! erros.isEmpty()) {
			req.setAttribute("erros", erros);
			req.setAttribute("usuario", usuario);
			forward(req, resp, "form");
			return;
		}
		
		//Verifica se � cadastro ou uma alera��o
		try {
			long id = Long.parseLong(idValue);
			usuario.setId(id);
			alterar(usuario, req, resp);
		} catch (Exception e) {
			cadastar(usuario, req, resp);
		}
	}
	
	protected void alterar(Usuario usuarioFonte, HttpServletRequest req, HttpServletResponse resp) throws IOException {
		Usuario usuarioAlterado = usuarioDAO.pegar(usuarioFonte.getId());
		
		if(usuarioAlterado == null) {
			redirect(resp, "listar?id=3");
			return;
		}
		
		//Aplica os valores do usu�rio fonte no usu�rio que j� estava na lista
		usuarioAlterado.setEndereco(usuarioFonte.getEndereco());
		usuarioAlterado.setNome(usuarioFonte.getNome());
		usuarioAlterado.setSexo(usuarioFonte.getSexo());
		usuarioAlterado.setTemFilhos(usuarioAlterado.isTemFilhos());
		
		redirect(resp, "listar");
	}
	
	protected void cadastar(Usuario usuario, HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		usuarioDAO.cadastrar(usuario);
		redirect(resp, "listar");
	}
	
}
