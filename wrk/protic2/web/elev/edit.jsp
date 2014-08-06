<%@ page import="java.util.ArrayList,
                 java.util.List,
                 ro.auto.beans.*,
                 ro.dirigentie.dao.UserDAO,
                 ro.dirigentie.dao.ElevDAO,
                 ro.utils.DateUtils"%>
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

    ElevBean b = new ElevBean();
    ElevDAO userDAO = new ElevDAO();
    List elements = userDAO.getByPK(new Object[] {request.getParameter("id")});
    b = (ElevBean) elements.get(0);

%>


<h2 align=center>Editare Elev</h2>
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
    <input name="id" type="hidden" size="20" maxlength="15" value="<%=b.getId()%>">
    &nbsp;</td>
  </tr>

  <tr>
    <td width="201">Nr. Matr. : </td>
    <td width="282">
    <input name="nrmat" type="text" size="30" value="<%=b.getMatr()!=0?b.getMatr():""%>">
    </td>
   </tr>
  <tr>
    <td width="201">Nume : </td>
    <td width="282">
    <input name="nume" type="text" size="30" value="<%=b.getNume()!=null?b.getNume():""%>">
    </td>
   </tr>
      </tr>  <tr>
    <td width="201">Data Nasterii : </td>
    <td width="282">
    <input name="datan" type="text" size="30" value="<%=(b.getDatan()!=null?(DateUtils.getDate(b.getDatan())):"")%>">
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
  <tr>
    <td width="201">Cod Postal : </td>
    <td width="282">
    <input name="cod" type="text" size="30" value="<%=b.getCodp()!=0?b.getCodp():""%>">
    </td>
   </tr>
  <tr>
    <td width="201">Sex : </td>
    <td width="282">
    <select name=sex>
        <option name="M" type="text" value="M" <%=b.getSex().equals("M")?"Selected":""%>>M</option>
        <option name="F" type="text" value="F" <%=b.getSex().equals("F")?"Selected":""%>>F</option>
    </select>
    </td>
   </tr>
     <tr>
    <td width="201">Nationalitate : </td>
    <td width="282">
    <input name="nat" type="text" size="30" value="<%=b.getNat()!=null?b.getNat():""%>">
    </td>
   </tr>
  <tr>
    <td width="201">Statut : </td>
    <td width="282">
    <select name=statut>
        <option name="Inmatriculat" type="text" value="Inmatriculat" <%=b.getStatut().equals("Inmatriculat")?"Selected":""%>>Inmatriculat</option>
        <option name="Neinmatriculat" type="text" value="Neinmatriculat" <%=b.getStatut().equals("Neinmatriculat")?"Selected":""%>>Neinmatriculat</option>
        <option name="Exmatriculat" type="text" value="Exmatriculat" <%=b.getStatut().equals("Exmatriculat")?"Selected":""%>>Exmatriculat</option>
    </select>
    </td>
   </tr>
</table>
</form>
</td></tr>
<%--    <tr>--%>
<%--    <td width="201">--%>
<%--           <input type="button" name="parinti" value="Parinti elev"--%>
<%--            onClick="document.location='../parinte/list.jsp?id_elev=<%=request.getParameter("id")%>'" >--%>
<%--</td></tr>--%>
<%--</tr>--%>
<%--    <tr>--%>
<%--    <td width="201">--%>
<%--           <input type="button" name="medii" value="Medii elev"--%>
<%--            onClick="document.location='../media/list.jsp?id_elev=<%=request.getParameter("id")%>'" >--%>
<%--</td></tr>--%>
<%--    <tr>--%>
<%--    <td width="201">--%>
<%--           <input type="button" name="medii" value="Absente elev"--%>
<%--            onClick="document.location='../absente/list.jsp?id_elev=<%=request.getParameter("id")%>'" >--%>
<%--</td></tr>--%>
</table>
