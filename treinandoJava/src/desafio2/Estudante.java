package desafio2;

public class Estudante {

	private String nome;
	private String telefone;
	private String endereco;
	private String responsavel;
	
	
	public Estudante(String nome, String telefone, String endereco, String responsavel) {
		this.nome = nome;
		this.telefone = telefone;
		this.endereco = endereco;
		this.responsavel = responsavel;
	}


	public String getNome() {
		return nome;
	}


	public void setNome(String nome) {
		this.nome = nome;
	}


	public String getTelefone() {
		return telefone;
	}


	public void setTelefone(String telefone) {
		this.telefone = telefone;
	}


	public String getEndereco() {
		return endereco;
	}


	public void setEndereco(String endereco) {
		this.endereco = endereco;
	}


	public String getResponsavel() {
		return responsavel;
	}


	public void setResponsavel(String responsavel) {
		this.responsavel = responsavel;
	}
	
	
		
		
		
	
	
}
