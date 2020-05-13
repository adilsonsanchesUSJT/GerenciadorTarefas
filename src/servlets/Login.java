package servlets;

import java.io.IOException;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import model.Usuario;
import service.UsuarioService;

@WebServlet(
		name = "Login.do", 
		urlPatterns = { 
				"/Login.do" 
		})
public class Login extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    public Login() {
        super();
    }

	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		UsuarioService us = new UsuarioService();
		Usuario u = new Usuario();
		
		String email = request.getParameter("email");
		String senha = request.getParameter("senha");
	
			u = us.consultar(email, senha);
			HttpSession sessao = request.getSession();
			if (u != null) {
				sessao.setAttribute("email", email);
				sessao.setAttribute("senha", senha);
				sessao.setAttribute("nome", u.getNome());
				sessao.removeAttribute("mensagem");
				response.sendRedirect("tarefas.jsp");
			}
			else {
				sessao.setAttribute("mensagem", "Usuário e/ou senha inválidos!");
			}
	}
}