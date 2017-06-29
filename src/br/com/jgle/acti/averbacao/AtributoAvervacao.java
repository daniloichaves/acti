package br.com.jgle.acti.averbacao;

import br.com.jgle.acti.util.StringUtil;

public class AtributoAvervacao {

	private int num;
	private String campo;
	private String tipo;
	private int coluna;
	private int tamanho;
	private String descricao;
	// Obter da base de dados
	private String valor = "";

	public AtributoAvervacao(int num, String campo, String tipo, int coluna, int tamanho, String descricao) {
		super();
		this.num = num;
		this.campo = campo;
		this.tipo = tipo;
		this.coluna = coluna;
		this.tamanho = tamanho;
		this.descricao = descricao;
	}

	public void setValor(String valor) throws Exception {
		if (valor != null && valor.length() > tamanho)
			throw new Exception("Valor maior que tamanho do campo permitido - " + campo);

		this.valor = valor;
	}

	public String preencherLinha(String linha) {
		String preenchido = StringUtil.escrever(linha, coluna, tamanho, valor);

		return preenchido;
	}

	public String getCampo() {
		return campo;
	}

	public void setCampo(String campo) {
		this.campo = campo;
	}

	public int getNum() {
		return num;
	}

	public String getTipo() {
		return tipo;
	}

	public int getColuna() {
		return coluna;
	}

	public int getTamanho() {
		return tamanho;
	}

	public String getDescricao() {
		return descricao;
	}

	public String getValor() {
		return valor;
	}

	public void setNum(int num) {
		this.num = num;
	}

	public void setTipo(String tipo) {
		this.tipo = tipo;
	}

	public void setColuna(int coluna) {
		this.coluna = coluna;
	}

	public void setTamanho(int tamanho) {
		this.tamanho = tamanho;
	}

	public void setDescricao(String descricao) {
		this.descricao = descricao;
	}

}
