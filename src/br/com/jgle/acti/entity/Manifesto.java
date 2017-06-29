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

import org.hibernate.annotations.Fetch;
import org.hibernate.annotations.FetchMode;

import br.com.jgle.acti.entity.estoque.Almoxarifado;

@SuppressWarnings("serial")
@Entity
public class Manifesto extends AbstractEntity {

	@SuppressWarnings("unchecked")
	@Override
	public Manifesto newInstance() {
		return new Manifesto();
	}

	protected Integer numeroManifesto;

	@ManyToOne(fetch = FetchType.EAGER)
	protected Login digitador;

	@ManyToOne(fetch = FetchType.EAGER)
	protected Login conferente;

	// Entrega
	@ManyToOne
	protected Motorista motoristaEntrega = new Motorista();

	@ManyToOne(fetch = FetchType.EAGER)
	protected Veiculo veiculoEntrega = new Veiculo();
	protected Integer kmInicialEntrega;
	protected Integer kmFinalEntrega;
	@Temporal(TemporalType.TIMESTAMP)
	protected Date dataHoraInicialEntrega;
	@Temporal(TemporalType.TIMESTAMP)
	protected Date dataHoraFinalEntrega;

	@OneToOne(cascade = CascadeType.ALL, fetch = FetchType.EAGER, orphanRemoval = true)
	protected Seguradora seguradora = new Seguradora();

	@OneToMany(fetch = FetchType.EAGER, mappedBy = "manifesto")
	@Fetch(FetchMode.SELECT)
	protected Set<Conhecimento> conhecimentos = new HashSet<Conhecimento>();

	@Fetch(FetchMode.SELECT)
	@ManyToOne(fetch = FetchType.EAGER)
	protected Almoxarifado almoxarifado;

	// Calculo Frete
	// Totalização dos conhecimentos para conferência
	protected BigDecimal totalValorNF;
	protected Integer totalQuantidade;
	protected BigDecimal totalPeso;
	protected BigDecimal valorSeguro;
	protected BigDecimal totalFreteCif;
	protected BigDecimal totalFreteFob;
	protected BigDecimal totalFrete;
	protected Integer quantidadeCTRC;
	protected BigDecimal procentagemSeguro;
	protected BigDecimal totalDesconto;

	// Despesas
	protected BigDecimal sestSenat;
	protected BigDecimal inss;
	protected BigDecimal ir;
	protected BigDecimal pedagio;
	protected BigDecimal faltaMercadoria;
	protected BigDecimal seguro;
	protected BigDecimal outros;

	// Despesas
	protected ContaBanco contaBanco;
	protected Integer numCheque;
	@Temporal(TemporalType.TIMESTAMP)
	protected Date dataPagamento;
	protected BigDecimal valorAdiantamento;
	protected BigDecimal cidAdiantamento;
	protected BigDecimal valorMotorista;
	@Column(length = 200)
	protected String observacao;
	protected Funcionario ajudanteGeral;
	protected Integer quantidadeDias;

	// Despesas
	@Column(length = 100)
	protected String descargaPorConta;
	protected Integer pesoTratado;
	protected BigDecimal valorTonelada;
	@Temporal(TemporalType.TIMESTAMP)
	protected Date dataMaxDescarregamento;
	@Temporal(TemporalType.TIMESTAMP)
	protected Date dataValidade;
	protected BigDecimal multaAtrasoDescarregamento;
	protected Integer totalLacres;
	protected BigDecimal pernoite;
	protected BigDecimal refeicao;

	@SuppressWarnings("rawtypes")
	@Override
	public Collection getList(AbstractEntity name) {
		if (name instanceof Conhecimento) {
			return getConhecimentos();
		}
		throw new NullPointerException();
	}

	@Override
	public Map<String, ?> getParametrosSimpleSearch(String textSearch) {
		@SuppressWarnings("unchecked")
		Map<String, Object> params = (Map<String, Object>) super
				.getParametrosSimpleSearch(textSearch);

		params.put("digitador.nome", textToSearch(textSearch));
		params.put("conferente.nome", textToSearch(textSearch));
		params.put("motoristaEntrega.nome", textToSearch(textSearch));
		params.put("motoristaEntrega.apelido", textToSearch(textSearch));
		params.put("veiculoEntrega.placa", textToSearch(textSearch));
		params.put("seguradora.agenciaSeguradora", textToSearch(textSearch));

		return params;
	}

