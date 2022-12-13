package control;

import java.io.IOException;
import java.sql.SQLException;
import java.time.LocalDate;
import java.time.LocalTime;
import java.time.format.DateTimeFormatter;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import dao.FuncionarioDao;
import dao.PontoDao;
import model.Ponto;

@WebServlet("/AdicionarPontoServlet")
public class AdicionarPontoServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    public AdicionarPontoServlet() {
        super();
    }

	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		response.getWriter().append("Served at: ").append(request.getContextPath());
		
		int funcionario_id = Integer.valueOf(request.getParameter("id"));
		
		LocalDate data = java.time.LocalDate.now();
		DateTimeFormatter dataFormatada = DateTimeFormatter.ofPattern("dd LLLL yyyy");
		String dataString = data.format(dataFormatada);
		
		LocalTime hora = java.time.LocalTime.now();
		
		Ponto ponto = new Ponto();
		ponto.setData(dataString);
		ponto.setHora(hora.toString());
		
		FuncionarioDao funcionarioDao = new FuncionarioDao();
		
		try {
			ponto.setFuncionario(funcionarioDao.listarUm(funcionario_id));
		} catch (SQLException e) {
	    	e.printStackTrace(); 
	    }
		
		try {
			PontoDao.addPonto(ponto);
		} catch (SQLException e) {
			e.printStackTrace();
		}
		
		RequestDispatcher rd = request.getRequestDispatcher("/ListarPontoServlet");
		rd.forward(request, response);
	}

	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		doGet(request, response);
	}
}
