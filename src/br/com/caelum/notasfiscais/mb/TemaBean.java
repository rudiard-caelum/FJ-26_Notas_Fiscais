package br.com.caelum.notasfiscais.mb;

import java.io.Serializable;
import java.util.Map;
import java.util.TreeMap;

import javax.enterprise.context.SessionScoped;
import javax.inject.Named;

@Named
@SessionScoped
public class TemaBean implements Serializable {

	// Temas disponíveis
	private Map<String, String> temas;

	// Temas escolhido
	private String tema = "aristo";

	public TemaBean() {
		// cria lista de temas
		temas = new TreeMap<String, String>();

		temas.put("Aristo", "aristo");
		temas.put("Bluesky", "bluesky");
		temas.put("Cupertino", "cupertino");
		temas.put("Sam", "sam");
		temas.put("UI-Lightness", "ui-lightness");
	}

	public Map<String, String> getTemas() {
		return temas;
	}

	public void setTemas(Map<String, String> temas) {
		this.temas = temas;
	}

	public String getTema() {
		return tema;
	}

	public void setTema(String tema) {
		this.tema = tema;
	}

}
