package br.com.jgle.acti.controller;

import java.util.List;

import javax.annotation.Resource;

import org.springframework.context.annotation.Scope;
import org.springframework.stereotype.Controller;
import org.zkoss.zk.ui.Component;
import org.zkoss.zk.ui.event.Event;
import org.zkoss.zk.ui.util.GenericForwardComposer;
import org.zkoss.zul.Label;
import org.zkoss.zul.Row;

import br.com.jgle.acti.entity.Motorista;
import br.com.jgle.acti.service.GenericService;
import br.com.jgle.acti.service.MotoristaService;

@SuppressWarnings("serial")
@Scope("page")
@Controller
public class DashboardController extends GenericForwardComposer {

	@Resource
	protected GenericService genericService;

	@Resource
	protected MotoristaService motoristaService;

	protected Component cnhavenderRows;

	public void onCreate$cnhavenderRows(Event event) {

		List<Motorista> motoristaCNHAVencer = motoristaService
				.getMotoristaCNHAVencer();

		for (Motorista motorista : motoristaCNHAVencer) {

			Row row = new Row();
			Label cadastro = new Label("Motorista");
			Label descricao = new Label("CNH está vencendo");
			Label identificador = new Label(motorista.getApelido());

			cadastro.setParent(row);
			descricao.setParent(row);
			identificador.setParent(row);

			row.setParent(cnhavenderRows);
		}
	}

	public GenericService getGenericService() {
		return genericService;
	}

	public void setGenericService(GenericService genericService) {
		this.genericService = genericService;
	}

	public MotoristaService getMotoristaService() {
		return motoristaService;
	}

	public void setMotoristaService(MotoristaService motoristaService) {
		this.motoristaService = motoristaService;
	}

	public Component getCnhavenderRows() {
		return cnhavenderRows;
	}

	public void setCnhavenderRows(Component cnhavenderRows) {
		this.cnhavenderRows = cnhavenderRows;
	}

}
