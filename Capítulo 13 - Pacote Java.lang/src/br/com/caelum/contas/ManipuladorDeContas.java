package br.com.caelum.contas;

import br.com.caelum.contas.modelo.Conta;
import br.com.caelum.contas.modelo.ContaCorrente;
import br.com.caelum.contas.modelo.ContaPoupanca;
import br.com.caelum.javafx.api.util.Evento;

//classe responsável por realizar a ponte entre a conta e a interface gráfica

//Precisamos pegar os dados de tela para criar uma nova conta 
//utilizando o objeto "evento" consigo que os dados recuperados da tela sejam colocados na nova conta

public class ManipuladorDeContas {

	private Conta conta;
	
	public void criaConta(Evento evento){
		
		//Para criar a conta correspondente, vamos usar o método getSelecionadoNoRadio do objeto evento
		
		String tipo = evento.getSelecionadoNoRadio("tipo");
		
		//coloco um if para checar o tipo selecionado e criar a conta correspondente
		
		if(tipo.equals("Conta Corrente")){
			this.conta = new ContaCorrente();
		}
		else if(tipo.equals("Conta Poupança")){
			this.conta = new ContaPoupanca();
		}
		
		//setters para pegar os dados de tela e criar a conta com estes dados
		
		this.conta.setAgencia(evento.getString("agencia"));
		this.conta.setNumero(evento.getInt("numero"));
		this.conta.setTitular(evento.getString("titular"));	
	}
	
	//métodos saca, deposita e transfere pegam os dados de tela e executam os métodos correspondentes 
	
	public Conta getConta(){
		return this.conta;
	}
	
	public void saca (Evento evento){
		double valor = evento.getDouble("valorOperacao");
		this.conta.saca(valor);
		}
	
	public void deposita (Evento evento){
		double valorDigitado = evento.getDouble("valorOperacao");
		this.conta.deposita(valorDigitado);
	}	
	
	public void transfere (Evento evento){
		Conta destino = (Conta) evento.getSelecionadoNoCombo("destino");
		conta.transfere(evento.getDouble("valorTransferencia"), destino);
	}
}
