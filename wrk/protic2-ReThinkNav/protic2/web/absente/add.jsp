R<%@ page import="java.util.List,
                 java.util.ArrayList,
                 ro.auto.beans.*,
                 java.util.Date
                 ,
                 ro.dirigentie.dao.ClasaDAO,
                 ro.dirigentie.dao.DisciplinaDAO"%>
<!DOCTYPE HTML PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<BODY BACKGROUND="../img/background.jpg">
<table class="titlu">
    <tr><td valign=top>
        <jsp:include page="../menu.jsp" flush="true"/>
    </td>
    <td width=10%>
        &nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;<BR>
    </td>
    <td><br>

<h2 align=center>Adaugare Absente</h2>
<form name="form1" method="post" action="list.jsp"
onSubmit="MM_validateForm('prDesignCode', 'Design Code', 'R', 'prCurrencyCode', 'Currency Code', 'R', 'prType', 'Instrument Type', 'R', 'prDescription', 'Description', 'R', 'prPDCode', 'POSA/Distributor', 'R', 'prCPCode', 'Content Provider', 'R', 'prCode', 'Code', 'R', 'prAmount','Amount','int','prQuantity','Quantity','int');return document.MM_returnValue">

<table width="400" border="0" cellpadding="0">
  <tr>
    <td colspan="2" align="left" >
    <P/>
    <input type="submit" name="Add" value="Adauga">
    <input type="button" name="cancel" value="Inapoi" onClick="document.location='list.jsp?id_elev=<%=request.getParameter("id_elev")%>'">
    <input type="hidden" name="id_elev" value="<%=request.getParameter("id_elev")%>">
  </td>
  </tr>
  <tr><td>
       &nbsp;<BR>
       </td>
  </tr>

      <tr>
    <td width="201">An scolar curent : </td>
    <td width="282">
    <%=request.getSession().getAttribute("denan")%>
    </td>
   </tr>
    <tr>
        <td width="201">Semestru : </td>
        <td cellspan=3 cellpadding="3" >
<%--        <jsp:include page="profilinc.jsp?idp=<%=ua.getId_profil()%>" flush="true"/>--%>

    <select name=sem>
           <option name="S1" type="text"  value="S1">S1</option>
           <option name="S2" type="text"  value="S2">S2</option>
    </select>
    </td>
    </tr>
     <tr>
    <td width="201">Motivat : </td>
    <td width="282">
    <input name="mot" type="text" size="3" value="">
    </td>
  </tr>

     <tr>
    <td width="201">Nemotivat : </td>
    <td width="282">
    <input name="nemot" type="text" size="3" value="">
    </td>
  </tr>
  </table>

</form>
</td></tr>
</table>
