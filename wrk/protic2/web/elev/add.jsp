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

<h2 align=center>Adaugare Elev</h2>
<form name="form1" method="post" action="list.jsp"
onSubmit="MM_validateForm('prDesignCode', 'Design Code', 'R', 'prCurrencyCode', 'Currency Code', 'R', 'prType', 'Instrument Type', 'R', 'prDescription', 'Description', 'R', 'prPDCode', 'POSA/Distributor', 'R', 'prCPCode', 'Content Provider', 'R', 'prCode', 'Code', 'R', 'prAmount','Amount','int','prQuantity','Quantity','int');return document.MM_returnValue">

<table width="400" border="0" cellpadding="0">
  <tr>
    <td colspan="2" align="left" >
    <P/>
    <input type="submit" name="Add" value="Adauga">
        <input type="button" name="cancel" value="Inapoi" onClick="document.location='list.jsp'">
  </td>
  </tr>
  <tr><td>
       &nbsp;<BR>
       </td>
  </tr>
  <tr>
    <td width="201">Nr. Matr. : </td>
    <td width="282">
    <input name="nrmat" type="text" size="30" value="">
    </td>
   </tr>
  <tr>
    <td width="201">Nume : </td>
    <td width="282">
    <input name="nume" type="text" size="30" value="">
    </td>
   </tr>  <tr>
    <td width="201">Data Nasterii : </td>
    <td width="282">
    <input name="datan" type="text" size="30" value="">
    </td>
   </tr>
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
    <td width="201">Sex : </td>
    <td width="282">
        <select name=sex>
    <option name="M" type="text" value="M">M</option>
    <option name="F" type="text" value="F">F</option>
    </select>
    </td>
   </tr>
     <tr>
    <td width="201">Nationalitate : </td>
    <td width="282">
    <input name="nat" type="text" size="30" value="">
    </td>
   </tr>
  <tr>
    <td width="201">Statut : </td>
    <td width="282">
    <select name=statut>
    <option name="Inmatriculat" type="text" value="Inmatriculat">Inmatriculat</option>
    <option name="Neinmatriculat" type="text" value="Neinmatriculat">Neinmatriculat</option>
    <option name="Exmatriculat" type="text" value="Exmatriculat">Exmatriculat</option>
    </select>
    </td>
   </tr>
  </table>

</form>
</td></tr>
</table>
