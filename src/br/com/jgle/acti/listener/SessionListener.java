package br.com.jgle.acti.listener;

import java.util.logging.Logger;

import org.springframework.web.context.WebApplicationContext;
import org.springframework.web.context.support.WebApplicationContextUtils;

/**
 *
 * Classe para 
 * 
 * @author Danilo Ischiavolini Chaves
 * 
 * http://www.guj.com.br/java/220154--resolvido--como-controlar-nero-de-usuarios-logados
 *
 */
public class SessionListener {
	/*
	public class SessionListener implements HttpSessionListener {

	protected static org.apache.log4j.Logger log = Logger
			.getLogger(SessionListener.class);

	@Override
	public void sessionCreated(HttpSessionEvent se) {

		ServletContext sc = se.getSession().getServletContext();
		if (sc != null) {
			WebApplicationContext context = WebApplicationContextUtils
					.getRequiredWebApplicationContext(sc);
			if (context != null) { // SessionManager � um singleton do spring
									// que controla as sess�es ativas
				SessionManager sessionManager = (SessionManager) context
						.getBean("sessionManager");
				if (sessionManager != null) {
					sessionManager.registerLogin(se.getSession().getId(), null);
					log.debug("Sess�o iniciada - sem autentica��o ["
							+ se.getSession().getId()
							+ "] - N�mero de sess�es: "
							+ sessionManager.getTotalNumberOfSessions()
							+ " -  N�mero de usu�rios logados: "
							+ sessionManager.getNumberOfAuthenticatedUsers());
				}
			}
		}

	}

	@Override
	public void sessionDestroyed(HttpSessionEvent se) {
		ServletContext sc = se.getSession().getServletContext();
		if (sc != null) {
			WebApplicationContext context = WebApplicationContextUtils
					.getRequiredWebApplicationContext(sc);
			if (context != null) {
				// SessionManager � um singleton do spring que controla as
				// sess�es ativas
				SessionManager sessionManager = (SessionManager) context
						.getBean("sessionManager");
				if (sessionManager != null) {
					sessionManager.registerLogout(se.getSession().getId()); // decrementa
																			// o
																			// contador
																			// de
																			// sess�es
																			// ativas
					log.debug("Sess�o finalizada [" + se.getSession().getId()
							+ "]. N�mero de sess�es: "
							+ sessionManager.getTotalNumberOfSessions()
							+ " - N�mero de usu�rios logados: "
							+ sessionManager.getNumberOfAuthenticatedUsers());
				}
			}
		}

	}
	*/

}