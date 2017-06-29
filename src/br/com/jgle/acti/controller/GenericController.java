package br.com.jgle.acti.controller;

import java.util.List;

import javax.annotation.Resource;
import javax.persistence.EntityNotFoundException;

import org.zkoss.zk.ui.Component;
import org.zkoss.zk.ui.event.Event;
import org.zkoss.zk.ui.event.EventListener;
import org.zkoss.zk.ui.event.Events;
import org.zkoss.zk.ui.event.KeyEvent;
import org.zkoss.zk.ui.event.SelectEvent;
import org.zkoss.zk.ui.util.GenericForwardComposer;
import org.zkoss.zkplus.databind.DataBinder;
import org.zkoss.zul.Button;
import org.zkoss.zul.Datebox;
import org.zkoss.zul.Listbox;
import org.zkoss.zul.Messagebox;
import org.zkoss.zul.Spinner;
import org.zkoss.zul.Textbox;
import org.zkoss.zul.Window;

import br.com.jgle.acti.entity.AbstractEntity;
import br.com.jgle.acti.service.GenericService;

//GenericAutowireComposer 
abstract class GenericController<T extends AbstractEntity> extends GenericForwardComposer {

	private static final long serialVersionUID = 1L;
	// ZK databinder
	protected DataBinder binder;

	protected T selected;
	protected T selectedNew;

	// Todo Model
	@Resource
	protected GenericService genericService = null;

	// main control window
	@Resource
	protected Window todoWin; // main window
	@Resource
	protected Listbox todoList; // domain object summary list
	@Resource
	protected Component todoDetail; // domain object detail

	// edit mode
	@Resource
	protected Component todoEdit; // edit panel
	@Resource
	protected Textbox name;
	@Resource
	protected Datebox date;
	@Resource
	protected Spinner priority;

	// buttons
	@Resource
	protected Button todoCreate; // new button
	@Resource
	protected Button todoUpdate; // edit button
	@Resource
	protected Button todoDelete; // delete button
	@Resource
	protected Button todoSave; // save button
	@Resource
	protected Button todoCancel; // cancel button

	// operation transient state
	protected T _tmpSelected; // store original selected entity
	protected boolean _create; // when new a entity
	protected boolean _editMode; // switch to edit mode when doing
									// editing(new/update)
	protected int _lastSelectedIndex = -1; // last selectedIndex before delete

	public GenericController() {
	}

	public GenericService getModel() {
		return genericService;
	}

	public void setModel(GenericService toDoModel) {
		this.genericService = toDoModel;
	}

	public void refreshModel() {
		binder.loadAttribute(todoList, "model"); // reload model to force
													// refresh
	}

	// -- view/edit mode --//
	public void setEditMode(boolean b) {
		_editMode = b;
		switchMode();
	}

	public boolean isViewMode() {
		return !_editMode;
	}

	public boolean isEditMode() {
		return _editMode;
	}

	public boolean isCreate() {
		return _create;
	}

	public boolean isNotSelected() {
		// TODO VERIFICAR return this.getModel().getSelected() == null;
		return false;
	}

	private void switchMode() {
		binder.loadComponent(todoDetail); // reload visible to force refresh
		setFocus();
	}

	@SuppressWarnings("rawtypes")
	private void setFocus() {
		if (_editMode) {
			name.focus();
		} else {
			if (((List) todoList.getModel()).isEmpty()) {
				// no result in list, focus on new button
				todoCreate.focus();
			} else {
				if (_create) {
					todoCreate.focus();
				} else {
					todoList.focus();
				}
			}
		}
	}

	// -- Initialization --//
	// @On("todoWin.onCreate")
	@SuppressWarnings({ "rawtypes", "unchecked" })
	public void init() {
		// binder = (DataBinder) todoWin.getVariable("binder", true);
		binder = (DataBinder) todoWin.getAttribute("binder", true);
		final List model = (List) todoList.getModel();
		if (!model.isEmpty()) {
			// genericService.setSelected((T) model.get(0));
			selected = (T) model.get(0);
			binder.loadComponent(todoDetail);
		}
		setFocus();
	}

