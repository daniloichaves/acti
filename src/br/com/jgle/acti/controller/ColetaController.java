package br.com.jgle.acti.controller;

import java.io.Serializable;
import java.math.BigDecimal;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import net.sf.jasperreports.engine.data.JRBeanCollectionDataSource;

import org.springframework.context.annotation.Scope;
import org.springframework.stereotype.Controller;
import org.zkoss.gmaps.Gmaps;
import org.zkoss.gmaps.Gmarker;
import org.zkoss.gmaps.Gpolyline;
import org.zkoss.zk.ui.Component;
import org.zkoss.zk.ui.event.Event;
import org.zkoss.zkex.zul.Jasperreport;
import org.zkoss.zul.Button;
import org.zkoss.zul.Combobox;
import org.zkoss.zul.Comboitem;
import org.zkoss.zul.Doublebox;
import org.zkoss.zul.Image;
import org.zkoss.zul.Intbox;
import org.zkoss.zul.Label;
import org.zkoss.zul.Listbox;
import org.zkoss.zul.Messagebox;
import org.zkoss.zul.api.Textbox;

import br.com.jgle.acti.entity.Cliente;
import br.com.jgle.acti.entity.Coleta;
import br.com.jgle.acti.entity.ColetaEndereco;
import br.com.jgle.acti.entity.Cpof;
import br.com.jgle.acti.entity.Endereco;
import br.com.jgle.acti.entity.Motorista;
import br.com.jgle.acti.entity.Veiculo;
import br.com.jgle.acti.exception.ServiceException;
import br.com.jgle.acti.util.BoletoUtil;
import br.com.jgle.acti.util.MathUtil;
import br.com.jgle.acti.webservice.CepService;
import br.com.jgle.acti.webservice.GoogleMapService;
import br.com.jgle.acti.webservice.Webservicecep;
import br.com.nordestefomento.jrimum.bopepo.Boleto;
import br.com.nordestefomento.jrimum.bopepo.view.BoletoViewer;

@SuppressWarnings("serial")
@Scope("page")
@Controller
public class ColetaController extends AbstractController<Coleta> implements Serializable {

	// Roterizador
	protected Gmaps mymap;
	protected Label lbl;
	protected Gpolyline mypoly;

	protected Component gerarBoletoImg;

	@Override
	public void doAfterCompose(Component comp) throws Exception {
		super.doAfterCompose(comp);

		if (mymap == null)
			return;

		List<Coleta> coletas = genericService.procurarTodos(Coleta.class);

		for (Coleta coleta : coletas) {

			ColetaEndereco remetente = coleta.getRemetente();

			if (remetente.getLat() == null || remetente.getLat() == 0) {

				String endereco = remetente.getEnderecoBusca();
				String findCoordenates = GoogleMapService.findCoordenates(endereco);
				if (findCoordenates != null && !"".equals(findCoordenates) && !findCoordenates.contains("0,0")) {
					String[] coord = findCoordenates.split(",");

					double lnt = new Double(coord[1]);
					double lat = new Double(coord[0]);
					// add a gmarker on the vertex
					Gmarker gmarker = new Gmarker(endereco, lat, lnt);
					gmarker.setParent(mymap);
					// add a polyline vertex point
					mypoly.addPoint(lat, lnt, 3);
					// display the vertex latitude and longitude
					lbl.setValue(lbl.getValue() + lat + "," + lnt + ";\n");

					remetente.setLat(lat);
					remetente.setLnt(lnt);

					genericService.atualizar(remetente);
				}
			}
		}
		// binder.loadComponent(entityDetail);
	}

	protected Combobox remetenteBox;
	protected Combobox destinatarioBox;
	protected NotaFiscalController notaFiscalController;
	protected ServicoController servicoController;

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

	public List<Motorista> getMotoristas() {
		return genericService.procurarTodos(Motorista.class);
	}

	public List<Veiculo> getVeiculos() {
		return genericService.procurarTodos(Veiculo.class);
	}

