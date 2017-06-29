package br.com.jgle.acti.load;

import java.util.List;

import javax.annotation.Resource;

import org.springframework.beans.factory.InitializingBean;
import org.springframework.stereotype.Service;

import br.com.jgle.acti.entity.Banco;
import br.com.jgle.acti.service.GenericService;

@Service
public class CadastroLoad implements InitializingBean {

	@Resource
	protected GenericService genericService;

	@Override
	public void afterPropertiesSet() throws Exception {
		carregarBanco();

	}

	public void carregarBanco() {

		List<Banco> all = genericService.procurarTodos(Banco.class);

		if (all == null || all.isEmpty()) {
			// Bancos habilitados para o jRimum
			Banco banco = new Banco(1, " Banco do Brasil S.A.");
			genericService.inserir(banco);
			banco = new Banco(4, " Banco do Nordeste do Brasil S.A.");
			genericService.inserir(banco);
			banco = new Banco(21, " BANESTES S.A. Banco do Estado do Espírito Santo");
			genericService.inserir(banco);
			banco = new Banco(33, " Banco Santander (Brasil) S.A.");
			genericService.inserir(banco);
			banco = new Banco(41, " Banco Barisul");
			genericService.inserir(banco);
			banco = new Banco(77, " Banco Intermedium");
			genericService.inserir(banco);
			banco = new Banco(104, " Caixa Econômica Federal");
			genericService.inserir(banco);
			banco = new Banco(151, " Nossa Caixa");
			genericService.inserir(banco);
			banco = new Banco(237, " Banco Bradesco S.A.");
			genericService.inserir(banco);
			banco = new Banco(341, " Itaú Unibanco S.A.");
			genericService.inserir(banco);
			banco = new Banco(356, " Banco Real S.A.");
			genericService.inserir(banco);
			banco = new Banco(389, " Banco Mercantil do Brasil S.A.");
			genericService.inserir(banco);
			banco = new Banco(399, " HSBC Bank Brasil S.A. - Banco Múltiplo");
			genericService.inserir(banco);
			banco = new Banco(409, " UNIBANCO - União de Bancos Brasileiros S.A.");
			genericService.inserir(banco);
			banco = new Banco(422, " Banco Safra S.A.");
			genericService.inserir(banco);
			banco = new Banco(453, " Banco Rural S.A.");
			genericService.inserir(banco);
			banco = new Banco(748, " Banco Cooperativo Sicredi S.A.");
			genericService.inserir(banco);
			banco = new Banco(756, " Banco Cooperativo do Brasil S.A. - BANCOOB");
			genericService.inserir(banco);

			// Bancos NÂO habilitados para o jRimum
			/*
			banco = new Banco(246, " Banco ABC Brasil S.A.");
			genericService.inserir(banco);
			banco = new Banco(246, "Banco ABC Brasil S.A.");
			genericService.inserir(banco);
			banco = new Banco(25, " Banco Alfa S.A.");
			genericService.inserir(banco);
			banco = new Banco(641, " Banco Alvorada S.A.");
			genericService.inserir(banco);
			banco = new Banco(29, " Banco Banerj S.A.");
			genericService.inserir(banco);
			banco = new Banco(0, " Banco Bankpar S.A.");
			genericService.inserir(banco);
			banco = new Banco(740, " Banco Barclays S.A.");
			genericService.inserir(banco);
			banco = new Banco(107, " Banco BBM S.A.");
			genericService.inserir(banco);
			banco = new Banco(31, " Banco Beg S.A.");
			genericService.inserir(banco);
			banco = new Banco(739, " Banco BGN S.A.");
			genericService.inserir(banco);
			banco = new Banco(96, " Banco BM&F de Serviços de Liquidação e Custódia S.A");
			genericService.inserir(banco);
			banco = new Banco(318, " Banco BMG S.A.");
			genericService.inserir(banco);
			banco = new Banco(752, " Banco BNP Paribas Brasil S.A.");
			genericService.inserir(banco);
			banco = new Banco(248, " Banco Boavista Interatlântico S.A.");
			genericService.inserir(banco);
			banco = new Banco(218, " Banco Bonsucesso S.A.");
			genericService.inserir(banco);
			banco = new Banco(65, " Banco Bracce S.A.");
			genericService.inserir(banco);
			banco = new Banco(36, " Banco Bradesco BBI S.A.");
			genericService.inserir(banco);
			banco = new Banco(204, " Banco Bradesco Cartões S.A.");
			genericService.inserir(banco);
			banco = new Banco(394, " Banco Bradesco Financiamentos S.A.");
			genericService.inserir(banco);
			banco = new Banco(225, " Banco Brascan S.A.");
			genericService.inserir(banco);
			banco = new Banco(208, " Banco BTG Pactual S.A.");
			genericService.inserir(banco);
			banco = new Banco(44, " Banco BVA S.A.");
			genericService.inserir(banco);
			banco = new Banco(263, " Banco Cacique S.A.");
			genericService.inserir(banco);
			banco = new Banco(473, " Banco Caixa Geral - Brasil S.A.");
			genericService.inserir(banco);
			banco = new Banco(40, " Banco Cargill S.A.");
			genericService.inserir(banco);
			banco = new Banco(745, " Banco Citibank S.A.");
			genericService.inserir(banco);
			banco = new Banco(215, " Banco Comercial e de Investimento Sudameris S.A.");
			genericService.inserir(banco);
			banco = new Banco(222, " Banco Credit Agricole Brasil S.A.");
			genericService.inserir(banco);
			banco = new Banco(505, " Banco Credit Suisse (Brasil) S.A.");
			genericService.inserir(banco);
			banco = new Banco(229, " Banco Cruzeiro do Sul S.A.");
			genericService.inserir(banco);
			banco = new Banco(3, " Banco da Amazônia S.A.");
			genericService.inserir(banco);
			banco = new Banco(833, " Banco da China Brasil S.A.");
			genericService.inserir(banco);
			banco = new Banco(707, " Banco Daycoval S.A.");
			genericService.inserir(banco);
			banco = new Banco(24, " Banco de Pernambuco S.A. - BANDEPE");
			genericService.inserir(banco);
			banco = new Banco(456, " Banco de Tokyo-Mitsubishi UFJ Brasil S.A.");
			genericService.inserir(banco);
			banco = new Banco(214, " Banco Dibens S.A.");
			genericService.inserir(banco);
			banco = new Banco(47, " Banco do Estado de Sergipe S.A.");
			genericService.inserir(banco);
			banco = new Banco(37, " Banco do Estado do Pará S.A.");
			genericService.inserir(banco);
			banco = new Banco(41, " Banco do Estado do Rio Grande do Sul S.A.");
			genericService.inserir(banco);
			banco = new Banco(265, " Banco Fator S.A.");
			genericService.inserir(banco);
			banco = new Banco(224, " Banco Fibra S.A.");
			genericService.inserir(banco);
			banco = new Banco(626, " Banco Ficsa S.A.");
			genericService.inserir(banco);
			banco = new Banco(233, " Banco GE Capital S.A.");
			genericService.inserir(banco);
			banco = new Banco(612, " Banco Guanabara S.A.");
			genericService.inserir(banco);
			banco = new Banco(63, " Banco Ibi S.A. Banco Múltiplo");
			genericService.inserir(banco);
			banco = new Banco(604, " Banco Industrial do Brasil S.A.");
			genericService.inserir(banco);
			banco = new Banco(320, " Banco Industrial e Comercial S.A.");
			genericService.inserir(banco);
			banco = new Banco(653, " Banco Indusval S.A.");
			genericService.inserir(banco);
			banco = new Banco(249, " Banco Investcred Unibanco S.A.");
			genericService.inserir(banco);
			banco = new Banco(184, " Banco Itaú BBA S.A.");
			genericService.inserir(banco);
			banco = new Banco(479, " Banco ItaúBank S.A");
			genericService.inserir(banco);
			banco = new Banco(376, " Banco J. P. Morgan S.A.");
			genericService.inserir(banco);
			banco = new Banco(74, " Banco J. Safra S.A.");
			genericService.inserir(banco);
			banco = new Banco(217, " Banco John Deere S.A.");
			genericService.inserir(banco);
			banco = new Banco(600, " Banco Luso Brasileiro S.A.");
			genericService.inserir(banco);
			banco = new Banco(746, " Banco Modal S.A.");
			genericService.inserir(banco);
			banco = new Banco(45, " Banco Opportunity S.A.");
			genericService.inserir(banco);
			banco = new Banco(623, " Banco Panamericano S.A.");
			genericService.inserir(banco);
			banco = new Banco(611, " Banco Paulista S.A.");
			genericService.inserir(banco);
			banco = new Banco(643, " Banco Pine S.A.");
			genericService.inserir(banco);
			banco = new Banco(638, " Banco Prosper S.A.");
			genericService.inserir(banco);
			banco = new Banco(747, " Banco Rabobank International Brasil S.A.");
			genericService.inserir(banco);
			banco = new Banco(633, " Banco Rendimento S.A.");
			genericService.inserir(banco);
			banco = new Banco(72, " Banco Rural Mais S.A.");
			genericService.inserir(banco);
			banco = new Banco(250, " Banco Schahin S.A.");
			genericService.inserir(banco);
			banco = new Banco(749, " Banco Simples S.A.");
			genericService.inserir(banco);
			banco = new Banco(366, " Banco Société Générale Brasil S.A.");
			genericService.inserir(banco);
			banco = new Banco(637, " Banco Sofisa S.A.");
			genericService.inserir(banco);
			banco = new Banco(12, " Banco Standard de Investimentos S.A.");
			genericService.inserir(banco);
			banco = new Banco(464, " Banco Sumitomo Mitsui Brasileiro S.A.");
			genericService.inserir(banco);
			banco = new Banco(655, " Banco Votorantim S.A.");
			genericService.inserir(banco);
			banco = new Banco(610, " Banco VR S.A.");
			genericService.inserir(banco);
			banco = new Banco(370, " Banco WestLB do Brasil S.A.");
			genericService.inserir(banco);
			banco = new Banco(719, " Banif-Banco Internacional do Funchal (Brasil)S.A.");
			genericService.inserir(banco);
			banco = new Banco(755, " Bank of America Merrill Lynch Banco Múltiplo S.A.");
			genericService.inserir(banco);
			banco = new Banco(73, " BB Banco Popular do Brasil S.A.");
			genericService.inserir(banco);
			banco = new Banco(78, " BES Investimento do Brasil S.A.-Banco de Investimento");
			genericService.inserir(banco);
			banco = new Banco(69, " BPN Brasil Banco Múltiplo S.A.");
			genericService.inserir(banco);
			banco = new Banco(70, " BRB - Banco de Brasília S.A.");
			genericService.inserir(banco);
			banco = new Banco(477, " Citibank N.A.");
			genericService.inserir(banco);
			banco = new Banco(487, " Deutsche Bank S.A. - Banco Alemão");
			genericService.inserir(banco);
			banco = new Banco(751, " Dresdner Bank Brasil S.A. - Banco Múltiplo");
			genericService.inserir(banco);
			banco = new Banco(64, " Goldman Sachs do Brasil Banco Múltiplo S.A.");
			genericService.inserir(banco);
			banco = new Banco(62, " Hipercard Banco Múltiplo S.A.");
			genericService.inserir(banco);
			banco = new Banco(492, " ING Bank N.V.");
			genericService.inserir(banco);
			banco = new Banco(652, " Itaú Unibanco Holding S.A.");
			genericService.inserir(banco);
			banco = new Banco(79, " JBS Banco S.A.");
			genericService.inserir(banco);
			banco = new Banco(488, " JPMorgan Chase Bank");
			genericService.inserir(banco);
			banco = new Banco(230, " Unicard Banco Múltiplo S.A.");
			genericService.inserir(banco);
			*/
		}

	}

	public GenericService getGenericService() {
		return genericService;
	}

	public void setGenericService(GenericService genericService) {
		this.genericService = genericService;
	}

}
