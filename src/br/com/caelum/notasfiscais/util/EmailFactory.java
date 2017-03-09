package br.com.caelum.notasfiscais.util;

import javax.enterprise.inject.Produces;

import br.com.caelum.notasfiscais.annotation.EmailComercial;
import br.com.caelum.notasfiscais.annotation.EmailFinanceiro;

public class EmailFactory {
	
	@Produces @EmailComercial
	private String emailComercial = "comercial@uberdist.com.br";
	
	@Produces @EmailFinanceiro
	private String emailFinanceiro = "financeiro@uberdist.com.br";

}
