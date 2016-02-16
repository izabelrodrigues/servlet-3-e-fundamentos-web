package br.com.alura.gerenciador.web;

import java.util.Collection;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import br.com.alura.gerenciador.Empresa;
import br.com.alura.gerenciador.dao.EmpresaDAO;

//@WebServlet(urlPatterns = "/busca")
public class BuscaEmpresa implements Tarefa {

	// private static final long serialVersionUID = -5640846148829616329L;
	//
	// public BuscaEmpresa() {
	// System.out.println("Instanciando uma Servlet do tipo BuscaEmpresa " +
	// this);
	// }
	//
	// @Override
	// public void init() throws ServletException {
	// super.init();
	// System.out.println("Inicializando uma Servlet do tipo BuscaEmpresa " +
	// this);
	// }
	//
	// @Override
	// public void destroy() {
	// super.destroy();
	// System.out.println("Destruindo uma Servlet do tipo BuscaEmpresa " +
	// this);
	// }

	// @Override
	// protected void doGet(HttpServletRequest req, HttpServletResponse resp)
	// throws ServletException, IOException {
	//
	// String parameter = req.getParameter("filtro");
	// EmpresaDAO empresaDAO = new EmpresaDAO();
	// Collection<Empresa> empresas =
	// empresaDAO.buscaPorSimilaridade(parameter);
	// req.setAttribute("empresas", empresas);
	// RequestDispatcher requestDispatcher =
	// req.getRequestDispatcher("/WEB-INF/paginas/buscaempresa.jsp");
	// requestDispatcher.forward(req, resp);
	//
	// }

	@Override
	public String executa(HttpServletRequest req, HttpServletResponse resp) {
		String parameter = req.getParameter("filtro");
		EmpresaDAO empresaDAO = new EmpresaDAO();
		Collection<Empresa> empresas = empresaDAO.buscaPorSimilaridade(parameter);
		req.setAttribute("empresas", empresas);
		return "/WEB-INF/paginas/buscaempresa.jsp";
	}

}
