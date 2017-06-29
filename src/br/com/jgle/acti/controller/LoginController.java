package br.com.jgle.acti.controller;

import java.util.List;

import org.springframework.context.annotation.Scope;
import org.springframework.stereotype.Controller;
import org.zkoss.spring.context.annotation.AppliedTo;

import br.com.jgle.acti.entity.Login;
import br.com.jgle.acti.entity.Unidade;

@Scope("page")
@Controller
@AppliedTo("entityWin")
public class LoginController extends AbstractController<Login> {

	public LoginController() {
		super(new Login());
	}

	@SuppressWarnings({ "rawtypes", "unchecked" })
	public LoginController(AbstractController parent) {
		super(new Login(), parent);
	}

	private static final long serialVersionUID = 1L;

	public List<Unidade> getUnidades() {
		return genericService.procurarTodos(Unidade.class);
	}

}
