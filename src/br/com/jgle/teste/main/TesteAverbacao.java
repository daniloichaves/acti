package br.com.jgle.teste.main;

import java.util.Date;

import br.com.jgle.acti.averbacao.AverbacaoEntity;
import br.com.jgle.acti.util.ArquivoUtil;
import br.com.jgle.acti.util.DateUtil;
import br.com.jgle.acti.util.StringUtil;

public class TesteAverbacao {

	public static void main(String[] args) throws Exception {
		AverbacaoEntity averbacaoEntity = new AverbacaoEntity();
		// averbacaoEntity.get
		averbacaoEntity.getTipoAverbacao().setValor("1");
		averbacaoEntity.getTipoDocumentoAverbação().setValor("2");
		averbacaoEntity.getNumeroDocumento().setValor("12345");
		averbacaoEntity.getSerieDocumento().setValor("A");
		averbacaoEntity.getSubSerieDocumento().setValor("B");
		averbacaoEntity.getEstadoOrigem().setValor("SP");
		averbacaoEntity.getEstadoDestino().setValor("BA");
		averbacaoEntity.getCodigoMercadoria().setValor("423");
		averbacaoEntity.getMercadoriaNova().setValor("S");
		averbacaoEntity.getDataSaída().setValor(DateUtil.format(new Date(), "yyyyMMdd"));
		// Remover o ponto ou virgula do centavos
		averbacaoEntity.getiSTTN().setValor("50000");
		averbacaoEntity.getiSRCTR_C().setValor("50000");
		averbacaoEntity.getiSRCF_DC().setValor("50000");
		averbacaoEntity.getContainerRCTR_C().setValor("60000");
		averbacaoEntity.getContainerRCF_DC().setValor("60000");

		averbacaoEntity.getPlaca().setValor("DWO5895");
		averbacaoEntity.getCPFMotorista().setValor("22952158896");
		averbacaoEntity.getRebocador().setValor("rebocador");
		averbacaoEntity.getBalsa().setValor("balsa");
		averbacaoEntity.getVeículoProprio().setValor("S");
		averbacaoEntity.getRodofluvial().setValor("S");
		averbacaoEntity.getImportaçãoExportação().setValor("E");
		averbacaoEntity.getPaís().setValor("55");
		averbacaoEntity.getCoberturaOCD().setValor("2");

		String linha = averbacaoEntity.toString();

		ArquivoUtil.criarArquivo(linha.getBytes(), "averbacao.txt", "/tmp/");

		System.out.println("Teste linha: " + linha);
	}

	public static void main2(String[] args) {
		String escrever = StringUtil.escrever("", 48, 10, "danilo");

		System.out.println("Resultado: " + escrever);

		escrever = StringUtil.escrever(escrever, 0, 4, "dan");

		System.out.println("Resultado: " + escrever);
	}
}
