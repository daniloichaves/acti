package br.com.jgle.acti.entity;

import java.math.BigDecimal;
import java.util.Collection;
import java.util.Date;
import java.util.HashSet;
import java.util.Map;
import java.util.Set;

import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.ManyToOne;
import javax.persistence.OneToMany;
import javax.persistence.Temporal;
import javax.persistence.TemporalType;
import javax.persistence.Transient;

import org.hibernate.annotations.Fetch;
import org.hibernate.annotations.FetchMode;

@SuppressWarnings("serial")
@Entity
public class Coleta extends AbstractEntity {

	
	protected Integer numeroOS = 0;
	
	@Column(length = 15)
	protected String tipoFrete;
	@Column(length = 50)
	protected String operacao;
	@Column(length = 70)
	protected String solicitante;
	@Column(length = 15)
	protected String telefone;
	@Column(length = 10)
	protected String ramal;
	@Column(length = 30)
	protected String email;
	@Temporal(TemporalType.TIMESTAMP)
	protected Date dataHoraColeta;
	@Temporal(TemporalType.TIMESTAMP)
	protected Date dataHoraColetaLimite;

	// Valores para calcular o Frete
	protected BigDecimal valorFrete = BigDecimal.ZERO;
	protected BigDecimal pedagio = BigDecimal.ZERO;
	protected BigDecimal adValorem = BigDecimal.ZERO;
	protected BigDecimal seguro = BigDecimal.ZERO;
	protected BigDecimal taxaAerea = BigDecimal.ZERO;
	protected BigDecimal taxaColeta = BigDecimal.ZERO;
	protected BigDecimal taxaEntrega = BigDecimal.ZERO;
	protected BigDecimal redespacho = BigDecimal.ZERO;

	protected Integer distancia = 0;
	protected BigDecimal valorKm = BigDecimal.ZERO;
	protected BigDecimal valorTotalKm = BigDecimal.ZERO;

	protected BigDecimal desconto = BigDecimal.ZERO;

	protected BigDecimal valorTotalBruto = BigDecimal.ZERO;

	@Column(length = 100)
	protected String formula;
	protected BigDecimal valorFormula = BigDecimal.ZERO;

	@Column(length = 30)
	protected String pagamentoFrete;
	@Column(length = 50)
	protected String responsavelPagamentoFrete;

	// Coleta
	@ManyToOne(cascade = CascadeType.ALL)
	protected Motorista motoristaColeta;
	@ManyToOne(cascade = CascadeType.ALL)
	protected Veiculo veiculoColeta;
	protected Integer kmInicialColeta;
	protected Integer kmFinalColeta;
	@Temporal(TemporalType.TIMESTAMP)
	protected Date dataHoraInicialColeta;
	@Temporal(TemporalType.TIMESTAMP)
	protected Date dataHoraFinalColeta;
	@Column(length = 50)
	protected String entreguePor;
	@Column(length = 100)
	protected String observacaoColeta;

	// Entrega
	@ManyToOne(cascade = CascadeType.ALL)
	protected Motorista motoristaEntrega;
	@ManyToOne(cascade = CascadeType.ALL)
	protected Veiculo veiculoEntrega;
	protected Integer kmInicialEntrega;
	protected Integer kmFinalEntrega;
	@Temporal(TemporalType.TIMESTAMP)
	protected Date dataHoraInicialEntrega;
	@Temporal(TemporalType.TIMESTAMP)
	protected Date dataHoraFinalEntrega;
	@Column(length = 50)
	protected String recebidoPor;
	@Column(length = 50)
	protected String observacaoEntrega;
	@Column(length = 50)
	protected String consignatario;

