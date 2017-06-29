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
import javax.persistence.OneToOne;
import javax.persistence.Temporal;
import javax.persistence.TemporalType;
import javax.persistence.Transient;

import org.hibernate.annotations.Fetch;
import org.hibernate.annotations.FetchMode;

@SuppressWarnings("serial")
@Entity
public class Conhecimento extends AbstractEntity {

	public final static String TIPO_FRETE_FOB = "FOB";
	public final static String TIPO_FRETE_CIF = "CIF";
	
	public final static String TIPO_CALCULO_1 = "CALC_FRETE_1";
	public final static String TIPO_CALCULO_2 = "CALC_FRETE_2";
	public final static String TIPO_CALCULO_CARTA_FRETE = "CALC_CARTA_FRETE";

	// Parte 1 - CRTC
	@Column(length = 20)
	protected String ctrc;
	@Column(length = 50)
	protected String serie;
	@Column(length = 50)
	protected String subSerie;
	@Column(length = 20)
	protected String tipoFrete;
	@Column(length = 30)
	protected String tipoGris;
	@ManyToOne
	protected Cpof cpof;
	@Column(length = 20)
	protected String localEmissao;
	@ManyToOne
	protected Login digitador;

	@OneToOne(cascade = CascadeType.ALL, fetch = FetchType.EAGER, orphanRemoval = true)
	protected Seguradora seguradora;

	@ManyToOne(cascade = CascadeType.ALL, fetch = FetchType.EAGER)
	protected Manifesto manifesto;

	// Parte 2 - Remetente
	@ManyToOne(cascade = CascadeType.ALL)
	protected Cliente clienteRemetente;
	@ManyToOne(cascade = CascadeType.ALL)
	protected ColetaEndereco remetente = new ColetaEndereco();
	@ManyToOne(cascade = CascadeType.ALL)
	protected ColetaEndereco destinatario = new ColetaEndereco();

	// Parte 3 - Consg/ Redesp/ Parceiros
	@ManyToOne(cascade = CascadeType.ALL)
	protected Fornecedor consignatario;
	@ManyToOne(cascade = CascadeType.ALL)
	protected ColetaEndereco consignatarioEndereco = new ColetaEndereco();
	@Column(length = 20)
	protected String consignatarioPagamentoFrete;
	@Column(length = 20)
	protected String consignatarioSerie;
	protected Boolean consignatarioFreteComb;
	// @Column(length = 20)
	protected BigDecimal consignatarioIcms = BigDecimal.ZERO;
	@Column(length = 20)
	protected String consignatarioCtrc;

	@ManyToOne(cascade = CascadeType.ALL)
	protected Fornecedor redespacho;
	@ManyToOne(cascade = CascadeType.ALL)
	protected ColetaEndereco redespachoEndereco = new ColetaEndereco();
	@Column(length = 20)
	protected String redespachoPagamentoFrete;
	@Column(length = 20)
	protected String redespachoSerie;
	@Column(length = 20)
	protected Boolean redespachoFreteComb;
	// @Column(length = 20)
	protected BigDecimal redespachoIcms = BigDecimal.ZERO;

	@OneToOne(cascade = CascadeType.ALL, fetch = FetchType.EAGER, orphanRemoval = true)
	protected ConhecimentoMaritimo conhecimentoMaritimo = new ConhecimentoMaritimo();

	// Parte 4 - Mercadoria
	@OneToMany(cascade = CascadeType.ALL, fetch = FetchType.EAGER, orphanRemoval = true)
	@Fetch(FetchMode.SELECT)
	protected Set<NotaFiscal> notaFiscals = new HashSet<NotaFiscal>();

	@OneToMany(cascade = CascadeType.ALL, fetch = FetchType.EAGER, orphanRemoval = true)
	@Fetch(FetchMode.SELECT)
	protected Set<Servico> servicos = new HashSet<Servico>();

	// Parte 5 - Calculo Frete
	@Column(length = 20)
	protected String tipoCalculoFrete = TIPO_CALCULO_1;

	@OneToOne(cascade = CascadeType.ALL, fetch = FetchType.EAGER, orphanRemoval = true)
	protected ConhecimentoCalculoFreteUm conhecimentoCalculoFreteUm = new ConhecimentoCalculoFreteUm();

	@OneToOne(cascade = CascadeType.ALL, fetch = FetchType.EAGER, orphanRemoval = true)
	protected ConhecimentoCalculoFreteDois conhecimentoCalculoFreteDois = new ConhecimentoCalculoFreteDois();

	@OneToOne(cascade = CascadeType.ALL, fetch = FetchType.EAGER, orphanRemoval = true)
	protected ConhecimentoCalculoFreteCarta conhecimentoCalculoFreteCarta = new ConhecimentoCalculoFreteCarta();

