package br.com.jgle.acti.controller;

import java.util.ArrayList;
import java.util.Collection;

import javax.annotation.Resource;

import org.springframework.context.annotation.Scope;
import org.springframework.stereotype.Controller;
import org.zkoss.spring.context.annotation.AppliedTo;
import org.zkoss.zk.ui.Component;
import org.zkoss.zk.ui.event.Event;

import br.com.jgle.acti.entity.Motorista;
import br.com.jgle.acti.exception.ServiceException;
import br.com.jgle.acti.service.BrasilRiskService;

@Scope("page")
@Controller
@AppliedTo("entityWin")
public class MotoristaController extends AbstractController<Motorista> {

	private static final long serialVersionUID = 1L;

	protected TelefoneController telefoneController;
	protected ContaBancoController contaBancoController;
	protected EmailController emailController;
	protected EnderecoController enderecoController;
	protected MotoristaReferenciaController motoristaReferenciaController;

	@Resource
	protected BrasilRiskService brasilRiskService;

	// Integração
	protected Component entitySync; // sync button

	public MotoristaController() {
		super(new Motorista());

		telefoneController = new TelefoneController(this);
		contaBancoController = new ContaBancoController(this);
		emailController = new EmailController(this);
		enderecoController = new EnderecoController(this);
		motoristaReferenciaController = new MotoristaReferenciaController(this);

	}

	@SuppressWarnings({ "rawtypes", "unchecked" })
	public Collection getControllerList() {
		Collection<AbstractController> list = new ArrayList<AbstractController>();
		list.add(telefoneController);
		list.add(contaBancoController);
		list.add(emailController);

		return list;
	}

	public void onClick$entitySync(Event event) {
		try {
			brasilRiskService.cadastraMotorista(selected);
		} catch (ServiceException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}

	// Gett's and Sett's
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

	public Component getEntitySync() {
		return entitySync;
	}

	public void setEntitySync(Component entitySync) {
		this.entitySync = entitySync;
	}

	public BrasilRiskService getBrasilRiskService() {
		return brasilRiskService;
	}

	public void setBrasilRiskService(BrasilRiskService brasilRiskService) {
		this.brasilRiskService = brasilRiskService;
	}

	public MotoristaReferenciaController getMotoristaReferenciaController() {
		return motoristaReferenciaController;
	}

	public void setMotoristaReferenciaController(MotoristaReferenciaController motoristaReferenciaController) {
		this.motoristaReferenciaController = motoristaReferenciaController;
	}
}
