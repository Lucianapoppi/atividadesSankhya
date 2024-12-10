package treinandoJava;

import java.util.Random;
import java.util.Scanner;

public class desafio1 {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		/*
		 * Desafio: Projeto caixa eletronico 1. Crie um novo projeto; 2. Crie uma classe
		 * com o método main; 3. Escreva um algoritmo que simula a funcionalidade de
		 * saque: a)A pessoa informa o nome e o valor a ser sacado; b) O sistema exibe
		 * se o saque pode ou não se realizado de acordo com as regras de negócios.
		 * 
		 * Regras de negócio: 1. Valor máximo que pode ser sacado é de R$1000; 2. Valor
		 * mínimo que pode ser sacado é de R$10; 3. Caixa eletrônico somente possui
		 * cédulas de R$10, R$20, R$50 e R$100; 4. Valor do saque não deve ultrapassar o
		 * saldo da conta; 5. Caso o saque possa ser realizado, exibir a mensagem:
		 * "Olá NOME! O saque de VALOR foi realizado com sucesso!" 6. Caso o saque não
		 * possa ser realizado, exibir a mensagem: "Ola, NOME! O saque de VALOR não pode
		 * ser realizado porque o valor máximo para retirada é de R$1000.
		 * 
		 */

		var leitor = new Scanner(System.in);

		System.out.println("Digite seu nome");
		var nome = leitor.nextLine();

		System.out.println(
				"Qual valor deseja retirar entre R$10 e R$1000? Essa máquina só possui notas de R$10, R$20, R$50 e R$100 disponíveis.");
		var valor = leitor.nextInt();

		Random numeroAleatorio = new Random();

		var saldo = numeroAleatorio.nextInt(10001);
		
		if (saldo > valor) {

			if (valor > 10 && valor % 10 == 0) {

				if (valor > 1000) {
					System.out.println("O valor máximo para retirada é de R$1000");

				} else {

					var quantidadeNotas100 = 0;
					var quantidadeNotas50 = 0;
					var quantidadeNotas20 = 0;
					var quantidadeNotas10 = 0;
					var valorDesejado = valor;

					if (valorDesejado >= 100) {
						quantidadeNotas100 = (int) Math.floor(valorDesejado / 100);
						valorDesejado = valorDesejado - (quantidadeNotas100 * 100);

					}
					if (valorDesejado >= 50 && valorDesejado < 100) {
						quantidadeNotas50 = (int) Math.floor(valorDesejado / 50);
						valorDesejado = valorDesejado - (quantidadeNotas50 * 50);

					}
					if (valorDesejado >= 20 && valorDesejado < 50) {
						quantidadeNotas20 = (int) Math.floor(valorDesejado / 20);
						valorDesejado = valorDesejado - (quantidadeNotas20 * 20);

					}
					if (valorDesejado >= 10 && valorDesejado < 20) {
						quantidadeNotas10 = (int) Math.floor(valorDesejado / 10);
						valorDesejado = valorDesejado - (quantidadeNotas10 * 10);

					}

					System.out.println("Olá, " + nome + "! " + "O seu saldo é de R$" +saldo + " e o saque de R$ " + valor + " foi realizado com sucesso!");

					System.out.println("O saque contém " + quantidadeNotas100 + " notas de 100, " + quantidadeNotas50
							+ " notas de 50, " + quantidadeNotas20 + " notas de 20 e " + quantidadeNotas10
							+ " notas de 10.");

				}

				var valor100 = Math.round(valor / 100);

			} else {
				System.out.println("Olá, " + nome + "! " + "O seu saldo é de R$" +saldo +  " e o saque de R$" + valor
						+ " não pode ser realizado, pois essa máquina só possui notas de R$10, R$20, R$50 e R$100 disponíveis.");
			}

		}else {
			System.out.println("Saldo insuficiente.");
		}
		
	}

}
