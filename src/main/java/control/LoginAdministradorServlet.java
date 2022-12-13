package control;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.Cookie;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import dao.LoginAdministradorDao;

import java.io.IOException;
import java.sql.SQLException;

@WebServlet(name = "LoginAdministradorServlet", value = "/LoginAdministradorServlet")
public class LoginAdministradorServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    public LoginAdministradorServlet() {
        super();
    }

	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		response.getWriter().append("Served at: ").append(request.getContextPath());
	}

	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		doGet(request, response);
		
		int result = 0;
		
		String email = request.getParameter("email");
		String senha = request.getParameter("senha");
		
		try {
			result = LoginAdministradorDao.autenticaLogin(email, senha);
		} catch (SQLException e) {
			e.printStackTrace();
		}
		
		String nextPage = null;
		String erro = null;
		
		if (result == 1) {
			nextPage = "/ListarFuncionarioServlet";
		}
		else {
			nextPage = "login_administrador.jsp";
			erro = "Login inválido";
			request.setAttribute("erro", erro);
		}
		
		HttpSession session = request.getSession();
		Cookie cookieSession = new Cookie("session", session.getId());
		cookieSession.setMaxAge(60*60*24*31*12);
		response.addCookie(cookieSession);
		
		session.setAttribute("cookieSession", cookieSession);
		
		RequestDispatcher rd = request.getRequestDispatcher(nextPage);
		rd.forward(request, response);
	}	
}