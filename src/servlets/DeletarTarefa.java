package servlets;

import java.io.IOException;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import model.Tarefa;
import service.TarefaService;

@WebServlet(name = "DeletarTarefa.do", urlPatterns = { "/DeletarTarefa.do" })
public class DeletarTarefa extends HttpServlet {
	private static final long serialVersionUID = 1L;

	public DeletarTarefa() {
		super();
	}

	protected void doGet(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		String idTarefa = request.getParameter("id");
		TarefaService ts = new TarefaService();

		int idTarefaInt = Integer.parseInt(idTarefa);
		Tarefa t = ts.consultar(idTarefaInt);

		ts.excluir(t);
		
		response.sendRedirect("tarefas.jsp");
	}
}
