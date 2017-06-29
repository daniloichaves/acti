package br.com.jgle.acti.averbacao;

public class AverbacaoEntity {

	protected AtributoAvervacao tipoAverbacao = new AtributoAvervacao(1, "Tipo de averba��o", "C", 1, 1,
			"1 - TTN 2 - RCTR-C (S� poder� ser usado se n�o houver ap�lice do ramo RCF-DC) 3 - RCTR-C / RCF-DC 6 - RCTA-C 7 - RCA-C 8 - RCTRC-VI B - (representando 11) - RCTR-C Conjugado");

	protected AtributoAvervacao tipoDocumentoAverba��o = new AtributoAvervacao(2, "Tipo de documento da averba��o", "C", 2, 1,
			"1 - NOTA FISCAL 2 - CONHECIMENTO 3 - MANIFESTO 4 - ROMANEIO 5 � ORDEM DE COMPRA");

	protected AtributoAvervacao numeroDocumento = new AtributoAvervacao(3, "N�mero do documento", "C", 3, 15, "");

	protected AtributoAvervacao serieDocumento = new AtributoAvervacao(4, "S�rie do documento", "C", 18, 2, "");

	protected AtributoAvervacao subSerieDocumento = new AtributoAvervacao(5, "Sub-s�rie do documento", "C", 20, 2, "");

	protected AtributoAvervacao estadoOrigem = new AtributoAvervacao(6, "Estado de origem", "C", 22, 2,
			"Sigla do estado origem. Ex.: SP, RJ Na averba��o internacional, representa o estado de origem na Exporta��o, ou o estado de fronteira na Importa��o.");

	protected AtributoAvervacao estadoDestino = new AtributoAvervacao(7, "Estado de destino", "C", 24, 2,
			"Sigla do estado destino. Ex.: AM, BA Em percurso Urbano/Suburbano, utilizar: UR Na averba��o internacional, representa o estado de fronteira na Exporta��o, ou o estado de destino na Importa��o.");

	protected AtributoAvervacao codigoMercadoria = new AtributoAvervacao(8, "C�digo da mercadoria", "N", 26, 4,
			"A lista de c�digos dever� ser informada pela seguradora, caso este campo seja utilizado");

	protected AtributoAvervacao mercadoriaNova = new AtributoAvervacao(9, "Mercadoria nova", "C", 30, 1, "S/N � indica se a mercadoria transportada � nova");

	protected AtributoAvervacao dataSa�da = new AtributoAvervacao(10, "Data de sa�da", "C", 31, 8, "Data de sa�da do embarque, no formato: AAAAMMDD");

	protected AtributoAvervacao iSTTN = new AtributoAvervacao(11, "IS TTN", "N", 39, 10, "Valor declarado para o ramo TTN, em Reais (R$). (1) (2)");

	protected AtributoAvervacao iSRCTR_C = new AtributoAvervacao(12, "IS RCTR-C", "N", 49, 10,
			"Valor declarado para os ramos RCTR-C, RCA-C, RCTA-C e RCTR-C Conjugado, em Reais (R$), e RCTRC-VI, em d�lares (US$). (1) (2)");

	protected AtributoAvervacao iSRCF_DC = new AtributoAvervacao(13, "IS RCF-DC", "N", 59, 10, "Valor declarado para o ramo RCF-DC, em Reais (R$). (1) (2)");

	protected AtributoAvervacao containerRCTR_C = new AtributoAvervacao(14, "Container (RCTR-C)", "N", 69, 10,
			"Valor declarado do container para o ramo RCTR-C e RCTR-C Conjugado, em Reais (R$), e RCTRC-VI, em d�lares (R$). (1) (3)");

	protected AtributoAvervacao containerRCF_DC = new AtributoAvervacao(15, "Container (RCF-DC)", "N", 79, 10, "Valor declarado do container para o ramo RCF-DC. Valores em Reais (R$). (1) (3)");

	protected AtributoAvervacao placa = new AtributoAvervacao(16, "Placa", "C", 89, 7, "Placa do ve�culo, no formato: AAA9999 (3 caracteres e 4 d�gitos)");

	protected AtributoAvervacao CPFMotorista = new AtributoAvervacao(17, "CPF do Motorista", "N", 96, 11, "N�o ser� validado, mas � num�rico e obrigat�rio.");

