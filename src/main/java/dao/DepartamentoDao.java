package dao;

import java.io.FileNotFoundException;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

import model.Departamento;

public class DepartamentoDao {
	public static int addDepartamento(Departamento departamento) throws SQLException, FileNotFoundException { 
		int result = 0; 
		
	    Connection connect = ConnectionDao.connectDB(); 
	    
	    PreparedStatement preparedStatement 
	        = connect.prepareStatement( 
	            "INSERT INTO departamento(nome) VALUES (?)");
	    
	    preparedStatement.setString(1, departamento.getNome());
	
	    result = preparedStatement.executeUpdate(); 
	    
	    connect.close();
	    preparedStatement.close();
	    
	    return result; 
	}
	
	public Departamento listarUm(int id) throws SQLException, FileNotFoundException {
		Connection con = ConnectionDao.connectDB();
		String sql = "SELECT departamento_id, nome FROM departamento WHERE departamento_id = ?";
		PreparedStatement stmt = con.prepareStatement(sql);
		stmt.setInt(1, id);
		ResultSet rs = stmt.executeQuery();
		
		Departamento departamento = null;
		
		if(rs.next()) {
			departamento = new Departamento();
			departamento.setId(rs.getInt("departamento_id"));
			departamento.setNome(rs.getString("nome"));
		}
		stmt.close();
		con.close();
		
		return departamento;
	}
	
	public List<Departamento> listarTodos() throws SQLException, FileNotFoundException {
		Connection con = ConnectionDao.connectDB();
		String sql = "SELECT departamento_id, nome FROM departamento";
		PreparedStatement stmt = con.prepareStatement(sql);
		ResultSet rs = stmt.executeQuery();
		
		Departamento departamento = null;
		List<Departamento> departamentos = new ArrayList<Departamento>();
		
		while(rs.next()) {
			departamento = new Departamento();
			departamento.setId(rs.getInt("departamento_id"));
			departamento.setNome(rs.getString("nome"));
			departamentos.add(departamento);
		}
		stmt.close();
		con.close();
		
		return departamentos;
	}
}
