package br.com.jgle.acti.controller;

import java.util.ArrayList;
import java.util.List;
import java.util.Set;

import javax.annotation.Resource;

import org.springframework.context.annotation.Scope;
import org.springframework.stereotype.Controller;
import org.zkoss.zk.ui.Component;
import org.zkoss.zk.ui.event.Event;
import org.zkoss.zul.Image;
import org.zkoss.zul.Listitem;
import org.zkoss.zul.api.Listbox;

import br.com.jgle.acti.entity.Motorista;
import br.com.jgle.acti.entity.Proprietario;
import br.com.jgle.acti.entity.Unidade;
import br.com.jgle.acti.entity.Veiculo;
import br.com.jgle.acti.entity.pgr.Adicional;
import br.com.jgle.acti.entity.pgr.Atuador;
import br.com.jgle.acti.entity.pgr.Sensor;
import br.com.jgle.acti.exception.ServiceException;
import br.com.jgle.acti.service.BrasilRiskService;

@Scope("page")
@Controller
public class VeiculoController extends AbstractController<Veiculo> {

	private static final long serialVersionUID = 1L;

	@Resource
	protected BrasilRiskService brasilRiskService;

	protected VeiculoRastreadorController veiculoRastreadorController;
	protected VeiculoSensorController veiculoSensorController;
	protected VeiculoAdicionalController veiculoAdicionalController;
	protected VeiculoServicoManutencaoController veiculoServicoManutencaoController;

	// Integração
	protected Component entitySync; // sync button

	public VeiculoController() {
		super(new Veiculo());

		veiculoRastreadorController = new VeiculoRastreadorController(this);
		veiculoAdicionalController = new VeiculoAdicionalController(this);
		veiculoSensorController = new VeiculoSensorController(this);
		veiculoServicoManutencaoController = new VeiculoServicoManutencaoController(
				this);
	}
	
	public List<Unidade> getUnidades() {
		return genericService.procurarTodos(Unidade.class);
	}

	public List<Proprietario> getProprietarios() {
		return genericService.procurarTodos(Proprietario.class);
	}

	public List<Motorista> getMotoristas() {
		return genericService.procurarTodos(Motorista.class);
	}

	public void onClick$entitySync(Event event) {
		try {
			brasilRiskService.cadastraVeiculo(selected);
		} catch (ServiceException e) {
			e.printStackTrace();
		}
	}
	
	// Adicionais, sensores, atuadores
	protected Component sensoresBox;
	protected Listbox leftSensores;
	protected Listbox rightSensores;
	protected Image addSensores;
	protected Image removeSensores;

	protected Component atuadoresBox;
	protected Listbox leftAtuadores;
	protected Listbox rightAtuadores;
	protected Image addAtuadores;
	protected Image removeAtuadores;

	protected Component adicionaisBox;
	protected Listbox leftAdicionais;
	protected Listbox rightAdicionais;
	protected Image addAdicionais;
	protected Image removeAdicionais;
	
	public List<Sensor> getSensores() {

		List<Sensor> procurarTodos = genericService.procurarTodos(Sensor.class);
		procurarTodos.removeAll(selected.getSensors());

		return procurarTodos;
	}

	public List<Atuador> getAtuadores() {
		List<Atuador> procurarTodos = genericService
				.procurarTodos(Atuador.class);
		procurarTodos.removeAll(selected.getAtuadors());

		return procurarTodos;

	}

	public List<Adicional> getAdicionais() {
		List<Adicional> procurarTodos = genericService
				.procurarTodos(Adicional.class);
		procurarTodos.removeAll(selected.getAdicionals());

		return procurarTodos;
	}
	
	@SuppressWarnings({ "rawtypes", "unchecked" })
	public void onClick$addSensores(Event event) {
		Set items = leftSensores.getSelectedItems();
		if (items.isEmpty()) {
			alert("Por favor, selecione um produto para ser adicionado!");
		} else {
			List al = new ArrayList(items);
			List<Sensor> sensors = new ArrayList(getSensores());
			List<Sensor> sensorsRemover = new ArrayList<Sensor>();

			for (int i = 0; i < al.size(); i++) {
				Listitem li = (Listitem) al.get(i);
				li.setSelected(false);
				rightSensores.appendChild(li);

				Sensor sensor = sensors.get(i);
				selected.getSensors().add(sensor);
				sensorsRemover.add(sensor);
			}
			sensors.remove(sensorsRemover);
		}

		binder.loadComponent(sensoresBox);
	}

