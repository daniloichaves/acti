package br.com.jgle.acti.service;

import java.io.StringWriter;

import javax.annotation.Resource;
import javax.xml.bind.JAXBContext;
import javax.xml.bind.Marshaller;

import org.springframework.stereotype.Service;

import _59._12._54._201.WS.BrasilRiskSoapProxy;
import _59._12._54._201.WS.CadastrarCPFRequest;
import _59._12._54._201.WS.CadastrarCPFResposta;
import _59._12._54._201.WS.CadastrarVeiculoRequest;
import _59._12._54._201.WS.CadastrarVeiculoResposta;
import _59._12._54._201.WS.ConsultaCPFMotoristaResposta;
import _59._12._54._201.WS.ConsultaPlacaVeiculoResposta;
import _59._12._54._201.WS.SolicitacaoMonitoramentoResposta;
import br.com.jgle.acti.entity.ColetaEndereco;
import br.com.jgle.acti.entity.Conhecimento;
import br.com.jgle.acti.entity.Endereco;
import br.com.jgle.acti.entity.Motorista;
import br.com.jgle.acti.entity.NotaFiscal;
import br.com.jgle.acti.entity.Proprietario;
import br.com.jgle.acti.entity.Telefone;
import br.com.jgle.acti.entity.Veiculo;
import br.com.jgle.acti.entity.VeiculoRastreador;
import br.com.jgle.acti.entity.brasilrisk.Destino;
import br.com.jgle.acti.entity.brasilrisk.Destinos;
import br.com.jgle.acti.entity.brasilrisk.OrigemParada;
import br.com.jgle.acti.entity.brasilrisk.Paradas;
import br.com.jgle.acti.entity.brasilrisk.Planejamento;
import br.com.jgle.acti.entity.brasilrisk.Solicitacaomonitoramento;
import br.com.jgle.acti.exception.ServiceException;
import br.com.jgle.acti.util.DateUtil;
import br.com.jgle.acti.util.PropertiesUtil;

@Service
public class BrasilRiskService {

	protected BrasilRiskSoapProxy brasilRiskSoapProxy = new BrasilRiskSoapProxy();
	@Resource
	protected GenericService genericService;

	protected static String AUTENTICACAO;
	
	static {
		AUTENTICACAO = PropertiesUtil.getPropertyValue("brasil.risk.autenticacao");
	}

	public boolean cadastraMotorista(Motorista motorista) throws ServiceException {
		CadastrarCPFRequest cadastrarCPFRequest = new CadastrarCPFRequest();
		try {

			cadastrarCPFRequest.setAutenticacao(AUTENTICACAO);

			cadastrarCPFRequest.setFuncao("M");

			cadastrarCPFRequest.setNome(motorista.getNome() + motorista.getSobrenome());
			cadastrarCPFRequest.setCPF(motorista.getCpf());
			cadastrarCPFRequest.setRG(motorista.getRg());
			cadastrarCPFRequest.setOrgaoExpeditor(motorista.getOrgaoExpeditor());
			cadastrarCPFRequest.setDataEmissao(DateUtil.getCalendar(motorista.getDataEmissao()));
			cadastrarCPFRequest.setDataNascimento(DateUtil.getCalendar(motorista.getDataNascimento()));
			cadastrarCPFRequest.setNomePai(motorista.getNomePai());
			cadastrarCPFRequest.setNomeMae(motorista.getNomeMae());
			
			cadastrarCPFRequest.setPerfil(motorista.getPerfilBrasilRisk());
			
			if(motorista.getEnderecos() != null && !motorista.getEnderecos().isEmpty()){
				Endereco primeiroEndereco = motorista.getEnderecos().iterator().next();
				cadastrarCPFRequest.setEndereco(primeiroEndereco.getEndereco());
				cadastrarCPFRequest.setNumero(primeiroEndereco.getNumero());
				cadastrarCPFRequest.setCEP(primeiroEndereco.getCep());
				cadastrarCPFRequest.setBairro(primeiroEndereco.getBairro());
				cadastrarCPFRequest.setCidade(primeiroEndereco.getCidade());
				cadastrarCPFRequest.setUF(primeiroEndereco.getUf());
				cadastrarCPFRequest.setComplemento(primeiroEndereco.getPontoReferencia());
			}

			Telefone celular = motorista.getPrimeiroCelular();
			if (celular != null) {
				cadastrarCPFRequest.setCelular(celular.getDdi() + celular.getDdd() + celular.getNumero());
			}
			
			Telefone comercial = motorista.getPrimeiroComercial();
			if (comercial != null) {
				cadastrarCPFRequest.setTelefone(comercial.getDdi() + comercial.getDdd() + comercial.getNumero());
			}

			cadastrarCPFRequest.setCNH(motorista.getCnh());
			cadastrarCPFRequest.setCNHUF(motorista.getCnhUf());
			cadastrarCPFRequest.setCNHRegistro(motorista.getCnhRegistro());
			cadastrarCPFRequest.setCNHValidade(DateUtil.getCalendar(motorista.getCnhDataValidate()));
			cadastrarCPFRequest.setCNHCategoria(motorista.getCategoria());

			CadastrarCPFResposta cadastrarCPFResposta = brasilRiskSoapProxy.cadastrarCPF(cadastrarCPFRequest);

			// 0 = sucesso
			// 1 = erro
			if (cadastrarCPFResposta.getRetornoErro() == 0) {
				motorista.setBrasilRiskStatus("Cadastrado");
				motorista.setBrasilRiskDataSync(DateUtil.getDate());

				genericService.atualizar(motorista);
			} else {
				throw new ServiceException(cadastrarCPFResposta.getMensagemErro());
			}

		} catch (Exception e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
			throw new ServiceException(e.getMessage());
		}

		return true;

	}
	
