/**
 * AlterarSMResposta.java
 *
 * This file was auto-generated from WSDL
 * by the Apache Axis 1.4 Apr 22, 2006 (06:55:48 PDT) WSDL2Java emitter.
 */

package _59._12._54._201.WS;

public class AlterarSMResposta  implements java.io.Serializable {
    private int retornoErro;

    private java.lang.String msgm;

    public AlterarSMResposta() {
    }

    public AlterarSMResposta(
           int retornoErro,
           java.lang.String msgm) {
           this.retornoErro = retornoErro;
           this.msgm = msgm;
    }


    /**
     * Gets the retornoErro value for this AlterarSMResposta.
     * 
     * @return retornoErro
     */
    public int getRetornoErro() {
        return retornoErro;
    }


    /**
     * Sets the retornoErro value for this AlterarSMResposta.
     * 
     * @param retornoErro
     */
    public void setRetornoErro(int retornoErro) {
        this.retornoErro = retornoErro;
    }


    /**
     * Gets the msgm value for this AlterarSMResposta.
     * 
     * @return msgm
     */
    public java.lang.String getMsgm() {
        return msgm;
    }


    /**
     * Sets the msgm value for this AlterarSMResposta.
     * 
     * @param msgm
     */
    public void setMsgm(java.lang.String msgm) {
        this.msgm = msgm;
    }

    private java.lang.Object __equalsCalc = null;
    public synchronized boolean equals(java.lang.Object obj) {
        if (!(obj instanceof AlterarSMResposta)) return false;
        AlterarSMResposta other = (AlterarSMResposta) obj;
        if (obj == null) return false;
        if (this == obj) return true;
        if (__equalsCalc != null) {
            return (__equalsCalc == obj);
        }
        __equalsCalc = obj;
        boolean _equals;
        _equals = true && 
            this.retornoErro == other.getRetornoErro() &&
            ((this.msgm==null && other.getMsgm()==null) || 
             (this.msgm!=null &&
              this.msgm.equals(other.getMsgm())));
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
        if (getMsgm() != null) {
            _hashCode += getMsgm().hashCode();
        }
        __hashCodeCalc = false;
        return _hashCode;
    }

    // Type metadata
    private static org.apache.axis.description.TypeDesc typeDesc =
        new org.apache.axis.description.TypeDesc(AlterarSMResposta.class, true);

    static {
        typeDesc.setXmlType(new javax.xml.namespace.QName("http://201.54.12.59/WS", "AlterarSMResposta"));
        org.apache.axis.description.ElementDesc elemField = new org.apache.axis.description.ElementDesc();
        elemField.setFieldName("retornoErro");
        elemField.setXmlName(new javax.xml.namespace.QName("http://201.54.12.59/WS", "retornoErro"));
        elemField.setXmlType(new javax.xml.namespace.QName("http://www.w3.org/2001/XMLSchema", "int"));
        elemField.setNillable(false);
        typeDesc.addFieldDesc(elemField);
        elemField = new org.apache.axis.description.ElementDesc();
        elemField.setFieldName("msgm");
        elemField.setXmlName(new javax.xml.namespace.QName("http://201.54.12.59/WS", "msgm"));
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
