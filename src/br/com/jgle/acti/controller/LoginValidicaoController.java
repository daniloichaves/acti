package br.com.jgle.acti.controller;


import java.util.HashMap;
import java.util.List;
import java.util.Map;

import javax.annotation.Resource;

import org.springframework.context.annotation.Scope;
import org.springframework.stereotype.Controller;
import org.zkoss.zk.ui.Executions;
import org.zkoss.zk.ui.util.GenericForwardComposer;
import org.zkoss.zul.Button;
import org.zkoss.zul.Messagebox;
import org.zkoss.zul.Textbox;
import org.zkoss.zul.Window;
import org.zkoss.zul.Combobox;

import br.com.jgle.acti.entity.Login;
import br.com.jgle.acti.service.GenericService;

@Scope("page")
@Controller
public class LoginValidicaoController extends GenericForwardComposer {

	private static final long serialVersionUID = 1L;

	@Resource
	protected GenericService genericService;

	@Resource
	protected Login login;

	protected Textbox usuario;
	protected Textbox senha;
	protected Button entrar;
	protected Window loginWindow;
	protected Integer tentativa = new Integer(0);
	protected Combobox thema;

	public void onCreate$loginWindow() {
		List<Login> logins = getLogins();

		if (logins == null || logins.size() == 0)
			Executions.sendRedirect("/loginPrimeiroCadastro.zul");
	}

	public void onClick$entrar() {
		Map<String, String> mapSearch = new HashMap<String, String>();
		mapSearch.put("login", usuario.getValue());
		mapSearch.put("senha", senha.getValue());

		List<Login> result = genericService.procurarSimples(new Login(),
				mapSearch);

		if (result.isEmpty() || result.size() > 1) {
			try {
				tentativa++;
				Messagebox.show("Usuário ou senha inválido");
				if (tentativa > 5) {
					Messagebox
							.show("Seus dados foram enviados para o administrador");
					// TODO enviar email para administrador
				}
			} catch (Exception e2) {
				// ignore
				e2.printStackTrace();
			}
		} else {
			setLogin(result.get(0));
			session.setAttribute("usuario", login);
			session.setAttribute("login", login);
			application.setAttribute("usuario", login);
			application.setAttribute("login", login);
			
//			if(thema != null) {
//				int corThema = thema.getSelectedIndex();
//				switch (corThema) {
//				case 0:
//					Themes.setTheme(Executions.getCurrent(), "blue");
//					break;
//				case 1:
//					Themes.setTheme(Executions.getCurrent(), Themes.BREEZE_THEME);
//					break;
//				case 2:
//					Themes.setTheme(Executions.getCurrent(), "silver");
//					break;
//
//				default:
//					break;
//				}
//				
//			}
//			Themes.setTheme(Executions.getCurrent(), thema.getSelectedItemApi().getValue().toString());

			Executions.sendRedirect("/index.zul");
		}
	}

	public List<Login> getLogins() {
		return genericService.procurarTodos(Login.class);
	}

	public GenericService getGenericService() {
		return genericService;
	}

	public void setGenericService(GenericService genericService) {
		this.genericService = genericService;
	}

	public Textbox getLogin() {
		return usuario;
	}

	public void setLogin(Textbox login) {
		this.usuario = login;
	}

	public Textbox getSenha() {
		return senha;
	}

	public void setSenha(Textbox senha) {
		this.senha = senha;
	}

	public Button getEntrar() {
		return entrar;
	}

	public void setEntrar(Button entrar) {
		this.entrar = entrar;
	}

	public Textbox getUsuario() {
		return usuario;
	}

	public void setUsuario(Textbox usuario) {
		this.usuario = usuario;
	}

	public Integer getTentativa() {
		return tentativa;
	}

	public void setTentativa(Integer tentativa) {
		this.tentativa = tentativa;
	}

	public void setLogin(Login login) {
		this.login = login;
	}

	public Window getLoginWindow() {
		return loginWindow;
	}

	public void setLoginWindow(Window loginWindow) {
		this.loginWindow = loginWindow;
	}

	public Combobox getThema() {
		return thema;
	}

	public void setThema(Combobox thema) {
		this.thema = thema;
	}
}
