<%@ page import="java.util.List,
                 java.util.ArrayList,
                 ro.auto.beans.*,
                 java.util.Date
           "%>
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

<h2 align=center>Adaugare Parinte</h2>
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

    <td width="201">Nume : </td>
    <td width="282">
    <input name="nume" type="text" size="30" value="">
    </td>
   </tr>  <tr>
    <td width="201">Profesie : </td>
    <td width="282">
    <input name="prof" type="text" size="30" value="">
    </td>
   </tr>
     <tr>
    <td width="201">Loc de munca : </td>
    <td width="282">
    <input name="locmnc" type="text" size="30" value="">
    </td>
   </tr>
  <tr>
  <tr>
    <td width="201">Adresa : </td>
    <td width="282">
    <input name="adr" type="text" size="30" value="">
    </td>
   </tr>
  <tr>
    <td width="201">Localitate : </td>
    <td width="282">
    <input name="loc" type="text" size="30" value="">
    </td>
   </tr>
  <tr>
    <td width="201">Judet : </td>
    <td width="282">
    <input name="jud" type="text" size="30" value="">
    </td>
   </tr>
  <tr>
    <td width="201">Email : </td>
    <td width="282">
    <input name="email" type="text" size="30" value="">
    </td>
   </tr>
  <tr>
    <td width="201">Telefon : </td>
    <td width="282">
    <input name="tel" type="text" size="30" value="">
    </td>
   </tr>
  <tr>
    <td width="201">Cod Postal : </td>
    <td width="282">
    <input name="cod" type="text" size="30" value="">
    </td>
   </tr>
  <tr>
    <td width="201">In tara : </td>
    <td width="282">
        <select name=intr>
    <option name="DA" type="text" value="DA">DA</option>
    <option name="NU" type="text" value="NU">NU</option>
    </select>
    </td>
   </tr>
     <tr>
    <td width="201">Observatii : </td>
    <td width="282">
    <input name="obs" type="text" size="30" value="">
    </td>
   </tr>
  <tr>
    <td width="201">Statut : </td>
    <td width="282">
    <select name=statut>
    <option name="Casatorit" type="text" value="Casatorit">Casatorit</option>
    <option name="Necasatorit" type="text" value="Necasatorit">Necasatorit</option>
    <option name="Divortat" type="text" value="Divortat">Divortat</option>
    <option name="Tutore" type="text" value="Tutore">Tutore</option>
    </select>
    </td>
   </tr>
  </table>

</form>
</td></tr>
</table>
