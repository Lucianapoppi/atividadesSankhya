package desafio2Aperfeicoado;

import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.StandardOpenOption;
import java.time.LocalDate;
import java.time.format.DateTimeFormatter;
import java.util.ArrayList;
import java.util.Scanner;

public class Principal {

	public static void main(String[] args) {

		// TODO Auto-generated method stub

		/*
		 * Desafio: Cadastro de turmas e estudantes
		 * 
		 * 1. No projeto de gestao escolar, apague todo o codigo existente ou comente-o;
		 * 2. Escrever um algoritmo para exibir um menu com as opcoes: a) Cadastrar
		 * turma; b) Cadastrar estudante; c) Listar turmas; d) Listar estudantes; e)
		 * sair.
		 * 
		 * 3. Ler do teclado a opcao escolhida; 4. Para cada opcao escolhida,
		 * implementar seu respectivo algoritmo e, no final, reexibir o menu; 5.
		 * 
		 * 
		 * OBSERVACAO: 1. Ao cadastrar turma, solicitar: a) Codigo; b) Nome; c)
		 * Capacidade.
		 * 
		 * 2. Ao cadastrar estudante, solicitar: a) Nome; b) Telefone; c) Endereço; d)
		 * Responsavel.
		 * 
		 * 
		 */

		try {
			var turmas = Path.of("turmas.csv");
			var estudantesPath = Path.of("estudantes.csv");
			var cursosPath = Path.of("C:/Users/lucia/OneDrive/Área de Trabalho/ProjetoLuSankhya/atividadesSankhya/treinandoJava/cursos.csv");
			
			if (!Files.exists(turmas)) {
				Files.createFile(turmas);
			}

			Scanner leitor = new Scanner(System.in);
			var opcaoDigitada = 0;

			boolean continuar = true;
			while (opcaoDigitada != 7) {

				System.out.println("1 - Cadastrar codigoCurso");
				System.out.println("2 - Cadastrar estudante");
				System.out.println("3 - Cadastrar turma");
				System.out.println("4 - Listar estudantes");
				System.out.println("5 - Listar turmas");
				System.out.println("6 - Listar curso");
				System.out.println("7 - sair");
				System.out.println("Digite o código da opção:");

				opcaoDigitada = Integer.parseInt(leitor.nextLine());
				if (opcaoDigitada == 1) {
					cadastrarCursos(leitor);

				} else if (opcaoDigitada == 2) {
					cadastrarEstudante(leitor);		
				
				}else if (opcaoDigitada == 3) {
						cadastrarTurma(leitor, turmas);

				} else if (opcaoDigitada == 4) {
					listarEstudantes(estudantesPath);
				
				} else if (opcaoDigitada == 5) {
					listarTurmas(turmas);
				
				} else if (opcaoDigitada == 6) {
					listarCursos(cursosPath);

				} else if (opcaoDigitada == 5) {
					System.out.println("Você escolheu sair.");

				} else {
					System.out.println("Opção inválida! Por favor, escolha uma opção válida.");
				}
			}

		} catch (IOException e) {
			System.out.println("Erro ao carregar o arquivo de turmas ou de estudantes!");
		}
	}

	private static void cadastrarTurma(Scanner leitor, Path arquivo) throws IOException {

		System.out.println("Você escolheu cadastrar uma turma.");
		
		System.out.println("Digite o codigoCurso:");
		var codigoCurso = leitor.nextLine();
		
		System.out.println("Digite o codigo da turma:");
		var codigoTurma = leitor.nextLine();
		
		System.out.println("Digite a data de início:(dd/MM/yyyy)");
		var dataInicio = LocalDate.parse(leitor.nextLine(), DateTimeFormatter.ofPattern("dd/MM/yyyy"));
		
		System.out.println("Digite a data final:(dd/MM/yyyy)");
		var dataFim = LocalDate.parse(leitor.nextLine(), DateTimeFormatter.ofPattern("dd/MM/yyyy"));
				
		System.out.println("Digite o período:(MATUTINO, VESPERTINO, NOTURNO, SABADOS)");
		var periodo = Periodo.valueOf(leitor.nextLine());
		
		var cadastro = new CadastroDeTurma();			

		try {
			cadastro.cadastrar(codigoCurso, codigoTurma, dataInicio, dataFim, periodo);
		} catch (IllegalArgumentException e) {
			System.out.println("Erro ao cadastrar turma: " + e.getMessage());
		}

	}

	private static void cadastrarEstudante(Scanner leitor) throws IOException {
		System.out.println("Você escolheu cadastrar um estudante.");

		System.out.println("Digite o nome do estudante:");
		String nomeEstudante = leitor.nextLine();

		System.out.println("Digite o numero do seu telefone:");
		String nroTelefone = leitor.nextLine();

		System.out.println("Digite o seu endereço:");
		String endEstudante = leitor.nextLine();

		System.out.println("Digite o número do cpf do estudante:");
		String cpf = leitor.nextLine();
		
		System.out.println("Digite o email do estudante:");
		String email = leitor.nextLine();

		var estudante = new Estudante(nomeEstudante, nroTelefone, endEstudante, cpf, email);

		var cadastro = new CadastroDeEstudante();

		try {
			cadastro.cadastrar(estudante);
		} catch (IllegalArgumentException e) {
			System.out.println("Erro ao cadastrar estudante: " + e.getMessage());
		}

	}
	
	private static void cadastrarCursos(Scanner leitor) throws IOException {
		System.out.println("Você escolheu cadastrar um curso.");

		System.out.println("Digite o código do curso:");
		String codigo = leitor.nextLine();

		System.out.println("Digite o nome do curso:");
		String nome = leitor.nextLine();

		System.out.println("Digite a carga horária do curso:");
		int cargaHoraria = Integer.parseInt(leitor.nextLine());

		System.out.println("Digite o nível do curso (BASICO, INTERMEDIARIO, AVANCADO)");
		String nivelEmString = leitor.nextLine();
		
		var nivel = Nivel.valueOf(nivelEmString);

		var curso = new Curso(codigo, nome, cargaHoraria, nivel);

		var cadastro = new CadastroDeCurso();

		try {
			cadastro.cadastrar(curso);
		} catch (IllegalArgumentException e) {
			System.out.println("Erro ao cadastrar curso: " + e.getMessage());
		}

	}

	private static void listarTurmas(Path arquivo) throws IOException {
		
		var linhas = Files.readAllLines(arquivo);

		for (var linha : linhas) {
			if(!linha.isEmpty()) {
				var campos = linha.split(",");
				System.out.println(campos[0] + " - " + campos[1] + " - " + campos[2]+ " - " + campos[3]);
			}
		
		}

	}

	private static void listarEstudantes(Path arquivo) throws IOException {
		var linhas = Files.readAllLines(arquivo);

		for (var linha : linhas) {
			if(!linha.isEmpty()) {
				var campos = linha.split(",");
				System.out.println(campos[0] + " - " + campos[1] + " - " + campos[2] + " - " + campos[3] + " - " + campos[3]+ " - " + campos[4]);
			}
		}
	
	}
	
	private static void listarCursos(Path arquivo) throws IOException {
		var linhas = Files.readAllLines(arquivo);
		//var cadastro = new CadastroDeCurso();
		//var cursosCadastrados = cadastro.listar();
		//for (var curso : cursosCadastrados) {
			for (var linha : linhas) {
				if(!linha.isEmpty()) {
					var campos = linha.split(",");								
					System.out.println(campos[0] + " - " + campos[1] + " - " + campos[2] + " - " + campos[3]);
				}
			//}
		}

	}

}
