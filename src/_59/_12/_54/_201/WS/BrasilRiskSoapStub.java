/**
 * BrasilRiskSoapStub.java
 *
 * This file was auto-generated from WSDL
 * by the Apache Axis 1.4 Apr 22, 2006 (06:55:48 PDT) WSDL2Java emitter.
 */

package _59._12._54._201.WS;

public class BrasilRiskSoapStub extends org.apache.axis.client.Stub implements _59._12._54._201.WS.BrasilRiskSoap {
    private java.util.Vector cachedSerClasses = new java.util.Vector();
    private java.util.Vector cachedSerQNames = new java.util.Vector();
    private java.util.Vector cachedSerFactories = new java.util.Vector();
    private java.util.Vector cachedDeserFactories = new java.util.Vector();

    static org.apache.axis.description.OperationDesc [] _operations;

    static {
        _operations = new org.apache.axis.description.OperationDesc[6];
        _initOperationDesc1();
    }

    private static void _initOperationDesc1(){
        org.apache.axis.description.OperationDesc oper;
        org.apache.axis.description.ParameterDesc param;
        oper = new org.apache.axis.description.OperationDesc();
        oper.setName("ConsultaPlacaVeiculo");
        param = new org.apache.axis.description.ParameterDesc(new javax.xml.namespace.QName("http://201.54.12.59/WS", "Placa"), org.apache.axis.description.ParameterDesc.IN, new javax.xml.namespace.QName("http://www.w3.org/2001/XMLSchema", "string"), java.lang.String.class, false, false);
        param.setOmittable(true);
        oper.addParameter(param);
        param = new org.apache.axis.description.ParameterDesc(new javax.xml.namespace.QName("http://201.54.12.59/WS", "Autenticacao"), org.apache.axis.description.ParameterDesc.IN, new javax.xml.namespace.QName("http://www.w3.org/2001/XMLSchema", "string"), java.lang.String.class, false, false);
        param.setOmittable(true);
        oper.addParameter(param);
        oper.setReturnType(new javax.xml.namespace.QName("http://201.54.12.59/WS", "ConsultaPlacaVeiculoResposta"));
        oper.setReturnClass(_59._12._54._201.WS.ConsultaPlacaVeiculoResposta.class);
        oper.setReturnQName(new javax.xml.namespace.QName("http://201.54.12.59/WS", "ConsultaPlacaVeiculoResult"));
        oper.setStyle(org.apache.axis.constants.Style.WRAPPED);
        oper.setUse(org.apache.axis.constants.Use.LITERAL);
        _operations[0] = oper;

        oper = new org.apache.axis.description.OperationDesc();
        oper.setName("ConsultaCPFMotorista");
        param = new org.apache.axis.description.ParameterDesc(new javax.xml.namespace.QName("http://201.54.12.59/WS", "CPF"), org.apache.axis.description.ParameterDesc.IN, new javax.xml.namespace.QName("http://www.w3.org/2001/XMLSchema", "string"), java.lang.String.class, false, false);
        param.setOmittable(true);
        oper.addParameter(param);
        param = new org.apache.axis.description.ParameterDesc(new javax.xml.namespace.QName("http://201.54.12.59/WS", "Autenticacao"), org.apache.axis.description.ParameterDesc.IN, new javax.xml.namespace.QName("http://www.w3.org/2001/XMLSchema", "string"), java.lang.String.class, false, false);
        param.setOmittable(true);
        oper.addParameter(param);
        oper.setReturnType(new javax.xml.namespace.QName("http://201.54.12.59/WS", "ConsultaCPFMotoristaResposta"));
        oper.setReturnClass(_59._12._54._201.WS.ConsultaCPFMotoristaResposta.class);
        oper.setReturnQName(new javax.xml.namespace.QName("http://201.54.12.59/WS", "ConsultaCPFMotoristaResult"));
        oper.setStyle(org.apache.axis.constants.Style.WRAPPED);
        oper.setUse(org.apache.axis.constants.Use.LITERAL);
        _operations[1] = oper;

        oper = new org.apache.axis.description.OperationDesc();
        oper.setName("CadastrarVeiculo");
        param = new org.apache.axis.description.ParameterDesc(new javax.xml.namespace.QName("http://201.54.12.59/WS", "Cadastro"), org.apache.axis.description.ParameterDesc.IN, new javax.xml.namespace.QName("http://201.54.12.59/WS", "CadastrarVeiculoRequest"), _59._12._54._201.WS.CadastrarVeiculoRequest.class, false, false);
        param.setOmittable(true);
        oper.addParameter(param);
        oper.setReturnType(new javax.xml.namespace.QName("http://201.54.12.59/WS", "CadastrarVeiculoResposta"));
        oper.setReturnClass(_59._12._54._201.WS.CadastrarVeiculoResposta.class);
        oper.setReturnQName(new javax.xml.namespace.QName("http://201.54.12.59/WS", "CadastrarVeiculoResult"));
        oper.setStyle(org.apache.axis.constants.Style.WRAPPED);
        oper.setUse(org.apache.axis.constants.Use.LITERAL);
        _operations[2] = oper;

        oper = new org.apache.axis.description.OperationDesc();
        oper.setName("CadastrarCPF");
        param = new org.apache.axis.description.ParameterDesc(new javax.xml.namespace.QName("http://201.54.12.59/WS", "Dados"), org.apache.axis.description.ParameterDesc.IN, new javax.xml.namespace.QName("http://201.54.12.59/WS", "CadastrarCPFRequest"), _59._12._54._201.WS.CadastrarCPFRequest.class, false, false);
        param.setOmittable(true);
        oper.addParameter(param);
        oper.setReturnType(new javax.xml.namespace.QName("http://201.54.12.59/WS", "CadastrarCPFResposta"));
        oper.setReturnClass(_59._12._54._201.WS.CadastrarCPFResposta.class);
        oper.setReturnQName(new javax.xml.namespace.QName("http://201.54.12.59/WS", "CadastrarCPFResult"));
        oper.setStyle(org.apache.axis.constants.Style.WRAPPED);
        oper.setUse(org.apache.axis.constants.Use.LITERAL);
        _operations[3] = oper;

        oper = new org.apache.axis.description.OperationDesc();
        oper.setName("SolicitacaoMonitoramento");
        param = new org.apache.axis.description.ParameterDesc(new javax.xml.namespace.QName("http://201.54.12.59/WS", "stringXML"), org.apache.axis.description.ParameterDesc.IN, new javax.xml.namespace.QName("http://www.w3.org/2001/XMLSchema", "string"), java.lang.String.class, false, false);
        param.setOmittable(true);
        oper.addParameter(param);
        oper.setReturnType(new javax.xml.namespace.QName("http://201.54.12.59/WS", "SolicitacaoMonitoramentoResposta"));
        oper.setReturnClass(_59._12._54._201.WS.SolicitacaoMonitoramentoResposta.class);
        oper.setReturnQName(new javax.xml.namespace.QName("http://201.54.12.59/WS", "SolicitacaoMonitoramentoResult"));
        oper.setStyle(org.apache.axis.constants.Style.WRAPPED);
        oper.setUse(org.apache.axis.constants.Use.LITERAL);
        _operations[4] = oper;

        oper = new org.apache.axis.description.OperationDesc();
        oper.setName("AlterarSM");
        param = new org.apache.axis.description.ParameterDesc(new javax.xml.namespace.QName("http://201.54.12.59/WS", "CPF"), org.apache.axis.description.ParameterDesc.IN, new javax.xml.namespace.QName("http://www.w3.org/2001/XMLSchema", "string"), java.lang.String.class, false, false);
        param.setOmittable(true);
        oper.addParameter(param);
        param = new org.apache.axis.description.ParameterDesc(new javax.xml.namespace.QName("http://201.54.12.59/WS", "Placa"), org.apache.axis.description.ParameterDesc.IN, new javax.xml.namespace.QName("http://www.w3.org/2001/XMLSchema", "string"), java.lang.String.class, false, false);
        param.setOmittable(true);
        oper.addParameter(param);
        param = new org.apache.axis.description.ParameterDesc(new javax.xml.namespace.QName("http://201.54.12.59/WS", "PlacaCarreta"), org.apache.axis.description.ParameterDesc.IN, new javax.xml.namespace.QName("http://www.w3.org/2001/XMLSchema", "string"), java.lang.String.class, false, false);
        param.setOmittable(true);
        oper.addParameter(param);
        param = new org.apache.axis.description.ParameterDesc(new javax.xml.namespace.QName("http://201.54.12.59/WS", "CodigoSM"), org.apache.axis.description.ParameterDesc.IN, new javax.xml.namespace.QName("http://www.w3.org/2001/XMLSchema", "string"), java.lang.String.class, false, false);
        param.setOmittable(true);
        oper.addParameter(param);
        param = new org.apache.axis.description.ParameterDesc(new javax.xml.namespace.QName("http://201.54.12.59/WS", "Autenticacao"), org.apache.axis.description.ParameterDesc.IN, new javax.xml.namespace.QName("http://www.w3.org/2001/XMLSchema", "string"), java.lang.String.class, false, false);
        param.setOmittable(true);
        oper.addParameter(param);
        oper.setReturnType(new javax.xml.namespace.QName("http://201.54.12.59/WS", "AlterarSMResposta"));
        oper.setReturnClass(_59._12._54._201.WS.AlterarSMResposta.class);
        oper.setReturnQName(new javax.xml.namespace.QName("http://201.54.12.59/WS", "AlterarSMResult"));
        oper.setStyle(org.apache.axis.constants.Style.WRAPPED);
        oper.setUse(org.apache.axis.constants.Use.LITERAL);
        _operations[5] = oper;

    }

