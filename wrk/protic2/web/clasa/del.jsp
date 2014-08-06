<%@ page import="java.util.ArrayList,
                 java.util.List,
                 ro.auto.beans.*,

                 ro.dirigentie.dao.UserDAO,
                 ro.dirigentie.dao.ClasaDAO,
                 ro.dirigentie.dao.ProfilDAO,
                 ro.dirigentie.dao.SpecializareDAO"%>
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

    ClasaBean ua = new ClasaBean();
    ClasaDAO userDAO = new ClasaDAO();
    List elements = userDAO.getByPK(new Object[] {request.getParameter("id")});
    ua = (ClasaBean) elements.get(0);

%>



<h2 align=center>Stregere Clasa</h2>
<form name="form1" method="post" action="list.jsp"
onSubmit="MM_validateForm('prDesignCode', 'Design Code', 'R', 'prCurrencyCode', 'Currency Code', 'R', 'prType', 'Instrument Type', 'R', 'prDescription', 'Description', 'R', 'prPDCode', 'POSA/Distributor', 'R', 'prCPCode', 'Content Provider', 'R', 'prCode', 'Code', 'R', 'prAmount','Amount','int','prQuantity','Quantity','int');return document.MM_returnValue">

<table width="489" border="0" cellpadding="0">
  <tr>
    <td colspan="2" align="left" >
        <P/><input type="submit" name="Del" value="Sterge">
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
    <td width="201">Denumire Clasa : </td>
    <td width="282">
        <input name="den" type="text" size="30" value="<%=ua.getDen()!=null?ua.getDen():""%>">
    </td>
  </tr>
    <tr>
        <td width="201">Profil : </td>
        <td cellspan=3 cellpadding="3" >
<%--        <jsp:include page="profilinc.jsp?idp=<%=ua.getId_profil()%>" flush="true"/>--%>

    <select name=idprofil>
        <%  List ep = new ProfilDAO().getALL();
            if (ep!=null)
            for (int i = 0; i < ep.size(); i++) {
                ProfilBean b = (ProfilBean) ep.get(i);
        %>
           <option name="DA" type="text" value="<%=b.getId()%>" <%=(ua.getId_profil()==b.getId())?"Selected":""%>><%=b.getDen()%></option>
        <%}%>
    </select>        </td>
    </tr>
    <tr>
        <td width="201">Specializare : </td>
        <td cellspan=3 cellpadding="3" >
    <select name=idspec>
        <%        List es = new SpecializareDAO().getALL();
            if (es!=null)
            for (int i = 0; i < es.size(); i++) {
                SpecializareBean b = (SpecializareBean) es.get(i);
        %>
           <option name="DA" type="text" value="<%=b.getId()%>" <%=ua.getId_specializare()==b.getId()?"Selected":""%>><%=b.getDen()%></option>
        <%}%>
    </select>
        </td>
    </tr>

</table>
</form>
</td></tr>
</table>
