package banco;

import java.util.Scanner;

public class Principal {

	public static void main(String[] args) {

		Conta conta1 = new Conta("12345", 25, "Lu", 1000);
		//conta1.depositar(1000);
		//conta1.setNumero("12345");
		//conta1.setAgencia(25);
		//conta1.setTitular("Lu");
		
		Scanner leitor = new Scanner(System.in);
		
		System.out.println("Digite o valor a sacar:");
		double valor = Double.parseDouble(leitor.nextLine());
		
		boolean sacou = conta1.sacar(valor);
		if (sacou) {
			System.out.println("Saque realizado com sucesso!");
		}else {
			System.out.println("Saldo insuficiente");
		}
		
		System.out.println("Novo saldo: " + conta1.getSaldo());
		System.out.println("Agencia: " +conta1.getAgencia());
		System.out.println("Numero: " +conta1.getNumero());
		System.out.println("Titular: " +conta1.getTitular());
		}
				
	}


