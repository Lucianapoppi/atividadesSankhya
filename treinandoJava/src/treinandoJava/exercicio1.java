package treinandoJava;

import java.util.Scanner;

public class exercicio1 {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		System.out.println("Praticando Java!");

		// Scanner que lerá o teclado
		var leitor = new Scanner(System.in);

		System.out.println("Digite o nome do estudante: ");
		var nome = leitor.nextLine();

		System.out.println("Digite a idade do estudante: ");
		var idade = leitor.nextInt();

		System.out.println("Digite a nota do estudante: ");
		var nota = leitor.nextDouble();

		System.out.println("O nome do estudante digitado: " + nome);
		System.out.println("A idade do estudante digitada: " + idade);
		System.out.println("A nota do estudante digitada: " + nota);

	}

}
