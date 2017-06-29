package br.com.jgle.acti.entity;

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

import org.hibernate.annotations.Fetch;
import org.hibernate.annotations.FetchMode;

import br.com.jgle.acti.entity.pgr.Adicional;
import br.com.jgle.acti.entity.pgr.Atuador;
import br.com.jgle.acti.entity.pgr.Sensor;

@SuppressWarnings("serial")
@Entity
public class Veiculo extends AbstractEntity {

	@Column(length = 1)
	protected String tipoAquisicao;
	@Column(length = 30)
	protected String classificacao;
	@Column(length = 8)
	protected String placa;
	@Column(length = 100)
	protected String descricao;
	protected Integer ano;
	@Column(length = 20)
	protected String renavan;
	@Column(length = 30)
	protected String chassi;
	@Column(length = 20)
	protected String cidade;
	@Column(length = 3)
	protected String uf;
	@Column(length = 25)
	protected String marca;
	@Column(length = 25)
	protected String modelo;
	@Column(length = 25)
	protected String tipo;
	// @ManyToOne
	// protected Motorista motorista;
	@ManyToOne
	protected Proprietario proprietario;
	@Temporal(TemporalType.DATE)
	protected Date dataAquisicao;
	protected Double valorAquisicao;
	protected Double valorVenda;
	@Column(length = 100)
	protected String informacoes;
	protected Boolean inativo;
	@Column(length = 35)
	protected String numeroCertificado;
	@Column(length = 20)
	protected String medidas;
	@Column(length = 20)
	protected String cor;
	@Column(length = 20)
	protected String combustivel;
	@Column(length = 20)
	protected String mediaConsLt;

	protected Integer kmAtual;

	@Column(length = 25)
	protected String capacidade;

	// Carreta
	@Column(length = 20)
	protected String carretaTipo;
	@Column(length = 10)
	protected String carretaPlaca;
	@Column(length = 20)
	protected String carretaRenavan;
	@Column(length = 30)
	protected String carretaChassi;
	protected Integer carretaAnoFabricacao;
	@Column(length = 25)
	protected String carretaMarca;
	@Column(length = 25)
	protected String carretaModelo;

	@Column(length = 30)
	protected String seguradora;
	@Column(length = 30)
	protected String corretora;
	@Column(length = 30)
	protected String apolice;
	@Column(length = 30)
	protected String tipoSeguradora;
	@Temporal(TemporalType.DATE)
	protected Date dataVencimentoSeguro;

	protected Double colisao;
	protected Double roubo;
	protected Double explosao;
	protected Double danosMateriais;
	protected Double danosCorporais;
	protected Double terceiros;
	protected Double incendio;
	protected Double raio;
	protected Double outros;
	protected Double valorPago;

	@Column(length = 15)
	protected String lotacaoMinima;
	@Column(length = 15)
	protected String lotacaoMaxima;
	protected Double valorPorViagem;
	protected Double valorViagemExecido;
	protected Double valorKmRodado;
	protected Double valorKmExecido;
	protected Double valorHora;
	protected Double valorHoraExecido;
	protected Double valorDia;
	protected Double valorDiaExecido;
	protected Double porcPagarMotor;
	protected Double valorPorEntrega;
	protected Double valorDevolucao;
	protected Double valorNF;

	// Rastreadores
	@OneToMany(cascade = CascadeType.ALL, fetch = FetchType.EAGER, orphanRemoval = true)
	protected Set<VeiculoRastreador> veiculoRastreadores = new HashSet<VeiculoRastreador>();
	
//	@OneToMany(cascade = CascadeType.ALL, fetch = FetchType.EAGER, orphanRemoval = true)
//	protected Set<VeiculoSensor> veiculoSensores = new HashSet<VeiculoSensor>();
//	
//	@OneToMany(cascade = CascadeType.ALL, fetch = FetchType.EAGER, orphanRemoval = true)
//	protected Set<VeiculoAdicional> veiculoAdicionais = new HashSet<VeiculoAdicional>();
	
	@OneToMany(cascade = CascadeType.ALL, fetch = FetchType.EAGER)
	@Fetch(FetchMode.SELECT)
	protected Set<Sensor> sensors = new HashSet<Sensor>();

	@OneToMany(cascade = CascadeType.ALL, fetch = FetchType.EAGER)
	@Fetch(FetchMode.SELECT)
	protected Set<Atuador> atuadors = new HashSet<Atuador>();

	@OneToMany(cascade = CascadeType.ALL, fetch = FetchType.EAGER)
	@Fetch(FetchMode.SELECT)
	protected Set<Adicional> adicionals = new HashSet<Adicional>();

