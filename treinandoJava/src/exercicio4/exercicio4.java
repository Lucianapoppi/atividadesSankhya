package exercicio4;

import java.util.Scanner;

public class exercicio4 {

	public static void main(String[] args) {
		System.out.println("Cadastro de estudante");
		var leitor = new Scanner(System.in);

		System.out.println("Digite o numero de estudantes que deseja cadastrar");
		var qtdEstudantes = Integer.parseInt(leitor.nextLine());
		var estudantes = new Estudante[20];

		int qtdCadastrados = 0;
		while (qtdCadastrados != qtdEstudantes) {
			var estudante = new Estudante();

			System.out.println("Digite o nome do estudante");
			estudante.nome = leitor.nextLine();

			System.out.println("Digite o telefone do estudante");
			estudante.telefone = leitor.nextLine();

			System.out.println("Digite o endereco do estudante");
			estudante.endereco = leitor.nextLine();

			System.out.println("Digite o nome do responsavel do estudante");
			estudante.responsavel = leitor.nextLine();

			estudantes[qtdCadastrados] = estudante;
			qtdCadastrados++;

		}

		for (Estudante e : estudantes) {
			System.out.println("Nome: " + e.nome);
			System.out.println("Telefone: " + e.telefone);
			System.out.println("Endereco: " + e.endereco);
			System.out.println("Responsavel: " + e.responsavel);
		}

		/*
		 * var estudante1 = new Estudante(); var estudante2 = new Estudante();
		 * 
		 * var turma1 = new Turma(); var turma2 = new Turma();
		 * 
		 * 
		 * estudante1.nome = "Luciana"; estudante1.telefone = "123456";
		 * estudante1.endereco = "Rua x";
		 * 
		 * estudante2.nome = "Maria"; estudante2.telefone = "1234567";
		 * estudante2.endereco = "Rua y";
		 * 
		 * turma1.codigo = "A"; turma1.finalizada = false;
		 * 
		 * turma1.codigo = "B"; turma1.finalizada = false;
		 * 
		 * System.out.println(estudante1.nome); System.out.println(estudante2.telefone);
		 * System.out.println(estudante2.endereco); System.out.println(turma1.codigo);
		 */

		// TODO Auto-generated method stub
		/*
		 * System.out.println("Praticando Java!");
		 * 
		 * // Scanner que lerá o teclado var leitor = new Scanner(System.in);
		 * 
		 * System.out.println("Digite o nome do estudante: "); var nome =
		 * leitor.nextLine();
		 * 
		 * System.out.println("Digite a idade do estudante: "); var idade =
		 * leitor.nextInt();
		 * 
		 * var opcao = 0; var somatorio = 0.0; //quantidadeNotas++; var quantidadeNotas
		 * = 0; var tirouZero = false;
		 * 
		 * while (opcao != -1) { System.out.println("Digite a nota do estudante: "); var
		 * nota = leitor.nextDouble();
		 * 
		 * if (nota == 0) { tirouZero = true; }
		 * 
		 * //somatorio = somatorio + nota somatorio += nota;
		 * 
		 * //quantidadeNotas +=1; quantidadeNotas++;
		 * 
		 * System.out.
		 * println("Deseja informar outra nota? (Digite -1 caso não queira digitar mais notas)"
		 * ); opcao = leitor.nextInt(); }
		 * 
		 * var media = somatorio / quantidadeNotas; System.out.println(media);
		 * System.out.println("Média do estudante: " + media);
		 * 
		 * if (media >= 7.0 && !tirouZero) {
		 * System.out.println("O estudante está aprovado!"); } else {
		 * System.out.println("O estudante está reprovado!"); }
		 */
	}

}
