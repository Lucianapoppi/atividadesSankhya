package banco;

public class Conta {

		
		private int agencia;
		private String numero;
		private double saldo;
		private String titular;
		
		
		public Conta(String numero, int agencia, String titular, double saldoInicial) {
			this.numero = numero;
			this.agencia = agencia;
			this.titular = titular;
			
			
			depositar(saldoInicial);
		}
		
		public Conta(String titular, String agencia) {
			
		}
		
		public Conta(String numero) {
			this.numero = numero;
		}
		
		public Conta() {
			
		}
		
		
		
		public boolean sacar(double valor){
			if (valor <= 0) {
				return false;
			}
			//taxa de saque de 1 centavo
			valor += 0.01;
			if(saldo >= valor) {
				saldo -= valor;
				return true;

			}
			return false;
		}
		
		public void depositar(double valor) {
			if (valor <= 0) {
				return;
			}
			saldo += valor;		
		}

		public int getAgencia() {
			return agencia;
		}

		public void setAgencia(int agencia) {
			this.agencia = agencia;
		}

		public String getNumero() {
			return numero;
		}

		public void setNumero(String numero) {
			this.numero = numero;
		}

		public double getSaldo() {
			return saldo;
		}

		public void setSaldo(double saldo) {
			this.saldo = saldo;
		}

		public String getTitular() {
			return titular;
		}

		public void setTitular(String titular) {
			this.titular = titular;
		}
		
		
		
}


