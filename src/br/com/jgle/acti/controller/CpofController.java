package br.com.jgle.acti.controller;

import org.springframework.context.annotation.Scope;
import org.springframework.stereotype.Controller;

import br.com.jgle.acti.entity.Cpof;

@Scope("page")
@Controller
public class CpofController extends AbstractController<Cpof> {

	private static final long serialVersionUID = 1L;

	public CpofController() {
		super(new Cpof());
	}

}
