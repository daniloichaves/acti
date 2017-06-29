package br.com.jgle.acti.service;

import java.util.List;

import javax.annotation.Resource;

import org.springframework.stereotype.Service;

import br.com.jgle.acti.entity.AcessoMenu;

@Service
public class AcessoMenuService {

	@Resource
	protected GenericService genericService;

	public boolean existeAcessoMenu(String idMenu) {
		List<AcessoMenu> list = genericService.executeQuery("Select am from AcessoMenu as am where idMenu = :idMenu", "idMenu", idMenu);
		if (list != null && list.size() > 0)
			return true;

		return false;
	}

	public AcessoMenu getAcessoMenu(String idMenu) {
		AcessoMenu acessoMenu = genericService.executeQuerySingle("Select am from AcessoMenu as am where idMenu = :idMenu", "idMenu", idMenu);

		return acessoMenu;
	}

	public GenericService getGenericService() {
		return genericService;
	}

	public void setGenericService(GenericService genericService) {
		this.genericService = genericService;
	}

}
