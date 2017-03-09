package br.com.caelum.notasfiscais.mb;

import java.io.Serializable;
import java.util.List;

import javax.inject.Inject;

import org.primefaces.model.LazyDataModel;

import br.com.caelum.notasfiscais.annotation.ViewModel;
import br.com.caelum.notasfiscais.dao.NotaFiscalDao;
import br.com.caelum.notasfiscais.datamodel.DataModelNotasFiscais;
import br.com.caelum.notasfiscais.modelo.NotaFiscal;

@ViewModel
public class ListaNotasFiscaisBean implements Serializable {

	private static final long serialVersionUID = -5622637277338378911L;

	@Inject
	private NotaFiscalDao dao;

	@Inject
	private DataModelNotasFiscais dataModel;

	private NotaFiscal notaFiscal = new NotaFiscal();
	private List<NotaFiscal> notasFiscais;

	public LazyDataModel<NotaFiscal> getDataModel() {
		return dataModel;
	}

	public NotaFiscal getNotaFiscal() {
		return notaFiscal;
	}

	public void setNotaFiscal(NotaFiscal notaFiscal) {
		this.notaFiscal = notaFiscal;
	}

	public List<NotaFiscal> getNotasFiscais() {
		if (notasFiscais == null) {
			System.out.println("Carregando notas fiscais...");
			notasFiscais = dao.listaTodos();
		}
		return notasFiscais;
	}
}
