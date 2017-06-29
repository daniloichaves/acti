package br.com.jgle.acti.component;

import java.io.Serializable;
import java.util.Map;

import org.zkoss.zk.ui.event.Event;
import org.zkoss.zk.ui.event.EventListener;
import org.zkoss.zul.Combobox;
import org.zkoss.zul.Comboitem;
import org.zkoss.zul.Hbox;
import org.zkoss.zul.Image;
import org.zkoss.zul.Label;
import org.zkoss.zul.Textbox;
import org.zkoss.zul.Vbox;

import br.com.jgle.acti.entity.AbstractEntity;

@SuppressWarnings("serial")
public class SearchHbox<T extends AbstractEntity> extends Vbox implements Serializable {

	protected Hbox boxBuscaSimples;
	protected Label labelSimples;
	protected Textbox entitySearch;
	protected Image imageSearch;

	// Busca avançada
	protected Vbox boxBuscaAvancada;
	protected Label labelAvancada;
	protected Combobox atributoLabel;
	protected Combobox camparador;
	protected Textbox valor;
	protected Combobox operador;
	protected Image imageSearchAvancada;
	protected Image imageAddRegistro;

	protected Label trocarView;
	protected boolean isBuscaAvancada = true;
	private T selected;

	public SearchHbox() {
		boxBuscaSimples = new Hbox();
		boxBuscaSimples.setId("boxBuscaSimples");

		boxBuscaAvancada = new Vbox();
		boxBuscaAvancada.setId("boxBuscaAvancada");

		boxBuscaSimples.setVisible(true);
		boxBuscaAvancada.setVisible(false);

		trocarView = new Label("Trocar busca");
		trocarView.setId("trocarView");
		trocarView.addEventListener("onClick", new EventListener() {
			public void onEvent(Event event) throws Exception {
				trocarBusca();
			}
		});

		appendChild(boxBuscaSimples);
		appendChild(boxBuscaAvancada);
		appendChild(trocarView);

		viewBuscaSimples();
		viewBuscaAvancada();
	}

	public void trocarBusca() {
		if (isBuscaAvancada) {
			if (boxBuscaAvancada.getChildren().size() < 2)
				addRegistro();
			boxBuscaAvancada.setVisible(true);
			boxBuscaSimples.setVisible(false);
			isBuscaAvancada = false;
		} else {
			boxBuscaSimples.setVisible(true);
			boxBuscaAvancada.setVisible(false);
			isBuscaAvancada = true;
		}
	}

	public void viewBuscaSimples() {

		labelSimples = new Label("Busca Simples");
		labelSimples.setId("labelSimples");

		imageSearch = new Image();
		imageSearch.setId("imageSearch");
		imageSearch.setSrc("/img/png/search-icon32x32.png");

		entitySearch = new Textbox();
		entitySearch.setId("entitySearch");
		entitySearch.setStyle("text-transform:uppercase");

		boxBuscaSimples.appendChild(labelSimples);
		boxBuscaSimples.appendChild(entitySearch);
		boxBuscaSimples.appendChild(imageSearch);

	}

	public void viewBuscaAvancada() {
		Hbox hbox = new Hbox();
		boxBuscaAvancada.appendChild(hbox);

		labelAvancada = new Label("Busca avançada");
		labelAvancada.setId("labelAvancada");
		hbox.appendChild(labelAvancada);

		imageSearchAvancada = new Image();
		imageSearchAvancada.setId("imageSearchAvancada");
		imageSearchAvancada.setSrc("/img/png/search-icon32x32.png");
		hbox.appendChild(imageSearchAvancada);

		imageAddRegistro = new Image();
		imageAddRegistro.setId("imageAddRegistro");
		imageAddRegistro.setSrc("/img/png/file-new-icon16x16.png");
		imageAddRegistro.addEventListener("onClick", new EventListener() {
			public void onEvent(Event event) throws Exception {
				addRegistro();
			}
		});
		hbox.appendChild(imageAddRegistro);
		// addRegistro();
	}

	public void addRegistro() {

		Combobox atributoLabel = new Combobox();
		if (atributoLabel.getChildren().size() < 1) {
			if (selected != null) {
				Map<String, String> labelValues = selected.getParametrosAdvancedSearch();
				for (String key : labelValues.keySet()) {
					Comboitem comboitem = new Comboitem();
					comboitem.setLabel(labelValues.get(key));
					comboitem.setValue(key);
					comboitem.setParent(atributoLabel);
				}
			}
		}

		SearchAdvancedHBox hbox = new SearchAdvancedHBox(atributoLabel, selected.getClass());

		boxBuscaAvancada.appendChild(hbox);
	}

	public void setSelected(T selected) {
		this.selected = selected;
	}

	public Image getImageSearch() {
		return imageSearch;
	}

	public void setImageSearch(Image imageSearch) {
		this.imageSearch = imageSearch;
	}

	public Textbox getEntitySearch() {
		return entitySearch;
	}

	public void setEntitySearch(Textbox entitySearch) {
		this.entitySearch = entitySearch;
	}

	public Label getBuscaAvancada() {
		return labelAvancada;
	}

	public void setBuscaAvancada(Label buscaAvancada) {
		this.labelAvancada = buscaAvancada;
	}

	public Label getLabelSimples() {
		return labelSimples;
	}

	public void setLabelSimples(Label labelSimples) {
		this.labelSimples = labelSimples;
	}

	public Hbox getBoxBuscaSimples() {
		return boxBuscaSimples;
	}

	public void setBoxBuscaSimples(Hbox boxBuscaSimples) {
		this.boxBuscaSimples = boxBuscaSimples;
	}

	public Label getLabelAvancada() {
		return labelAvancada;
	}

	public void setLabelAvancada(Label labelAvancada) {
		this.labelAvancada = labelAvancada;
	}

	public Vbox getBoxBuscaAvancada() {
		return boxBuscaAvancada;
	}

	public void setBoxBuscaAvancada(Vbox boxBuscaAvancada) {
		this.boxBuscaAvancada = boxBuscaAvancada;
	}

	public Combobox getAtributoLabel() {
		return atributoLabel;
	}

	public void setAtributoLabel(Combobox atributoLabel) {
		this.atributoLabel = atributoLabel;
	}

	public Combobox getCamparador() {
		return camparador;
	}

	public void setCamparador(Combobox camparador) {
		this.camparador = camparador;
	}

	public Textbox getValor() {
		return valor;
	}

	public void setValor(Textbox valor) {
		this.valor = valor;
	}

	public Combobox getOperador() {
		return operador;
	}

	public void setOperador(Combobox operador) {
		this.operador = operador;
	}

	public Label getTrocarView() {
		return trocarView;
	}

	public void setTrocarView(Label trocarView) {
		this.trocarView = trocarView;
	}

	public boolean isBuscaAvancada() {
		return isBuscaAvancada;
	}

	public void setBuscaAvancada(boolean isBuscaAvancada) {
		this.isBuscaAvancada = isBuscaAvancada;
	}

	public Image getImageSearchAvancada() {
		return imageSearchAvancada;
	}

	public void setImageSearchAvancada(Image imageSearchAvancada) {
		this.imageSearchAvancada = imageSearchAvancada;
	}

	public Image getImageAddRegistro() {
		return imageAddRegistro;
	}

	public void setImageAddRegistro(Image imageAddRegistro) {
		this.imageAddRegistro = imageAddRegistro;
	}

	public T getEntity() {
		return selected;
	}

	public void setEntity(T entity) {
		this.selected = entity;
	}

	public T getSelected() {
		return selected;
	}

}
