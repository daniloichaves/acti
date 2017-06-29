package br.com.jgle.acti.entity.pgr;

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
import javax.persistence.ManyToMany;
import javax.persistence.ManyToOne;
import javax.persistence.OneToMany;
import javax.persistence.Temporal;
import javax.persistence.TemporalType;

import org.hibernate.annotations.Fetch;
import org.hibernate.annotations.FetchMode;

import br.com.jgle.acti.entity.AbstractEntity;
import br.com.jgle.acti.entity.Cliente;
import br.com.jgle.acti.entity.Endereco;
import br.com.jgle.acti.entity.Fornecedor;
import br.com.jgle.acti.entity.Unidade;

@SuppressWarnings("serial")
@Entity
public class Projeto extends AbstractEntity {

	@ManyToOne(cascade = CascadeType.ALL)
	protected Fornecedor seguradora;
	
	@ManyToOne(cascade = CascadeType.ALL)
	protected Fornecedor corretora;

	@Temporal(TemporalType.DATE)
	protected Date dataVigenciaInicial;

	@Temporal(TemporalType.DATE)
	protected Date dataVigenciaFinal;

	@ManyToMany(fetch = FetchType.EAGER, cascade = CascadeType.ALL)
	@Fetch(FetchMode.SELECT)
	protected Set<Unidade> unidades = new HashSet<Unidade>();

	protected BigDecimal limiteMaximoGarantia = BigDecimal.ZERO;

	@Column(length = 500)
	protected String bensNaoCompreendidosSeguro;

	@Column(length = 250)
	protected String arquivosNamesSeparadoPorVirgula = "";

	@ManyToMany(fetch = FetchType.EAGER, cascade = CascadeType.ALL)
	protected Set<Cliente> embarcadoresSegProprio = new HashSet<Cliente>();

	@OneToMany(cascade = CascadeType.ALL, fetch = FetchType.EAGER, orphanRemoval = true)
	@Fetch(FetchMode.SELECT)
	protected Set<GrupoMercadoria> grupoMercadorias = new HashSet<GrupoMercadoria>();

	@OneToMany(cascade = CascadeType.ALL, fetch = FetchType.EAGER)
	@Fetch(FetchMode.SELECT)
	protected Set<Endereco> enderecos = new HashSet<Endereco>();

	@OneToMany(cascade = CascadeType.ALL, fetch = FetchType.EAGER)
	@Fetch(FetchMode.SELECT)
	protected Set<Rastreador> rastreadores = new HashSet<Rastreador>();

	@OneToMany(cascade = CascadeType.ALL, fetch = FetchType.EAGER)
	@Fetch(FetchMode.SELECT)
	protected Set<Sensor> sensors = new HashSet<Sensor>();

	@OneToMany(cascade = CascadeType.ALL, fetch = FetchType.EAGER)
	@Fetch(FetchMode.SELECT)
	protected Set<Atuador> atuadors = new HashSet<Atuador>();

	@OneToMany(cascade = CascadeType.ALL, fetch = FetchType.EAGER)
	@Fetch(FetchMode.SELECT)
	protected Set<Adicional> adicionals = new HashSet<Adicional>();

	protected Integer tempoMaximoComunicacao;

	@OneToMany(cascade = CascadeType.ALL, fetch = FetchType.EAGER)
	@Fetch(FetchMode.SELECT)
	protected Set<Estado> estado = new HashSet<Estado>();

	protected Integer tempoMaximoComunicacao2;

	@OneToMany(cascade = CascadeType.ALL, fetch = FetchType.EAGER)
	@Fetch(FetchMode.SELECT)
	protected Set<Estado> estado2 = new HashSet<Estado>();

	@OneToMany(cascade = CascadeType.ALL, fetch = FetchType.EAGER)
	@Fetch(FetchMode.SELECT)
	protected Set<EscoltaArmadaTrajeto> escoltaArmadaTrajetos = new HashSet<EscoltaArmadaTrajeto>();

	protected Boolean veiculoRastreado;
	protected Boolean sensores;
	protected Boolean atuadores;
	protected Boolean adicionaisObrigadorios;
	protected Boolean termoCompromissoMotorista;

	@Override
	public Map<String, ?> getParametrosSimpleSearch(String textSearch) {
		@SuppressWarnings("unchecked")
		Map<String, Object> params = (Map<String, Object>) super
				.getParametrosSimpleSearch(textSearch);

		params.put("unidade", textToSearch(textSearch));
		params.put("bensNaoCompreendidosSeguro", textToSearch(textSearch));

		return params;
	}

	@SuppressWarnings("rawtypes")
	@Override
	public Collection getList(AbstractEntity name) {
		if (name instanceof Cliente) {
			return getEmbarcadoresSegProprio();
		} else if (name instanceof GrupoMercadoria) {
			return getGrupoMercadorias();
		} else if (name instanceof Endereco) {
			return getEnderecos();
		} else if (name instanceof EscoltaArmadaTrajeto) {
			return getEscoltaArmadaTrajetos();
		}
		throw new NullPointerException();
	}

	@Override
	@SuppressWarnings("unchecked")
	public Projeto newInstance() {
		return new Projeto();
	}

