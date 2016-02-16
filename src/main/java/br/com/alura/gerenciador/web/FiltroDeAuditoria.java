package br.com.alura.gerenciador.web;

import java.io.IOException;

import javax.servlet.Filter;
import javax.servlet.FilterChain;
import javax.servlet.FilterConfig;
import javax.servlet.ServletException;
import javax.servlet.ServletRequest;
import javax.servlet.ServletResponse;
import javax.servlet.annotation.WebFilter;
import javax.servlet.http.Cookie;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpSession;

import br.com.alura.gerenciador.Usuario;

@WebFilter(urlPatterns="/*")
public class FiltroDeAuditoria implements Filter{

	@Override
	public void destroy() {
	}

	@Override
	public void doFilter(ServletRequest request, ServletResponse response, FilterChain chain)
			throws IOException, ServletException {
		
		HttpServletRequest req = (HttpServletRequest)request;
//		HttpServletResponse resp = (HttpServletResponse)response;
		String uri = req.getRequestURI();
		
//		Cookie cookie = getUsuario(req);
//		String usuario = "<deslogado>";
//
//		if(cookie != null){
//			cookie.setMaxAge(10 *60);
//			resp.addCookie(cookie);
//			usuario = cookie.getValue();
//		}
		
		HttpSession session = req.getSession();
		Usuario usuario =(Usuario)session.getAttribute("usuarioLogado");
		
		System.out.println("Usuario " + (usuario != null ? usuario.getEmail() : "<deslogado>") + " acessando a URI " + uri);
		chain.doFilter(request, response);
	}

	public Cookie getUsuario(HttpServletRequest req) {
		Cookie[] cookies = req.getCookies();
		
		return new Cookies(cookies).getUsuarioLogado();
		
	}

	@Override
	public void init(FilterConfig arg0) throws ServletException {
	}

}
