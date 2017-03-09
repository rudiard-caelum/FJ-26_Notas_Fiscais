package br.com.caelum.notasfiscais.mb;

import java.io.Serializable;

import javax.enterprise.context.SessionScoped;
import javax.faces.context.FacesContext;
import javax.inject.Inject;
import javax.inject.Named;

import br.com.caelum.notasfiscais.modelo.Usuario;

@Named
@SessionScoped
public class UsuarioLogadoBean implements Serializable {

	private static final long serialVersionUID = -7624882497701448506L;

	@Inject
	FacesContext context;
	
	private Usuario usuario;

	public void logar(Usuario usuario) {
		this.usuario = usuario;
	}

	public String deslogar() {
		this.usuario = null;
		context.getExternalContext().invalidateSession();
		return "login?faces-redirect=true";
	}

	public Usuario getUsuario() {
		return usuario;
	}

	public boolean isLogado() {
		return usuario != null;
	}

}