    public BrasilRiskSoapStub() throws org.apache.axis.AxisFault {
         this(null);
    }

    public BrasilRiskSoapStub(java.net.URL endpointURL, javax.xml.rpc.Service service) throws org.apache.axis.AxisFault {
         this(service);
         super.cachedEndpoint = endpointURL;
    }

    public BrasilRiskSoapStub(javax.xml.rpc.Service service) throws org.apache.axis.AxisFault {
        if (service == null) {
            super.service = new org.apache.axis.client.Service();
        } else {
            super.service = service;
        }
        ((org.apache.axis.client.Service)super.service).setTypeMappingVersion("1.2");
            java.lang.Class cls;
            javax.xml.namespace.QName qName;
            javax.xml.namespace.QName qName2;
            java.lang.Class beansf = org.apache.axis.encoding.ser.BeanSerializerFactory.class;
            java.lang.Class beandf = org.apache.axis.encoding.ser.BeanDeserializerFactory.class;
            java.lang.Class enumsf = org.apache.axis.encoding.ser.EnumSerializerFactory.class;
            java.lang.Class enumdf = org.apache.axis.encoding.ser.EnumDeserializerFactory.class;
            java.lang.Class arraysf = org.apache.axis.encoding.ser.ArraySerializerFactory.class;
            java.lang.Class arraydf = org.apache.axis.encoding.ser.ArrayDeserializerFactory.class;
            java.lang.Class simplesf = org.apache.axis.encoding.ser.SimpleSerializerFactory.class;
            java.lang.Class simpledf = org.apache.axis.encoding.ser.SimpleDeserializerFactory.class;
            java.lang.Class simplelistsf = org.apache.axis.encoding.ser.SimpleListSerializerFactory.class;
            java.lang.Class simplelistdf = org.apache.axis.encoding.ser.SimpleListDeserializerFactory.class;
            qName = new javax.xml.namespace.QName("http://201.54.12.59/WS", "AlterarSMResposta");
            cachedSerQNames.add(qName);
            cls = _59._12._54._201.WS.AlterarSMResposta.class;
            cachedSerClasses.add(cls);
            cachedSerFactories.add(beansf);
            cachedDeserFactories.add(beandf);

            qName = new javax.xml.namespace.QName("http://201.54.12.59/WS", "CadastrarCPFRequest");
            cachedSerQNames.add(qName);
            cls = _59._12._54._201.WS.CadastrarCPFRequest.class;
            cachedSerClasses.add(cls);
            cachedSerFactories.add(beansf);
            cachedDeserFactories.add(beandf);

            qName = new javax.xml.namespace.QName("http://201.54.12.59/WS", "CadastrarCPFResposta");
            cachedSerQNames.add(qName);
            cls = _59._12._54._201.WS.CadastrarCPFResposta.class;
            cachedSerClasses.add(cls);
            cachedSerFactories.add(beansf);
            cachedDeserFactories.add(beandf);

            qName = new javax.xml.namespace.QName("http://201.54.12.59/WS", "CadastrarVeiculoRequest");
            cachedSerQNames.add(qName);
            cls = _59._12._54._201.WS.CadastrarVeiculoRequest.class;
            cachedSerClasses.add(cls);
            cachedSerFactories.add(beansf);
            cachedDeserFactories.add(beandf);

            qName = new javax.xml.namespace.QName("http://201.54.12.59/WS", "CadastrarVeiculoResposta");
            cachedSerQNames.add(qName);
            cls = _59._12._54._201.WS.CadastrarVeiculoResposta.class;
            cachedSerClasses.add(cls);
            cachedSerFactories.add(beansf);
            cachedDeserFactories.add(beandf);

            qName = new javax.xml.namespace.QName("http://201.54.12.59/WS", "ConsultaCPFMotoristaResposta");
            cachedSerQNames.add(qName);
            cls = _59._12._54._201.WS.ConsultaCPFMotoristaResposta.class;
            cachedSerClasses.add(cls);
            cachedSerFactories.add(beansf);
            cachedDeserFactories.add(beandf);

            qName = new javax.xml.namespace.QName("http://201.54.12.59/WS", "ConsultaPlacaVeiculoResposta");
            cachedSerQNames.add(qName);
            cls = _59._12._54._201.WS.ConsultaPlacaVeiculoResposta.class;
            cachedSerClasses.add(cls);
            cachedSerFactories.add(beansf);
            cachedDeserFactories.add(beandf);

            qName = new javax.xml.namespace.QName("http://201.54.12.59/WS", "SolicitacaoMonitoramentoResposta");
            cachedSerQNames.add(qName);
            cls = _59._12._54._201.WS.SolicitacaoMonitoramentoResposta.class;
            cachedSerClasses.add(cls);
            cachedSerFactories.add(beansf);
            cachedDeserFactories.add(beandf);

    }

