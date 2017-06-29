package br.com.jgle.acti.controller;

import java.util.ArrayList;
import java.util.Collection;
import java.util.List;

import org.springframework.context.annotation.Scope;
import org.springframework.stereotype.Controller;
import org.zkoss.spring.context.annotation.AppliedTo;

import br.com.jgle.acti.entity.Cliente;
import br.com.jgle.acti.entity.Funcionario;

@Scope("page")
@Controller
@AppliedTo("entityWin")
public class ClienteFornecedorController extends AbstractController<Cliente> {

	private static final long serialVersionUID = 1L;

	protected TelefoneController telefoneController;
	protected ContaBancoController contaBancoController;
	protected EmailController emailController;
	protected EnderecoController enderecoController;

	public ClienteFornecedorController() {
		super(new Cliente());

		telefoneController = new TelefoneController(this);
		contaBancoController = new ContaBancoController(this);
		emailController = new EmailController(this);
		enderecoController = new EnderecoController(this);

	}

	@SuppressWarnings({ "rawtypes", "unchecked" })
	public Collection getControllerList() {
		Collection<AbstractController> list = new ArrayList<AbstractController>();
		list.add(telefoneController);
		list.add(contaBancoController);
		list.add(emailController);

		return list;
	}

	public List<Funcionario> getRepresentantes() {
		return genericService.procurarTodos(Funcionario.class);
	}

	public List<Funcionario> getVendedores() {
		return genericService.procurarTodos(Funcionario.class);
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
}
