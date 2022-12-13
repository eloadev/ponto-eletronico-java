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
import dao.FuncionarioDao;
import model.Departamento;
import model.Funcionario;

@WebServlet("/MostrarFormularioEdicaoServlet")
public class MostrarFormularioEdicaoServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    public MostrarFormularioEdicaoServlet() {
        super();
    }

	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		response.getWriter().append("Served at: ").append(request.getContextPath());
		
		FuncionarioDao funcionarioDao = new FuncionarioDao();
		Funcionario funcionario = new Funcionario();
		
		int id = Integer.valueOf(request.getParameter("id"));
		
		try {
			funcionario = funcionarioDao.listarUm(id);
		} catch (SQLException e) {
			e.printStackTrace();
		}
		
		DepartamentoDao departamentoDao = new DepartamentoDao();
		List<Departamento> departamentos = null;
		
		try {
			departamentos = departamentoDao.listarTodos();
		} catch (SQLException e) {
			e.printStackTrace();
		}
		
		request.setAttribute("departamentos", departamentos);
		request.setAttribute("funcionario", funcionario);
		
		RequestDispatcher rd = request.getRequestDispatcher("editar_funcionario.jsp");
		rd.forward(request, response);
	}

	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		doGet(request, response);
	}

}
