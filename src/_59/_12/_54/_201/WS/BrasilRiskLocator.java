/**
 * BrasilRiskLocator.java
 *
 * This file was auto-generated from WSDL
 * by the Apache Axis 1.4 Apr 22, 2006 (06:55:48 PDT) WSDL2Java emitter.
 */

package _59._12._54._201.WS;

public class BrasilRiskLocator extends org.apache.axis.client.Service implements _59._12._54._201.WS.BrasilRisk {

    public BrasilRiskLocator() {
    }


    public BrasilRiskLocator(org.apache.axis.EngineConfiguration config) {
        super(config);
    }

    public BrasilRiskLocator(java.lang.String wsdlLoc, javax.xml.namespace.QName sName) throws javax.xml.rpc.ServiceException {
        super(wsdlLoc, sName);
    }

    // Use to get a proxy class for BrasilRiskSoap
    private java.lang.String BrasilRiskSoap_address = "http://201.54.12.59/WS/BrasilRiskWS.asmx";

    public java.lang.String getBrasilRiskSoapAddress() {
        return BrasilRiskSoap_address;
    }

    // The WSDD service name defaults to the port name.
    private java.lang.String BrasilRiskSoapWSDDServiceName = "BrasilRiskSoap";

    public java.lang.String getBrasilRiskSoapWSDDServiceName() {
        return BrasilRiskSoapWSDDServiceName;
    }

    public void setBrasilRiskSoapWSDDServiceName(java.lang.String name) {
        BrasilRiskSoapWSDDServiceName = name;
    }

    public _59._12._54._201.WS.BrasilRiskSoap getBrasilRiskSoap() throws javax.xml.rpc.ServiceException {
       java.net.URL endpoint;
        try {
            endpoint = new java.net.URL(BrasilRiskSoap_address);
        }
        catch (java.net.MalformedURLException e) {
            throw new javax.xml.rpc.ServiceException(e);
        }
        return getBrasilRiskSoap(endpoint);
    }

    public _59._12._54._201.WS.BrasilRiskSoap getBrasilRiskSoap(java.net.URL portAddress) throws javax.xml.rpc.ServiceException {
        try {
            _59._12._54._201.WS.BrasilRiskSoapStub _stub = new _59._12._54._201.WS.BrasilRiskSoapStub(portAddress, this);
            _stub.setPortName(getBrasilRiskSoapWSDDServiceName());
            return _stub;
        }
        catch (org.apache.axis.AxisFault e) {
            return null;
        }
    }

    public void setBrasilRiskSoapEndpointAddress(java.lang.String address) {
        BrasilRiskSoap_address = address;
    }

    /**
     * For the given interface, get the stub implementation.
     * If this service has no port for the given interface,
     * then ServiceException is thrown.
     */
    public java.rmi.Remote getPort(Class serviceEndpointInterface) throws javax.xml.rpc.ServiceException {
        try {
            if (_59._12._54._201.WS.BrasilRiskSoap.class.isAssignableFrom(serviceEndpointInterface)) {
                _59._12._54._201.WS.BrasilRiskSoapStub _stub = new _59._12._54._201.WS.BrasilRiskSoapStub(new java.net.URL(BrasilRiskSoap_address), this);
                _stub.setPortName(getBrasilRiskSoapWSDDServiceName());
                return _stub;
            }
        }
        catch (java.lang.Throwable t) {
            throw new javax.xml.rpc.ServiceException(t);
        }
        throw new javax.xml.rpc.ServiceException("There is no stub implementation for the interface:  " + (serviceEndpointInterface == null ? "null" : serviceEndpointInterface.getName()));
    }

    /**
     * For the given interface, get the stub implementation.
     * If this service has no port for the given interface,
     * then ServiceException is thrown.
     */
    public java.rmi.Remote getPort(javax.xml.namespace.QName portName, Class serviceEndpointInterface) throws javax.xml.rpc.ServiceException {
        if (portName == null) {
            return getPort(serviceEndpointInterface);
        }
        java.lang.String inputPortName = portName.getLocalPart();
        if ("BrasilRiskSoap".equals(inputPortName)) {
            return getBrasilRiskSoap();
        }
        else  {
            java.rmi.Remote _stub = getPort(serviceEndpointInterface);
            ((org.apache.axis.client.Stub) _stub).setPortName(portName);
            return _stub;
        }
    }

    public javax.xml.namespace.QName getServiceName() {
        return new javax.xml.namespace.QName("http://201.54.12.59/WS", "BrasilRisk");
    }

    private java.util.HashSet ports = null;

    public java.util.Iterator getPorts() {
        if (ports == null) {
            ports = new java.util.HashSet();
            ports.add(new javax.xml.namespace.QName("http://201.54.12.59/WS", "BrasilRiskSoap"));
        }
        return ports.iterator();
    }

    /**
    * Set the endpoint address for the specified port name.
    */
    public void setEndpointAddress(java.lang.String portName, java.lang.String address) throws javax.xml.rpc.ServiceException {
        
if ("BrasilRiskSoap".equals(portName)) {
            setBrasilRiskSoapEndpointAddress(address);
        }
        else 
{ // Unknown Port Name
            throw new javax.xml.rpc.ServiceException(" Cannot set Endpoint Address for Unknown Port" + portName);
        }
    }

    /**
    * Set the endpoint address for the specified port name.
    */
    public void setEndpointAddress(javax.xml.namespace.QName portName, java.lang.String address) throws javax.xml.rpc.ServiceException {
        setEndpointAddress(portName.getLocalPart(), address);
    }

}
