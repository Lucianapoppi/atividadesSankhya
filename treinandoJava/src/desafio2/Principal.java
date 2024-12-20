package desafio2;

import java.util.ArrayList;
import java.util.Scanner;

import banco.Conta;

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

		Scanner leitor = new Scanner(System.in);
		
		var listaEstudantes = new ArrayList<Estudante>();
		var listaTurmas = new ArrayList<Turma>();

		boolean continuar = true;
		while (continuar = true) {

			System.out.println("1 - Cadastrar turma");
			System.out.println("2 - Cadastrar estudante");
			System.out.println("3 - Listar turmas");
			System.out.println("4 - Listar estudantes");
			System.out.println("5 - sair");

			System.out.println("Digite o código da opção:");
			int codigo = leitor.nextInt();
			leitor.nextLine();

			if (codigo == 1) {
				System.out.println("Você escolheu cadastrar uma turma.");
				
					System.out.println("Digite o codigo da turma:");
					int codigoTurma = leitor.nextInt();
					leitor.nextLine();
					
					System.out.println("Digite o nome da turma:");
					String nomeTurma = leitor.nextLine();
				
					System.out.println("Digite a capacidade da turma:");
					int capacidadeTurma = leitor.nextInt();
				
					Turma turma = new Turma(codigoTurma, nomeTurma, capacidadeTurma);

					listaTurmas.add(turma);
				

			} else if (codigo == 2) {
				System.out.println("Você escolheu cadastrar um estudante.");

				
					System.out.println("Digite o nome do estudante:");
					String nomeEstudante = leitor.nextLine();
					
					System.out.println("Digite o numero do seu telefone:");
					String nroTelefone = leitor.nextLine();
					
					System.out.println("Digite o seu endereço:");
					String endEstudante = leitor.nextLine();
					
					System.out.println("Digite o nome do responsável do estudante:");
					String nomeResponsavel = leitor.nextLine();
					
					Estudante estudante = new Estudante(nomeEstudante, nroTelefone, endEstudante, nomeResponsavel);

					listaEstudantes.add(estudante);
					
					
			} else if (codigo == 3) {
				System.out.println("Você escolheu listar as turmas.");
				
					for(int i = 0; i<listaTurmas.size(); i++) {
						System.out.println("turma:  "+ listaTurmas.get(i).getCodigo() + ", " + listaTurmas.get(i).getNome() + ", " + listaTurmas.get(i).getCapacidade());
						
					}
				
				
				
				
				

			} else if (codigo == 4) {
				System.out.println("Você escolheu listar os estudantes.");
				
				
				
				
				
				
				
				

			} else if (codigo == 5) {
				System.out.println("Você escolheu sair.");
				
				
				
				
				
			} else {
				System.out.println("Opção inválida! Escolha uma opção válida.");
			}

		}
	}

}