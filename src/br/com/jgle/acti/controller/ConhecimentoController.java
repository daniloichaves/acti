package br.com.jgle.acti.controller;

import java.io.File;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.math.BigDecimal;
import java.util.List;

import javax.annotation.Resource;

import org.springframework.context.annotation.Scope;
import org.springframework.stereotype.Controller;
import org.zkoss.zhtml.Filedownload;
import org.zkoss.zk.ui.Component;
import org.zkoss.zk.ui.event.Event;
import org.zkoss.zul.Button;
import org.zkoss.zul.Combobox;
import org.zkoss.zul.Comboitem;
import org.zkoss.zul.Doublebox;
import org.zkoss.zul.Grid;
import org.zkoss.zul.Image;
import org.zkoss.zul.Messagebox;
import org.zkoss.zul.Radio;
import org.zkoss.zul.Textbox;

import br.com.jgle.acti.entity.Cliente;
import br.com.jgle.acti.entity.ColetaEndereco;
import br.com.jgle.acti.entity.Conhecimento;
import br.com.jgle.acti.entity.ConhecimentoCTe;
import br.com.jgle.acti.entity.ConhecimentoCalculoFreteUm;
import br.com.jgle.acti.entity.Cpof;
import br.com.jgle.acti.entity.Endereco;
import br.com.jgle.acti.entity.Login;
import br.com.jgle.acti.entity.Motorista;
import br.com.jgle.acti.entity.Veiculo;
import br.com.jgle.acti.exception.ServiceException;
import br.com.jgle.acti.service.AverbacaoService;
import br.com.jgle.acti.service.BrasilRiskService;
import br.com.jgle.acti.util.BoletoUtil;
import br.com.jgle.acti.util.MathUtil;
import br.com.jgle.acti.webservice.CepService;
import br.com.jgle.acti.webservice.Webservicecep;
import br.com.nordestefomento.jrimum.bopepo.Boleto;
import br.com.nordestefomento.jrimum.bopepo.view.BoletoViewer;

@Scope("page")
@Controller
public class ConhecimentoController extends AbstractController<Conhecimento> {

	private static final long serialVersionUID = 1L;

	@Resource
	protected BrasilRiskService brasilRiskService;

	@Resource
	protected AverbacaoService averbacaoService;

	// Integração
	protected Component entitySync; // sync button

	public ConhecimentoController() {
		super(new Conhecimento());

		notaFiscalController = new NotaFiscalController(this);
		servicoController = new ServicoController(this);
		// conhecimentoCalculoFreteUmController = new
		// ConhecimentoCalculoFreteUmController(this);
	}

	protected Combobox remetenteBox;
	protected Combobox destinatarioBox;
	protected Combobox consignatarioBox;
	protected Combobox redespachoBox;
	protected NotaFiscalController notaFiscalController;
	protected ServicoController servicoController;
	// protected ConhecimentoCalculoFreteUmController
	// conhecimentoCalculoFreteUmController;

	protected Textbox remetenteCepBox;
	protected Image remetenteCepSearch;
	protected Textbox remetenteEnderecoBox;
	protected Textbox remetenteBairroBox;
	protected Textbox remetenteCidadeBox;
	protected Combobox remetenteUfBox;

	protected Textbox destinatarioCepBox;
	protected Image destinatarioCepSearch;
	protected Textbox destinatarioEnderecoBox;
	protected Textbox destinatarioBairroBox;
	protected Textbox destinatarioCidadeBox;
	protected Combobox destinatarioUfBox;

	protected Textbox consignatarioCepBox;
	protected Image consignatarioCepSearch;
	protected Textbox consignatarioEnderecoBox;
	protected Textbox consignatarioBairroBox;
	protected Textbox consignatarioCidadeBox;
	protected Combobox consignatarioUfBox;

	protected Textbox redespachoCepBox;
	protected Image redespachoCepSearch;
	protected Textbox redespachoEnderecoBox;
	protected Textbox redespachoBairroBox;
	protected Textbox redespachoCidadeBox;
	protected Combobox redespachoUfBox;
	
