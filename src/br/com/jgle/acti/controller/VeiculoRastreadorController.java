package br.com.jgle.acti.controller;

import java.util.List;

import org.springframework.context.annotation.Scope;
import org.springframework.stereotype.Controller;

import br.com.jgle.acti.entity.VeiculoRastreador;
import br.com.jgle.acti.entity.pgr.Rastreador;

@Scope("page")
@Controller
public class VeiculoRastreadorController extends
		AbstractController<VeiculoRastreador> {

	private static final long serialVersionUID = 1L;

	public VeiculoRastreadorController() {
		super(new VeiculoRastreador());
	}

	@SuppressWarnings({ "rawtypes", "unchecked" })
	public VeiculoRastreadorController(AbstractController parent) {
		super(new VeiculoRastreador(), parent);
	}
	
	public List<Rastreador> getRastreadores(){
		return parent.getGenericService().procurarTodos(Rastreador.class);
	}

}
