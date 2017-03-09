package br.com.caelum.notasfiscais.mb;

import java.io.Serializable;

import javax.enterprise.event.Event;
import javax.enterprise.inject.Model;
import javax.inject.Inject;

import br.com.caelum.notasfiscais.dao.UsuarioDao;
import br.com.caelum.notasfiscais.modelo.Usuario;

//@Named
//@RequestScoped
@Model
public class LoginBean implements Serializable {

	private static final long serialVersionUID = 7619160418677198940L;

	@Inject
	Event<Usuario> eventoLogin;

	@Inject
	private UsuarioLogadoBean usuarioLogado;

	@Inject
	private UsuarioDao dao;

	private Usuario usuario = new Usuario();

	public String efetuaLogin() {
		boolean loginValido = dao.existe(this.usuario);
		if (loginValido) {
			eventoLogin.fire(usuario);
			usuarioLogado.logar(usuario);
			return "produtos?faces-redirect=true";
		} else {
			usuarioLogado.deslogar();
			this.usuario = new Usuario();
			return "login";
		}
	}

	public Usuario getUsuario() {
		return this.usuario;
	}

}