	public Map<String, String> getParametrosAdvancedSearch() {
		Map<String, String> params = (Map<String, String>) super
				.getParametrosAdvancedSearch();

		params.put("digitador.nome", "Nome Digitador");
		params.put("conferente.nome", "Nome Conferente");
		params.put("motoristaEntrega.nome", "Nome Motorista Entregue");
		params.put("motoristaEntrega.apelido", "Apelido Motorista Entregue");
		params.put("veiculoEntrega.placa", "Placa Veiculo Entregue");
		params.put("seguradora.agenciaSeguradora", "Agencia Seguradora");

		return params;

	}

	public Set<Conhecimento> getConhecimentos() {
		return conhecimentos;
	}

	public void setConhecimentos(Set<Conhecimento> conhecimentos) {
		this.conhecimentos = conhecimentos;
	}

	public Integer getNumeroManifesto() {
		return numeroManifesto;
	}

	public void setNumeroManifesto(Integer numeroManifesto) {
		this.numeroManifesto = numeroManifesto;
	}

	public Login getDigitador() {
		return digitador;
	}

	public void setDigitador(Login digitador) {
		this.digitador = digitador;
	}

	public Login getConferente() {
		return conferente;
	}

	public void setConferente(Login conferente) {
		this.conferente = conferente;
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

	public Seguradora getSeguradora() {
		return seguradora;
	}

	public void setSeguradora(Seguradora seguradora) {
		this.seguradora = seguradora;
	}

	public Almoxarifado getAlmoxarifado() {
		return almoxarifado;
	}

	public void setAlmoxarifado(Almoxarifado almoxarifado) {
		this.almoxarifado = almoxarifado;
	}

	public BigDecimal getTotalValorNF() {
		return totalValorNF;
	}

	public void setTotalValorNF(BigDecimal totalValorNF) {
		this.totalValorNF = totalValorNF;
	}

	public Integer getTotalQuantidade() {
		return totalQuantidade;
	}

	public void setTotalQuantidade(Integer totalQuantidade) {
		this.totalQuantidade = totalQuantidade;
	}

	public BigDecimal getTotalPeso() {
		return totalPeso;
	}

	public void setTotalPeso(BigDecimal totalPeso) {
		this.totalPeso = totalPeso;
	}

	public BigDecimal getValorSeguro() {
		return valorSeguro;
	}

	public void setValorSeguro(BigDecimal valorSeguro) {
		this.valorSeguro = valorSeguro;
	}

	public BigDecimal getTotalFreteCif() {
		return totalFreteCif;
	}

	public void setTotalFreteCif(BigDecimal totalFreteCif) {
		this.totalFreteCif = totalFreteCif;
	}

	public BigDecimal getTotalFreteFob() {
		return totalFreteFob;
	}

	public void setTotalFreteFob(BigDecimal totalFreteFob) {
		this.totalFreteFob = totalFreteFob;
	}

	public BigDecimal getTotalFrete() {
		return totalFrete;
	}

	public void setTotalFrete(BigDecimal totalFrete) {
		this.totalFrete = totalFrete;
	}

	public Integer getQuantidadeCTRC() {
		return quantidadeCTRC;
	}

	public void setQuantidadeCTRC(Integer quantidadeCTRC) {
		this.quantidadeCTRC = quantidadeCTRC;
	}

	public BigDecimal getProcentagemSeguro() {
		return procentagemSeguro;
	}

	public void setProcentagemSeguro(BigDecimal procentagemSeguro) {
		this.procentagemSeguro = procentagemSeguro;
	}

	public BigDecimal getTotalDesconto() {
		return totalDesconto;
	}

	public void setTotalDesconto(BigDecimal totalDesconto) {
		this.totalDesconto = totalDesconto;
	}

	public BigDecimal getSestSenat() {
		return sestSenat;
	}

	public void setSestSenat(BigDecimal sestSenat) {
		this.sestSenat = sestSenat;
	}

	public BigDecimal getInss() {
		return inss;
	}

	public void setInss(BigDecimal inss) {
		this.inss = inss;
	}

	public BigDecimal getIr() {
		return ir;
	}

	public void setIr(BigDecimal ir) {
		this.ir = ir;
	}

	public BigDecimal getPedagio() {
		return pedagio;
	}

	public void setPedagio(BigDecimal pedagio) {
		this.pedagio = pedagio;
	}

	public BigDecimal getFaltaMercadoria() {
		return faltaMercadoria;
	}

	public void setFaltaMercadoria(BigDecimal faltaMercadoria) {
		this.faltaMercadoria = faltaMercadoria;
	}

	public BigDecimal getSeguro() {
		return seguro;
	}

	public void setSeguro(BigDecimal seguro) {
		this.seguro = seguro;
	}

	public BigDecimal getOutros() {
		return outros;
	}

	public void setOutros(BigDecimal outros) {
		this.outros = outros;
	}

	public ContaBanco getContaBanco() {
		return contaBanco;
	}

	public void setContaBanco(ContaBanco contaBanco) {
		this.contaBanco = contaBanco;
	}

	public Integer getNumCheque() {
		return numCheque;
	}

	public void setNumCheque(Integer numCheque) {
		this.numCheque = numCheque;
	}

	public Date getDataPagamento() {
		return dataPagamento;
	}

	public void setDataPagamento(Date dataPagamento) {
		this.dataPagamento = dataPagamento;
	}

	public BigDecimal getValorAdiantamento() {
		return valorAdiantamento;
	}

	public void setValorAdiantamento(BigDecimal valorAdiantamento) {
		this.valorAdiantamento = valorAdiantamento;
	}

	public BigDecimal getCidAdiantamento() {
		return cidAdiantamento;
	}

	public void setCidAdiantamento(BigDecimal cidAdiantamento) {
		this.cidAdiantamento = cidAdiantamento;
	}

	public BigDecimal getValorMotorista() {
		return valorMotorista;
	}

	public void setValorMotorista(BigDecimal valorMotorista) {
		this.valorMotorista = valorMotorista;
	}

	public String getObservacao() {
		return observacao;
	}

	public void setObservacao(String observacao) {
		this.observacao = observacao;
	}

	public Funcionario getAjudanteGeral() {
		return ajudanteGeral;
	}

	public void setAjudanteGeral(Funcionario ajudanteGeral) {
		this.ajudanteGeral = ajudanteGeral;
	}

	public Integer getQuantidadeDias() {
		return quantidadeDias;
	}

	public void setQuantidadeDias(Integer quantidadeDias) {
		this.quantidadeDias = quantidadeDias;
	}

	public String getDescargaPorConta() {
		return descargaPorConta;
	}

	public void setDescargaPorConta(String descargaPorConta) {
		this.descargaPorConta = descargaPorConta;
	}

	public Integer getPesoTratado() {
		return pesoTratado;
	}

	public void setPesoTratado(Integer pesoTratado) {
		this.pesoTratado = pesoTratado;
	}

	public BigDecimal getValorTonelada() {
		return valorTonelada;
	}

	public void setValorTonelada(BigDecimal valorTonelada) {
		this.valorTonelada = valorTonelada;
	}

	public Date getDataMaxDescarregamento() {
		return dataMaxDescarregamento;
	}

	public void setDataMaxDescarregamento(Date dataMaxDescarregamento) {
		this.dataMaxDescarregamento = dataMaxDescarregamento;
	}

	public Date getDataValidade() {
		return dataValidade;
	}

	public void setDataValidade(Date dataValidade) {
		this.dataValidade = dataValidade;
	}

	public BigDecimal getMultaAtrasoDescarregamento() {
		return multaAtrasoDescarregamento;
	}

	public void setMultaAtrasoDescarregamento(
			BigDecimal multaAtrasoDescarregamento) {
		this.multaAtrasoDescarregamento = multaAtrasoDescarregamento;
	}

	public Integer getTotalLacres() {
		return totalLacres;
	}

	public void setTotalLacres(Integer totalLacres) {
		this.totalLacres = totalLacres;
	}

	public BigDecimal getPernoite() {
		return pernoite;
	}

	public void setPernoite(BigDecimal pernoite) {
		this.pernoite = pernoite;
	}

	public BigDecimal getRefeicao() {
		return refeicao;
	}

	public void setRefeicao(BigDecimal refeicao) {
		this.refeicao = refeicao;
	}

}
