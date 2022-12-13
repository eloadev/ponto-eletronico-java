package dao;

import java.io.FileNotFoundException;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

import model.Funcionario;

public class FuncionarioDao {

	public static int addFuncionario(Funcionario funcionario) throws SQLException, FileNotFoundException { 
		int result = 0; 
		
	    Connection connect = ConnectionDao.connectDB(); 
	    
	    PreparedStatement preparedStatement 
	        = connect.prepareStatement( 
	            "INSERT INTO funcionario(nome, cpf, email, senha, departamento_id) VALUES (?,?,?,?,?)");
	    
	    preparedStatement.setString(1, funcionario.getNome());
	    preparedStatement.setString(2, funcionario.getCpf());
	    preparedStatement.setString(3, funcionario.getEmail());
	    preparedStatement.setString(4, funcionario.getSenha());
	    preparedStatement.setInt(5, funcionario.getDepartamento().getId());
	
	    result = preparedStatement.executeUpdate(); 
	    
	    connect.close();
	    preparedStatement.close();
	    
	    return result; 
	}
	
    public static int updateFuncionario(Funcionario funcionario) throws SQLException, FileNotFoundException { 
    	int result = 0; 
    	
	    Connection connect = ConnectionDao.connectDB(); 
	    
	    PreparedStatement preparedStatement 
	    	= connect.prepareStatement( 
	    			"UPDATE funcionario SET nome=?, cpf=?, email=?, senha=?, departamento_id=? WHERE funcionario_id=?"); 
	    
	    preparedStatement.setString(1, funcionario.getNome());
	    preparedStatement.setString(2, funcionario.getCpf());
	    preparedStatement.setString(3, funcionario.getEmail());
	    preparedStatement.setString(4, funcionario.getSenha());
	    preparedStatement.setInt(5, funcionario.getDepartamento().getId());
	    preparedStatement.setInt(6, funcionario.getId());
	    
	    result = preparedStatement.executeUpdate(); 
	    
	    connect.close();
	    preparedStatement.close();
	    
	    return result; 
    }
    
    public static int deleteFuncionario(int id) throws SQLException, FileNotFoundException { 
        int result = 0;
        
        Connection connect = ConnectionDao.connectDB(); 
        
        PreparedStatement preparedStatement 
            = connect.prepareStatement( 
                "DELETE FROM funcionario WHERE funcionario_id=?");
        
        preparedStatement.setInt(1, id); 
        
        result = preparedStatement.executeUpdate(); 

        connect.close();
        preparedStatement.close();
        
        return result; 
    } 

    public static List<Funcionario> getTodosFuncionarios() throws SQLException, FileNotFoundException { 
    	List<Funcionario> listaFuncionarios = new ArrayList<Funcionario>(); 

    	Connection connect = ConnectionDao.connectDB();
    	
    	PreparedStatement preparedStatement 
    		= connect.prepareStatement( 
    				"SELECT funcionario_id, nome, cpf, email, senha, departamento_id FROM funcionario");
    	
    	ResultSet resultSet 
    		= preparedStatement.executeQuery(); 

		while (resultSet.next()) { 
			Funcionario funcionario = new Funcionario(); 
			funcionario.setId(resultSet.getInt(1)); 
			funcionario.setNome(resultSet.getString(2));
			funcionario.setCpf(resultSet.getString(3));
			funcionario.setEmail(resultSet.getString(4)); 
			funcionario.setSenha(resultSet.getString(5));
			
			DepartamentoDao departamentoDao = new DepartamentoDao();
			
			funcionario.setDepartamento(departamentoDao.listarUm(resultSet.getInt("departamento_id")));
			
			listaFuncionarios.add(funcionario); 
		}
		
		connect.close();
		preparedStatement.close();
		
		return listaFuncionarios;
    }
    
	public Funcionario listarUm(int id) throws SQLException, FileNotFoundException {
	Connection con = ConnectionDao.connectDB();
	String sql = "SELECT funcionario_id, nome, cpf, email, senha, departamento_id FROM funcionario WHERE funcionario_id = ?";
	PreparedStatement stmt = con.prepareStatement(sql);
	stmt.setInt(1, id);
	ResultSet rs = stmt.executeQuery();
	
	Funcionario funcionario = null;
	
	if(rs.next()) {
		funcionario = new Funcionario();
		funcionario.setId(rs.getInt("funcionario_id"));
		funcionario.setNome(rs.getString("nome"));
		funcionario.setCpf(rs.getString("cpf"));
		funcionario.setEmail(rs.getString("email"));
		funcionario.setSenha(rs.getString("senha"));
		
		DepartamentoDao departamentoDao = new DepartamentoDao();
		funcionario.setDepartamento(departamentoDao.listarUm(rs.getInt("departamento_id")));
	}
	stmt.close();
	con.close();
	
	return funcionario;
	}
}
    