	protected AtributoAvervacao rebocador = new AtributoAvervacao(18, "Rebocador", "C", 107, 15, "Identifica��o do rebocador (para ramo RCA-C)");

	protected AtributoAvervacao balsa = new AtributoAvervacao(19, "Balsa", "C", 122, 15, "Identifica��o da balsa (para ramo RCA-C)");

	protected AtributoAvervacao ve�culoProprio = new AtributoAvervacao(20, "Ve�culo pr�prio", "C", 137, 1, "S/N � indica se o ve�culo � pr�prio do transportador");

	protected AtributoAvervacao rodofluvial = new AtributoAvervacao(21, "Rodofluvial", "C", 138, 1, "S/N � indica transporte rodofluvial");

	protected AtributoAvervacao importa��oExporta��o = new AtributoAvervacao(22, "Importa��o / Exporta��o", "C", 139, 1, "I/E � para o ramo RCTRC-VI, indica importa��o ou exporta��o");

	protected AtributoAvervacao pa�s = new AtributoAvervacao(23, "Pa�s", "N", 140, 3,
			"C�digo DDI do pa�s na averba��o internacional, importa��o ou exporta��o. Exemplo: Argentina: 54 Bol�via: 591 Chile: 56 Paraguai: 595 Uruguai: 598");

	protected AtributoAvervacao coberturaOCD = new AtributoAvervacao(24, "Cobertura OCD", "N", 143, 3, "C�digo da cobertura OCD: 1 - Normal 2 - Com I�amento");

	public AverbacaoEntity() {
		super();
	}

	@Override
	public String toString() {
		String linha = "";
		linha = tipoAverbacao.preencherLinha(linha);
		linha = tipoAverbacao.preencherLinha(linha);
		linha = tipoDocumentoAverba��o.preencherLinha(linha);
		linha = numeroDocumento.preencherLinha(linha);
		linha = serieDocumento.preencherLinha(linha);
		linha = subSerieDocumento.preencherLinha(linha);
		linha = estadoOrigem.preencherLinha(linha);
		linha = estadoDestino.preencherLinha(linha);
		linha = codigoMercadoria.preencherLinha(linha);
		linha = mercadoriaNova.preencherLinha(linha);
		linha = dataSa�da.preencherLinha(linha);
		linha = iSTTN.preencherLinha(linha);
		linha = iSRCTR_C.preencherLinha(linha);
		linha = iSRCF_DC.preencherLinha(linha);
		linha = containerRCTR_C.preencherLinha(linha);
		linha = containerRCF_DC.preencherLinha(linha);
		linha = placa.preencherLinha(linha);
		linha = CPFMotorista.preencherLinha(linha);
		linha = rebocador.preencherLinha(linha);
		linha = balsa.preencherLinha(linha);
		linha = ve�culoProprio.preencherLinha(linha);
		linha = rodofluvial.preencherLinha(linha);
		linha = importa��oExporta��o.preencherLinha(linha);
		linha = pa�s.preencherLinha(linha);
		linha = coberturaOCD.preencherLinha(linha);

		return linha;
	}

	public void setValores(String tipoAverbacao, String tipoDocumentoAverba��o, String numeroDocumento, String serieDocumento, String subSerieDocumento, String estadoOrigem, String estadoDestino,
			String codigoMercadoria, String mercadoriaNova, String dataSa�da, String iSTTN, String iSRCTR_C, String iSRCF_DC, String containerRCTR_C, String containerRCF_DC, String placa,
			String cPFMotorista, String rebocador, String balsa, String ve�culoProprio, String rodofluvial, String importa��oExporta��o, String pa�s, String coberturaOCD) throws Exception {

		this.tipoAverbacao.setValor(tipoAverbacao);
		this.tipoDocumentoAverba��o.setValor(tipoDocumentoAverba��o);
		this.numeroDocumento.setValor(numeroDocumento);
		this.serieDocumento.setValor(serieDocumento);
		this.subSerieDocumento.setValor(subSerieDocumento);
		this.estadoOrigem.setValor(estadoOrigem);
		this.estadoDestino.setValor(estadoDestino);
		this.codigoMercadoria.setValor(codigoMercadoria);
		this.mercadoriaNova.setValor(mercadoriaNova);
		this.dataSa�da.setValor(dataSa�da);
		this.iSTTN.setValor(iSTTN);
		this.iSRCTR_C.setValor(iSRCTR_C);
		this.iSRCF_DC.setValor(iSRCF_DC);
		this.containerRCTR_C.setValor(containerRCTR_C);
		this.containerRCF_DC.setValor(containerRCF_DC);
		this.placa.setValor(placa);
		this.CPFMotorista.setValor(cPFMotorista);
		this.rebocador.setValor(rebocador);
		this.balsa.setValor(balsa);
		this.ve�culoProprio.setValor(ve�culoProprio);
		this.rodofluvial.setValor(rodofluvial);
		this.importa��oExporta��o.setValor(importa��oExporta��o);
		this.pa�s.setValor(pa�s);
		this.coberturaOCD.setValor(coberturaOCD);
	}

