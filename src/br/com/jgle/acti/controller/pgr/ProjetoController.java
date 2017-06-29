package br.com.jgle.acti.controller.pgr;

import java.util.ArrayList;
import java.util.Collection;
import java.util.Collections;
import java.util.List;
import java.util.Set;

import org.springframework.context.annotation.Scope;
import org.springframework.stereotype.Controller;
import org.zkoss.spring.context.annotation.AppliedTo;
import org.zkoss.zhtml.Filedownload;
import org.zkoss.zk.ui.Component;
import org.zkoss.zk.ui.event.Event;
import org.zkoss.zk.ui.event.EventListener;
import org.zkoss.zul.Fileupload;
import org.zkoss.zul.Hbox;
import org.zkoss.zul.Image;
import org.zkoss.zul.Label;
import org.zkoss.zul.Listitem;
import org.zkoss.zul.Messagebox;
import org.zkoss.zul.Vbox;
import org.zkoss.zul.Listbox;

import br.com.jgle.acti.controller.AbstractController;
import br.com.jgle.acti.controller.EnderecoController;
import br.com.jgle.acti.entity.Cliente;
import br.com.jgle.acti.entity.Fornecedor;
import br.com.jgle.acti.entity.Login;
import br.com.jgle.acti.entity.Unidade;
import br.com.jgle.acti.entity.pgr.Adicional;
import br.com.jgle.acti.entity.pgr.Atuador;
import br.com.jgle.acti.entity.pgr.Estado;
import br.com.jgle.acti.entity.pgr.Projeto;
import br.com.jgle.acti.entity.pgr.Rastreador;
import br.com.jgle.acti.entity.pgr.Sensor;
import br.com.jgle.acti.util.ArquivoUtil;
import br.com.jgle.acti.util.PropertiesUtil;

@Scope("page")
@Controller
@AppliedTo("entityWin")
public class ProjetoController extends AbstractController<Projeto> {

	private static final long serialVersionUID = 1L;

	private static final String PATH = PropertiesUtil
			.getPropertyValue("path.pgr");

	protected GrupoMercadoriaController grupoMercadoriaController;
	protected EnderecoController enderecoController;
	protected EscoltaArmadaTrajetoController escoltaArmadaTrajetoController;

	protected Cliente empresasSegurosProprioSelected;
	protected Component clienteDetail; // domain object detail
	protected Component totaisBox;
	protected Listbox left;
	protected Listbox right;
	protected Image addProject;
	protected Image removeProject;

	protected Component unidadeBox;
	protected Listbox leftUnidades;
	protected Listbox rightUnidades;
	protected Image addUnidades;
	protected Image removeUnidades;

	protected Component rastreadorBox;
	protected Listbox leftRastreador;
	protected Listbox rightRastreador;
	protected Image addRastreador;
	protected Image removeRastreador;

	protected Component sensoresBox;
	protected Listbox leftSensores;
	protected Listbox rightSensores;
	protected Image addSensores;
	protected Image removeSensores;

	protected Component atuadoresBox;
	protected Listbox leftAtuadores;
	protected Listbox rightAtuadores;
	protected Image addAtuadores;
	protected Image removeAtuadores;

	protected Component adicionaisBox;
	protected Listbox leftAdicionais;
	protected Listbox rightAdicionais;
	protected Image addAdicionais;
	protected Image removeAdicionais;

	protected Component estadoBox;
	protected Listbox leftEstados;
	protected Listbox rightEstados;
	protected Image addEstados;
	protected Image removeEstados;

	protected Component estado2Box;
	protected Listbox leftEstados2;
	protected Listbox rightEstados2;
	protected Image addEstados2;
	protected Image removeEstados2;

	protected Component pgrUploadBtn;
	protected Component downloadBox;
	protected Vbox pics;

	public ProjetoController() {
		super(new Projeto());

		grupoMercadoriaController = new GrupoMercadoriaController(this);
		enderecoController = new EnderecoController(this);
		escoltaArmadaTrajetoController = new EscoltaArmadaTrajetoController(
				this);
	}

