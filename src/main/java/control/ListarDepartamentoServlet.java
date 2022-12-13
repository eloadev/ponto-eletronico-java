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
import dao.DepartamentoDao;
import model.Departamento;

@WebServlet("/ListarDepartamentoServlet")
public class ListarDepartamentoServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;

    public ListarDepartamentoServlet() {
        super();
    }

	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		
		String nextPage = request.getParameter("nextPage");
		DepartamentoDao departamentoDao = new DepartamentoDao();
		List<Departamento> departamentos = null;
		try {
			departamentos = departamentoDao.listarTodos();
		} catch (SQLException e) {
			e.printStackTrace();
		}
		
		request.setAttribute("departamentos", departamentos);
		RequestDispatcher rd = request.getRequestDispatcher(nextPage);
		rd.forward(request, response);
	}
	
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		doGet(request, response);
	}

}