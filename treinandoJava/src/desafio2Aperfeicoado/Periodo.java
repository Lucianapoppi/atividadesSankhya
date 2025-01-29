package desafio2Aperfeicoado;

public enum Periodo {

	MATUTINO("Matutino"),
	VESPERTINO("Vespertino"),
	NOTURNO("Noturno"),
	SABADOS("Sabado");
	
	private final String nome;
	
	private Periodo(String nome) {
		this.nome = nome;		
	}

	public String getNome() {
		return nome;
	}
	
}