	@Override
	public void onClick$entityDeleteQuick(Event event) {
		try {
			// TODO verificar se esta funcionando
			if (selected.getManifesto() != null) {
				Messagebox.show("Conhecimento não pode ser deletado. Verificar o Manifesto Nº " + selected.getManifesto().getNumeroManifesto());
				return;
			}
			super.onClick$entityDeleteQuick(event);
		} catch (Exception e) {
			e.printStackTrace();
		}
	}

	public void onClick$entitySync(Event event) throws InterruptedException {
		try {
			brasilRiskService.solicitacaoMonitoramento(selected);
		} catch (Exception e) {
			e.printStackTrace();
			Messagebox.show(e.getMessage());
		}
	}

	// Averbação
	protected Button averbacaoBtn;

	@SuppressWarnings("unused")
	public void onClick$averbacaoBtn() throws InterruptedException, FileNotFoundException {

		try {
			// java.io.InputStream is =
			// desktop.getWebApp().getResourceAsStream("/test/download.html");
			// java.io.InputStream is =
			// desktop.getWebApp().getResourceAsStream(PropertiesUtil.getPropertyValue("pach.name.file.averbacao"));

			File file = averbacaoService.criarArquivoAverbacao(selected);
			java.io.InputStream is = new FileInputStream(file);

			if (is != null)
				Filedownload.save(is, "text/html", "averbacao.txt");
			else
				alert("Não foi possivel acessar o arquivo criado.");
		} catch (ServiceException e) {
			e.printStackTrace();
			Messagebox.show(e.getMessage());
		}

	}

	public void onChange$remetenteCepBox() {
		try {
			if (remetenteCepBox.getValue().length() == 8) {
				System.out.println(remetenteCepBox.getValue());

				Webservicecep endereco = CepService.getEndereco(remetenteCepBox.getValue());
				if (endereco.enderecoValido()) {
					remetenteEnderecoBox.setValue(endereco.getTipo_logradouro() + " " + endereco.getLogradouro() + ", ");
					remetenteBairroBox.setValue(endereco.getBairro());
					remetenteCidadeBox.setValue(endereco.getCidade());
					// remetenteUfBox.setValue(endereco.getUf());

					selected.getRemetente().setEndereco(endereco.getTipo_logradouro() + " " + endereco.getLogradouro() + ", ");
					selected.getRemetente().setBairro(endereco.getBairro());
					selected.getRemetente().setCidade(endereco.getCidade());
					selected.getRemetente().setUf(endereco.getUf());
				} else {
					Messagebox.show("CEP inválido.");
				}

				System.out.println(endereco);
			} else {
				Messagebox.show("Digite um CEP válido.");
			}
		} catch (Exception e) {
			try {
				Messagebox.show(e.getMessage());
			} catch (Exception e1) {
				e1.printStackTrace();
			}
			e.printStackTrace();
		}
	}

	public void onChange$destinatarioCepBox() {
		try {
			if (destinatarioCepBox.getValue().length() == 8) {
				System.out.println(destinatarioCepBox.getValue());

				Webservicecep endereco = CepService.getEndereco(destinatarioCepBox.getValue());
				if (endereco.enderecoValido()) {
					destinatarioEnderecoBox.setValue(endereco.getTipo_logradouro() + " " + endereco.getLogradouro() + ", ");
					destinatarioBairroBox.setValue(endereco.getBairro());
					destinatarioCidadeBox.setValue(endereco.getCidade());
					// destinatarioUfBox.setValue(endereco.getUf());

					selected.getDestinatario().setEndereco(endereco.getTipo_logradouro() + " " + endereco.getLogradouro() + ", ");
					selected.getDestinatario().setBairro(endereco.getBairro());
					selected.getDestinatario().setCidade(endereco.getCidade());
					selected.getDestinatario().setUf(endereco.getUf());
				} else {
					Messagebox.show("CEP inválido.");
				}

				System.out.println(endereco);
			} else {
				Messagebox.show("Digite um CEP válido.");
			}
		} catch (Exception e) {
			try {
				Messagebox.show(e.getMessage());
			} catch (Exception e1) {
				e1.printStackTrace();
			}
			e.printStackTrace();
		}
	}

