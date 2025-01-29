package desafio2Aperfeicoado;

import java.util.Objects;

public class Curso {

	private String codigoCurso;
	private String nome;
	private int cargaHoraria;
	private Nivel nivel;
	
	
	public Curso(String codigoCurso, String nome, int cargaHoraria, Nivel nivel) {
		this.codigoCurso = codigoCurso;
		this.nome = nome;
		this.cargaHoraria = cargaHoraria;
		this.nivel = nivel;
	}
	
	
	@Override
	public boolean equals(Object o) {
		if (this == o)
			return true;
		if (o == null || getClass() != o.getClass()) return false;
			
		Curso curso = (Curso) o;
		return Objects.equals(codigoCurso.toLowerCase(), curso.codigoCurso.toLowerCase());
	}


	@Override
	public int hashCode() {return Objects.hash(codigoCurso);}
	
	public String getCodigoCurso() {return codigoCurso;}
	
	public String getNome() {return nome;}
	
	public int getCargaHoraria() {return cargaHoraria;}
	
	public Nivel getNivel() {return nivel;	}
}
