package br.com.jgle.acti.util;

import java.math.BigDecimal;
import java.util.Date;

import br.com.jgle.acti.entity.Banco;
import br.com.jgle.acti.entity.ClienteFornecedor;
import br.com.jgle.acti.entity.ContaBanco;
import br.com.jgle.acti.entity.Unidade;
import br.com.jgle.acti.exception.ServiceException;
import br.com.nordestefomento.jrimum.bopepo.BancoSuportado;
import br.com.nordestefomento.jrimum.bopepo.Boleto;
import br.com.nordestefomento.jrimum.domkee.comum.pessoa.endereco.CEP;
import br.com.nordestefomento.jrimum.domkee.comum.pessoa.endereco.Endereco;
import br.com.nordestefomento.jrimum.domkee.comum.pessoa.endereco.UnidadeFederativa;
import br.com.nordestefomento.jrimum.domkee.financeiro.banco.febraban.Agencia;
import br.com.nordestefomento.jrimum.domkee.financeiro.banco.febraban.Carteira;
import br.com.nordestefomento.jrimum.domkee.financeiro.banco.febraban.Cedente;
import br.com.nordestefomento.jrimum.domkee.financeiro.banco.febraban.ContaBancaria;
import br.com.nordestefomento.jrimum.domkee.financeiro.banco.febraban.NumeroDaConta;
import br.com.nordestefomento.jrimum.domkee.financeiro.banco.febraban.Sacado;
import br.com.nordestefomento.jrimum.domkee.financeiro.banco.febraban.TipoDeTitulo;
import br.com.nordestefomento.jrimum.domkee.financeiro.banco.febraban.Titulo;
import br.com.nordestefomento.jrimum.domkee.financeiro.banco.febraban.Titulo.EnumAceite;
/**
 * 	http://www.jrimum.org/bopepo/wiki/Componente/BancosSuportados
	http://www.jrimum.org/jrimum/wiki/Projeto/Download
	http://www.guj.com.br/java/240306-melhores-solucoes-para-geracao-de-boleto
	http://lifehacker.com/5799960/this-is-lifehacker-episode-8-tangle+free-headphones-ssd-upgrade-and-skipping-floors-on-elevators

 * @author Danilo Ischiavolini Chaves
 *
 */
public class BoletoUtil {