	// Gett's and Sett's
	public AtributoAvervacao getTipoAverbacao() {
		return tipoAverbacao;
	}

	public AtributoAvervacao getTipoDocumentoAverba��o() {
		return tipoDocumentoAverba��o;
	}

	public AtributoAvervacao getNumeroDocumento() {
		return numeroDocumento;
	}

	public AtributoAvervacao getSerieDocumento() {
		return serieDocumento;
	}

	public AtributoAvervacao getSubSerieDocumento() {
		return subSerieDocumento;
	}

	public AtributoAvervacao getEstadoOrigem() {
		return estadoOrigem;
	}

	public AtributoAvervacao getEstadoDestino() {
		return estadoDestino;
	}

	public AtributoAvervacao getCodigoMercadoria() {
		return codigoMercadoria;
	}

	public AtributoAvervacao getMercadoriaNova() {
		return mercadoriaNova;
	}

	public AtributoAvervacao getDataSa�da() {
		return dataSa�da;
	}

	public AtributoAvervacao getiSTTN() {
		return iSTTN;
	}

	public AtributoAvervacao getiSRCTR_C() {
		return iSRCTR_C;
	}

	public AtributoAvervacao getiSRCF_DC() {
		return iSRCF_DC;
	}

	public AtributoAvervacao getContainerRCTR_C() {
		return containerRCTR_C;
	}

	public AtributoAvervacao getContainerRCF_DC() {
		return containerRCF_DC;
	}

	public AtributoAvervacao getPlaca() {
		return placa;
	}

	public AtributoAvervacao getCPFMotorista() {
		return CPFMotorista;
	}

	public AtributoAvervacao getRebocador() {
		return rebocador;
	}

	public AtributoAvervacao getBalsa() {
		return balsa;
	}

	public AtributoAvervacao getVe�culoProprio() {
		return ve�culoProprio;
	}

	public AtributoAvervacao getRodofluvial() {
		return rodofluvial;
	}

	public AtributoAvervacao getImporta��oExporta��o() {
		return importa��oExporta��o;
	}

	public AtributoAvervacao getPa�s() {
		return pa�s;
	}

	public AtributoAvervacao getCoberturaOCD() {
		return coberturaOCD;
	}

	public void setTipoAverbacao(AtributoAvervacao tipoAverbacao) {
		this.tipoAverbacao = tipoAverbacao;
	}

	public void setTipoDocumentoAverba��o(AtributoAvervacao tipoDocumentoAverba��o) {
		this.tipoDocumentoAverba��o = tipoDocumentoAverba��o;
	}

	public void setNumeroDocumento(AtributoAvervacao numeroDocumento) {
		this.numeroDocumento = numeroDocumento;
	}

	public void setSerieDocumento(AtributoAvervacao serieDocumento) {
		this.serieDocumento = serieDocumento;
	}

	public void setSubSerieDocumento(AtributoAvervacao subSerieDocumento) {
		this.subSerieDocumento = subSerieDocumento;
	}

	public void setEstadoOrigem(AtributoAvervacao estadoOrigem) {
		this.estadoOrigem = estadoOrigem;
	}

	public void setEstadoDestino(AtributoAvervacao estadoDestino) {
		this.estadoDestino = estadoDestino;
	}

	public void setCodigoMercadoria(AtributoAvervacao codigoMercadoria) {
		this.codigoMercadoria = codigoMercadoria;
	}

	public void setMercadoriaNova(AtributoAvervacao mercadoriaNova) {
		this.mercadoriaNova = mercadoriaNova;
	}

	public void setDataSa�da(AtributoAvervacao dataSa�da) {
		this.dataSa�da = dataSa�da;
	}

