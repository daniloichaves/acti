package _59._12._54._201.WS;

public class BrasilRiskSoapProxy implements _59._12._54._201.WS.BrasilRiskSoap {
  private String _endpoint = null;
  private _59._12._54._201.WS.BrasilRiskSoap brasilRiskSoap = null;
  
  public BrasilRiskSoapProxy() {
    _initBrasilRiskSoapProxy();
  }
  
  public BrasilRiskSoapProxy(String endpoint) {
    _endpoint = endpoint;
    _initBrasilRiskSoapProxy();
  }
  
  private void _initBrasilRiskSoapProxy() {
    try {
      brasilRiskSoap = (new _59._12._54._201.WS.BrasilRiskLocator()).getBrasilRiskSoap();
      if (brasilRiskSoap != null) {
        if (_endpoint != null)
          ((javax.xml.rpc.Stub)brasilRiskSoap)._setProperty("javax.xml.rpc.service.endpoint.address", _endpoint);
        else
          _endpoint = (String)((javax.xml.rpc.Stub)brasilRiskSoap)._getProperty("javax.xml.rpc.service.endpoint.address");
      }
      
    }
    catch (javax.xml.rpc.ServiceException serviceException) {}
  }
  
  public String getEndpoint() {
    return _endpoint;
  }
  
  public void setEndpoint(String endpoint) {
    _endpoint = endpoint;
    if (brasilRiskSoap != null)
      ((javax.xml.rpc.Stub)brasilRiskSoap)._setProperty("javax.xml.rpc.service.endpoint.address", _endpoint);
    
  }
  
  public _59._12._54._201.WS.BrasilRiskSoap getBrasilRiskSoap() {
    if (brasilRiskSoap == null)
      _initBrasilRiskSoapProxy();
    return brasilRiskSoap;
  }
  
  public _59._12._54._201.WS.ConsultaPlacaVeiculoResposta consultaPlacaVeiculo(java.lang.String placa, java.lang.String autenticacao) throws java.rmi.RemoteException{
    if (brasilRiskSoap == null)
      _initBrasilRiskSoapProxy();
    return brasilRiskSoap.consultaPlacaVeiculo(placa, autenticacao);
  }
  
  public _59._12._54._201.WS.ConsultaCPFMotoristaResposta consultaCPFMotorista(java.lang.String CPF, java.lang.String autenticacao) throws java.rmi.RemoteException{
    if (brasilRiskSoap == null)
      _initBrasilRiskSoapProxy();
    return brasilRiskSoap.consultaCPFMotorista(CPF, autenticacao);
  }
  
  public _59._12._54._201.WS.CadastrarVeiculoResposta cadastrarVeiculo(_59._12._54._201.WS.CadastrarVeiculoRequest cadastro) throws java.rmi.RemoteException{
    if (brasilRiskSoap == null)
      _initBrasilRiskSoapProxy();
    return brasilRiskSoap.cadastrarVeiculo(cadastro);
  }
  
  public _59._12._54._201.WS.CadastrarCPFResposta cadastrarCPF(_59._12._54._201.WS.CadastrarCPFRequest dados) throws java.rmi.RemoteException{
    if (brasilRiskSoap == null)
      _initBrasilRiskSoapProxy();
    return brasilRiskSoap.cadastrarCPF(dados);
  }
  
  public _59._12._54._201.WS.SolicitacaoMonitoramentoResposta solicitacaoMonitoramento(java.lang.String stringXML) throws java.rmi.RemoteException{
    if (brasilRiskSoap == null)
      _initBrasilRiskSoapProxy();
    return brasilRiskSoap.solicitacaoMonitoramento(stringXML);
  }
  
  public _59._12._54._201.WS.AlterarSMResposta alterarSM(java.lang.String CPF, java.lang.String placa, java.lang.String placaCarreta, java.lang.String codigoSM, java.lang.String autenticacao) throws java.rmi.RemoteException{
    if (brasilRiskSoap == null)
      _initBrasilRiskSoapProxy();
    return brasilRiskSoap.alterarSM(CPF, placa, placaCarreta, codigoSM, autenticacao);
  }
  
  
}