	// Opcionais
	@Column(length = 50)
	protected String ctrc;
	@Column(length = 50)
	protected String notaFiscal;
	@Column(length = 50)
	protected String diNumero;
	@Column(length = 50)
	protected String containerNumero;
	@Column(length = 50)
	protected String containerTipo;
	@Column(length = 50)
	protected String modalidade;
	@Column(length = 50)
	protected String numeroRisco;
	@Column(length = 50)
	protected String numeroOnu;
	@Column(length = 50)
	protected String navio;
	@Column(length = 50)
	protected String amador;
	@Column(length = 50)
	protected String booking;
	@Column(length = 50)
	protected String material;
	@Column(length = 50)
	protected String qtdeLacres;
	@Column(length = 50)
	protected String numeroLacres;
	@Column(length = 50)
	protected String porcentagemICMS;
	@Column(length = 50)
	protected String porcentagemISS;
	@Column(length = 50)
	protected String especializacao;
	@Column(length = 50)
	protected String tipoTransporte;

	// Opcionais
	protected Boolean paraFuturar;
	protected Boolean faturado;
	protected Boolean paraNfServico;
	protected Boolean pago;
	@Column(length = 50)
	protected String fatura;
	@Temporal(TemporalType.DATE)
	protected Date dataFatura;
	@Temporal(TemporalType.DATE)
	protected Date dataVencimento;
	@Column(length = 25)
	protected String conhecimento;
	@Temporal(TemporalType.DATE)
	protected Date dataPagamento;
	@Column(length = 50)
	protected String tabela;
	@Column(length = 50)
	protected String numeroFatura;

	@Transient
	public BigDecimal calcularValorTotalBruto() {
		BigDecimal soma = valorFrete.add(pedagio).add(adValorem).add(seguro)
				.add(taxaAerea);
		BigDecimal resultado = soma.add(taxaColeta).add(taxaEntrega)
				.add(redespacho).add(valorTotalKm).add(desconto);

		return resultado;
	}

	@Transient
	public BigDecimal calcularValorTotalKm() {
		return valorKm.multiply(new BigDecimal(distancia));
	}

	@OneToMany(cascade = CascadeType.ALL, fetch = FetchType.EAGER)
	@Fetch(FetchMode.SELECT)
	protected Set<NotaFiscal> notaFiscals = new HashSet<NotaFiscal>();

	@OneToMany(cascade = CascadeType.ALL, fetch = FetchType.EAGER)
	@Fetch(FetchMode.SELECT)
	protected Set<Servico> servicos = new HashSet<Servico>();

	@ManyToOne
	protected Cpof cpof;

	@ManyToOne(cascade = CascadeType.ALL, fetch = FetchType.EAGER)
	protected Cliente clienteRemetente;

	@ManyToOne(cascade = CascadeType.ALL, fetch = FetchType.EAGER)
	protected ColetaEndereco remetente = new ColetaEndereco();

	@ManyToOne(cascade = CascadeType.ALL, fetch = FetchType.EAGER)
	protected ColetaEndereco destinatario = new ColetaEndereco();

	@SuppressWarnings("unchecked")
	public Coleta newInstance() {
		return new Coleta();
	}

	@SuppressWarnings("rawtypes")
	@Override
	public Collection getList(AbstractEntity name) {
		if (name instanceof NotaFiscal) {
			return getNotaFiscals();
		}
		if (name instanceof Servico) {
			return getServicos();
		}
		throw new NullPointerException();
	}

	@Override
	public Map<String, ?> getParametrosSimpleSearch(String textSearch) {
		@SuppressWarnings("unchecked")
		Map<String, Object> params = (Map<String, Object>) super
				.getParametrosSimpleSearch(textSearch);

		params.put("solicitante", textToSearch(textSearch));
		params.put("dataHoraColeta", textToSearch(textSearch));

		params.put("motoristaColeta.nome", textToSearch(textSearch));
		params.put("motoristaColeta.apelido", textToSearch(textSearch));
		params.put("veiculoColeta.placa", textToSearch(textSearch));
		params.put("dataHoraInicialColeta", textToSearch(textSearch));
		params.put("observacaoColeta", textToSearch(textSearch));

		params.put("motoristaEntrega.nome", textToSearch(textSearch));
		params.put("motoristaEntrega.apelido", textToSearch(textSearch));
		params.put("veiculoEntrega.placa", textToSearch(textSearch));
		params.put("dataHoraInicialEntrega", textToSearch(textSearch));
		params.put("observacaoEntrega", textToSearch(textSearch));
		params.put("recebidoPor", textToSearch(textSearch));

		params.put("ctrc", textToSearch(textSearch));

		return params;
	}

