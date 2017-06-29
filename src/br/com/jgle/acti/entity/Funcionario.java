package br.com.jgle.acti.entity;

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
import javax.persistence.ManyToOne;
import javax.persistence.OneToMany;
import javax.persistence.OneToOne;
import javax.persistence.Temporal;
import javax.persistence.TemporalType;

@SuppressWarnings("serial")
@Entity
public class Funcionario extends AbstractEntity {

	@Column(length = 20)
	protected String cargo;
	@Column(length = 20)
	protected String tipo;
	@Column(length = 50)
	protected String nome;
	@Column(length = 50)
	protected String sobrenome;
	@Column(length = 10)
	protected String sexo;
	@Column(length = 15)
	protected String cpf;
	@Column(length = 15)
	protected String rg;
	protected Date dataExpedicao;
	@Column(length = 10)
	protected String expedicao;
	// protected String tituloEleitor;
	protected Integer tituloEleitorNum;
	@Column(length = 15)
	protected String carteiraTrabalhoNumero;
	@Column(length = 15)
	protected String carteiraTrabalhoSerie;
	@Column(length = 15)
	protected String numeroINSS;
	protected Double valorINSS = new Double(0);
	@Column(length = 50)
	protected String nomeConjuge;
	protected Integer qtdFilhos = 0;
	@Column(length = 25)
	protected String numeroPIS;
	protected Date dataRetracaoPIS;
	@Column(length = 25)
	protected String bancoDeposito;

	// Dados RH
	protected Date dataAdmissao;
	protected Date registro;
	@Column(length = 30)
	protected String cargoRegistro;
	protected BigDecimal salario = BigDecimal.ZERO;
	@Column(length = 35)
	protected String secao;
	@Column(length = 35)
	protected String formaPagamento;
	protected Date dataDemissao;
	protected Float cargaHoraria;

	protected Date horaEntrada;
	protected Date horaSaida;

	// Beneficiario
	@Column(length = 50)
	protected String dependenteNome;
	@Column(length = 50)
	protected String dependenteParentesco;
	@Temporal(TemporalType.DATE)
	protected Date dependenteNascimento;

	@OneToMany(cascade = CascadeType.ALL, fetch = FetchType.EAGER)
	protected Set<Telefone> telefones = new HashSet<Telefone>();
	@OneToMany(cascade = CascadeType.ALL, fetch = FetchType.EAGER)
	protected Set<Email> emails = new HashSet<Email>();
	@OneToMany(cascade = CascadeType.ALL, fetch = FetchType.EAGER)
	protected Set<ContaBanco> contaBancos = new HashSet<ContaBanco>();
	@OneToMany(cascade = CascadeType.ALL, fetch = FetchType.EAGER)
	protected Set<Endereco> enderecos = new HashSet<Endereco>();

	@OneToOne
	protected Login login;

	@ManyToOne(fetch = FetchType.EAGER)
	protected Unidade unidade;

