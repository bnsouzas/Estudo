package br.com.alura.gerenciador.web;

import java.io.IOException;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

@WebServlet(urlPatterns = "/executa")
public class Controller extends HttpServlet {
	private static final long serialVersionUID = 1L;

	@Override
	protected void service(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		String tarefa = req.getParameter("tarefa");
		if (tarefa == null)
			throw new IllegalArgumentException("Tarefa não definida");
		String classe = "br.com.alura.gerenciador.web." + tarefa;
		try {
			Class<?> tipo = Class.forName(classe);
			Tarefa instancia = (Tarefa)tipo.newInstance();
			String redirecionamento = instancia.executa(req,resp);
			RequestDispatcher requestDispatcher = req.getRequestDispatcher(redirecionamento);
			requestDispatcher.forward(req, resp);
		} catch (Exception e) {
			throw new ServletException(e);
		}
	}
}
