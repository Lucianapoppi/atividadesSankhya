package desafio2Aperfeicoado;
import java.util.Scanner;

public class TesteErros {

	public static void main(String[] args) {
		// TODO Auto-generated method stub

		System.out.println("Boas vindas ao sistema!");
		
		var scanner = new Scanner(System.in);
		
		System.out.println("Digite o primeiro valor: ");
		var valor1 = Integer.parseInt(scanner.nextLine());
		
		System.out.println("Digite o segundo valor: ");
		var valor2 = Integer.parseInt(scanner.nextLine());
		
		try {
		 var resultado = calcular(valor1, valor2);
		
		System.out.println("Resultado da divisão: " +resultado);
		System.out.println("Saindo do programa!");
		
		}catch(Exception exception) {
			System.out.println("Cálculo falhou!");
			
		}
	}
				
		
	private static int calcular(int valor1, int valor2) {
			System.out.println("Iniciando calculo da divisão");
			var resultado = dividir(valor1, valor2);
			System.out.println("Cálculo efetuado");
			return resultado;
	}
	
	
	private static int dividir(int valor1, int valor2) {
		System.out.println("Calculando divisão");
		var resultado = valor1 / valor2;
		System.out.println("divisão efetuada");
		return resultado;		
				
	}

}
