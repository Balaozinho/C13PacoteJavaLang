package br.com.caelum.contas.modelo;

public class ContaCorrente extends Conta {
	
	public String getTipo(){
		return "Conta Corrente";
	}
	
	//@override
	public void saca(double valor){
		if( valor < 0){
			throw new IllegalArgumentException("Você tentou sacar um valor negativo");
		}
		if( this.saldo < valor){
			throw new SaldoInsuficienteException(valor);
		}
		this.saldo -= (valor + 0.1);
	}
	
	//tive que modificar o acesso do atributo saldo declarado na classe mãe Conta, para que
	//a classe filha pudesse acessá-lo também. Dessa forma, colocamos o protected

}
