package model;

public class Ponto {
	private int ponto_id;
	private String data;
	private String hora;
	private Funcionario funcionario;

	public int getId() { return ponto_id; }
	public void setId(int ponto_id) { this.ponto_id = ponto_id; }
	
	public String getData() { return data; }
	public void setData(String data) { this.data = data; }
	
	public String getHora() { return hora; }
	public void setHora(String hora) { this.hora = hora; }
	
	public Funcionario getFuncionario() { return funcionario; }
	public void setFuncionario(Funcionario funcionario) { this.funcionario = funcionario; }
}
