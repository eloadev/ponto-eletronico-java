package control;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.sql.SQLException;
import java.util.List;

import dao.FuncionarioDao;
import model.Funcionario;

@WebServlet(name = "ListarFuncionarioServlet", value = "/ListarFuncionarioServlet")
public class ListarFuncionarioServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    public ListarFuncionarioServlet() {
        super();
    }

	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {

        List<Funcionario> list = null;
        
        try {
            list = FuncionarioDao.getTodosFuncionarios(); 
        } 
        catch (SQLException e) { 
            e.printStackTrace(); 
        }
        
        request.setAttribute("funcionarios", list);
        RequestDispatcher requestDispatcher = request.getRequestDispatcher("/lista_funcionario.jsp");
        requestDispatcher.forward(request, response);
	}

	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		doGet(request, response);
	}

}