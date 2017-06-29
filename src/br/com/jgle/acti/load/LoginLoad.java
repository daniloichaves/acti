package br.com.jgle.acti.load;

import java.util.List;

import javax.annotation.Resource;

import org.springframework.beans.factory.InitializingBean;
import org.springframework.stereotype.Service;

import br.com.jgle.acti.entity.Login;
import br.com.jgle.acti.service.GenericService;

@Service
public class LoginLoad implements InitializingBean {

	@Resource
	protected GenericService genericService;

	@Override
	public void afterPropertiesSet() throws Exception {
		carregarLogin();
	}

	public void carregarLogin() {

		List<Login> all = genericService.procurarTodos(Login.class);
		if (all == null || all.isEmpty()) {

			inserirUsuarioDesenvolvimento();
		}
	}

	public void inserirUsuarioDesenvolvimento() {

		Login login = new Login();

		login.setNome("jGle Solutions Technology");
		login.setEmail("suporte@jgle.com.br");
		login.setLogin("jgle");
		login.setSenha("jgle");

		genericService.inserir(login);
	}
}
