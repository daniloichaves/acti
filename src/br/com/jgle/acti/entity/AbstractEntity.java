package br.com.jgle.acti.entity;

import java.io.Serializable;
import java.util.ArrayList;
import java.util.Collection;
import java.util.Date;
import java.util.HashMap;
import java.util.Map;

import javax.persistence.Column;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.MappedSuperclass;
import javax.persistence.Temporal;
import javax.persistence.TemporalType;

@SuppressWarnings("serial")
@MappedSuperclass
public abstract class AbstractEntity implements Serializable, Comparable<AbstractEntity> {

	@Override
	public boolean equals(Object obj) {
		if (this == obj) {
			return true;
		}
		if (obj instanceof AbstractEntity) {
			AbstractEntity other = (AbstractEntity) obj;
			if (this.getId() != null && other.getId() != null && this.getId().equals(other.getId())) {
				return true;
			}
		}
		return false;
	}

	@Override
	public int hashCode() {
		return this.getId() == null ? System.identityHashCode(this) : this.getId().hashCode();
	}

	public abstract <T> T newInstance();

	public Map<String, ?> getParametrosSimpleSearch(String textSearch) {
		Map<String, Object> params = new HashMap<String, Object>();

		// params.put("unidade", textSearch);

		return params;
	}

	public Map<String, String> getParametrosAdvancedSearch() {
		Map<String, String> params = new HashMap<String, String>();

		return params;
	}

	public String textToSearch(String text) {
		return "%" + text.toUpperCase() + "%";
	}

	@SuppressWarnings("rawtypes")
	public Collection getList(String name) {
		return null;
	}

	@SuppressWarnings("rawtypes")
	public Collection getList(AbstractEntity name) {
		return new ArrayList();
	}

	@SuppressWarnings("rawtypes")
	public void setList(Collection list) {

	}

	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	protected Integer id;

	@Temporal(TemporalType.TIMESTAMP)
	protected Date dataCriacao = new Date();

	@Temporal(TemporalType.TIMESTAMP)
	protected Date dataAlteracao = new Date();

	@Column(length = 5)
	protected String sigla;

	protected Integer qtdVisto = 0;

	protected Boolean ativo = new Boolean(true);

	public Integer getId() {
		return id;
	}

	public void setId(Integer id) {
		this.id = id;
	}

	public int compareTo(AbstractEntity o) {

		return hashCode() - o.hashCode();
	}

	public Date getDataCriacao() {
		return dataCriacao;
	}

	public void setDataCriacao(Date dataCriacao) {
		this.dataCriacao = dataCriacao;
	}

	public Date getDataAlteracao() {
		return dataAlteracao;
	}

	public void setDataAlteracao(Date dataAlteracao) {
		this.dataAlteracao = dataAlteracao;
	}

	public Integer getQtdVisto() {
		return qtdVisto;
	}

	public void setQtdVisto(Integer qtdVisto) {
		this.qtdVisto = qtdVisto;
	}

	public Boolean getAtivo() {
		return ativo;
	}

	public void setAtivo(Boolean ativo) {
		this.ativo = ativo;
	}

	public String getSigla() {
		return sigla;
	}

	public void setSigla(String sigla) {
		this.sigla = sigla;
	}

}
