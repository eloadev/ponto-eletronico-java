package dao;

import java.io.FileNotFoundException;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.SQLTimeoutException;
import java.util.ArrayList;
import java.util.List;

import model.Ponto;

public class PontoDao {
	public static int addPonto(Ponto ponto) throws SQLException, FileNotFoundException { 
		int result = 0; 
		
	    Connection connect = ConnectionDao.connectDB(); 
	    
	    PreparedStatement preparedStatement 
	        = connect.prepareStatement( 
	            "INSERT INTO ponto (data, hora, funcionario_id) VALUES (?,?,?)");
	    
	    preparedStatement.setString(1, ponto.getData());
	    preparedStatement.setString(2, ponto.getHora());
	    preparedStatement.setInt(3, ponto.getFuncionario().getId());
	
	    result = preparedStatement.executeUpdate(); 
	    
	    connect.close();
	    preparedStatement.close();
	    
	    return result; 
	}

	public static List<Ponto> getTodosPontosPorFuncionario(int funcionario_id) throws SQLTimeoutException, FileNotFoundException, SQLException {
		List<Ponto> listaPontos = new ArrayList<Ponto>(); 

    	Connection connect = ConnectionDao.connectDB();
    	
    	PreparedStatement preparedStatement 
    		= connect.prepareStatement( 
    				"SELECT ponto_id, data, hora FROM ponto WHERE funcionario_id = ?");
    	
    	preparedStatement.setInt(1, funcionario_id);
    	
    	ResultSet resultSet 
    		= preparedStatement.executeQuery(); 

		while (resultSet.next()) { 
			Ponto ponto = new Ponto(); 
			ponto.setId(resultSet.getInt(1)); 
			ponto.setData(resultSet.getString(2)); 
			ponto.setHora(resultSet.getString(3));
			
			FuncionarioDao funcionarioDao = new FuncionarioDao();
			
			ponto.setFuncionario(funcionarioDao.listarUm(funcionario_id));
			
			listaPontos.add(ponto); 
		}
		
		connect.close();
		preparedStatement.close();
		
		return listaPontos;
	}
}
