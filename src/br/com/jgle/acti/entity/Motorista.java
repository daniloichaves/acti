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
public class Motorista extends AbstractEntity {

	@Column(length = 50)
	protected String nome;
	@Column(length = 50)
	protected String sobrenome;
	@Column(length = 50)
	protected String apelido;

	// Documento
	@Column(length = 15)
	protected String cpf;
	@Column(length = 15)
	protected String rg;
	@Column(length = 5)
	protected String orgaoExpeditor;
	protected Date dataExpedicao;
	protected Date dataEmissao;

	@Temporal(TemporalType.DATE)
	protected Date dataNascimento;
	@Column(length = 20)
	protected String vinculo;

	protected Double comissaoPorc;
	protected Double comissaoFixo;
	@Column(length = 20)
	protected String ce;

	// Habilitacao Motorista
	@Column(length = 20)
	protected String cnhRegistro;
	@Column(length = 20)
	protected String cnh;
	@Column(length = 3)
	protected String categoria;
	protected Date cnhDataValidate;
	@Column(length = 2)
	protected String cnhUf;
	@Column(length = 15)
	protected String prontuario;

	// Dados Complementares
	@Column(length = 20)
	protected String natualDe;
	@Column(length = 25)
	protected String nomePai;
	@Column(length = 25)
	protected String nomeMae;
	@Column(length = 25)
	protected String esposaConjuge;
	@Column(length = 20)
	protected String numeroINSS;
	@Column(length = 200)
	protected String observacao;
	protected Integer qtdAcidente;
	protected Integer qtdTransporteRealizado;
	protected Integer qtdRoubo;

	@OneToMany(cascade = CascadeType.ALL, fetch = FetchType.EAGER)
	protected Set<Telefone> telefones = new HashSet<Telefone>();
	@OneToMany(cascade = CascadeType.ALL, fetch = FetchType.EAGER)
	protected Set<Email> emails = new HashSet<Email>();
	@OneToMany(cascade = CascadeType.ALL, fetch = FetchType.EAGER)
	protected Set<ContaBanco> contaBancos = new HashSet<ContaBanco>();
	@OneToMany(cascade = CascadeType.ALL, fetch = FetchType.EAGER)
	protected Set<Endereco> enderecos = new HashSet<Endereco>();
	@OneToMany(cascade = CascadeType.ALL, fetch = FetchType.EAGER)
	protected Set<MotoristaReferencia> motoristaReferencias = new HashSet<MotoristaReferencia>();

	// Integrações
	// BrasilRisk
	@Column(length = 20)
	private String brasilRiskStatus = "Não Cadastrado";
	@Temporal(TemporalType.TIMESTAMP)
	protected Date brasilRiskDataSync = new Date();

	@SuppressWarnings("unchecked")
	public Motorista newInstance() {
		return new Motorista();
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
		} else if (name instanceof MotoristaReferencia) {
			return getMotoristaReferencias();
		}