	public Map<String, String> getParametrosAdvancedSearch() {
		Map<String, String> params = (Map<String, String>) super
				.getParametrosAdvancedSearch();

		params.put("solicitante", "Solicitante");
		params.put("dataHoraColeta", "Coleta Data Hora");

		params.put("motoristaColeta.nome", "Coleta Nome Motor.");
		params.put("motoristaColeta.apelido", "Coleta Apelido Motor.");
		params.put("veiculoColeta.placa", "Coleta Veiculo Placa");
		params.put("dataHoraInicialColeta", "Coleta Data Hora Inicio");
		params.put("observacaoColeta", "Coleta Observacao");

		params.put("motoristaEntrega.nome", "Entrega Nome Motor.");
		params.put("motoristaEntrega.apelido", "Entrega Apelido Motor.");
		params.put("veiculoEntrega.placa", "Entrega Veiculo Placa");
		params.put("dataHoraInicialEntrega", "Entrega Data Hora Entrega");
		params.put("observacaoEntrega", "Entrega Observacao");
		params.put("recebidoPor", "Entrega Recebido Por");

		params.put("ctrc", "CTRC");

		return params;
	}

	public String getTipoFrete() {
		return tipoFrete;
	}

	public void setTipoFrete(String tipoFrete) {
		this.tipoFrete = tipoFrete;
	}

	public String getOperacao() {
		return operacao;
	}

	public void setOperacao(String operacao) {
		this.operacao = operacao;
	}

	public String getSolicitante() {
		return solicitante;
	}

	public void setSolicitante(String solicitante) {
		this.solicitante = solicitante;
	}

	public String getTelefone() {
		return telefone;
	}

	public void setTelefone(String telefone) {
		this.telefone = telefone;
	}

	public String getRamal() {
		return ramal;
	}

	public void setRamal(String ramal) {
		this.ramal = ramal;
	}

	public String getEmail() {
		return email;
	}

	public void setEmail(String email) {
		this.email = email;
	}

	public Date getDataHoraColeta() {
		return dataHoraColeta;
	}

	public void setDataHoraColeta(Date dataHoraColeta) {
		this.dataHoraColeta = dataHoraColeta;
	}

	public Cpof getCpof() {
		return cpof;
	}

	public void setCpof(Cpof cpof) {
		this.cpof = cpof;
	}

	public Cliente getClienteRemetente() {
		return clienteRemetente;
	}

	public void setClienteRemetente(Cliente clienteRemetente) {
		this.clienteRemetente = clienteRemetente;
	}

	public ColetaEndereco getRemetente() {
		return remetente;
	}

	public void setRemetente(ColetaEndereco remetente) {
		this.remetente = remetente;
	}

	public ColetaEndereco getDestinatario() {
		return destinatario;
	}

	public void setDestinatario(ColetaEndereco destinatario) {
		this.destinatario = destinatario;
	}

	public Set<NotaFiscal> getNotaFiscals() {
		return notaFiscals;
	}

	public void setNotaFiscals(Set<NotaFiscal> notaFiscals) {
		this.notaFiscals = notaFiscals;
	}

	public Set<Servico> getServicos() {
		return servicos;
	}

	public void setServicos(Set<Servico> servicos) {
		this.servicos = servicos;
	}

	public Date getDataHoraColetaLimite() {
		return dataHoraColetaLimite;
	}

	public void setDataHoraColetaLimite(Date dataHoraColetaLimite) {
		this.dataHoraColetaLimite = dataHoraColetaLimite;
	}

	public BigDecimal getValorFrete() {
		return valorFrete;
	}

	public void setValorFrete(BigDecimal valorFrete) {
		this.valorFrete = valorFrete;
	}

