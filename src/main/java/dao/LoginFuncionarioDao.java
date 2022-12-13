package dao;

import java.io.FileNotFoundException;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

import model.Funcionario;

public class LoginFuncionarioDao {
	public static Funcionario autenticaLogin(String email, String senha) throws SQLException, FileNotFoundException {
		
		Connection connect = ConnectionDao.connectDB();
				
		PreparedStatement preparedStatement 
        	= connect.prepareStatement( 
        			"SELECT funcionario_id, nome, cpf, email, senha, departamento_id FROM funcionario\n"
        			+ "WHERE email=? AND senha=?;");
		
		preparedStatement.setString(1, email);
		preparedStatement.setString(2, senha);
		
		ResultSet resultSet = preparedStatement.executeQuery();
		
		Funcionario funcionario = null;
				
		if (resultSet.next()) {
			funcionario = new Funcionario();
			funcionario.setId(resultSet.getInt("funcionario_id"));
			funcionario.setNome(resultSet.getString("nome"));
			funcionario.setCpf(resultSet.getString("cpf"));
			funcionario.setEmail(resultSet.getString("email"));
			funcionario.setSenha(resultSet.getString("senha"));
			
			DepartamentoDao departamentoDao = new DepartamentoDao();
			
			funcionario.setDepartamento(departamentoDao.listarUm(resultSet.getInt("departamento_id")));
			}
		
		connect.close();
		preparedStatement.close();
		
		return funcionario;
	}
}
