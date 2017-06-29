/**
 * CadastrarVeiculoResposta.java
 *
 * This file was auto-generated from WSDL
 * by the Apache Axis 1.4 Apr 22, 2006 (06:55:48 PDT) WSDL2Java emitter.
 */

package _59._12._54._201.WS;

public class CadastrarVeiculoResposta  implements java.io.Serializable {
    private int retornoErro;

    private java.lang.String mensagemErro;

    public CadastrarVeiculoResposta() {
    }

    public CadastrarVeiculoResposta(
           int retornoErro,
           java.lang.String mensagemErro) {
           this.retornoErro = retornoErro;
           this.mensagemErro = mensagemErro;
    }


    /**
     * Gets the retornoErro value for this CadastrarVeiculoResposta.
     * 
     * @return retornoErro
     */
    public int getRetornoErro() {
        return retornoErro;
    }


    /**
     * Sets the retornoErro value for this CadastrarVeiculoResposta.
     * 
     * @param retornoErro
     */
    public void setRetornoErro(int retornoErro) {
        this.retornoErro = retornoErro;
    }


    /**
     * Gets the mensagemErro value for this CadastrarVeiculoResposta.
     * 
     * @return mensagemErro
     */
    public java.lang.String getMensagemErro() {
        return mensagemErro;
    }


    /**
     * Sets the mensagemErro value for this CadastrarVeiculoResposta.
     * 
     * @param mensagemErro
     */
    public void setMensagemErro(java.lang.String mensagemErro) {
        this.mensagemErro = mensagemErro;
    }

    private java.lang.Object __equalsCalc = null;
    public synchronized boolean equals(java.lang.Object obj) {
        if (!(obj instanceof CadastrarVeiculoResposta)) return false;
        CadastrarVeiculoResposta other = (CadastrarVeiculoResposta) obj;
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
              this.mensagemErro.equals(other.getMensagemErro())));
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
        __hashCodeCalc = false;
        return _hashCode;
    }

    // Type metadata
    private static org.apache.axis.description.TypeDesc typeDesc =
        new org.apache.axis.description.TypeDesc(CadastrarVeiculoResposta.class, true);

    static {
        typeDesc.setXmlType(new javax.xml.namespace.QName("http://201.54.12.59/WS", "CadastrarVeiculoResposta"));
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
