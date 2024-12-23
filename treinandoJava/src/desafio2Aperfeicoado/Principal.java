package desafio2Aperfeicoado;

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

			var leitor = new Scanner(System.in);
			var opcaoDigitada = 0;
			
			var estudantes = new ArrayList<Estudante>();
			var turmas = new ArrayList<Turma>();

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
					cadastrarEstudante(leitor, estudantes);								
										
						
				} else if (opcaoDigitada == 3) {
					listarTurmas(turmas);					
									
									

				} else if (opcaoDigitada == 4) {
					listarEstudantes(estudantes);
										
					

				} else if (opcaoDigitada == 5) {
					System.out.println("Você escolheu sair.");
					
									
				} else {
					System.out.println("Opção inválida! Por favor, escolha uma opção válida.");
				}

			}
		}

		private static void cadastrarTurma(Scanner leitor, ArrayList<Turma> turmas){
			System.out.println("Você escolheu cadastrar uma turma.");
			
			System.out.println("Digite o codigo da turma:");									
			var codigoTurma = leitor.nextLine();
			
			System.out.println("Digite o nome da turma:");
			var nomeTurma = leitor.nextLine();
			
			System.out.println("Digite a capacidade da turma:");
			var capacidadeTurma = Integer.parseInt(leitor.nextLine());
								
			var turma = new Turma(codigoTurma, nomeTurma, capacidadeTurma);									
														
			turmas.add(turma);
		}
				
				
		private static void	cadastrarEstudante(Scanner leitor, ArrayList<Estudante> estudantes){	
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

		estudantes.add(estudante);
			
		}
		
		private static void	listarTurmas(ArrayList<Turma> turmas){
			System.out.println("Você escolheu listar as turmas.");
			
			for(int i = 0; i < turmas.size(); i++) {
				System.out.println("turma:  "+ turmas.get(i).getCodigo() + ", " + turmas.get(i).getNome() + ", " + turmas.get(i).getCapacidade());
				
			}
		}
		
		
		private static void listarEstudantes(ArrayList<Estudante> estudantes){

			
			System.out.println("Você escolheu listar os estudantes.");
			
			for(int i = 0; i<estudantes.size(); i++) {
				System.out.println("estudantes:  "+ estudantes.get(i).getNome() + ", " + estudantes.get(i).getTelefone() + ", " + estudantes.get(i).getEndereco()+ ", " + estudantes.get(i).getResponsavel());
				
			}
		}
		
}
	
	

