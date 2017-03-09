package br.com.caelum.notasfiscais.teste;

import javax.enterprise.context.RequestScoped;
import javax.inject.Named;

@Named
@RequestScoped
public class TestBean {

	public void grava() {
		System.out.println("Clicou no botão!");
	}
}
