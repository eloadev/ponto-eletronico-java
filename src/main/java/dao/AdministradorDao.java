package dao;

import java.io.FileNotFoundException;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

import model.Administrador;

public class AdministradorDao {
	public Administrador listarUm(int id) throws SQLException, FileNotFoundException {
		Connection con = ConnectionDao.connectDB();
		String sql = "SELECT administrador_id, nome, email, senha FROM administrador WHERE administrador_id = ?";
		PreparedStatement stmt = con.prepareStatement(sql);
		stmt.setInt(1, id);
		ResultSet rs = stmt.executeQuery();
		
		Administrador administrador = null;
		
		if(rs.next()) {
			administrador = new Administrador();
			administrador.setId(rs.getInt("administrador_id"));
			administrador.setNome(rs.getString("nome"));
			administrador.setEmail(rs.getString("email"));
			administrador.setSenha(rs.getString("senha"));
		}
		stmt.close();
		con.close();
		
		return administrador;
	}
}
