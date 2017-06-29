package br.com.jgle.acti.entity;

import java.util.Collection;
import java.util.Collections;
import java.util.HashSet;
import java.util.Map;
import java.util.Set;

import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.OneToMany;
import javax.persistence.Transient;

import org.hibernate.annotations.Fetch;
import org.hibernate.annotations.FetchMode;

@SuppressWarnings("serial")
@Entity
public class Unidade extends AbstractEntity {

	@Column(length = 150)
	private String razaoSocial;
	@Column(length = 100)
	private String nomeFantasia;
	@Column(length = 20)
	private String cnpj;
	// private String sigla;
	private Boolean matriz = false;
	@Column(length = 20)
	private String ie;
	@Column(length = 25)
	private String gerente;

	@OneToMany(cascade = CascadeType.ALL, fetch = FetchType.EAGER)
	@Fetch(FetchMode.SELECT)
	protected Set<Telefone> telefones = new HashSet<Telefone>();
	@OneToMany(cascade = CascadeType.ALL, fetch = FetchType.EAGER)
	@Fetch(FetchMode.SELECT)
	protected Set<Email> emails = new HashSet<Email>();
	@OneToMany(cascade = CascadeType.ALL, fetch = FetchType.EAGER)
	@Fetch(FetchMode.SELECT)
	protected Set<ContaBanco> contaBancos = new HashSet<ContaBanco>();
	@OneToMany(cascade = CascadeType.ALL, fetch = FetchType.EAGER)
	@Fetch(FetchMode.SELECT)
	protected Set<Endereco> enderecos = new HashSet<Endereco>();
	
	// CascadeType.REMOVE
	// Error javax.persistence.EntityNotFoundException: deleted entity passed to persist
	@OneToMany(cascade = CascadeType.REMOVE, fetch = FetchType.EAGER, mappedBy = "unidade")
	protected Set<Funcionario> funcionarios = new HashSet<Funcionario>();
	@OneToMany(cascade = CascadeType.REMOVE, fetch = FetchType.EAGER, mappedBy = "unidade")
	protected Set<Login> logins = new HashSet<Login>();

	@SuppressWarnings("unchecked")
	public Unidade newInstance() {
		return new Unidade();
	}

	@SuppressWarnings("rawtypes")
	@Override
	public Collection getList(AbstractEntity name) {
		if (name instanceof Telefone) {
			return getTelefones();
		} else if (name instanceof Email) {
			return getEmails();
		} else if (name instanceof ContaBanco) {
			return getContaBancos();
		} else if (name instanceof Funcionario) {
			return getFuncionarios();
		} else if (name instanceof Endereco) {
			return getEnderecos();
		}
		// throw new NullPointerException();
		return Collections.EMPTY_LIST;
	}

	@Override
	public Map<String, ?> getParametrosSimpleSearch(String textSearch) {
		@SuppressWarnings("unchecked")
		Map<String, Object> params = (Map<String, Object>) super
				.getParametrosSimpleSearch(textSearch);

		params.put("razaoSocial", textToSearch(textSearch));
		params.put("nomeFantasia", textToSearch(textSearch));
		params.put("cnpj", textToSearch(textSearch));
		params.put("sigla", textToSearch(textSearch));

		return params;
	}

	public Map<String, String> getParametrosAdvancedSearch() {
		Map<String, String> params = (Map<String, String>) super
				.getParametrosAdvancedSearch();

		params.put("razaoSocial", "Razão Social");
		params.put("nomeFantasia", "Nome Fantasia");
		params.put("cnpj", "CNPJ");
		params.put("sigla", "Sigla");

		return params;

	}
	
	@Transient
	public ContaBanco getContaBanco(){
		if(contaBancos.size() > 0)
			return contaBancos.iterator().next();
		
		return null;
	}

	public String getRazaoSocial() {
		return razaoSocial;
	}

	public void setRazaoSocial(String razaoSocial) {
		this.razaoSocial = razaoSocial;
	}

	public String getNomeFantasia() {
		return nomeFantasia;
	}

	public void setNomeFantasia(String nomeFantasia) {
		this.nomeFantasia = nomeFantasia;
	}

	public String getCnpj() {
		return cnpj;
	}

	public void setCnpj(String cnpj) {
		this.cnpj = cnpj;
	}

	public Boolean getMatriz() {
		return matriz;
	}

	public void setMatriz(Boolean matriz) {
		this.matriz = matriz;
	}

	public String getSigla() {
		return sigla;
	}

	public void setSigla(String sigla) {
		this.sigla = sigla;
	}

	public String getIe() {
		return ie;
	}

	public void setIe(String ie) {
		this.ie = ie;
	}

	public String getGerente() {
		return gerente;
	}

	public void setGerente(String gerente) {
		this.gerente = gerente;
	}

	public Set<Telefone> getTelefones() {
		if (telefones == null) {
			return new HashSet<Telefone>();
		}
		return telefones;
	}

	public void setTelefones(Set<Telefone> telefones) {
		this.telefones = telefones;
	}

	public Set<Email> getEmails() {
		if (emails == null) {
			return new HashSet<Email>();
		}

		return emails;
	}

	public void setEmails(Set<Email> emails) {
		this.emails = emails;
	}

	public Set<ContaBanco> getContaBancos() {
		if (contaBancos == null) {
			return new HashSet<ContaBanco>();
		}

		return contaBancos;
	}

	public void setContaBancos(Set<ContaBanco> contaBancos) {
		this.contaBancos = contaBancos;
	}

	public Set<Endereco> getEnderecos() {
		if (enderecos == null) {
			return new HashSet<Endereco>();
		}

		return enderecos;
	}

	public void setEnderecos(Set<Endereco> enderecos) {
		this.enderecos = enderecos;
	}

	public Set<Funcionario> getFuncionarios() {
		return funcionarios;
	}

	public void setFuncionarios(Set<Funcionario> funcionarios) {
		this.funcionarios = funcionarios;
	}

	public Set<Login> getLogins() {
		return logins;
	}

	public void setLogins(Set<Login> logins) {
		this.logins = logins;
	}

}