	public void onChange$consignatarioCepBox() {
		try {
			if (consignatarioCepBox.getValue().length() == 8) {
				System.out.println(consignatarioCepBox.getValue());

				Webservicecep endereco = CepService.getEndereco(consignatarioCepBox.getValue());
				if (endereco.enderecoValido()) {
					consignatarioEnderecoBox.setValue(endereco.getTipo_logradouro() + " " + endereco.getLogradouro() + ", ");
					consignatarioBairroBox.setValue(endereco.getBairro());
					consignatarioCidadeBox.setValue(endereco.getCidade());
					// consignatarioUfBox.setValue(endereco.getUf());

					selected.getConsignatarioEndereco().setEndereco(endereco.getTipo_logradouro() + " " + endereco.getLogradouro() + ", ");
					selected.getConsignatarioEndereco().setBairro(endereco.getBairro());
					selected.getConsignatarioEndereco().setCidade(endereco.getCidade());
					selected.getConsignatarioEndereco().setUf(endereco.getUf());
				} else {
					Messagebox.show("CEP inválido.");
				}

				System.out.println(endereco);
			} else {
				Messagebox.show("Digite um CEP válido.");
			}
		} catch (Exception e) {
			try {
				Messagebox.show(e.getMessage());
			} catch (Exception e1) {
				e1.printStackTrace();
			}
			e.printStackTrace();
		}
	}

	public void onChange$redespachoCepBox() {
		try {
			if (redespachoCepBox.getValue().length() == 8) {
				System.out.println(redespachoCepBox.getValue());

				Webservicecep endereco = CepService.getEndereco(redespachoCepBox.getValue());
				if (endereco.enderecoValido()) {
					redespachoEnderecoBox.setValue(endereco.getTipo_logradouro() + " " + endereco.getLogradouro() + ", ");
					redespachoBairroBox.setValue(endereco.getBairro());
					redespachoCidadeBox.setValue(endereco.getCidade());
					// redespachoUfBox.setValue(endereco.getUf());

					selected.getRedespachoEndereco().setEndereco(endereco.getTipo_logradouro() + " " + endereco.getLogradouro() + ", ");
					selected.getRedespachoEndereco().setBairro(endereco.getBairro());
					selected.getRedespachoEndereco().setCidade(endereco.getCidade());
					selected.getRedespachoEndereco().setUf(endereco.getUf());
				} else {
					Messagebox.show("CEP inválido.");
				}

				System.out.println(endereco);
			} else {
				Messagebox.show("Digite um CEP válido.");
			}
		} catch (Exception e) {
			try {
				Messagebox.show(e.getMessage());
			} catch (Exception e1) {
				e1.printStackTrace();
			}
			e.printStackTrace();
		}
	}

	public void onClick$remetenteCepSearch() {
		onChange$remetenteCepBox();
	}

	public void onClick$destinatarioCepSearch() {
		onChange$destinatarioCepBox();
	}

	public void onClick$consignatarioCepSearch() {
		onChange$consignatarioCepBox();
	}

	public void onClick$redespachoCepSearch() {
		onChange$redespachoCepBox();
	}

