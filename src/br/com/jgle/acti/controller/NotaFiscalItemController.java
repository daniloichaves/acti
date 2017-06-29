package br.com.jgle.acti.controller;

import org.springframework.context.annotation.Scope;
import org.springframework.stereotype.Controller;

import br.com.jgle.acti.entity.NotaFiscalItem;

@Scope("page")
@Controller
public class NotaFiscalItemController extends AbstractController<NotaFiscalItem> {

	private static final long serialVersionUID = 1L;

	public NotaFiscalItemController() {
		super(new NotaFiscalItem());
	}

	@SuppressWarnings({ "rawtypes", "unchecked" })
	public NotaFiscalItemController(AbstractController parent) {
		super(new NotaFiscalItem(), parent);
	}

}
