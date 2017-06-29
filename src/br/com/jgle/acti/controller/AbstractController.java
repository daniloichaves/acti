package br.com.jgle.acti.controller;

import java.io.Serializable;
import java.util.ArrayList;
import java.util.Calendar;
import java.util.Collection;
import java.util.Comparator;
import java.util.LinkedList;
import java.util.List;
import java.util.Map;

import javax.annotation.Resource;
import javax.persistence.EntityNotFoundException;

import org.springframework.dao.DataIntegrityViolationException;
import org.zkoss.lang.Strings;
import org.zkoss.zk.ui.Component;
import org.zkoss.zk.ui.event.Event;
import org.zkoss.zk.ui.event.EventListener;
import org.zkoss.zk.ui.event.Events;
import org.zkoss.zk.ui.event.ForwardEvent;
import org.zkoss.zk.ui.event.KeyEvent;
import org.zkoss.zk.ui.event.SelectEvent;
import org.zkoss.zk.ui.util.GenericForwardComposer;
import org.zkoss.zkplus.databind.DataBinder;
import org.zkoss.zul.Caption;
import org.zkoss.zul.Combobox;
import org.zkoss.zul.Comboitem;
import org.zkoss.zul.FieldComparator;
import org.zkoss.zul.Image;
import org.zkoss.zul.Include;
import org.zkoss.zul.Label;
import org.zkoss.zul.Listbox;
import org.zkoss.zul.Listheader;
import org.zkoss.zul.Messagebox;
import org.zkoss.zul.Paging;
import org.zkoss.zul.Textbox;
import org.zkoss.zul.Vbox;
import org.zkoss.zul.Window;
import org.zkoss.zul.event.PagingEvent;

import br.com.jgle.acti.component.FiltroVO;
import br.com.jgle.acti.component.SearchAdvancedHBox;
import br.com.jgle.acti.entity.AbstractEntity;
import br.com.jgle.acti.entity.LogAcesso;
import br.com.jgle.acti.entity.Login;
import br.com.jgle.acti.service.GenericService;
import br.com.jgle.acti.util.ExcelUtil;

import com.sun.istack.internal.NotNull;