	// -- view mode control --//
	// @On("todoWin.onCtrlKey")
	@SuppressWarnings("rawtypes")
	public void doCtrlKey(Event event) {
		final List items = todoList.getItems();
		if (!items.isEmpty() && (!_editMode || !_create)) {
			final int keycode = ((KeyEvent) event).getKeyCode();
			if (keycode == KeyEvent.DOWN || keycode == KeyEvent.UP) {
				// handle no selected item case
				if (todoList.getSelectedIndex() < 0) { // no selected item
					// try our best to guess one
					if (_lastSelectedIndex >= 0) {
						final int index = Math.min(items.size() - 1, _lastSelectedIndex);
						todoList.setSelectedIndex(index);
						Events.sendEvent(new SelectEvent("onSelect", todoList, todoList.getSelectedItems()));
					}
				}
				todoList.focus();
			}
		}
	}

	// @On("todoList.onSelect")
	public void doSelect(Event event) {
		final int index = todoList.getSelectedIndex();
		if (index >= 0) {
			_lastSelectedIndex = index;
			_create = false;
		}
	}

	// @On("todoCreate.onClick")
	public void doCreate(Event event) {
		if (isViewMode()) {
			// prepare a new Todo
			// _tmpSelected = genericService.getSelected();
			_tmpSelected = selected;
			_create = true;
			// genericService.setSelected(new Todo());
			// TODO Verificar
			// selected = new T();

			// switch to edit mode
			setEditMode(true);
		}
	}

	// @On("todoUpdate.onClick")
	public void doUpdate(Event event) {
		if (isViewMode()) {
			if (selected != null) {
				_create = false;

				// switch to edit mode
				setEditMode(true);
			}
		}
	}

	// @On("todoDelete.onClick")
	public void doDelete(Event event) {
		if (isViewMode()) {
			if (selected != null) {
				_create = false;
				newConfirmDelete().show();
			}
		}
	}

	// -- sorting --//
	// @On("todoNameSort.onSort,todoDateSort.onSort,todoPrioritySort.onSort")
	public void doSort(Event event) {
		// final Listheader lh = (Listheader) event.getTarget();
		// final String sortDirection = lh.getSortDirection(); // original
		// // direction
		// if ("ascending".equals(sortDirection)) {
		// final Comparator cmpr = lh.getSortDescending();
		// if (cmpr instanceof FieldComparator) {
		// final String orderBy = ((FieldComparator) cmpr).getOrderBy();
		// genericService.setOrderBy(orderBy); // update query string
		// }
		// } else if ("descending".equals(sortDirection)
		// || "natural".equals(sortDirection)
		// || Strings.isBlank(sortDirection)) {
		// final Comparator cmpr = lh.getSortAscending();
		// if (cmpr instanceof FieldComparator) {
		// final String orderBy = ((FieldComparator) cmpr).getOrderBy();
		// genericService.setOrderBy(orderBy); // update query string
		// }
		// }
	}

	@Override
	public void doAfterCompose(Component comp) throws Exception {
		todoSave.addEventListener("doSave", new EventListener() {
			public void onEvent(Event event) throws Exception {
				doCreate(event);
			}
		});

		todoWin.addEventListener("onClick", new EventListener() {
			public void onEvent(Event event) throws Exception {
				if (isEditMode()) {
					// validate
					validate();

					// save into bean
					binder.saveComponent(todoEdit); // reload model to force
													// refresh

					// store into db
					if (_create) {
						genericService.inserir(selectedNew);
					} else {
						try {
							genericService.atualizar(selected);
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
		});
	}

	// @On("todoCancel.onClick,todoWin.onCancel")
	public void doCancel(Event event) {
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

	// --To be override--//
	/** Validate the input field */
	protected void validate() {
		date.getValue();
		priority.getValue();
		name.getValue();
	}

	/** The info message when end user trying to update a "deleted" entity. */
	protected String getUpdateDeletedMessage() {
		return "Cannot find the selected item, might have been deleted by others.";
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
				genericService.remover(selected);
				todoCreate.focus();
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
			return "Are you sure you want to delete the selected item?";
		}
	}

	public T getSelected() {
		return selected;
	}

	public void setSelected(T selected) {
		this.selected = selected;
	}
}
