package br.com.jgle.acti.controller.pgr;

import java.util.List;

import org.springframework.context.annotation.Scope;
import org.springframework.stereotype.Controller;

import br.com.jgle.acti.controller.AbstractController;
import br.com.jgle.acti.entity.estoque.Grupo;
import br.com.jgle.acti.entity.pgr.GrupoMercadoria;
import br.com.jgle.acti.service.GenericService;

@Scope("page")
@Controller
public class GrupoMercadoriaController extends AbstractController<GrupoMercadoria> {

	private static final long serialVersionUID = 1L;

	public GrupoMercadoriaController() {
		super(new GrupoMercadoria());

	}

	@SuppressWarnings({ "rawtypes", "unchecked" })
	public GrupoMercadoriaController(AbstractController parent) {
		super(new GrupoMercadoria(), parent);
	}

	public List<Grupo> getGrupos() {
		return parent.getGenericService().procurarTodos(Grupo.class);
	}

	public GenericService getGenericService() {
		return genericService;
	}

	public void setGenericService(GenericService genericService) {
		this.genericService = genericService;
	}

}
