package control;

import java.io.IOException;
import java.sql.SQLException;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import dao.DepartamentoDao;
import model.Departamento;

@WebServlet("/AdicionarDepartamentoServlet")
public class AdicionarDepartamentoServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;

    public AdicionarDepartamentoServlet() {
        super();
    }

	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		response.getWriter().append("Served at: ").append(request.getContextPath());
	}

	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		doGet(request, response);
		
		String nome = request.getParameter("nome");
		
		Departamento departamento = new Departamento();
		
		departamento.setNome(nome);
		
		try {
			DepartamentoDao.addDepartamento(departamento);
		} catch (SQLException e) {
			e.printStackTrace();
		}
		
		RequestDispatcher rd = request.getRequestDispatcher("ListarDepartamentoServlet?nextPage=novo_departamento.jsp");
		rd.forward(request, response);
	}

}
