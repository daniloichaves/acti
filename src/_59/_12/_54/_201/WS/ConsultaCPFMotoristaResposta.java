/**
 * ConsultaCPFMotoristaResposta.java
 *
 * This file was auto-generated from WSDL
 * by the Apache Axis 1.4 Apr 22, 2006 (06:55:48 PDT) WSDL2Java emitter.
 */

package _59._12._54._201.WS;

public class ConsultaCPFMotoristaResposta  implements java.io.Serializable {
    private int retornoErro;

    private java.lang.String mensagemErro;

    private long CPF;

    private java.util.Calendar CNHDataValidade;

    private java.lang.String CNHVencida;

    private int status;

    private boolean CNHOK;

    private boolean creditoOK;

    private boolean criminalOK;

    private java.util.Calendar dataValidade;

    public ConsultaCPFMotoristaResposta() {
    }

    public ConsultaCPFMotoristaResposta(
           int retornoErro,
           java.lang.String mensagemErro,
           long CPF,
           java.util.Calendar CNHDataValidade,
           java.lang.String CNHVencida,
           int status,
           boolean CNHOK,
           boolean creditoOK,
           boolean criminalOK,
           java.util.Calendar dataValidade) {
           this.retornoErro = retornoErro;
           this.mensagemErro = mensagemErro;
           this.CPF = CPF;
           this.CNHDataValidade = CNHDataValidade;
           this.CNHVencida = CNHVencida;
           this.status = status;
           this.CNHOK = CNHOK;
           this.creditoOK = creditoOK;
           this.criminalOK = criminalOK;
           this.dataValidade = dataValidade;
    }


    /**
     * Gets the retornoErro value for this ConsultaCPFMotoristaResposta.
     * 
     * @return retornoErro
     */
    public int getRetornoErro() {
        return retornoErro;
    }


    /**
     * Sets the retornoErro value for this ConsultaCPFMotoristaResposta.
     * 
     * @param retornoErro
     */
    public void setRetornoErro(int retornoErro) {
        this.retornoErro = retornoErro;
    }


    /**
     * Gets the mensagemErro value for this ConsultaCPFMotoristaResposta.
     * 
     * @return mensagemErro
     */
    public java.lang.String getMensagemErro() {
        return mensagemErro;
    }


    /**
     * Sets the mensagemErro value for this ConsultaCPFMotoristaResposta.
     * 
     * @param mensagemErro
     */
    public void setMensagemErro(java.lang.String mensagemErro) {
        this.mensagemErro = mensagemErro;
    }


    /**
     * Gets the CPF value for this ConsultaCPFMotoristaResposta.
     * 
     * @return CPF
     */
    public long getCPF() {
        return CPF;
    }


    /**
     * Sets the CPF value for this ConsultaCPFMotoristaResposta.
     * 
     * @param CPF
     */
    public void setCPF(long CPF) {
        this.CPF = CPF;
    }


    /**
     * Gets the CNHDataValidade value for this ConsultaCPFMotoristaResposta.
     * 
     * @return CNHDataValidade
     */
    public java.util.Calendar getCNHDataValidade() {
        return CNHDataValidade;
    }


    /**
     * Sets the CNHDataValidade value for this ConsultaCPFMotoristaResposta.
     * 
     * @param CNHDataValidade
     */
    public void setCNHDataValidade(java.util.Calendar CNHDataValidade) {
        this.CNHDataValidade = CNHDataValidade;
    }


    /**
     * Gets the CNHVencida value for this ConsultaCPFMotoristaResposta.
     * 
     * @return CNHVencida
     */
    public java.lang.String getCNHVencida() {
        return CNHVencida;
    }


    /**
     * Sets the CNHVencida value for this ConsultaCPFMotoristaResposta.
     * 
     * @param CNHVencida
     */
    public void setCNHVencida(java.lang.String CNHVencida) {
        this.CNHVencida = CNHVencida;
    }


    /**
     * Gets the status value for this ConsultaCPFMotoristaResposta.
     * 
     * @return status
     */
    public int getStatus() {
        return status;
    }


    /**
     * Sets the status value for this ConsultaCPFMotoristaResposta.
     * 
     * @param status
     */
    public void setStatus(int status) {
        this.status = status;
    }


    /**
     * Gets the CNHOK value for this ConsultaCPFMotoristaResposta.
     * 
     * @return CNHOK
     */
    public boolean isCNHOK() {
        return CNHOK;
    }


    /**
     * Sets the CNHOK value for this ConsultaCPFMotoristaResposta.
     * 
     * @param CNHOK
     */
    public void setCNHOK(boolean CNHOK) {
        this.CNHOK = CNHOK;
    }