    protected org.apache.axis.client.Call createCall() throws java.rmi.RemoteException {
        try {
            org.apache.axis.client.Call _call = super._createCall();
            if (super.maintainSessionSet) {
                _call.setMaintainSession(super.maintainSession);
            }
            if (super.cachedUsername != null) {
                _call.setUsername(super.cachedUsername);
            }
            if (super.cachedPassword != null) {
                _call.setPassword(super.cachedPassword);
            }
            if (super.cachedEndpoint != null) {
                _call.setTargetEndpointAddress(super.cachedEndpoint);
            }
            if (super.cachedTimeout != null) {
                _call.setTimeout(super.cachedTimeout);
            }
            if (super.cachedPortName != null) {
                _call.setPortName(super.cachedPortName);
            }
            java.util.Enumeration keys = super.cachedProperties.keys();
            while (keys.hasMoreElements()) {
                java.lang.String key = (java.lang.String) keys.nextElement();
                _call.setProperty(key, super.cachedProperties.get(key));
            }
            // All the type mapping information is registered
            // when the first call is made.
            // The type mapping information is actually registered in
            // the TypeMappingRegistry of the service, which
            // is the reason why registration is only needed for the first call.
            synchronized (this) {
                if (firstCall()) {
                    // must set encoding style before registering serializers
                    _call.setEncodingStyle(null);
                    for (int i = 0; i < cachedSerFactories.size(); ++i) {
                        java.lang.Class cls = (java.lang.Class) cachedSerClasses.get(i);
                        javax.xml.namespace.QName qName =
                                (javax.xml.namespace.QName) cachedSerQNames.get(i);
                        java.lang.Object x = cachedSerFactories.get(i);
                        if (x instanceof Class) {
                            java.lang.Class sf = (java.lang.Class)
                                 cachedSerFactories.get(i);
                            java.lang.Class df = (java.lang.Class)
                                 cachedDeserFactories.get(i);
                            _call.registerTypeMapping(cls, qName, sf, df, false);
                        }
                        else if (x instanceof javax.xml.rpc.encoding.SerializerFactory) {
                            org.apache.axis.encoding.SerializerFactory sf = (org.apache.axis.encoding.SerializerFactory)
                                 cachedSerFactories.get(i);
                            org.apache.axis.encoding.DeserializerFactory df = (org.apache.axis.encoding.DeserializerFactory)
                                 cachedDeserFactories.get(i);
                            _call.registerTypeMapping(cls, qName, sf, df, false);
                        }
                    }
                }
            }
            return _call;
        }
        catch (java.lang.Throwable _t) {
            throw new org.apache.axis.AxisFault("Failure trying to get the Call object", _t);
        }
    }

