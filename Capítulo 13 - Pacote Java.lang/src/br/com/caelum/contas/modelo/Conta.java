package br.com.caelum.contas.modelo;

//a classe Conta se tornou abstrata, o que impede ela de ser instanciada 
//dessa forma, toda vez que eu tentar instanciar a classe funcionario, n�o ir� compilar
//Conta c = new Conta (); - dar� pau
//n�o faz sentido instanciar apenas a classe conta, uma vez que dever� ser indicado o tipo dela cc ou cp



public abstract class Conta {
	
	protected double saldo;
	private String titular;
	private String agencia;
	private int numero;
	
	//Todas as classes herdam da classe Object
	//m�todo equals compara refencia dos objetos (por padr�o)
	//Para comparar os atributos, o m�todo equals da classe Object deve ser reescrito(que recebe um Obj)
	//m�todo equals me permite comparar o conte�do dos objetos, evitando que se crie uma conta
	//com o mesmo n�mero e agencia. 
	
	public boolean equals (Object obj){
		if (obj == null){
			return false;
		}
		
		
		//Casting de referencias 
		Conta outraConta = (Conta)obj;
		
		return this.numero == outraConta.numero && this.agencia.equals(outraConta.agencia);
	}
	
	
	//M�todo toString para me devolver as informa��es customizadas no box de transferencia
	
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
			throw new IllegalArgumentException("Voc� tentou depositar um valor negativo");
		}
		else{
			this.saldo += valor;
		}
	}
	
	public void saca(double valor){
		if(valor > this.saldo){
			throw new IllegalArgumentException("Voc� tentou sacar um valor negativo");
		}
		else{
			this.saldo -= valor;
		}
	}
	
	
	//A classe Conta � abstrata, entretando consigo indicar sua refer�ncia, por isso que o m�todo
	//abaixo recebe como referencia a classe Conta 
	
	public void transfere (double valor, Conta conta){
		this.saca(valor);
		conta.deposita(valor);
	}
	
	public double getSaldo(){
		return this.saldo;
	}
	
	public abstract String getTipo();
	//tornando este m�todo abstrato, obrigatoriamente tenho que reescreve-lo nas classes filhas
	//ContaCorrente e ContaPoupanca
	//Mantenho o m�todo getTipo pois utilizo ele em conjunto com o polimorfismo e heran�a para as 
	//Demais classes
	
	public String recuperarDadosParaImpressao(){
		String dados = "Titular: " + this.titular;
		dados += "\nNumero: " + this.numero;
		dados += "\nAg�ncia: " + this.agencia;
		dados += "\nSaldo: R$" + this.saldo;
		dados += "\nTipo: " + this.getTipo();
		
		//� poss�vel chamar um m�todo abstrato de dentro de um outro m�todo da pr�pria classe abstrata
		
		return dados;
	}
	
	
}


//Checar no javadoc os m�todos da classe String (charArt(i); lenght; substring; indexOf)
//toUpperCase; toLowerCase; isEmpty; contains e matches. 
//StringBuffer

//m�todo compareTo -> compara duas strings , se igual, devolve zero
//uma String � IMUTAVEL 
