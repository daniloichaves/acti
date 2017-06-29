/**
 * ConsultaPlacaVeiculoResposta.java
 *
 * This file was auto-generated from WSDL
 * by the Apache Axis 1.4 Apr 22, 2006 (06:55:48 PDT) WSDL2Java emitter.
 */

package _59._12._54._201.WS;

public class ConsultaPlacaVeiculoResposta  implements java.io.Serializable {
    private int retornoErro;

    private java.lang.String mensagemErro;

    private int status;

    private boolean creditoOK;

    private boolean criminalOK;

    private boolean proprietarioOK;

    private java.util.Calendar dataValidade;

    public ConsultaPlacaVeiculoResposta() {
    }

    public ConsultaPlacaVeiculoResposta(
           int retornoErro,
           java.lang.String mensagemErro,
           int status,
           boolean creditoOK,
           boolean criminalOK,
           boolean proprietarioOK,
           java.util.Calendar dataValidade) {
           this.retornoErro = retornoErro;
           this.mensagemErro = mensagemErro;
           this.status = status;
           this.creditoOK = creditoOK;
           this.criminalOK = criminalOK;
           this.proprietarioOK = proprietarioOK;
           this.dataValidade = dataValidade;
    }


    /**
     * Gets the retornoErro value for this ConsultaPlacaVeiculoResposta.
     * 
     * @return retornoErro
     */
    public int getRetornoErro() {
        return retornoErro;
    }


    /**
     * Sets the retornoErro value for this ConsultaPlacaVeiculoResposta.
     * 
     * @param retornoErro
     */
    public void setRetornoErro(int retornoErro) {
        this.retornoErro = retornoErro;
    }


    /**
     * Gets the mensagemErro value for this ConsultaPlacaVeiculoResposta.
     * 
     * @return mensagemErro
     */
    public java.lang.String getMensagemErro() {
        return mensagemErro;
    }


    /**
     * Sets the mensagemErro value for this ConsultaPlacaVeiculoResposta.
     * 
     * @param mensagemErro
     */
    public void setMensagemErro(java.lang.String mensagemErro) {
        this.mensagemErro = mensagemErro;
    }


    /**
     * Gets the status value for this ConsultaPlacaVeiculoResposta.
     * 
     * @return status
     */
    public int getStatus() {
        return status;
    }


    /**
     * Sets the status value for this ConsultaPlacaVeiculoResposta.
     * 
     * @param status
     */
    public void setStatus(int status) {
        this.status = status;
    }


    /**
     * Gets the creditoOK value for this ConsultaPlacaVeiculoResposta.
     * 
     * @return creditoOK
     */
    public boolean isCreditoOK() {
        return creditoOK;
    }


    /**
     * Sets the creditoOK value for this ConsultaPlacaVeiculoResposta.
     * 
     * @param creditoOK
     */
    public void setCreditoOK(boolean creditoOK) {
        this.creditoOK = creditoOK;
    }


    /**
     * Gets the criminalOK value for this ConsultaPlacaVeiculoResposta.
     * 
     * @return criminalOK
     */
    public boolean isCriminalOK() {
        return criminalOK;
    }


    /**
     * Sets the criminalOK value for this ConsultaPlacaVeiculoResposta.
     * 
     * @param criminalOK
     */
    public void setCriminalOK(boolean criminalOK) {
        this.criminalOK = criminalOK;
    }


    /**
     * Gets the proprietarioOK value for this ConsultaPlacaVeiculoResposta.
     * 
     * @return proprietarioOK
     */
    public boolean isProprietarioOK() {
        return proprietarioOK;
    }


    /**
     * Sets the proprietarioOK value for this ConsultaPlacaVeiculoResposta.
     * 
     * @param proprietarioOK
     */
    public void setProprietarioOK(boolean proprietarioOK) {
        this.proprietarioOK = proprietarioOK;
    }


    /**
     * Gets the dataValidade value for this ConsultaPlacaVeiculoResposta.
     * 
     * @return dataValidade
     */
    public java.util.Calendar getDataValidade() {
        return dataValidade;
    }


    /**
     * Sets the dataValidade value for this ConsultaPlacaVeiculoResposta.
     * 
     * @param dataValidade
     */
    public void setDataValidade(java.util.Calendar dataValidade) {
        this.dataValidade = dataValidade;
    }

    private java.lang.Object __equalsCalc = null;
    public synchronized boolean equals(java.lang.Object obj) {
        if (!(obj instanceof ConsultaPlacaVeiculoResposta)) return false;
        ConsultaPlacaVeiculoResposta other = (ConsultaPlacaVeiculoResposta) obj;
        if (obj == null) return false;
        if (this == obj) return true;
        if (__equalsCalc != null) {
            return (__equalsCalc == obj);
        }
        __equalsCalc = obj;
        boolean _equals;
        _equals = true && 
            this.retornoErro == other.getRetornoErro() &&
            ((this.mensagemErro==null && other.getMensagemErro()==null) || 
             (this.mensagemErro!=null &&
              this.mensagemErro.equals(other.getMensagemErro()))) &&
            this.status == other.getStatus() &&
            this.creditoOK == other.isCreditoOK() &&
            this.criminalOK == other.isCriminalOK() &&
            this.proprietarioOK == other.isProprietarioOK() &&
            ((this.dataValidade==null && other.getDataValidade()==null) || 
             (this.dataValidade!=null &&
              this.dataValidade.equals(other.getDataValidade())));
        __equalsCalc = null;
        return _equals;
    }

