package br.com.caelum.notasfiscais.mb;

import java.util.List;

import javax.enterprise.inject.Model;
import javax.inject.Inject;

import br.com.caelum.notasfiscais.dao.UsuarioDao;
import br.com.caelum.notasfiscais.modelo.Usuario;
import br.com.caelum.notasfiscais.tx.Transactional;

//@Named
//@RequestScoped
@Model
public class UsuarioBean {

	@Inject
	private UsuarioDao dao;

	private Usuario usuario = new Usuario();
	private List<Usuario> usuarios;

	public Usuario getUsuario() {
		return this.usuario;
	}

	public void setUsuario(Usuario usuario) {
		this.usuario = usuario;
	}

	public List<Usuario> getUsuarios() {
		if (usuarios == null) {
			System.out.println("Carregando usuários...");
			usuarios = dao.listaTodos();
		}
		return usuarios;
	}

	@Transactional
	public void grava() {
		if (usuario.getId() == null) {
			dao.adiciona(usuario);
		} else {
			dao.atualiza(usuario);
		}
		usuarios = dao.listaTodos();
		this.usuario = new Usuario();
	}

	@Transactional
	public void remove(Usuario usuario) {
		dao.remove(usuario);
		this.usuarios = dao.listaTodos();
	}

	public void cancela() {
		System.out.println("Cancelando a operação...");
		this.usuario = new Usuario();
	}

}
