package control;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.sql.SQLException;

import dao.DepartamentoDao;
import dao.FuncionarioDao;
import model.Funcionario;

@WebServlet(name = "AdicionarFuncionarioServlet", value = "/AdicionarFuncionarioServlet")
public class AdicionarFuncionarioServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    public AdicionarFuncionarioServlet() {
        super();
    }

@Override
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
	}

@Override
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		doGet(request, response);
		
		String nome = request.getParameter("nome");
		String cpf = request.getParameter("cpf");
		String email = request.getParameter("email");
		String senha = request.getParameter("senha");
		int departamento_id = Integer.valueOf(request.getParameter("departamento_id"));
		
		Funcionario funcionario = new Funcionario();
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
				
		try {
			FuncionarioDao.addFuncionario(funcionario);
		} catch (SQLException e) {
			e.printStackTrace();
		}
		
		RequestDispatcher rd = request.getRequestDispatcher("ListarDepartamentoServlet?nextPage=novo_funcionario.jsp");
		rd.forward(request, response);
	}
}