    private boolean __hashCodeCalc = false;
    public synchronized int hashCode() {
        if (__hashCodeCalc) {
            return 0;
        }
        __hashCodeCalc = true;
        int _hashCode = 1;
        _hashCode += getRetornoErro();
        if (getMensagemErro() != null) {
            _hashCode += getMensagemErro().hashCode();
        }
        _hashCode += getStatus();
        _hashCode += (isCreditoOK() ? Boolean.TRUE : Boolean.FALSE).hashCode();
        _hashCode += (isCriminalOK() ? Boolean.TRUE : Boolean.FALSE).hashCode();
        _hashCode += (isProprietarioOK() ? Boolean.TRUE : Boolean.FALSE).hashCode();
        if (getDataValidade() != null) {
            _hashCode += getDataValidade().hashCode();
        }
        __hashCodeCalc = false;
        return _hashCode;
    }

    // Type metadata
    private static org.apache.axis.description.TypeDesc typeDesc =
        new org.apache.axis.description.TypeDesc(ConsultaPlacaVeiculoResposta.class, true);

    static {
        typeDesc.setXmlType(new javax.xml.namespace.QName("http://201.54.12.59/WS", "ConsultaPlacaVeiculoResposta"));
        org.apache.axis.description.ElementDesc elemField = new org.apache.axis.description.ElementDesc();
        elemField.setFieldName("retornoErro");
        elemField.setXmlName(new javax.xml.namespace.QName("http://201.54.12.59/WS", "retornoErro"));
        elemField.setXmlType(new javax.xml.namespace.QName("http://www.w3.org/2001/XMLSchema", "int"));
        elemField.setNillable(false);
        typeDesc.addFieldDesc(elemField);
        elemField = new org.apache.axis.description.ElementDesc();
        elemField.setFieldName("mensagemErro");
        elemField.setXmlName(new javax.xml.namespace.QName("http://201.54.12.59/WS", "mensagemErro"));
        elemField.setXmlType(new javax.xml.namespace.QName("http://www.w3.org/2001/XMLSchema", "string"));
        elemField.setMinOccurs(0);
        elemField.setNillable(false);
        typeDesc.addFieldDesc(elemField);
        elemField = new org.apache.axis.description.ElementDesc();
        elemField.setFieldName("status");
        elemField.setXmlName(new javax.xml.namespace.QName("http://201.54.12.59/WS", "Status"));
        elemField.setXmlType(new javax.xml.namespace.QName("http://www.w3.org/2001/XMLSchema", "int"));
        elemField.setNillable(false);
        typeDesc.addFieldDesc(elemField);
        elemField = new org.apache.axis.description.ElementDesc();
        elemField.setFieldName("creditoOK");
        elemField.setXmlName(new javax.xml.namespace.QName("http://201.54.12.59/WS", "CreditoOK"));
        elemField.setXmlType(new javax.xml.namespace.QName("http://www.w3.org/2001/XMLSchema", "boolean"));
        elemField.setNillable(false);
        typeDesc.addFieldDesc(elemField);
        elemField = new org.apache.axis.description.ElementDesc();
        elemField.setFieldName("criminalOK");
        elemField.setXmlName(new javax.xml.namespace.QName("http://201.54.12.59/WS", "CriminalOK"));
        elemField.setXmlType(new javax.xml.namespace.QName("http://www.w3.org/2001/XMLSchema", "boolean"));
        elemField.setNillable(false);
        typeDesc.addFieldDesc(elemField);
        elemField = new org.apache.axis.description.ElementDesc();
        elemField.setFieldName("proprietarioOK");
        elemField.setXmlName(new javax.xml.namespace.QName("http://201.54.12.59/WS", "ProprietarioOK"));
        elemField.setXmlType(new javax.xml.namespace.QName("http://www.w3.org/2001/XMLSchema", "boolean"));
        elemField.setNillable(false);
        typeDesc.addFieldDesc(elemField);
        elemField = new org.apache.axis.description.ElementDesc();
        elemField.setFieldName("dataValidade");
        elemField.setXmlName(new javax.xml.namespace.QName("http://201.54.12.59/WS", "DataValidade"));
        elemField.setXmlType(new javax.xml.namespace.QName("http://www.w3.org/2001/XMLSchema", "dateTime"));
        elemField.setNillable(false);
        typeDesc.addFieldDesc(elemField);
    }

    /**
     * Return type metadata object
     */
    public static org.apache.axis.description.TypeDesc getTypeDesc() {
        return typeDesc;
    }

    /**
     * Get Custom Serializer
     */
    public static org.apache.axis.encoding.Serializer getSerializer(
           java.lang.String mechType, 
           java.lang.Class _javaType,  
           javax.xml.namespace.QName _xmlType) {
        return 
          new  org.apache.axis.encoding.ser.BeanSerializer(
            _javaType, _xmlType, typeDesc);
    }

    /**
     * Get Custom Deserializer
     */
    public static org.apache.axis.encoding.Deserializer getDeserializer(
           java.lang.String mechType, 
           java.lang.Class _javaType,  
           javax.xml.namespace.QName _xmlType) {
        return 
          new  org.apache.axis.encoding.ser.BeanDeserializer(
            _javaType, _xmlType, typeDesc);
    }

}