	public static Boleto criarBoleto(Unidade unidade, ClienteFornecedor clienteFornecedor, String numeroDocumento, String nossoNumero, String digitoNossoNuemro, BigDecimal valor, Date dataDocumento,
			Date dataVencimento, BigDecimal desconto) throws ServiceException {

		// Checagem dos dados
		if (unidade == null)
			throw new ServiceException("Usuário sem unidade cadastrada.");
		if (clienteFornecedor == null)
			throw new ServiceException("Cliente/ Fornecedor não cadastrado.");
		ContaBanco contaBanco = unidade.getContaBanco();
		Banco banco = contaBanco.getBanco();
		if (!BancoSuportado.isSuportado(banco.getNumero().toString()))
			throw new ServiceException("Banco não suportado.");

		// Cedente quem vai receber o valor
		Cedente cedente = new Cedente(unidade.getRazaoSocial(), unidade.getCnpj());
		// Sacado quem vai pagar o valor
		Sacado sacado = new Sacado(clienteFornecedor.getRazaosocialnome(), clienteFornecedor.getCnpjcpf());

		// Informando o endereço do sacado.
		br.com.jgle.acti.entity.Endereco enderecoCobranca = clienteFornecedor.getEnderecoCobranca();
		if (enderecoCobranca != null) {
			Endereco enderecoSac = new Endereco();
			if ("SP".equalsIgnoreCase(enderecoCobranca.getUf()))
				enderecoSac.setUF(UnidadeFederativa.SP);
			else
				for (UnidadeFederativa uf : UnidadeFederativa.values()) {
					if (uf.getSigla().equalsIgnoreCase(enderecoCobranca.getUf())) {
						enderecoSac.setUF(uf);
						break;
					}
				}
			enderecoSac.setLocalidade(enderecoCobranca.getCidade());
			enderecoSac.setCep(new CEP(enderecoCobranca.getCepFormat()));
			enderecoSac.setBairro(enderecoCobranca.getBairro());
			enderecoSac.setLogradouro(enderecoCobranca.getEndereco());
			enderecoSac.setNumero(enderecoCobranca.getNumero());
			sacado.addEndereco(enderecoSac);
		}

		// Informações bancarias
		ContaBancaria contaBancaria = null;
		for (BancoSuportado bancoSuportado : BancoSuportado.values()) {
			if (banco.getNumero().compareTo(new Integer(bancoSuportado.getCodigoDeCompensacao())) == 0) {
				contaBancaria = new ContaBancaria(bancoSuportado.create());
				contaBancaria.setAgencia(new Agencia(contaBanco.getAgencia(), contaBanco.getAgenciaDigito()));
				contaBancaria.setNumeroDaConta(new NumeroDaConta(contaBanco.getConta(), contaBanco.getContaDigito()));
				contaBancaria.setCarteira(new Carteira(30));
			}
		}

		Titulo titulo = new Titulo(contaBancaria, sacado, cedente);
		titulo.setNumeroDoDocumento(numeroDocumento);
		titulo.setNossoNumero(nossoNumero);
		titulo.setDigitoDoNossoNumero(digitoNossoNuemro);
		titulo.setValor(valor);
		titulo.setDataDoDocumento(dataDocumento);
		if(dataVencimento == null)
			dataVencimento = dataDocumento;
		titulo.setDataDoVencimento(dataVencimento);
		titulo.setTipoDeDocumento(TipoDeTitulo.DM_DUPLICATA_MERCANTIL);
		titulo.setAceite(EnumAceite.A);
		titulo.setDesconto(desconto);

		// Boleto boleto = Exemplos.crieBoleto(titulo);
		Boleto boleto = new Boleto(titulo);

		// Informando o template personalizado:
		return boleto;
	}

	public static void main(String[] args) {
		Cedente cedente = new Cedente("PROJETO JRimum", "00.000.208/0001-00");
		Sacado sacado = new Sacado("JavaDeveloper Pronto Para Férias", "222.222.222-22");

		// Informando o endereço do sacado.
		br.com.nordestefomento.jrimum.domkee.comum.pessoa.endereco.Endereco enderecoSac = new br.com.nordestefomento.jrimum.domkee.comum.pessoa.endereco.Endereco();
		enderecoSac.setUF(UnidadeFederativa.RN);
		enderecoSac.setLocalidade("Natal");
		enderecoSac.setCep(new CEP("59064-120"));
		enderecoSac.setBairro("Grande Centro");
		enderecoSac.setLogradouro("Rua poeta dos programas");
		enderecoSac.setNumero("1");
		sacado.addEndereco(enderecoSac);

		ContaBancaria contaBancaria = new ContaBancaria(BancoSuportado.BANCO_BRADESCO.create());
		contaBancaria.setNumeroDaConta(new NumeroDaConta(123456, "0"));
		contaBancaria.setCarteira(new Carteira(30));
		contaBancaria.setAgencia(new Agencia(1234, "1"));

		Titulo titulo = new Titulo(contaBancaria, sacado, cedente);
		titulo.setNumeroDoDocumento("123456");
		titulo.setNossoNumero("99345678912");
		titulo.setDigitoDoNossoNumero("5");
		titulo.setValor(BigDecimal.valueOf(0.23));
		titulo.setDataDoDocumento(new Date());
		titulo.setDataDoVencimento(new Date());
		titulo.setTipoDeDocumento(TipoDeTitulo.DM_DUPLICATA_MERCANTIL);
		titulo.setAceite(EnumAceite.A);
		titulo.setDesconto(new BigDecimal(0.05));

		// Boleto boleto = Exemplos.crieBoleto(titulo);
		Boleto boleto = new Boleto(titulo);
		System.out.println(boleto);
	}

}
