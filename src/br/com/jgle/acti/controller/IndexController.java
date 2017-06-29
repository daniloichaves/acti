package br.com.jgle.acti.controller;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

import javax.annotation.Resource;

import org.apache.log4j.Logger;
import org.springframework.context.annotation.Scope;
import org.springframework.stereotype.Controller;
import org.zkoss.zk.ui.Component;
import org.zkoss.zk.ui.util.GenericForwardComposer;

import br.com.jgle.acti.component.initiator.SessionManager;
import br.com.jgle.acti.entity.Login;
import br.com.jgle.acti.load.LoginLoad;
import br.com.jgle.acti.service.GenericService;

@SuppressWarnings("serial")
@Scope("page")
@Controller
public class IndexController extends GenericForwardComposer {

	protected Logger log = Logger.getLogger(IndexController.class);

	@Resource
	protected GenericService genericService;
	@Resource
	private Login login;
	@Resource
	private SessionManager sessionManager;
	@Resource
	private LoginLoad loginLoad;
	@Resource
	protected DashboardController dashboardController;

	@Override
	public void doAfterCompose(Component comp) throws Exception {
		super.doAfterCompose(comp);

		try {

			if (login == null || login.getLogin() == null) {
				Map<String, String> mapSearch = new HashMap<String, String>();
				mapSearch.put("login", "admin");
				mapSearch.put("senha", "admin");

				List<Login> result = genericService.procurarSimples(
						new Login(), mapSearch);

				if (result.isEmpty() || result.size() > 1) {
					loginLoad.inserirUsuarioDesenvolvimento();

					result = genericService.procurarSimples(new Login(),
							mapSearch);
				}

				login = result.get(0);
			}

			if (sessionManager != null) {

				sessionManager.registerLogin(login.getLogin(), null);

				log.debug("Sessão iniciada - com autenticação ["
						+ login.getLogin() + "] - Número de sessões: "
						+ sessionManager.getTotalNumberOfSessions()
						+ " -  Número de usuários logados: "
						+ sessionManager.getNumberOfAuthenticatedUsers());
			}
		} catch (Exception e) {
			e.printStackTrace();
			log.error(e.getMessage());
		}
	}

	@Override
	public void doFinally() throws Exception {
		super.doFinally();
		try {

			if (sessionManager != null) {

				sessionManager.registerLogout(login.getLogin());

				log.debug("Sessão finalizada [" + login.getLogin()
						+ "]. Número de sessões: "
						+ sessionManager.getTotalNumberOfSessions()
						+ " - Número de usuários logados: "
						+ sessionManager.getNumberOfAuthenticatedUsers());
			}

		} catch (Exception e) {
			e.printStackTrace();
			log.error(e.getMessage());
		}

	}

	public GenericService getGenericService() {
		return genericService;
	}

	public void setGenericService(GenericService genericService) {
		this.genericService = genericService;
	}

	public DashboardController getDashboardController() {
		return dashboardController;
	}

	public void setDashboardController(DashboardController dashboardController) {
		this.dashboardController = dashboardController;
	}

	public Logger getLog() {
		return log;
	}

	public void setLog(Logger log) {
		this.log = log;
	}

	public Login getLogin() {
		return login;
	}

	public void setLogin(Login login) {
		this.login = login;
	}

	public SessionManager getSessionManager() {
		return sessionManager;
	}

	public void setSessionManager(SessionManager sessionManager) {
		this.sessionManager = sessionManager;
	}

	public LoginLoad getLoginLoad() {
		return loginLoad;
	}

	public void setLoginLoad(LoginLoad loginLoad) {
		this.loginLoad = loginLoad;
	}

}