	public List<Fornecedor> getSeguradoras() {
		return genericService.procurarTodos(Fornecedor.class);
	}
	
	public List<Fornecedor> getCorretoras() {
		return genericService.procurarTodos(Fornecedor.class);
	}

	@SuppressWarnings({ "rawtypes", "unchecked" })
	public void onClick$addUnidades(Event event) {
		Set items = leftUnidades.getSelectedItems();
		if (items.isEmpty()) {
			alert("Por favor, selecione um produto para ser adicionado!");
		} else {
			List al = new ArrayList(items);
			List<Unidade> unidades = new ArrayList(getUnidades());
			List<Unidade> unidadesRemover = new ArrayList<Unidade>();

			for (int i = 0; i < al.size(); i++) {
				Listitem li = (Listitem) al.get(i);
				li.setSelected(false);
				rightUnidades.appendChild(li);

				Unidade cliente = unidades.get(i);
				selected.getUnidades().add(cliente);
				unidadesRemover.add(cliente);
			}
			unidades.remove(unidadesRemover);
		}

		binder.loadComponent(unidadeBox);
	}

	@SuppressWarnings({ "rawtypes", "unchecked" })
	public void onClick$addRastreador(Event event) {
		Set items = leftRastreador.getSelectedItems();
		if (items.isEmpty()) {
			alert("Por favor, selecione um produto para ser adicionado!");
		} else {
			List al = new ArrayList(items);
			List<Rastreador> rastreadors = new ArrayList(getRastreadores());
			List<Rastreador> rastreadorsRemover = new ArrayList<Rastreador>();

			for (int i = 0; i < al.size(); i++) {
				Listitem li = (Listitem) al.get(i);
				li.setSelected(false);
				rightRastreador.appendChild(li);

				Rastreador rastreador = rastreadors.get(i);
				selected.getRastreadores().add(rastreador);
				rastreadorsRemover.add(rastreador);
			}
			rastreadors.remove(rastreadorsRemover);
		}

		binder.loadComponent(rastreadorBox);
	}

	@SuppressWarnings({ "rawtypes", "unchecked" })
	public void onClick$addSensores(Event event) {
		Set items = leftSensores.getSelectedItems();
		if (items.isEmpty()) {
			alert("Por favor, selecione um produto para ser adicionado!");
		} else {
			List al = new ArrayList(items);
			List<Sensor> sensors = new ArrayList(getSensores());
			List<Sensor> sensorsRemover = new ArrayList<Sensor>();

			for (int i = 0; i < al.size(); i++) {
				Listitem li = (Listitem) al.get(i);
				li.setSelected(false);
				rightSensores.appendChild(li);

				Sensor sensor = sensors.get(i);
				selected.getSensors().add(sensor);
				sensorsRemover.add(sensor);
			}
			sensors.remove(sensorsRemover);
		}

		binder.loadComponent(sensoresBox);
	}

	@SuppressWarnings({ "rawtypes", "unchecked" })
	public void onClick$addAtuadores(Event event) {
		Set items = leftAtuadores.getSelectedItems();
		if (items.isEmpty()) {
			alert("Por favor, selecione um produto para ser adicionado!");
		} else {
			List al = new ArrayList(items);
			List<Atuador> atuadors = new ArrayList(getAtuadores());
			List<Atuador> atuadorsRemover = new ArrayList<Atuador>();

			for (int i = 0; i < al.size(); i++) {
				Listitem li = (Listitem) al.get(i);
				li.setSelected(false);
				rightAtuadores.appendChild(li);

				Atuador atuador = atuadors.get(i);
				selected.getAtuadors().add(atuador);
				atuadorsRemover.add(atuador);
			}
			atuadors.remove(atuadorsRemover);
		}

		binder.loadComponent(atuadoresBox);
	}

