package br.com.alura.gerenciador.web;

import java.io.PrintWriter;

import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import br.com.alura.gerenciador.Usuario;
import br.com.alura.gerenciador.dao.UsuarioDAO;

public class Login implements Tarefa{

	private static final long serialVersionUID = -3796313427747926879L;

	protected void doPost(javax.servlet.http.HttpServletRequest req, javax.servlet.http.HttpServletResponse resp)
			throws javax.servlet.ServletException, java.io.IOException {

		String email = req.getParameter("email");
		String senha = req.getParameter("senha");

		UsuarioDAO usuarioDAO = new UsuarioDAO();
		Usuario usuario = usuarioDAO.buscaPorEmailESenha(email, senha);
		PrintWriter writer = resp.getWriter();
		if (null == usuario) {
			writer.println("<html><body>");
			writer.println("Usuário inválido!");
			writer.println("</html></body>");
		} else {
//			Cookie cookie = new Cookie("usuario.logado", email);
//			resp.addCookie(cookie);
			
			HttpSession session = req.getSession();
			session.setAttribute("usuarioLogado", usuario);
			
			writer.println("<html><body>");
			writer.println("Usuário ");
			writer.println(email);
			writer.println(" ");
			writer.println("logado com sucesso!");
			writer.println("</html></body>");
		}
	}

	@Override
	public String executa(HttpServletRequest req, HttpServletResponse resp) {
		// TODO Auto-generated method stub
		return null;
	}
}
