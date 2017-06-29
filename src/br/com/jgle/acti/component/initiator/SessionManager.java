package br.com.jgle.acti.component.initiator;

import java.util.HashMap;
import java.util.Map;
import java.util.Set;

import br.com.jgle.acti.entity.Login;

public class SessionManager {

	public static Integer loggedUsersNum = 0;
	private Map<String, Login> usersMap = new HashMap<String, Login>();

	public synchronized void registerLogout(String sessionId) {
		usersMap.remove(sessionId);

	}

	public synchronized Integer getTotalNumberOfSessions() {
		return usersMap.size();
	}

	public synchronized Integer getNumberOfAuthenticatedUsers() {
		int number = 0;
		Set<Map.Entry<String, Login>> entries = usersMap.entrySet();
		for (Map.Entry<String, Login> entry : entries) {
			if (null != entry.getValue()) {
				number++;
			}
		}
		return number;
	}

	public synchronized void registerLogin(String sessionId, Login user) {
		usersMap.put(sessionId, user);
	}
}