	// Serviços Manutenção
	@OneToMany(cascade = CascadeType.ALL, fetch = FetchType.EAGER)
	protected Set<VeiculoServicoManutencao> veiculoServicoManutencoes = new HashSet<VeiculoServicoManutencao>();

	// Integrações
	// BrasilRisk
	@Column(length = 20)
	private String brasilRiskStatus = "Não Cadastrado";
	@Temporal(TemporalType.TIMESTAMP)
	protected Date brasilRiskDataSync = new Date();

	@SuppressWarnings("unchecked")
	public Veiculo newInstance() {
		return new Veiculo();
	}

	@Override
	public Map<String, ?> getParametrosSimpleSearch(String textSearch) {
		@SuppressWarnings("unchecked")
		Map<String, Object> params = (Map<String, Object>) super
				.getParametrosSimpleSearch(textSearch);

		params.put("placa", textToSearch(textSearch));
		params.put("descricao", textToSearch(textSearch));
		params.put("ano", textToSearch(textSearch));
		params.put("renavan", textToSearch(textSearch));
		params.put("cidade", textToSearch(textSearch));
		params.put("uf", textToSearch(textSearch));
		params.put("marca", textToSearch(textSearch));
		params.put("modelo", textToSearch(textSearch));
		params.put("combustivel", textToSearch(textSearch));
		params.put("capacidade", textToSearch(textSearch));
		params.put("seguradora", textToSearch(textSearch));

		return params;
	}

	public Map<String, String> getParametrosAdvancedSearch() {
		Map<String, String> params = (Map<String, String>) super
				.getParametrosAdvancedSearch();

		params.put("placa", "Placa");
		params.put("descricao", "Descriçã");
		params.put("ano", "Ano");
		params.put("renavan", "Renavan");
		params.put("cidade", "Cidade");
		params.put("uf", "UF");
		params.put("marca", "Marca");
		params.put("modelo", "Modelo");
		params.put("combustivel", "Combustivel");
		params.put("capacidade", "Capacidade");
		params.put("seguradora", "Seguradora");

		return params;
	}

	@SuppressWarnings("rawtypes")
	@Override
	public Collection getList(AbstractEntity name) {
		if (name instanceof VeiculoRastreador) {
			return getVeiculoRastreadores();
		}
//		if (name instanceof VeiculoSensor) {
//			return getVeiculoSensores();
//		}
//		if (name instanceof VeiculoAdicional) {
//			return getVeiculoAdicionais();
//		}
		if (name instanceof Sensor) {
			return getSensors();
		}
		if (name instanceof Atuador) {
			return getAtuadors();
		}
		if (name instanceof Adicional) {
			return getAdicionals();
		}
		if (name instanceof VeiculoServicoManutencao) {
			return getVeiculoServicoManutencoes();
		}

		throw new NullPointerException();
	}

	public String getTipoAquisicao() {
		return tipoAquisicao;
	}

	public void setTipoAquisicao(String tipoAquisicao) {
		this.tipoAquisicao = tipoAquisicao;
	}

	public String getPlaca() {
		return placa;
	}

	public void setPlaca(String placa) {
		this.placa = placa;
	}

	public String getDescricao() {
		return descricao;
	}

	public void setDescricao(String descricao) {
		this.descricao = descricao;
	}

	public Integer getAno() {
		return ano;
	}

	public void setAno(Integer ano) {
		this.ano = ano;
	}

	public String getRenavan() {
		return renavan;
	}

	public void setRenavan(String renavan) {
		this.renavan = renavan;
	}

	public String getChassi() {
		return chassi;
	}

	public void setChassi(String chassi) {
		this.chassi = chassi;
	}

	public String getCidade() {
		return cidade;
	}

	public void setCidade(String cidade) {
		this.cidade = cidade;
	}

	public String getUf() {
		return uf;
	}

	public void setUf(String uf) {
		this.uf = uf;
	}

	public String getMarca() {
		return marca;
	}

	public void setMarca(String marca) {
		this.marca = marca;
	}

	public String getModelo() {
		return modelo;
	}

	public void setModelo(String modelo) {
		this.modelo = modelo;
	}

	public String getTipo() {
		return tipo;
	}

	public void setTipo(String tipo) {
		this.tipo = tipo;
	}

	// public Motorista getMotorista() {
	// return motorista;
	// }
	//
	// public void setMotorista(Motorista motorista) {
	// this.motorista = motorista;
	// }

	public Proprietario getProprietario() {
		return proprietario;
	}

	public void setProprietario(Proprietario proprietario) {
		this.proprietario = proprietario;
	}

	public Date getDataAquisicao() {
		return dataAquisicao;
	}

	public void setDataAquisicao(Date dataAquisicao) {
		this.dataAquisicao = dataAquisicao;
	}

