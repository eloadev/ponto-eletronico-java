package model;

public class Administrador {
	private int administrador_id;
	private String nome;
	private String email;
	private String senha;
	
	public int getId() { return administrador_id; }
	public void setId(int administrador_id) { this.administrador_id = administrador_id; }
	
	public String getNome() { return nome; }
	public void setNome(String nome) { this.nome = nome; }
	
	public String getEmail() { return email; }
	public void setEmail(String email) { this.email = email; }
	
	public String getSenha() { return senha; }
	public void setSenha(String senha) { this.senha = senha; }
}