	public boolean cadastraVeiculo(Veiculo veiculo) throws ServiceException {
	
		CadastrarVeiculoRequest cadastrarVeiculoRequest = new CadastrarVeiculoRequest(); 
		
		try {
			
			cadastrarVeiculoRequest.setAutenticacao(AUTENTICACAO);
			cadastrarVeiculoRequest.setCarreta_Placa(veiculo.getCarretaPlaca());
			cadastrarVeiculoRequest.setCarreta_Renavam(veiculo.getCarretaRenavan());
			cadastrarVeiculoRequest.setCarreta_Tipo(veiculo.getCarretaTipo());
			
			if(veiculo.getVeiculoRastreadores() != null && !veiculo.getVeiculoRastreadores().isEmpty()){
				VeiculoRastreador primeiroRastreador = veiculo.getVeiculoRastreadores().iterator().next();
				cadastrarVeiculoRequest.setEquipamento_Rastreamento(primeiroRastreador.getRastreador().getRastreador());
				cadastrarVeiculoRequest.setEquipamento_Status(primeiroRastreador.getEquipamentoStatusBrasilRisk());
				cadastrarVeiculoRequest.setNumero_Terminal(primeiroRastreador.getNumeroTerminal());
			}
			
			Proprietario proprietario = veiculo.getProprietario();
			cadastrarVeiculoRequest.setProprietario_CNPJ_CPF(proprietario.getCnpjcpf());
			cadastrarVeiculoRequest.setProprietario_Data_Nascimento(DateUtil.getCalendar(proprietario.getDataNascimento()));
			cadastrarVeiculoRequest.setProprietario_IE_RG(proprietario.getIerg());
			cadastrarVeiculoRequest.setProprietario_Nome(proprietario.getNomeProprietario());
			cadastrarVeiculoRequest.setProprietario_Nome_Mae(proprietario.getNomeMae());
			cadastrarVeiculoRequest.setProprietario_RG_UF(proprietario.getUfrg());
			cadastrarVeiculoRequest.setProprietario_Tipo_Pessoa(proprietario.getTipoPessoaBrasilRisk());
			
			cadastrarVeiculoRequest.setVeiculo_AnoFabricacao(veiculo.getAno());
			cadastrarVeiculoRequest.setVeiculo_Chassi(veiculo.getChassi());
			cadastrarVeiculoRequest.setVeiculo_Cidade(veiculo.getCidade());
			cadastrarVeiculoRequest.setVeiculo_Cor(veiculo.getCor());
			cadastrarVeiculoRequest.setVeiculo_Marca(veiculo.getMarca());
			cadastrarVeiculoRequest.setVeiculo_Modelo(veiculo.getModelo());
			cadastrarVeiculoRequest.setVeiculo_Placa(veiculo.getPlaca());
			cadastrarVeiculoRequest.setVeiculo_Renavam(veiculo.getRenavan());
			cadastrarVeiculoRequest.setVeiculo_Tipo(veiculo.getTipo());
			cadastrarVeiculoRequest.setVeiculo_UF(veiculo.getUf());
			
			CadastrarVeiculoResposta cadastrarVeiculoResposta = brasilRiskSoapProxy.cadastrarVeiculo(cadastrarVeiculoRequest);
			
			// 0 = sucesso
			// 1 = erro
			if (cadastrarVeiculoResposta.getRetornoErro() == 0) {
				veiculo.setBrasilRiskStatus("Cadastrado");
				veiculo.setBrasilRiskDataSync(DateUtil.getDate());

				genericService.atualizar(veiculo);
			} else {
				throw new ServiceException(cadastrarVeiculoResposta.getMensagemErro());
			}
			
		} catch (Exception e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
			throw new ServiceException(e.getMessage());
		}

		return true;
	
	}
	
