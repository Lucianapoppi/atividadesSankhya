package desafio2Aperfeicoado;

import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.StandardOpenOption;
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
			if(!Files.exists(turmas)) {
				Files.createFile(turmas);
			}
			
			
			Scanner leitor = new Scanner(System.in);
			var opcaoDigitada = 0;
		
			boolean continuar = true;
			while (opcaoDigitada != 5) {
	
				System.out.println("1 - Cadastrar turma");
				System.out.println("2 - Cadastrar estudante");
				System.out.println("3 - Listar turmas");
				System.out.println("4 - Listar estudantes");
				System.out.println("5 - sair");
				System.out.println("Digite o código da opção:");
	
				opcaoDigitada = Integer.parseInt(leitor.nextLine());
				if (opcaoDigitada == 1) {
					cadastrarTurma(leitor, turmas);
	
				} else if (opcaoDigitada == 2) {
					cadastrarEstudante(leitor);
	
				} else if (opcaoDigitada == 3) {
					listarTurmas(turmas);
	
				} else if (opcaoDigitada == 4) {
					listarEstudantes();
	
				} else if (opcaoDigitada == 5) {
					System.out.println("Você escolheu sair.");
	
				} else {
					System.out.println("Opção inválida! Por favor, escolha uma opção válida.");
				}
			}

		}catch (IOException e) {
			System.out.println("Erro ao carregar o arquivo de turmas ou de estudantes!");
		}
	}

	private static void cadastrarTurma(Scanner leitor, Path arquivo) throws IOException {
		
		System.out.println("Você escolheu cadastrar uma turma.");

		System.out.println("Digite o codigo da turma:");
		var codigoTurma = leitor.nextLine();

		System.out.println("Digite o nome da turma:");
		var nomeTurma = leitor.nextLine();

		System.out.println("Digite a capacidade da turma:");
		var capacidadeTurma = Integer.parseInt(leitor.nextLine());

		var turma = new Turma(codigoTurma, nomeTurma, capacidadeTurma);

		Files.writeString(
				arquivo, 
				turma.getCodigo() + "," + turma.getNome() + "," + turma.getCapacidade() +"\n",
				StandardOpenOption.APPEND);
		
	}

	private static void	cadastrarEstudante(Scanner leitor) throws IOException{	
		System.out.println("Você escolheu cadastrar um estudante.");
		
		System.out.println("Digite o nome do estudante:");
		String nomeEstudante = leitor.nextLine();
		
		System.out.println("Digite o numero do seu telefone:");
		String nroTelefone = leitor.nextLine();
		
		System.out.println("Digite o seu endereço:");
		String endEstudante = leitor.nextLine();
		
		System.out.println("Digite o nome do responsável do estudante:");
		String nomeResponsavel = leitor.nextLine();
		
		var estudante = new Estudante(nomeEstudante, nroTelefone, endEstudante, nomeResponsavel);
		
		var cadastro = new CadastroDeEstudante();
		cadastro.cadastrar(estudante);
 			
		}

	
	private static void listarTurmas(Path arquivo) throws IOException{
		var linhas = Files.readAllLines(arquivo);
				
		for(var linha : linhas) {
			var campos = linha.split(",");
			System.out.println(campos[0] + " - " + campos[1] + " - " + campos[2]);
		}
			
	}
	

	private static void listarEstudantes() throws IOException{
		var cadastro = new CadastroDeEstudante();
		var estudantesCadastrados = cadastro.listar();
		for (var estudante:estudantesCadastrados) {
			System.out.println(estudante.getNome() + " - " +estudante.getTelefone() + " - " +estudante.getEndereco() + " - " +estudante.getResponsavel());
		}

	}
	
	
	
}