	@SuppressWarnings({ "rawtypes", "unchecked" })
	public void onClick$addAdicionais(Event event) {
		Set items = leftAdicionais.getSelectedItems();
		if (items.isEmpty()) {
			alert("Por favor, selecione um produto para ser adicionado!");
		} else {
			List al = new ArrayList(items);
			List<Adicional> adicionals = new ArrayList(getAdicionais());
			List<Adicional> adicionalsRemover = new ArrayList<Adicional>();

			for (int i = 0; i < al.size(); i++) {
				Listitem li = (Listitem) al.get(i);
				li.setSelected(false);
				rightAdicionais.appendChild(li);

				Adicional adicional = adicionals.get(i);
				selected.getAdicionals().add(adicional);
				adicionalsRemover.add(adicional);
			}
			adicionals.remove(adicionalsRemover);
		}

		binder.loadComponent(adicionaisBox);
	}

	@SuppressWarnings({ "rawtypes", "unchecked" })
	public void onClick$addEstados(Event event) {
		Set items = leftEstados.getSelectedItems();
		if (items.isEmpty()) {
			alert("Por favor, selecione um estado para ser adicionado!");
		} else {
			List al = new ArrayList(items);
			List<Estado> estados = new ArrayList(getEstados());
			List<Estado> estadosRemover = new ArrayList<Estado>();

			for (int i = 0; i < al.size(); i++) {
				Listitem li = (Listitem) al.get(i);
				li.setSelected(false);
				rightEstados.appendChild(li);

				Estado estado = estados.get(i);
				selected.getEstado().add(estado);
				estadosRemover.add(estado);
			}
			estados.remove(estadosRemover);
		}

		binder.loadComponent(estadoBox);
	}

	@SuppressWarnings({ "rawtypes", "unchecked" })
	public void onClick$addEstados2(Event event) {
		Set items = leftEstados2.getSelectedItems();
		if (items.isEmpty()) {
			alert("Por favor, selecione um estado para ser adicionado!");
		} else {
			List al = new ArrayList(items);
			List<Estado> estados = new ArrayList(getEstados2());
			List<Estado> estadosRemover = new ArrayList<Estado>();

			for (int i = 0; i < al.size(); i++) {
				Listitem li = (Listitem) al.get(i);
				li.setSelected(false);
				rightEstados2.appendChild(li);

				Estado estado = estados.get(i);
				selected.getEstado2().add(estado);
				estadosRemover.add(estado);
			}
			estados.remove(estadosRemover);
		}

		binder.loadComponent(estado2Box);
	}

	@SuppressWarnings({ "rawtypes", "unchecked" })
	public void onClick$removeUnidades(Event event) {
		Set items = rightUnidades.getSelectedItems();
		if (items.isEmpty()) {
			alert("Por favor, selecione um produto para ser removido!");
		} else {
			List al = new ArrayList(items);
			List<Unidade> kitUnidade = new ArrayList<Unidade>(
					selected.getUnidades());
			for (int i = 0; i < al.size(); i++) {
				Listitem li = (Listitem) al.get(i);
				li.setSelected(false);
				leftUnidades.appendChild(li);

				Unidade unidade = kitUnidade.get(i);
				getUnidades().add(unidade);
				selected.getUnidades().remove(unidade);
			}
			for (int i = 0; i < al.size(); i++) {
				Unidade unidade = kitUnidade.get(i);
				selected.getUnidades().remove(unidade);

			}
		}
		binder.loadComponent(unidadeBox);
	}

	@SuppressWarnings({ "rawtypes", "unchecked" })
	public void onClick$removeRastreador(Event event) {
		Set items = rightRastreador.getSelectedItems();
		if (items.isEmpty()) {
			alert("Por favor, selecione um produto para ser removido!");
		} else {
			List al = new ArrayList(items);
			List<Rastreador> kitRastreador = new ArrayList<Rastreador>(
					selected.getRastreadores());
			for (int i = 0; i < al.size(); i++) {
				Listitem li = (Listitem) al.get(i);
				li.setSelected(false);
				leftRastreador.appendChild(li);

				Rastreador rastreador = kitRastreador.get(i);
				getRastreadores().add(rastreador);
				selected.getRastreadores().remove(rastreador);
			}
			for (int i = 0; i < al.size(); i++) {
				Rastreador rastreador = kitRastreador.get(i);
				selected.getRastreadores().remove(rastreador);

			}
		}
		binder.loadComponent(rastreadorBox);
	}

