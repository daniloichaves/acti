<%@page contentType="text/html;charset=UTF-8"%>
<HTML>
<HEAD>
<TITLE>Inputs</TITLE>
</HEAD>
<BODY>
<H1>Inputs</H1>

<%
String method = request.getParameter("method");
int methodID = 0;
if (method == null) methodID = -1;

boolean valid = true;

if(methodID != -1) methodID = Integer.parseInt(method);
switch (methodID){ 
case 2:
valid = false;
%>
<FORM METHOD="POST" ACTION="Result.jsp" TARGET="result">
<INPUT TYPE="HIDDEN" NAME="method" VALUE="<%=method%>">
<BR>
<INPUT TYPE="SUBMIT" VALUE="Invoke">
<INPUT TYPE="RESET" VALUE="Clear">
</FORM>
<%
break;
case 5:
valid = false;
%>
<FORM METHOD="POST" ACTION="Result.jsp" TARGET="result">
<INPUT TYPE="HIDDEN" NAME="method" VALUE="<%=method%>">
<TABLE>
<TR>
<TD COLSPAN="1" ALIGN="LEFT">endpoint:</TD>
<TD ALIGN="left"><INPUT TYPE="TEXT" NAME="endpoint8" SIZE=20></TD>
</TR>
</TABLE>
<BR>
<INPUT TYPE="SUBMIT" VALUE="Invoke">
<INPUT TYPE="RESET" VALUE="Clear">
</FORM>
<%
break;
case 10:
valid = false;
%>
<FORM METHOD="POST" ACTION="Result.jsp" TARGET="result">
<INPUT TYPE="HIDDEN" NAME="method" VALUE="<%=method%>">
<BR>
<INPUT TYPE="SUBMIT" VALUE="Invoke">
<INPUT TYPE="RESET" VALUE="Clear">
</FORM>
<%
break;
case 13:
valid = false;
%>
<FORM METHOD="POST" ACTION="Result.jsp" TARGET="result">
<INPUT TYPE="HIDDEN" NAME="method" VALUE="<%=method%>">
<TABLE>
<TR>
<TD COLSPAN="1" ALIGN="LEFT">placa:</TD>
<TD ALIGN="left"><INPUT TYPE="TEXT" NAME="placa30" SIZE=20></TD>
</TR>
</TABLE>
<TABLE>
<TR>
<TD COLSPAN="1" ALIGN="LEFT">autenticacao:</TD>
<TD ALIGN="left"><INPUT TYPE="TEXT" NAME="autenticacao32" SIZE=20></TD>
</TR>
</TABLE>
<BR>
<INPUT TYPE="SUBMIT" VALUE="Invoke">
<INPUT TYPE="RESET" VALUE="Clear">
</FORM>
<%
break;
case 34:
valid = false;
%>
<FORM METHOD="POST" ACTION="Result.jsp" TARGET="result">
<INPUT TYPE="HIDDEN" NAME="method" VALUE="<%=method%>">
<TABLE>
<TR>
<TD COLSPAN="1" ALIGN="LEFT">CPF:</TD>
<TD ALIGN="left"><INPUT TYPE="TEXT" NAME="CPF57" SIZE=20></TD>
</TR>
</TABLE>
<TABLE>
<TR>
<TD COLSPAN="1" ALIGN="LEFT">autenticacao:</TD>
<TD ALIGN="left"><INPUT TYPE="TEXT" NAME="autenticacao59" SIZE=20></TD>
</TR>
</TABLE>
<BR>
<INPUT TYPE="SUBMIT" VALUE="Invoke">
<INPUT TYPE="RESET" VALUE="Clear">
</FORM>
<%
break;
case 61:
valid = false;
%>
<FORM METHOD="POST" ACTION="Result.jsp" TARGET="result">
<INPUT TYPE="HIDDEN" NAME="method" VALUE="<%=method%>">
<TABLE>
<TR>
<TD COLSPAN="3" ALIGN="LEFT">cadastro:</TD>
<TR>
<TD WIDTH="5%"></TD>
<TD COLSPAN="2" ALIGN="LEFT">veiculo_Renavam:</TD>
<TD ALIGN="left"><INPUT TYPE="TEXT" NAME="veiculo_Renavam70" SIZE=20></TD>
</TR>
<TR>
<TD WIDTH="5%"></TD>
<TD COLSPAN="2" ALIGN="LEFT">proprietario_IE_RG:</TD>
<TD ALIGN="left"><INPUT TYPE="TEXT" NAME="proprietario_IE_RG72" SIZE=20></TD>
</TR>
<TR>
<TD WIDTH="5%"></TD>
<TD COLSPAN="2" ALIGN="LEFT">carreta_Renavam:</TD>
<TD ALIGN="left"><INPUT TYPE="TEXT" NAME="carreta_Renavam74" SIZE=20></TD>
</TR>
<TR>
<TD WIDTH="5%"></TD>
<TD COLSPAN="2" ALIGN="LEFT">numero_Terminal:</TD>
<TD ALIGN="left"><INPUT TYPE="TEXT" NAME="numero_Terminal76" SIZE=20></TD>
</TR>
<TR>
<TD WIDTH="5%"></TD>
<TD COLSPAN="2" ALIGN="LEFT">proprietario_Nome_Mae:</TD>
<TD ALIGN="left"><INPUT TYPE="TEXT" NAME="proprietario_Nome_Mae78" SIZE=20></TD>
</TR>
<TR>
<TD WIDTH="5%"></TD>
<TD COLSPAN="2" ALIGN="LEFT">carreta_Placa:</TD>
<TD ALIGN="left"><INPUT TYPE="TEXT" NAME="carreta_Placa80" SIZE=20></TD>
</TR>
<TR>
<TD WIDTH="5%"></TD>
<TD COLSPAN="2" ALIGN="LEFT">veiculo_Modelo:</TD>
<TD ALIGN="left"><INPUT TYPE="TEXT" NAME="veiculo_Modelo82" SIZE=20></TD>
</TR>
<TR>
<TD WIDTH="5%"></TD>
<TD COLSPAN="2" ALIGN="LEFT">proprietario_Data_Nascimento:</TD>
<TD ALIGN="left"><INPUT TYPE="TEXT" NAME="proprietario_Data_Nascimento84" SIZE=20></TD>
<%
java.text.DateFormat dateFormatproprietario_Data_Nascimento84 = java.text.DateFormat.getDateInstance();
java.util.GregorianCalendar gcExampproprietario_Data_Nascimento84  = new java.util.GregorianCalendar();
java.util.Date dateproprietario_Data_Nascimento84 = gcExampproprietario_Data_Nascimento84.getTime();
String tempResultproprietario_Data_Nascimento84 = dateFormatproprietario_Data_Nascimento84.format(dateproprietario_Data_Nascimento84);
%>
<TD ALIGN="left">
</TR>
<TR>
<TD> </TD>
<TD ALIGN="left"> eg. <%= tempResultproprietario_Data_Nascimento84 %> </TD>
</TR>
<TR>
<TD WIDTH="5%"></TD>
<TD COLSPAN="2" ALIGN="LEFT">autenticacao:</TD>
<TD ALIGN="left"><INPUT TYPE="TEXT" NAME="autenticacao86" SIZE=20></TD>
</TR>
<TR>
<TD WIDTH="5%"></TD>
<TD COLSPAN="2" ALIGN="LEFT">veiculo_UF:</TD>
<TD ALIGN="left"><INPUT TYPE="TEXT" NAME="veiculo_UF88" SIZE=20></TD>
</TR>
<TR>
<TD WIDTH="5%"></TD>
<TD COLSPAN="2" ALIGN="LEFT">carreta_Tipo:</TD>
<TD ALIGN="left"><INPUT TYPE="TEXT" NAME="carreta_Tipo90" SIZE=20></TD>
</TR>
<TR>
<TD WIDTH="5%"></TD>
<TD COLSPAN="2" ALIGN="LEFT">veiculo_Chassi:</TD>
<TD ALIGN="left"><INPUT TYPE="TEXT" NAME="veiculo_Chassi92" SIZE=20></TD>
</TR>
<TR>
<TD WIDTH="5%"></TD>
<TD COLSPAN="2" ALIGN="LEFT">veiculo_Cor:</TD>
<TD ALIGN="left"><INPUT TYPE="TEXT" NAME="veiculo_Cor94" SIZE=20></TD>
</TR>
<TR>
<TD WIDTH="5%"></TD>
<TD COLSPAN="2" ALIGN="LEFT">proprietario_Tipo_Pessoa:</TD>
<TD ALIGN="left"><INPUT TYPE="TEXT" NAME="proprietario_Tipo_Pessoa96" SIZE=20></TD>
</TR>
<TR>
<TD WIDTH="5%"></TD>
<TD COLSPAN="2" ALIGN="LEFT">veiculo_Cidade:</TD>
<TD ALIGN="left"><INPUT TYPE="TEXT" NAME="veiculo_Cidade98" SIZE=20></TD>
</TR>
<TR>
<TD WIDTH="5%"></TD>
<TD COLSPAN="2" ALIGN="LEFT">equipamento_Status:</TD>
<TD ALIGN="left"><INPUT TYPE="TEXT" NAME="equipamento_Status100" SIZE=20></TD>
</TR>
<TR>
<TD WIDTH="5%"></TD>
<TD COLSPAN="2" ALIGN="LEFT">equipamento_Rastreamento:</TD>
<TD ALIGN="left"><INPUT TYPE="TEXT" NAME="equipamento_Rastreamento102" SIZE=20></TD>
</TR>
<TR>
<TD WIDTH="5%"></TD>
<TD COLSPAN="2" ALIGN="LEFT">veiculo_Marca:</TD>
<TD ALIGN="left"><INPUT TYPE="TEXT" NAME="veiculo_Marca104" SIZE=20></TD>
</TR>
<TR>
<TD WIDTH="5%"></TD>
<TD COLSPAN="2" ALIGN="LEFT">veiculo_Tipo:</TD>
<TD ALIGN="left"><INPUT TYPE="TEXT" NAME="veiculo_Tipo106" SIZE=20></TD>
</TR>
<TR>
<TD WIDTH="5%"></TD>
<TD COLSPAN="2" ALIGN="LEFT">proprietario_CNPJ_CPF:</TD>
<TD ALIGN="left"><INPUT TYPE="TEXT" NAME="proprietario_CNPJ_CPF108" SIZE=20></TD>
</TR>
<TR>
<TD WIDTH="5%"></TD>
<TD COLSPAN="2" ALIGN="LEFT">veiculo_Placa:</TD>
<TD ALIGN="left"><INPUT TYPE="TEXT" NAME="veiculo_Placa110" SIZE=20></TD>
</TR>
<TR>
<TD WIDTH="5%"></TD>
<TD COLSPAN="2" ALIGN="LEFT">proprietario_Nome:</TD>
<TD ALIGN="left"><INPUT TYPE="TEXT" NAME="proprietario_Nome112" SIZE=20></TD>
</TR>
<TR>
<TD WIDTH="5%"></TD>
<TD COLSPAN="2" ALIGN="LEFT">veiculo_AnoFabricacao:</TD>
<TD ALIGN="left"><INPUT TYPE="TEXT" NAME="veiculo_AnoFabricacao114" SIZE=20></TD>
</TR>
<TR>
<TD WIDTH="5%"></TD>
<TD COLSPAN="2" ALIGN="LEFT">proprietario_RG_UF:</TD>
<TD ALIGN="left"><INPUT TYPE="TEXT" NAME="proprietario_RG_UF116" SIZE=20></TD>
</TR>
</TABLE>
<BR>
<INPUT TYPE="SUBMIT" VALUE="Invoke">
<INPUT TYPE="RESET" VALUE="Clear">
</FORM>
<%
break;
case 118:
valid = false;
%>
<FORM METHOD="POST" ACTION="Result.jsp" TARGET="result">
<INPUT TYPE="HIDDEN" NAME="method" VALUE="<%=method%>">
<TABLE>
<TR>
<TD COLSPAN="3" ALIGN="LEFT">dados:</TD>
<TR>
<TD WIDTH="5%"></TD>
<TD COLSPAN="2" ALIGN="LEFT">endereco:</TD>
<TD ALIGN="left"><INPUT TYPE="TEXT" NAME="endereco127" SIZE=20></TD>
</TR>
<TR>
<TD WIDTH="5%"></TD>
<TD COLSPAN="2" ALIGN="LEFT">observacao:</TD>
<TD ALIGN="left"><INPUT TYPE="TEXT" NAME="observacao129" SIZE=20></TD>
</TR>
<TR>
<TD WIDTH="5%"></TD>
<TD COLSPAN="2" ALIGN="LEFT">numero:</TD>
<TD ALIGN="left"><INPUT TYPE="TEXT" NAME="numero131" SIZE=20></TD>
</TR>
<TR>
<TD WIDTH="5%"></TD>
<TD COLSPAN="2" ALIGN="LEFT">dataEmissao:</TD>
<TD ALIGN="left"><INPUT TYPE="TEXT" NAME="dataEmissao133" SIZE=20></TD>
<%
java.text.DateFormat dateFormatdataEmissao133 = java.text.DateFormat.getDateInstance();
java.util.GregorianCalendar gcExampdataEmissao133  = new java.util.GregorianCalendar();
java.util.Date datedataEmissao133 = gcExampdataEmissao133.getTime();
String tempResultdataEmissao133 = dateFormatdataEmissao133.format(datedataEmissao133);
%>
<TD ALIGN="left">
</TR>
<TR>
<TD> </TD>
<TD ALIGN="left"> eg. <%= tempResultdataEmissao133 %> </TD>
</TR>
<TR>
<TD WIDTH="5%"></TD>
<TD COLSPAN="2" ALIGN="LEFT">rG:</TD>
<TD ALIGN="left"><INPUT TYPE="TEXT" NAME="rG135" SIZE=20></TD>
</TR>
<TR>
<TD WIDTH="5%"></TD>
<TD COLSPAN="2" ALIGN="LEFT">cidade:</TD>
<TD ALIGN="left"><INPUT TYPE="TEXT" NAME="cidade137" SIZE=20></TD>
</TR>
<TR>
<TD WIDTH="5%"></TD>
<TD COLSPAN="2" ALIGN="LEFT">uF:</TD>
<TD ALIGN="left"><INPUT TYPE="TEXT" NAME="uF139" SIZE=20></TD>
</TR>
<TR>
<TD WIDTH="5%"></TD>
<TD COLSPAN="2" ALIGN="LEFT">nomePai:</TD>
<TD ALIGN="left"><INPUT TYPE="TEXT" NAME="nomePai141" SIZE=20></TD>
</TR>
<TR>
<TD WIDTH="5%"></TD>
<TD COLSPAN="2" ALIGN="LEFT">autenticacao:</TD>
<TD ALIGN="left"><INPUT TYPE="TEXT" NAME="autenticacao143" SIZE=20></TD>
</TR>
<TR>
<TD WIDTH="5%"></TD>
<TD COLSPAN="2" ALIGN="LEFT">controleCliente:</TD>
<TD ALIGN="left"><INPUT TYPE="TEXT" NAME="controleCliente145" SIZE=20></TD>
</TR>
<TR>
<TD WIDTH="5%"></TD>
<TD COLSPAN="2" ALIGN="LEFT">funcao:</TD>
<TD ALIGN="left"><INPUT TYPE="TEXT" NAME="funcao147" SIZE=20></TD>
</TR>
<TR>
<TD WIDTH="5%"></TD>
<TD COLSPAN="2" ALIGN="LEFT">cPF:</TD>
<TD ALIGN="left"><INPUT TYPE="TEXT" NAME="cPF149" SIZE=20></TD>
</TR>
<TR>
<TD WIDTH="5%"></TD>
<TD COLSPAN="2" ALIGN="LEFT">cEP:</TD>
<TD ALIGN="left"><INPUT TYPE="TEXT" NAME="cEP151" SIZE=20></TD>
</TR>
<TR>
<TD WIDTH="5%"></TD>
<TD COLSPAN="2" ALIGN="LEFT">cNHCategoria:</TD>
<TD ALIGN="left"><INPUT TYPE="TEXT" NAME="cNHCategoria153" SIZE=20></TD>
</TR>
<TR>
<TD WIDTH="5%"></TD>
<TD COLSPAN="2" ALIGN="LEFT">cNHRegistro:</TD>
<TD ALIGN="left"><INPUT TYPE="TEXT" NAME="cNHRegistro155" SIZE=20></TD>
</TR>
<TR>
<TD WIDTH="5%"></TD>
<TD COLSPAN="2" ALIGN="LEFT">nome:</TD>
<TD ALIGN="left"><INPUT TYPE="TEXT" NAME="nome157" SIZE=20></TD>
</TR>
<TR>
<TD WIDTH="5%"></TD>
<TD COLSPAN="2" ALIGN="LEFT">dataNascimento:</TD>
<TD ALIGN="left"><INPUT TYPE="TEXT" NAME="dataNascimento159" SIZE=20></TD>
<%
java.text.DateFormat dateFormatdataNascimento159 = java.text.DateFormat.getDateInstance();
java.util.GregorianCalendar gcExampdataNascimento159  = new java.util.GregorianCalendar();
java.util.Date datedataNascimento159 = gcExampdataNascimento159.getTime();
String tempResultdataNascimento159 = dateFormatdataNascimento159.format(datedataNascimento159);
%>
<TD ALIGN="left">
</TR>
<TR>
<TD> </TD>
<TD ALIGN="left"> eg. <%= tempResultdataNascimento159 %> </TD>
</TR>
<TR>
<TD WIDTH="5%"></TD>
<TD COLSPAN="2" ALIGN="LEFT">cNH:</TD>
<TD ALIGN="left"><INPUT TYPE="TEXT" NAME="cNH161" SIZE=20></TD>
</TR>
<TR>
<TD WIDTH="5%"></TD>
<TD COLSPAN="2" ALIGN="LEFT">cNHValidade:</TD>
<TD ALIGN="left"><INPUT TYPE="TEXT" NAME="cNHValidade163" SIZE=20></TD>
<%
java.text.DateFormat dateFormatcNHValidade163 = java.text.DateFormat.getDateInstance();
java.util.GregorianCalendar gcExampcNHValidade163  = new java.util.GregorianCalendar();
java.util.Date datecNHValidade163 = gcExampcNHValidade163.getTime();
String tempResultcNHValidade163 = dateFormatcNHValidade163.format(datecNHValidade163);
%>
<TD ALIGN="left">
</TR>
<TR>
<TD> </TD>
<TD ALIGN="left"> eg. <%= tempResultcNHValidade163 %> </TD>
</TR>
<TR>
<TD WIDTH="5%"></TD>
<TD COLSPAN="2" ALIGN="LEFT">nomeMae:</TD>
<TD ALIGN="left"><INPUT TYPE="TEXT" NAME="nomeMae165" SIZE=20></TD>
</TR>
<TR>
<TD WIDTH="5%"></TD>
<TD COLSPAN="2" ALIGN="LEFT">celular:</TD>
<TD ALIGN="left"><INPUT TYPE="TEXT" NAME="celular167" SIZE=20></TD>
</TR>
<TR>
<TD WIDTH="5%"></TD>
<TD COLSPAN="2" ALIGN="LEFT">telefone:</TD>
<TD ALIGN="left"><INPUT TYPE="TEXT" NAME="telefone169" SIZE=20></TD>
</TR>
<TR>
<TD WIDTH="5%"></TD>
<TD COLSPAN="2" ALIGN="LEFT">orgaoExpeditor:</TD>
<TD ALIGN="left"><INPUT TYPE="TEXT" NAME="orgaoExpeditor171" SIZE=20></TD>
</TR>
<TR>
<TD WIDTH="5%"></TD>
<TD COLSPAN="2" ALIGN="LEFT">perfil:</TD>
<TD ALIGN="left"><INPUT TYPE="TEXT" NAME="perfil173" SIZE=20></TD>
</TR>
<TR>
<TD WIDTH="5%"></TD>
<TD COLSPAN="2" ALIGN="LEFT">bairro:</TD>
<TD ALIGN="left"><INPUT TYPE="TEXT" NAME="bairro175" SIZE=20></TD>
</TR>
<TR>
<TD WIDTH="5%"></TD>
<TD COLSPAN="2" ALIGN="LEFT">cNHUF:</TD>
<TD ALIGN="left"><INPUT TYPE="TEXT" NAME="cNHUF177" SIZE=20></TD>
</TR>
<TR>
<TD WIDTH="5%"></TD>
<TD COLSPAN="2" ALIGN="LEFT">complemento:</TD>
<TD ALIGN="left"><INPUT TYPE="TEXT" NAME="complemento179" SIZE=20></TD>
</TR>
</TABLE>
<BR>
<INPUT TYPE="SUBMIT" VALUE="Invoke">
<INPUT TYPE="RESET" VALUE="Clear">
</FORM>
<%
break;
case 181:
valid = false;
%>
<FORM METHOD="POST" ACTION="Result.jsp" TARGET="result">
<INPUT TYPE="HIDDEN" NAME="method" VALUE="<%=method%>">
<TABLE>
<TR>
<TD COLSPAN="1" ALIGN="LEFT">stringXML:</TD>
<TD ALIGN="left"><INPUT TYPE="TEXT" NAME="stringXML190" SIZE=20></TD>
</TR>
</TABLE>
<BR>
<INPUT TYPE="SUBMIT" VALUE="Invoke">
<INPUT TYPE="RESET" VALUE="Clear">
</FORM>
<%
break;
case 192:
valid = false;
%>
<FORM METHOD="POST" ACTION="Result.jsp" TARGET="result">
<INPUT TYPE="HIDDEN" NAME="method" VALUE="<%=method%>">
<TABLE>
<TR>
<TD COLSPAN="1" ALIGN="LEFT">CPF:</TD>
<TD ALIGN="left"><INPUT TYPE="TEXT" NAME="CPF199" SIZE=20></TD>
</TR>
</TABLE>
<TABLE>
<TR>
<TD COLSPAN="1" ALIGN="LEFT">placa:</TD>
<TD ALIGN="left"><INPUT TYPE="TEXT" NAME="placa201" SIZE=20></TD>
</TR>
</TABLE>
<TABLE>
<TR>
<TD COLSPAN="1" ALIGN="LEFT">placaCarreta:</TD>
<TD ALIGN="left"><INPUT TYPE="TEXT" NAME="placaCarreta203" SIZE=20></TD>
</TR>
</TABLE>
<TABLE>
<TR>
<TD COLSPAN="1" ALIGN="LEFT">codigoSM:</TD>
<TD ALIGN="left"><INPUT TYPE="TEXT" NAME="codigoSM205" SIZE=20></TD>
</TR>
</TABLE>
<TABLE>
<TR>
<TD COLSPAN="1" ALIGN="LEFT">autenticacao:</TD>
<TD ALIGN="left"><INPUT TYPE="TEXT" NAME="autenticacao207" SIZE=20></TD>
</TR>
</TABLE>
<BR>
<INPUT TYPE="SUBMIT" VALUE="Invoke">
<INPUT TYPE="RESET" VALUE="Clear">
</FORM>
<%
break;
case 1111111111:
valid = false;
%>
<FORM METHOD="POST" ACTION="Result.jsp" TARGET="result">
<INPUT TYPE="HIDDEN" NAME="method" VALUE="<%=method%>">
<TABLE>
<TR>
<TD COLSPAN="1" ALIGN="LEFT">URLString:</TD>
<TD ALIGN="left"><INPUT TYPE="TEXT" NAME="url1111111111" SIZE=20></TD>
</TR>
</TABLE>
<BR>
<INPUT TYPE="SUBMIT" VALUE="Invoke">
<INPUT TYPE="RESET" VALUE="Clear">
</FORM>
<%
break;
case 1111111112:
valid = false;
%>
<FORM METHOD="POST" ACTION="Result.jsp" TARGET="result">
<INPUT TYPE="HIDDEN" NAME="method" VALUE="<%=method%>">
<BR>
<INPUT TYPE="SUBMIT" VALUE="Invoke">
<INPUT TYPE="RESET" VALUE="Clear">
</FORM>
<%
break;
}
if (valid) {
%>
Select a method to test.
<%
}
%>

</BODY>
</HTML>
