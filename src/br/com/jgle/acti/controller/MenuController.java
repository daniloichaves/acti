package br.com.jgle.acti.controller;

import java.util.Iterator;

import org.springframework.context.annotation.Scope;
import org.springframework.stereotype.Controller;
import org.zkoss.zk.ui.event.Event;
import org.zkoss.zk.ui.event.EventListener;
import org.zkoss.zk.ui.util.GenericForwardComposer;
import org.zkoss.zul.Include;
import org.zkoss.zul.Tab;
import org.zkoss.zul.Tabbox;
import org.zkoss.zul.Tabpanel;
import org.zkoss.zul.Tabpanels;
import org.zkoss.zul.Tabs;

@Scope("page")
@Controller
public class MenuController extends GenericForwardComposer {

	private static final long serialVersionUID = 1L;

	private Tabbox childrenTabbox;

	public void onCloseTab(Event event) {

	}

	@SuppressWarnings("rawtypes")
	public void adicionarAba(String paginaZul, String titulo) {
		if (session.getAttribute(paginaZul + "tab") != null) {
			Tab tab = (Tab) session.getAttribute(paginaZul + "tab");
			// tab.addEventListener("onClick", new EventListener() {
			// public void onClose(Event event) throws Exception {
			// onCloseTab(event);
			// }
			// });
			Tabpanel tabpanel = (Tabpanel) session.getAttribute(paginaZul + "tabpanel");
			tab.setClosable(true);
			tab.setSelected(true);
			childrenTabbox.getTabs().appendChild(tab);
			childrenTabbox.getTabpanels().appendChild(tabpanel);
			return;
		}

		for (Iterator it = childrenTabbox.getTabs().getChildren().iterator(); it.hasNext();) {
			final Tab t = (Tab) it.next();
			if (t.getLabel().equals(titulo)) {
				t.setSelected(true);
				t.setVisible(true);
			}
		}

		Include include = new Include();
		include.setSrc(paginaZul);
		include.setProgressing(true);

		Tabpanel tabpanel = new Tabpanel();
		tabpanel.setHeight("100%");
		tabpanel.appendChild(include);
		// Executions.createComponents("/cadastro/loginList.zul", tabpanel,
		// null);

		Tab tab = new Tab(titulo);
		tab.setHeight("100%");
		tab.setClosable(true);
		tab.setSelected(true);
		tab.addEventListener("onClose", new EventListener() {
			@Override
			public void onEvent(Event arg0) throws Exception {
				self.setVisible(false);
			}
		});

		if (childrenTabbox.getTabs() == null) {
			childrenTabbox.appendChild(new Tabs());
			childrenTabbox.appendChild(new Tabpanels());
		}

		childrenTabbox.getTabs().appendChild(tab);
		childrenTabbox.getTabpanels().appendChild(tabpanel);
		session.setAttribute(paginaZul + "tab", tab);
		session.setAttribute(paginaZul + "tabpanel", tabpanel);
	}

	public Tabbox getChildrenTabbox() {
		return childrenTabbox;
	}

	public void setChildrenTabbox(Tabbox childrenTabbox) {
		this.childrenTabbox = childrenTabbox;
	}

}
