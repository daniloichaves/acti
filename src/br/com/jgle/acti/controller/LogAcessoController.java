package br.com.jgle.acti.controller;

import org.springframework.context.annotation.Scope;
import org.springframework.stereotype.Controller;

import br.com.jgle.acti.entity.LogAcesso;

@Scope("page")
@Controller
public class LogAcessoController extends AbstractController<LogAcesso> {

	private static final long serialVersionUID = 1L;

	public LogAcessoController() {
		super(new LogAcesso());
	}

}
