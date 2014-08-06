<%@ page import="java.util.List,
                 java.util.ArrayList,
                 ro.auto.beans.UsersBean,
                 ro.auto.beans.SpecializareBean,
                 ro.dirigentie.dao.SpecializareDAO"%>
<%
    if(request.getSession().getAttribute("userbean")== null || ((UsersBean) request.getSession().getAttribute("userbean")).getUsername()== null)
        response.sendRedirect(response.encodeRedirectURL("../login/login.jsp"));
%>
<BODY BACKGROUND="../img/background.bmp">
<table class="titlu">
<tr><td valign=top>
        <jsp:include page="../menu.jsp" flush="true"/>
</td><td width=10%>
        &nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;
</td><td>
        <br>

        <h2 align=center>Administrare Specializare</h2>
        <br>
            <input type="button" name="add" value="Adauga"
            onClick="document.location='add.jsp'" >
        <br/><br>
        <P>

        <table width="450" border="0" cellpadding="0">
        <tr>
            <th cellspan=3 cellpadding="3" >Denumire Specializare</th>
        </tr>
        <%

            SpecializareBean ua = new SpecializareBean();
            SpecializareDAO SpecializareDAO = new SpecializareDAO();

//            ro.sam.dao.SpecializareDAO uDAO = new ro.sam.dao.SpecializareDAO();

            if(request.getParameter("Del")!= null) {
                if(request.getParameter("id")!= null) {
                    Object [] s = new Object[1];
                    s[0] = request.getParameter("id");
                    ua = (SpecializareBean) SpecializareDAO.getByPK(s).get(0);
                }
                SpecializareDAO.delete(ua.getId());            }
            if(request.getParameter("Add")!= null) {
                ua.setDen(request.getParameter("den"));
                SpecializareDAO.insert(ua);
            } else if(request.getParameter("Save")!= null) {
                if(request.getParameter("id")!= null) {
                    Object [] s = new Object[1];
                    s[0] = request.getParameter("id");
                    ua = (SpecializareBean) SpecializareDAO.getByPK(s).get(0);
                }
                ua.setDen(request.getParameter("den"));
                SpecializareDAO.update(ua);
            }

        //    String count = "" + SpecializareDAO.getCount();
            List elements = SpecializareDAO.getALL();

            if (elements!=null)
            for (int i = 0; i < elements.size(); i++) {
                SpecializareBean sb = (SpecializareBean) elements.get(i);
        %>
        <tr>
            <td colspan=3><%=sb.getDen()!=null?sb.getDen():""%>&nbsp;</td>
            <td align="center">
            <input type="button" name="Init" value="Modifica"
                onClick="document.location='edit.jsp?id=<%=sb.getId()%>'" >
            </td>
            <td align="center">
            <input type="button" name="Init" value="Sterge"
                onClick="document.location='del.jsp?id=<%=sb.getId()%>'" >
            </td>
<td width="100">&nbsp;
        </td>
      </tr>
        <%
            }
        %>
        </table>
</td></tr>
</table>