	@SuppressWarnings({ "rawtypes", "unchecked" })
	public void onClick$removeSensores(Event event) {
		Set items = rightSensores.getSelectedItems();
		if (items.isEmpty()) {
			alert("Por favor, selecione um produto para ser removido!");
		} else {
			List al = new ArrayList(items);
			List<Sensor> kitSensor = new ArrayList<Sensor>(
					selected.getSensors());
			for (int i = 0; i < al.size(); i++) {
				Listitem li = (Listitem) al.get(i);
				li.setSelected(false);
				leftSensores.appendChild(li);

				Sensor sensor = kitSensor.get(i);
				getSensores().add(sensor);
				selected.getSensors().remove(sensor);
			}
			for (int i = 0; i < al.size(); i++) {
				Sensor sensor = kitSensor.get(i);
				selected.getSensors().remove(sensor);
			}
		}
		binder.loadComponent(sensoresBox);
	}

	@SuppressWarnings({ "rawtypes", "unchecked" })
	public void onClick$removeAtuadores(Event event) {
		Set items = rightAtuadores.getSelectedItems();
		if (items.isEmpty()) {
			alert("Por favor, selecione um produto para ser removido!");
		} else {
			List al = new ArrayList(items);
			List<Atuador> kitAtuador = new ArrayList<Atuador>(
					selected.getAtuadors());
			for (int i = 0; i < al.size(); i++) {
				Listitem li = (Listitem) al.get(i);
				li.setSelected(false);
				leftAtuadores.appendChild(li);

				Atuador atuador = kitAtuador.get(i);
				getAtuadores().add(atuador);
				selected.getAtuadors().remove(atuador);
			}
			for (int i = 0; i < al.size(); i++) {
				Atuador atuador = kitAtuador.get(i);
				selected.getAtuadors().remove(atuador);
			}
		}
		binder.loadComponent(atuadoresBox);
	}

	@SuppressWarnings({ "rawtypes", "unchecked" })
	public void onClick$removeAdicionais(Event event) {
		Set items = rightAdicionais.getSelectedItems();
		if (items.isEmpty()) {
			alert("Por favor, selecione um produto para ser removido!");
		} else {
			List al = new ArrayList(items);
			List<Adicional> kitAdicional = new ArrayList<Adicional>(
					selected.getAdicionals());
			for (int i = 0; i < al.size(); i++) {
				Listitem li = (Listitem) al.get(i);
				li.setSelected(false);
				leftAdicionais.appendChild(li);

				Adicional adicional = kitAdicional.get(i);
				getAdicionais().add(adicional);
				selected.getAdicionals().remove(adicional);
			}
			for (int i = 0; i < al.size(); i++) {
				Adicional adicional = kitAdicional.get(i);
				selected.getAdicionals().remove(adicional);
			}
		}
		binder.loadComponent(adicionaisBox);
	}

	@SuppressWarnings({ "rawtypes", "unchecked" })
	public void onClick$removeEstados(Event event) {
		Set items = rightEstados.getSelectedItems();
		if (items.isEmpty()) {
			alert("Por favor, selecione um estado para ser removido!");
		} else {
			List al = new ArrayList(items);
			List<Estado> kitEstado = new ArrayList<Estado>(selected.getEstado());
			for (int i = 0; i < al.size(); i++) {
				Listitem li = (Listitem) al.get(i);
				li.setSelected(false);
				leftEstados.appendChild(li);

				Estado estado = kitEstado.get(i);
				getEstados().add(estado);
				selected.getEstado().remove(estado);
			}
			for (int i = 0; i < al.size(); i++) {
				Estado estado = kitEstado.get(i);
				selected.getAdicionals().remove(estado);
			}
		}
		binder.loadComponent(estadoBox);
	}

