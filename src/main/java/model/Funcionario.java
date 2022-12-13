package model;

public class Funcionario {
	private int funcionario_id;
	private String nome;
	private String cpf;
	private String email;
	private String senha;
	private Departamento departamento;
	
	public int getId() { return funcionario_id; }
	public void setId(int funcionario_id) { this.funcionario_id = funcionario_id; }
	
	public String getNome() { return nome; }
	public void setNome(String nome) { this.nome = nome; }
	
	public String getCpf() { return cpf; }
	public void setCpf(String cpf) { this.cpf = cpf; }
	
	public String getEmail() { return email; }
	public void setEmail(String email) { this.email = email; }
	
	public String getSenha() { return senha; }
	public void setSenha(String senha) { this.senha = senha; }
	
	public Departamento getDepartamento() { return departamento; }
	public void setDepartamento(Departamento departamento) { this.departamento = departamento; }
}