	public Double getValorAquisicao() {
		return valorAquisicao;
	}

	public void setValorAquisicao(Double valorAquisicao) {
		this.valorAquisicao = valorAquisicao;
	}

	public Double getValorVenda() {
		return valorVenda;
	}

	public void setValorVenda(Double valorVenda) {
		this.valorVenda = valorVenda;
	}

	public String getInformacoes() {
		return informacoes;
	}

	public void setInformacoes(String informacoes) {
		this.informacoes = informacoes;
	}

	public Boolean getInativo() {
		return inativo;
	}

	public void setInativo(Boolean inativo) {
		this.inativo = inativo;
	}

	public String getNumeroCertificado() {
		return numeroCertificado;
	}

	public void setNumeroCertificado(String numeroCertificado) {
		this.numeroCertificado = numeroCertificado;
	}

	public String getMedidas() {
		return medidas;
	}

	public void setMedidas(String medidas) {
		this.medidas = medidas;
	}

	public String getCor() {
		return cor;
	}

	public void setCor(String cor) {
		this.cor = cor;
	}

	public String getCombustivel() {
		return combustivel;
	}

	public void setCombustivel(String combustivel) {
		this.combustivel = combustivel;
	}

	public String getMediaConsLt() {
		return mediaConsLt;
	}

	public void setMediaConsLt(String mediaConsLt) {
		this.mediaConsLt = mediaConsLt;
	}

	public Integer getKmAtual() {
		return kmAtual;
	}

	public void setKmAtual(Integer kmAtual) {
		this.kmAtual = kmAtual;
	}

	public String getCapacidade() {
		return capacidade;
	}

	public void setCapacidade(String capacidade) {
		this.capacidade = capacidade;
	}

	public String getCarretaTipo() {
		return carretaTipo;
	}

	public void setCarretaTipo(String carretaTipo) {
		this.carretaTipo = carretaTipo;
	}

	public String getCarretaPlaca() {
		return carretaPlaca;
	}

	public void setCarretaPlaca(String carretaPlaca) {
		this.carretaPlaca = carretaPlaca;
	}

	public String getCarretaRenavan() {
		return carretaRenavan;
	}

	public void setCarretaRenavan(String carretaRenavan) {
		this.carretaRenavan = carretaRenavan;
	}

	public String getCarretaChassi() {
		return carretaChassi;
	}

	public void setCarretaChassi(String carretaChassi) {
		this.carretaChassi = carretaChassi;
	}

	public Integer getCarretaAnoFabricacao() {
		return carretaAnoFabricacao;
	}

	public void setCarretaAnoFabricacao(Integer carretaAnoFabricacao) {
		this.carretaAnoFabricacao = carretaAnoFabricacao;
	}

	public String getCarretaMarca() {
		return carretaMarca;
	}

	public void setCarretaMarca(String carretaMarca) {
		this.carretaMarca = carretaMarca;
	}

	public String getCarretaModelo() {
		return carretaModelo;
	}

	public void setCarretaModelo(String carretaModelo) {
		this.carretaModelo = carretaModelo;
	}

	public String getSeguradora() {
		return seguradora;
	}

	public void setSeguradora(String seguradora) {
		this.seguradora = seguradora;
	}

	public String getCorretora() {
		return corretora;
	}

	public void setCorretora(String corretora) {
		this.corretora = corretora;
	}

	public String getApolice() {
		return apolice;
	}

	public void setApolice(String apolice) {
		this.apolice = apolice;
	}

	public String getTipoSeguradora() {
		return tipoSeguradora;
	}

	public void setTipoSeguradora(String tipoSeguradora) {
		this.tipoSeguradora = tipoSeguradora;
	}

	public Date getDataVencimentoSeguro() {
		return dataVencimentoSeguro;
	}

	public void setDataVencimentoSeguro(Date dataVencimentoSeguro) {
		this.dataVencimentoSeguro = dataVencimentoSeguro;
	}

	public Double getColisao() {
		return colisao;
	}

	public void setColisao(Double colisao) {
		this.colisao = colisao;
	}

	public Double getRoubo() {
		return roubo;
	}

	public void setRoubo(Double roubo) {
		this.roubo = roubo;
	}

	public Double getExplosao() {
		return explosao;
	}

	public void setExplosao(Double explosao) {
		this.explosao = explosao;
	}

	public Double getDanosMateriais() {
		return danosMateriais;
	}

	public void setDanosMateriais(Double danosMateriais) {
		this.danosMateriais = danosMateriais;
	}

	public Double getDanosCorporais() {
		return danosCorporais;
	}

	public void setDanosCorporais(Double danosCorporais) {
		this.danosCorporais = danosCorporais;
	}

