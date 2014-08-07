<%@ page import="java.util.ArrayList,
                 java.util.List,
                 ro.auto.beans.*,

                 ro.dirigentie.dao.UserDAO,
                 ro.dirigentie.dao.AnscolarDAO"%>
<!DOCTYPE HTML PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN"
"http://www.w3.org/TR/html4/loose.dtd">
<BODY BACKGROUND="../img/background.jpg">
<table class="titlu">
    <tr><td valign=top>
        <jsp:include page="../leftMenu.jsp" flush="true"/>
    </td>
    <td width=10%>
        &nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;<BR>
    </td>
    <td><br>
<%  int len = 0;

    AnscolarBean ua = new AnscolarBean();
    AnscolarDAO userDAO = new AnscolarDAO();
    List elements = userDAO.getByPK(new Object[] {request.getParameter("id")});
    ua = (AnscolarBean) elements.get(0);

%>



<h2 align=center>Stregere An Scolar</h2>
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
    <td width="201">Denumire An Scolar : </td>
    <td width="282">
    <B><%=ua.getDen()!=null?ua.getDen():""%></B>
    </td>
  </tr>

</table>
</form>
</td></tr>
</table>
