package br.com.jgle.acti.controller.roterizador;

import java.io.Serializable;

import org.springframework.context.annotation.Scope;
import org.springframework.stereotype.Controller;

import br.com.jgle.acti.controller.ColetaController;

@SuppressWarnings("serial")
@Scope("page")
@Controller
public class RoterizadorOrdemColetaController extends ColetaController
		implements Serializable {

}
