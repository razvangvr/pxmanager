<%@ page import="java.util.ArrayList,
                 java.util.List,
                 ro.auto.beans.*,

                 ro.dirigentie.dao.UserDAO,
                 ro.dirigentie.dao.ProfesorDAO"%>
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

    ProfesorBean b = new ProfesorBean();
    ProfesorDAO userDAO = new ProfesorDAO();
    List elements = userDAO.getByPK(new Object[] {request.getParameter("id")});
    b = (ProfesorBean) elements.get(0);

%>



<h2 align=center>Stregere Profesor</h2>
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
    <input name="id" type="hidden" size="20" maxlength="15" value="<%=b.getId()%>">
    &nbsp;</td>
  </tr>


  <tr>
    <td width="201">Nume Profesor : </td>
    <td width="282">
    <B><%=b.getNume()!=null?b.getNume():""%></B>
    </td>
  </tr>
  <tr>
    <td width="201">Adresa : </td>
    <td width="282">
    <input name="adr" type="text" size="30" value="<%=b.getAdr()!=null?b.getAdr():""%>">
    </td>
   </tr>
  <tr>
    <td width="201">Localitate : </td>
    <td width="282">
    <input name="loc" type="text" size="30" value="<%=b.getLoc()!=null?b.getLoc():""%>">
    </td>
   </tr>
  <tr>
    <td width="201">Judet : </td>
    <td width="282">
    <input name="jud" type="text" size="30" value="<%=b.getJud()!=null?b.getJud():""%>">
    </td>
   </tr>
  <tr>
    <td width="201">Email : </td>
    <td width="282">
    <input name="email" type="text" size="30" value="<%=b.getEmail()!=null?b.getEmail():""%>">
    </td>
   </tr>
  <tr>
    <td width="201">Telefon : </td>
    <td width="282">
    <input name="tel" type="text" size="30" value="<%=b.getTel()!=null?b.getTel():""%>">
    </td>
   </tr>
</table>
</form>
</td></tr>
</table>
