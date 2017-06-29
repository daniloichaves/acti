package br.com.jgle.acti.controller;

import java.util.List;

import org.springframework.context.annotation.Scope;
import org.springframework.stereotype.Controller;

import br.com.jgle.acti.entity.Proprietario;
import br.com.jgle.acti.entity.Unidade;
import br.com.jgle.acti.entity.estoque.Almoxarifado;
import br.com.jgle.acti.entity.estoque.Grupo;

@Scope("page")
@Controller
public class ProprietarioController extends AbstractController<Proprietario> {

	protected TelefoneController telefoneController;
	protected ContaBancoController contaBancoController;
	protected EmailController emailController;
	protected EnderecoController enderecoController;

	public ProprietarioController() {
		super(new Proprietario());

		telefoneController = new TelefoneController(this);
		contaBancoController = new ContaBancoController(this);
		emailController = new EmailController(this);
		enderecoController = new EnderecoController(this);
	}

	private static final long serialVersionUID = 1L;

	public List<Unidade> getUnidades() {
		return genericService.procurarTodos(Unidade.class);
	}

	public List<Almoxarifado> getAlmoxarifados() {
		return genericService.procurarTodos(Almoxarifado.class);
	}

	public List<Grupo> getGrupos() {
		return genericService.procurarTodos(Grupo.class);
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
}
