<%@ page import="java.util.List,
                 java.util.ArrayList,
                 ro.auto.beans.UsersBean,
                 ro.dirigentie.dao.UserDAO
            "%>
<%
    if(request.getSession().getAttribute("userbean")== null || ((UsersBean) request.getSession().getAttribute("userbean")).getUsername()== null)
        response.sendRedirect(response.encodeRedirectURL("../login/login.jsp"));
%>
<BODY BACKGROUND="../img/background.jpg">
<table class="titlu">
<tr><td valign=top>
        <jsp:include page="../menu.jsp" flush="true"/>
</td><td>
        &nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;
</td><td>
        <br>
        <h2 align=center>Administrare Utilizatori</h2>
        <br>
            <input type="button" name="add" value="Adauga"
            onClick="document.location='add.jsp'" >
        <br><br>
        <%--<%@taglib uri="/WEB-INF/tlds/c.tld" prefix="c" %>--%>
        <%--<c:out value="${listElementsCount}"/>--%>
        <table border=1 cellpadding="3" cellspacing="0" width="90%">
        <tr>
            <th>user</th>
            <th>Nume</th>
            <th>Email</th>
            <th width=120 nowrap>Drepturi</th>
            <th width=100 nowrap>Tel.</th>
            <th width=160 nowrap>Creat</th>
            <th>&nbsp;</th>
            <th>&nbsp;</th>
        </tr>
        <%

            UsersBean ua = new UsersBean();
            UserDAO userDAO = new UserDAO();

//            ro.sam.dao.UserDAO uDAO = new ro.sam.dao.UserDAO();
System.out.println("1");
            if(request.getParameter("Del")!= null) {
                System.out.println("2");

                if(request.getParameter("user")!= null)
                    userDAO.deleteUser(request.getParameter("user"));
            } if(request.getParameter("Add")!= null) {
                ua.setUsername(request.getParameter("user"));
                ua.setUserpassword(request.getParameter("Password"));
                ua.setName(request.getParameter("Name"));
                ua.setEmail(request.getParameter("Email"));
                ua.setUsertype(request.getParameter("Type"));
                ua.setAddress1(request.getParameter("Address1"));
                ua.setAddress2(request.getParameter("Address2"));
                ua.setCity(request.getParameter("City"));
                ua.setCountry(request.getParameter("Country"));
                ua.setEmail(request.getParameter("Email"));
                ua.setPhone(request.getParameter("Phone"));

//                ua.setChatuserid(u.getUser_id());
                userDAO.insert(ua);

            } else if(request.getParameter("Save")!= null) {
                if(request.getParameter("user")!= null) {
                    Object [] s = new Object[1];
                    s[0] = request.getParameter("user");
                    ua = (UsersBean) userDAO.getByPK(s).get(0);
                }

                ua.setUsername(request.getParameter("user"));
                ua.setName(request.getParameter("Name"));
                ua.setUserpassword(request.getParameter("Password"));
                ua.setEmail(request.getParameter("Email"));
                ua.setUsertype(request.getParameter("Type"));
                ua.setAddress1(request.getParameter("Address1"));
                ua.setAddress2(request.getParameter("Address2"));
                ua.setCity(request.getParameter("City"));
                ua.setCountry(request.getParameter("Country"));
                ua.setEmail(request.getParameter("Email"));
                ua.setPhone(request.getParameter("Phone"));
                userDAO.update(ua);

            }

        //    String count = "" + userDAO.getCount();
            List elements = userDAO.getALL();

            if (elements!=null)
            for (int i = 0; i < elements.size(); i++) {
                UsersBean sb = (UsersBean) elements.get(i);
        %>
        <tr>
            <td><%=sb.getUsername()!=null?sb.getUsername():""%>&nbsp;</td>
            <td><%=sb.getName()!=null?sb.getName():""%>&nbsp;</td>
            <td><%=sb.getEmail()!=null?sb.getEmail():""%>&nbsp;</td>
            <td><%=sb.getUsertype()!=null?sb.getUsertype():""%>&nbsp;</td>
            <td><%=sb.getPhone()!=null?sb.getPhone():""%>&nbsp;</td>
            <td align="center"><%=sb.getLastLogin()!=null?sb.getLastLogin()+"":""%>&nbsp;</td>

            <td align="center">
            <input type="button" name="Init" value="Modifica"
                onClick="document.location='edit.jsp?user=<%=sb.getUsername()%>'" >
            </td>
            <td align="center">
            <input type="button" name="Init" value="Sterge"
                onClick="document.location='del.jsp?user=<%=sb.getUsername()%>'" >
            </td>
        </tr>
        <%
            }
        %>
        </table>
</td></tr>
</table>

