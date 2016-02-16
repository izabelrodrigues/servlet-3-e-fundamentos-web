package br.com.alura.gerenciador.web;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

public class Logout implements Tarefa {

/*	private static final long serialVersionUID = 697426254938121928L;

	@Override
	protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		// Cookie[] cookies = req.getCookies();
		// Cookie cookie = new Cookies(cookies).getUsuarioLogado();
		// if(cookie != null){
		// cookie.setMaxAge(0);
		// resp.addCookie(cookie);
		// }

		HttpSession session = req.getSession();
		session.removeAttribute("usuarioLogado");
		RequestDispatcher dispatcher = req.getRequestDispatcher("/WEB-INF/paginas/logout.html");
		dispatcher.forward(req, resp);
	}*/

	@Override
	public String executa(HttpServletRequest req, HttpServletResponse resp) {
		HttpSession session = req.getSession();
		session.removeAttribute("usuarioLogado");
		return "/WEB-INF/paginas/logout.html";
	}

}