	public BigDecimal getLimiteMaximoGarantia() {
		return limiteMaximoGarantia;
	}

	public String getBensNaoCompreendidosSeguro() {
		return bensNaoCompreendidosSeguro;
	}

	public Set<Cliente> getEmbarcadoresSegProprio() {
		return embarcadoresSegProprio;
	}

	public void setLimiteMaximoGarantia(BigDecimal limiteMaximoGarantia) {
		this.limiteMaximoGarantia = limiteMaximoGarantia;
	}

	public void setBensNaoCompreendidosSeguro(String bensNaoCompreendidosSeguro) {
		this.bensNaoCompreendidosSeguro = bensNaoCompreendidosSeguro;
	}

	public void setEmbarcadoresSegProprio(Set<Cliente> embarcadoresSegProprio) {
		this.embarcadoresSegProprio = embarcadoresSegProprio;
	}

	public Boolean getVeiculoRastreado() {
		return veiculoRastreado;
	}

	public Boolean getSensores() {
		return sensores;
	}

	public Boolean getAtuadores() {
		return atuadores;
	}

	public Boolean getAdicionaisObrigadorios() {
		return adicionaisObrigadorios;
	}

	public Boolean getTermoCompromissoMotorista() {
		return termoCompromissoMotorista;
	}

	public void setVeiculoRastreado(Boolean veiculoRastreado) {
		this.veiculoRastreado = veiculoRastreado;
	}

	public void setSensores(Boolean sensores) {
		this.sensores = sensores;
	}

	public void setAtuadores(Boolean atuadores) {
		this.atuadores = atuadores;
	}

	public void setAdicionaisObrigadorios(Boolean adicionaisObrigadorios) {
		this.adicionaisObrigadorios = adicionaisObrigadorios;
	}

	public void setTermoCompromissoMotorista(Boolean termoCompromissoMotorista) {
		this.termoCompromissoMotorista = termoCompromissoMotorista;
	}

	public Set<GrupoMercadoria> getGrupoMercadorias() {
		return grupoMercadorias;
	}

	public void setGrupoMercadorias(Set<GrupoMercadoria> grupoMercadorias) {
		this.grupoMercadorias = grupoMercadorias;
	}

	public Set<Endereco> getEnderecos() {
		return enderecos;
	}

	public void setEnderecos(Set<Endereco> enderecos) {
		this.enderecos = enderecos;
	}

	public Set<EscoltaArmadaTrajeto> getEscoltaArmadaTrajetos() {
		return escoltaArmadaTrajetos;
	}

	public void setEscoltaArmadaTrajetos(
			Set<EscoltaArmadaTrajeto> escoltaArmadaTrajetos) {
		this.escoltaArmadaTrajetos = escoltaArmadaTrajetos;
	}

	public Set<Unidade> getUnidades() {
		return unidades;
	}

	public void setUnidades(Set<Unidade> unidades) {
		this.unidades = unidades;
	}

	public Integer getTempoMaximoComunicacao() {
		return tempoMaximoComunicacao;
	}

	public void setTempoMaximoComunicacao(Integer tempoMaximoComunicacao) {
		this.tempoMaximoComunicacao = tempoMaximoComunicacao;
	}

	public String getArquivosNamesSeparadoPorVirgula() {
		return arquivosNamesSeparadoPorVirgula;
	}

	public void setArquivosNamesSeparadoPorVirgula(
			String arquivosNamesSeparadoPorVirgula) {
		this.arquivosNamesSeparadoPorVirgula = arquivosNamesSeparadoPorVirgula;
	}

	public Set<Rastreador> getRastreadores() {
		return rastreadores;
	}

	public void setRastreadores(Set<Rastreador> rastreadores) {
		this.rastreadores = rastreadores;
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

	public Set<Estado> getEstado() {
		return estado;
	}

	public void setEstado(Set<Estado> estado) {
		this.estado = estado;
	}

	public Set<Estado> getEstado2() {
		return estado2;
	}

	public void setEstado2(Set<Estado> estado2) {
		this.estado2 = estado2;
	}

	public Integer getTempoMaximoComunicacao2() {
		return tempoMaximoComunicacao2;
	}

	public void setTempoMaximoComunicacao2(Integer tempoMaximoComunicacao2) {
		this.tempoMaximoComunicacao2 = tempoMaximoComunicacao2;
	}

	public Fornecedor getSeguradora() {
		return seguradora;
	}

	public void setSeguradora(Fornecedor seguradora) {
		this.seguradora = seguradora;
	}

	public Date getDataVigenciaInicial() {
		return dataVigenciaInicial;
	}

	public void setDataVigenciaInicial(Date dataVigenciaInicial) {
		this.dataVigenciaInicial = dataVigenciaInicial;
	}

	public Date getDataVigenciaFinal() {
		return dataVigenciaFinal;
	}

	public void setDataVigenciaFinal(Date dataVigenciaFinal) {
		this.dataVigenciaFinal = dataVigenciaFinal;
	}

	public Fornecedor getCorretora() {
		return corretora;
	}

	public void setCorretora(Fornecedor corretora) {
		this.corretora = corretora;
	}

}
