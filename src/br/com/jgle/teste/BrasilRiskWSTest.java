package br.com.jgle.teste;

import java.rmi.RemoteException;

import _59._12._54._201.WS.BrasilRiskSoapProxy;
import _59._12._54._201.WS.ConsultaPlacaVeiculoResposta;

public class BrasilRiskWSTest {
	public static void main(String[] args) throws RemoteException {
		BrasilRiskSoapProxy brasilRiskSoapProxy = new BrasilRiskSoapProxy();

		ConsultaPlacaVeiculoResposta consultaPlacaVeiculo = brasilRiskSoapProxy.consultaPlacaVeiculo("DWO5825", "4036f57f49fd07e90dc1f29b0d9002f0");

		System.out.println(consultaPlacaVeiculo.getMensagemErro());
	}
}
