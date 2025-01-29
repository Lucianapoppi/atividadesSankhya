package desafio2Aperfeicoado;

public enum Nivel {

	BASICO("Básico"),
	INTERMEDIARIO("Intermediário"),
	AVANCADO("Avançado");
	
	private String nome;
	
	Nivel(String nome){
		this.nome = nome;
	}
	
	public String getNome() {
		return nome;
	}
}
