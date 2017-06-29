package br.com.jgle.acti.controller;

import java.util.List;

import org.springframework.context.annotation.Scope;
import org.springframework.stereotype.Controller;

import br.com.jgle.acti.entity.VeiculoAdicional;
import br.com.jgle.acti.entity.pgr.Adicional;

@Scope("page")
@Controller
public class VeiculoAdicionalController extends AbstractController<VeiculoAdicional> {

	private static final long serialVersionUID = 1L;

	public VeiculoAdicionalController() {
		super(new VeiculoAdicional());
	}

	@SuppressWarnings({ "rawtypes", "unchecked" })
	public VeiculoAdicionalController(AbstractController parent) {
		super(new VeiculoAdicional(), parent);
	}

	public List<Adicional> getAdicionais() {
		return parent.getGenericService().procurarTodos(Adicional.class);
	}

}
