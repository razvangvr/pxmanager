<%@ page import="java.util.ArrayList,
                 java.util.List,
                 ro.auto.beans.*,
                 ro.sam.dao.UseradminsDAO
                 ,
                 ro.sam.dao.BusDAO"%>
<!DOCTYPE HTML PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN"
"http://www.w3.org/TR/html4/loose.dtd">

<table>
<tr><td valign=top>
        <jsp:include page="../menu.jsp" flush="true"/>
</td><td>
        &nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;
</td><td>


<%  int len = 0;

//    Object[] o = new Object[1];
//    UseradminsBean bus = new UseradminsBean();
//    bus.setUsername(request.getParameter("user"));
//    o[0] = bus ;

    BusBean bus = new BusBean();
    BusDAO bDAO = new BusDAO();
    List elements = bDAO.getByPK(new Object[] {request.getParameter("id")});
    bus = (BusBean) elements.get(0);
//    bus = new UseradminsBean();

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

<h2 align=center>Sterge Autobuz/Troleibuz</h2>
<br><br>

<form name="form1" method="post" action="list.jsp"
onSubmit="MM_validateForm('prDesignCode', 'Design Code', 'R', 'prCurrencyCode', 'Currency Code', 'R', 'prType', 'Instrument Type', 'R', 'prDescription', 'Description', 'R', 'prPDCode', 'POSA/Distributor', 'R', 'prCPCode', 'Content Provider', 'R', 'prCode', 'Code', 'R', 'prAmount','Amount','int','prQuantity','Quantity','int');return document.MM_returnValue">

<table width="489" border="0" cellpadding="0">
  <tr>
    <td colspan="2" align="left" ><input type="submit" name="Del" value="Sterge">
        <input type="button" name="cancel" value="Renunta" onClick="document.location='list.jsp'">
        <input type="hidden" name="Id" value="<%=bus.getId()%>">
<%--<input type="submit" name="Submit3" value="Initialize DB for Program"></td>--%>
  </tr>
  <tr>
<%--    <td colspan="2" align="left" ><c:out value="${errorMessage}"/>&nbsp;</td>--%>
  </tr>


  <tr>
    <td>Categorie:</td>
    <td>
        <select name="Type">
<%--        <select name="SUType" onchange="alert(document.forms[0].elements('code').value)">--%>
            <option value="Troleibuze" <%=(bus.getCategorie()!=null&&bus.getCategorie().equals("Troleibuze")?"selected":"")%>>Troleibuze</option>
            <option value="Autobuze" <%=(bus.getCategorie()!=null&&bus.getCategorie().equals("Autobuze")?"selected":"")%>>Autobuze</option>
        </select>

<%--    <input name="prPDCode" type="text" size="20" maxlength="15" value="<c:out value="${bean.prPDCode}"/>">--%>
    </td>
  </tr>
  <tr>
    <td width="201">Denumire: </td>
    <td width="282">
    <input name="Denumire" type="text" size="20" maxlength="15" value="<%=bus.getDenumire()!=null?bus.getDenumire():""%>">
    </td>
  </tr>
  <tr>
    <td width="201">Tara import: </td>
    <td width="282"><input name="Taraimport" type="text" size="20" maxlength="15" value="<%=bus.getTaraimport()!=null?bus.getTaraimport():""%>"></td>
  </tr>
  <tr>
    <td width="201">Bucati: </td>
    <td width="282"><input name="Buc" type="text" size="20" maxlength="15" value="<%=bus.getBuc()!=null?bus.getBuc():""%>"/></td>
  </tr>
  <tr>
    <td width="201">An Fabricatie: </td>
    <td width="282"><input name="An_fab" type="text" size="20" maxlength="15" value="<%=bus.getAn_fab()!=null?bus.getAn_fab():""%>"/></td>
  </tr>
  <tr>
    <td width="201">Locuri: </td>
    <td width="282"><input name="Nr_locuri" type="text" size="20" maxlength="15" value="<%=bus.getNr_locuri()!=null?bus.getNr_locuri():""%>"/></td>
  </tr>
  <tr>
    <td width="201">Lungime: </td>
    <td width="282"><input name="Lungime" type="text" size="20" maxlength="15" value="<%=bus.getLungime()!=null?bus.getLungime():""%>"/></td>
  </tr>
  <tr>
    <td width="201">Latime: </td>
    <td width="282"><input name="Latime" type="text" size="20" maxlength="15" value="<%=bus.getLatime()!=null?bus.getLatime():""%>"/></td>
  </tr>
  <tr>
    <td width="201">Inaltime: </td>
    <td width="282"><input name="Inaltime" type="text" size="20" maxlength="15" value="<%=bus.getInaltime()!=null?bus.getInaltime():""%>"/></td>
  </tr>
  <tr>
    <td width="201">Text 1: </td>
    <td width="282"><input name="Text1" type="text" size="20" maxlength="15" value="<%=bus.getText1()!=null?bus.getText1():""%>"/></td>
  </tr>
  <tr>
    <td width="201">Text 2: </td>
    <td width="282"><input name="Text2" type="text" size="20" maxlength="15" value="<%=bus.getText2()!=null?bus.getText2():""%>"/></td>
  </tr>
  <tr>
    <td width="201">Text 3: </td>
    <td width="282"><input name="Text3" type="text" size="20" maxlength="15" value="<%=bus.getText3()!=null?bus.getText3():""%>"/></td>
  </tr>
  <tr>
    <td width="201">Text 4: </td>
    <td width="282"><input name="Text4" type="text" size="20" maxlength="15" value="<%=bus.getText4()!=null?bus.getText4():""%>"/></td>
  </tr>

</table>
</form>
</td></tr>
</table>
