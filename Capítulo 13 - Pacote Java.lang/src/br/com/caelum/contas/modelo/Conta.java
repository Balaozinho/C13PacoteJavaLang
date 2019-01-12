package br.com.caelum.contas.modelo;

//a classe Conta se tornou abstrata, o que impede ela de ser instanciada 
//dessa forma, toda vez que eu tentar instanciar a classe funcionario, não irá compilar
//Conta c = new Conta (); - dará pau
//não faz sentido instanciar apenas a classe conta, uma vez que deverá ser indicado o tipo dela cc ou cp



public abstract class Conta {
	
	protected double saldo;
	private String titular;
	private String agencia;
	private int numero;
	
	//Todas as classes herdam da classe Object
	//método equals compara refencia dos objetos (por padrão)
	//Para comparar os atributos, o método equals da classe Object deve ser reescrito(que recebe um Obj)
	//método equals me permite comparar o conteúdo dos objetos, evitando que se crie uma conta
	//com o mesmo número e agencia. 
	
	public boolean equals (Object obj){
		if (obj == null){
			return false;
		}
		
		
		//Casting de referencias 
		Conta outraConta = (Conta)obj;
		
		return this.numero == outraConta.numero && this.agencia.equals(outraConta.agencia);
	}
	
	
	//Método toString para me devolver as informações customizadas no box de transferencia
	
	public String toString(){
		return "[titular= " + titular.toUpperCase() + ", numero= " + numero + ", agencia= " + agencia + "]";
	}
	

	public void setTitular(String titular){
		this.titular = titular;
	}
	
	public String getTitular(){
		return this.titular;
	}
	
	public void setAgencia(String agencia){
		this.agencia = agencia;
	}
	
	public String getAgencia(){
		return this.agencia; 
	}
	
	public void setNumero(int numero){
		this.numero = numero;
	}
	
	public int getNumero(){
		return this.numero;
	}
	
	public void deposita(double valor){
		if(valor <= 0){
			throw new IllegalArgumentException("Você tentou depositar um valor negativo");
		}
		else{
			this.saldo += valor;
		}
	}
	
	public void saca(double valor){
		if(valor > this.saldo){
			throw new IllegalArgumentException("Você tentou sacar um valor negativo");
		}
		else{
			this.saldo -= valor;
		}
	}
	
	
	//A classe Conta é abstrata, entretando consigo indicar sua referência, por isso que o método
	//abaixo recebe como referencia a classe Conta 
	
	public void transfere (double valor, Conta conta){
		this.saca(valor);
		conta.deposita(valor);
	}
	
	public double getSaldo(){
		return this.saldo;
	}
	
	public abstract String getTipo();
	//tornando este método abstrato, obrigatoriamente tenho que reescreve-lo nas classes filhas
	//ContaCorrente e ContaPoupanca
	//Mantenho o método getTipo pois utilizo ele em conjunto com o polimorfismo e herança para as 
	//Demais classes
	
	public String recuperarDadosParaImpressao(){
		String dados = "Titular: " + this.titular;
		dados += "\nNumero: " + this.numero;
		dados += "\nAgência: " + this.agencia;
		dados += "\nSaldo: R$" + this.saldo;
		dados += "\nTipo: " + this.getTipo();
		
		//É possível chamar um método abstrato de dentro de um outro método da própria classe abstrata
		
		return dados;
	}
	
	
}


//Checar no javadoc os métodos da classe String (charArt(i); lenght; substring; indexOf)
//toUpperCase; toLowerCase; isEmpty; contains e matches. 
//StringBuffer

//método compareTo -> compara duas strings , se igual, devolve zero
//uma String é IMUTAVEL 
