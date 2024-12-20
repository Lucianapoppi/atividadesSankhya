package desafio2;

public class Turma {

	private int codigo;
	private String nome;
	private int capacidade;
	
	
	public Turma(int codigo, String nome, int capacidade) {
		this.codigo = codigo;
		this.nome = nome;
		this.capacidade = capacidade;
	}
		
		
	

	public int getCodigo() {
		return codigo;
	}


	public void setCodigo(int codigo) {
		this.codigo = codigo;
	}


	public String getNome() {
		return nome;
	}


	public void setNome(String nome) {
		this.nome = nome;
	}


	public int getCapacidade() {
		return capacidade;
	}


	public void setCapacidade(int capacidade) {
		this.capacidade = capacidade;
	}
}
