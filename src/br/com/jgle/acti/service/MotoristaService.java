package br.com.jgle.acti.service;

import java.util.ArrayList;
import java.util.Calendar;
import java.util.Collections;
import java.util.Date;
import java.util.List;

import javax.annotation.Resource;

import org.springframework.stereotype.Service;

import br.com.jgle.acti.entity.Motorista;
import br.com.jgle.acti.entity.Veiculo;
import br.com.jgle.acti.util.DateUtil;

@Service
public class MotoristaService {

	@Resource
	protected GenericService genericService;

	@Resource
	protected CRLVService crlvService;

	public List<Motorista> getMotoristaCNHAVencer() {

		Date data = DateUtil.getDate();
		data = DateUtil.adicionarDias(data, 60);

		String sql = "Select m from Motorista as m where m.cnhDataValidate < :data";
		List<Motorista> motoristaCartaAVencer = genericService.executeQuery(
				sql, "data", data);

		return motoristaCartaAVencer;
	}

	public List<Veiculo> getVeiculosSeguroAVencer() {

		Date data = DateUtil.getDate();
		data = DateUtil.adicionarDias(data, 60);
		String sql = "SELECT v FROM Veiculo v WHERE v.dataVencimentoSeguro < :data";

		List<Veiculo> veiculosSegurosAVencer = genericService.executeQuery(sql,
				"data", data);

		return veiculosSegurosAVencer;
	}

	/**
	 * Conforme lista do DETRAN
	 * 
	 * http://www.detran.sp.gov.br/legis/portaria_2009_2405.asp
	 * 
	 * @return List<Veiculo>
	 */
	@SuppressWarnings("unchecked")
	public List<Veiculo> getVeiculosCRLVAVencer() {
		try {

			List<Veiculo> veiculos = genericService
					.procurarTodos(Veiculo.class);
			List<Veiculo> veiculosCRLVAVencer = new ArrayList<Veiculo>();
			Date data = DateUtil.getDate();
			Calendar calendar = DateUtil.getCalendar(data);

			for (Veiculo veiculo : veiculos) {
				String placa = veiculo.getPlaca();
				if(placa == null)
					placa = "ZZZ9999";
				char charAt = placa.charAt(placa.length() - 1);
				int finalPlaca = new Integer(charAt);

				@SuppressWarnings("static-access")
				int mesCRLVCaminhao = crlvService
						.getMesCRLVCaminhao(finalPlaca);

				// TODO Verificar classificação
				if (mesCRLVCaminhao == calendar.get(Calendar.MONTH)
						|| mesCRLVCaminhao == calendar.get(Calendar.MONTH) + 1) {

					veiculosCRLVAVencer.add(veiculo);

				}

			}

			return veiculosCRLVAVencer;

		} catch (Exception e) {
			e.printStackTrace();
			return Collections.EMPTY_LIST;
		}
	}

	public GenericService getGenericService() {
		return genericService;
	}

	public void setGenericService(GenericService genericService) {
		this.genericService = genericService;
	}

	public CRLVService getCrlvService() {
		return crlvService;
	}

	public void setCrlvService(CRLVService crlvService) {
		this.crlvService = crlvService;
	}

}
