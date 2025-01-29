package desafio2Aperfeicoado;

import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.StandardOpenOption;
import java.time.LocalDate;
import java.time.format.DateTimeFormatter;
import java.util.ArrayList;
import java.util.List;

public class CadastroDeTurma {
	
	Path turmasPath = Path.of("turmas.csv");
	
	private Path arquivo;
	
	public CadastroDeTurma() {
		
		try {
			this.arquivo = Path.of("turmas.csv");
			if(!Files.exists(arquivo)) {
				Files.createFile(arquivo);
			}
		}catch(Exception e) {
			throw new IllegalArgumentException("Erro ao criar arquivo de turmas!");			
		}
	}
	
	public void cadastrar(String codigoCurso, String codigoTurma, LocalDate dataInicio, LocalDate dataFim, Periodo periodo) {
		if(codigoTurma.isBlank()) {
			throw new IllegalArgumentException("Campo códigoTurma é obrigatório");
		}
		
		if(codigoCurso.isBlank()) {
			throw new IllegalArgumentException("Campo curso é obrigatório");
		}
		
		if(dataInicio == null) {
			throw new IllegalArgumentException("Campo dataInicio é obrigatório");
		}
		
		if(dataFim == null) {
			throw new IllegalArgumentException("Campo dataFim é obrigatório");
		}
		
		if(periodo == null) {
			throw new IllegalArgumentException("Campo periodo é obrigatório");
		}
		
		var turmasCadastradas = listar(turmasPath);
		for (var t : turmasCadastradas) {
			if (t.getCodigoTurma().equals(codigoTurma)) {
				throw new IllegalArgumentException("Código da Turma já cadastrado!");
			}			
		}
		
		var cadastroDeCursos = new CadastroDeCurso();
		var curso = cadastroDeCursos.carregarCursoPeloCodigo(codigoCurso);
		if (curso == null) {
			throw new IllegalArgumentException("Código do curso inexistente!");
		}
		
		var mascaraData = DateTimeFormatter.ofPattern("dd/MM/yyyy");
		
		try {
			Files.writeString(
					arquivo, 
					codigoTurma + "," + curso.getCodigoCurso() + "," + dataInicio.format(mascaraData) + "," + dataFim.format(mascaraData) +"," + periodo + "\n", 
				 
					StandardOpenOption.APPEND);
		}catch (Exception e) {
			System.out.println("Erro ao cadastrar turma no arquivo!");
		}
	}

	
	public List<Turma> listar(Path arquivo) {
		var lista = new ArrayList<Turma>();
		
		var mascaraData = DateTimeFormatter.ofPattern("dd/MM/yyyy");
				
		try {
			var linhas = Files.readAllLines(arquivo);
			
			for(var linha : linhas) {
				var campos = linha.split(",");
				if (campos.length != 5) {
                    continue;
                }

				Turma turma = new Turma(campos[0], campos[1], LocalDate.parse(campos[2], mascaraData), LocalDate.parse(campos[3], mascaraData), Periodo.valueOf(campos[4]));
				
				lista.add(turma);
			}
			
			return lista;
				
		}catch (Exception e) {
			throw new IllegalArgumentException("Erro ao carregar turma do arquivo!");
		}
		
		
	}
	
}