    /**
     * Gets the creditoOK value for this ConsultaCPFMotoristaResposta.
     * 
     * @return creditoOK
     */
    public boolean isCreditoOK() {
        return creditoOK;
    }


    /**
     * Sets the creditoOK value for this ConsultaCPFMotoristaResposta.
     * 
     * @param creditoOK
     */
    public void setCreditoOK(boolean creditoOK) {
        this.creditoOK = creditoOK;
    }


    /**
     * Gets the criminalOK value for this ConsultaCPFMotoristaResposta.
     * 
     * @return criminalOK
     */
    public boolean isCriminalOK() {
        return criminalOK;
    }


    /**
     * Sets the criminalOK value for this ConsultaCPFMotoristaResposta.
     * 
     * @param criminalOK
     */
    public void setCriminalOK(boolean criminalOK) {
        this.criminalOK = criminalOK;
    }


    /**
     * Gets the dataValidade value for this ConsultaCPFMotoristaResposta.
     * 
     * @return dataValidade
     */
    public java.util.Calendar getDataValidade() {
        return dataValidade;
    }


    /**
     * Sets the dataValidade value for this ConsultaCPFMotoristaResposta.
     * 
     * @param dataValidade
     */
    public void setDataValidade(java.util.Calendar dataValidade) {
        this.dataValidade = dataValidade;
    }

    private java.lang.Object __equalsCalc = null;
    public synchronized boolean equals(java.lang.Object obj) {
        if (!(obj instanceof ConsultaCPFMotoristaResposta)) return false;
        ConsultaCPFMotoristaResposta other = (ConsultaCPFMotoristaResposta) obj;
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
            this.CPF == other.getCPF() &&
            ((this.CNHDataValidade==null && other.getCNHDataValidade()==null) || 
             (this.CNHDataValidade!=null &&
              this.CNHDataValidade.equals(other.getCNHDataValidade()))) &&
            ((this.CNHVencida==null && other.getCNHVencida()==null) || 
             (this.CNHVencida!=null &&
              this.CNHVencida.equals(other.getCNHVencida()))) &&
            this.status == other.getStatus() &&
            this.CNHOK == other.isCNHOK() &&
            this.creditoOK == other.isCreditoOK() &&
            this.criminalOK == other.isCriminalOK() &&
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
        _hashCode += new Long(getCPF()).hashCode();
        if (getCNHDataValidade() != null) {
            _hashCode += getCNHDataValidade().hashCode();
        }
        if (getCNHVencida() != null) {
            _hashCode += getCNHVencida().hashCode();
        }
        _hashCode += getStatus();
        _hashCode += (isCNHOK() ? Boolean.TRUE : Boolean.FALSE).hashCode();
        _hashCode += (isCreditoOK() ? Boolean.TRUE : Boolean.FALSE).hashCode();
        _hashCode += (isCriminalOK() ? Boolean.TRUE : Boolean.FALSE).hashCode();
        if (getDataValidade() != null) {
            _hashCode += getDataValidade().hashCode();
        }
        __hashCodeCalc = false;
        return _hashCode;
    }

    // Type metadata
    private static org.apache.axis.description.TypeDesc typeDesc =
        new org.apache.axis.description.TypeDesc(ConsultaCPFMotoristaResposta.class, true);

    static {
        typeDesc.setXmlType(new javax.xml.namespace.QName("http://201.54.12.59/WS", "ConsultaCPFMotoristaResposta"));
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
        elemField.setFieldName("CPF");
        elemField.setXmlName(new javax.xml.namespace.QName("http://201.54.12.59/WS", "CPF"));
        elemField.setXmlType(new javax.xml.namespace.QName("http://www.w3.org/2001/XMLSchema", "long"));
        elemField.setNillable(false);
        typeDesc.addFieldDesc(elemField);
        elemField = new org.apache.axis.description.ElementDesc();
        elemField.setFieldName("CNHDataValidade");
        elemField.setXmlName(new javax.xml.namespace.QName("http://201.54.12.59/WS", "CNHDataValidade"));
        elemField.setXmlType(new javax.xml.namespace.QName("http://www.w3.org/2001/XMLSchema", "dateTime"));
        elemField.setNillable(false);
        typeDesc.addFieldDesc(elemField);
        elemField = new org.apache.axis.description.ElementDesc();
        elemField.setFieldName("CNHVencida");
        elemField.setXmlName(new javax.xml.namespace.QName("http://201.54.12.59/WS", "CNHVencida"));
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
        elemField.setFieldName("CNHOK");
        elemField.setXmlName(new javax.xml.namespace.QName("http://201.54.12.59/WS", "CNHOK"));
        elemField.setXmlType(new javax.xml.namespace.QName("http://www.w3.org/2001/XMLSchema", "boolean"));
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
