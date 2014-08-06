<%@ page import="java.util.ArrayList,
                 java.util.List,
                 ro.auto.beans.*,
                 ro.dirigentie.dao.UserDAO"%>
<!DOCTYPE HTML PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN"
"http://www.w3.org/TR/html4/loose.dtd">
<BODY BACKGROUND="../img/background.jpg">
<table class="titlu">
<tr><td valign=top>
        <jsp:include page="../menu.jsp" flush="true"/>
</td><td>
        &nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;
</td><td>

<%  int len = 0;
//    Object[] o = new Object[1];
//    UseradminsBean ua = new UseradminsBean();
//    ua.setUsername(request.getParameter("user"));
//    o[0] = ua ;
    UsersBean ua = new UsersBean();
    UserDAO userDAO = new UserDAO();
    List elements = userDAO.getByPK(new Object[] {request.getParameter("user")});
    ua = (UsersBean) elements.get(0);
//    ua = new UseradminsBean();

%>

<script>
    function setOptions(sel) { //v4.0

    len = <%=len%>
//    selection = document.forms[0].elements('SUType').value;
    selection = document.forms[0].SUType.value;
<%--    cps = new Array(<%=cps%>);--%>
<%--    posas = new Array(<%=posas%>);--%>

    for (i=0; i < len; i++) {
        sel[i] = null
    }

  for (i=0; i < len; i++) {
        sel[i] = null
    }
  for (i=0; i < len; i++) {
        sel[i] = null
    }

        if(selection=="CNTPRV") {
            for (i=0;  i < (cps.length); i++) {
                o = new Option(cps[i])
                o.value = cps[i]
                sel[i] = o
           }// for

<%--            for (i=cps.length; i < len; i++) {--%>
<%--                sel[i] = null--%>
<%--            }--%>
        } else if(selection=="POSADISTR") {
            for (i=0;  i < (posas.length); i++) {
                o = new Option(posas[i])
                o.value = posas[i]
                sel[i] = o
            }// for

            for (i=posas.length; i < len; i++) {
                sel[i] = null
            }
        }


    }
</script>

<h2 align=center>Stergere Utilizatori</h2>
<form name="form1" method="post" action="list.jsp"
onSubmit="MM_validateForm('prDesignCode', 'Design Code', 'R', 'prCurrencyCode', 'Currency Code', 'R', 'prType', 'Instrument Type', 'R', 'prDescription', 'Description', 'R', 'prPDCode', 'POSA/Distributor', 'R', 'prCPCode', 'Content Provider', 'R', 'prCode', 'Code', 'R', 'prAmount','Amount','int','prQuantity','Quantity','int');return document.MM_returnValue">

<table width="489" border="0" cellpadding="0">
  <tr>
    <td colspan="2" align="left" ><input type="submit" name="Del" value="Sterge">
        <input type="button" name="cancel" value="Back" onClick="document.location='list.jsp'">
        <input type="hidden" name="user" value="<%=ua.getUsername()%>">

<%--<input type="submit" name="Submit3" value="Initialize DB for Program"></td>--%>
  </tr>
  <tr>
<%--    <td colspan="2" align="left" ><c:out value="${errorMessage}"/>&nbsp;</td>--%>
  </tr>


  <tr>
    <td width="201">Utilizator: </td>
    <td width="282"><%=ua.getUsername()%>
    <input name="user" type="hidden" size="20" maxlength="15" value="<%=ua.getUsername()!=null?ua.getUsername():""%>">
    </td>
  </tr>
  <tr>
    <td width="201">Parola: </td>
    <td width="282"><input name="Password" type="password" size="20" maxlength="15" value="<%=ua.getUserpassword()%>"></td>
  </tr>


  <tr>
    <td>Tip utilizator:</td>
    <td>
        <select name="Type">
            <option value="ADMIN" >ADMIN</option>
            <option value="PROFESOR" <%=(ua.getUsertype()!=null&&ua.getUsertype().equals("PROFESOR")?"selected":"")%>>PROFESOR</option>
            <option value="ELEV" <%=(ua.getUsertype()!=null&&ua.getUsertype().equals("ELEV")?"selected":"")%>>ELEV</option>
        </select>

<%--    <input name="prPDCode" type="text" size="20" maxlength="15" value="<c:out value="${bean.prPDCode}"/>">--%>
    </td>
  <tr>
    <td width="201">Nume: </td>
    <td width="282"><input name="Name" type="text" size="20" maxlength="15" value="<%=ua.getName()!=null?ua.getName():""%>"/></td>
  </tr>
  <tr>
    <td width="201">Adresa: </td>
    <td width="282"><input name="Address1" type="text" size="20" maxlength="15" value="<%=ua.getAddress1()!=null?ua.getAddress1():""%>"/></td>
  </tr>
  <tr>
    <td width="201">Adresa: </td>
    <td width="282"><input name="Address2" type="text" size="20" maxlength="15" value="<%=ua.getAddress2()!=null?ua.getAddress2():""%>"/></td>
  </tr>
  <tr>
    <td width="201">Oras: </td>
    <td width="282"><input name="City" type="text" size="20" maxlength="15" value="<%=ua.getCity()!=null?ua.getCity():""%>"/></td>
  </tr>
  <tr>
    <td width="201">Tara: </td>
    <td width="282"><input name="Country" type="text" size="20" maxlength="15" value="<%=ua.getCountry()!=null?ua.getCountry():""%>"/></td>
  </tr>
  <tr>
    <td width="201">Email: </td>
    <td width="282"><input name="Email" type="text" size="20" maxlength="15" value="<%=ua.getEmail()!=null?ua.getEmail():""%>"/></td>
  </tr>
  <tr>
    <td width="201">Telefon: </td>
    <td width="282"><input name="Phone" type="text" size="20" maxlength="15" value="<%=ua.getPhone()!=null?ua.getPhone():""%>"/></td>
  </tr>

</table>
</form>
</td></tr>
</table>
