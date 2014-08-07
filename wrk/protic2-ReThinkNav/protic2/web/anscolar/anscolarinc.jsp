<%@ page import="java.util.List,
                 ro.auto.beans.UsersBean,
                 ro.utils.DateUtils,
                 ro.dirigentie.dao.AnscolarDAO,
                 ro.auto.beans.AnscolarBean"%>
<%
    if(request.getSession().getAttribute("userbean")== null || ((UsersBean) request.getSession().getAttribute("userbean")).getUsername()== null)
        response.sendRedirect(response.encodeRedirectURL("../login/login.jsp"));
%>
<BODY BACKGROUND="../img/background.jpg">
<table class="titlu">
<form name="form1" method="post" action="list.jsp">
<tr><td valign=top>
  <tr>
    <th width="301">Selecteaza an curent : </th>
    <td width="182">
    <select name=idan onchange="this.form.submit()">
        <%        List elements = new AnscolarDAO().getALL();
            if (elements!=null)
            for (int i = 0; i < elements.size(); i++) {
                AnscolarBean b = (AnscolarBean) elements.get(i);
        %>
           <option name="DA" type="text" value="<%=b.getId()%>" <%=session.getAttribute("idan")!=null && session.getAttribute("idan").equals(b.getId()+"")?"Selected":""%>><%=b.getDen()%></option>
        <%}%>
    </select>
    </td>
   </tr>
</td></tr>
</form>
</table>