		throw new NullPointerException();
	}

	@Override
	public Map<String, ?> getParametrosSimpleSearch(String textSearch) {
		@SuppressWarnings("unchecked")
		Map<String, Object> params = (Map<String, Object>) super
				.getParametrosSimpleSearch(textSearch);

		params.put("nome", textToSearch(textSearch));
		params.put("sobrenome", textToSearch(textSearch));
		params.put("apelido", textToSearch(textSearch));
		params.put("cpf", textToSearch(textSearch));
		params.put("rg", textToSearch(textSearch));
		params.put("cnhRegistro", textToSearch(textSearch));
		params.put("cnh", textToSearch(textSearch));
		params.put("cnhDataValidate", textToSearch(textSearch));
		params.put("observacao", textToSearch(textSearch));

		return params;
	}

	public Map<String, String> getParametrosAdvancedSearch() {
		Map<String, String> params = (Map<String, String>) super
				.getParametrosAdvancedSearch();

		params.put("nome", "Nome");
		params.put("sobrenome", "Sobrenome");
		params.put("apelido", "Apelido");
		params.put("cpf", "CPF");
		params.put("cidade", "Cidade");
		params.put("rg", "RG");
		params.put("cnhRegistro", "CNH Registro");
		params.put("cnh", "CNH");
		params.put("cnhDataValidate", "CNH Data Validade");
		params.put("observacao", "Observação");

		return params;
	}

	@Transient
	public Telefone getPrimeiroCelular() {
		if (getTelefones() != null && !getTelefones().isEmpty()) {
			for (Telefone telefone : telefones) {
				if (telefone.getTipo().equals(Telefone.TIPO_CELULAR)) {
					return telefone;
				}
			}
		}
		return null;
	}

	@Transient
	public Telefone getPrimeiroComercial() {
		if (getTelefones() != null && !getTelefones().isEmpty()) {
			for (Telefone telefone : telefones) {
				if (telefone.getTipo().equals(Telefone.TIPO_COMERCIAL)) {
					return telefone;
				}
			}
		}
		return null;
	}

	@Transient
	public String getPerfilBrasilRisk() {
		if ("FROTA".equals(getVinculo())) {
			return "FR";
		} else if ("AUTONOMO".equals(getVinculo())) {
			return "AG";
		} else if ("AGREGADO".equals(getVinculo())) {
			return "AU";
		}

		return null;
	}

	/** Get's and Set's **/
	public String getNome() {
		return nome;
	}

	public void setNome(String nome) {
		this.nome = nome;
	}

	public String getSobrenome() {
		return sobrenome;
	}

	public void setSobrenome(String sobrenome) {
		this.sobrenome = sobrenome;
	}

	public String getApelido() {
		return apelido;
	}

	public void setApelido(String apelido) {
		this.apelido = apelido;
	}

	public String getCpf() {
		return cpf;
	}

	public void setCpf(String cpf) {
		this.cpf = cpf;
	}

	public String getRg() {
		return rg;
	}

	public void setRg(String rg) {
		this.rg = rg;
	}

	public String getOrgaoExpeditor() {
		return orgaoExpeditor;
	}

	public void setOrgaoExpeditor(String orgaoExpeditor) {
		this.orgaoExpeditor = orgaoExpeditor;
	}

	public Date getDataExpedicao() {
		return dataExpedicao;
	}

	public void setDataExpedicao(Date dataExpedicao) {
		this.dataExpedicao = dataExpedicao;
	}

	public Date getDataEmissao() {
		return dataEmissao;
	}

	public void setDataEmissao(Date dataEmissao) {
		this.dataEmissao = dataEmissao;
	}

	public Date getDataNascimento() {
		return dataNascimento;
	}

	public void setDataNascimento(Date dataNascimento) {
		this.dataNascimento = dataNascimento;
	}

	public String getVinculo() {
		return vinculo;
	}

	public void setVinculo(String vinculo) {
		this.vinculo = vinculo;
	}

	public Double getComissaoPorc() {
		return comissaoPorc;
	}

	public void setComissaoPorc(Double comissaoPorc) {
		this.comissaoPorc = comissaoPorc;
	}

	public Double getComissaoFixo() {
		return comissaoFixo;
	}

	public void setComissaoFixo(Double comissaoFixo) {
		this.comissaoFixo = comissaoFixo;
	}

	public String getCe() {
		return ce;
	}

	public void setCe(String ce) {
		this.ce = ce;
	}

	public String getCnhRegistro() {
		return cnhRegistro;
	}

	public void setCnhRegistro(String cnhRegistro) {
		this.cnhRegistro = cnhRegistro;
	}

	public String getCnh() {
		return cnh;
	}

	public void setCnh(String cnh) {
		this.cnh = cnh;
	}

	public String getCategoria() {
		return categoria;
	}

	public void setCategoria(String categoria) {
		this.categoria = categoria;
	}

	public String getCnhUf() {
		return cnhUf;
	}

	public void setCnhUf(String cnhUf) {
		this.cnhUf = cnhUf;
	}

	public String getProntuario() {
		return prontuario;
	}

	public void setProntuario(String prontuario) {
		this.prontuario = prontuario;
	}

	public String getNatualDe() {
		return natualDe;
	}

	public void setNatualDe(String natualDe) {
		this.natualDe = natualDe;
	}

	public String getNomePai() {
		return nomePai;
	}

	public void setNomePai(String nomePai) {
		this.nomePai = nomePai;
	}

	public String getNomeMae() {
		return nomeMae;
	}

	public void setNomeMae(String nomeMae) {
		this.nomeMae = nomeMae;
	}

	public String getEsposaConjuge() {
		return esposaConjuge;
	}

	public void setEsposaConjuge(String esposaConjuge) {
		this.esposaConjuge = esposaConjuge;
	}

	public String getNumeroINSS() {
		return numeroINSS;
	}

	public void setNumeroINSS(String numeroINSS) {
		this.numeroINSS = numeroINSS;
	}

	public String getObservacao() {
		return observacao;
	}

	public void setObservacao(String observacao) {
		this.observacao = observacao;
	}

	public Integer getQtdAcidente() {
		return qtdAcidente;
	}

	public void setQtdAcidente(Integer qtdAcidente) {
		this.qtdAcidente = qtdAcidente;
	}

	public Integer getQtdTransporteRealizado() {
		return qtdTransporteRealizado;
	}

	public void setQtdTransporteRealizado(Integer qtdTransporteRealizado) {
		this.qtdTransporteRealizado = qtdTransporteRealizado;
	}

	public Integer getQtdRoubo() {
		return qtdRoubo;
	}

	public void setQtdRoubo(Integer qtdRoubo) {
		this.qtdRoubo = qtdRoubo;
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

	public Date getCnhDataValidate() {
		return cnhDataValidate;
	}

	public void setCnhDataValidate(Date cnhDataValidate) {
		this.cnhDataValidate = cnhDataValidate;
	}

	public Set<Endereco> getEnderecos() {
		return enderecos;
	}

	public void setEnderecos(Set<Endereco> enderecos) {
		this.enderecos = enderecos;
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

	public Set<MotoristaReferencia> getMotoristaReferencias() {
		return motoristaReferencias;
	}

	public void setMotoristaReferencias(
			Set<MotoristaReferencia> motoristaReferencias) {
		this.motoristaReferencias = motoristaReferencias;
	}
}