	public void setiSTTN(AtributoAvervacao iSTTN) {
		this.iSTTN = iSTTN;
	}

	public void setiSRCTR_C(AtributoAvervacao iSRCTR_C) {
		this.iSRCTR_C = iSRCTR_C;
	}

	public void setiSRCF_DC(AtributoAvervacao iSRCF_DC) {
		this.iSRCF_DC = iSRCF_DC;
	}

	public void setContainerRCTR_C(AtributoAvervacao containerRCTR_C) {
		this.containerRCTR_C = containerRCTR_C;
	}

	public void setContainerRCF_DC(AtributoAvervacao containerRCF_DC) {
		this.containerRCF_DC = containerRCF_DC;
	}

	public void setPlaca(AtributoAvervacao placa) {
		this.placa = placa;
	}

	public void setCPFMotorista(AtributoAvervacao cPFMotorista) {
		CPFMotorista = cPFMotorista;
	}

	public void setRebocador(AtributoAvervacao rebocador) {
		this.rebocador = rebocador;
	}

	public void setBalsa(AtributoAvervacao balsa) {
		this.balsa = balsa;
	}

	public void setVe�culoProprio(AtributoAvervacao ve�culoProprio) {
		this.ve�culoProprio = ve�culoProprio;
	}

	public void setRodofluvial(AtributoAvervacao rodofluvial) {
		this.rodofluvial = rodofluvial;
	}

	public void setImporta��oExporta��o(AtributoAvervacao importa��oExporta��o) {
		this.importa��oExporta��o = importa��oExporta��o;
	}

	public void setPa�s(AtributoAvervacao pa�s) {
		this.pa�s = pa�s;
	}

	public void setCoberturaOCD(AtributoAvervacao coberturaOCD) {
		this.coberturaOCD = coberturaOCD;
	}

	@Override
	public int hashCode() {
		final int prime = 31;
		int result = 1;
		result = prime * result + ((CPFMotorista == null) ? 0 : CPFMotorista.hashCode());
		result = prime * result + ((balsa == null) ? 0 : balsa.hashCode());
		result = prime * result + ((coberturaOCD == null) ? 0 : coberturaOCD.hashCode());
		result = prime * result + ((codigoMercadoria == null) ? 0 : codigoMercadoria.hashCode());
		result = prime * result + ((containerRCF_DC == null) ? 0 : containerRCF_DC.hashCode());
		result = prime * result + ((containerRCTR_C == null) ? 0 : containerRCTR_C.hashCode());
		result = prime * result + ((dataSa�da == null) ? 0 : dataSa�da.hashCode());
		result = prime * result + ((estadoDestino == null) ? 0 : estadoDestino.hashCode());
		result = prime * result + ((estadoOrigem == null) ? 0 : estadoOrigem.hashCode());
		result = prime * result + ((iSRCF_DC == null) ? 0 : iSRCF_DC.hashCode());
		result = prime * result + ((iSRCTR_C == null) ? 0 : iSRCTR_C.hashCode());
		result = prime * result + ((iSTTN == null) ? 0 : iSTTN.hashCode());
		result = prime * result + ((importa��oExporta��o == null) ? 0 : importa��oExporta��o.hashCode());
		result = prime * result + ((mercadoriaNova == null) ? 0 : mercadoriaNova.hashCode());
		result = prime * result + ((numeroDocumento == null) ? 0 : numeroDocumento.hashCode());
		result = prime * result + ((pa�s == null) ? 0 : pa�s.hashCode());
		result = prime * result + ((placa == null) ? 0 : placa.hashCode());
		result = prime * result + ((rebocador == null) ? 0 : rebocador.hashCode());
		result = prime * result + ((rodofluvial == null) ? 0 : rodofluvial.hashCode());
		result = prime * result + ((serieDocumento == null) ? 0 : serieDocumento.hashCode());
		result = prime * result + ((subSerieDocumento == null) ? 0 : subSerieDocumento.hashCode());
		result = prime * result + ((tipoAverbacao == null) ? 0 : tipoAverbacao.hashCode());
		result = prime * result + ((tipoDocumentoAverba��o == null) ? 0 : tipoDocumentoAverba��o.hashCode());
		result = prime * result + ((ve�culoProprio == null) ? 0 : ve�culoProprio.hashCode());
		return result;
	}