	public Double getTerceiros() {
		return terceiros;
	}

	public void setTerceiros(Double terceiros) {
		this.terceiros = terceiros;
	}

	public Double getIncendio() {
		return incendio;
	}

	public void setIncendio(Double incendio) {
		this.incendio = incendio;
	}

	public Double getRaio() {
		return raio;
	}

	public void setRaio(Double raio) {
		this.raio = raio;
	}

	public Double getOutros() {
		return outros;
	}

	public void setOutros(Double outros) {
		this.outros = outros;
	}

	public Double getValorPago() {
		return valorPago;
	}

	public void setValorPago(Double valorPago) {
		this.valorPago = valorPago;
	}

	public String getLotacaoMinima() {
		return lotacaoMinima;
	}

	public void setLotacaoMinima(String lotacaoMinima) {
		this.lotacaoMinima = lotacaoMinima;
	}

	public String getLotacaoMaxima() {
		return lotacaoMaxima;
	}

	public void setLotacaoMaxima(String lotacaoMaxima) {
		this.lotacaoMaxima = lotacaoMaxima;
	}

	public Double getValorPorViagem() {
		return valorPorViagem;
	}

	public void setValorPorViagem(Double valorPorViagem) {
		this.valorPorViagem = valorPorViagem;
	}

	public Double getValorViagemExecido() {
		return valorViagemExecido;
	}

	public void setValorViagemExecido(Double valorViagemExecido) {
		this.valorViagemExecido = valorViagemExecido;
	}

	public Double getValorKmRodado() {
		return valorKmRodado;
	}

	public void setValorKmRodado(Double valorKmRodado) {
		this.valorKmRodado = valorKmRodado;
	}

	public Double getValorKmExecido() {
		return valorKmExecido;
	}

	public void setValorKmExecido(Double valorKmExecido) {
		this.valorKmExecido = valorKmExecido;
	}

	public Double getValorHora() {
		return valorHora;
	}

	public void setValorHora(Double valorHora) {
		this.valorHora = valorHora;
	}

	public Double getValorHoraExecido() {
		return valorHoraExecido;
	}

	public void setValorHoraExecido(Double valorHoraExecido) {
		this.valorHoraExecido = valorHoraExecido;
	}

	public Double getValorDia() {
		return valorDia;
	}

	public void setValorDia(Double valorDia) {
		this.valorDia = valorDia;
	}

	public Double getValorDiaExecido() {
		return valorDiaExecido;
	}

	public void setValorDiaExecido(Double valorDiaExecido) {
		this.valorDiaExecido = valorDiaExecido;
	}

	public Double getPorcPagarMotor() {
		return porcPagarMotor;
	}

	public void setPorcPagarMotor(Double porcPagarMotor) {
		this.porcPagarMotor = porcPagarMotor;
	}

	public Double getValorPorEntrega() {
		return valorPorEntrega;
	}

	public void setValorPorEntrega(Double valorPorEntrega) {
		this.valorPorEntrega = valorPorEntrega;
	}

	public Double getValorDevolucao() {
		return valorDevolucao;
	}

	public void setValorDevolucao(Double valorDevolucao) {
		this.valorDevolucao = valorDevolucao;
	}

	public Double getValorNF() {
		return valorNF;
	}

	public void setValorNF(Double valorNF) {
		this.valorNF = valorNF;
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

	public Set<VeiculoRastreador> getVeiculoRastreadores() {
		return veiculoRastreadores;
	}

	public void setVeiculoRastreadores(
			Set<VeiculoRastreador> veiculoRastreadores) {
		this.veiculoRastreadores = veiculoRastreadores;
	}

	public Set<VeiculoServicoManutencao> getVeiculoServicoManutencoes() {
		return veiculoServicoManutencoes;
	}

	public void setVeiculoServicoManutencoes(
			Set<VeiculoServicoManutencao> veiculoServicoManutencoes) {
		this.veiculoServicoManutencoes = veiculoServicoManutencoes;
	}

	public String getClassificacao() {
		return classificacao;
	}

	public void setClassificacao(String classificacao) {
		this.classificacao = classificacao;
	}

	public Set<Sensor> getSensors() {
		return sensors;
	}

	public void setSensors(Set<Sensor> sensors) {
		this.sensors = sensors;
	}

	public Set<Atuador> getAtuadors() {
		return atuadors;
	}

	public void setAtuadors(Set<Atuador> atuadors) {
		this.atuadors = atuadors;
	}

	public Set<Adicional> getAdicionals() {
		return adicionals;
	}

	public void setAdicionals(Set<Adicional> adicionals) {
		this.adicionals = adicionals;
	}
}
