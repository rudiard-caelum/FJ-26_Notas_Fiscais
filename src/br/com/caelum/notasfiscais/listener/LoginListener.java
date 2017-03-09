package br.com.caelum.notasfiscais.listener;

import javax.enterprise.event.Observes;
import javax.inject.Inject;

import br.com.caelum.notasfiscais.annotation.EmailComercial;
import br.com.caelum.notasfiscais.annotation.EmailFinanceiro;
import br.com.caelum.notasfiscais.modelo.Usuario;

public class LoginListener {

	@Inject
	@EmailComercial
	String emailComercial;
	@Inject
	@EmailFinanceiro
	String emailFinanceiro;

	public void onLogin(@Observes Usuario usuario) {
		System.out
				.printf("Usuário %s se logou no sistema.", usuario.getLogin());
		// enviando email para outro sistema.
		System.out.println("Enviando e-mail para Comercial: " + emailComercial);
		System.out.println("Enviando e-mail para Financeiro: "
				+ emailFinanceiro);
	}
}