    public _59._12._54._201.WS.ConsultaPlacaVeiculoResposta consultaPlacaVeiculo(java.lang.String placa, java.lang.String autenticacao) throws java.rmi.RemoteException {
        if (super.cachedEndpoint == null) {
            throw new org.apache.axis.NoEndPointException();
        }
        org.apache.axis.client.Call _call = createCall();
        _call.setOperation(_operations[0]);
        _call.setUseSOAPAction(true);
        _call.setSOAPActionURI("http://201.54.12.59/WS/ConsultaPlacaVeiculo");
        _call.setEncodingStyle(null);
        _call.setProperty(org.apache.axis.client.Call.SEND_TYPE_ATTR, Boolean.FALSE);
        _call.setProperty(org.apache.axis.AxisEngine.PROP_DOMULTIREFS, Boolean.FALSE);
        _call.setSOAPVersion(org.apache.axis.soap.SOAPConstants.SOAP11_CONSTANTS);
        _call.setOperationName(new javax.xml.namespace.QName("http://201.54.12.59/WS", "ConsultaPlacaVeiculo"));

        setRequestHeaders(_call);
        setAttachments(_call);
 try {        java.lang.Object _resp = _call.invoke(new java.lang.Object[] {placa, autenticacao});

        if (_resp instanceof java.rmi.RemoteException) {
            throw (java.rmi.RemoteException)_resp;
        }
        else {
            extractAttachments(_call);
            try {
                return (_59._12._54._201.WS.ConsultaPlacaVeiculoResposta) _resp;
            } catch (java.lang.Exception _exception) {
                return (_59._12._54._201.WS.ConsultaPlacaVeiculoResposta) org.apache.axis.utils.JavaUtils.convert(_resp, _59._12._54._201.WS.ConsultaPlacaVeiculoResposta.class);
            }
        }
  } catch (org.apache.axis.AxisFault axisFaultException) {
  throw axisFaultException;
}
    }

