package br.com.jgle.acti.service;

import java.io.BufferedWriter;
import java.io.File;
import java.io.FileWriter;

import javax.annotation.Resource;

import org.springframework.stereotype.Service;

import br.com.jgle.acti.averbacao.AverbacaoEntity;
import br.com.jgle.acti.entity.Conhecimento;
import br.com.jgle.acti.exception.ServiceException;
import br.com.jgle.acti.util.DateUtil;
import br.com.jgle.acti.util.PropertiesUtil;

@Service
public class AverbacaoService {

	@Resource
	protected GenericService genericService;

	// Tipos de seguros está na apolice via de regra 3
	public static final String TIPO_AVERBACAO;
	public static final String VALOR_ISRCF_DC;
	public static final String VALOR_CONTAINER_RCTR_C;
	public static final String VALOR_CONTAINER_RCF_DC;
	public static final String COBERTURA_OCD;
	// Sempre por conhecimento
	public static final String TIPO_DOCUMENTO;

	static {
		TIPO_AVERBACAO = PropertiesUtil.getPropertyValue("averbacao.tipo.averbacao");
		VALOR_ISRCF_DC = PropertiesUtil.getPropertyValue("averbacao.valor.isrcf.dc");
		VALOR_CONTAINER_RCTR_C = PropertiesUtil.getPropertyValue("averbacao.valor.container.rctr.c");
		VALOR_CONTAINER_RCF_DC = PropertiesUtil.getPropertyValue("averbacao.valor.container.rcf.dc");
		COBERTURA_OCD = PropertiesUtil.getPropertyValue("averbacao.cobertura.ocd");
		TIPO_DOCUMENTO = PropertiesUtil.getPropertyValue("averbacao.tipo.documento");
	}

	public File criarArquivoAverbacao(Conhecimento conhecimento) throws ServiceException {

		AverbacaoEntity averbacaoEntity = new AverbacaoEntity();

		try {

			averbacaoEntity.getTipoAverbacao().setValor(TIPO_AVERBACAO);
			averbacaoEntity.getTipoDocumentoAverbação().setValor(TIPO_DOCUMENTO);
			averbacaoEntity.getNumeroDocumento().setValor(conhecimento.getCtrc());
			averbacaoEntity.getSerieDocumento().setValor(conhecimento.getSerie());
			averbacaoEntity.getSubSerieDocumento().setValor(conhecimento.getSubSerie());
			if (conhecimento.getRemetente() != null)
				averbacaoEntity.getEstadoOrigem().setValor(conhecimento.getRemetente().getEstado());
			if (conhecimento.getDestinatario() != null)
				averbacaoEntity.getEstadoDestino().setValor(conhecimento.getDestinatario().getEstado());
			// Não é usado
			// averbacaoEntity.getCodigoMercadoria().setValor("");
			// averbacaoEntity.getMercadoriaNova().setValor("S");
			if (conhecimento.getDataHoraInicialEntrega() != null)
				averbacaoEntity.getDataSaída().setValor(DateUtil.format(conhecimento.getDataHoraInicialEntrega(), "yyyyMMdd"));
			// Remover o ponto ou virgula do centavos
			// averbacaoEntity.getiSTTN().setValor("50000");
			// Total conhecimento
			String totalFrete = conhecimento.getTotalFreteBruto().toString();
			totalFrete = totalFrete.replaceAll(",", "");
			totalFrete = totalFrete.replaceAll(".", "");
			averbacaoEntity.getiSRCTR_C().setValor(totalFrete);
			averbacaoEntity.getiSRCF_DC().setValor(VALOR_ISRCF_DC);

			averbacaoEntity.getContainerRCTR_C().setValor(VALOR_CONTAINER_RCTR_C);
			averbacaoEntity.getContainerRCF_DC().setValor(VALOR_CONTAINER_RCF_DC);

			if (conhecimento.getVeiculoEntrega() != null)
				averbacaoEntity.getPlaca().setValor(conhecimento.getVeiculoEntrega().getPlaca());
			if (conhecimento.getMotoristaEntrega() != null)
				averbacaoEntity.getCPFMotorista().setValor(conhecimento.getMotoristaEntrega().getCpf());
			// Não é usado
			// averbacaoEntity.getRebocador().setValor("");
			// averbacaoEntity.getBalsa().setValor("");
			averbacaoEntity.getVeículoProprio().setValor("S");
			averbacaoEntity.getRodofluvial().setValor("S");

			// Não é usado
			// averbacaoEntity.getImportaçãoExportação().setValor("");
			// averbacaoEntity.getPaís().setValor("55");
			averbacaoEntity.getCoberturaOCD().setValor(COBERTURA_OCD);

			File file = new File(PropertiesUtil.getPropertyValue("pach.name.file.averbacao"));
			FileWriter fw = new FileWriter(file);
			BufferedWriter out = new BufferedWriter(fw);

			out.write(averbacaoEntity.toString());
			out.close();

			return file;

		} catch (Exception e) {
			e.printStackTrace();
			throw new ServiceException(e.getMessage());
		}
	}
}
