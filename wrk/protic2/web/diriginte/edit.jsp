<%@ page import="java.util.ArrayList,
                 java.util.List,
                 ro.auto.beans.*,

                 ro.dirigentie.dao.*"%>
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

    DiriginteBean ua = new DiriginteBean();
    DiriginteDAO userDAO = new DiriginteDAO();
    List elements = userDAO.getByPK(new Object[] {request.getParameter("id")});
    ua = (DiriginteBean) elements.get(0);

%>


<h2 align=center>Editare Diriginte</h2>
<form name="form1" method="post" action="list.jsp"
onSubmit="MM_validateForm('prDesignCode', 'Design Code', 'R', 'prCurrencyCode', 'Currency Code', 'R', 'prType', 'Instrument Type', 'R', 'prDescription', 'Description', 'R', 'prPDCode', 'POSA/Distributor', 'R', 'prCPCode', 'Content Provider', 'R', 'prCode', 'Code', 'R', 'prAmount','Amount','int','prQuantity','Quantity','int');return document.MM_returnValue">

<table width="400" border="0" cellpadding="0">
  <tr>
    <td colspan="2" align="left" >
        <P/><input type="submit" name="Save" value="Salveaza">
        <input type="button" name="cancel" value="Inapoi" onClick="document.location='list.jsp'">
    </td>
  </tr>
  <tr>
    <td colspan="2" align="left" >
    <input name="id" type="hidden" size="20" maxlength="15" value="<%=ua.getId()%>">
    &nbsp;</td>
  </tr>


  <tr>
    <td width="201">An scolar curent : </td>
    <td width="282">
    <%=request.getSession().getAttribute("denan")%>
    </td>
  </tr>
    <tr>
        <td width="201">Profesor : </td>
        <td cellspan=3 cellpadding="3" >
<%--        <jsp:include page="Profesorinc.jsp?idp=<%=ua.getId_Profesor()%>" flush="true"/>--%>

    <select name=idprof>
        <%  List ep = new ProfesorDAO().getALL();
            if (ep!=null)
            for (int i = 0; i < ep.size(); i++) {
                ProfesorBean b = (ProfesorBean) ep.get(i);
        %>
           <option name="DA" type="text" value="<%=b.getId()%>"  <%=b.getId()==ua.getId_profesor()?"Selected":""%>><%=b.getNume()%></option>
        <%}%>
    </select>
    </td>
    </tr>
    <tr>
        <td width="201">Clasa : </td>
        <td cellspan=3 cellpadding="3" >
    <select name=idclasa>
        <%        List es = new ClasaDAO().getByAn(request.getSession().getAttribute("idan")+"");
            if (es!=null)
            for (int i = 0; i < es.size(); i++) {
                ClasaBean b = (ClasaBean) es.get(i);
        %>
           <option name="DA" type="text"  value="<%=b.getId()%>"  <%=b.getId()==ua.getId_clasa()?"Selected":""%>><%=b.getDen()%></option>
        <%}%>
    </select>
        </td>
    </tr>    <tr>
        <td width="201">Utilizator : </td>
        <td cellspan=3 cellpadding="3" >
    <select name=iduser>
        <%        List c = new UserDAO().getALL();
            if (c!=null)
            for (int i = 0; i < c.size(); i++) {
                UsersBean b = (UsersBean) c.get(i);
        %>
           <option name="DA" type="text"  value="<%=b.getUsername()%>" <%=b.getUsername()==ua.getUsername()?"Selected":""%>><%=b.getName()%></option>
        <%}%>
    </select>
        </td>
    </tr>
     <tr>
    <td width="201">Observatii : </td>
    <td width="282">
    <input name="obs" type="text" size="30" value="">
    </td>
  </tr>

</table>
</form>
</td></tr>
</table>
