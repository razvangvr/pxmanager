<%@ page import="java.util.List,
                 java.util.ArrayList,
                 ro.auto.beans.UsersBean,
                 ro.auto.beans.ClasaBean,
                 ro.dirigentie.dao.ClasaDAO"%>
<%
    if(request.getSession().getAttribute("userbean")== null || ((UsersBean) request.getSession().getAttribute("userbean")).getUsername()== null)
        response.sendRedirect(response.encodeRedirectURL("../login/login.jsp"));
%>
<BODY BACKGROUND="../img/background.jpg">
<table class="titlu">
<tr><td valign=top>
        <jsp:include page="../menu.jsp" flush="true"/>
</td><td width=10%>
        &nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;
</td><td>
        <br>

        <h2 align=center>Administrare Clase</h2>
        <br>
            <input type="button" name="add" value="Adauga"
            onClick="document.location='add.jsp'" >
        <br/><br>
        <P>

        <table width="350" border="0" cellpadding="0">
        <tr>
            <th cellpadding="3" >Clasa</th>
            <th   cellpadding="3" >An Scolar</th>
        </tr>
        <%

            ClasaBean ua = new ClasaBean();
            ClasaDAO ClasaDAO = new ClasaDAO();

//            ro.sam.dao.ClasaDAO uDAO = new ro.sam.dao.ClasaDAO();

            if(request.getParameter("Del")!= null) {
                if(request.getParameter("id")!= null) {
                    Object [] s = new Object[1];
                    s[0] = request.getParameter("id");
                    ua = (ClasaBean) ClasaDAO.getByPK(s).get(0);
                }
                ClasaDAO.delete(ua.getId());            }
            if(request.getParameter("Add")!= null) {
                ua.setDen(request.getParameter("den"));
                ua.setId_an(new Long(request.getSession().getAttribute("idan")+"").longValue());
                ua.setId_profil(new Integer(request.getParameter("idprofil")).intValue());
                ua.setId_specializare(new Integer(request.getParameter("idspec")).intValue());
                ClasaDAO.insert(ua);
            } else if(request.getParameter("Save")!= null) {
                if(request.getParameter("id")!= null) {
                    Object [] s = new Object[1];
                    s[0] = request.getParameter("id");
                    ua = (ClasaBean) ClasaDAO.getByPK(s).get(0);
                }
                ua.setDen(request.getParameter("den"));
                ua.setId_profil(new Integer(request.getParameter("idprofil")).intValue());
                ua.setId_specializare(new Integer(request.getParameter("idspec")).intValue());
                ClasaDAO.update(ua);
            }

        //    String count = "" + ClasaDAO.getCount();
            List elements = ClasaDAO.getByAn(request.getSession().getAttribute("idan")+"");

            if (elements!=null)
            for (int i = 0; i < elements.size(); i++) {
                ClasaBean sb = (ClasaBean) elements.get(i);
        %>
        <tr>
            <td colspan=1><%=sb.getDen()!=null?sb.getDen():""%>&nbsp;</td>
            <td width="182" align="center">
                <%=request.getSession().getAttribute("denan")%>
            </td>
            <td align="center">
            <input type="button" name="Init" value="Modifica"
                onClick="document.location='edit.jsp?id=<%=sb.getId()%>'" >
            </td>
<%--            <td align="center">--%>
<%--            <input type="button" name="Init" value="Sterge"--%>
<%--                onClick="document.location='del.jsp?id=<%=sb.getId()%>'" >--%>
<%--            </td>  --%>
            <td align="center">
            <input type="button" name="Init" value="Elevi"
                onClick="document.location='../eleviclasa/list.jsp?id_clasa=<%=sb.getId()%>'" >
            </td>
        </tr>
        <%
            }
        %>
        </table>
</td></tr>
</table>

