package desafio2Aperfeicoado;

public class Turma {

		private String codigoTurma;
		private String nomeTurma;
		private int capacidadeTurma;
		
		
		public Turma(String codigo, String nome, int capacidade) {
			this.codigoTurma = codigo;
			this.nomeTurma = nome;
			this.capacidadeTurma = capacidade;
		}
			
					

		public String getCodigo() {
			return codigoTurma;
		}


		public void setCodigo(String codigo) {
			this.codigoTurma = codigo;
		}


		public String getNome() {
			return nomeTurma;
		}


		public void setNome(String nome) {
			this.nomeTurma = nome;
		}


		public int getCapacidade() {
			return capacidadeTurma;
		}


		public void setCapacidade(int capacidade) {
			this.capacidadeTurma = capacidade;
		}
}

	

