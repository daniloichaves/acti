/**
 * BrasilRiskSoap.java
 *
 * This file was auto-generated from WSDL
 * by the Apache Axis 1.4 Apr 22, 2006 (06:55:48 PDT) WSDL2Java emitter.
 */

package _59._12._54._201.WS;

public interface BrasilRiskSoap extends java.rmi.Remote {

    /**
     * Consulta Placa do veículo. Retorna se o mesmo está apto ou
     * não.
     */
    public _59._12._54._201.WS.ConsultaPlacaVeiculoResposta consultaPlacaVeiculo(java.lang.String placa, java.lang.String autenticacao) throws java.rmi.RemoteException;

    /**
     * Consulta CPF do motorista. Retorna se o motorista está apto
     * ou não para execer a atividade.
     */
    public _59._12._54._201.WS.ConsultaCPFMotoristaResposta consultaCPFMotorista(java.lang.String CPF, java.lang.String autenticacao) throws java.rmi.RemoteException;

    /**
     * Este método permite o cadastro de Veículo. Consulte a documentação
     * do XML de entrada para utilizar este método corretamente.
     */
    public _59._12._54._201.WS.CadastrarVeiculoResposta cadastrarVeiculo(_59._12._54._201.WS.CadastrarVeiculoRequest cadastro) throws java.rmi.RemoteException;

    /**
     * Este método permite o cadastro de um Motorista. Consulte a
     * documentação do XML de entrada para utilizar este método corretamente.
     */
    public _59._12._54._201.WS.CadastrarCPFResposta cadastrarCPF(_59._12._54._201.WS.CadastrarCPFRequest dados) throws java.rmi.RemoteException;

    /**
     * Este método gera uma Solicitação de Monitoramento. Consulte
     * a documentação do XML de entrada para utilizar este método corretamente.
     */
    public _59._12._54._201.WS.SolicitacaoMonitoramentoResposta solicitacaoMonitoramento(java.lang.String stringXML) throws java.rmi.RemoteException;

    /**
     * Alterar Motorista ou Placa de uma SM.
     */
    public _59._12._54._201.WS.AlterarSMResposta alterarSM(java.lang.String CPF, java.lang.String placa, java.lang.String placaCarreta, java.lang.String codigoSM, java.lang.String autenticacao) throws java.rmi.RemoteException;
}
