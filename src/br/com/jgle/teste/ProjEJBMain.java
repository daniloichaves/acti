package br.com.jgle.teste;

import org.springframework.context.support.ClassPathXmlApplicationContext;

import br.com.jgle.acti.util.DateUtil;

public class ProjEJBMain {

	/**
	 * @param args
	 */
	@SuppressWarnings("unused")
	public static void main(String[] args) {
		System.out.println("####### INICIO: " + DateUtil.getActualFormatedDate());
		ClassPathXmlApplicationContext ctx = new ClassPathXmlApplicationContext("WebContent/WEB-INF/applicationContext.xml");

		// GenericService genericService = (GenericService)
		// ctx.getBean("generic");
		// MelhorCompraWebServiceFacade melhorCompraWebServiceFacade =
		// (MelhorCompraWebServiceFacade)
		// ctx.getBean("melhorCompraWebServiceFacade");

		// melhorCompraWebServiceFacade.inserirCargaTeste();

		System.out.println("####### FIM: " + DateUtil.getActualFormatedDate());
	}
}
