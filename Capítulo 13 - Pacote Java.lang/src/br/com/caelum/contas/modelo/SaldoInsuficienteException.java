package br.com.caelum.contas.modelo;

//Ao extender uma classe, não herdamos seus construtores..Posso acessá-los por meio do super

public class SaldoInsuficienteException extends RuntimeException {
	
	public SaldoInsuficienteException (double valor){
		super("Saldo insuficiente para sacar o valor de: " + valor);
	}

}

//Exercicio opcional 7, oi? trocar para checked e atribuir try e catch nos blocos 