	@SuppressWarnings("unchecked")
	public Funcionario newInstance() {
		return new Funcionario();
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

	@Override
	public Map<String, ?> getParametrosSimpleSearch(String textSearch) {
		@SuppressWarnings("unchecked")
		Map<String, Object> params = (Map<String, Object>) super
				.getParametrosSimpleSearch(textSearch);

		params.put("cargo", textToSearch(textSearch));
		params.put("nome", textToSearch(textSearch));
		params.put("sobrenome", textToSearch(textSearch));
		params.put("cpf", textToSearch(textSearch));
		params.put("rg", textToSearch(textSearch));
		params.put("cargoRegistro", textToSearch(textSearch));
		params.put("secao", textToSearch(textSearch));

		return params;
	}

	public Map<String, String> getParametrosAdvancedSearch() {
		Map<String, String> params = (Map<String, String>) super
				.getParametrosAdvancedSearch();

		params.put("cargo", "Cargo");
		params.put("nome", "Nome");
		params.put("sobrenome", "Sobrenome");
		params.put("cpf", "CPF");
		params.put("rg", "RG");
		params.put("cargoRegistro", "Cargo");
		params.put("secao", "Seção");

		return params;

	}

	/** Get's and Set's **/
	public String getCargo() {
		return cargo;
	}

	public void setCargo(String cargo) {
		this.cargo = cargo;
	}

	public String getTipo() {
		return tipo;
	}

	public void setTipo(String tipo) {
		this.tipo = tipo;
	}

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

	public String getSexo() {
		return sexo;
	}

	public void setSexo(String sexo) {
		this.sexo = sexo;
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

	public Date getDataExpedicao() {
		return dataExpedicao;
	}

	public void setDataExpedicao(Date dataExpedicao) {
		this.dataExpedicao = dataExpedicao;
	}

	public String getExpedicao() {
		return expedicao;
	}

	public void setExpedicao(String expedicao) {
		this.expedicao = expedicao;
	}

	// public String getTituloEleitor() {
	// return tituloEleitor;
	// }
	//
	// public void setTituloEleitor(String tituloEleitor) {
	// this.tituloEleitor = tituloEleitor;
	// }

	public String getCarteiraTrabalhoNumero() {
		return carteiraTrabalhoNumero;
	}

	public Integer getTituloEleitorNum() {
		return tituloEleitorNum;
	}

	public void setTituloEleitorNum(Integer tituloEleitorNum) {
		this.tituloEleitorNum = tituloEleitorNum;
	}

	public void setCarteiraTrabalhoNumero(String carteiraTrabalhoNumero) {
		this.carteiraTrabalhoNumero = carteiraTrabalhoNumero;
	}

	public String getCarteiraTrabalhoSerie() {
		return carteiraTrabalhoSerie;
	}

	public void setCarteiraTrabalhoSerie(String carteiraTrabalhoSerie) {
		this.carteiraTrabalhoSerie = carteiraTrabalhoSerie;
	}

	public String getNumeroINSS() {
		return numeroINSS;
	}

	public void setNumeroINSS(String numeroINSS) {
		this.numeroINSS = numeroINSS;
	}

	public Double getValorINSS() {
		return valorINSS;
	}

	public void setValorINSS(Double valorINSS) {
		this.valorINSS = valorINSS;
	}

	public String getNomeConjuge() {
		return nomeConjuge;
	}

	public void setNomeConjuge(String nomeConjuge) {
		this.nomeConjuge = nomeConjuge;
	}

	public Integer getQtdFilhos() {
		return qtdFilhos;
	}

	public void setQtdFilhos(Integer qtdFilhos) {
		this.qtdFilhos = qtdFilhos;
	}

	public String getNumeroPIS() {
		return numeroPIS;
	}

	public void setNumeroPIS(String numeroPIS) {
		this.numeroPIS = numeroPIS;
	}

	public Date getDataRetracaoPIS() {
		return dataRetracaoPIS;
	}

	public void setDataRetracaoPIS(Date dataRetracaoPIS) {
		this.dataRetracaoPIS = dataRetracaoPIS;
	}

	public String getBancoDeposito() {
		return bancoDeposito;
	}

	public void setBancoDeposito(String bancoDeposito) {
		this.bancoDeposito = bancoDeposito;
	}

	public Date getDataAdmissao() {
		return dataAdmissao;
	}

	public void setDataAdmissao(Date dataAdmissao) {
		this.dataAdmissao = dataAdmissao;
	}

	public Date getRegistro() {
		return registro;
	}

	public void setRegistro(Date registro) {
		this.registro = registro;
	}

	public String getCargoRegistro() {
		return cargoRegistro;
	}

	public void setCargoRegistro(String cargoRegistro) {
		this.cargoRegistro = cargoRegistro;
	}

	public BigDecimal getSalario() {
		return salario;
	}

	public void setSalario(BigDecimal salario) {
		this.salario = salario;
	}

	public String getSecao() {
		return secao;
	}

	public void setSecao(String secao) {
		this.secao = secao;
	}

	public String getFormaPagamento() {
		return formaPagamento;
	}

	public void setFormaPagamento(String formaPagamento) {
		this.formaPagamento = formaPagamento;
	}

	public Date getDataDemissao() {
		return dataDemissao;
	}

	public void setDataDemissao(Date dataDemissao) {
		this.dataDemissao = dataDemissao;
	}

	public Float getCargaHoraria() {
		return cargaHoraria;
	}

	public void setCargaHoraria(Float cargaHoraria) {
		this.cargaHoraria = cargaHoraria;
	}

	public Date getHoraEntrada() {
		return horaEntrada;
	}

	public void setHoraEntrada(Date horaEntrada) {
		this.horaEntrada = horaEntrada;
	}

	public Date getHoraSaida() {
		return horaSaida;
	}

	public void setHoraSaida(Date horaSaida) {
		this.horaSaida = horaSaida;
	}

	public String getDependenteNome() {
		return dependenteNome;
	}

	public void setDependenteNome(String dependenteNome) {
		this.dependenteNome = dependenteNome;
	}

	public String getDependenteParentesco() {
		return dependenteParentesco;
	}

	public void setDependenteParentesco(String dependenteParentesco) {
		this.dependenteParentesco = dependenteParentesco;
	}

	public Date getDependenteNascimento() {
		return dependenteNascimento;
	}

	public void setDependenteNascimento(Date dependenteNascimento) {
		this.dependenteNascimento = dependenteNascimento;
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

	public Login getLogin() {
		return login;
	}

	public void setLogin(Login login) {
		this.login = login;
	}

	public Unidade getUnidade() {
		return unidade;
	}

	public void setUnidade(Unidade unidade) {
		this.unidade = unidade;
	}

}
