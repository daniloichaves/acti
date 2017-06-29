package br.com.jgle.acti.entity;

import java.util.Collection;
import java.util.Date;
import java.util.HashSet;
import java.util.Map;
import java.util.Set;

import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.DiscriminatorColumn;
import javax.persistence.DiscriminatorType;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.Inheritance;
import javax.persistence.InheritanceType;
import javax.persistence.ManyToOne;
import javax.persistence.OneToMany;
import javax.persistence.Temporal;
import javax.persistence.TemporalType;
import javax.persistence.Transient;

@SuppressWarnings("serial")
@Entity
@Inheritance(strategy = InheritanceType.SINGLE_TABLE)
@DiscriminatorColumn(name = "TIPO_CADASTRO", discriminatorType = DiscriminatorType.STRING)
public class ClienteFornecedor extends AbstractEntity {

	@Column(length = 20)
	protected String tipoRegistro;
	@Column(length = 10)
	protected String tipoPessoa;
	@Column(length = 20)
	protected String cnpjcpf;

	@Column(length = 100)
	protected String razaosocialnome;
	@Column(length = 50)
	protected String nomefantasiasobrenome;
	@Column(length = 15)
	protected String ierg;

	@Temporal(TemporalType.DATE)
	protected Date dataCadastro = new Date();

	@Column(length = 200)
	protected String observacao;
	@Column(length = 15)
	protected String tipoCobranca;

	@ManyToOne
	protected Funcionario vendedor;
	protected Float comissaoVendedor;

	@ManyToOne
	protected Funcionario representante;
	protected Float comissaoRepresentante;

	// restrições para não emitir
	protected Boolean restricaoOrdemColeta = new Boolean(false);
	protected Boolean restricaoConhecimento = new Boolean(false);
	protected Boolean restricaoFatura = new Boolean(false);
	protected Boolean restricaoComissao = new Boolean(false);

	@OneToMany(cascade = CascadeType.ALL, fetch = FetchType.EAGER)
	protected Set<Telefone> telefones = new HashSet<Telefone>();
	@OneToMany(cascade = CascadeType.ALL, fetch = FetchType.EAGER)
	protected Set<Email> emails = new HashSet<Email>();
	@OneToMany(cascade = CascadeType.ALL, fetch = FetchType.EAGER)
	protected Set<ContaBanco> contaBancos = new HashSet<ContaBanco>();
	@OneToMany(cascade = CascadeType.ALL, fetch = FetchType.EAGER)
	protected Set<Endereco> enderecos = new HashSet<Endereco>();

