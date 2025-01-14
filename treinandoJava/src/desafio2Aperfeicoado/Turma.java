package desafio2Aperfeicoado;

import java.time.LocalDate;

public class Turma {

		private String codigoTurma;
		private Curso curso;
		private LocalDate dataInicio;
		private LocalDate dataFim;
		
		
		public Turma(String codigo, Curso curso, LocalDate dataInicio, LocalDate dataFim) {
			this.codigoTurma = codigo;
			this.curso = curso;
			this.dataInicio = dataInicio;
			this.dataFim = dataFim;
			
		}
								

		public String getCodigo() {
			return codigoTurma;
		}


		public void setCodigo(String codigo) {
			this.codigoTurma = codigo;
		}


		public Curso getCurso() {
			return curso;
		}


		public void setCurso(Curso curso) {
			this.curso = curso;
		}


		public LocalDate getDataInicio() {
			return dataInicio;
		}


		public void setDataInicio(LocalDate dataInicio) {
			this.dataInicio = dataInicio;
		}


		public LocalDate getDataFim() {
			return dataFim;
		}


		public void setDataFim(LocalDate dataFim) {
			this.dataFim = dataFim;
		}

}

	

