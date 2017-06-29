package br.com.jgle.acti.entity;

import java.util.Date;
import java.util.Map;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.ManyToOne;
import javax.persistence.Temporal;
import javax.persistence.TemporalType;

@SuppressWarnings("serial")
@Entity(name = "LOG_ACESSO")
public class LogAcesso extends AbstractEntity {

	public static final String ACAO_VISUALIZACAO = "VISUALIZACAO";

	@ManyToOne
	protected Login login;

	@Column(length = 50)
	protected String nome;

	@Temporal(TemporalType.TIMESTAMP)
	protected Date dataHora;

	@Column(length = 15)
	protected String ip;

	@Column(length = 20)
	protected String pagina;

	@Column(length = 15)
	protected String acao;

	protected Integer identificador;

	@ManyToOne
	protected Unidade unidade;

	@SuppressWarnings("unchecked")
	public LogAcesso newInstance() {
		return new LogAcesso();
	}

	@Override
	public Map<String, ?> getParametrosSimpleSearch(String textSearch) {
		@SuppressWarnings("unchecked")
		Map<String, Object> params = (Map<String, Object>) super.getParametrosSimpleSearch(textSearch);

		params.put("nome", textToSearch(textSearch));

		return params;
	}

	public Login getLogin() {
		return login;
	}

	public void setLogin(Login login) {
		this.login = login;
	}

	public String getNome() {
		return nome;
	}

	public void setNome(String nome) {
		this.nome = nome;
	}

	public Date getDataHora() {
		return dataHora;
	}

	public void setDataHora(Date dataHora) {
		this.dataHora = dataHora;
	}

	public String getIp() {
		return ip;
	}

	public void setIp(String ip) {
		this.ip = ip;
	}

	public String getPagina() {
		return pagina;
	}

	public void setPagina(String pagina) {
		this.pagina = pagina;
	}

	public String getAcao() {
		return acao;
	}

	public void setAcao(String acao) {
		this.acao = acao;
	}

	public Unidade getUnidade() {
		return unidade;
	}

	public void setUnidade(Unidade unidade) {
		this.unidade = unidade;
	}

	public Integer getIdentificador() {
		return identificador;
	}

	public void setIdentificador(Integer identificador) {
		this.identificador = identificador;
	}

}
