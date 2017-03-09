package br.com.caelum.notasfiscais.mb;

import java.util.List;

import javax.enterprise.inject.Model;
import javax.inject.Inject;

import org.primefaces.model.chart.PieChartModel;

import br.com.caelum.notasfiscais.dao.GraficoDao;
import br.com.caelum.notasfiscais.dao.ProdutoDao;
import br.com.caelum.notasfiscais.modelo.Produto;
import br.com.caelum.notasfiscais.modelo.QuantidadePorProduto;
import br.com.caelum.notasfiscais.tx.Transactional;

//@Named
//@RequestScoped
@Model
public class ProdutoBean {

	@Inject
	ProdutoDao dao;

	@Inject
	private GraficoDao graficoDao;

	private Produto produto = new Produto();
	private List<Produto> produtos;
	private Double totalProdutos;

	public Produto getProduto() {
		return this.produto;
	}

	public void setProduto(Produto produto) {
		this.produto = produto;
	}

	public List<Produto> getProdutos() {
		if (produtos == null) {
			System.out.println("Carregando produtos...");
			produtos = dao.listaTodos();
		}
		return produtos;
	}

	public Double getTotalProdutos() {
		System.out.println("Somando produtos...");
		return dao.totalProdutos();
	}

	@Transactional
	public void grava() {
		if (produto.getId() == null) {
			dao.adiciona(produto);
		} else {
			dao.atualiza(produto);
		}
		produtos = dao.listaTodos();
		this.produto = new Produto();
	}

	@Transactional
	public void remove(Produto produto) {
		dao.remove(produto);
		this.produtos = dao.listaTodos();
	}

	public void cancela() {
		System.out.println("Cancelando a operação...");
		this.produto = new Produto();
	}

	public PieChartModel getRelatorioQuantidadePorProduto() {
		PieChartModel model = new PieChartModel();
		model.setTitle("Quantidade vendida por Produto");
		model.setLegendPosition("w");
		model.setShowDataLabels(true);

		List<QuantidadePorProduto> lista = graficoDao
				.relatorioQuantidadePorProduto();
		for (QuantidadePorProduto qtde : lista) {
			model.set(qtde.getProduto().getNome(), qtde.getQuantidade());
		}
		return model;
	}
	
	public List<Produto> busca(String texto) {
		return dao.buscaPorNome(texto);
	}

}