//GenericAutowireComposer 
public class AbstractController<T extends AbstractEntity> extends
		GenericForwardComposer implements Serializable {

	private static final long serialVersionUID = 1L;

	protected int _pageSize = 10;
	protected int _startPageNumber = 0;
	protected Paging userPaging;
	private boolean _needsTotalSizeUpdate = true;

	@Resource
	protected Login login;

	// ZK databinder
	protected DataBinder binder;

	@Resource
	protected GenericService genericService;

	@SuppressWarnings("rawtypes")
	protected AbstractController parent;

	// main control window
	protected Window entityWin; // main window
	protected Collection<T> list; // domain object summary list
	protected Listbox entityList; // domain object summary list
	protected Component entityDetail; // domain object detail
	protected Include includeDetail;

	// Search
	protected Textbox entitySearch; // domain object for filter search
	protected Component imageSearch; // new button
	protected Vbox boxBuscaAvancada;
	protected Component imageSearchAvancada;
	// Advanced
	protected Combobox atributoLabel;
	protected Label trocarView;

	// edit mode
	protected Component entityEdit; // edit panel

	@NotNull
	protected T selected;

	// buttons
	protected Component entityCreate; // new button
	// protected Component entityUpdate; // edit button
	protected Component entityUpdateQuick; // edit button
	protected Component entityDelete; // delete button
	protected Component entityDeleteQuick; // delete button
	protected Component entitySave; // save button
	protected Component entityCancel; // cancel button

	// operation transient state
	protected T _tmpSelected; // store original selected entity
	protected boolean _create; // when new a entity
	protected boolean _search; // switch to edit mode when doing
	protected boolean _deleteMode; // switch to edit mode when doing
	protected boolean _editMode; // switch to edit mode when doing
									// editing(new/update)
	protected int _lastSelectedIndex = -1; // last selectedIndex before delete

	@SuppressWarnings("rawtypes")
	protected transient final Class entityClass;

	// Variavel de controle para não executar o bind novamente nos objetos
	private boolean _initializer = true;

	@SuppressWarnings("rawtypes")
	private AbstractController() {
		entityClass = (Class) ((java.lang.reflect.ParameterizedType) this
				.getClass().getGenericSuperclass()).getActualTypeArguments()[0];
	}

	public AbstractController(T entity) {
		this();
		selected = entity.newInstance();

		atributoLabel = new Combobox();
		atributoLabel.setId("atributoLabel");
		if (atributoLabel.getChildren().size() < 1) {
			Map<String, String> labelValues = selected
					.getParametrosAdvancedSearch();
			for (String key : labelValues.keySet()) {
				Comboitem comboitem = new Comboitem();
				comboitem.setLabel(labelValues.get(key));
				comboitem.setValue(key);
				comboitem.setParent(atributoLabel);
			}
		}

	}

	public AbstractController(T entity,
			AbstractController<AbstractEntity> parent) {
		this();
		selected = entity.newInstance();
		this.parent = parent;
		this.genericService = parent.genericService;

	}

	@SuppressWarnings({ "rawtypes" })
	public Collection<AbstractController> getControllerList() {
		return new ArrayList<AbstractController>();
	}

	protected Caption caption;
	protected Combobox sizeCombobox;
	@Override
	public void doAfterCompose(Component comp) throws Exception {
		super.doAfterCompose(comp);
		_startPageNumber = 0;
		
		if(caption == null) {
			
			caption = new Caption();
			Image excelImage = new Image("/img/png/Excel-icon24x24.png");
			excelImage.addEventListener("onClick", new EventListener() {
				@Override
				public void onEvent(Event arg0) throws Exception {
					ExcelUtil.export_to_csv(entityList);
				}
			});
			
			
			sizeCombobox =  new Combobox("10");
			sizeCombobox.addEventListener("onChange", new EventListener() {
				@Override
				public void onEvent(Event event) throws Exception {
					_pageSize = (Integer) sizeCombobox.getSelectedItem().getValue();
					_startPageNumber = 0;
					if(userPaging != null)
						getRemindersLimited();
					else {
						entityList.setAutopaging(true);
						entityList.setPageSize(_pageSize);
					}
					refreshModel();	
				}
			});
			sizeCombobox.setWidth("50px");
			Comboitem comboitem10 = new Comboitem("10");
			comboitem10.setValue(10);
			Comboitem comboitem15 = new Comboitem("15");
			comboitem15.setValue(15);
			Comboitem comboitem30 = new Comboitem("30");
			comboitem30.setValue(30);
			Comboitem comboitem50 = new Comboitem("50");
			comboitem50.setValue(50);
			sizeCombobox.appendChild(comboitem10);
			sizeCombobox.appendChild(comboitem15);
			sizeCombobox.appendChild(comboitem30);
			sizeCombobox.appendChild(comboitem50);

			caption.appendChild(sizeCombobox);
			caption.appendChild(excelImage);
			entityWin.appendChild(caption);
		}
	}

	@SuppressWarnings("unchecked")
	public Collection<T> getReminders() {
		// For Parent
		if (parent != null) {
			return parent.getSelected().getList(selected);
		}
		// For search
		if (_search) {
			return list;
		}
		list = genericService.procurarTodos(entityClass, _pageSize);
		return list;
	}

	@SuppressWarnings("unchecked")
	public Collection<T> getRemindersLimited() {
		// For Parent
		if (parent != null) {
			return parent.getSelected().getList(selected);
		}
		// For search
		if (_search) {
			return list;
		}

		userPaging.setPageSize(_pageSize);
		Integer totalSize = genericService.procurarBuscaAvancadaTotal(entityClass, null);
		userPaging.setTotalSize(totalSize);
		list = genericService.procurarBuscaAvancada(entityClass, null,
				_startPageNumber, _pageSize, "desc", "dataAlteracao");

		return list;
	}

	public void refreshModel() {
		binder.loadAttribute(entityList, "model"); // reload model to force

	}

	public void onPaging$userPaging(ForwardEvent event) {
		final PagingEvent pe = (PagingEvent) event.getOrigin();
		_startPageNumber = pe.getActivePage();

		refreshModel();
	}

	// doOk
	public void doOk$entityWin(Event event) {
		makeSearch();
	}

	public void onChanging$entitySearch() {
		if (entitySearch.getValue().length() > 2) {
			makeSearch();
		}
	}

	public void onClick$imageSearchAvancada() {
		if (parent != null)
			return;
		makeSearchAvancada();
	}

	public void onClick$imageSearch() {
		makeSearch();
	}

	public void onClick$imageCreate() {
		makeSearch();
	}

	@SuppressWarnings({ "rawtypes", "unchecked" })
	public void makeSearch() {
		if (genericService == null)
			genericService = parent.getGenericService();

		list = genericService
				.procurarSimples(selected, entitySearch.getValue());
		saveAcessoLog("BUSCA", selected.getId());
		_search = true;
		refreshModel();
		final Collection model = (Collection) entityList.getModel();
		if (!model.isEmpty()) {
			selected = (T) model.iterator().next();
			binder.loadComponent(entityDetail);
		}
		setEditMode(false);
	}

	@SuppressWarnings({ "unchecked", "rawtypes" })
	public void makeSearchAvancada() {
		List<FiltroVO> filtroVOs = new ArrayList<FiltroVO>();
		for (Object comp : boxBuscaAvancada.getChildren()) {
			if (comp instanceof SearchAdvancedHBox) {
				SearchAdvancedHBox sah = (SearchAdvancedHBox) comp;
				filtroVOs.add(sah.getFitlro());
			}
		}
		if (filtroVOs.size() > 0) {
			if (genericService == null)
				genericService = parent.getGenericService();

			if (parent != null)
				list = (Collection<T>) genericService.procurarBuscaAvancada(
						parent.getSelected().getClass(), filtroVOs, 0, 100, "");
			else
				list = (Collection<T>) genericService.procurarBuscaAvancada(
						selected.getClass(), filtroVOs, 0, 100, "");

			saveAcessoLog("BUSCA", selected.getId());
			_search = true;
			refreshModel();
			final Collection model = (Collection) entityList.getModel();
			if (!model.isEmpty()) {
				selected = (T) model.iterator().next();
				binder.loadComponent(entityDetail);
			}
			setEditMode(false);
		}

	}

	// -- Initialization --//
	// @On("todoWin.onCreate") OK onCreate$entityWin
	@SuppressWarnings({ "unchecked", "rawtypes" })
	public void onCreate$entityWin() {
		if (_initializer) {
			_initializer = false;
			binder = (DataBinder) entityWin.getAttribute("binder", true);
			final Collection model = (Collection) entityList.getModel();
			if (!model.isEmpty()) {
				selected = (T) model.iterator().next();
				binder.loadComponent(entityDetail);
			}
			setFocus();

			saveAcessoLog("Lista", null);
		}
		_search = false;
	}

	// -- view mode control --//

	// @On("todoCreate.onClick") OK
	public void onClick$entityCreate(Event event) {
		// prepare a new Todo
		_tmpSelected = selected;
		_create = true;
		selected = selected.newInstance();

		// switch to edit mode
		setEditMode(true);
	}

	// // @On("todoUpdate.onClick") Edit
	// public void onClick$entityUpdate(Event event) {
	// if (isViewMode()) {
	// if (selected != null) {
	// _create = false;
	//
	// // switch to edit mode
	// setEditMode(true);
	// }
	// }
	// }
	// @On("todoDelete.onClick")
	public void onClick$entityDelete(Event event) {
		if (isViewMode()) {
			if (selected != null) {
				_create = false;
				newConfirmDelete().show();
			}
		}
	}

	public void onClick$entityUpdateQuick(Event event) {
		if (isViewMode()) {
			if (selected != null) {
				_create = false;

				// switch to edit mode
				setEditMode(true);
			}
		}
	}

	// @On("todoDelete.onClick")
	public void onClick$entityDeleteQuick(Event event)
			throws InterruptedException {

		checkDelete();

		if (!messagesRemoveError.isEmpty()) {
			Messagebox.show(messagesRemoveError.toString());
			messagesRemoveError.clear();
			return;
		}

		if (isViewMode() && isDeleteMode()) {
			_create = false;
			_deleteMode = true;
			newConfirmDelete().show();
		}
	}

	public void checkDelete() throws InterruptedException {
		return;
	}

	@SuppressWarnings("rawtypes")
	public boolean isEmpty(Collection lista) {
		if (lista == null || lista.isEmpty())
			return true;
		return false;
	}

	protected List<String> messagesRemoveError = new LinkedList<String>();
	public static final String TEMPLATE_MESSAGE_ERROR = "Registro não pode ser removido. Verificar cadastro de ";

	public boolean addMessageRemoveError(String cadastroError) {
		return messagesRemoveError.add(TEMPLATE_MESSAGE_ERROR + cadastroError
				+ "\n\n");
	}

	// -- edit mode control --//
	// @On("todoSave.onClick,todoWin.onOK")
	@SuppressWarnings("unchecked")
	public void onClick$entitySave(Event event) {
		if (isEditMode()) {

			// save into bean
			// if (parent == null)
			// binder.saveComponent(entityEdit); // reload model to force
			// refresh

			// store into db
			if (_create) {
				// For Parent
				if (parent != null)
					parent.getSelected().getList(selected).add(selected);
				else {
					genericService.inserir(selected);
					saveAcessoLog("INSERCAO", selected.getId());
				}

				// this.todoModel.persist();
			} else {
				try {
					if (parent != null)
						parent.getGenericService().atualizar(
								parent.getSelected());
					else
						genericService.atualizar(selected);
					saveAcessoLog("ATUALIZACAO", selected.getId());
					// this.todoModel.merge();
				} catch (EntityNotFoundException e1) {
					try {
						Messagebox.show(getUpdateDeletedMessage());
					} catch (Exception e2) {
						// ignore
					}
				}
			}
			// refresh the todoList
			refreshModel();
			// switch to view mode
			setEditMode(false);
		}
	}

	// @On("todoCancel.onClick,todoWin.onCancel")
	public void onClick$entityCancel(Event event) {
		if (isEditMode()) {
			// restore to original selected Todo if cancel from new
			if (_create) {
				selected = _tmpSelected;
				_tmpSelected = _tmpSelected.newInstance();
			}

			// switch to view mode
			setEditMode(false);
		}
	}

	// @On("todoList.onSelect") OK
	public void onSelect$entityList(Event event) {
		final int index = entityList.getSelectedIndex();
		if (index >= 0) {
			_lastSelectedIndex = index;
			_create = false;
		}
	}

	// @On("todoWin.onCtrlKey")
	@SuppressWarnings("rawtypes")
	public void doCtrlKey$entityWin(Event event) {
		final Collection items = entityList.getItems();
		if (!items.isEmpty() && (!_editMode || !_create)) {
			final int keycode = ((KeyEvent) event).getKeyCode();
			if (keycode == KeyEvent.DOWN || keycode == KeyEvent.UP) {
				// handle no selected item case
				if (entityList.getSelectedIndex() < 0) { // no selected item
					// try our best to guess one
					if (_lastSelectedIndex >= 0) {
						final int index = Math.min(items.size() - 1,
								_lastSelectedIndex);
						entityList.setSelectedIndex(index);
						Events.sendEvent(new SelectEvent("onSelect",
								entityList, entityList.getSelectedItems()));
					}
				}
				entityList.focus();
			}
		}
	}

	// -- view/edit mode --//
	public void setEditMode(boolean b) {
		_editMode = b;
		switchMode();
	}

	public boolean isViewMode() {
		return !_editMode;
	}

	public boolean isDeleteMode() {
		return !_deleteMode;
	}

	public boolean getViewMode() {
		return isViewMode();
	}

	public boolean isEditMode() {
		return _editMode;
	}

	public boolean isCreate() {
		return _create;
	}

	public boolean getCreate() {
		return _create;
	}

	public boolean isNotSelected() {
		return this.selected == null;
	}

	public boolean getNotSelected() {
		return this.selected == null;
	}

	private void switchMode() {
		binder.loadComponent(entityDetail); // reload visible to force refresh
		setFocus();
	}

	@SuppressWarnings("rawtypes")
	private void setFocus() {
		if (_editMode) {
			// name.focus();
			// entityEdit.setFocus(true);
		} else {
			if (((Collection) entityList.getModel()).isEmpty()) { // no result
																	// in
				// list, focus on
				// new button entityCreate.focus();
			} else {
				if (_create) {
					// entityCreate.focus();
					// entityEdit.setFocus(true);
				} else {
					entityList.focus();
				}
			}
		}
	}

	// -- sorting --//
	// @On("todoNameSort.onSort,todoDateSort.onSort,todoPrioritySort.onSort")
	@SuppressWarnings({ "rawtypes", "unused" })
	public void onSort$entityList(Event event) {
		final Listheader lh = (Listheader) event.getTarget();
		final String sortDirection = lh.getSortDirection(); // original
															// direction
		if ("ascending".equals(sortDirection)) {
			final Comparator cmpr = lh.getSortDescending();
			if (cmpr instanceof FieldComparator) {
				final String orderBy = ((FieldComparator) cmpr).getOrderBy();
				// TODO Verificar
				// todoModel.setOrderBy(orderBy); // update query string
			}
		} else if ("descending".equals(sortDirection)
				|| "natural".equals(sortDirection)
				|| Strings.isBlank(sortDirection)) {
			final Comparator cmpr = lh.getSortAscending();
			if (cmpr instanceof FieldComparator) {
				final String orderBy = ((FieldComparator) cmpr).getOrderBy();
				// TODO Verificar
				// todoModel.setOrderBy(orderBy); // update query string
			}
		}
	}

	// --To be override--//
	/** The info message when end user trying to update a "deleted" entity. */
	protected String getUpdateDeletedMessage() {
		return "Não pode encontrar o item selecionado, registro pode ter sido excluído por outros.";
	}

	/** Get a instance of ConfirmDelete class */
	protected ConfirmDelete newConfirmDelete() {
		return new ConfirmDelete();
	}

	/** Delete Confirmation */
	protected class ConfirmDelete {
		/** Show the ConfirmDelete Messagebox */
		public void show() {
			try {
				Messagebox.show(getMessage(), getTitle(), Messagebox.YES
						+ Messagebox.NO, Messagebox.EXCLAMATION,
						new org.zkoss.zk.ui.event.EventListener() {
							public void onEvent(Event event) {
								if ("onYes".equals(event.getName())) {
									doYes();
								}
								_deleteMode = false;
							}
						});
			} catch (Exception ex) {
				// ignore
			}
		}

		/**
		 * Operation when end user click Yes button in confirm delete Messagebox
		 */
		public void doYes() {
			try {
				//saveAcessoLog("REMOCAO", selected.getId());
				// For Parent
				if (parent != null)
					parent.getSelected().getList(selected).remove(selected);
				else {
					if (_tmpSelected == null)
						_tmpSelected = selected.newInstance();
					try {
						genericService.remover(selected);
					} catch (DataIntegrityViolationException e) {
						try {
							Messagebox.show("Registro em uso e não pode ser removido.");
						} catch (Exception e1) {
							e1.printStackTrace();
						}
					}
					// entityCreate.focus();
				}
			} catch (EntityNotFoundException e) {
				// ignore, already deleted by others
			}
			selected = _tmpSelected;
			// refresh the todoList
			refreshModel();
			// update the todoDetail
			switchMode();
		}

		/** Returns title of confirm deleting Messagebox */
		public String getTitle() {
			return "Deletar o registro?";
		}

		/** Returns message for confirm deleting Messagbox */
		public String getMessage() {
			return "Você tem certeza que quer deletar esse registro?";
		}
	}

	/** Register log Acesso **/
	public void saveAcessoLog(String acao, Integer id) {
		LogAcesso acesso = new LogAcesso();
		acesso.setAcao(LogAcesso.ACAO_VISUALIZACAO);
		acesso.setDataHora(Calendar.getInstance().getTime());
		acesso.setIp(session.getRemoteAddr());
		acesso.setIdentificador(id);

		String pagina = this.toString().replace("br.com.jgle.acti.controller.",
				"");
		acesso.setPagina(pagina.substring(0, pagina.indexOf('@')));
		acesso.setAcao(acao);

		if (login != null && login.getId() != null) {
			acesso.setLogin(login);
			acesso.setNome(login.getNome());
			acesso.setUnidade(login.getUnidade());
		}
		// genericService.inserir(acesso);
	}

	// #### Gett's and Sett's #####
	public void setEntityCreate(Image entityCreate) {
		this.entityCreate = entityCreate;
	}

	public void setEntityDelete(Image entityDelete) {
		this.entityDelete = entityDelete;
	}

	public void setEntitySave(Image entitySave) {
		this.entitySave = entitySave;
	}

	public void setEntityCancel(Image entityCancel) {
		this.entityCancel = entityCancel;
	}

	public GenericService getGenericService() {
		return genericService;
	}

	public void setGenericService(GenericService genericService) {
		this.genericService = genericService;
	}

	public T getSelected() {
		return selected;
	}

	public void setSelected(T selected) {
		this.selected = selected;
	}

	public DataBinder getBinder() {
		return binder;
	}

	public void setBinder(DataBinder binder) {
		this.binder = binder;
	}

	public Window getEntityWin() {
		return entityWin;
	}

	public void setEntityWin(Window entityWin) {
		this.entityWin = entityWin;
	}

	public Listbox getEntityList() {
		return entityList;
	}

	public void setEntityList(Listbox entityList) {
		this.entityList = entityList;
	}

	public Component getEntityDetail() {
		return entityDetail;
	}

	public void setEntityDetail(Component entityDetail) {
		this.entityDetail = entityDetail;
	}

	public Component getEntityEdit() {
		return entityEdit;
	}

	public void setEntityEdit(Window entityEdit) {
		this.entityEdit = entityEdit;
	}

	public Component getEntityCreate() {
		return entityCreate;
	}

	public Component getEntityDelete() {
		return entityDelete;
	}

	public void setEntityDelete(Component entityDelete) {
		this.entityDelete = entityDelete;
	}

	public Component getEntitySave() {
		return entitySave;
	}

	public void setEntitySave(Component entitySave) {
		this.entitySave = entitySave;
	}

	public Component getEntityCancel() {
		return entityCancel;
	}

	public void setEntityCancel(Component entityCancel) {
		this.entityCancel = entityCancel;
	}

	public T get_tmpSelected() {
		return _tmpSelected;
	}

	public void set_tmpSelected(T _tmpSelected) {
		this._tmpSelected = _tmpSelected;
	}

	public boolean is_create() {
		return _create;
	}

	public void set_create(boolean _create) {
		this._create = _create;
	}

	public boolean is_editMode() {
		return _editMode;
	}

	public boolean getEditMode() {
		return _editMode;
	}

	public void set_editMode(boolean _editMode) {
		this._editMode = _editMode;
	}

	public int get_lastSelectedIndex() {
		return _lastSelectedIndex;
	}

	public void set_lastSelectedIndex(int _lastSelectedIndex) {
		this._lastSelectedIndex = _lastSelectedIndex;
	}

	public static long getSerialversionuid() {
		return serialVersionUID;
	}

	@SuppressWarnings("rawtypes")
	public Class getEntityClass() {
		return entityClass;
	}

	public Component getEntityUpdateQuick() {
		return entityUpdateQuick;
	}

	public void setEntityUpdateQuick(Component entityUpdateQuick) {
		this.entityUpdateQuick = entityUpdateQuick;
	}

	public Component getEntityDeleteQuick() {
		return entityDeleteQuick;
	}

	public void setEntityDeleteQuick(Component entityDeleteQuick) {
		this.entityDeleteQuick = entityDeleteQuick;
	}

	public void setEntityCreate(Component entityCreate) {
		this.entityCreate = entityCreate;
	}

	public void setEntityEdit(Component entityEdit) {
		this.entityEdit = entityEdit;
	}

	public Textbox getEntitySearch() {
		return entitySearch;
	}

	public void setEntitySearch(Textbox entitySearch) {
		this.entitySearch = entitySearch;
	}

	public Collection<T> getList() {
		return list;
	}

	public void setList(Collection<T> list2) {
		this.list = list2;
	}

	@SuppressWarnings("rawtypes")
	public AbstractController getParent() {
		return parent;
	}

	public void setParent(
			@SuppressWarnings("rawtypes") AbstractController parent) {
		this.parent = parent;
	}

	public Component getImageSearch() {
		return imageSearch;
	}

	public void setImageSearch(Component imageCreate) {
		this.imageSearch = imageCreate;
	}

	public Component getImageCreate() {
		return imageSearch;
	}

	public void setImageCreate(Component imageCreate) {
		this.imageSearch = imageCreate;
	}

	public boolean is_search() {
		return _search;
	}

	public void set_search(boolean _search) {
		this._search = _search;
	}

	public boolean is_initializer() {
		return _initializer;
	}

	public void set_initializer(boolean _initializer) {
		this._initializer = _initializer;
	}

	public Login getUsuario() {
		return login;
	}

	public void setUsuario(Login usuario) {
		this.login = usuario;
	}

	public Login getLogin() {
		return login;
	}

	public void setLogin(Login login) {
		this.login = login;
	}

	public Label getTrocarView() {
		return trocarView;
	}

	public void setTrocarView(Label trocarView) {
		this.trocarView = trocarView;
	}

	public Combobox getAtributoLabel() {
		return atributoLabel;
	}

	public void setAtributoLabel(Combobox atributoLabel) {
		this.atributoLabel = atributoLabel;
	}

	public Vbox getBoxBuscaAvancada() {
		return boxBuscaAvancada;
	}

	public void setBoxBuscaAvancada(Vbox boxBuscaAvancada) {
		this.boxBuscaAvancada = boxBuscaAvancada;
	}

	public void setImageSearchAvancada(Image imageSearchAvancada) {
		this.imageSearchAvancada = imageSearchAvancada;
	}

	public Component getImageSearchAvancada() {
		return imageSearchAvancada;
	}

	public void setImageSearchAvancada(Component imageSearchAvancada) {
		this.imageSearchAvancada = imageSearchAvancada;
	}

	public Include getIncludeDetail() {
		return includeDetail;
	}

	public void setIncludeDetail(Include includeDetail) {
		this.includeDetail = includeDetail;
	}

	public int get_startPageNumber() {
		return _startPageNumber;
	}

	public void set_startPageNumber(int _startPageNumber) {
		this._startPageNumber = _startPageNumber;
	}

	public int get_pageSize() {
		return _pageSize;
	}
	
	public int getPageSize() {
		return _pageSize;
	}

	public Paging getUserPaging() {
		return userPaging;
	}

	public void setUserPaging(Paging userPaging) {
		this.userPaging = userPaging;
	}

	public boolean is_needsTotalSizeUpdate() {
		return _needsTotalSizeUpdate;
	}

	public void set_needsTotalSizeUpdate(boolean _needsTotalSizeUpdate) {
		this._needsTotalSizeUpdate = _needsTotalSizeUpdate;
	}
}
