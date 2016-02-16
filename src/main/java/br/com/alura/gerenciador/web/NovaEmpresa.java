package br.com.alura.gerenciador.web;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import br.com.alura.gerenciador.Empresa;
import br.com.alura.gerenciador.dao.EmpresaDAO;

//@WebServlet(urlPatterns="/novaEmpresa")
public class NovaEmpresa implements Tarefa {

//	private static final long serialVersionUID = -4165129590738667259L;
//
//	@Override
//	protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
//		String nome = req.getParameter("nome");
//		EmpresaDAO empresaDAO = new EmpresaDAO();
//		Empresa empresa = new Empresa(nome);
//		empresaDAO.adiciona(empresa);
//		req.setAttribute("nome", nome);
//		RequestDispatcher requestDispatcher = req.getRequestDispatcher("/WEB-INF/paginas/novaempresa.jsp");
//		requestDispatcher.forward(req, resp);
//		
//	}

	@Override
	public String executa(HttpServletRequest req, HttpServletResponse resp) {
		String nome = req.getParameter("nome");
		EmpresaDAO empresaDAO = new EmpresaDAO();
		Empresa empresa = new Empresa(nome);
		empresaDAO.adiciona(empresa);
		req.setAttribute("nome", nome);
		return "/WEB-INF/paginas/novaempresa.jsp";
	}
}
