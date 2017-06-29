package br.com.jgle.acti.component;

import org.zkoss.zul.Combobox;
import org.zkoss.zul.Comboitem;

import br.com.caelum.stella.type.Estado;

@SuppressWarnings("serial")
public class UFCombobox extends Combobox {
	public UFCombobox() {
		for (Estado estado : Estado.values()) {
			Comboitem comboitem = new Comboitem(estado.toString());
			this.appendChild(comboitem);
		}
	}
}
