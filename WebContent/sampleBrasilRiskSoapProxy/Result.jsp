<%@page contentType="text/html;charset=UTF-8"%>
<% request.setCharacterEncoding("UTF-8"); %>
<HTML>
<HEAD>
<TITLE>Result</TITLE>
</HEAD>
<BODY>
<H1>Result</H1>

<jsp:useBean id="sampleBrasilRiskSoapProxyid" scope="session" class="_59._12._54._201.WS.BrasilRiskSoapProxy" />
<%
if (request.getParameter("endpoint") != null && request.getParameter("endpoint").length() > 0)
sampleBrasilRiskSoapProxyid.setEndpoint(request.getParameter("endpoint"));
%>

<%
String method = request.getParameter("method");
int methodID = 0;
if (method == null) methodID = -1;

if(methodID != -1) methodID = Integer.parseInt(method);
boolean gotMethod = false;

try {
switch (methodID){ 
case 2:
        gotMethod = true;
        java.lang.String getEndpoint2mtemp = sampleBrasilRiskSoapProxyid.getEndpoint();
if(getEndpoint2mtemp == null){
%>
<%=getEndpoint2mtemp %>
<%
}else{
        String tempResultreturnp3 = org.eclipse.jst.ws.util.JspUtils.markup(String.valueOf(getEndpoint2mtemp));
        %>
        <%= tempResultreturnp3 %>
        <%
}
break;
case 5:
        gotMethod = true;
        String endpoint_0id=  request.getParameter("endpoint8");
            java.lang.String endpoint_0idTemp = null;
        if(!endpoint_0id.equals("")){
         endpoint_0idTemp  = endpoint_0id;
        }
        sampleBrasilRiskSoapProxyid.setEndpoint(endpoint_0idTemp);
break;
case 10:
        gotMethod = true;
        _59._12._54._201.WS.BrasilRiskSoap getBrasilRiskSoap10mtemp = sampleBrasilRiskSoapProxyid.getBrasilRiskSoap();
if(getBrasilRiskSoap10mtemp == null){
%>
<%=getBrasilRiskSoap10mtemp %>
<%
}else{
        if(getBrasilRiskSoap10mtemp!= null){
        String tempreturnp11 = getBrasilRiskSoap10mtemp.toString();
        %>
        <%=tempreturnp11%>
        <%
        }}
break;
case 13:
        gotMethod = true;
        String placa_1id=  request.getParameter("placa30");
            java.lang.String placa_1idTemp = null;
        if(!placa_1id.equals("")){
         placa_1idTemp  = placa_1id;
        }
        String autenticacao_2id=  request.getParameter("autenticacao32");
            java.lang.String autenticacao_2idTemp = null;
        if(!autenticacao_2id.equals("")){
         autenticacao_2idTemp  = autenticacao_2id;
        }
        _59._12._54._201.WS.ConsultaPlacaVeiculoResposta consultaPlacaVeiculo13mtemp = sampleBrasilRiskSoapProxyid.consultaPlacaVeiculo(placa_1idTemp,autenticacao_2idTemp);
if(consultaPlacaVeiculo13mtemp == null){
%>
<%=consultaPlacaVeiculo13mtemp %>
<%
}else{
%>
<TABLE>
<TR>
<TD COLSPAN="3" ALIGN="LEFT">returnp:</TD>
<TR>
<TD WIDTH="5%"></TD>
<TD COLSPAN="2" ALIGN="LEFT">criminalOK:</TD>
<TD>
<%
if(consultaPlacaVeiculo13mtemp != null){
%>
<%=consultaPlacaVeiculo13mtemp.isCriminalOK()
%><%}%>
</TD>
<TR>
<TD WIDTH="5%"></TD>
<TD COLSPAN="2" ALIGN="LEFT">status:</TD>
<TD>
<%
if(consultaPlacaVeiculo13mtemp != null){
%>
<%=consultaPlacaVeiculo13mtemp.getStatus()
%><%}%>
</TD>
<TR>
<TD WIDTH="5%"></TD>
<TD COLSPAN="2" ALIGN="LEFT">mensagemErro:</TD>
<TD>
<%
if(consultaPlacaVeiculo13mtemp != null){
java.lang.String typemensagemErro20 = consultaPlacaVeiculo13mtemp.getMensagemErro();
        String tempResultmensagemErro20 = org.eclipse.jst.ws.util.JspUtils.markup(String.valueOf(typemensagemErro20));
        %>
        <%= tempResultmensagemErro20 %>
        <%
}%>
</TD>
<TR>
<TD WIDTH="5%"></TD>
<TD COLSPAN="2" ALIGN="LEFT">dataValidade:</TD>
<TD>
<%
if(consultaPlacaVeiculo13mtemp != null){
java.util.Calendar typedataValidade22 = consultaPlacaVeiculo13mtemp.getDataValidade();
        java.text.DateFormat dateFormatdataValidade22 = java.text.DateFormat.getDateInstance();
        java.util.Date datedataValidade22 = typedataValidade22.getTime();
        String tempResultdataValidade22 = org.eclipse.jst.ws.util.JspUtils.markup(dateFormatdataValidade22.format(datedataValidade22));
        %>
        <%= tempResultdataValidade22 %>
        <%
}%>
</TD>
<TR>
<TD WIDTH="5%"></TD>
<TD COLSPAN="2" ALIGN="LEFT">retornoErro:</TD>
<TD>
<%
if(consultaPlacaVeiculo13mtemp != null){
%>
<%=consultaPlacaVeiculo13mtemp.getRetornoErro()
%><%}%>
</TD>
<TR>
<TD WIDTH="5%"></TD>
<TD COLSPAN="2" ALIGN="LEFT">proprietarioOK:</TD>
<TD>
<%
if(consultaPlacaVeiculo13mtemp != null){
%>
<%=consultaPlacaVeiculo13mtemp.isProprietarioOK()
%><%}%>
</TD>
<TR>
<TD WIDTH="5%"></TD>
<TD COLSPAN="2" ALIGN="LEFT">creditoOK:</TD>
<TD>
<%
if(consultaPlacaVeiculo13mtemp != null){
%>
<%=consultaPlacaVeiculo13mtemp.isCreditoOK()
%><%}%>
</TD>
</TABLE>
<%
}
break;
case 34:
        gotMethod = true;
        String CPF_3id=  request.getParameter("CPF57");
            java.lang.String CPF_3idTemp = null;
        if(!CPF_3id.equals("")){
         CPF_3idTemp  = CPF_3id;
        }
        String autenticacao_4id=  request.getParameter("autenticacao59");
            java.lang.String autenticacao_4idTemp = null;
        if(!autenticacao_4id.equals("")){
         autenticacao_4idTemp  = autenticacao_4id;
        }
        _59._12._54._201.WS.ConsultaCPFMotoristaResposta consultaCPFMotorista34mtemp = sampleBrasilRiskSoapProxyid.consultaCPFMotorista(CPF_3idTemp,autenticacao_4idTemp);
if(consultaCPFMotorista34mtemp == null){
%>
<%=consultaCPFMotorista34mtemp %>
<%
}else{
%>
<TABLE>
<TR>
<TD COLSPAN="3" ALIGN="LEFT">returnp:</TD>
<TR>
<TD WIDTH="5%"></TD>
<TD COLSPAN="2" ALIGN="LEFT">retornoErro:</TD>
<TD>
<%
if(consultaCPFMotorista34mtemp != null){
%>
<%=consultaCPFMotorista34mtemp.getRetornoErro()
%><%}%>
</TD>
<TR>
<TD WIDTH="5%"></TD>
<TD COLSPAN="2" ALIGN="LEFT">mensagemErro:</TD>
<TD>
<%
if(consultaCPFMotorista34mtemp != null){
java.lang.String typemensagemErro39 = consultaCPFMotorista34mtemp.getMensagemErro();
        String tempResultmensagemErro39 = org.eclipse.jst.ws.util.JspUtils.markup(String.valueOf(typemensagemErro39));
        %>
        <%= tempResultmensagemErro39 %>
        <%
}%>
</TD>
<TR>
<TD WIDTH="5%"></TD>
<TD COLSPAN="2" ALIGN="LEFT">criminalOK:</TD>
<TD>
<%
if(consultaCPFMotorista34mtemp != null){
%>
<%=consultaCPFMotorista34mtemp.isCriminalOK()
%><%}%>
</TD>
<TR>
<TD WIDTH="5%"></TD>
<TD COLSPAN="2" ALIGN="LEFT">status:</TD>
<TD>
<%
if(consultaCPFMotorista34mtemp != null){
%>
<%=consultaCPFMotorista34mtemp.getStatus()
%><%}%>
</TD>
<TR>
<TD WIDTH="5%"></TD>
<TD COLSPAN="2" ALIGN="LEFT">cNHVencida:</TD>
<TD>
<%
if(consultaCPFMotorista34mtemp != null){
java.lang.String typecNHVencida45 = consultaCPFMotorista34mtemp.getCNHVencida();
        String tempResultcNHVencida45 = org.eclipse.jst.ws.util.JspUtils.markup(String.valueOf(typecNHVencida45));
        %>
        <%= tempResultcNHVencida45 %>
        <%
}%>
</TD>
<TR>
<TD WIDTH="5%"></TD>
<TD COLSPAN="2" ALIGN="LEFT">dataValidade:</TD>
<TD>
<%
if(consultaCPFMotorista34mtemp != null){
java.util.Calendar typedataValidade47 = consultaCPFMotorista34mtemp.getDataValidade();
        java.text.DateFormat dateFormatdataValidade47 = java.text.DateFormat.getDateInstance();
        java.util.Date datedataValidade47 = typedataValidade47.getTime();
        String tempResultdataValidade47 = org.eclipse.jst.ws.util.JspUtils.markup(dateFormatdataValidade47.format(datedataValidade47));
        %>
        <%= tempResultdataValidade47 %>
        <%
}%>
</TD>
<TR>
<TD WIDTH="5%"></TD>
<TD COLSPAN="2" ALIGN="LEFT">cPF:</TD>
<TD>
<%
if(consultaCPFMotorista34mtemp != null){
%>
<%=consultaCPFMotorista34mtemp.getCPF()
%><%}%>
</TD>
<TR>
<TD WIDTH="5%"></TD>
<TD COLSPAN="2" ALIGN="LEFT">creditoOK:</TD>
<TD>
<%
if(consultaCPFMotorista34mtemp != null){
%>
<%=consultaCPFMotorista34mtemp.isCreditoOK()
%><%}%>
</TD>
<TR>
<TD WIDTH="5%"></TD>
<TD COLSPAN="2" ALIGN="LEFT">cNHDataValidade:</TD>
<TD>
<%
if(consultaCPFMotorista34mtemp != null){
java.util.Calendar typecNHDataValidade53 = consultaCPFMotorista34mtemp.getCNHDataValidade();
        java.text.DateFormat dateFormatcNHDataValidade53 = java.text.DateFormat.getDateInstance();
        java.util.Date datecNHDataValidade53 = typecNHDataValidade53.getTime();
        String tempResultcNHDataValidade53 = org.eclipse.jst.ws.util.JspUtils.markup(dateFormatcNHDataValidade53.format(datecNHDataValidade53));
        %>
        <%= tempResultcNHDataValidade53 %>
        <%
}%>
</TD>
<TR>
<TD WIDTH="5%"></TD>
<TD COLSPAN="2" ALIGN="LEFT">cNHOK:</TD>
<TD>
<%
if(consultaCPFMotorista34mtemp != null){
%>
<%=consultaCPFMotorista34mtemp.isCNHOK()
%><%}%>
</TD>
</TABLE>
<%
}
break;
case 61:
        gotMethod = true;
        String veiculo_Renavam_6id=  request.getParameter("veiculo_Renavam70");
            java.lang.String veiculo_Renavam_6idTemp = null;
        if(!veiculo_Renavam_6id.equals("")){
         veiculo_Renavam_6idTemp  = veiculo_Renavam_6id;
        }
        String proprietario_IE_RG_7id=  request.getParameter("proprietario_IE_RG72");
            java.lang.String proprietario_IE_RG_7idTemp = null;
        if(!proprietario_IE_RG_7id.equals("")){
         proprietario_IE_RG_7idTemp  = proprietario_IE_RG_7id;
        }
        String carreta_Renavam_8id=  request.getParameter("carreta_Renavam74");
            java.lang.String carreta_Renavam_8idTemp = null;
        if(!carreta_Renavam_8id.equals("")){
         carreta_Renavam_8idTemp  = carreta_Renavam_8id;
        }
        String numero_Terminal_9id=  request.getParameter("numero_Terminal76");
            java.lang.String numero_Terminal_9idTemp = null;
        if(!numero_Terminal_9id.equals("")){
         numero_Terminal_9idTemp  = numero_Terminal_9id;
        }
        String proprietario_Nome_Mae_10id=  request.getParameter("proprietario_Nome_Mae78");
            java.lang.String proprietario_Nome_Mae_10idTemp = null;
        if(!proprietario_Nome_Mae_10id.equals("")){
         proprietario_Nome_Mae_10idTemp  = proprietario_Nome_Mae_10id;
        }
        String carreta_Placa_11id=  request.getParameter("carreta_Placa80");
            java.lang.String carreta_Placa_11idTemp = null;
        if(!carreta_Placa_11id.equals("")){
         carreta_Placa_11idTemp  = carreta_Placa_11id;
        }
        String veiculo_Modelo_12id=  request.getParameter("veiculo_Modelo82");
            java.lang.String veiculo_Modelo_12idTemp = null;
        if(!veiculo_Modelo_12id.equals("")){
         veiculo_Modelo_12idTemp  = veiculo_Modelo_12id;
        }
        String proprietario_Data_Nascimento_13id=  request.getParameter("proprietario_Data_Nascimento84");
            java.util.Calendar proprietario_Data_Nascimento_13idTemp = null;
        if(!proprietario_Data_Nascimento_13id.equals("")){
        java.text.DateFormat dateFormatproprietario_Data_Nascimento84 = java.text.DateFormat.getDateInstance();
        java.util.Date dateTempproprietario_Data_Nascimento84  = dateFormatproprietario_Data_Nascimento84.parse(proprietario_Data_Nascimento_13id);
         proprietario_Data_Nascimento_13idTemp = new java.util.GregorianCalendar();
        proprietario_Data_Nascimento_13idTemp.setTime(dateTempproprietario_Data_Nascimento84);
        }
        String autenticacao_14id=  request.getParameter("autenticacao86");
            java.lang.String autenticacao_14idTemp = null;
        if(!autenticacao_14id.equals("")){
         autenticacao_14idTemp  = autenticacao_14id;
        }
        String veiculo_UF_15id=  request.getParameter("veiculo_UF88");
            java.lang.String veiculo_UF_15idTemp = null;
        if(!veiculo_UF_15id.equals("")){
         veiculo_UF_15idTemp  = veiculo_UF_15id;
        }
        String carreta_Tipo_16id=  request.getParameter("carreta_Tipo90");
            java.lang.String carreta_Tipo_16idTemp = null;
        if(!carreta_Tipo_16id.equals("")){
         carreta_Tipo_16idTemp  = carreta_Tipo_16id;
        }
        String veiculo_Chassi_17id=  request.getParameter("veiculo_Chassi92");
            java.lang.String veiculo_Chassi_17idTemp = null;
        if(!veiculo_Chassi_17id.equals("")){
         veiculo_Chassi_17idTemp  = veiculo_Chassi_17id;
        }
        String veiculo_Cor_18id=  request.getParameter("veiculo_Cor94");
            java.lang.String veiculo_Cor_18idTemp = null;
        if(!veiculo_Cor_18id.equals("")){
         veiculo_Cor_18idTemp  = veiculo_Cor_18id;
        }
        String proprietario_Tipo_Pessoa_19id=  request.getParameter("proprietario_Tipo_Pessoa96");
            java.lang.String proprietario_Tipo_Pessoa_19idTemp = null;
        if(!proprietario_Tipo_Pessoa_19id.equals("")){
         proprietario_Tipo_Pessoa_19idTemp  = proprietario_Tipo_Pessoa_19id;
        }
        String veiculo_Cidade_20id=  request.getParameter("veiculo_Cidade98");
            java.lang.String veiculo_Cidade_20idTemp = null;
        if(!veiculo_Cidade_20id.equals("")){
         veiculo_Cidade_20idTemp  = veiculo_Cidade_20id;
        }
        String equipamento_Status_21id=  request.getParameter("equipamento_Status100");
            java.lang.String equipamento_Status_21idTemp = null;
        if(!equipamento_Status_21id.equals("")){
         equipamento_Status_21idTemp  = equipamento_Status_21id;
        }
        String equipamento_Rastreamento_22id=  request.getParameter("equipamento_Rastreamento102");
            java.lang.String equipamento_Rastreamento_22idTemp = null;
        if(!equipamento_Rastreamento_22id.equals("")){
         equipamento_Rastreamento_22idTemp  = equipamento_Rastreamento_22id;
        }
        String veiculo_Marca_23id=  request.getParameter("veiculo_Marca104");
            java.lang.String veiculo_Marca_23idTemp = null;
        if(!veiculo_Marca_23id.equals("")){
         veiculo_Marca_23idTemp  = veiculo_Marca_23id;
        }
        String veiculo_Tipo_24id=  request.getParameter("veiculo_Tipo106");
            java.lang.String veiculo_Tipo_24idTemp = null;
        if(!veiculo_Tipo_24id.equals("")){
         veiculo_Tipo_24idTemp  = veiculo_Tipo_24id;
        }
        String proprietario_CNPJ_CPF_25id=  request.getParameter("proprietario_CNPJ_CPF108");
            java.lang.String proprietario_CNPJ_CPF_25idTemp = null;
        if(!proprietario_CNPJ_CPF_25id.equals("")){
         proprietario_CNPJ_CPF_25idTemp  = proprietario_CNPJ_CPF_25id;
        }
        String veiculo_Placa_26id=  request.getParameter("veiculo_Placa110");
            java.lang.String veiculo_Placa_26idTemp = null;
        if(!veiculo_Placa_26id.equals("")){
         veiculo_Placa_26idTemp  = veiculo_Placa_26id;
        }
        String proprietario_Nome_27id=  request.getParameter("proprietario_Nome112");
            java.lang.String proprietario_Nome_27idTemp = null;
        if(!proprietario_Nome_27id.equals("")){
         proprietario_Nome_27idTemp  = proprietario_Nome_27id;
        }
        String veiculo_AnoFabricacao_28id=  request.getParameter("veiculo_AnoFabricacao114");
        int veiculo_AnoFabricacao_28idTemp  = Integer.parseInt(veiculo_AnoFabricacao_28id);
        String proprietario_RG_UF_29id=  request.getParameter("proprietario_RG_UF116");
            java.lang.String proprietario_RG_UF_29idTemp = null;
        if(!proprietario_RG_UF_29id.equals("")){
         proprietario_RG_UF_29idTemp  = proprietario_RG_UF_29id;
        }
        %>
        <jsp:useBean id="_591_121_541_2011WS1CadastrarVeiculoRequest_5id" scope="session" class="_59._12._54._201.WS.CadastrarVeiculoRequest" />
        <%
        _591_121_541_2011WS1CadastrarVeiculoRequest_5id.setVeiculo_Renavam(veiculo_Renavam_6idTemp);
        _591_121_541_2011WS1CadastrarVeiculoRequest_5id.setProprietario_IE_RG(proprietario_IE_RG_7idTemp);
        _591_121_541_2011WS1CadastrarVeiculoRequest_5id.setCarreta_Renavam(carreta_Renavam_8idTemp);
        _591_121_541_2011WS1CadastrarVeiculoRequest_5id.setNumero_Terminal(numero_Terminal_9idTemp);
        _591_121_541_2011WS1CadastrarVeiculoRequest_5id.setProprietario_Nome_Mae(proprietario_Nome_Mae_10idTemp);
        _591_121_541_2011WS1CadastrarVeiculoRequest_5id.setCarreta_Placa(carreta_Placa_11idTemp);
        _591_121_541_2011WS1CadastrarVeiculoRequest_5id.setVeiculo_Modelo(veiculo_Modelo_12idTemp);
        _591_121_541_2011WS1CadastrarVeiculoRequest_5id.setProprietario_Data_Nascimento(proprietario_Data_Nascimento_13idTemp);
        _591_121_541_2011WS1CadastrarVeiculoRequest_5id.setAutenticacao(autenticacao_14idTemp);
        _591_121_541_2011WS1CadastrarVeiculoRequest_5id.setVeiculo_UF(veiculo_UF_15idTemp);
        _591_121_541_2011WS1CadastrarVeiculoRequest_5id.setCarreta_Tipo(carreta_Tipo_16idTemp);
        _591_121_541_2011WS1CadastrarVeiculoRequest_5id.setVeiculo_Chassi(veiculo_Chassi_17idTemp);
        _591_121_541_2011WS1CadastrarVeiculoRequest_5id.setVeiculo_Cor(veiculo_Cor_18idTemp);
        _591_121_541_2011WS1CadastrarVeiculoRequest_5id.setProprietario_Tipo_Pessoa(proprietario_Tipo_Pessoa_19idTemp);
        _591_121_541_2011WS1CadastrarVeiculoRequest_5id.setVeiculo_Cidade(veiculo_Cidade_20idTemp);
        _591_121_541_2011WS1CadastrarVeiculoRequest_5id.setEquipamento_Status(equipamento_Status_21idTemp);
        _591_121_541_2011WS1CadastrarVeiculoRequest_5id.setEquipamento_Rastreamento(equipamento_Rastreamento_22idTemp);
        _591_121_541_2011WS1CadastrarVeiculoRequest_5id.setVeiculo_Marca(veiculo_Marca_23idTemp);
        _591_121_541_2011WS1CadastrarVeiculoRequest_5id.setVeiculo_Tipo(veiculo_Tipo_24idTemp);
        _591_121_541_2011WS1CadastrarVeiculoRequest_5id.setProprietario_CNPJ_CPF(proprietario_CNPJ_CPF_25idTemp);
        _591_121_541_2011WS1CadastrarVeiculoRequest_5id.setVeiculo_Placa(veiculo_Placa_26idTemp);
        _591_121_541_2011WS1CadastrarVeiculoRequest_5id.setProprietario_Nome(proprietario_Nome_27idTemp);
        _591_121_541_2011WS1CadastrarVeiculoRequest_5id.setVeiculo_AnoFabricacao(veiculo_AnoFabricacao_28idTemp);
        _591_121_541_2011WS1CadastrarVeiculoRequest_5id.setProprietario_RG_UF(proprietario_RG_UF_29idTemp);
        _59._12._54._201.WS.CadastrarVeiculoResposta cadastrarVeiculo61mtemp = sampleBrasilRiskSoapProxyid.cadastrarVeiculo(_591_121_541_2011WS1CadastrarVeiculoRequest_5id);
if(cadastrarVeiculo61mtemp == null){
%>
<%=cadastrarVeiculo61mtemp %>
<%
}else{
%>
<TABLE>
<TR>
<TD COLSPAN="3" ALIGN="LEFT">returnp:</TD>
<TR>
<TD WIDTH="5%"></TD>
<TD COLSPAN="2" ALIGN="LEFT">mensagemErro:</TD>
<TD>
<%
if(cadastrarVeiculo61mtemp != null){
java.lang.String typemensagemErro64 = cadastrarVeiculo61mtemp.getMensagemErro();
        String tempResultmensagemErro64 = org.eclipse.jst.ws.util.JspUtils.markup(String.valueOf(typemensagemErro64));
        %>
        <%= tempResultmensagemErro64 %>
        <%
}%>
</TD>
<TR>
<TD WIDTH="5%"></TD>
<TD COLSPAN="2" ALIGN="LEFT">retornoErro:</TD>
<TD>
<%
if(cadastrarVeiculo61mtemp != null){
%>
<%=cadastrarVeiculo61mtemp.getRetornoErro()
%><%}%>
</TD>
</TABLE>
<%
}
break;
case 118:
        gotMethod = true;
        String endereco_31id=  request.getParameter("endereco127");
            java.lang.String endereco_31idTemp = null;
        if(!endereco_31id.equals("")){
         endereco_31idTemp  = endereco_31id;
        }
        String observacao_32id=  request.getParameter("observacao129");
            java.lang.String observacao_32idTemp = null;
        if(!observacao_32id.equals("")){
         observacao_32idTemp  = observacao_32id;
        }
        String numero_33id=  request.getParameter("numero131");
            java.lang.String numero_33idTemp = null;
        if(!numero_33id.equals("")){
         numero_33idTemp  = numero_33id;
        }
        String dataEmissao_34id=  request.getParameter("dataEmissao133");
            java.util.Calendar dataEmissao_34idTemp = null;
        if(!dataEmissao_34id.equals("")){
        java.text.DateFormat dateFormatdataEmissao133 = java.text.DateFormat.getDateInstance();
        java.util.Date dateTempdataEmissao133  = dateFormatdataEmissao133.parse(dataEmissao_34id);
         dataEmissao_34idTemp = new java.util.GregorianCalendar();
        dataEmissao_34idTemp.setTime(dateTempdataEmissao133);
        }
        String rG_35id=  request.getParameter("rG135");
            java.lang.String rG_35idTemp = null;
        if(!rG_35id.equals("")){
         rG_35idTemp  = rG_35id;
        }
        String cidade_36id=  request.getParameter("cidade137");
            java.lang.String cidade_36idTemp = null;
        if(!cidade_36id.equals("")){
         cidade_36idTemp  = cidade_36id;
        }
        String uF_37id=  request.getParameter("uF139");
            java.lang.String uF_37idTemp = null;
        if(!uF_37id.equals("")){
         uF_37idTemp  = uF_37id;
        }
        String nomePai_38id=  request.getParameter("nomePai141");
            java.lang.String nomePai_38idTemp = null;
        if(!nomePai_38id.equals("")){
         nomePai_38idTemp  = nomePai_38id;
        }
        String autenticacao_39id=  request.getParameter("autenticacao143");
            java.lang.String autenticacao_39idTemp = null;
        if(!autenticacao_39id.equals("")){
         autenticacao_39idTemp  = autenticacao_39id;
        }
        String controleCliente_40id=  request.getParameter("controleCliente145");
            java.lang.String controleCliente_40idTemp = null;
        if(!controleCliente_40id.equals("")){
         controleCliente_40idTemp  = controleCliente_40id;
        }
        String funcao_41id=  request.getParameter("funcao147");
            java.lang.String funcao_41idTemp = null;
        if(!funcao_41id.equals("")){
         funcao_41idTemp  = funcao_41id;
        }
        String cPF_42id=  request.getParameter("cPF149");
            java.lang.String cPF_42idTemp = null;
        if(!cPF_42id.equals("")){
         cPF_42idTemp  = cPF_42id;
        }
        String cEP_43id=  request.getParameter("cEP151");
            java.lang.String cEP_43idTemp = null;
        if(!cEP_43id.equals("")){
         cEP_43idTemp  = cEP_43id;
        }
        String cNHCategoria_44id=  request.getParameter("cNHCategoria153");
            java.lang.String cNHCategoria_44idTemp = null;
        if(!cNHCategoria_44id.equals("")){
         cNHCategoria_44idTemp  = cNHCategoria_44id;
        }
        String cNHRegistro_45id=  request.getParameter("cNHRegistro155");
            java.lang.String cNHRegistro_45idTemp = null;
        if(!cNHRegistro_45id.equals("")){
         cNHRegistro_45idTemp  = cNHRegistro_45id;
        }
        String nome_46id=  request.getParameter("nome157");
            java.lang.String nome_46idTemp = null;
        if(!nome_46id.equals("")){
         nome_46idTemp  = nome_46id;
        }
        String dataNascimento_47id=  request.getParameter("dataNascimento159");
            java.util.Calendar dataNascimento_47idTemp = null;
        if(!dataNascimento_47id.equals("")){
        java.text.DateFormat dateFormatdataNascimento159 = java.text.DateFormat.getDateInstance();
        java.util.Date dateTempdataNascimento159  = dateFormatdataNascimento159.parse(dataNascimento_47id);
         dataNascimento_47idTemp = new java.util.GregorianCalendar();
        dataNascimento_47idTemp.setTime(dateTempdataNascimento159);
        }
        String cNH_48id=  request.getParameter("cNH161");
            java.lang.String cNH_48idTemp = null;
        if(!cNH_48id.equals("")){
         cNH_48idTemp  = cNH_48id;
        }
        String cNHValidade_49id=  request.getParameter("cNHValidade163");
            java.util.Calendar cNHValidade_49idTemp = null;
        if(!cNHValidade_49id.equals("")){
        java.text.DateFormat dateFormatcNHValidade163 = java.text.DateFormat.getDateInstance();
        java.util.Date dateTempcNHValidade163  = dateFormatcNHValidade163.parse(cNHValidade_49id);
         cNHValidade_49idTemp = new java.util.GregorianCalendar();
        cNHValidade_49idTemp.setTime(dateTempcNHValidade163);
        }
        String nomeMae_50id=  request.getParameter("nomeMae165");
            java.lang.String nomeMae_50idTemp = null;
        if(!nomeMae_50id.equals("")){
         nomeMae_50idTemp  = nomeMae_50id;
        }
        String celular_51id=  request.getParameter("celular167");
            java.lang.String celular_51idTemp = null;
        if(!celular_51id.equals("")){
         celular_51idTemp  = celular_51id;
        }
        String telefone_52id=  request.getParameter("telefone169");
            java.lang.String telefone_52idTemp = null;
        if(!telefone_52id.equals("")){
         telefone_52idTemp  = telefone_52id;
        }
        String orgaoExpeditor_53id=  request.getParameter("orgaoExpeditor171");
            java.lang.String orgaoExpeditor_53idTemp = null;
        if(!orgaoExpeditor_53id.equals("")){
         orgaoExpeditor_53idTemp  = orgaoExpeditor_53id;
        }
        String perfil_54id=  request.getParameter("perfil173");
            java.lang.String perfil_54idTemp = null;
        if(!perfil_54id.equals("")){
         perfil_54idTemp  = perfil_54id;
        }
        String bairro_55id=  request.getParameter("bairro175");
            java.lang.String bairro_55idTemp = null;
        if(!bairro_55id.equals("")){
         bairro_55idTemp  = bairro_55id;
        }
        String cNHUF_56id=  request.getParameter("cNHUF177");
            java.lang.String cNHUF_56idTemp = null;
        if(!cNHUF_56id.equals("")){
         cNHUF_56idTemp  = cNHUF_56id;
        }
        String complemento_57id=  request.getParameter("complemento179");
            java.lang.String complemento_57idTemp = null;
        if(!complemento_57id.equals("")){
         complemento_57idTemp  = complemento_57id;
        }
        %>
        <jsp:useBean id="_591_121_541_2011WS1CadastrarCPFRequest_30id" scope="session" class="_59._12._54._201.WS.CadastrarCPFRequest" />
        <%
        _591_121_541_2011WS1CadastrarCPFRequest_30id.setEndereco(endereco_31idTemp);
        _591_121_541_2011WS1CadastrarCPFRequest_30id.setObservacao(observacao_32idTemp);
        _591_121_541_2011WS1CadastrarCPFRequest_30id.setNumero(numero_33idTemp);
        _591_121_541_2011WS1CadastrarCPFRequest_30id.setDataEmissao(dataEmissao_34idTemp);
        _591_121_541_2011WS1CadastrarCPFRequest_30id.setRG(rG_35idTemp);
        _591_121_541_2011WS1CadastrarCPFRequest_30id.setCidade(cidade_36idTemp);
        _591_121_541_2011WS1CadastrarCPFRequest_30id.setUF(uF_37idTemp);
        _591_121_541_2011WS1CadastrarCPFRequest_30id.setNomePai(nomePai_38idTemp);
        _591_121_541_2011WS1CadastrarCPFRequest_30id.setAutenticacao(autenticacao_39idTemp);
        _591_121_541_2011WS1CadastrarCPFRequest_30id.setControleCliente(controleCliente_40idTemp);
        _591_121_541_2011WS1CadastrarCPFRequest_30id.setFuncao(funcao_41idTemp);
        _591_121_541_2011WS1CadastrarCPFRequest_30id.setCPF(cPF_42idTemp);
        _591_121_541_2011WS1CadastrarCPFRequest_30id.setCEP(cEP_43idTemp);
        _591_121_541_2011WS1CadastrarCPFRequest_30id.setCNHCategoria(cNHCategoria_44idTemp);
        _591_121_541_2011WS1CadastrarCPFRequest_30id.setCNHRegistro(cNHRegistro_45idTemp);
        _591_121_541_2011WS1CadastrarCPFRequest_30id.setNome(nome_46idTemp);
        _591_121_541_2011WS1CadastrarCPFRequest_30id.setDataNascimento(dataNascimento_47idTemp);
        _591_121_541_2011WS1CadastrarCPFRequest_30id.setCNH(cNH_48idTemp);
        _591_121_541_2011WS1CadastrarCPFRequest_30id.setCNHValidade(cNHValidade_49idTemp);
        _591_121_541_2011WS1CadastrarCPFRequest_30id.setNomeMae(nomeMae_50idTemp);
        _591_121_541_2011WS1CadastrarCPFRequest_30id.setCelular(celular_51idTemp);
        _591_121_541_2011WS1CadastrarCPFRequest_30id.setTelefone(telefone_52idTemp);
        _591_121_541_2011WS1CadastrarCPFRequest_30id.setOrgaoExpeditor(orgaoExpeditor_53idTemp);
        _591_121_541_2011WS1CadastrarCPFRequest_30id.setPerfil(perfil_54idTemp);
        _591_121_541_2011WS1CadastrarCPFRequest_30id.setBairro(bairro_55idTemp);
        _591_121_541_2011WS1CadastrarCPFRequest_30id.setCNHUF(cNHUF_56idTemp);
        _591_121_541_2011WS1CadastrarCPFRequest_30id.setComplemento(complemento_57idTemp);
        _59._12._54._201.WS.CadastrarCPFResposta cadastrarCPF118mtemp = sampleBrasilRiskSoapProxyid.cadastrarCPF(_591_121_541_2011WS1CadastrarCPFRequest_30id);
if(cadastrarCPF118mtemp == null){
%>
<%=cadastrarCPF118mtemp %>
<%
}else{
%>
<TABLE>
<TR>
<TD COLSPAN="3" ALIGN="LEFT">returnp:</TD>
<TR>
<TD WIDTH="5%"></TD>
<TD COLSPAN="2" ALIGN="LEFT">mensagemErro:</TD>
<TD>
<%
if(cadastrarCPF118mtemp != null){
java.lang.String typemensagemErro121 = cadastrarCPF118mtemp.getMensagemErro();
        String tempResultmensagemErro121 = org.eclipse.jst.ws.util.JspUtils.markup(String.valueOf(typemensagemErro121));
        %>
        <%= tempResultmensagemErro121 %>
        <%
}%>
</TD>
<TR>
<TD WIDTH="5%"></TD>
<TD COLSPAN="2" ALIGN="LEFT">retornoErro:</TD>
<TD>
<%
if(cadastrarCPF118mtemp != null){
%>
<%=cadastrarCPF118mtemp.getRetornoErro()
%><%}%>
</TD>
</TABLE>
<%
}
break;
case 181:
        gotMethod = true;
        String stringXML_58id=  request.getParameter("stringXML190");
            java.lang.String stringXML_58idTemp = null;
        if(!stringXML_58id.equals("")){
         stringXML_58idTemp  = stringXML_58id;
        }
        _59._12._54._201.WS.SolicitacaoMonitoramentoResposta solicitacaoMonitoramento181mtemp = sampleBrasilRiskSoapProxyid.solicitacaoMonitoramento(stringXML_58idTemp);
if(solicitacaoMonitoramento181mtemp == null){
%>
<%=solicitacaoMonitoramento181mtemp %>
<%
}else{
%>
<TABLE>
<TR>
<TD COLSPAN="3" ALIGN="LEFT">returnp:</TD>
<TR>
<TD WIDTH="5%"></TD>
<TD COLSPAN="2" ALIGN="LEFT">codigoSM:</TD>
<TD>
<%
if(solicitacaoMonitoramento181mtemp != null){
%>
<%=solicitacaoMonitoramento181mtemp.getCodigoSM()
%><%}%>
</TD>
<TR>
<TD WIDTH="5%"></TD>
<TD COLSPAN="2" ALIGN="LEFT">mensagemErro:</TD>
<TD>
<%
if(solicitacaoMonitoramento181mtemp != null){
java.lang.String typemensagemErro186 = solicitacaoMonitoramento181mtemp.getMensagemErro();
        String tempResultmensagemErro186 = org.eclipse.jst.ws.util.JspUtils.markup(String.valueOf(typemensagemErro186));
        %>
        <%= tempResultmensagemErro186 %>
        <%
}%>
</TD>
<TR>
<TD WIDTH="5%"></TD>
<TD COLSPAN="2" ALIGN="LEFT">retornoErro:</TD>
<TD>
<%
if(solicitacaoMonitoramento181mtemp != null){
%>
<%=solicitacaoMonitoramento181mtemp.getRetornoErro()
%><%}%>
</TD>
</TABLE>
<%
}
break;
case 192:
        gotMethod = true;
        String CPF_59id=  request.getParameter("CPF199");
            java.lang.String CPF_59idTemp = null;
        if(!CPF_59id.equals("")){
         CPF_59idTemp  = CPF_59id;
        }
        String placa_60id=  request.getParameter("placa201");
            java.lang.String placa_60idTemp = null;
        if(!placa_60id.equals("")){
         placa_60idTemp  = placa_60id;
        }
        String placaCarreta_61id=  request.getParameter("placaCarreta203");
            java.lang.String placaCarreta_61idTemp = null;
        if(!placaCarreta_61id.equals("")){
         placaCarreta_61idTemp  = placaCarreta_61id;
        }
        String codigoSM_62id=  request.getParameter("codigoSM205");
            java.lang.String codigoSM_62idTemp = null;
        if(!codigoSM_62id.equals("")){
         codigoSM_62idTemp  = codigoSM_62id;
        }
        String autenticacao_63id=  request.getParameter("autenticacao207");
            java.lang.String autenticacao_63idTemp = null;
        if(!autenticacao_63id.equals("")){
         autenticacao_63idTemp  = autenticacao_63id;
        }
        _59._12._54._201.WS.AlterarSMResposta alterarSM192mtemp = sampleBrasilRiskSoapProxyid.alterarSM(CPF_59idTemp,placa_60idTemp,placaCarreta_61idTemp,codigoSM_62idTemp,autenticacao_63idTemp);
if(alterarSM192mtemp == null){
%>
<%=alterarSM192mtemp %>
<%
}else{
%>
<TABLE>
<TR>
<TD COLSPAN="3" ALIGN="LEFT">returnp:</TD>
<TR>
<TD WIDTH="5%"></TD>
<TD COLSPAN="2" ALIGN="LEFT">msgm:</TD>
<TD>
<%
if(alterarSM192mtemp != null){
java.lang.String typemsgm195 = alterarSM192mtemp.getMsgm();
        String tempResultmsgm195 = org.eclipse.jst.ws.util.JspUtils.markup(String.valueOf(typemsgm195));
        %>
        <%= tempResultmsgm195 %>
        <%
}%>
</TD>
<TR>
<TD WIDTH="5%"></TD>
<TD COLSPAN="2" ALIGN="LEFT">retornoErro:</TD>
<TD>
<%
if(alterarSM192mtemp != null){
%>
<%=alterarSM192mtemp.getRetornoErro()
%><%}%>
</TD>
</TABLE>
<%
}
break;
}
} catch (Exception e) { 
%>
exception: <%= e %>
<%
return;
}
if(!gotMethod){
%>
result: N/A
<%
}
%>
</BODY>
</HTML>