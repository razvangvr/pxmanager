<%@ page import="java.util.ArrayList,
                 java.util.List,
                 ro.auto.beans.*,
                 ro.dirigentie.dao.UserDAO,
                 ro.dirigentie.dao.AbsenteDAO,
                 ro.utils.DateUtils,
                 ro.dirigentie.dao.ClasaDAO,
                 ro.dirigentie.dao.DisciplinaDAO"%>
<!DOCTYPE HTML PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN"
"http://www.w3.org/TR/html4/loose.dtd">
<BODY BACKGROUND="../img/background.jpg">
<table class="titlu">
    <tr><td valign=top>
        <jsp:include page="../menu.jsp" flush="true"/>
    </td>
    <td width=10%>
        &nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;<BR>
    </td>
    <td><br>

<%  int len = 0;

    AbsenteBean mb = new AbsenteBean();
    AbsenteDAO userDAO = new AbsenteDAO();
    List elements = userDAO.getByPK(new Object[] {request.getParameter("id")});
    mb = (AbsenteBean) elements.get(0);

%>


<h2 align=center>Editare Absente</h2>
<form name="form1" method="post" action="list.jsp"
onSubmit="MM_validateForm('prDesignCode', 'Design Code', 'R', 'prCurrencyCode', 'Currency Code', 'R', 'prType', 'Instrument Type', 'R', 'prDescription', 'Description', 'R', 'prPDCode', 'POSA/Distributor', 'R', 'prCPCode', 'Content Provider', 'R', 'prCode', 'Code', 'R', 'prAmount','Amount','int','prQuantity','Quantity','int');return document.MM_returnValue">

<table width="400" border="0" cellpadding="0">
  <tr>
    <td colspan="2" align="left" >
        <P/><input type="submit" name="Save" value="Salveaza">
    <input type="button" name="cancel" value="Inapoi" onClick="document.location='list.jsp?id_elev=<%=request.getParameter("id_elev")%>'">
    <input type="hidden" name="id_elev" value="<%=request.getParameter("id_elev")%>">
    </td>
  </tr>
  <tr>
    <td colspan="2" align="left" >
    <input name="id" type="hidden" size="20" maxlength="15" value="<%=mb.getId()%>">
    &nbsp;</td>
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
           <option name="S1" type="text"  value="S1" <%=mb.getSemestru().equalsIgnoreCase("S1")?"Selected":""%>>S1</option>
           <option name="S2" type="text"  value="S2" <%=mb.getSemestru().equalsIgnoreCase("S2")?"Selected":""%>>S2</option>
    </select>        </td>
    </tr>
    <tr>
    <td width="201">Motivat : </td>
    <td width="282">
    <input name="mot" type="text" size="3" value="<%=mb.getMotivat()%>">
    </td>
  </tr>
     <tr>
    <td width="201">Nemotivat : </td>
    <td width="282">
    <input name="nemot" type="text" size="3" value="<%=mb.getNemotivat()%>">
    </td>
  </tr>
 </table>
</form>
</td></tr>
</table>