	@SuppressWarnings({ "rawtypes", "unchecked" })
	public void onClick$removeEstados2(Event event) {
		Set items = rightEstados2.getSelectedItems();
		if (items.isEmpty()) {
			alert("Por favor, selecione um estado para ser removido!");
		} else {
			List al = new ArrayList(items);
			List<Estado> kitEstado = new ArrayList<Estado>(
					selected.getEstado2());
			for (int i = 0; i < al.size(); i++) {
				Listitem li = (Listitem) al.get(i);
				li.setSelected(false);
				leftEstados2.appendChild(li);

				Estado estado = kitEstado.get(i);
				getEstados2().add(estado);
				selected.getEstado2().remove(estado);
			}
			for (int i = 0; i < al.size(); i++) {
				Estado estado = kitEstado.get(i);
				selected.getEstado2().remove(estado);
			}
		}
		binder.loadComponent(estado2Box);
	}

	@SuppressWarnings({ "rawtypes", "unchecked" })
	public void onClick$addProject(Event event) {
		Set items = left.getSelectedItems();
		if (items.isEmpty()) {
			alert("Por favor, selecione um produto para ser adicionado!");
		} else {
			List al = new ArrayList(items);
			List<Cliente> conhecimentos = new ArrayList(getClientes());
			List<Cliente> conhecimentoRemover = new ArrayList<Cliente>();

			for (int i = 0; i < al.size(); i++) {
				Listitem li = (Listitem) al.get(i);
				li.setSelected(false);
				right.appendChild(li);

				Cliente cliente = conhecimentos.get(i);
				selected.getEmbarcadoresSegProprio().add(cliente);
				conhecimentoRemover.add(cliente);
			}
			conhecimentos.remove(conhecimentoRemover);
		}

		binder.loadComponent(clienteDetail);
	}

	@SuppressWarnings({ "rawtypes", "unchecked" })
	public void onClick$removeProject(Event event) {
		Set items = right.getSelectedItems();
		if (items.isEmpty()) {
			alert("Por favor, selecione um produto para ser removido!");
		} else {
			List al = new ArrayList(items);
			List<Cliente> kitManifesto = new ArrayList<Cliente>(
					selected.getEmbarcadoresSegProprio());
			for (int i = 0; i < al.size(); i++) {
				Listitem li = (Listitem) al.get(i);
				li.setSelected(false);
				left.appendChild(li);

				Cliente cliente = kitManifesto.get(i);
				getClientes().add(cliente);
				selected.getEmbarcadoresSegProprio().remove(cliente);
			}
			for (int i = 0; i < al.size(); i++) {
				Cliente Conhecimento = kitManifesto.get(i);
				selected.getEmbarcadoresSegProprio().remove(Conhecimento);

			}
		}

		binder.loadComponent(clienteDetail);
	}

	public void onClick$pgrUploadBtn(Event event) throws InterruptedException {
		org.zkoss.util.media.Media[] media = Fileupload.get(5);
		if (media != null) {

			String arquivosNamesSeparadoPorVirgula = selected
					.getArquivosNamesSeparadoPorVirgula();
			if (arquivosNamesSeparadoPorVirgula == null)
				arquivosNamesSeparadoPorVirgula = "";

			for (int j = 0; j < media.length; ++j) {

				boolean criarArquivo = ArquivoUtil.criarArquivo(
						media[j].getByteData(), media[j].getName(), PATH);

				if (!criarArquivo) {
					Messagebox.show("Arquivo " + media[j].getName()
							+ " não pode ser gravado.");
				}

				arquivosNamesSeparadoPorVirgula += media[j].getName() + ", ";

				Hbox hbox = new Hbox();
				Label label = new Label(media[j].getName());
				label.setAttribute("arquivo", media[j].getName());
				label.setParent(hbox);
				label.addEventListener("onClick", new EventListener() {
					@Override
					public void onEvent(Event event) throws Exception {
						downalodArquivo(event);

					}
				});
				Image remover = new Image("/img/png/delete-icon16x16.png");
				remover.setParent(hbox);
				remover.setAttribute("arquivo", media[j].getName());
				hbox.setParent(downloadBox);

				remover.addEventListener("onClick", new EventListener() {
					@Override
					public void onEvent(Event event) throws Exception {
						removerArquivo(event);

					}
				});
			}
			selected.setArquivosNamesSeparadoPorVirgula(arquivosNamesSeparadoPorVirgula);
		}

	}

