<%@ page import="java.util.ArrayList,
                 java.util.List,
                 ro.auto.beans.*,
                 ro.dirigentie.dao.UserDAO,
                 ro.dirigentie.dao.ParinteDAO,
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

    ParinteBean b = new ParinteBean();
    ParinteDAO userDAO = new ParinteDAO();
    System.out.println("111");
    List elements = userDAO.getByPK(new Object[] {request.getParameter("id")});
    System.out.println("222");
    b = (ParinteBean) elements.get(0);
    System.out.println("333"+b.getStatut());

%>


<h2 align=center>Editare Parinte</h2>
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
    <input name="id" type="hidden" size="20" maxlength="15" value="<%=b.getId()%>">
    &nbsp;</td>
  </tr>


  <tr>
    <td width="201">Nume : </td>
    <td width="282">
    <input name="nume" type="text" size="30" value="<%=b.getNume()!=null?b.getNume():""%>">
    </td>
   </tr>
  <tr>
    <td width="201">Profesie : </td>
    <td width="282">
    <input name="prof" type="text" size="30" value="<%=b.getProfesie()!=null?b.getProfesie():""%>">
    </td>
   </tr>
   </tr>  <tr>
    <td width="201">Loc de munca : </td>
    <td width="282">
    <input name="locmun" type="text" size="30" value="<%=(b.getLoc_munca()!=null?(DateUtils.getDate(b.getLoc_munca())):"")%>">
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
    <td width="201">Se afla in tara : </td>
    <td width="282">
    <select name=intr>
       <option name="DA" type="text" value="DA" <%=b.getIntara().equals("DA")?"Selected":""%>>DA</option>
        <option name="NU" type="text" value="NU" <%=b.getIntara().equals("NU")?"Selected":""%>>NU</option>
     </select>
    </td>
   </tr>
     <tr>
    <td width="201">Observatii : </td>
    <td width="282">
    <input name="obs" type="text" size="30" value="<%=b.getObs()!=null?b.getObs():""%>">
    </td>
   </tr>
  <tr>
    <td width="201">Statut : </td>
    <td width="282">
    <select name=statut>
        <option name="Casatorit" type="text" value="Casatorit" <%=b.getStatut().equals("Casatorit")?"Selected":""%>>Casatorit</option>
        <option name="Necasatorit" type="text" value="Necasatorit" <%=b.getStatut().equals("Necasatorit")?"Selected":""%>>Necasatorit</option>
        <option name="Divortat" type="text" value="Divortat" <%=b.getStatut().equals("Divortat")?"Selected":""%>>Divortat</option>
        <option name="Tutore" type="text" value="Tutore" <%=b.getStatut().equals("Tutore")?"Selected":""%>>Tutore</option>
    </select>
    </td>
   </tr>

</table>
</form>
</td></tr>
</table>
