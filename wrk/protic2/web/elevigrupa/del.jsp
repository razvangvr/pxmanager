<%@ page import="java.util.ArrayList,
                 java.util.List,
                 ro.auto.beans.*,
                 ro.dirigentie.dao.UserDAO,
                 ro.dirigentie.dao.DisciplineprofesoriDAO,
                 ro.utils.DateUtils,
                 ro.dirigentie.dao.ClasaDAO,
                 ro.dirigentie.dao.DisciplinaDAO"%>
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

    DisciplineprofesoriBean db = new DisciplineprofesoriBean();
    DisciplineprofesoriDAO userDAO = new DisciplineprofesoriDAO();
    List elements = userDAO.getByPK(new Object[] {request.getParameter("id")});
    db = (DisciplineprofesoriBean) elements.get(0);


%>

<h2 align=center>Stregere Disciplineprofesori</h2>
<form name="form1" method="post" action="list.jsp"
onSubmit="MM_validateForm('prDesignCode', 'Design Code', 'R', 'prCurrencyCode', 'Currency Code', 'R', 'prType', 'Instrument Type', 'R', 'prDescription', 'Description', 'R', 'prPDCode', 'POSA/Distributor', 'R', 'prCPCode', 'Content Provider', 'R', 'prCode', 'Code', 'R', 'prAmount','Amount','int','prQuantity','Quantity','int');return document.MM_returnValue">

<table width="489" border="0" cellpadding="0">
  <tr>
    <td colspan="2" align="left" >
        <P/><input type="submit" name="Del" value="Sterge">
    <input type="button" name="cancel" value="Inapoi" onClick="document.location='list.jsp?id_clasa=<%=request.getParameter("id_clasa")%>'">
    <input type="hidden" name="id_clasa" value="<%=request.getParameter("id_clasa")%>">
    </td>
  </tr>
  <tr>
    <td colspan="2" align="left" >
    <input name="id" type="hidden" size="20" maxlength="15" value="<%=db.getId()%>">
    &nbsp;</td>
  </tr>


   <tr>
    <td width="201">An scolar curent : </td>
    <td width="282">
    <%=request.getSession().getAttribute("denan")%>
    </td>
   </tr>
    <tr>
        <td width="201">Clasa : </td>
        <td cellspan=3 cellpadding="3" >
<%--        <jsp:include page="profilinc.jsp?idp=<%=ua.getId_profil()%>" flush="true"/>--%>

    <select name=idclasa>
        <%  List ep = new ClasaDAO().getByAn(request.getSession().getAttribute("idan")+"");
            if (ep!=null)
            for (int i = 0; i < ep.size(); i++) {
                ClasaBean b = (ClasaBean) ep.get(i);
        %>
           <option name="DA" type="text"  value="<%=b.getId()%>" <%=db.getId_clasa()==b.getId()?"Selected":""%>><%=b.getDen()%></option>
        <%}%>
    </select>        </td>
    </tr>
    <tr>
        <td width="201">Disciplina : </td>
        <td cellspan=3 cellpadding="3" >
    <select name=iddisc>
        <%        List es = new DisciplinaDAO().getALL();
            if (es!=null)
            for (int i = 0; i < es.size(); i++) {
                DisciplinaBean b = (DisciplinaBean) es.get(i);
        %>
           <option name="DA" type="text"  value="<%=b.getId()%>" <%=db.getId_disciplina()==b.getId()?"Selected":""%>><%=b.getDen()%></option>
        <%}%>
    </select>
        </td>
    </tr>
     <tr>
    <td width="201">Ore : </td>
    <td width="282">
    <input name="ore" type="text" size="3" value="<%=db.getOre()%>">
    </td>
  </tr>
</table>
</form>
</td></tr>
</table>
