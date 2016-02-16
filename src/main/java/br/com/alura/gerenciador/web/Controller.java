package br.com.alura.gerenciador.web;

import java.io.IOException;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

@WebServlet(urlPatterns= "/executa")
public class Controller extends HttpServlet{
	
	private static final String PACKAGE_NAME = "br.com.alura.gerenciador.web.";
	
	@Override
	protected void service(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		//Pega a ação a ser executada
		String action = req.getParameter("tarefa");
		
		if(null == action){
			throw new IllegalArgumentException("Você não informou a ação a ser executada");
		}
		
		//Redireciona para a página de resultado
		String className = PACKAGE_NAME + action;
		try {
			Class type = Class.forName(className);
			Tarefa task = (Tarefa) type.newInstance();
			String pagina = task.executa(req, resp);
			
			RequestDispatcher requestDispatcher = req.getRequestDispatcher(pagina);
			requestDispatcher.forward(req, resp);
			
		} catch (ClassNotFoundException | InstantiationException | IllegalAccessException e) {
			throw new ServletException(e.getMessage());
		}
		
	}

}
