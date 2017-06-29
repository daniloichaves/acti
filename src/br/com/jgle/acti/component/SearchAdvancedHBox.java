package br.com.jgle.acti.component;

import java.io.Serializable;

import org.zkoss.zk.ui.event.Event;
import org.zkoss.zk.ui.event.EventListener;
import org.zkoss.zul.Combobox;
import org.zkoss.zul.Comboitem;
import org.zkoss.zul.Hbox;
import org.zkoss.zul.Image;
import org.zkoss.zul.Textbox;

import br.com.jgle.acti.component.FiltroVO.AttributeComparator;
import br.com.jgle.acti.component.FiltroVO.AttributeOperator;

@SuppressWarnings("serial")
public class SearchAdvancedHBox extends Hbox implements Serializable {

	Combobox atributoLabel;
	Combobox camparador;
	Textbox valor;
	Combobox operador;
	Image remover;
	@SuppressWarnings("rawtypes")
	Class clazz;

	@SuppressWarnings("rawtypes")
	public SearchAdvancedHBox(Combobox atributoLabel, Class clazz) {
		super();
		this.atributoLabel = atributoLabel;
		this.valor = new Textbox();
		this.clazz = clazz;
		this.valor.setStyle("text-transform:uppercase");

		this.camparador = new Combobox();
		for (AttributeComparator ac : AttributeComparator.values()) {
			Comboitem comboitem = new Comboitem();
			comboitem.setLabel(ac.getAttributeCompator());
			comboitem.setValue(ac);
			comboitem.setParent(camparador);
		}

		operador = new Combobox();
		for (AttributeOperator op : AttributeOperator.values()) {
			Comboitem comboitem = new Comboitem();
			comboitem.setLabel(op.getAttributeCompator());
			comboitem.setValue(op);
			comboitem.setParent(operador);
		}

		remover = new Image();
		remover.setSrc("/img/png/delete-icon16x16.png");
		remover.addEventListener("onClick", new EventListener() {
			public void onEvent(Event event) throws Exception {
				removeRegistro(event);
			}
		});

		appendChild(atributoLabel);
		appendChild(camparador);
		appendChild(valor);
		appendChild(operador);
		appendChild(remover);

	}

	public FiltroVO getFitlro() {
		FiltroVO filtro = new FiltroVO(clazz);

		if (atributoLabel.getSelectedItem() != null) {
			filtro.setAttributeLabel(atributoLabel.getSelectedItem().getLabel());
			filtro.setAttributeCampo(atributoLabel.getSelectedItem().getValue().toString());
		}

		if (camparador.getSelectedItem() != null)
			filtro.setAttributeComparator((AttributeComparator) camparador.getSelectedItem().getValue());

		filtro.setAttributeValue(valor.getValue());

		if (operador.getSelectedItem() != null)
			filtro.setAttributeOperator((AttributeOperator) operador.getSelectedItem().getValue());

		return filtro;
	}

	public void removeRegistro(Event event) {

		removeChild(event.getTarget().getParent());
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

	public Image getRemover() {
		return remover;
	}

	public void setRemover(Image remover) {
		this.remover = remover;
	}

	public Combobox getOperador() {
		return operador;
	}

	public void setOperador(Combobox operador) {
		this.operador = operador;
	}

}
