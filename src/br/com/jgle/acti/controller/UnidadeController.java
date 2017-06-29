package br.com.jgle.acti.controller;

import org.springframework.context.annotation.Scope;
import org.springframework.stereotype.Controller;

import br.com.jgle.acti.entity.Unidade;

@Scope("page")
@Controller
public class UnidadeController extends AbstractController<Unidade> {

	private static final long serialVersionUID = 1L;

	protected TelefoneController telefoneController;
	protected ContaBancoController contaBancoController;
	protected EmailController emailController;
	protected EnderecoController enderecoController;

	public UnidadeController() {
		super(new Unidade());

		telefoneController = new TelefoneController(this);
		contaBancoController = new ContaBancoController(this);
		emailController = new EmailController(this);
		enderecoController = new EnderecoController(this);
	}

	@Override
	public void checkDelete() throws InterruptedException {

		super.checkDelete();

		if (!isEmpty(selected.getLogins())) {
			addMessageRemoveError("Login");
		}
		if (!isEmpty(selected.getFuncionarios())) {
			addMessageRemoveError("Funcionarios");
		}
		

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

	public void setContaBancoController(
			ContaBancoController contaBancoController) {
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

}