	@SuppressWarnings("unchecked")
	public ClienteFornecedor newInstance() {
		return new ClienteFornecedor();
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
		} else if (name instanceof Endereco) {
			return getEnderecos();
		}
		throw new NullPointerException();
	}

	@Transient
	public boolean isEditarCPFCNPJ() {
		if (cnpjcpf != null && !"".equals(cnpjcpf))
			return true;
		return false;
	}
	
	@Transient
	public Endereco getEnderecoCobranca(){
		for (Endereco endereco : enderecos) {
			if("COBRANCA".equals(endereco.getTipo()))
					return endereco;
		}
		if(enderecos.size() > 0)
			return enderecos.iterator().next();
		
		return null;
	}
	
	@Transient
	public ContaBanco getContaBanco(){
		if(contaBancos.size() > 0)
			return contaBancos.iterator().next();
		
		return null;
	}

	@Override
	public Map<String, ?> getParametrosSimpleSearch(String textSearch) {
		@SuppressWarnings("unchecked")
		Map<String, Object> params = (Map<String, Object>) super.getParametrosSimpleSearch(textSearch);

		params.put("razaosocialnome", textToSearch(textSearch));
		params.put("nomefantasiasobrenome", textToSearch(textSearch));
		params.put("cnpjcpf", textToSearch(textSearch));
		params.put("ierg", textToSearch(textSearch));
		params.put("observacao", textToSearch(textSearch));
		params.put("vendedor.nome", textToSearch(textSearch));
		params.put("vendedor.sobrenome", textToSearch(textSearch));
		params.put("representante.nome", textToSearch(textSearch));
		params.put("representante.sobrenome", textToSearch(textSearch));

		return params;
	}

	public Map<String, String> getParametrosAdvancedSearch() {
		Map<String, String> params = (Map<String, String>) super.getParametrosAdvancedSearch();

		params.put("razaosocialnome", "Razao/ Nome");
		params.put("nomefantasiasobrenome", "Fantasia/ Nome");
		params.put("cnpjcpf", "CNPJ/ CPF");
		params.put("ierg", "IE/ RG");
		params.put("observacao", "Observação");
		params.put("vendedor.nome", "Vendedor Nome");
		params.put("vendedor.sobrenome", "Vendedor Sobrenome");
		params.put("representante.nome", "Representante Nome");
		params.put("representante.sobrenome", "Representante Sobrenome");

		return params;
	}

	/** Get's and Set's **/
	public String getTipoRegistro() {
		return tipoRegistro;
	}

	public void setTipoRegistro(String tipoRegistro) {
		this.tipoRegistro = tipoRegistro;
	}

	public String getTipoPessoa() {
		return tipoPessoa;
	}

	public void setTipoPessoa(String tipoPessoa) {
		this.tipoPessoa = tipoPessoa;
	}

	public String getCnpjcpf() {
		return cnpjcpf;
	}

	public void setCnpjcpf(String cnpjcpf) {
		this.cnpjcpf = cnpjcpf;
	}

	public String getRazaosocialnome() {
		return razaosocialnome;
	}

	public void setRazaosocialnome(String razaosocialnome) {
		this.razaosocialnome = razaosocialnome;
	}

	public String getNomefantasiasobrenome() {
		return nomefantasiasobrenome;
	}

	public void setNomefantasiasobrenome(String nomefantasiasobrenome) {
		this.nomefantasiasobrenome = nomefantasiasobrenome;
	}

	public String getIerg() {
		return ierg;
	}

	public void setIerg(String ierg) {
		this.ierg = ierg;
	}

	public Date getDataCadastro() {
		return dataCadastro;
	}

	public void setDataCadastro(Date dataCadastro) {
		this.dataCadastro = dataCadastro;
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

	public String getObservacao() {
		return observacao;
	}

	public void setObservacao(String observacao) {
		this.observacao = observacao;
	}

	public String getTipoCobranca() {
		return tipoCobranca;
	}

	public void setTipoCobranca(String tipoCobranca) {
		this.tipoCobranca = tipoCobranca;
	}

	public Funcionario getVendedor() {
		return vendedor;
	}

	public void setVendedor(Funcionario vendedor) {
		this.vendedor = vendedor;
	}

	public Float getComissaoVendedor() {
		return comissaoVendedor;
	}

	public void setComissaoVendedor(Float comissaoVendedor) {
		this.comissaoVendedor = comissaoVendedor;
	}

	public Funcionario getRepresentante() {
		return representante;
	}

	public void setRepresentante(Funcionario representante) {
		this.representante = representante;
	}

	public Float getComissaoRepresentante() {
		return comissaoRepresentante;
	}

	public void setComissaoRepresentante(Float comissaoRepresentante) {
		this.comissaoRepresentante = comissaoRepresentante;
	}

	public Boolean getRestricaoOrdemColeta() {
		return restricaoOrdemColeta;
	}

	public void setRestricaoOrdemColeta(Boolean restricaoOrdemColeta) {
		this.restricaoOrdemColeta = restricaoOrdemColeta;
	}

	public Boolean getRestricaoConhecimento() {
		return restricaoConhecimento;
	}

	public void setRestricaoConhecimento(Boolean restricaoConhecimento) {
		this.restricaoConhecimento = restricaoConhecimento;
	}

	public Boolean getRestricaoFatura() {
		return restricaoFatura;
	}

	public void setRestricaoFatura(Boolean restricaoFatura) {
		this.restricaoFatura = restricaoFatura;
	}

	public Boolean getRestricaoComissao() {
		return restricaoComissao;
	}

	public void setRestricaoComissao(Boolean restricaoComissao) {
		this.restricaoComissao = restricaoComissao;
	}
}
