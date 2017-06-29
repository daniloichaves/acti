package br.com.jgle.acti.controller;

import java.util.List;

import org.springframework.context.annotation.Scope;
import org.springframework.stereotype.Controller;

import br.com.jgle.acti.entity.Funcionario;
import br.com.jgle.acti.entity.Login;
import br.com.jgle.acti.entity.Unidade;

@Scope("page")
@Controller
public class FuncionarioController extends AbstractController<Funcionario> {

	private static final long serialVersionUID = 1L;

	protected TelefoneController telefoneController;
	protected ContaBancoController contaBancoController;
	protected EmailController emailController;
	protected EnderecoController enderecoController;
	protected LoginController loginController;

	public FuncionarioController() {
		super(new Funcionario());

		telefoneController = new TelefoneController(this);
		contaBancoController = new ContaBancoController(this);
		emailController = new EmailController(this);
		enderecoController = new EnderecoController(this);
		loginController = new LoginController(this);

	}

	public List<Login> getLogins() {
		return genericService.procurarTodos(Login.class);
	}

	public List<Unidade> getUnidades() {
		return genericService.procurarTodos(Unidade.class);
	}

	public TelefoneController getTelefoneController() {
		return telefoneController;
	}

	public void setTelefoneController(TelefoneController telefoneController) {
		this.telefoneController = telefoneController;
	}

	public ContaBancoController getContaBancoController() {
		return contaBancoController;
	}

	public void setContaBancoController(ContaBancoController contaBancoController) {
		this.contaBancoController = contaBancoController;
	}

	public EmailController getEmailController() {
		return emailController;
	}

	public void setEmailController(EmailController emailController) {
		this.emailController = emailController;
	}

	public EnderecoController getEnderecoController() {
		return enderecoController;
	}

	public void setEnderecoController(EnderecoController enderecoController) {
		this.enderecoController = enderecoController;
	}

	public static long getSerialversionuid() {
		return serialVersionUID;
	}

	public LoginController getLoginController() {
		return loginController;
	}

	public void setLoginController(LoginController loginController) {
		this.loginController = loginController;
	}

}
