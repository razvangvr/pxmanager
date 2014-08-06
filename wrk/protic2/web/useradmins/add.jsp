<%@ page import="java.util.List,
                 java.util.ArrayList,
                 ro.auto.beans.*,
                 java.util.Date
                 ,
                 ro.dirigentie.dao.ClasaDAO"%>
<!DOCTYPE HTML PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<BODY BACKGROUND="../img/background.jpg">
<table>
<tr><td valign=top>
        <jsp:include page="../menu.jsp" flush="true"/>
</td><td>
<h2 align=center>Adaugare Administrare Utilizatori</h2>
<form name="form1" method="post" action="list.jsp"
onSubmit="MM_validateForm('prDesignCode', 'Design Code', 'R', 'prCurrencyCode', 'Currency Code', 'R', 'prType', 'Instrument Type', 'R', 'prDescription', 'Description', 'R', 'prPDCode', 'POSA/Distributor', 'R', 'prCPCode', 'Content Provider', 'R', 'prCode', 'Code', 'R', 'prAmount','Amount','int','prQuantity','Quantity','int');return document.MM_returnValue">

<table width="489" border="0" cellpadding="0">
  <tr>
    <td colspan="2" align="left" ><input type="submit" name="Add" value="Adauga">
        <input type="button" name="cancel" value="Back" onClick="document.location='list.jsp'">
<%--<input type="submit" name="Submit3" value="Initialize DB for Program"></td>--%>
  </tr>
  <tr>
<%--    <td colspan="2" align="left" ><c:out value="${errorMessage}"/>&nbsp;</td>--%>
  </tr>


 <tr>
    <td width="201">Utilizator: </td>
    <td width="282">
    <input name="user" type="text" size="20" maxlength="15" value="">
    </td>
  </tr>
  <tr>
    <td width="201">Parola: </td>
    <td width="282"><input name="Password" type="password" size="20" maxlength="15" value=""></td>
  </tr>

  <tr>
    <td>Tip utilizator:</td>
    <td>
        <select name="Type">
<%--        <select name="SUType" onchange="alert(document.forms[0].elements('code').value)">--%>
            <option value="ADMIN" >ADMIN</option>
            <option value="PROFESOR">PROFESOR</option>
            <option value="ELEV">ELEV</option>
        </select>

<%--    <input name="prPDCode" type="text" size="20" maxlength="15" value="<c:out value="${bean.prPDCode}"/>">--%>
    </td>
  <tr>
    <td width="201">Nume: </td>
    <td width="282"><input name="Name" type="text" size="20" maxlength="15" value=""/></td>
  </tr>
  <tr>
    <td width="201">Adresa: </td>
    <td width="282"><input name="Address1" type="text" size="20" maxlength="15" value=""/></td>
  </tr>
  <tr>
    <td width="201">Adresa: </td>
    <td width="282"><input name="Address2" type="text" size="20" maxlength="15" value=""/></td>
  </tr>
  <tr>
    <td width="201">Oras: </td>
    <td width="282"><input name="City" type="text" size="20" maxlength="15" value=""/></td>
  </tr>
  <tr>
    <td width="201">Tara: </td>
    <td width="282"><input name="Country" type="text" size="20" maxlength="15" value=""/></td>
  </tr>
  <tr>
    <td width="201">Email: </td>
    <td width="282"><input name="Email" type="text" size="20" maxlength="15" value=""/></td>
  </tr>
  <tr>
    <td width="201">Telefon: </td>
    <td width="282"><input name="Phone" type="text" size="20" maxlength="15" value=""/></td>
  </tr>
  \  <tr>
    <td width="201">An scolar curent : </td>
    <td width="282">
    <%=request.getSession().getAttribute("denan")%>
    </td>
  </tr>
  </table>

</form>
</td></tr>
</table>
