package br.com.jgle.acti.controller;

import org.springframework.context.annotation.Scope;
import org.springframework.stereotype.Controller;

import br.com.jgle.acti.entity.NotaFiscal;

@Scope("page")
@Controller
public class NotaFiscalController extends AbstractController<NotaFiscal> {

	private static final long serialVersionUID = 1L;

	// protected NotaFiscalItemController notaFiscalItemController;

	public NotaFiscalController() {
		super(new NotaFiscal());

		// notaFiscalItemController = new NotaFiscalItemController(this);
	}

	@SuppressWarnings({ "rawtypes", "unchecked" })
	public NotaFiscalController(AbstractController parent) {
		super(new NotaFiscal(), parent);
	}

	// public NotaFiscalItemController getNotaFiscalItemController() {
	// return notaFiscalItemController;
	// }
	//
	// public void setNotaFiscalItemController(NotaFiscalItemController
	// notaFiscalItemController) {
	// this.notaFiscalItemController = notaFiscalItemController;
	// }

}