	public BigDecimal getPedagio() {
		return pedagio;
	}

	public void setPedagio(BigDecimal pedagio) {
		this.pedagio = pedagio;
	}

	public BigDecimal getAdValorem() {
		return adValorem;
	}

	public void setAdValorem(BigDecimal adValorem) {
		this.adValorem = adValorem;
	}

	public BigDecimal getSeguro() {
		return seguro;
	}

	public void setSeguro(BigDecimal seguro) {
		this.seguro = seguro;
	}

	public BigDecimal getTaxaAerea() {
		return taxaAerea;
	}

	public void setTaxaAerea(BigDecimal taxaAerea) {
		this.taxaAerea = taxaAerea;
	}

	public BigDecimal getTaxaColeta() {
		return taxaColeta;
	}

	public void setTaxaColeta(BigDecimal taxaColeta) {
		this.taxaColeta = taxaColeta;
	}

	public BigDecimal getTaxaEntrega() {
		return taxaEntrega;
	}

	public void setTaxaEntrega(BigDecimal taxaEntrega) {
		this.taxaEntrega = taxaEntrega;
	}

	public BigDecimal getRedespacho() {
		return redespacho;
	}

	public void setRedespacho(BigDecimal redespacho) {
		this.redespacho = redespacho;
	}

	public BigDecimal getDesconto() {
		return desconto;
	}

	public void setDesconto(BigDecimal desconto) {
		this.desconto = desconto;
	}

	public Integer getDistancia() {
		return distancia;
	}

	public void setDistancia(Integer distancia) {
		this.distancia = distancia;
	}

	public BigDecimal getValorKm() {
		return valorKm;
	}

	public void setValorKm(BigDecimal valorKm) {
		this.valorKm = valorKm;
	}

	public BigDecimal getValorTotalKm() {
		return valorTotalKm;
	}

	public void setValorTotalKm(BigDecimal valorTotalKm) {
		this.valorTotalKm = valorTotalKm;
	}

	public BigDecimal getValorTotalBruto() {
		return valorTotalBruto;
	}

	public void setValorTotalBruto(BigDecimal valorTotalBruto) {
		this.valorTotalBruto = valorTotalBruto;
	}

	public Motorista getMotoristaColeta() {
		return motoristaColeta;
	}

	public void setMotoristaColeta(Motorista motoristaColeta) {
		this.motoristaColeta = motoristaColeta;
	}

	public Veiculo getVeiculoColeta() {
		return veiculoColeta;
	}

	public void setVeiculoColeta(Veiculo veiculoColeta) {
		this.veiculoColeta = veiculoColeta;
	}

	public Integer getKmInicialColeta() {
		return kmInicialColeta;
	}

	public void setKmInicialColeta(Integer kmInicialColeta) {
		this.kmInicialColeta = kmInicialColeta;
	}

	public Integer getKmFinalColeta() {
		return kmFinalColeta;
	}

	public void setKmFinalColeta(Integer kmFinalColeta) {
		this.kmFinalColeta = kmFinalColeta;
	}

	public Date getDataHoraInicialColeta() {
		return dataHoraInicialColeta;
	}

	public void setDataHoraInicialColeta(Date dataHoraInicialColeta) {
		this.dataHoraInicialColeta = dataHoraInicialColeta;
	}

	public Date getDataHoraFinalColeta() {
		return dataHoraFinalColeta;
	}

	public void setDataHoraFinalColeta(Date dataHoraFinalColeta) {
		this.dataHoraFinalColeta = dataHoraFinalColeta;
	}

	public String getEntreguePor() {
		return entreguePor;
	}

	public void setEntreguePor(String entreguePor) {
		this.entreguePor = entreguePor;
	}

	public String getObservacaoColeta() {
		return observacaoColeta;
	}

	public void setObservacaoColeta(String observacaoColeta) {
		this.observacaoColeta = observacaoColeta;
	}

	public Motorista getMotoristaEntrega() {
		return motoristaEntrega;
	}