	public void onSelect$remetenteBox(Event event) {
		Comboitem selectedItem = remetenteBox.getSelectedItem();
		Cliente clienteRemetente = (Cliente) selectedItem.getValue();

		Endereco remetente = null;
		for (Endereco endereco : clienteRemetente.getEnderecos()) {
			if (endereco.getTipo().equals(Endereco.TIPO_ENTREGA) || endereco.getTipo().equals(Endereco.TIPO_GERAL)) {
				remetente = endereco;
			}
		}

		if (remetente == null || clienteRemetente.getEnderecos().size() < 0)
			return;

		selected.setRemetente(new ColetaEndereco());
		selected.getRemetente().setNomeRazaoSocial(clienteRemetente.getNomefantasiasobrenome());
		selected.getRemetente().setCpfCnpj(clienteRemetente.getCnpjcpf());
		selected.getRemetente().setEndereco(remetente.getEndereco());
		selected.getRemetente().setCep(remetente.getCep());
		selected.getRemetente().setBairro(remetente.getBairro());
		selected.getRemetente().setCidade(remetente.getCidade());
		selected.getRemetente().setUf(remetente.getUf());

		binder.loadAll();
	}

	public void onSelect$destinatarioBox(Event event) {
		Comboitem selectedItem = destinatarioBox.getSelectedItem();
		ColetaEndereco destinatario = (ColetaEndereco) selectedItem.getValue();

		selected.setDestinatario(new ColetaEndereco());
		selected.getDestinatario().setNomeRazaoSocial(destinatario.getNomeRazaoSocial());
		selected.getDestinatario().setCpfCnpj(destinatario.getCpfCnpj());
		selected.getDestinatario().setEndereco(destinatario.getEndereco());
		selected.getDestinatario().setCep(destinatario.getCep());
		selected.getDestinatario().setBairro(destinatario.getBairro());
		selected.getDestinatario().setGuia(destinatario.getGuia());
		selected.getDestinatario().setContato(destinatario.getContato());
		selected.getDestinatario().setTelefone(destinatario.getTelefone());
		selected.getDestinatario().setRamal(destinatario.getRamal());
		selected.getDestinatario().setEmail(destinatario.getEmail());

	}

	public void onSelect$consignatarioBox(Event event) {
		Comboitem selectedItem = consignatarioBox.getSelectedItem();
		ColetaEndereco consignatario = (ColetaEndereco) selectedItem.getValue();

		selected.setConsignatarioEndereco(new ColetaEndereco());
		selected.getConsignatarioEndereco().setNomeRazaoSocial(consignatario.getNomeRazaoSocial());
		selected.getConsignatarioEndereco().setCpfCnpj(consignatario.getCpfCnpj());
		selected.getConsignatarioEndereco().setEndereco(consignatario.getEndereco());
		selected.getConsignatarioEndereco().setCep(consignatario.getCep());
		selected.getConsignatarioEndereco().setBairro(consignatario.getBairro());
		selected.getConsignatarioEndereco().setGuia(consignatario.getGuia());
		selected.getConsignatarioEndereco().setContato(consignatario.getContato());
		selected.getConsignatarioEndereco().setTelefone(consignatario.getTelefone());
		selected.getConsignatarioEndereco().setRamal(consignatario.getRamal());
		selected.getConsignatarioEndereco().setEmail(consignatario.getEmail());

	}

	public void onSelect$redespachoBox(Event event) {
		Comboitem selectedItem = redespachoBox.getSelectedItem();
		ColetaEndereco redespacho = (ColetaEndereco) selectedItem.getValue();

		selected.setRedespachoEndereco(new ColetaEndereco());
		selected.getRedespachoEndereco().setNomeRazaoSocial(redespacho.getNomeRazaoSocial());
		selected.getRedespachoEndereco().setCpfCnpj(redespacho.getCpfCnpj());
		selected.getRedespachoEndereco().setEndereco(redespacho.getEndereco());
		selected.getRedespachoEndereco().setCep(redespacho.getCep());
		selected.getRedespachoEndereco().setBairro(redespacho.getBairro());
		selected.getRedespachoEndereco().setGuia(redespacho.getGuia());
		selected.getRedespachoEndereco().setContato(redespacho.getContato());
		selected.getRedespachoEndereco().setTelefone(redespacho.getTelefone());
		selected.getRedespachoEndereco().setRamal(redespacho.getRamal());
		selected.getRedespachoEndereco().setEmail(redespacho.getEmail());

	}

	// Box Frete
	protected Radio caldFreteRad1;
	protected Radio caldFreteRad2;
	protected Radio caldFreteRad3;

