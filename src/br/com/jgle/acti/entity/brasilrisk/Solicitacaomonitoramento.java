package br.com.jgle.acti.entity.brasilrisk;

import javax.xml.bind.annotation.XmlRootElement;



@XmlRootElement
public class Solicitacaomonitoramento {
	
	protected String autenticacao;
	protected String tipo_gris;
	protected String cnpj_cliente;
	protected String centro_custo_cliente;
	protected String cnpj_transportadora;
	protected String cpf_motorista;
	protected String placa_veiculo;
	protected String placa_carreta;
	protected String tipo_produto;

	protected OrigemParada origem;

	protected Destinos destinos;

	protected Planejamento planejamento;
	
	protected Paradas paradas;

	protected String observacoes;

	public String getAutenticacao() {
		return autenticacao;
	}

	public void setAutenticacao(String autenticacao) {
		this.autenticacao = autenticacao;
	}

	public String getTipo_gris() {
		return tipo_gris;
	}

	public void setTipo_gris(String tipo_gris) {
		this.tipo_gris = tipo_gris;
	}

	public String getCnpj_cliente() {
		return cnpj_cliente;
	}

	public void setCnpj_cliente(String cnpj_cliente) {
		this.cnpj_cliente = cnpj_cliente;
	}

	public String getCentro_custo_cliente() {
		return centro_custo_cliente;
	}

	public void setCentro_custo_cliente(String centro_custo_cliente) {
		this.centro_custo_cliente = centro_custo_cliente;
	}

	public String getCnpj_transportadora() {
		return cnpj_transportadora;
	}

	public void setCnpj_transportadora(String cnpj_transportadora) {
		this.cnpj_transportadora = cnpj_transportadora;
	}

	public String getCpf_motorista() {
		return cpf_motorista;
	}

	public void setCpf_motorista(String cpf_motorista) {
		this.cpf_motorista = cpf_motorista;
	}

	public String getPlaca_veiculo() {
		return placa_veiculo;
	}

	public void setPlaca_veiculo(String placa_veiculo) {
		this.placa_veiculo = placa_veiculo;
	}

	public String getPlaca_carreta() {
		return placa_carreta;
	}

	public void setPlaca_carreta(String placa_carreta) {
		this.placa_carreta = placa_carreta;
	}

	public String getTipo_produto() {
		return tipo_produto;
	}

	public void setTipo_produto(String tipo_produto) {
		this.tipo_produto = tipo_produto;
	}

	public OrigemParada getOrigem() {
		return origem;
	}

	public void setOrigem(OrigemParada origem) {
		this.origem = origem;
	}

	public Destinos getDestinos() {
		return destinos;
	}

	public void setDestinos(Destinos destinos) {
		this.destinos = destinos;
	}

	public Planejamento getPlanejamento() {
		return planejamento;
	}

	public void setPlanejamento(Planejamento planejamento) {
		this.planejamento = planejamento;
	}

	public Paradas getParadas() {
		return paradas;
	}

	public void setParadas(Paradas paradas) {
		this.paradas = paradas;
	}

	public String getObservacoes() {
		return observacoes;
	}

	public void setObservacoes(String observacoes) {
		this.observacoes = observacoes;
	}
}
