package br.com.jgle.acti.controller;

import java.util.ArrayList;
import java.util.List;

import org.springframework.context.annotation.Scope;
import org.springframework.stereotype.Controller;
import org.zkoss.zk.ui.util.Composer;
import org.zkoss.zul.Combobox;
import org.zkoss.zul.Image;
import org.zkoss.zul.Messagebox;
import org.zkoss.zul.Textbox;

import br.com.jgle.acti.controller.pgr.ProjetoController;
import br.com.jgle.acti.entity.Endereco;
import br.com.jgle.acti.webservice.CepService;
import br.com.jgle.acti.webservice.Webservicecep;

@Scope("page")
@Controller
public class EnderecoController extends AbstractController<Endereco> implements Composer {

	private static final long serialVersionUID = 1L;

	protected Textbox cepBox;
	protected Image cepSearch;

	protected Textbox enderecoBox;
	protected Textbox bairroBox;
	protected Textbox cidadeBox;
	protected Combobox ufBox;

	public EnderecoController() {
		super(new Endereco());
	}

	@SuppressWarnings({ "rawtypes", "unchecked" })
	public EnderecoController(AbstractController parent) {
		super(new Endereco(), parent);
	}

	public void onClick$cepTextLabel() {
		onChange$cepBox();
	}

	public void onClick$cepSearch() {
		onChange$cepBox();
	}
	
	public List<String> getTipoEnderecos() {
		List<String> tipoEnderecos = new ArrayList<String>();
		
		if(parent instanceof ProjetoController) {
			tipoEnderecos.add("PARADA OBRIGATÓRIA");
			tipoEnderecos.add("PARADA AUTORIZADA PARA HIGIENE E REFEIÇÃO");
			tipoEnderecos.add("PARADA AUTORIZADA PARA PERNOITE");
			
		} else {
			tipoEnderecos.add("GERAL");
			tipoEnderecos.add("COBRANÇA");
			tipoEnderecos.add("ENTREGA");
			tipoEnderecos.add("COLETA");
		}
		
		
		return tipoEnderecos;
	}

	public void onChange$cepBox() {
		try {
			if (cepBox.getValue().length() == 8) {
				System.out.println(cepBox.getValue());

				Webservicecep endereco = CepService.getEndereco(cepBox.getValue());
				if (endereco.enderecoValido()) {
					enderecoBox.setValue(endereco.getTipo_logradouro() + " " + endereco.getLogradouro());
					bairroBox.setValue(endereco.getBairro());
					cidadeBox.setValue(endereco.getCidade());
					ufBox.setValue(endereco.getUf());

					selected.setEndereco(endereco.getTipo_logradouro() + " " + endereco.getLogradouro());
					selected.setBairro(endereco.getBairro());
					selected.setCidade(endereco.getCidade());
					selected.setUf(endereco.getUf());
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

	// Get's and Set's

	public Textbox getCepTextbox() {
		return cepBox;
	}

	public void setCepTextbox(Textbox cepTextbox) {
		this.cepBox = cepTextbox;
	}

	public Image getCepSearch() {
		return cepSearch;
	}

	public void setCepSearch(Image cepSearch) {
		this.cepSearch = cepSearch;
	}

	public Textbox getEnderecoBox() {
		return enderecoBox;
	}

	public void setEnderecoBox(Textbox enderecoBox) {
		this.enderecoBox = enderecoBox;
	}

	public Textbox getBairroBox() {
		return bairroBox;
	}

	public void setBairroBox(Textbox bairroBox) {
		this.bairroBox = bairroBox;
	}

	public Textbox getCidadeBox() {
		return cidadeBox;
	}

	public void setCidadeBox(Textbox cidadeBox) {
		this.cidadeBox = cidadeBox;
	}

	public Combobox getUfBox() {
		return ufBox;
	}

	public void setUfBox(Combobox ufBox) {
		this.ufBox = ufBox;
	}

	public Textbox getCepBox() {
		return cepBox;
	}

	public void setCepBox(Textbox cepBox) {
		this.cepBox = cepBox;
	}

}
