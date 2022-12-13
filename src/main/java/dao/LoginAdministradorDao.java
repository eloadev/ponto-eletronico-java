package dao;

import java.io.FileNotFoundException;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

public class LoginAdministradorDao {
	public static int autenticaLogin(String email, String senha) throws SQLException, FileNotFoundException {
		
		Connection connect = ConnectionDao.connectDB();
		
		int validacao = 0;
		
		PreparedStatement preparedStatement 
        	= connect.prepareStatement( 
        			"SELECT email, senha FROM administrador\n"
        			+ "WHERE email=? AND senha=?;");
		
		preparedStatement.setString(1, email);
		preparedStatement.setString(2, senha);
		
		ResultSet resultSet = preparedStatement.executeQuery();
				
		if (resultSet.next()) {
			validacao = 1;
		}
		
		connect.close();
		preparedStatement.close();
		
		return validacao;
	}
}