	public boolean solicitacaoMonitoramento(Conhecimento conhecimento) throws ServiceException{
		
		try {
			Solicitacaomonitoramento solicitacaoMonitoramento = new Solicitacaomonitoramento();
			solicitacaoMonitoramento.setAutenticacao(AUTENTICACAO);
			solicitacaoMonitoramento.setTipo_gris(conhecimento.getTipoGrisBrasilRisk());
			solicitacaoMonitoramento.setCnpj_cliente(conhecimento.getClienteRemetente().getCnpjcpf());
			solicitacaoMonitoramento.setCentro_custo_cliente("transferencia");
			solicitacaoMonitoramento.setCnpj_transportadora("15.324.221/0001-92");
			solicitacaoMonitoramento.setCpf_motorista(conhecimento.getMotoristaEntrega().getCpf());
			solicitacaoMonitoramento.setPlaca_veiculo(conhecimento.getVeiculoEntrega().getPlaca());
			solicitacaoMonitoramento.setPlaca_carreta(conhecimento.getVeiculoEntrega().getCarretaPlaca());
			
			// Origem
			ColetaEndereco coletaEndereco = conhecimento.getRemetente();
			OrigemParada origem = new OrigemParada();
			origem.setUf(coletaEndereco.getUf());
			origem.setCidade(coletaEndereco.getCidade());
			origem.setLocal(conhecimento.getLocalEmissao());
			origem.setData(DateUtil.format(coletaEndereco.getDataHoraColeta(), "dd/MM/yyyy"));
			origem.setHora(DateUtil.format(coletaEndereco.getDataHoraColeta(), "hh:mm:ss"));
			solicitacaoMonitoramento.setOrigem(origem);
			
			// Destinos 
			ColetaEndereco coletaDestinatario = conhecimento.getDestinatario();
			Destinos destinos = new Destinos();
			Destino destino1 = new Destino();
			destino1.setUf(coletaDestinatario.getUf());
			destino1.setCidade(coletaDestinatario.getCidade());
			destino1.setLocal(coletaDestinatario.getNomeRazaoSocial());
			destino1.setPeso(conhecimento.getConhecimentoCalculoFreteUm().getFretePeso().toString());
			destino1.setValor(conhecimento.getConhecimentoCalculoFreteUm().getFreteValor().toString());
			
			NotaFiscal notasFiscais[] = conhecimento.getNotaFiscals().toArray(new NotaFiscal[0]);
			String tipoProduto = "geral";
			for (int i = 0; i < notasFiscais.length; i++) {
				if(i == 0) {
					destino1.setNotafiscal_1(notasFiscais[0].getNumeroNotaFical());
				//	tipoProduto += notasFiscais[0].getTipoProduto();
				}
				if(i == 1) {
					destino1.setNotafiscal_2(notasFiscais[1].getNumeroNotaFical());
				//	tipoProduto += " / " + notasFiscais[1].getTipoProduto();
				}
				
				if(i == 2) {
					destino1.setNotafiscal_3(notasFiscais[2].getNumeroNotaFical());
				//	tipoProduto += " / " + notasFiscais[2].getTipoProduto();
				}
			}
			
			solicitacaoMonitoramento.setTipo_produto(tipoProduto);
			
			destinos.getDestino().add(destino1);
			
			/*Destino destino2 = new Destino();
			destino2.setUf("uf");
			destino2.setCidade("cidade");
			destino2.setLocal("local");
			destino2.setPeso("peso");
			destino2.setValor("valor");
			destino2.setNotafiscal_1("notafiscal_1");
			destino2.setNotafiscal_2("notafiscal_2");
			destino2.setNotafiscal_3("notafiscal_3");
			destinos.getDestino().add(destino2);*/
			
			solicitacaoMonitoramento.setDestinos(destinos);
			
			// Planejamento
			Planejamento planejamento = new Planejamento();
			planejamento.setPrevisao_de_inicio_data(DateUtil.format(conhecimento.getDataHoraInicialEntrega(), "dd/MM/yyyy"));
			planejamento.setPrevisao_de_inicio_hora(DateUtil.format(conhecimento.getDataHoraInicialEntrega(), "hh:mm:ss"));
			planejamento.setPrevisao_de_termino_data(DateUtil.format(conhecimento.getDataHoraFinalEntrega(), "dd/MM/yyyy"));
			planejamento.setPrevisao_de_termino_hora(DateUtil.format(conhecimento.getDataHoraFinalEntrega(), "hh:mm:ss"));
			planejamento.setItinerario("itinerario");
			solicitacaoMonitoramento.setPlanejamento(planejamento);
			
			// Paradas
			Paradas paradas = new Paradas();
			OrigemParada parada1 = new OrigemParada();
			parada1.setUf("uf");
			parada1.setCidade("cidade");
			parada1.setLocal("local");
			parada1.setData("data");
			parada1.setHora("hora");
			paradas.getParada().add(parada1);
			
			OrigemParada parada2 = new OrigemParada();
			parada2.setUf("uf");
			parada2.setCidade("cidade");
			parada2.setLocal("local");
			parada2.setData("data");
			parada2.setHora("hora");
			paradas.getParada().add(parada2);
			
			solicitacaoMonitoramento.setParadas(paradas);
			
			solicitacaoMonitoramento.setObservacoes(conhecimento.getObservacao());
			
			JAXBContext jc = JAXBContext.newInstance(Solicitacaomonitoramento.class);
			Marshaller marshaller = jc.createMarshaller();
			
			StringWriter stringWriter = new StringWriter();
			marshaller.marshal(solicitacaoMonitoramento, stringWriter);
			
			System.out.println(stringWriter.toString());
			
			SolicitacaoMonitoramentoResposta solicitacaoMonitoramentoResposta = brasilRiskSoapProxy.solicitacaoMonitoramento(stringWriter.toString());
			
			// 0 = sucesso
			// 1 = erro
			if (solicitacaoMonitoramentoResposta.getRetornoErro() == 0) {
				//veiculo.setBrasilRiskStatus("Cadastrado");
				//veiculo.setBrasilRiskDataSync(DateUtil.getDate());

				//genericService.atualizar(veiculo);
			} else {
				throw new ServiceException(solicitacaoMonitoramentoResposta.getMensagemErro());
			}
		
		} catch (Exception e) {
			e.printStackTrace();
			throw new ServiceException(e);
		}
		
		return false;
	}
	
