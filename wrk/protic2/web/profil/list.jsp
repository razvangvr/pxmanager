<%@ page import="java.util.List,
                 java.util.ArrayList,
                 ro.auto.beans.UsersBean,
                 ro.auto.beans.ProfilBean,
                 ro.dirigentie.dao.ProfilDAO"%>
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

        <h2 align=center>Administrare Profile</h2>
        <br>
            <input type="button" name="add" value="Adauga"
            onClick="document.location='add.jsp'" >
        <br/><br>
        <P>

        <table width="370" border="0" cellpadding="0">
        <tr>
            <th cellspan=3 >Denumire Profil</th>
        </tr>
        <%

            ProfilBean ua = new ProfilBean();
            ProfilDAO profilDAO = new ProfilDAO();

//            ro.sam.dao.profilDAO uDAO = new ro.sam.dao.profilDAO();

            if(request.getParameter("Del")!= null) {
                if(request.getParameter("id")!= null) {
                    Object [] s = new Object[1];
                    s[0] = request.getParameter("id");
                    ua = (ProfilBean) profilDAO.getByPK(s).get(0);
                }
                profilDAO.delete(ua.getId());            }
            if(request.getParameter("Add")!= null) {
                ua.setDen(request.getParameter("den"));
                profilDAO.insert(ua);
            } else if(request.getParameter("Save")!= null) {
                if(request.getParameter("id")!= null) {
                    Object [] s = new Object[1];
                    s[0] = request.getParameter("id");
                    ua = (ProfilBean) profilDAO.getByPK(s).get(0);
                }
                ua.setDen(request.getParameter("den"));
                profilDAO.update(ua);
            }

        //    String count = "" + profilDAO.getCount();
            List elements = profilDAO.getALL();

            if (elements!=null)
            for (int i = 0; i < elements.size(); i++) {
                ProfilBean sb = (ProfilBean) elements.get(i);
        %>
        <tr>
            <td ><%=sb.getDen()!=null?sb.getDen():""%>&nbsp;</td>
            <td align="center">
            <input type="button" name="Init" value="Modifica"
                onClick="document.location='edit.jsp?id=<%=sb.getId()%>'" >
            </td>
            <td align="center">
            <input type="button" name="Init" value="Sterge"
                onClick="document.location='del.jsp?id=<%=sb.getId()%>'" >
            </td>
        </tr>
        <%
            }
        %>
        </table>
</td></tr>
</table>

