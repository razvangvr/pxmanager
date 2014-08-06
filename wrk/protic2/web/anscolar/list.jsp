
<%@ page import="java.util.List,
                 java.util.ArrayList,
                 ro.auto.beans.UsersBean,
                 ro.auto.beans.AnscolarBean,
                 ro.dirigentie.dao.AnscolarDAO"%>
<%
    if(request.getSession().getAttribute("userbean")== null || ((UsersBean) request.getSession().getAttribute("userbean")).getUsername()== null)
        response.sendRedirect(response.encodeRedirectURL("../login/login.jsp"));
%>
<table class="titlu">
<tr><td valign=top>
        <jsp:include page="../menu.jsp" flush="true"/>
</td><td width=10%>
        &nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;
</td><td>
        <br>
         <h2 align=center>Administrare Ani Scolari</h2>
        <br>
            <input type="button" name="add" value="Adauga"
            onClick="document.location='add.jsp'" >
        <br/><br>


        <table width="380" border="0" cellpadding="0">

        <tr>
            <th cellspan=3 cellpadding="3" >Ani Scolari</th>
        </tr>
        <%
            AnscolarBean ua = new AnscolarBean();
            AnscolarDAO AnscolarDAO = new AnscolarDAO();
            if(request.getParameter("idan")!= null) {
                request.getSession().setAttribute("idan", request.getParameter("idan"));
                Object [] s = new Object[1];
                s[0] = request.getParameter("idan");
                ua = (AnscolarBean) AnscolarDAO.getByPK(s).get(0);

               request.getSession().setAttribute("denan", ua.getDen());
             } else if(request.getParameter("Del")!= null) {
                if(request.getParameter("id")!= null) {
                    Object [] s = new Object[1];
                    s[0] = request.getParameter("id");
                    ua = (AnscolarBean) AnscolarDAO.getByPK(s).get(0);
                }
                AnscolarDAO.delete(ua.getId());
            } else if(request.getParameter("Add")!= null) {
                ua.setDen(request.getParameter("den"));
                AnscolarDAO.insert(ua);
            } else if(request.getParameter("Save")!= null) {
                if(request.getParameter("id")!= null) {
                    Object [] s = new Object[1];
                    s[0] = request.getParameter("id");
                    ua = (AnscolarBean) AnscolarDAO.getByPK(s).get(0);
                }
                ua.setDen(request.getParameter("den"));
                AnscolarDAO.update(ua);
            }
            List elements = AnscolarDAO.getALL();
            if (elements!=null)    {
            for (int i = 0; i < elements.size(); i++) {
                AnscolarBean sb = (AnscolarBean) elements.get(i);
        %>
        <tr>
            <td colspan=3 align=center><%=sb.getDen()!=null?sb.getDen():""%>&nbsp;</td>
            <td align="center">
            <input type="button" name="Init" value="Modifica"
                onClick="document.location='edit.jsp?id=<%=sb.getId()%>'" >
            </td>
<%--            <td align="center">--%>
<%--            <input type="button" name="Init" value="Sterge"--%>
<%--                onClick="document.location='del.jsp?id=<%=sb.getId()%>'" >--%>
<%--            </td>--%>
        </tr>
        <%
            }
                if(request.getSession().getAttribute("idan") == null) {
                    request.getSession().setAttribute("idan", ((AnscolarBean) elements.get(elements.size()-1)).getId()+"");
                    request.getSession().setAttribute("denan", ((AnscolarBean) elements.get(elements.size()-1)).getDen()+"");

                }
            }
        %>
        <tr>
            <td cellspan=2 cellpadding="3" >
            <jsp:include page="anscolarinc.jsp" flush="true"/>
            </td>
        </tr>
        <tr>
            <td cellspan=1 cellpadding="3" ><P></td>
        </tr>
        </table>
</td></tr>
</table>

