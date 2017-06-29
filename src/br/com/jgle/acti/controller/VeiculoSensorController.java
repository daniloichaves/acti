package br.com.jgle.acti.controller;

import java.util.List;

import org.springframework.context.annotation.Scope;
import org.springframework.stereotype.Controller;

import br.com.jgle.acti.entity.VeiculoSensor;
import br.com.jgle.acti.entity.pgr.Sensor;

@Scope("page")
@Controller
public class VeiculoSensorController extends
		AbstractController<VeiculoSensor> {

	private static final long serialVersionUID = 1L;

	public VeiculoSensorController() {
		super(new VeiculoSensor());
	}

	@SuppressWarnings({ "rawtypes", "unchecked" })
	public VeiculoSensorController(AbstractController parent) {
		super(new VeiculoSensor(), parent);
	}
	
	public List<Sensor> getSensores(){
		return parent.getGenericService().procurarTodos(Sensor.class);
	}

}
