package servlets;

import java.io.IOException;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import model.Usuario;
import service.UsuarioService;

@WebServlet(name = "Cadastrar.do", urlPatterns = { "/Cadastrar.do" })
public class Cadastrar extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    public Cadastrar() {
        super();
    }

	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {	
		String email = request.getParameter("email");
		String senha = request.getParameter("senha");
		String nome = request.getParameter("nome");
		
		UsuarioService usuarioService = new UsuarioService();
		Usuario u = new Usuario(email, senha, nome);
		usuarioService.cadastrar(u);
		response.sendRedirect("index.jsp");
	}
}