	private void downalodArquivo(Event event) {
		String arquivoname = (String) event.getTarget().getAttribute("arquivo");
		java.io.InputStream is = ArquivoUtil.lerArquivo(PATH, arquivoname);

		if (is != null)
			Filedownload.save(is, "text/html", arquivoname);
		else
			alert("Não foi possivel acessar o arquivo " + arquivoname);

	}

	private void removerArquivo(final Event eventSuper)
			throws InterruptedException {
		final String arquivoname = (String) eventSuper.getTarget()
				.getAttribute("arquivo");

		Messagebox.show("Deseja excluir o arquivo " + arquivoname,
				"Deseja remover o arquivo", Messagebox.YES + Messagebox.NO,
				Messagebox.EXCLAMATION,
				new org.zkoss.zk.ui.event.EventListener() {
					@Override
					public void onEvent(Event event) {
						if ("onYes".equals(event.getName())) {

							selected.setArquivosNamesSeparadoPorVirgula(selected
									.getArquivosNamesSeparadoPorVirgula()
									.replace(arquivoname + ", ", ""));
							ArquivoUtil.excluirArquivo(PATH, arquivoname);

							eventSuper.getTarget().getParent()
									.setVisible(false);
						}
					}
				});
	}

	@SuppressWarnings("unchecked")
	public Collection<Cliente> getClientesReminders() {
		Set<Cliente> ctrcLista = selected.getEmbarcadoresSegProprio();

		if (ctrcLista == null || ctrcLista.isEmpty())
			return Collections.EMPTY_LIST;

		return ctrcLista;
	}