	@Column(length = 200)
	protected String observacao;

	// Taxa
	protected BigDecimal taxaMinima = BigDecimal.ZERO;
	protected BigDecimal taxaSeguro = BigDecimal.ZERO;
	protected BigDecimal valorSeguro = BigDecimal.ZERO;
	protected BigDecimal totalFrete = BigDecimal.ZERO;
	protected BigDecimal baseICMS = BigDecimal.ZERO;
	protected BigDecimal ICMS = BigDecimal.ZERO;
	protected BigDecimal valorICMS = BigDecimal.ZERO;

	protected BigDecimal totalFreteBruto = BigDecimal.ZERO;

	protected BigDecimal totalFreteLiquido = BigDecimal.ZERO;

	// Parte 6 - Motorista
	// Coleta
	@ManyToOne(cascade = CascadeType.ALL)
	protected Motorista motoristaColeta = new Motorista();
	@ManyToOne(cascade = CascadeType.ALL)
	protected Veiculo veiculoColeta = new Veiculo();
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
	protected String consignatarioEntrega;

	// Integrações
	// BrasilRisk
	@Column(length = 20)
	private String brasilRiskStatus = "Não Cadastrado";
	@Temporal(TemporalType.TIMESTAMP)
	protected Date brasilRiskDataSync = new Date();

	// Parte 7 - CT-e
	@OneToOne(cascade = CascadeType.ALL, fetch = FetchType.EAGER, orphanRemoval = true)
	protected ConhecimentoCTe conhecimentoCTe = new ConhecimentoCTe();

	// Parte 8 - Coleta

	// Parte 9 - Carga

	protected String operacao;
	protected String solicitante;
	protected String telefone;
	protected String ramal;
	protected String email;
	protected Date dataHoraColeta;
	protected Date dataHoraColetaLimite;

	@SuppressWarnings("unchecked")
	public Conhecimento newInstance() {
		return new Conhecimento();
	}
	
	public void calcularValores() {
		// TODO fazer calculos
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
		Map<String, Object> params = (Map<String, Object>) super.getParametrosSimpleSearch(textSearch);

		params.put("ctrc", textToSearch(textSearch));
		params.put("serie", textToSearch(textSearch));
		params.put("subSerie", textToSearch(textSearch));
		params.put("cpof.codigo", textToSearch(textSearch));
		params.put("digitador.nome", textToSearch(textSearch));
		params.put("seguradora.agenciaSeguradora", textToSearch(textSearch));
		params.put("clienteRemetente.razaosocialnome", textToSearch(textSearch));
		params.put("clienteRemetente.nomefantasiasobrenome", textToSearch(textSearch));
		params.put("clienteRemetente.ierg", textToSearch(textSearch));
		
		params.put("remetente.nomeRazaoSocial", textToSearch(textSearch));
		params.put("remetente.cpfCnpj", textToSearch(textSearch));
		
		params.put("destinatario.nomeRazaoSocial", textToSearch(textSearch));
		params.put("destinatario.cpfCnpj", textToSearch(textSearch));
		
		
		params.put("consignatario.razaosocialnome", textToSearch(textSearch));
		params.put("consignatario.nomefantasiasobrenome", textToSearch(textSearch));
		
		params.put("redespacho.razaosocialnome", textToSearch(textSearch));
		params.put("redespacho.nomefantasiasobrenome", textToSearch(textSearch));
		
		params.put("observacao", textToSearch(textSearch));

		return params;
	}
	
	public Map<String, String> getParametrosAdvancedSearch() {
		Map<String, String> params = (Map<String, String>) super.getParametrosAdvancedSearch();
		
		params.put("ctrc", "Nº CTRC");
		params.put("serie", "Serie");
		params.put("subSerie", "SubSerie");
		params.put("cpof.codigo", "Codifo CPOF");
		params.put("digitador.nome", "Nome Digitador");
		params.put("seguradora.agenciaSeguradora", "Agencia Seguradora");
		params.put("clienteRemetente.razaosocialnome", "Razão/Nome Cliente Remetente");
		params.put("clienteRemetente.nomefantasiasobrenome", "Fantasia/Sobr. Cliente Remetente");
		params.put("clienteRemetente.ierg", "IE/RG Cliente Remetente");
		
		params.put("remetente.nomeRazaoSocial", "Razao/Nome End. Remetente");
		params.put("remetente.cpfCnpj", "CPF/CNPJ End. Remetente");
		
		params.put("destinatario.nomeRazaoSocial", "Razao/Nome End. Destinatario");
		params.put("destinatario.cpfCnpj", "CPF/CNPJ End. Destinatario");
		
		
		params.put("consignatario.razaosocialnome", "Razao/Nome Consignatario");
		params.put("consignatario.nomefantasiasobrenome", "Fantasia/Sobr. Consignatario");
		
		params.put("redespacho.razaosocialnome", "Razao/Nome Redespacho");
		params.put("redespacho.nomefantasiasobrenome", "Fantasia/Sobr. Redespacho");
		
		params.put("observacao", "");

		return params;

	}

