package br.com.jgle.acti.controller;

import java.util.Collection;
import java.util.Comparator;

import javax.persistence.EntityNotFoundException;

import org.zkoss.lang.Strings;
import org.zkoss.zk.ui.Component;
import org.zkoss.zk.ui.event.Event;
import org.zkoss.zk.ui.event.Events;
import org.zkoss.zk.ui.event.KeyEvent;
import org.zkoss.zk.ui.event.SelectEvent;
import org.zkoss.zk.ui.util.GenericForwardComposer;
import org.zkoss.zkplus.databind.DataBinder;
import org.zkoss.zul.FieldComparator;
import org.zkoss.zul.Image;
import org.zkoss.zul.Listbox;
import org.zkoss.zul.Listheader;
import org.zkoss.zul.Messagebox;
import org.zkoss.zul.Textbox;
import org.zkoss.zul.Window;

import br.com.jgle.acti.entity.AbstractEntity;

//GenericAutowireComposer 
public class AbstractListController<K extends AbstractEntity, T extends AbstractEntity> extends GenericForwardComposer {

	private static final long serialVersionUID = 1L;

	// ZK databinder
	protected DataBinder binder;

	// main control window
	protected Window entityWin; // main window
	protected Collection<T> list; // domain object summary list
	protected Listbox entityList; // domain object summary list
	protected Component entityDetail; // domain object detail

	// Search
	protected Textbox entitySearch; // domain object for filter search
	protected Component imageCreate; // new button

	// edit mode
	protected Component entityEdit; // edit panel

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
	protected boolean _editMode; // switch to edit mode when doing
									// editing(new/update)
	protected int _lastSelectedIndex = -1; // last selectedIndex before delete

	@SuppressWarnings("rawtypes")
	protected transient final Class entityClass;

	// Variavel de controle para não executar o bind novamente nos objetos
	private boolean _initializer = true;

	private String nameList;

	private K entity;

	@SuppressWarnings("rawtypes")
	private AbstractListController() {
		entityClass = (Class) ((java.lang.reflect.ParameterizedType) this.getClass().getGenericSuperclass()).getActualTypeArguments()[0];
	}

	public AbstractListController(K entity, T selected, String nameList) {
		this();

		this.entity = (K) entity;
		this.selected = selected.newInstance();
		this.nameList = nameList;

	}

	@SuppressWarnings("unchecked")
	public Collection<T> getReminders() {
		list = entity.getList(nameList);

		return list;
	}

	public void refreshModel() {
		binder.loadAttribute(entityList, "model"); // reload model to force
		// binder.loadAttribute(entityDetail, "model"); // reload model to force
		// refresh

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

	public void onClick$imageCreate() {
		makeSearch();
	}

	@SuppressWarnings({ "rawtypes", "unchecked" })
	public void makeSearch() {
		// list = genericService.procurarSimples(selected,
		// entitySearch.getValue());
		list = selected.getList(nameList);
		_search = true;
		refreshModel();
		final Collection model = (Collection) entityList.getModel();
		if (!model.isEmpty()) {
			selected = (T) model.iterator().next();
			binder.loadComponent(entityDetail);
		}
		setEditMode(false);
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
	public void onClick$entityDeleteQuick(Event event) {
		if (isViewMode()) {
			if (selected != null) {
				_create = false;
				newConfirmDelete().show();
			}
		}
	}

	// -- edit mode control --//
	// @On("todoSave.onClick,todoWin.onOK")
	public void onClick$entitySave(Event event) {
		if (isEditMode()) {

			// save into bean
			binder.saveComponent(entityEdit); // reload model to force refresh

			// store into db
			if (_create) {
				// genericService.inserir(selected);
				list.add(selected);
				// this.todoModel.persist();
			} else {
				try {
					// /genericService.atualizar(selected);
					// this.todoModel.merge();
				} catch (EntityNotFoundException e1) {
					try {
						Messagebox.show(getUpdateDeletedMessage());
					} catch (InterruptedException e2) {
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
				_tmpSelected = null;
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
						final int index = Math.min(items.size() - 1, _lastSelectedIndex);
						entityList.setSelectedIndex(index);
						Events.sendEvent(new SelectEvent("onSelect", entityList, entityList.getSelectedItems()));
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

	public boolean getViewMode() {
		return !_editMode;
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
		} else if ("descending".equals(sortDirection) || "natural".equals(sortDirection) || Strings.isBlank(sortDirection)) {
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
				Messagebox.show(getMessage(), getTitle(), Messagebox.YES + Messagebox.NO, Messagebox.EXCLAMATION, new org.zkoss.zk.ui.event.EventListener() {
					public void onEvent(Event event) {
						if ("onYes".equals(event.getName())) {
							doYes();
						}
					}
				});
			} catch (InterruptedException ex) {
				// ignore
			}
		}

		/**
		 * Operation when end user click Yes button in confirm delete Messagebox
		 */
		public void doYes() {
			try {
				// genericService.remover(selected);
				list.remove(selected);
				// entityCreate.focus();
			} catch (EntityNotFoundException e) {
				// ignore, already deleted by others
			}
			selected = null;
			// refresh the todoList
			refreshModel();
			// update the todoDetail
			switchMode();
		}

		/** Returns title of confirm deleting Messagebox */
		public String getTitle() {
			return "Are you sure?";
		}

		/** Returns message for confirm deleting Messagbox */
		public String getMessage() {
			return "Você tem certeza que quer deletar esse registro?";
		}
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
}