    public _59._12._54._201.WS.ConsultaCPFMotoristaResposta consultaCPFMotorista(java.lang.String CPF, java.lang.String autenticacao) throws java.rmi.RemoteException {
        if (super.cachedEndpoint == null) {
            throw new org.apache.axis.NoEndPointException();
        }
        org.apache.axis.client.Call _call = createCall();
        _call.setOperation(_operations[1]);
        _call.setUseSOAPAction(true);
        _call.setSOAPActionURI("http://201.54.12.59/WS/ConsultaCPFMotorista");
        _call.setEncodingStyle(null);
        _call.setProperty(org.apache.axis.client.Call.SEND_TYPE_ATTR, Boolean.FALSE);
        _call.setProperty(org.apache.axis.AxisEngine.PROP_DOMULTIREFS, Boolean.FALSE);
        _call.setSOAPVersion(org.apache.axis.soap.SOAPConstants.SOAP11_CONSTANTS);
        _call.setOperationName(new javax.xml.namespace.QName("http://201.54.12.59/WS", "ConsultaCPFMotorista"));

        setRequestHeaders(_call);
        setAttachments(_call);
 try {        java.lang.Object _resp = _call.invoke(new java.lang.Object[] {CPF, autenticacao});

        if (_resp instanceof java.rmi.RemoteException) {
            throw (java.rmi.RemoteException)_resp;
        }
        else {
            extractAttachments(_call);
            try {
                return (_59._12._54._201.WS.ConsultaCPFMotoristaResposta) _resp;
            } catch (java.lang.Exception _exception) {
                return (_59._12._54._201.WS.ConsultaCPFMotoristaResposta) org.apache.axis.utils.JavaUtils.convert(_resp, _59._12._54._201.WS.ConsultaCPFMotoristaResposta.class);
            }
        }
  } catch (org.apache.axis.AxisFault axisFaultException) {
  throw axisFaultException;
}
    }