	// Box Frete
	protected Grid boxFrete1;
	protected Component boxFrete2;
	protected Grid boxFrete3;

	public void onCheck$caldFreteRad1() {
		boxFrete1.setVisible(true);

		boxFrete2.setVisible(false);
		boxFrete3.setVisible(false);
	}

	public void onCheck$caldFreteRad2() {
		boxFrete2.setVisible(true);

		boxFrete1.setVisible(false);
		boxFrete3.setVisible(false);
	}

	public void onCheck$caldFreteRad3() {
		boxFrete3.setVisible(true);

		boxFrete2.setVisible(false);
		boxFrete1.setVisible(false);
	}

	// Frete
	public void setConhecimentoCTe(ConhecimentoCTe conhecimentoCTe) {
		selected.setConhecimentoCTe(conhecimentoCTe);
	}

	public ConhecimentoCalculoFreteUm getConhecimentoCalculoFreteUm() {
		return selected.getConhecimentoCalculoFreteUm();
	}
	
	// Gerar Boleto
	protected Component gerarBoletoImg;
	
	public void onClick$gerarBoletoImg() throws InterruptedException {
		Boleto boleto;
		try {
			boleto = BoletoUtil.criarBoleto(login.getUnidade(), selected.getClienteRemetente(), selected.getId().toString(), selected.getCtrc(), selected.getId().toString(),
					selected.getTotalFreteBruto(), selected.getDataCriacao(), selected.getDataCriacao(), BigDecimal.ZERO);
			BoletoViewer boletoViewer = new BoletoViewer(boleto);
			org.zkoss.zul.Filedownload.save(boletoViewer.getPdfAsByteArray(), "text/plain", selected.getId() + "_conhecimento_boleto.pdf");

		} catch (ServiceException e) {
			Messagebox.show(e.getMessage());
			e.printStackTrace();
		}
	}


	// Calcular por formula
	protected Textbox formulaBox;
	protected Doublebox valorFormulaBox;

	protected Textbox formulaBox2;
	protected Doublebox valorFormulaBox2;

	protected Textbox formulaBox3;
	protected Doublebox valorFormulaBox3;

	public void alterarValorTotalBruto() {
		selected.calcularValores();
	}

	public void alterarValorPelaFormula() {
		BigDecimal bigDecimalExpression = MathUtil.getBigDecimalExpression(formulaBox.getValue());
		selected.getConhecimentoCalculoFreteUm().setValorFormula(bigDecimalExpression);
	}

	public void onChange$formulaBox() {
		alterarValorPelaFormula();
	}

	public void onChange$valorFreteBox() {
		alterarValorTotalBruto();
	}

	public void alterarValorPelaFormula2() {
		BigDecimal bigDecimalExpression = MathUtil.getBigDecimalExpression(formulaBox2.getValue());
		selected.getConhecimentoCalculoFreteDois().setValorFormula(bigDecimalExpression);
	}

	public void onChange$formulaBox2() {
		alterarValorPelaFormula2();
	}

	public void onChange$valorFreteBox2() {
		alterarValorTotalBruto();
	}

	public void alterarValorPelaFormula3() {
		BigDecimal bigDecimalExpression = MathUtil.getBigDecimalExpression(formulaBox3.getValue());
		selected.getConhecimentoCalculoFreteCarta().setValorFormula(bigDecimalExpression);
	}

	public void onChange$formulaBox3() {
		alterarValorPelaFormula3();
	}

	public void onChange$valorFreteBox3() {
		alterarValorTotalBruto();
	}

	// Listas
	protected List<Login> logins;

	public List<Login> getDigitadores() {
		if (logins == null || logins.isEmpty())
			logins = genericService.procurarTodos(Login.class);

		return logins;
	}

	public List<Cpof> getCpofs() {
		return genericService.procurarTodos(Cpof.class);
	}

	public List<ColetaEndereco> getEnderecosEntregues() {
		return genericService.procurarTodos(ColetaEndereco.class);
	}

