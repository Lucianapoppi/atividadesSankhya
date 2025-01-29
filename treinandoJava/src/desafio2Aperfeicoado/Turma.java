package desafio2Aperfeicoado;

import java.time.LocalDate;
import java.util.Objects;

public class Turma {

		private String codigoTurma;
		private String curso;
		private LocalDate dataInicio;
		private LocalDate dataFim;
		private Periodo periodo;
		
		
		
		public Turma(String codigoTurma, String curso, LocalDate dataInicio, LocalDate dataFim, Periodo periodo) {
			this.codigoTurma = codigoTurma;
			this.curso = curso;
			this.dataInicio = dataInicio;
			this.dataFim = dataFim;
			this.periodo = periodo;			
		}
		

		@Override
		public int hashCode() {
			return Objects.hash(codigoTurma);
		}

		
		@Override
		public boolean equals(Object obj) {
			if (this == obj)
				return true;
			if (obj == null)
				return false;
			if (getClass() != obj.getClass())
				return false;
			Turma other = (Turma) obj;
			return Objects.equals(codigoTurma, other.codigoTurma);
		}

		public String getCodigoTurma() {
			return codigoTurma;
		}

		public void setCodigoTurma(String codigo) {
			this.codigoTurma = codigo;
		}


		public String getCurso() {
			return curso;
		}


		public void setCurso(String curso) {
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


		public Periodo getPeriodo() {
			return periodo;
		}


		public void setPeriodo(Periodo periodo) {
			this.periodo = periodo;
		}

}

	

