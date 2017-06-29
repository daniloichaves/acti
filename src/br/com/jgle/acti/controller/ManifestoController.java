package br.com.jgle.acti.controller;

import java.math.BigDecimal;
import java.util.ArrayList;
import java.util.Collection;
import java.util.Collections;
import java.util.List;
import java.util.Set;

import org.springframework.context.annotation.Scope;
import org.springframework.stereotype.Controller;
import org.zkoss.zk.ui.Component;
import org.zkoss.zk.ui.event.Event;
import org.zkoss.zul.Combobox;
import org.zkoss.zul.Comboitem;
import org.zkoss.zul.Image;
import org.zkoss.zul.Listbox;
import org.zkoss.zul.Listitem;

import br.com.jgle.acti.entity.Cliente;
import br.com.jgle.acti.entity.ColetaEndereco;
import br.com.jgle.acti.entity.Conhecimento;
import br.com.jgle.acti.entity.Endereco;
import br.com.jgle.acti.entity.Login;
import br.com.jgle.acti.entity.Manifesto;
import br.com.jgle.acti.entity.Motorista;
import br.com.jgle.acti.entity.NotaFiscal;
import br.com.jgle.acti.entity.Veiculo;
import br.com.jgle.acti.entity.estoque.Almoxarifado;

@Scope("page")
@Controller
public class ManifestoController extends AbstractController<Manifesto> {

	private static final long serialVersionUID = 1L;

	// protected List<Conhecimento> selecionados;
	protected Conhecimento conhecimentoSelected;
	protected Component conhecimentoDetail; // domain object detail
	protected Component totaisBox;
	// protected Listbox conhecimentoList;
	protected Combobox almoxarifadoBox;
	protected Listbox left;
	protected Listbox right;
	protected Image addProject;
	protected Image removeProject;

	protected ManifestoConhecimentoController manifestoConhecimentoController;

	public ManifestoController() {
		super(new Manifesto());
		manifestoConhecimentoController = new ManifestoConhecimentoController(this);
	}

	public void onSelect$almoxarifadoBox(Event event) {
		Comboitem selectedItem = almoxarifadoBox.getSelectedItem();
		Almoxarifado almoxarifado = (Almoxarifado) selectedItem.getValue();

		if (almoxarifado == null)
			return;

		Endereco endereco = almoxarifado.getEndereco();

		if (endereco == null)
			return;

		selected.setAlmoxarifado(almoxarifado);

		atualizarCalculos();
		binder.loadComponent(conhecimentoDetail);
	}

	@SuppressWarnings({ "rawtypes", "unchecked" })
	public void onClick$addProject(Event event) {
		Set items = left.getSelectedItems();
		if (items.isEmpty()) {
			alert("Por favor, selecione um produto para ser adicionado!");
		} else {
			List al = new ArrayList(items);
			List<Conhecimento> conhecimentos = new ArrayList(getConhecimentos());
			List<Conhecimento> conhecimentoRemover = new ArrayList<Conhecimento>();

			for (int i = 0; i < al.size(); i++) {
				Listitem li = (Listitem) al.get(i);
				li.setSelected(false);
				right.appendChild(li);

				Conhecimento conhecimento = conhecimentos.get(i);
				selected.getConhecimentos().add(conhecimento);
				conhecimentoRemover.add(conhecimento);
			}
			conhecimentos.remove(conhecimentoRemover);
		}

		atualizarCalculos();
		binder.loadComponent(conhecimentoDetail);
	}

	@SuppressWarnings({ "rawtypes", "unchecked" })
	public void onClick$removeProject(Event event) {
		Set items = right.getSelectedItems();
		if (items.isEmpty()) {
			alert("Por favor, selecione um produto para ser removido!");
		} else {
			List al = new ArrayList(items);
			List<Conhecimento> kitManifesto = new ArrayList<Conhecimento>(selected.getConhecimentos());
			for (int i = 0; i < al.size(); i++) {
				Listitem li = (Listitem) al.get(i);
				li.setSelected(false);
				left.appendChild(li);

				Conhecimento conhecimento = kitManifesto.get(i);
				getConhecimentos().add(conhecimento);
				selected.getConhecimentos().remove(conhecimento);
			}
			for (int i = 0; i < al.size(); i++) {
				Conhecimento Conhecimento = kitManifesto.get(i);
				selected.getConhecimentos().remove(Conhecimento);

			}
		}

		atualizarCalculos();
		binder.loadComponent(conhecimentoDetail);
	}

