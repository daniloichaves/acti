package br.com.jgle.acti.ws;

import javax.jws.WebMethod;
import javax.jws.WebService;

import org.springframework.stereotype.Service;
import org.springframework.web.context.support.SpringBeanAutowiringSupport;

@Service
@WebService(serviceName = "TesteWS")
public class TesteWS extends SpringBeanAutowiringSupport {

	public TesteWS() {
		System.out.println("Passou");
	}

	@WebMethod
	public String sayHello() {
		return "Hello from Teste WS";
	}
}