	@Override
	public boolean equals(Object obj) {
		if (this == obj)
			return true;
		if (obj == null)
			return false;
		if (getClass() != obj.getClass())
			return false;
		AverbacaoEntity other = (AverbacaoEntity) obj;
		if (CPFMotorista == null) {
			if (other.CPFMotorista != null)
				return false;
		} else if (!CPFMotorista.equals(other.CPFMotorista))
			return false;
		if (balsa == null) {
			if (other.balsa != null)
				return false;
		} else if (!balsa.equals(other.balsa))
			return false;
		if (coberturaOCD == null) {
			if (other.coberturaOCD != null)
				return false;
		} else if (!coberturaOCD.equals(other.coberturaOCD))
			return false;
		if (codigoMercadoria == null) {
			if (other.codigoMercadoria != null)
				return false;
		} else if (!codigoMercadoria.equals(other.codigoMercadoria))
			return false;
		if (containerRCF_DC == null) {
			if (other.containerRCF_DC != null)
				return false;
		} else if (!containerRCF_DC.equals(other.containerRCF_DC))
			return false;
		if (containerRCTR_C == null) {
			if (other.containerRCTR_C != null)
				return false;
		} else if (!containerRCTR_C.equals(other.containerRCTR_C))
			return false;
		if (dataSa�da == null) {
			if (other.dataSa�da != null)
				return false;
		} else if (!dataSa�da.equals(other.dataSa�da))
			return false;
		if (estadoDestino == null) {
			if (other.estadoDestino != null)
				return false;
		} else if (!estadoDestino.equals(other.estadoDestino))
			return false;
		if (estadoOrigem == null) {
			if (other.estadoOrigem != null)
				return false;
		} else if (!estadoOrigem.equals(other.estadoOrigem))
			return false;
		if (iSRCF_DC == null) {
			if (other.iSRCF_DC != null)
				return false;
		} else if (!iSRCF_DC.equals(other.iSRCF_DC))
			return false;
		if (iSRCTR_C == null) {
			if (other.iSRCTR_C != null)
				return false;
		} else if (!iSRCTR_C.equals(other.iSRCTR_C))
			return false;
		if (iSTTN == null) {
			if (other.iSTTN != null)
				return false;
		} else if (!iSTTN.equals(other.iSTTN))
			return false;
		if (importa��oExporta��o == null) {
			if (other.importa��oExporta��o != null)
				return false;
		} else if (!importa��oExporta��o.equals(other.importa��oExporta��o))
			return false;
		if (mercadoriaNova == null) {
			if (other.mercadoriaNova != null)
				return false;
		} else if (!mercadoriaNova.equals(other.mercadoriaNova))
			return false;
		if (numeroDocumento == null) {
			if (other.numeroDocumento != null)
				return false;
		} else if (!numeroDocumento.equals(other.numeroDocumento))
			return false;
		if (pa�s == null) {
			if (other.pa�s != null)
				return false;
		} else if (!pa�s.equals(other.pa�s))
			return false;
		if (placa == null) {
			if (other.placa != null)
				return false;
		} else if (!placa.equals(other.placa))
			return false;
		if (rebocador == null) {
			if (other.rebocador != null)
				return false;
		} else if (!rebocador.equals(other.rebocador))
			return false;
		if (rodofluvial == null) {
			if (other.rodofluvial != null)
				return false;
		} else if (!rodofluvial.equals(other.rodofluvial))
			return false;
		if (serieDocumento == null) {
			if (other.serieDocumento != null)
				return false;
		} else if (!serieDocumento.equals(other.serieDocumento))
			return false;
		if (subSerieDocumento == null) {
			if (other.subSerieDocumento != null)
				return false;
		} else if (!subSerieDocumento.equals(other.subSerieDocumento))
			return false;
		if (tipoAverbacao == null) {
			if (other.tipoAverbacao != null)
				return false;
		} else if (!tipoAverbacao.equals(other.tipoAverbacao))
			return false;
		if (tipoDocumentoAverba��o == null) {
			if (other.tipoDocumentoAverba��o != null)
				return false;
		} else if (!tipoDocumentoAverba��o.equals(other.tipoDocumentoAverba��o))
			return false;
		if (ve�culoProprio == null) {
			if (other.ve�culoProprio != null)
				return false;
		} else if (!ve�culoProprio.equals(other.ve�culoProprio))
			return false;
		return true;
	}

}
