package control;

import java.io.IOException;
import java.sql.SQLException;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import dao.FuncionarioDao;

@WebServlet("/ExcluirFuncionarioServlet")
public class ExcluirFuncionarioServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;

    public ExcluirFuncionarioServlet() {
        super();
    }

	@SuppressWarnings("static-access")
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		response.getWriter().append("Served at: ").append(request.getContextPath());
		
		int id = Integer.valueOf(request.getParameter("id"));
		int result = 0;
		
		FuncionarioDao funcionarioDao = new FuncionarioDao();

		try {
			result = funcionarioDao .deleteFuncionario(id);
		} catch (SQLException e) {
			e.printStackTrace();
		}
		
		String mensagem;
		
		if(result == 1) {
			mensagem = "Exclusão feita com sucesso!";
		} else {
			mensagem = "Exclusão falhou.";
		}
		
		request.setAttribute("mensagem_excluir", mensagem);
        RequestDispatcher requestDispatcher = request.getRequestDispatcher("/ListarFuncionarioServlet");
        requestDispatcher.forward(request, response);
	}

	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		doGet(request, response);
	}

}