	public boolean consultaCPFMotorista(Motorista motorista) throws ServiceException {
		
		try {
		
			ConsultaCPFMotoristaResposta consultaCPFMotoristaResposta = brasilRiskSoapProxy.consultaCPFMotorista(motorista.getCpf(), AUTENTICACAO);
			
			// 0 = sucesso
			// 1 = erro
			if (consultaCPFMotoristaResposta.getRetornoErro() == 0) {
				// TODO verificar onde utilizaremos este metodo
				consultaCPFMotoristaResposta.getStatus(); // 1 = Quando o motorista estiver apto; 2 = Quando o motorista estiver inapto
				consultaCPFMotoristaResposta.getCNHDataValidade(); // validade da CNH
				consultaCPFMotoristaResposta.getCNHVencida(); // informa S/N se CNH estiver vencida
				consultaCPFMotoristaResposta.isCNHOK(); // informa S/N se houver restrição na CNH do motorista
				consultaCPFMotoristaResposta.isCreditoOK(); // informa S/N se o motorista tiver restrição financeira
				consultaCPFMotoristaResposta.isCriminalOK(); // informa S/N se o motorista tiver restrição criminal
				consultaCPFMotoristaResposta.getDataValidade(); //validade da pesquisa do motorista
			} else {
				throw new ServiceException(consultaCPFMotoristaResposta.getMensagemErro());
			}
			
		} catch (Exception e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
			throw new ServiceException(e.getMessage());
		}

		return true;
	}
	
	public boolean consultaPlacaVeiculo(Veiculo veiculo) throws ServiceException {
		
		try {
		
			ConsultaPlacaVeiculoResposta consultaPlacaVeiculoResposta = brasilRiskSoapProxy.consultaPlacaVeiculo("EMP4641", AUTENTICACAO);
			
			// 0 = sucesso
			// 1 = erro
			if (consultaPlacaVeiculoResposta.getRetornoErro() == 0) {
				// TODO verificar onde utilizaremos este metodo
				consultaPlacaVeiculoResposta.getStatus(); // 1 = Quando o veiculo estiver apto; 2 = Quando o veiculo estiver inapto
				consultaPlacaVeiculoResposta.isCreditoOK(); // informa S/N se o motorista tiver restrição financeira
				consultaPlacaVeiculoResposta.isCriminalOK(); // informa S/N se o motorista tiver restrição criminal
				consultaPlacaVeiculoResposta.isProprietarioOK(); // informa S/N se houver restrição na CNH do motorista
				consultaPlacaVeiculoResposta.getDataValidade(); //validade da pesquisa do veiculo
			} else {
				throw new ServiceException(consultaPlacaVeiculoResposta.getMensagemErro());
			}
			
		} catch (Exception e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
			throw new ServiceException(e.getMessage());
		}

		return true;
	}
	

	public BrasilRiskSoapProxy getBrasilRiskSoapProxy() {
		return brasilRiskSoapProxy;
	}

	public void setBrasilRiskSoapProxy(BrasilRiskSoapProxy brasilRiskSoapProxy) {
		this.brasilRiskSoapProxy = brasilRiskSoapProxy;
	}

	public GenericService getGenericService() {
		return genericService;
	}

	public void setGenericService(GenericService genericService) {
		this.genericService = genericService;
	}

}
