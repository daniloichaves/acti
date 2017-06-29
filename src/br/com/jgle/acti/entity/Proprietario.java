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
import javax.persistence.OneToMany;
import javax.persistence.Temporal;
import javax.persistence.TemporalType;
import javax.persistence.Transient;

@SuppressWarnings("serial")
@Entity
public class Proprietario extends AbstractEntity {

	@Column(length = 10)
	protected String tipoPessoa;
	@Column(length = 50)
	protected String nomeProprietario;
	@Column(length = 50)
	protected String nomeMae;
	@Column(length = 50)
	protected String nomePai;
	@Column(length = 20)
	protected String cnpjcpf;
	@Column(length = 20)
	protected String ierg;
	@Column(length = 3)
	protected String ufrg;
	@Column(length = 200)
	protected String observacao;

	@Temporal(TemporalType.DATE)
	protected Date dataNascimento;

	@SuppressWarnings("unchecked")
	public Proprietario newInstance() {
		return new Proprietario();
	}

	@OneToMany(cascade = CascadeType.ALL, fetch = FetchType.EAGER)
	protected Set<Telefone> telefones = new HashSet<Telefone>();
	@OneToMany(cascade = CascadeType.ALL, fetch = FetchType.EAGER)
	protected Set<Email> emails = new HashSet<Email>();
	@OneToMany(cascade = CascadeType.ALL, fetch = FetchType.EAGER)
	protected Set<ContaBanco> contaBancos = new HashSet<ContaBanco>();
	@OneToMany(cascade = CascadeType.ALL, fetch = FetchType.EAGER)
	protected Set<Endereco> enderecos = new HashSet<Endereco>();

	@SuppressWarnings("rawtypes")
	@Override
	public Collection getList(AbstractEntity name) {
		if (name instanceof Telefone) {
			return getTelefones();
		} else if (name instanceof Email) {
			return getEmails();
		} else if (name instanceof ContaBanco) {
			return getContaBancos();
		} else if (name instanceof Endereco) {
			return getEnderecos();
		}
		throw new NullPointerException();
	}

	@Override
	public Map<String, ?> getParametrosSimpleSearch(String textSearch) {
		@SuppressWarnings("unchecked")
		Map<String, Object> params = (Map<String, Object>) super
				.getParametrosSimpleSearch(textSearch);

		params.put("nomeProprietario", textToSearch(textSearch));
		params.put("cnpjcpf", textToSearch(textSearch));
		params.put("ierg", textToSearch(textSearch));
		params.put("observacao", textToSearch(textSearch));

		return params;
	}

	public Map<String, String> getParametrosAdvancedSearch() {
		Map<String, String> params = (Map<String, String>) super
				.getParametrosAdvancedSearch();

		params.put("nomeProprietario", "Proprietário");
		params.put("ierg", "IE/RG");
		params.put("observacao", "Observacao");

		return params;

	}

	@Transient
	public String getTipoPessoaBrasilRisk() {
		if (getTipoPessoa() != null) {
			if ("JURIDICA".equals(getTipoPessoa())) {
				return "1";
			} else if ("FISICA".equals(getTipoPessoa())) {
				return "2";
			}
		}
		return null;
	}

	public String getTipoPessoa() {
		return tipoPessoa;
	}

	public void setTipoPessoa(String tipoPessoa) {
		this.tipoPessoa = tipoPessoa;
	}

	public String getNomeProprietario() {
		return nomeProprietario;
	}

	public void setNomeProprietario(String nomeProprietario) {
		this.nomeProprietario = nomeProprietario;
	}

	public String getIerg() {
		return ierg;
	}

	public void setIerg(String ierg) {
		this.ierg = ierg;
	}

	public String getUfrg() {
		return ufrg;
	}

	public void setUfrg(String ufrg) {
		this.ufrg = ufrg;
	}

	public String getCnpjcpf() {
		return cnpjcpf;
	}

	public void setCnpjcpf(String cnpjcpf) {
		this.cnpjcpf = cnpjcpf;
	}

	public String getObservacao() {
		return observacao;
	}

	public void setObservacao(String observacao) {
		this.observacao = observacao;
	}

	public Set<Telefone> getTelefones() {
		return telefones;
	}

	public void setTelefones(Set<Telefone> telefones) {
		this.telefones = telefones;
	}

	public Set<Email> getEmails() {
		return emails;
	}

	public void setEmails(Set<Email> emails) {
		this.emails = emails;
	}

	public Set<ContaBanco> getContaBancos() {
		return contaBancos;
	}

	public void setContaBancos(Set<ContaBanco> contaBancos) {
		this.contaBancos = contaBancos;
	}

	public Set<Endereco> getEnderecos() {
		return enderecos;
	}

	public void setEnderecos(Set<Endereco> enderecos) {
		this.enderecos = enderecos;
	}

	public Date getDataNascimento() {
		return dataNascimento;
	}

	public void setDataNascimento(Date dataNascimento) {
		this.dataNascimento = dataNascimento;
	}

	public String getNomeMae() {
		return nomeMae;
	}

	public void setNomeMae(String nomeMae) {
		this.nomeMae = nomeMae;
	}

	public String getNomePai() {
		return nomePai;
	}

	public void setNomePai(String nomePai) {
		this.nomePai = nomePai;
	}
}