	public List<ColetaEndereco> getConsignatarioEnderecosEntregues() {
		return genericService.procurarTodos(ColetaEndereco.class);
	}

	public List<ColetaEndereco> getRedespachoEnderecosEntregues() {
		return genericService.procurarTodos(ColetaEndereco.class);
	}

	public List<Cliente> getClientes() {
		return genericService.procurarTodos(Cliente.class);
	}

	public List<Motorista> getMotoristas() {
		return genericService.procurarTodos(Motorista.class);
	}

	public List<Veiculo> getVeiculos() {
		return genericService.procurarTodos(Veiculo.class);
	}

	// Gett's and Sett's

	public Combobox getDestinatarioBox() {
		return destinatarioBox;
	}

	public void setDestinatarioBox(Combobox destinatarioBox) {
		this.destinatarioBox = destinatarioBox;
	}

	public Combobox getRemetenteBox() {
		return remetenteBox;
	}

	public void setRemetenteBox(Combobox remetenteBox) {
		this.remetenteBox = remetenteBox;
	}

	public NotaFiscalController getNotaFiscalController() {
		return notaFiscalController;
	}

	public void setNotaFiscalController(NotaFiscalController notaFiscalController) {
		this.notaFiscalController = notaFiscalController;
	}

	public ServicoController getServicoController() {
		return servicoController;
	}

	public void setServicoController(ServicoController servicoController) {
		this.servicoController = servicoController;
	}

	public Textbox getRemetenteCepBox() {
		return remetenteCepBox;
	}

	public void setRemetenteCepBox(Textbox remetenteCepBox) {
		this.remetenteCepBox = remetenteCepBox;
	}

	public Image getRemetenteCepSearch() {
		return remetenteCepSearch;
	}

	public void setRemetenteCepSearch(Image remetenteCepSearch) {
		this.remetenteCepSearch = remetenteCepSearch;
	}

	public Textbox getRemetenteEnderecoBox() {
		return remetenteEnderecoBox;
	}

	public void setRemetenteEnderecoBox(Textbox remetenteEnderecoBox) {
		this.remetenteEnderecoBox = remetenteEnderecoBox;
	}

	public Textbox getRemetenteBairroBox() {
		return remetenteBairroBox;
	}

	public void setRemetenteBairroBox(Textbox remetenteBairroBox) {
		this.remetenteBairroBox = remetenteBairroBox;
	}

	public Textbox getRemetenteCidadeBox() {
		return remetenteCidadeBox;
	}

	public void setRemetenteCidadeBox(Textbox remetenteCidadeBox) {
		this.remetenteCidadeBox = remetenteCidadeBox;
	}

	public Textbox getDestinatarioCepBox() {
		return destinatarioCepBox;
	}

	public void setDestinatarioCepBox(Textbox destinatarioCepBox) {
		this.destinatarioCepBox = destinatarioCepBox;
	}

	public Image getDestinatarioCepSearch() {
		return destinatarioCepSearch;
	}

	public void setDestinatarioCepSearch(Image destinatarioCepSearch) {
		this.destinatarioCepSearch = destinatarioCepSearch;
	}

	public Textbox getDestinatarioEnderecoBox() {
		return destinatarioEnderecoBox;
	}

	public void setDestinatarioEnderecoBox(Textbox destinatarioEnderecoBox) {
		this.destinatarioEnderecoBox = destinatarioEnderecoBox;
	}

	public Textbox getDestinatarioBairroBox() {
		return destinatarioBairroBox;
	}

	public void setDestinatarioBairroBox(Textbox destinatarioBairroBox) {
		this.destinatarioBairroBox = destinatarioBairroBox;
	}

	public Textbox getDestinatarioCidadeBox() {
		return destinatarioCidadeBox;
	}

	public void setDestinatarioCidadeBox(Textbox destinatarioCidadeBox) {
		this.destinatarioCidadeBox = destinatarioCidadeBox;
	}

