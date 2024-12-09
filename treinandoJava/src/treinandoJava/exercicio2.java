package treinandoJava;

import java.util.Scanner;

public class exercicio2 {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		System.out.println("Praticando Java!");

		// Scanner que lerá o teclado
		var leitor = new Scanner(System.in);

		System.out.println("Digite o nome do estudante: ");
		var nome = leitor.nextLine();

		System.out.println("Digite a idade do estudante: ");
		var idade = leitor.nextInt();

		System.out.println("Digite a nota 1 do estudante: ");
		var nota1 = leitor.nextDouble();

		System.out.println("Digite a nota 2 do estudante: ");
		var nota2 = leitor.nextDouble();

		System.out.println("Digite a nota 3 do estudante: ");
		var nota3 = leitor.nextDouble();

		var media = (nota1 + nota2 + nota3) / 3;

		System.out.println("A média do estudante: " + media);

		if (media >= 7.0) {
			System.out.println("O estudante está aprovado!");
		} else {
			System.out.println("O estudante está reprovado!");
		}

	}

}
