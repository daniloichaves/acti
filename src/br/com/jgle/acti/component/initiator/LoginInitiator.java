package br.com.jgle.acti.component.initiator;

import java.util.Collection;
import java.util.Map;

import org.zkoss.zk.ui.Page;
import org.zkoss.zk.ui.util.Initiator;

import br.com.jgle.acti.entity.Login;
import br.com.jgle.acti.service.LoginService;

//@Component
public class LoginInitiator implements Initiator {

	// @Resource
	private LoginService loginService;
	private Collection<Login> logins;

	@SuppressWarnings("rawtypes")
	public void doInit(Page page, Map arg1) throws Exception {
		// loginService = (LoginService) SpringUtil
		// .getBean("loginService");
		logins = loginService.procurarTodos(Login.class);
		page.setAttribute("allLogins", logins);
	}

	public void doAfterCompose(Page arg0) throws Exception {
		// TODO Auto-generated method stub

	}

	public boolean doCatch(Throwable arg0) throws Exception {
		// TODO Auto-generated method stub
		return false;
	}

	public void doFinally() throws Exception {
		// TODO Auto-generated method stub

	}

	public LoginService getLoginService() {
		return loginService;
	}

	public void setLoginService(LoginService loginService) {
		this.loginService = loginService;
	}

	public Collection<Login> getLogins() {
		return logins;
	}

	public void setLogins(Collection<Login> logins) {
		this.logins = logins;
	}
}