    public _59._12._54._201.WS.CadastrarVeiculoResposta cadastrarVeiculo(_59._12._54._201.WS.CadastrarVeiculoRequest cadastro) throws java.rmi.RemoteException {
        if (super.cachedEndpoint == null) {
            throw new org.apache.axis.NoEndPointException();
        }
        org.apache.axis.client.Call _call = createCall();
        _call.setOperation(_operations[2]);
        _call.setUseSOAPAction(true);
        _call.setSOAPActionURI("http://201.54.12.59/WS/CadastrarVeiculo");
        _call.setEncodingStyle(null);
        _call.setProperty(org.apache.axis.client.Call.SEND_TYPE_ATTR, Boolean.FALSE);
        _call.setProperty(org.apache.axis.AxisEngine.PROP_DOMULTIREFS, Boolean.FALSE);
        _call.setSOAPVersion(org.apache.axis.soap.SOAPConstants.SOAP11_CONSTANTS);
        _call.setOperationName(new javax.xml.namespace.QName("http://201.54.12.59/WS", "CadastrarVeiculo"));

        setRequestHeaders(_call);
        setAttachments(_call);
 try {        java.lang.Object _resp = _call.invoke(new java.lang.Object[] {cadastro});

        if (_resp instanceof java.rmi.RemoteException) {
            throw (java.rmi.RemoteException)_resp;
        }
        else {
            extractAttachments(_call);
            try {
                return (_59._12._54._201.WS.CadastrarVeiculoResposta) _resp;
            } catch (java.lang.Exception _exception) {
                return (_59._12._54._201.WS.CadastrarVeiculoResposta) org.apache.axis.utils.JavaUtils.convert(_resp, _59._12._54._201.WS.CadastrarVeiculoResposta.class);
            }
        }
  } catch (org.apache.axis.AxisFault axisFaultException) {
  throw axisFaultException;
}
    }

    public _59._12._54._201.WS.CadastrarCPFResposta cadastrarCPF(_59._12._54._201.WS.CadastrarCPFRequest dados) throws java.rmi.RemoteException {
        if (super.cachedEndpoint == null) {
            throw new org.apache.axis.NoEndPointException();
        }
        org.apache.axis.client.Call _call = createCall();
        _call.setOperation(_operations[3]);
        _call.setUseSOAPAction(true);
        _call.setSOAPActionURI("http://201.54.12.59/WS/CadastrarCPF");
        _call.setEncodingStyle(null);
        _call.setProperty(org.apache.axis.client.Call.SEND_TYPE_ATTR, Boolean.FALSE);
        _call.setProperty(org.apache.axis.AxisEngine.PROP_DOMULTIREFS, Boolean.FALSE);
        _call.setSOAPVersion(org.apache.axis.soap.SOAPConstants.SOAP11_CONSTANTS);
        _call.setOperationName(new javax.xml.namespace.QName("http://201.54.12.59/WS", "CadastrarCPF"));

        setRequestHeaders(_call);
        setAttachments(_call);
 try {        java.lang.Object _resp = _call.invoke(new java.lang.Object[] {dados});

        if (_resp instanceof java.rmi.RemoteException) {
            throw (java.rmi.RemoteException)_resp;
        }
        else {
            extractAttachments(_call);
            try {
                return (_59._12._54._201.WS.CadastrarCPFResposta) _resp;
            } catch (java.lang.Exception _exception) {
                return (_59._12._54._201.WS.CadastrarCPFResposta) org.apache.axis.utils.JavaUtils.convert(_resp, _59._12._54._201.WS.CadastrarCPFResposta.class);
            }
        }
  } catch (org.apache.axis.AxisFault axisFaultException) {
  throw axisFaultException;
}
    }

