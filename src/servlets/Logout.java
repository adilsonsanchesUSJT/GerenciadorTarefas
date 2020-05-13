package servlets;

import java.io.IOException;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

@WebServlet(
		name = "Logout.do", 
		urlPatterns = { 
				"/Logout.do" 
		})
public class Logout extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    public Logout() {
        super();
    }

	protected void service(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		HttpSession sessao = request.getSession(); 
		
		sessao.removeAttribute("email");
		sessao.removeAttribute("senha");
		sessao.removeAttribute("nome");
		sessao.invalidate();
		response.sendRedirect("index.jsp");
	}
}