	public void setMotoristaEntrega(Motorista motoristaEntrega) {
		this.motoristaEntrega = motoristaEntrega;
	}

	public Veiculo getVeiculoEntrega() {
		return veiculoEntrega;
	}

	public void setVeiculoEntrega(Veiculo veiculoEntrega) {
		this.veiculoEntrega = veiculoEntrega;
	}

	public Integer getKmInicialEntrega() {
		return kmInicialEntrega;
	}

	public void setKmInicialEntrega(Integer kmInicialEntrega) {
		this.kmInicialEntrega = kmInicialEntrega;
	}

	public Integer getKmFinalEntrega() {
		return kmFinalEntrega;
	}

	public void setKmFinalEntrega(Integer kmFinalEntrega) {
		this.kmFinalEntrega = kmFinalEntrega;
	}

	public Date getDataHoraInicialEntrega() {
		return dataHoraInicialEntrega;
	}

	public void setDataHoraInicialEntrega(Date dataHoraInicialEntrega) {
		this.dataHoraInicialEntrega = dataHoraInicialEntrega;
	}

	public Date getDataHoraFinalEntrega() {
		return dataHoraFinalEntrega;
	}

	public void setDataHoraFinalEntrega(Date dataHoraFinalEntrega) {
		this.dataHoraFinalEntrega = dataHoraFinalEntrega;
	}

	public String getRecebidoPor() {
		return recebidoPor;
	}

	public void setRecebidoPor(String recebidoPor) {
		this.recebidoPor = recebidoPor;
	}

	public String getObservacaoEntrega() {
		return observacaoEntrega;
	}

	public void setObservacaoEntrega(String observacaoEntrega) {
		this.observacaoEntrega = observacaoEntrega;
	}

	public String getConsignatario() {
		return consignatario;
	}

	public void setConsignatario(String consignatario) {
		this.consignatario = consignatario;
	}

	public String getCtrc() {
		return ctrc;
	}

	public void setCtrc(String ctrc) {
		this.ctrc = ctrc;
	}

	public String getNotaFiscal() {
		return notaFiscal;
	}

	public void setNotaFiscal(String notaFiscal) {
		this.notaFiscal = notaFiscal;
	}

	public String getDiNumero() {
		return diNumero;
	}

	public void setDiNumero(String diNumero) {
		this.diNumero = diNumero;
	}

	public String getContainerNumero() {
		return containerNumero;
	}

	public void setContainerNumero(String containerNumero) {
		this.containerNumero = containerNumero;
	}

	public String getContainerTipo() {
		return containerTipo;
	}

	public void setContainerTipo(String containerTipo) {
		this.containerTipo = containerTipo;
	}

	public String getModalidade() {
		return modalidade;
	}

	public void setModalidade(String modalidade) {
		this.modalidade = modalidade;
	}

	public String getNumeroRisco() {
		return numeroRisco;
	}

	public void setNumeroRisco(String numeroRisco) {
		this.numeroRisco = numeroRisco;
	}

	public String getNumeroOnu() {
		return numeroOnu;
	}

	public void setNumeroOnu(String numeroOnu) {
		this.numeroOnu = numeroOnu;
	}

	public String getNavio() {
		return navio;
	}

	public void setNavio(String navio) {
		this.navio = navio;
	}

	public String getAmador() {
		return amador;
	}

	public void setAmador(String amador) {
		this.amador = amador;
	}

	public String getBooking() {
		return booking;
	}

	public void setBooking(String booking) {
		this.booking = booking;
	}

	public String getMaterial() {
		return material;
	}

	public void setMaterial(String material) {
		this.material = material;
	}

	public String getQtdeLacres() {
		return qtdeLacres;
	}

	public void setQtdeLacres(String qtdeLacres) {
		this.qtdeLacres = qtdeLacres;
	}

	public String getNumeroLacres() {
		return numeroLacres;
	}

	public void setNumeroLacres(String numeroLacres) {
		this.numeroLacres = numeroLacres;
	}

	public String getPorcentagemICMS() {
		return porcentagemICMS;
	}

