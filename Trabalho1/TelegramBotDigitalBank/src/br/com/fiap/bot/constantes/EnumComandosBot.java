package br.com.fiap.bot.constantes;

import java.util.HashMap;
import java.util.Map;

public enum EnumComandosBot {

	START("/start", EnumTipoIntegracaoBot.CONSULTA),
	CRIAR_CONTA("/criar_conta", EnumTipoIntegracaoBot.SOLICITACAO),
	MODIFICAR_CONTA("/modificar_conta", EnumTipoIntegracaoBot.SOLICITACAO),
	INCLUIR_DEPENDENTE("/incluir_dependente", EnumTipoIntegracaoBot.SOLICITACAO),
	REALIZAR_DEPOSITOS("/realizar_deposito", EnumTipoIntegracaoBot.SOLICITACAO),
	REALIZAR_SAQUE("/realizar_saque", EnumTipoIntegracaoBot.SOLICITACAO),
	CONSULTAR_SALDO("/consultar_saldo_conta", EnumTipoIntegracaoBot.CONSULTA),
	SOLICITAR_EMPRESTIMO("/solicitar_emprestimo", EnumTipoIntegracaoBot.SOLICITACAO),
	PAGAR_PARCELAS_VENCIDAS_EMPRESTIMO("/pagar_parcelas_vencidas_emprest", EnumTipoIntegracaoBot.SOLICITACAO),
	PAGAR_PARCELA_EMPRESTIMO("/pagar_parcela_emprestimo", EnumTipoIntegracaoBot.SOLICITACAO),
	EXIBIR_DADOS("/exibir_info_titular_dependentes", EnumTipoIntegracaoBot.CONSULTA),
	CONSULTAR_EXTRATO("/consultar_extrato", EnumTipoIntegracaoBot.CONSULTA),
	CONSULTA_DEPOSITOS("/consultar_lancamentos", EnumTipoIntegracaoBot.CONSULTA),
	CONSULTAR_RETIRADAS("/consultar_retiradas", EnumTipoIntegracaoBot.CONSULTA),
	CONSULTAR_TARIFAS_PAGAS("/consultar_tarifas_pagas", EnumTipoIntegracaoBot.CONSULTA),
	CONSULTAR_EMPRESTIMO("/consultar_emprestimo", EnumTipoIntegracaoBot.CONSULTA),
	CONSULTAR_SALDO_DEVEDOR_EMPRESTIMO("/consultar_saldo_devedor_emprest", EnumTipoIntegracaoBot.CONSULTA),
	AJUDA("/ajuda", EnumTipoIntegracaoBot.CONSULTA );

	public static final Map<String, EnumComandosBot> LISTA_COMANDO_INTERACOES = new HashMap<String, EnumComandosBot>();
	
	private String comando;
	private EnumTipoIntegracaoBot enumTipoIntegracaoBot;
	
	EnumComandosBot(String comando, EnumTipoIntegracaoBot enumTipoIntegracaoBot){
		this.comando = comando;
		this.enumTipoIntegracaoBot = enumTipoIntegracaoBot;
	}
	
	static{
		for(EnumComandosBot enumComando : EnumComandosBot.values()){
			LISTA_COMANDO_INTERACOES.put(enumComando.comando, enumComando);
		}
	}
	
	public String getComando() {
		return comando;
	}

	public EnumTipoIntegracaoBot getEnumTipoIntegracaoBot() {
		return enumTipoIntegracaoBot;
	}
}
