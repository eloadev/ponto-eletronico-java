package control;

import java.io.IOException;
import java.sql.SQLException;
import java.util.List;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import dao.PontoDao;
import model.Ponto;

@WebServlet("/ListarPontoServlet")
public class ListarPontoServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;

    public ListarPontoServlet() {
        super();
    }

	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		response.getWriter().append("Served at: ").append(request.getContextPath());
		
		List<Ponto> list = null;
		
		int id = Integer.valueOf(request.getParameter("id"));
        
        try {
            list = PontoDao.getTodosPontosPorFuncionario(id); 
        } 
        catch (SQLException e) { 
            e.printStackTrace(); 
        }
        
        request.setAttribute("pontos", list);
        RequestDispatcher requestDispatcher = request.getRequestDispatcher("/tela_principal.jsp");
        requestDispatcher.forward(request, response);
	}

	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		doGet(request, response);
	}

}
