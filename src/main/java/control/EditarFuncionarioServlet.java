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
import dao.FuncionarioDao;
import model.Funcionario;

@WebServlet("/EditarFuncionarioServlet")
public class EditarFuncionarioServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;

    public EditarFuncionarioServlet() {
        super();
    }

	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		response.getWriter().append("Served at: ").append(request.getContextPath());
		
		String id = request.getParameter("id");
		String nome = request.getParameter("nome");
		String cpf = request.getParameter("cpf");
		String email = request.getParameter("email");
		String senha = request.getParameter("senha");
		int departamento_id = Integer.valueOf(request.getParameter("departamento"));
		
		Funcionario funcionario = new Funcionario();
		funcionario.setId(Integer.valueOf(id));
		funcionario.setNome(nome);
		funcionario.setCpf(cpf);
		funcionario.setEmail(email);
		funcionario.setSenha(senha);
		
		DepartamentoDao departamentoDao = new DepartamentoDao();
				
		try {
			funcionario.setDepartamento(departamentoDao.listarUm(departamento_id));
		} catch (SQLException e) { 
	    	e.printStackTrace(); 
	    }
		
		int result = 0;
		String mensagem = null;
		
		try {
			result = FuncionarioDao.updateFuncionario(funcionario);
		} catch (SQLException e) {
			e.printStackTrace();
		}
		
		if(result == 1) {
			mensagem = "Edição feita com sucesso!";
		} else {
			mensagem = "Edição falhou.";
		}
		
		request.setAttribute("mensagem_editar", mensagem);
		RequestDispatcher rd = request.getRequestDispatcher("/ListarFuncionarioServlet");
		rd.forward(request, response);
	}

	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		doGet(request, response);
	}
}