	public void onChange$remetenteCepBox() {
		try {
			if (remetenteCepBox.getValue().length() == 8) {
				System.out.println(remetenteCepBox.getValue());

				Webservicecep endereco = CepService.getEndereco(remetenteCepBox.getValue());
				if (endereco.enderecoValido()) {
					remetenteEnderecoBox.setValue(endereco.getTipo_logradouro() + " " + endereco.getLogradouro() + ", ");
					remetenteBairroBox.setValue(endereco.getBairro());
					// remetenteCidadeBox.setValue(endereco.getCidade());
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
			} catch (InterruptedException e1) {
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
					// destinatarioCidadeBox.setValue(endereco.getCidade());
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
			} catch (InterruptedException e1) {
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

	public ColetaController() {
		super(new Coleta());

		notaFiscalController = new NotaFiscalController(this);
		servicoController = new ServicoController(this);
	}

	public void onSelect$remetenteBox(Event event) {
		Comboitem selectedItem = remetenteBox.getSelectedItem();
		Cliente clienteRemetente = (Cliente) selectedItem.getValue();

		Endereco remetente = null;
		for (Endereco endereco : clienteRemetente.getEnderecos()) {
			if (endereco.getTipo().equals(Endereco.TIPO_ENTREGA)) {
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

	// Valores

	protected Doublebox valorFreteBox;
	protected Doublebox pedagioBox;
	protected Doublebox adValoremBox;
	protected Doublebox seguroBox;
	protected Doublebox taxaAereaBox;
	protected Doublebox taxaColetaBox;
	protected Doublebox taxaEntregaBox;
	protected Doublebox redespachoBox;
	protected Doublebox descontoBox;

	// Calcular por KM
	protected Intbox distanciaBox;
	protected Doublebox valorKmBox;
	protected Doublebox valorTotalBox;

	// Calculo total
	protected Doublebox valorTotalBrutoBox;

	// Calcular por formula
	protected Textbox formulaBox;
	protected Doublebox valorFormulaBox;

	public void alterarValorTotalBruto() {
		selected.setValorTotalBruto(selected.calcularValorTotalBruto());
	}

	public void onCreate$valorTotalBox() {
		selected.setValorTotalKm(selected.calcularValorTotalKm());
	}

	public void alterarValorPelaFormula() {
		BigDecimal bigDecimalExpression = MathUtil.getBigDecimalExpression(formulaBox.getValue());
		selected.setValorFormula(bigDecimalExpression);
	}

	public void onChange$formulaBox() {
		alterarValorPelaFormula();
	}

	public void onChange$valorFreteBox() {
		alterarValorTotalBruto();
	}

	public void onChange$pedagioBox() {
		alterarValorTotalBruto();
	}

	public void onChange$adValoremBox() {
		alterarValorTotalBruto();
	}

	public void onChange$taxaAereaBox() {
		alterarValorTotalBruto();
	}

	public void onChange$taxaColetaBox() {
		alterarValorTotalBruto();
	}

	public void onChange$taxaEntregaBox() {
		alterarValorTotalBruto();
	}

	public void onChange$redespachoBox() {
		alterarValorTotalBruto();
	}

	public void onChange$descontoBox() {
		alterarValorTotalBruto();
	}

	public void onChange$distanciaBox() {
		selected.setValorTotalKm(selected.calcularValorTotalKm());
		alterarValorTotalBruto();
	}

	public void onChange$valorKmBox() {
		selected.setValorTotalKm(selected.calcularValorTotalKm());
		alterarValorTotalBruto();
	}

	public void onChange$valorTotalBox() {
		alterarValorTotalBruto();
	}

	// Relatorio
	protected Button reportButoton;
	protected Jasperreport report;
	protected Listbox formatBox;

	@SuppressWarnings({ "unchecked", "rawtypes" })
	public void onClick$reportButoton() {
		// Preparing parameters
		Map parameters = new HashMap();
		parameters.put("ReportTitle", "Teste Report");
		parameters.put("TITULO", "Teste Report");
		parameters.put("DataFile", "CustomDataSource from java");

		report.setSrc("/relatorio/teste.jasper");
		report.setParameters(parameters);
		report.setType((String) formatBox.getSelectedItem().getValue());
		report.setDatasource(new JRBeanCollectionDataSource((java.util.Collection) getList()));
	}

	public void onSelect$formatBox() {
		onClick$reportButoton();
	}

	// Geração de Boleto
	public void onClick$gerarBoletoImg() throws InterruptedException {
		Boleto boleto;
		try {
			boleto = BoletoUtil.criarBoleto(login.getUnidade(), selected.getClienteRemetente(), selected.getDiNumero(), selected.getId().toString(), selected.getNumeroOS().toString(),
					selected.getValorTotalBruto(), selected.getDataCriacao(), selected.getDataVencimento(), selected.getDesconto());
			BoletoViewer boletoViewer = new BoletoViewer(boleto);
			org.zkoss.zul.Filedownload.save(boletoViewer.getPdfAsByteArray(), "text/plain", selected.getId() + "_coleta_boleto.pdf");

		} catch (ServiceException e) {
			Messagebox.show(e.getMessage());
			e.printStackTrace();
		}
	}

	// Getts and Setts
	public List<Cpof> getCpofs() {
		return genericService.procurarTodos(Cpof.class);
	}

	public List<ColetaEndereco> getEnderecosEntregues() {
		return genericService.procurarTodos(ColetaEndereco.class);
	}

	public List<Cliente> getClientes() {
		return genericService.procurarTodos(Cliente.class);
	}

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

	public Combobox getRemetenteUfBox() {
		return remetenteUfBox;
	}

	public void setRemetenteUfBox(Combobox remetenteUfBox) {
		this.remetenteUfBox = remetenteUfBox;
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

	public Combobox getDestinatarioUfBox() {
		return destinatarioUfBox;
	}

	public void setDestinatarioUfBox(Combobox destinatarioUfBox) {
		this.destinatarioUfBox = destinatarioUfBox;
	}

	public Doublebox getValorFreteBox() {
		return valorFreteBox;
	}

	public void setValorFreteBox(Doublebox valorFreteBox) {
		this.valorFreteBox = valorFreteBox;
	}

	public Doublebox getPedagioBox() {
		return pedagioBox;
	}

	public void setPedagioBox(Doublebox pedagioBox) {
		this.pedagioBox = pedagioBox;
	}

	public Doublebox getAdValoremBox() {
		return adValoremBox;
	}

	public void setAdValoremBox(Doublebox adValoremBox) {
		this.adValoremBox = adValoremBox;
	}

	public Doublebox getSeguroBox() {
		return seguroBox;
	}

	public void setSeguroBox(Doublebox seguroBox) {
		this.seguroBox = seguroBox;
	}

	public Doublebox getTaxaAereaBox() {
		return taxaAereaBox;
	}

	public void setTaxaAereaBox(Doublebox taxaAereaBox) {
		this.taxaAereaBox = taxaAereaBox;
	}

	public Doublebox getTaxaColetaBox() {
		return taxaColetaBox;
	}

	public void setTaxaColetaBox(Doublebox taxaColetaBox) {
		this.taxaColetaBox = taxaColetaBox;
	}

	public Doublebox getTaxaEntregaBox() {
		return taxaEntregaBox;
	}

	public void setTaxaEntregaBox(Doublebox taxaEntregaBox) {
		this.taxaEntregaBox = taxaEntregaBox;
	}

	public Doublebox getRedespachoBox() {
		return redespachoBox;
	}

	public void setRedespachoBox(Doublebox redespachoBox) {
		this.redespachoBox = redespachoBox;
	}

	public Doublebox getDescontoBox() {
		return descontoBox;
	}

	public void setDescontoBox(Doublebox descontoBox) {
		this.descontoBox = descontoBox;
	}

	public Intbox getDistanciaBox() {
		return distanciaBox;
	}

	public void setDistanciaBox(Intbox distanciaBox) {
		this.distanciaBox = distanciaBox;
	}

	public Doublebox getValorKmBox() {
		return valorKmBox;
	}

	public void setValorKmBox(Doublebox valorKmBox) {
		this.valorKmBox = valorKmBox;
	}

	public Doublebox getValorTotalBox() {
		return valorTotalBox;
	}

	public void setValorTotalBox(Doublebox valorTotalBox) {
		this.valorTotalBox = valorTotalBox;
	}

	public Doublebox getValorTotalBrutoBox() {
		return valorTotalBrutoBox;
	}

	public void setValorTotalBrutoBox(Doublebox valorTotalBrutoBox) {
		this.valorTotalBrutoBox = valorTotalBrutoBox;
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

	public Button getReportButoton() {
		return reportButoton;
	}

	public Jasperreport getReport() {
		return report;
	}

	public void setReportButoton(Button reportButoton) {
		this.reportButoton = reportButoton;
	}

	public void setReport(Jasperreport report) {
		this.report = report;
	}

	public Listbox getFormatBox() {
		return formatBox;
	}

	public void setFormatBox(Listbox formatBox) {
		this.formatBox = formatBox;
	}

	public Gmaps getMymap() {
		return mymap;
	}

	public void setMymap(Gmaps mymap) {
		this.mymap = mymap;
	}

	public Label getLbl() {
		return lbl;
	}

	public void setLbl(Label lbl) {
		this.lbl = lbl;
	}

	public Gpolyline getMypoly() {
		return mypoly;
	}

	public void setMypoly(Gpolyline mypoly) {
		this.mypoly = mypoly;
	}

	public Component getGerarBoletoImg() {
		return gerarBoletoImg;
	}

	public void setGerarBoletoImg(Component gerarBoletoImg) {
		this.gerarBoletoImg = gerarBoletoImg;
	}
}
