package br.com.fiap.bot.integradores.impl;

import com.pengrad.telegrambot.model.Chat;

import br.com.fiap.banco.comandos.BotComando;
import br.com.fiap.banco.excecao.ContaInexistenteExcecao;
import br.com.fiap.bot.integradores.IntegracaoBotSolicitacao;

public class IntegracaoBotPagarTodasParcelasEmprestimo extends IntegracaoBotSolicitacao {

	public IntegracaoBotPagarTodasParcelasEmprestimo() {
		super("Voc� gostaria de pagar todas as parcelas poss�veis com o saldo da sua conta? Sim ou N�o", "Sim ou N�o");
	}

	@Override
	public Boolean validarResposta(String resposta) {
		boolean respostaOk = true;
		
		try {
			if (resposta == null || resposta.trim().length() != 3 || 
					!(resposta.trim().toUpperCase().equals("SIM")
							|| resposta.trim().toUpperCase().equals("NAO") 
							|| resposta.trim().toUpperCase().equals("N�O"))) {
				respostaOk = false;
			}
		} catch (Exception e) {
			respostaOk = false;
		}
		return respostaOk;
	}

	@Override
	public String integrarBanco(String resposta, Chat usuario) {	
		BotComando botComando = new BotComando();
		StringBuffer retorno = new StringBuffer();
		if( resposta.trim().toUpperCase().equals("NAO") 
							|| resposta.trim().toUpperCase().equals("N�O")){
			retorno.append("Ok! N�o vamos realizar os pagamentos!");
		}else{
			try {
				botComando.pagarParcelasVencidasEmprestimo(usuario.id());
			} catch (ContaInexistenteExcecao e) {
				retorno.append("Voc� ainda n�o tem uma conta, para criar sua conta digite /criar_conta");
			}
			
			retorno.append("Parcelas pagas com sucesso!");
		}
		return retorno.toString();
	}

}
