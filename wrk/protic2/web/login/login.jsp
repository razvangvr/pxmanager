<%@ page import="ro.auto.beans.UsersBean, java.util.List, ro.dirigentie.dao.UserDAO"%>
<%
    System.out.println("logiiin");
    if (request.getParameter("logout") != null) {
        request.getSession().removeAttribute("userbean");
    } else {

        UsersBean ua = new UsersBean();
        ro.dirigentie.dao.UserDAO userDAO = new ro.dirigentie.dao.UserDAO();
        if (request.getParameter("user") != null) {
            List elements = userDAO.getByPK(new String[]{request.getParameter("user")});
            if (elements != null && elements.size() > 0) {

                ua = (UsersBean) elements.get(0);
                System.out.println(elements.get(0).toString());

                if (ua != null && ua.getUserpassword().equals(request.getParameter("Password"))) {
                    request.getSession().setAttribute("userbean", ua);
                } else {
                    System.out.println("ua very null");
                }
            }
        }

        if (request.getSession().getAttribute("userbean") != null && ((UsersBean) request.getSession().getAttribute("userbean")).getUsername() != null) {
            response.sendRedirect(response.encodeRedirectURL("../anscolar/list.jsp"));
        }

        //    {
//        if (((UsersBean) request.getSession().getAttribute("userbean")).getUsertype().equals("ADMIN"))
//            response.sendRedirect(response.encodeRedirectURL("../useradmins/list.jsp"));
//        else
//            response.sendRedirect(response.encodeRedirectURL("../browse/ViewStatus.jsp"));
//    }
    }
%>

<form>
    <table>
        <tr>
            <td valign=top id="leftMenu">
                <jsp:include page="../leftMenu.jsp" flush="true"/>
            </td>
            <td id="PageFunctionality">
                <br>
                <h2 align=center>User Login</h2>
                <br>

                <table>
                    <tr>
                        <td width="201">Username: </td>
                        <td width="282">
                            <input name="user" type="text" size="20" maxlength="15" value="">
                        </td>
                    </tr>
                    <tr>
                        <td width="201">Password: </td>
                        <td width="282"><input name="Password" type="password" size="20" maxlength="15" value=""></td>
                    </tr>
                    <tr>
                        <td width="201"></td>
                        <td>
                            <input type="submit" name="Login" value="Login">
                        </td></tr>
                </table>
            </td>
        </tr>
    </table>
</form>
