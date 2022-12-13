package control;

import java.io.IOException;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.Cookie;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

@WebServlet("/CookieServlet")
public class CookieServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;

    public CookieServlet() {
        super();
    }

	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		response.getWriter().append("Served at: ").append(request.getContextPath());
		
		Cookie cookie_fundo = new Cookie("cor_fundo", request.getParameter("cor_fundo"));
		Cookie cookie_fonte = new Cookie("cor_fonte", request.getParameter("cor_fonte"));
		cookie_fundo.setMaxAge(60*60*24*31*12);
		cookie_fonte.setMaxAge(60*60*24*31*12);
		response.addCookie(cookie_fundo);
		response.addCookie(cookie_fonte);
		
		HttpSession session = request.getSession();
		session.setAttribute("cor_fundo", request.getParameter("cor_fundo"));
		session.setAttribute("cor_fonte", request.getParameter("cor_fonte"));
		
		RequestDispatcher requestDispatcher = request.getRequestDispatcher("/index.jsp");
		requestDispatcher.forward(request, response);
	}

	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		doGet(request, response);
	}

}
