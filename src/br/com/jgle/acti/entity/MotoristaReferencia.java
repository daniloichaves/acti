package br.com.jgle.acti.entity;

import java.util.Map;

import javax.persistence.Column;
import javax.persistence.Entity;

@SuppressWarnings("serial")
@Entity
public class MotoristaReferencia extends AbstractEntity {

	@Column(length = 35)
	protected String contato;
	@Column(length = 35)
	protected String empresa;
	@Column(length = 15)
	protected String telefone;
	@Column(length = 30)
	protected String parentesco;

	@SuppressWarnings("unchecked")
	public MotoristaReferencia newInstance() {
		return new MotoristaReferencia();
	}

	@Override
	public Map<String, ?> getParametrosSimpleSearch(String textSearch) {
		@SuppressWarnings("unchecked")
		Map<String, Object> params = (Map<String, Object>) super.getParametrosSimpleSearch(textSearch);

		params.put("contato", textToSearch(textSearch));
		params.put("empresa", textToSearch(textSearch));
		params.put("telefone", textToSearch(textSearch));
		params.put("cidade", textToSearch(textSearch));
		params.put("parentesco", textToSearch(textSearch));

		return params;
	}

	public String getContato() {
		return contato;
	}

	public void setContato(String contato) {
		this.contato = contato;
	}

	public String getEmpresa() {
		return empresa;
	}

	public void setEmpresa(String empresa) {
		this.empresa = empresa;
	}

	public String getTelefone() {
		return telefone;
	}

	public void setTelefone(String telefone) {
		this.telefone = telefone;
	}

	public String getParentesco() {
		return parentesco;
	}

	public void setParentesco(String parentesco) {
		this.parentesco = parentesco;
	}
}
