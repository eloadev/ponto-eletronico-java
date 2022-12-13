package control;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.Cookie;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import dao.LoginFuncionarioDao;
import model.Funcionario;

import java.io.IOException;
import java.sql.SQLException;

@WebServlet(name = "LoginFuncionarioServlet", value = "/LoginFuncionarioServlet")
public class LoginFuncionarioServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    public LoginFuncionarioServlet() {
        super();
    }

	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		response.getWriter().append("Served at: ").append(request.getContextPath());
	}

	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		doGet(request, response);
				
		String email = request.getParameter("email");
		String senha = request.getParameter("senha");
		
		Funcionario funcionario = new Funcionario();
		
		try {
			funcionario = LoginFuncionarioDao.autenticaLogin(email, senha);
		} catch (SQLException e) {
			e.printStackTrace();
		}
		
		String nextPage = null;
		String erro = null;
		
		if (funcionario != null) {
			int id = funcionario.getId();
			nextPage = "/ListarPontoServlet?id=" + id;
		}
		else {
			nextPage = "login_funcionario.jsp";
			erro = "Login inválido";
			request.setAttribute("erro", erro);
		}
		
		HttpSession session = request.getSession();
		Cookie cookieSession = new Cookie("session", session.getId());
		cookieSession.setMaxAge(60*60*24*31*12);
		response.addCookie(cookieSession);
		
		session.setAttribute("funcionario", funcionario);
		session.setAttribute("cookieSession", cookieSession);
		
		RequestDispatcher rd = request.getRequestDispatcher(nextPage);
		rd.forward(request, response);
	}	
}