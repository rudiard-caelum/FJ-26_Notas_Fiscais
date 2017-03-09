package br.com.caelum.notasfiscais.listener;

import javax.faces.application.NavigationHandler;
import javax.faces.context.FacesContext;
import javax.faces.event.PhaseEvent;
import javax.faces.event.PhaseId;
import javax.faces.event.PhaseListener;
import javax.inject.Inject;

import br.com.caelum.notasfiscais.mb.UsuarioLogadoBean;

public class Autorizador implements PhaseListener {

	private static final long serialVersionUID = -3432031879361978053L;

	@Inject
	private UsuarioLogadoBean usuarioLogado;
	@Inject
	private FacesContext context;
	@Inject
	private NavigationHandler handler;

	public void afterPhase(PhaseEvent event) {
		if ("/login.xhtml".equals(context.getViewRoot().getViewId())) {
			return;
		}
		if ("/index.xhtml".equals(context.getViewRoot().getViewId())) {
			return;
		}
		if (!usuarioLogado.isLogado()) {
			handler.handleNavigation(context, null, "login?faces-redirect=true");
			context.renderResponse();
		}
	}

	public void beforePhase(PhaseEvent event) {
		return;
	}

	public PhaseId getPhaseId() {
		return PhaseId.RESTORE_VIEW;
	}

}
