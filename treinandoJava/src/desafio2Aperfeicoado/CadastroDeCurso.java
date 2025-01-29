package desafio2Aperfeicoado;

import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.StandardOpenOption;
import java.util.ArrayList;
import java.util.List;

public class CadastroDeCurso {
	private Path arquivo;

	Path cursosPath = Path.of("C:/Users/lucia/OneDrive/Área de Trabalho/ProjetoLuSankhya/atividadesSankhya/treinandoJava/cursos.csv");

	public CadastroDeCurso() {
		try {
			this.arquivo = Path.of("C:/Users/lucia/OneDrive/Área de Trabalho/ProjetoLuSankhya/atividadesSankhya/treinandoJava/cursos.csv");
			if (!Files.exists(arquivo)) {
				Files.createFile(arquivo);
			}
		} catch (Exception e) {
			throw new RuntimeException("Erro ao criar arquivo de cursos!");
		}
	}

	public void cadastrar(Curso curso) {
		if(curso.getNome().isBlank()) {
			throw new IllegalArgumentException("Campo nome é obrigatório");
		}
		
		if(curso.getCodigoCurso() == null) {
			throw new IllegalArgumentException("Campo código é obrigatório");
		}
		
		if(curso.getCargaHoraria()<= 0) {
			throw new IllegalArgumentException("Campo carga horária é obrigatório e deve ser > 0");
		}
		
		if(curso.getNivel() == null) {
			throw new IllegalArgumentException("Campo nível é obrigatório");
		}
	
			
		var cursosCadastrados = listar(cursosPath);
		if (cursosCadastrados.contains(curso)) {
			throw new IllegalArgumentException("Código já cadastrado");
		}
		
		try {
			Files.writeString(
					arquivo, 
					curso.getCodigoCurso() + "," + curso.getNome() + "," + curso.getCargaHoraria() + "," + curso.getNivel() + "\n", 
				 	StandardOpenOption.APPEND);
		}catch (Exception e) {
			throw new RuntimeException("Erro ao cadastrar curso no arquivo!");
		}
	}

	public List<Curso> listar(Path arquivo) {
	    var lista = new ArrayList<Curso>();

	    try {
	        if (Files.exists(arquivo) && Files.size(arquivo) > 0) {
	            var linhas = Files.readAllLines(arquivo);

	            for (var linha : linhas) {
	                linha = linha.trim(); // Remove espaços extras
	                if (linha.isEmpty()) {
	                    continue; // Ignorar linhas vazias
	                }

	                var campos = linha.split(",");
	                if (campos.length != 4) {
	                    System.out.println("Linha inválida ignorada: " + linha);
	                    continue; // Ignorar linhas inválidas
	                }
	                
	                try {
	                    var codigoCurso = campos[0].trim();
	                    var nomeCurso = campos[1].trim();
	                    var duracao = Integer.parseInt(campos[2].trim());
	                    var nivel = Nivel.valueOf(campos[3].trim());

	                    lista.add(new Curso(codigoCurso, nomeCurso, duracao, nivel));
	                } catch (Exception e) {
	                    System.out.println("Erro ao processar linha: " + linha);
	                }
	            }
	        }

	        return lista;
	    } catch (Exception e) {
	        throw new RuntimeException("Erro ao carregar curso do arquivo!", e);
	    }
	}


	public Curso carregarCursoPeloCodigo(String codigoCurso) {
	    System.out.println("chamando carregarCursosPeloCodigo");
	    var cursosCadastrados = listar(cursosPath);

	    if (cursosCadastrados.isEmpty()|| cursosCadastrados == null) {
	        System.out.println("Nenhum curso encontrado!");
	        return null;
	    }

	    System.out.println("Vou entrar na lista");

	    for (var cursoCadastrado : cursosCadastrados) {
	        System.out.println("codigo curso = " + cursoCadastrado.getCodigoCurso());
	        System.out.println("Comparando com: " + codigoCurso);
	        
	        if (cursoCadastrado.getCodigoCurso().trim().equalsIgnoreCase(codigoCurso.trim())) {
	            System.out.println("Curso encontrado!");
	            return cursoCadastrado;
	        }
	    }

	    System.out.println("Curso não encontrado!");
	    return null;
	}

}
