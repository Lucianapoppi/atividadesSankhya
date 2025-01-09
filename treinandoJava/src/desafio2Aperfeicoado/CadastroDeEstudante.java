package desafio2Aperfeicoado;

import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.StandardOpenOption;
import java.util.ArrayList;

public class CadastroDeEstudante {
	
	private Path arquivo;
	
	public CadastroDeEstudante() {
		try {
			var estudantes = Path.of("estudantes.csv");
			if(!Files.exists(estudantes)) {
				Files.createFile(estudantes);
			}
		}catch(Exception e) {
			System.out.println("Erro ao criar arquivo de estudantes!");
		}
	}
	
	public void cadastrar(Estudante estudante) {	
		try {
			Files.writeString(
					arquivo, 
					estudante.getNome() + "," + estudante.getTelefone() + "," + estudante.getEndereco() + "," + estudante.getResponsavel() +"\n", 
				 
					StandardOpenOption.APPEND);
		}catch (Exception e) {
			System.out.println("Erro ao cadastrar estudante no arquivo!");
		}
	}

	
	public ArrayList<Estudante> listar() {
		var lista = new ArrayList<Estudante>();
		
		try {
			var linhas = Files.readAllLines(arquivo);
			
			for(var linha : linhas) {
				var campos = linha.split(",");
				var estudante = new Estudante(campos[0],  campos[1], campos[2], campos[3]);
				lista.add(estudante);
			}
			
			return lista;
				
		}catch (Exception e) {
			System.out.println("Erro ao carregar estudante do arquivo!");
			return lista;
		}
		
		
	}
	
}
