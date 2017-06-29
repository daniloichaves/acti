package br.com.jgle.acti.controller.integracao;

import org.springframework.context.annotation.Scope;
import org.springframework.stereotype.Controller;
import org.zkoss.spring.context.annotation.AppliedTo;
import org.zkoss.zk.ui.Component;
import org.zkoss.zk.ui.event.Event;

import br.com.jgle.acti.controller.MotoristaController;

@Scope("page")
@Controller
@AppliedTo("entityWin")
public class BrasilRiskMotoristaController extends MotoristaController {

	private static final long serialVersionUID = 1L;

	public BrasilRiskMotoristaController() {
		super();
	}

	protected Component entitySync; // sync button

	public void onClick$entitySync(Event event) {
		System.out.println("sincronizar");
	}

	public Component getEntitySync() {
		return entitySync;
	}

	public void setEntitySync(Component entitySync) {
		this.entitySync = entitySync;
	}

}