	public void atualizarCalculos() {
		Set<Conhecimento> conhecimentos = selected.getConhecimentos();

		BigDecimal totalValorNF = BigDecimal.ZERO;
		BigDecimal totalFreteCif = BigDecimal.ZERO;
		BigDecimal totalFreteFob = BigDecimal.ZERO;
		BigDecimal valorSeguro = BigDecimal.ZERO;
		Integer totalQtde = 0;
		BigDecimal totalPeso = BigDecimal.ZERO;
		// BigDecimal totalFrete = new BigDecimal(0);
		
		for (Conhecimento ctrc : conhecimentos) {
			totalValorNF.add(ctrc.getTotalFrete());
			valorSeguro.add(ctrc.getValorSeguro());
			if (Conhecimento.TIPO_FRETE_CIF.equals(ctrc.getTipoFrete())) {
				totalFreteCif.add(ctrc.getTotalFrete());
			} else {
				totalFreteFob.add(ctrc.getTotalFrete());
			}

			Set<NotaFiscal> nfs = ctrc.getNotaFiscals();

			for (NotaFiscal nf : nfs) {
				totalQtde += nf.getVolume();
				totalPeso.add(nf.getPeso());
			}
		}

		selected.setTotalFrete(totalValorNF);
		selected.setTotalFreteCif(totalFreteCif);
		selected.setTotalFreteFob(totalFreteFob);
		selected.setValorSeguro(valorSeguro);
		selected.setTotalPeso(totalPeso);
		selected.setTotalQuantidade(totalQtde);

		binder.loadComponent(totaisBox);

	}

	@SuppressWarnings({ "rawtypes", "unchecked" })
	public ManifestoController(AbstractController parent) {
		super(new Manifesto(), parent);
	}

	@SuppressWarnings("unchecked")
	public Collection<Conhecimento> getConhecimentosReminders() {
		Set<Conhecimento> ctrcLista = selected.getConhecimentos();

		if (ctrcLista == null || ctrcLista.isEmpty())
			return Collections.EMPTY_LIST;

		return ctrcLista;
	}

	public List<Conhecimento> getConhecimentos() {
		List<Conhecimento> procurarTodos = genericService.procurarTodos(Conhecimento.class);
		procurarTodos.removeAll(selected.getConhecimentos());

		return procurarTodos;
	}

	protected List<Login> logins;

	public List<Login> getDigitadores() {
		if (logins == null || logins.isEmpty())
			logins = genericService.procurarTodos(Login.class);

		return logins;
	}

	public List<Login> getConferentes() {
		if (logins == null || logins.isEmpty())
			logins = genericService.procurarTodos(Login.class);

		return logins;
	}

	// Gett's and Sett's
	public List<Cliente> getClientes() {
		return genericService.procurarTodos(Cliente.class);
	}

	public List<Almoxarifado> getAlmoxarifados() {
		return genericService.procurarTodos(Almoxarifado.class);
	}

	public List<Motorista> getMotoristas() {
		return genericService.procurarTodos(Motorista.class);
	}

	public List<Veiculo> getVeiculos() {
		return genericService.procurarTodos(Veiculo.class);
	}

	public List<ColetaEndereco> getEnderecosEntregues() {
		return genericService.procurarTodos(ColetaEndereco.class);
	}

	public Listbox getLeft() {
		return left;
	}

	public void setLeft(Listbox left) {
		this.left = left;
	}

	public Listbox getRight() {
		return right;
	}

	public void setRight(Listbox right) {
		this.right = right;
	}

	public Image getAddProject() {
		return addProject;
	}

	public void setAddProject(Image addProject) {
		this.addProject = addProject;
	}

	public Image getRemoveProject() {
		return removeProject;
	}

	public void setRemoveProject(Image removeProject) {
		this.removeProject = removeProject;
	}

	public static long getSerialversionuid() {
		return serialVersionUID;
	}

	public Conhecimento getConhecimentoSelected() {
		return conhecimentoSelected;
	}

	public void setConhecimentoSelected(Conhecimento conhecimentoSelected) {
		this.conhecimentoSelected = conhecimentoSelected;
	}

	public ManifestoConhecimentoController getManifestoConhecimentoController() {
		return manifestoConhecimentoController;
	}

	public void setManifestoConhecimentoController(ManifestoConhecimentoController manifestoConhecimentoController) {
		this.manifestoConhecimentoController = manifestoConhecimentoController;
	}

	public Component getConhecimentoDetail() {
		return conhecimentoDetail;
	}

	public void setConhecimentoDetail(Component conhecimentoDetail) {
		this.conhecimentoDetail = conhecimentoDetail;
	}

	public Combobox getAlmoxarifadoBox() {
		return almoxarifadoBox;
	}

	public void setAlmoxarifadoBox(Combobox almoxarifadoBox) {
		this.almoxarifadoBox = almoxarifadoBox;
	}

	public Component getTotaisBox() {
		return totaisBox;
	}

	public List<Login> getLogins() {
		return logins;
	}

	public void setTotaisBox(Component totaisBox) {
		this.totaisBox = totaisBox;
	}

	public void setLogins(List<Login> logins) {
		this.logins = logins;
	}
}