	@SuppressWarnings({ "rawtypes", "unchecked" })
	public void onClick$addAtuadores(Event event) {
		Set items = leftAtuadores.getSelectedItems();
		if (items.isEmpty()) {
			alert("Por favor, selecione um produto para ser adicionado!");
		} else {
			List al = new ArrayList(items);
			List<Atuador> atuadors = new ArrayList(getAtuadores());
			List<Atuador> atuadorsRemover = new ArrayList<Atuador>();

			for (int i = 0; i < al.size(); i++) {
				Listitem li = (Listitem) al.get(i);
				li.setSelected(false);
				rightAtuadores.appendChild(li);

				Atuador atuador = atuadors.get(i);
				selected.getAtuadors().add(atuador);
				atuadorsRemover.add(atuador);
			}
			atuadors.remove(atuadorsRemover);
		}

		binder.loadComponent(atuadoresBox);
	}

	@SuppressWarnings({ "rawtypes", "unchecked" })
	public void onClick$addAdicionais(Event event) {
		Set items = leftAdicionais.getSelectedItems();
		if (items.isEmpty()) {
			alert("Por favor, selecione um produto para ser adicionado!");
		} else {
			List al = new ArrayList(items);
			List<Adicional> adicionals = new ArrayList(getAdicionais());
			List<Adicional> adicionalsRemover = new ArrayList<Adicional>();

			for (int i = 0; i < al.size(); i++) {
				Listitem li = (Listitem) al.get(i);
				li.setSelected(false);
				rightAdicionais.appendChild(li);

				Adicional adicional = adicionals.get(i);
				selected.getAdicionals().add(adicional);
				adicionalsRemover.add(adicional);
			}
			adicionals.remove(adicionalsRemover);
		}

		binder.loadComponent(adicionaisBox);
	}
	
	@SuppressWarnings({ "rawtypes", "unchecked" })
	public void onClick$removeSensores(Event event) {
		Set items = rightSensores.getSelectedItems();
		if (items.isEmpty()) {
			alert("Por favor, selecione um produto para ser removido!");
		} else {
			List al = new ArrayList(items);
			List<Sensor> kitSensor = new ArrayList<Sensor>(
					selected.getSensors());
			for (int i = 0; i < al.size(); i++) {
				Listitem li = (Listitem) al.get(i);
				li.setSelected(false);
				leftSensores.appendChild(li);

				Sensor sensor = kitSensor.get(i);
				getSensores().add(sensor);
				selected.getSensors().remove(sensor);
			}
			for (int i = 0; i < al.size(); i++) {
				Sensor sensor = kitSensor.get(i);
				selected.getSensors().remove(sensor);
			}
		}
		binder.loadComponent(sensoresBox);
	}

	@SuppressWarnings({ "rawtypes", "unchecked" })
	public void onClick$removeAtuadores(Event event) {
		Set items = rightAtuadores.getSelectedItems();
		if (items.isEmpty()) {
			alert("Por favor, selecione um produto para ser removido!");
		} else {
			List al = new ArrayList(items);
			List<Atuador> kitAtuador = new ArrayList<Atuador>(
					selected.getAtuadors());
			for (int i = 0; i < al.size(); i++) {
				Listitem li = (Listitem) al.get(i);
				li.setSelected(false);
				leftAtuadores.appendChild(li);

				Atuador atuador = kitAtuador.get(i);
				getAtuadores().add(atuador);
				selected.getAtuadors().remove(atuador);
			}
			for (int i = 0; i < al.size(); i++) {
				Atuador atuador = kitAtuador.get(i);
				selected.getAtuadors().remove(atuador);
			}
		}
		binder.loadComponent(atuadoresBox);
	}

	@SuppressWarnings({ "rawtypes", "unchecked" })
	public void onClick$removeAdicionais(Event event) {
		Set items = rightAdicionais.getSelectedItems();
		if (items.isEmpty()) {
			alert("Por favor, selecione um produto para ser removido!");
		} else {
			List al = new ArrayList(items);
			List<Adicional> kitAdicional = new ArrayList<Adicional>(
					selected.getAdicionals());
			for (int i = 0; i < al.size(); i++) {
				Listitem li = (Listitem) al.get(i);
				li.setSelected(false);
				leftAdicionais.appendChild(li);

				Adicional adicional = kitAdicional.get(i);
				getAdicionais().add(adicional);
				selected.getAdicionals().remove(adicional);
			}
			for (int i = 0; i < al.size(); i++) {
				Adicional adicional = kitAdicional.get(i);
				selected.getAdicionals().remove(adicional);
			}
		}
		binder.loadComponent(adicionaisBox);
	}