	public void setPorcentagemICMS(String porcentagemICMS) {
		this.porcentagemICMS = porcentagemICMS;
	}

	public String getPorcentagemISS() {
		return porcentagemISS;
	}

	public void setPorcentagemISS(String porcentagemISS) {
		this.porcentagemISS = porcentagemISS;
	}

	public String getEspecializacao() {
		return especializacao;
	}

	public void setEspecializacao(String especializacao) {
		this.especializacao = especializacao;
	}

	public String getTipoTransporte() {
		return tipoTransporte;
	}

	public void setTipoTransporte(String tipoTransporte) {
		this.tipoTransporte = tipoTransporte;
	}

	public Boolean getParaFuturar() {
		return paraFuturar;
	}

	public void setParaFuturar(Boolean paraFuturar) {
		this.paraFuturar = paraFuturar;
	}

	public Boolean getFaturado() {
		return faturado;
	}

	public void setFaturado(Boolean faturado) {
		this.faturado = faturado;
	}

	public Boolean getParaNfServico() {
		return paraNfServico;
	}

	public void setParaNfServico(Boolean paraNfServico) {
		this.paraNfServico = paraNfServico;
	}

	public Boolean getPago() {
		return pago;
	}

	public void setPago(Boolean pago) {
		this.pago = pago;
	}

	public String getFatura() {
		return fatura;
	}

	public void setFatura(String fatura) {
		this.fatura = fatura;
	}

	public Date getDataFatura() {
		return dataFatura;
	}

	public void setDataFatura(Date dataFatura) {
		this.dataFatura = dataFatura;
	}

	public Date getDataVencimento() {
		return dataVencimento;
	}

	public void setDataVencimento(Date dataVencimento) {
		this.dataVencimento = dataVencimento;
	}

	public String getConhecimento() {
		return conhecimento;
	}

	public void setConhecimento(String conhecimento) {
		this.conhecimento = conhecimento;
	}

	public Date getDataPagamento() {
		return dataPagamento;
	}

	public void setDataPagamento(Date dataPagamento) {
		this.dataPagamento = dataPagamento;
	}

	public String getTabela() {
		return tabela;
	}

	public void setTabela(String tabela) {
		this.tabela = tabela;
	}

	public String getNumeroFatura() {
		return numeroFatura;
	}

	public void setNumeroFatura(String numeroFatura) {
		this.numeroFatura = numeroFatura;
	}

	public String getFormula() {
		return formula;
	}

	public void setFormula(String formula) {
		this.formula = formula;
	}

	public BigDecimal getValorFormula() {
		return valorFormula;
	}

	public void setValorFormula(BigDecimal valorFormula) {
		this.valorFormula = valorFormula;
	}

	public String getPagamentoFrete() {
		return pagamentoFrete;
	}

	public void setPagamentoFrete(String pagamentoFrete) {
		this.pagamentoFrete = pagamentoFrete;
	}

	public String getResponsavelPagamentoFrete() {
		return responsavelPagamentoFrete;
	}

	public void setResponsavelPagamentoFrete(String responsavelPagamentoFrete) {
		this.responsavelPagamentoFrete = responsavelPagamentoFrete;
	}

	public Integer getNumeroOS() {
		return numeroOS;
	}

	public void setNumeroOS(Integer numeroOS) {
		this.numeroOS = numeroOS;
	}

	// protected ClienteFornecedor destinatario;
	// protected String destinatarioNomeRazaoSocial;
	// protected String destinatarioCpfCnpj;
	// protected String destinatarioEndereco;
	// protected String destinatarioCep;
	// protected String destinatarioContato;
	// protected String destinatarioTelefone;
	// protected String destinatarioRamal;
	// protected String destinatarioEmail;

	// protected String remetenteNomeRazaoSocial;
	// protected String remetenteCpfCnpj;
	// protected String remetenteEndereco;
	// protected String remetenteCep;
	// protected String remetenteContato;
	// protected String remetenteTelefone;
	// protected String remetenteRamal;
}