	@Transient
	public String getTipoGrisBrasilRisk() {

		if ("LIBERADO".equals(getTipoGris())) {
			return "L";
		} else if ("RASTREADO".equals(getTipoGris())) {
			return "R";
		} else if ("TELEMONITORADO".equals(getTipoGris())) {
			return "T";
		} else if ("RASTREADO COM ESCOLTA".equals(getTipoGris())) {
			return "E";
		}

		return null;
	}

	public String getTipoFrete() {
		return tipoFrete;
	}

	public void setTipoFrete(String tipoFrete) {
		this.tipoFrete = tipoFrete;
	}

	public String getTipoGris() {
		return tipoGris;
	}

	public void setTipoGris(String tipoGris) {
		this.tipoGris = tipoGris;
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

	public String getCtrc() {
		return ctrc;
	}

	public void setCtrc(String ctrc) {
		this.ctrc = ctrc;
	}

	public String getSerie() {
		return serie;
	}

	public void setSerie(String serie) {
		this.serie = serie;
	}

	public String getLocalEmissao() {
		return localEmissao;
	}

	public void setLocalEmissao(String localEmissao) {
		this.localEmissao = localEmissao;
	}

	public Login getDigitador() {
		return digitador;
	}

	public void setDigitador(Login digitador) {
		this.digitador = digitador;
	}

	public Fornecedor getConsignatario() {
		return consignatario;
	}

	public void setConsignatario(Fornecedor consignatario) {
		this.consignatario = consignatario;
	}

	public ColetaEndereco getConsignatarioEndereco() {
		return consignatarioEndereco;
	}

	public void setConsignatarioEndereco(ColetaEndereco consignatarioEndereco) {
		this.consignatarioEndereco = consignatarioEndereco;
	}

	public String getConsignatarioPagamentoFrete() {
		return consignatarioPagamentoFrete;
	}

	public void setConsignatarioPagamentoFrete(String consignatarioPagamentoFrete) {
		this.consignatarioPagamentoFrete = consignatarioPagamentoFrete;
	}

	public String getConsignatarioSerie() {
		return consignatarioSerie;
	}

	public void setConsignatarioSerie(String consignatarioSerie) {
		this.consignatarioSerie = consignatarioSerie;
	}

	public Boolean getConsignatarioFreteComb() {
		return consignatarioFreteComb;
	}

	public void setConsignatarioFreteComb(Boolean consignatarioFreteComb) {
		this.consignatarioFreteComb = consignatarioFreteComb;
	}

	public BigDecimal getConsignatarioIcms() {
		return consignatarioIcms;
	}

	public void setConsignatarioIcms(BigDecimal consignatarioIcms) {
		this.consignatarioIcms = consignatarioIcms;
	}

	public String getConsignatarioCtrc() {
		return consignatarioCtrc;
	}

	public void setConsignatarioCtrc(String consignatarioCtrc) {
		this.consignatarioCtrc = consignatarioCtrc;
	}

	public Fornecedor getRedespacho() {
		return redespacho;
	}

	public void setRedespacho(Fornecedor redespacho) {
		this.redespacho = redespacho;
	}

	public ColetaEndereco getRedespachoEndereco() {
		return redespachoEndereco;
	}

	public void setRedespachoEndereco(ColetaEndereco redespachoEndereco) {
		this.redespachoEndereco = redespachoEndereco;
	}

	public String getRedespachoPagamentoFrete() {
		return redespachoPagamentoFrete;
	}

	public void setRedespachoPagamentoFrete(String redespachoPagamentoFrete) {
		this.redespachoPagamentoFrete = redespachoPagamentoFrete;
	}

	public String getRedespachoSerie() {
		return redespachoSerie;
	}

	public void setRedespachoSerie(String redespachoSerie) {
		this.redespachoSerie = redespachoSerie;
	}

	public Boolean getRedespachoFreteComb() {
		return redespachoFreteComb;
	}

	public void setRedespachoFreteComb(Boolean redespachoFreteComb) {
		this.redespachoFreteComb = redespachoFreteComb;
	}

	public BigDecimal getRedespachoIcms() {
		return redespachoIcms;
	}

	public void setRedespachoIcms(BigDecimal redespachoIcms) {
		this.redespachoIcms = redespachoIcms;
	}

	public ConhecimentoMaritimo getConhecimentoMaritimo() {
		return conhecimentoMaritimo;
	}

	public void setConhecimentoMaritimo(ConhecimentoMaritimo conhecimentoMaritimo) {
		this.conhecimentoMaritimo = conhecimentoMaritimo;
	}

	public String getTipoCalculoFrete() {
		return tipoCalculoFrete;
	}

	public void setTipoCalculoFrete(String tipoCalculoFrete) {
		this.tipoCalculoFrete = tipoCalculoFrete;
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

	public String getConsignatarioEntrega() {
		return consignatarioEntrega;
	}

	public void setConsignatarioEntrega(String consignatarioEntrega) {
		this.consignatarioEntrega = consignatarioEntrega;
	}

	public ConhecimentoCTe getConhecimentoCTe() {
		return conhecimentoCTe;
	}

	public void setConhecimentoCTe(ConhecimentoCTe conhecimentoCTe) {
		this.conhecimentoCTe = conhecimentoCTe;
	}

	public ConhecimentoCalculoFreteUm getConhecimentoCalculoFreteUm() {
		return conhecimentoCalculoFreteUm;
	}

	public void setConhecimentoCalculoFreteUm(ConhecimentoCalculoFreteUm conhecimentoCalculoFreteUm) {
		this.conhecimentoCalculoFreteUm = conhecimentoCalculoFreteUm;
	}

	public String getObservacao() {
		return observacao;
	}

	public void setObservacao(String observacao) {
		this.observacao = observacao;
	}

	public BigDecimal getTotalFreteBruto() {
		return totalFreteBruto;
	}

	public void setTotalFreteBruto(BigDecimal totalFreteBruto) {
		this.totalFreteBruto = totalFreteBruto;
	}

	public BigDecimal getTotalFreteLiquido() {
		return totalFreteLiquido;
	}

	public void setTotalFreteLiquido(BigDecimal totalFreteLiquido) {
		this.totalFreteLiquido = totalFreteLiquido;
	}

	public BigDecimal getTaxaMinima() {
		return taxaMinima;
	}

	public void setTaxaMinima(BigDecimal taxaMinima) {
		this.taxaMinima = taxaMinima;
	}

	public BigDecimal getTaxaSeguro() {
		return taxaSeguro;
	}

	public void setTaxaSeguro(BigDecimal taxaSeguro) {
		this.taxaSeguro = taxaSeguro;
	}

	public BigDecimal getValorSeguro() {
		return valorSeguro;
	}

	public void setValorSeguro(BigDecimal valorSeguro) {
		this.valorSeguro = valorSeguro;
	}

	public BigDecimal getBaseICMS() {
		return baseICMS;
	}

	public void setBaseICMS(BigDecimal baseICMS) {
		this.baseICMS = baseICMS;
	}

	public BigDecimal getICMS() {
		return ICMS;
	}

	public void setICMS(BigDecimal iCMS) {
		ICMS = iCMS;
	}

	public BigDecimal getValorICMS() {
		return valorICMS;
	}

	public void setValorICMS(BigDecimal valorICMS) {
		this.valorICMS = valorICMS;
	}

	public ConhecimentoCalculoFreteDois getConhecimentoCalculoFreteDois() {
		return conhecimentoCalculoFreteDois;
	}

	public void setConhecimentoCalculoFreteDois(ConhecimentoCalculoFreteDois conhecimentoCalculoFreteDois) {
		this.conhecimentoCalculoFreteDois = conhecimentoCalculoFreteDois;
	}

	public ConhecimentoCalculoFreteCarta getConhecimentoCalculoFreteCarta() {
		return conhecimentoCalculoFreteCarta;
	}

	public void setConhecimentoCalculoFreteCarta(ConhecimentoCalculoFreteCarta conhecimentoCalculoFreteCarta) {
		this.conhecimentoCalculoFreteCarta = conhecimentoCalculoFreteCarta;
	}

	public BigDecimal getTotalFrete() {
		return totalFrete;
	}

	public void setTotalFrete(BigDecimal totalFrete) {
		this.totalFrete = totalFrete;
	}

	public Seguradora getSeguradora() {
		return seguradora;
	}

	public void setSeguradora(Seguradora seguradora) {
		this.seguradora = seguradora;
	}

	public String getBrasilRiskStatus() {
		return brasilRiskStatus;
	}

	public void setBrasilRiskStatus(String brasilRiskStatus) {
		this.brasilRiskStatus = brasilRiskStatus;
	}

	public Date getBrasilRiskDataSync() {
		return brasilRiskDataSync;
	}

	public void setBrasilRiskDataSync(Date brasilRiskDataSync) {
		this.brasilRiskDataSync = brasilRiskDataSync;
	}

	public String getSubSerie() {
		return subSerie;
	}

	public void setSubSerie(String subSerie) {
		this.subSerie = subSerie;
	}

	public Manifesto getManifesto() {
		return manifesto;
	}

	public void setManifesto(Manifesto manifesto) {
		this.manifesto = manifesto;
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
