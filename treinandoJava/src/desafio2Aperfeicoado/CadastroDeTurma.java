package desafio2Aperfeicoado;

import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.StandardOpenOption;
import java.util.ArrayList;

public class CadastroDeTurma {
	
	private Path arquivo;
	
	public CadastroDeTurma() {
		try {
			this.arquivo = Path.of("turmas.csv");
			if(!Files.exists(arquivo)) {
				Files.createFile(arquivo);
			}
		}catch(Exception e) {
			System.out.println("Erro ao criar arquivo de turmas!");
		}
	}
	
	public void cadastrar(Turma turma) {
		if(turma.getCodigo().isBlank()) {
			throw new IllegalArgumentException("Campo código é obrigatório");
		}
		try {
			Files.writeString(
					arquivo, 
					turma.getCodigo() + "," + turma.getNome() + "," + turma.getCapacidade() +"\n", 
				 
					StandardOpenOption.APPEND);
		}catch (Exception e) {
			System.out.println("Erro ao cadastrar turma no arquivo!");
		}
	}

	
	public ArrayList<Turma> listar() {
		var lista = new ArrayList<Turma>();
		
		try {
			var linhas = Files.readAllLines(arquivo);
			
			for(var linha : linhas) {
				var campos = linha.split(",");
				var turma = new Turma(campos[0], campos[1], Integer.parseInt(campos[2]));
				lista.add(turma);
			}
			
			return lista;
				
		}catch (Exception e) {
			System.out.println("Erro ao carregar turma do arquivo!");
			return lista;
		}
		
		
	}
	
}