	// Gett's and Sett's
	public BrasilRiskService getBrasilRiskService() {
		return brasilRiskService;
	}

	public void setBrasilRiskService(BrasilRiskService brasilRiskService) {
		this.brasilRiskService = brasilRiskService;
	}

	public Component getEntitySync() {
		return entitySync;
	}

	public void setEntitySync(Component entitySync) {
		this.entitySync = entitySync;
	}

	public VeiculoRastreadorController getVeiculoRastreadorController() {
		return veiculoRastreadorController;
	}

	public void setVeiculoRastreadorController(
			VeiculoRastreadorController veiculoRastreadorController) {
		this.veiculoRastreadorController = veiculoRastreadorController;
	}

	public VeiculoServicoManutencaoController getVeiculoServicoManutencaoController() {
		return veiculoServicoManutencaoController;
	}

	public void setVeiculoServicoManutencaoController(
			VeiculoServicoManutencaoController veiculoServicoManutencaoController) {
		this.veiculoServicoManutencaoController = veiculoServicoManutencaoController;
	}

	public VeiculoSensorController getVeiculoSensorController() {
		return veiculoSensorController;
	}

	public void setVeiculoSensorController(
			VeiculoSensorController veiculoSensorController) {
		this.veiculoSensorController = veiculoSensorController;
	}

	public VeiculoAdicionalController getVeiculoAdicionalController() {
		return veiculoAdicionalController;
	}

	public void setVeiculoAdicionalController(VeiculoAdicionalController veiculoAdicionalController) {
		this.veiculoAdicionalController = veiculoAdicionalController;
	}

	public Component getSensoresBox() {
		return sensoresBox;
	}

	public void setSensoresBox(Component sensoresBox) {
		this.sensoresBox = sensoresBox;
	}

	public Listbox getLeftSensores() {
		return leftSensores;
	}

	public void setLeftSensores(Listbox leftSensores) {
		this.leftSensores = leftSensores;
	}

	public Listbox getRightSensores() {
		return rightSensores;
	}

	public void setRightSensores(Listbox rightSensores) {
		this.rightSensores = rightSensores;
	}

	public Image getAddSensores() {
		return addSensores;
	}

	public void setAddSensores(Image addSensores) {
		this.addSensores = addSensores;
	}

	public Image getRemoveSensores() {
		return removeSensores;
	}

	public void setRemoveSensores(Image removeSensores) {
		this.removeSensores = removeSensores;
	}

	public Component getAtuadoresBox() {
		return atuadoresBox;
	}

	public void setAtuadoresBox(Component atuadoresBox) {
		this.atuadoresBox = atuadoresBox;
	}

	public Listbox getLeftAtuadores() {
		return leftAtuadores;
	}

	public void setLeftAtuadores(Listbox leftAtuadores) {
		this.leftAtuadores = leftAtuadores;
	}

	public Listbox getRightAtuadores() {
		return rightAtuadores;
	}

	public void setRightAtuadores(Listbox rightAtuadores) {
		this.rightAtuadores = rightAtuadores;
	}

	public Image getAddAtuadores() {
		return addAtuadores;
	}

	public void setAddAtuadores(Image addAtuadores) {
		this.addAtuadores = addAtuadores;
	}

	public Image getRemoveAtuadores() {
		return removeAtuadores;
	}

	public void setRemoveAtuadores(Image removeAtuadores) {
		this.removeAtuadores = removeAtuadores;
	}

	public Component getAdicionaisBox() {
		return adicionaisBox;
	}

	public void setAdicionaisBox(Component adicionaisBox) {
		this.adicionaisBox = adicionaisBox;
	}

	public Listbox getLeftAdicionais() {
		return leftAdicionais;
	}

	public void setLeftAdicionais(Listbox leftAdicionais) {
		this.leftAdicionais = leftAdicionais;
	}

	public Listbox getRightAdicionais() {
		return rightAdicionais;
	}

	public void setRightAdicionais(Listbox rightAdicionais) {
		this.rightAdicionais = rightAdicionais;
	}

	public Image getAddAdicionais() {
		return addAdicionais;
	}

	public void setAddAdicionais(Image addAdicionais) {
		this.addAdicionais = addAdicionais;
	}

	public Image getRemoveAdicionais() {
		return removeAdicionais;
	}

	public void setRemoveAdicionais(Image removeAdicionais) {
		this.removeAdicionais = removeAdicionais;
	}

	public static long getSerialversionuid() {
		return serialVersionUID;
	}
}
