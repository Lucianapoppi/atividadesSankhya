package desafio2Aperfeicoado;

import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.StandardOpenOption;
import java.util.ArrayList;
import java.util.List;

public class CadastroDeEstudante {
	
	Path estudantesPath = Path.of("estudantes.csv");
	
	private Path arquivo;
	
	public CadastroDeEstudante() {
		try {
			this.arquivo = Path.of("estudantes.csv");
			if(!Files.exists(arquivo)) {
				Files.createFile(arquivo);
			}
		}catch(Exception e) {
			throw new RuntimeException("Erro ao criar arquivo de estudantes!");
		}
	}
	
	public void cadastrar(Estudante estudante) {
		if(estudante.getNome().isBlank()) {
			throw new IllegalArgumentException("Campo nome é obrigatório");
		}
		
		if(estudante.getCpf().isBlank()) {
			throw new IllegalArgumentException("Campo cpf é obrigatório");
		}
		
		if(estudante.getEmail().isBlank()) {
			throw new IllegalArgumentException("Campo email é obrigatório");
		}
		
		if(estudante.getTelefone().isBlank()) {
			throw new IllegalArgumentException("Campo telefone é obrigatório");
		}
		
		if(estudante.getEndereco().isBlank()) {
			throw new IllegalArgumentException("Campo endereço é obrigatório");
		}
		
		var estudantesCadastrados = listar(estudantesPath);
		for (var e : estudantesCadastrados) {
			if (e.getCpf().equals(estudante.getCpf())) {
				throw new IllegalArgumentException("Cpf já cadastrado!");
			}
			
			if (e.getEmail().equals(estudante.getEmail())) {
				throw new IllegalArgumentException("Email já cadastrado!");
			}
		}
				
		try {
			Files.writeString(
					arquivo, 
					estudante.getNome() + "," + estudante.getTelefone() + "," + estudante.getEndereco() + "," + estudante.getCpf() + "," + estudante.getEmail() + "\n", 
				 
					StandardOpenOption.APPEND);
		}catch (Exception e) {
			throw new RuntimeException("Erro ao cadastrar estudante no arquivo!");
		}
	}

	
	public List<Estudante> listar(Path arquivo) {
	    var lista = new ArrayList<Estudante>();

	    try {
	           var linhas = Files.readAllLines(arquivo);

	           for (var linha : linhas) {
	               var campos = linha.split(",");
	               if (campos.length != 5) {
	                    continue;
	               }
	               var estudante = new Estudante(campos[0], campos[1], campos[2], campos[3], campos[4]);
	               lista.add(estudante);
	           }
	        

	        return lista;

	    } catch (Exception e) {
	        throw new RuntimeException("Erro ao carregar estudantes do arquivo!", e);
	    }
	}

	
}