	public static long getSerialversionuid() {
		return serialVersionUID;
	}

	public Grid getBoxFrete1() {
		return boxFrete1;
	}

	public void setBoxFrete1(Grid boxFrete1) {
		this.boxFrete1 = boxFrete1;
	}

	public Component getBoxFrete2() {
		return boxFrete2;
	}

	public void setBoxFrete2(Component boxFrete2) {
		this.boxFrete2 = boxFrete2;
	}

	public Grid getBoxFrete3() {
		return boxFrete3;
	}

	public void setBoxFrete3(Grid boxFrete3) {
		this.boxFrete3 = boxFrete3;
	}

	public Radio getCaldFreteRad1() {
		return caldFreteRad1;
	}

	public void setCaldFreteRad1(Radio caldFreteRad1) {
		this.caldFreteRad1 = caldFreteRad1;
	}

	public Radio getCaldFreteRad2() {
		return caldFreteRad2;
	}

	public void setCaldFreteRad2(Radio caldFreteRad2) {
		this.caldFreteRad2 = caldFreteRad2;
	}

	public Radio getCaldFreteRad3() {
		return caldFreteRad3;
	}

	public void setCaldFreteRad3(Radio caldFreteRad3) {
		this.caldFreteRad3 = caldFreteRad3;
	}

	public Textbox getConsignatarioCepBox() {
		return consignatarioCepBox;
	}

	public void setConsignatarioCepBox(Textbox consignatarioCepBox) {
		this.consignatarioCepBox = consignatarioCepBox;
	}

	public Image getConsignatarioCepSearch() {
		return consignatarioCepSearch;
	}

	public void setConsignatarioCepSearch(Image consignatarioCepSearch) {
		this.consignatarioCepSearch = consignatarioCepSearch;
	}

	public Textbox getConsignatarioEnderecoBox() {
		return consignatarioEnderecoBox;
	}

	public void setConsignatarioEnderecoBox(Textbox consignatarioEnderecoBox) {
		this.consignatarioEnderecoBox = consignatarioEnderecoBox;
	}

	public Textbox getConsignatarioBairroBox() {
		return consignatarioBairroBox;
	}

	public void setConsignatarioBairroBox(Textbox consignatarioBairroBox) {
		this.consignatarioBairroBox = consignatarioBairroBox;
	}

	public Textbox getConsignatarioCidadeBox() {
		return consignatarioCidadeBox;
	}

	public void setConsignatarioCidadeBox(Textbox consignatarioCidadeBox) {
		this.consignatarioCidadeBox = consignatarioCidadeBox;
	}

	public Textbox getRedespachoCepBox() {
		return redespachoCepBox;
	}

	public void setRedespachoCepBox(Textbox redespachoCepBox) {
		this.redespachoCepBox = redespachoCepBox;
	}

	public Image getRedespachoCepSearch() {
		return redespachoCepSearch;
	}

	public void setRedespachoCepSearch(Image redespachoCepSearch) {
		this.redespachoCepSearch = redespachoCepSearch;
	}

	public Textbox getRedespachoEnderecoBox() {
		return redespachoEnderecoBox;
	}

	public void setRedespachoEnderecoBox(Textbox redespachoEnderecoBox) {
		this.redespachoEnderecoBox = redespachoEnderecoBox;
	}

	public Textbox getRedespachoBairroBox() {
		return redespachoBairroBox;
	}

	public void setRedespachoBairroBox(Textbox redespachoBairroBox) {
		this.redespachoBairroBox = redespachoBairroBox;
	}

	public Textbox getRedespachoCidadeBox() {
		return redespachoCidadeBox;
	}

	public void setRedespachoCidadeBox(Textbox redespachoCidadeBox) {
		this.redespachoCidadeBox = redespachoCidadeBox;
	}

	public Combobox getConsignatarioBox() {
		return consignatarioBox;
	}

	public void setConsignatarioBox(Combobox consignatarioBox) {
		this.consignatarioBox = consignatarioBox;
	}