    public _59._12._54._201.WS.SolicitacaoMonitoramentoResposta solicitacaoMonitoramento(java.lang.String stringXML) throws java.rmi.RemoteException {
        if (super.cachedEndpoint == null) {
            throw new org.apache.axis.NoEndPointException();
        }
        org.apache.axis.client.Call _call = createCall();
        _call.setOperation(_operations[4]);
        _call.setUseSOAPAction(true);
        _call.setSOAPActionURI("http://201.54.12.59/WS/SolicitacaoMonitoramento");
        _call.setEncodingStyle(null);
        _call.setProperty(org.apache.axis.client.Call.SEND_TYPE_ATTR, Boolean.FALSE);
        _call.setProperty(org.apache.axis.AxisEngine.PROP_DOMULTIREFS, Boolean.FALSE);
        _call.setSOAPVersion(org.apache.axis.soap.SOAPConstants.SOAP11_CONSTANTS);
        _call.setOperationName(new javax.xml.namespace.QName("http://201.54.12.59/WS", "SolicitacaoMonitoramento"));

        setRequestHeaders(_call);
        setAttachments(_call);
 try {        java.lang.Object _resp = _call.invoke(new java.lang.Object[] {stringXML});

        if (_resp instanceof java.rmi.RemoteException) {
            throw (java.rmi.RemoteException)_resp;
        }
        else {
            extractAttachments(_call);
            try {
                return (_59._12._54._201.WS.SolicitacaoMonitoramentoResposta) _resp;
            } catch (java.lang.Exception _exception) {
                return (_59._12._54._201.WS.SolicitacaoMonitoramentoResposta) org.apache.axis.utils.JavaUtils.convert(_resp, _59._12._54._201.WS.SolicitacaoMonitoramentoResposta.class);
            }
        }
  } catch (org.apache.axis.AxisFault axisFaultException) {
  throw axisFaultException;
}
    }

    public _59._12._54._201.WS.AlterarSMResposta alterarSM(java.lang.String CPF, java.lang.String placa, java.lang.String placaCarreta, java.lang.String codigoSM, java.lang.String autenticacao) throws java.rmi.RemoteException {
        if (super.cachedEndpoint == null) {
            throw new org.apache.axis.NoEndPointException();
        }
        org.apache.axis.client.Call _call = createCall();
        _call.setOperation(_operations[5]);
        _call.setUseSOAPAction(true);
        _call.setSOAPActionURI("http://201.54.12.59/WS/AlterarSM");
        _call.setEncodingStyle(null);
        _call.setProperty(org.apache.axis.client.Call.SEND_TYPE_ATTR, Boolean.FALSE);
        _call.setProperty(org.apache.axis.AxisEngine.PROP_DOMULTIREFS, Boolean.FALSE);
        _call.setSOAPVersion(org.apache.axis.soap.SOAPConstants.SOAP11_CONSTANTS);
        _call.setOperationName(new javax.xml.namespace.QName("http://201.54.12.59/WS", "AlterarSM"));

        setRequestHeaders(_call);
        setAttachments(_call);
 try {        java.lang.Object _resp = _call.invoke(new java.lang.Object[] {CPF, placa, placaCarreta, codigoSM, autenticacao});

        if (_resp instanceof java.rmi.RemoteException) {
            throw (java.rmi.RemoteException)_resp;
        }
        else {
            extractAttachments(_call);
            try {
                return (_59._12._54._201.WS.AlterarSMResposta) _resp;
            } catch (java.lang.Exception _exception) {
                return (_59._12._54._201.WS.AlterarSMResposta) org.apache.axis.utils.JavaUtils.convert(_resp, _59._12._54._201.WS.AlterarSMResposta.class);
            }
        }
  } catch (org.apache.axis.AxisFault axisFaultException) {
  throw axisFaultException;
}
    }

}
