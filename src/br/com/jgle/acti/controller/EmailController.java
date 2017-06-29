package br.com.jgle.acti.controller;

import org.springframework.context.annotation.Scope;
import org.springframework.stereotype.Controller;

import br.com.jgle.acti.entity.Email;

@Scope("page")
@Controller
public class EmailController extends AbstractController<Email> {

	private static final long serialVersionUID = 1L;

	public EmailController() {
		super(new Email());
	}

	@SuppressWarnings({ "rawtypes", "unchecked" })
	public EmailController(AbstractController parent) {
		super(new Email(), parent);
	}

}