	public List<Cliente> getClientes() {
		List<Cliente> procurarTodos = genericService.procurarTodos(Cliente.class);
		procurarTodos.removeAll(selected.getEmbarcadoresSegProprio());

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

	public List<Rastreador> getRastreadores() {
		List<Rastreador> procurarTodos = genericService
				.procurarTodos(Rastreador.class);
		procurarTodos.removeAll(selected.getRastreadores());

		return procurarTodos;

	}

	public List<Sensor> getSensores() {

		List<Sensor> procurarTodos = genericService.procurarTodos(Sensor.class);
		procurarTodos.removeAll(selected.getSensors());

		return procurarTodos;
	}

	public List<Atuador> getAtuadores() {
		List<Atuador> procurarTodos = genericService
				.procurarTodos(Atuador.class);
		procurarTodos.removeAll(selected.getAtuadors());

		return procurarTodos;

	}

	public List<Adicional> getAdicionais() {
		List<Adicional> procurarTodos = genericService
				.procurarTodos(Adicional.class);
		procurarTodos.removeAll(selected.getAdicionals());

		return procurarTodos;
	}

	public List<Estado> getEstados() {

		List<Estado> procurarTodos = genericService.procurarTodos(Estado.class);
		procurarTodos.removeAll(selected.getEstado());

		return procurarTodos;
	}

	public List<Estado> getEstados2() {

		List<Estado> procurarTodos = genericService.procurarTodos(Estado.class);
		procurarTodos.removeAll(selected.getEstado2());

		return procurarTodos;
	}

	// Gett's and Sett's
	public List<Unidade> getUnidades() {
		List<Unidade> procurarTodos = genericService
				.procurarTodos(Unidade.class);
		procurarTodos.removeAll(selected.getUnidades());

		return procurarTodos;
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

	public Cliente getConhecimentoSelected() {
		return empresasSegurosProprioSelected;
	}

	public void setConhecimentoSelected(Cliente conhecimentoSelected) {
		this.empresasSegurosProprioSelected = conhecimentoSelected;
	}

	public Component getConhecimentoDetail() {
		return clienteDetail;
	}

	public void setConhecimentoDetail(Component conhecimentoDetail) {
		this.clienteDetail = conhecimentoDetail;
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

	public Cliente getEmpresasSegurosProprioSelected() {
		return empresasSegurosProprioSelected;
	}

	public Component getClienteDetail() {
		return clienteDetail;
	}

	public void setEmpresasSegurosProprioSelected(
			Cliente empresasSegurosProprioSelected) {
		this.empresasSegurosProprioSelected = empresasSegurosProprioSelected;
	}

	public void setClienteDetail(Component clienteDetail) {
		this.clienteDetail = clienteDetail;
	}

	public GrupoMercadoriaController getGrupoMercadoriaController() {
		return grupoMercadoriaController;
	}

	public void setGrupoMercadoriaController(
			GrupoMercadoriaController grupoMercadoriaController) {
		this.grupoMercadoriaController = grupoMercadoriaController;
	}

	public EnderecoController getEnderecoController() {
		return enderecoController;
	}

	public void setEnderecoController(EnderecoController enderecoController) {
		this.enderecoController = enderecoController;
	}

	public EscoltaArmadaTrajetoController getEscoltaArmadaTrajetoController() {
		return escoltaArmadaTrajetoController;
	}

	public void setEscoltaArmadaTrajetoController(
			EscoltaArmadaTrajetoController escoltaArmadaTrajetoController) {
		this.escoltaArmadaTrajetoController = escoltaArmadaTrajetoController;
	}

	public Component getUnidadeBox() {
		return unidadeBox;
	}

	public void setUnidadeBox(Component unidadeBox) {
		this.unidadeBox = unidadeBox;
	}

	public Listbox getLeftUnidades() {
		return leftUnidades;
	}

	public void setLeftUnidades(Listbox leftUnidades) {
		this.leftUnidades = leftUnidades;
	}

	public Listbox getRightUnidades() {
		return rightUnidades;
	}

	public void setRightUnidades(Listbox rightUnidades) {
		this.rightUnidades = rightUnidades;
	}

	public Image getAddUnidades() {
		return addUnidades;
	}

	public void setAddUnidades(Image addUnidades) {
		this.addUnidades = addUnidades;
	}

	public Image getRemoveUnidades() {
		return removeUnidades;
	}

	public void setRemoveUnidades(Image removeUnidades) {
		this.removeUnidades = removeUnidades;
	}

	public Component getRastreadorBox() {
		return rastreadorBox;
	}

	public void setRastreadorBox(Component rastreadorBox) {
		this.rastreadorBox = rastreadorBox;
	}

	public Listbox getLeftRastreador() {
		return leftRastreador;
	}

	public void setLeftRastreador(Listbox leftRastreador) {
		this.leftRastreador = leftRastreador;
	}

	public Listbox getRightRastreador() {
		return rightRastreador;
	}

	public void setRightRastreador(Listbox rightRastreador) {
		this.rightRastreador = rightRastreador;
	}

	public Image getAddRastreador() {
		return addRastreador;
	}

	public void setAddRastreador(Image addRastreador) {
		this.addRastreador = addRastreador;
	}

	public Image getRemoveRastreador() {
		return removeRastreador;
	}

	public void setRemoveRastreador(Image removeRastreador) {
		this.removeRastreador = removeRastreador;
	}

	public Component getSensoresBox() {
		return sensoresBox;
	}

	public void setSensoresBox(Component sensoresBox) {
		this.sensoresBox = sensoresBox;
	}

	public Listbox getLeftSensores() {
		return leftSensores;
	}

	public void setLeftSensores(Listbox leftSensores) {
		this.leftSensores = leftSensores;
	}

	public Listbox getRightSensores() {
		return rightSensores;
	}

	public void setRightSensores(Listbox rightSensores) {
		this.rightSensores = rightSensores;
	}

	public Image getAddSensores() {
		return addSensores;
	}

	public void setAddSensores(Image addSensores) {
		this.addSensores = addSensores;
	}

	public Image getRemoveSensores() {
		return removeSensores;
	}

	public void setRemoveSensores(Image removeSensores) {
		this.removeSensores = removeSensores;
	}

	public Component getAtuadoresBox() {
		return atuadoresBox;
	}

	public void setAtuadoresBox(Component atuadoresBox) {
		this.atuadoresBox = atuadoresBox;
	}

	public Listbox getLeftAtuadores() {
		return leftAtuadores;
	}

	public void setLeftAtuadores(Listbox leftAtuadores) {
		this.leftAtuadores = leftAtuadores;
	}

	public Listbox getRightAtuadores() {
		return rightAtuadores;
	}

	public void setRightAtuadores(Listbox rightAtuadores) {
		this.rightAtuadores = rightAtuadores;
	}

	public Image getAddAtuadores() {
		return addAtuadores;
	}

	public void setAddAtuadores(Image addAtuadores) {
		this.addAtuadores = addAtuadores;
	}

	public Image getRemoveAtuadores() {
		return removeAtuadores;
	}

	public void setRemoveAtuadores(Image removeAtuadores) {
		this.removeAtuadores = removeAtuadores;
	}

	public Component getAdicionaisBox() {
		return adicionaisBox;
	}

	public void setAdicionaisBox(Component adicionaisBox) {
		this.adicionaisBox = adicionaisBox;
	}

	public Listbox getLeftAdicionais() {
		return leftAdicionais;
	}

	public void setLeftAdicionais(Listbox leftAdicionais) {
		this.leftAdicionais = leftAdicionais;
	}

	public Listbox getRightAdicionais() {
		return rightAdicionais;
	}

	public void setRightAdicionais(Listbox rightAdicionais) {
		this.rightAdicionais = rightAdicionais;
	}

	public Image getAddAdicionais() {
		return addAdicionais;
	}

	public void setAddAdicionais(Image addAdicionais) {
		this.addAdicionais = addAdicionais;
	}

	public Image getRemoveAdicionais() {
		return removeAdicionais;
	}

	public void setRemoveAdicionais(Image removeAdicionais) {
		this.removeAdicionais = removeAdicionais;
	}

	public Component getPgrUploadBtn() {
		return pgrUploadBtn;
	}

	public void setPgrUploadBtn(Component pgrUploadBtn) {
		this.pgrUploadBtn = pgrUploadBtn;
	}

	public Vbox getPics() {
		return pics;
	}

	public void setPics(Vbox pics) {
		this.pics = pics;
	}

	public Component getEstadoBox() {
		return estadoBox;
	}

	public void setEstadoBox(Component estadoBox) {
		this.estadoBox = estadoBox;
	}

	public Listbox getLeftEstados() {
		return leftEstados;
	}

	public void setLeftEstados(Listbox leftEstados) {
		this.leftEstados = leftEstados;
	}

	public Listbox getRightEstados() {
		return rightEstados;
	}

	public void setRightEstados(Listbox rightEstados) {
		this.rightEstados = rightEstados;
	}

	public Image getAddEstados() {
		return addEstados;
	}

	public void setAddEstados(Image addEstados) {
		this.addEstados = addEstados;
	}

	public Image getRemoveEstados() {
		return removeEstados;
	}

	public void setRemoveEstados(Image removeEstados) {
		this.removeEstados = removeEstados;
	}

	public Component getEstado2Box() {
		return estado2Box;
	}

	public void setEstado2Box(Component estado2Box) {
		this.estado2Box = estado2Box;
	}

	public Listbox getLeftEstados2() {
		return leftEstados2;
	}

	public void setLeftEstados2(Listbox leftEstados2) {
		this.leftEstados2 = leftEstados2;
	}

	public Listbox getRightEstados2() {
		return rightEstados2;
	}

	public void setRightEstados2(Listbox rightEstados2) {
		this.rightEstados2 = rightEstados2;
	}

	public Image getAddEstados2() {
		return addEstados2;
	}

	public void setAddEstados2(Image addEstados2) {
		this.addEstados2 = addEstados2;
	}

	public Image getRemoveEstados2() {
		return removeEstados2;
	}

	public void setRemoveEstados2(Image removeEstados2) {
		this.removeEstados2 = removeEstados2;
	}

	public Component getDownloadBox() {
		return downloadBox;
	}

	public void setDownloadBox(Component downloadBox) {
		this.downloadBox = downloadBox;
	}

	public static String getPath() {
		return PATH;
	}
}