	public Combobox getRedespachoBox() {
		return redespachoBox;
	}

	public void setRedespachoBox(Combobox redespachoBox) {
		this.redespachoBox = redespachoBox;
	}

	public Combobox getRemetenteUfBox() {
		return remetenteUfBox;
	}

	public Combobox getDestinatarioUfBox() {
		return destinatarioUfBox;
	}

	public void setDestinatarioUfBox(Combobox destinatarioUfBox) {
		this.destinatarioUfBox = destinatarioUfBox;
	}

	public Combobox getConsignatarioUfBox() {
		return consignatarioUfBox;
	}

	public void setConsignatarioUfBox(Combobox consignatarioUfBox) {
		this.consignatarioUfBox = consignatarioUfBox;
	}

	public Combobox getRedespachoUfBox() {
		return redespachoUfBox;
	}

	public void setRedespachoUfBox(Combobox redespachoUfBox) {
		this.redespachoUfBox = redespachoUfBox;
	}

	public void setRemetenteUfBox(Combobox remetenteUfBox) {
		this.remetenteUfBox = remetenteUfBox;
	}

	public Component getEntitySync() {
		return entitySync;
	}

	public void setEntitySync(Component entitySync) {
		this.entitySync = entitySync;
	}

	public BrasilRiskService getBrasilRiskService() {
		return brasilRiskService;
	}

	public void setBrasilRiskService(BrasilRiskService brasilRiskService) {
		this.brasilRiskService = brasilRiskService;
	}

	public Textbox getFormulaBox() {
		return formulaBox;
	}

	public void setFormulaBox(Textbox formulaBox) {
		this.formulaBox = formulaBox;
	}

	public Doublebox getValorFormulaBox() {
		return valorFormulaBox;
	}

	public void setValorFormulaBox(Doublebox valorFormulaBox) {
		this.valorFormulaBox = valorFormulaBox;
	}

	public Textbox getFormulaBox2() {
		return formulaBox2;
	}

	public void setFormulaBox2(Textbox formulaBox2) {
		this.formulaBox2 = formulaBox2;
	}

	public Doublebox getValorFormulaBox2() {
		return valorFormulaBox2;
	}

	public void setValorFormulaBox2(Doublebox valorFormulaBox2) {
		this.valorFormulaBox2 = valorFormulaBox2;
	}

	public Textbox getFormulaBox3() {
		return formulaBox3;
	}

	public void setFormulaBox3(Textbox formulaBox3) {
		this.formulaBox3 = formulaBox3;
	}

	public Doublebox getValorFormulaBox3() {
		return valorFormulaBox3;
	}

	public void setValorFormulaBox3(Doublebox valorFormulaBox3) {
		this.valorFormulaBox3 = valorFormulaBox3;
	}

	public List<Login> getLogins() {
		return logins;
	}

	public void setLogins(List<Login> logins) {
		this.logins = logins;
	}

	public Button getAverbacaoBtn() {
		return averbacaoBtn;
	}

	public void setAverbacaoBtn(Button averbacaoBtn) {
		this.averbacaoBtn = averbacaoBtn;
	}

	public AverbacaoService getAverbacaoService() {
		return averbacaoService;
	}

	public void setAverbacaoService(AverbacaoService averbacaoService) {
		this.averbacaoService = averbacaoService;
	}

	public Component getGerarBoletoImg() {
		return gerarBoletoImg;
	}

	public void setGerarBoletoImg(Component gerarBoletoImg) {
		this.gerarBoletoImg = gerarBoletoImg;
	}

	// public ConhecimentoCalculoFreteUmController
	// getConhecimentoCalculoFreteUmController() {
	// return conhecimentoCalculoFreteUmController;
	// }
	//
	// public void
	// setConhecimentoCalculoFreteUmController(ConhecimentoCalculoFreteUmController
	// conhecimentoCalculoFreteUmController) {
	// this.conhecimentoCalculoFreteUmController =
	// conhecimentoCalculoFreteUmController;
	// }

}
