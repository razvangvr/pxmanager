<%@ page import="java.util.List,
         java.util.ArrayList,
         ro.auto.beans.UsersBean,
         ro.auto.beans.DisciplinaBean,
         ro.dirigentie.dao.DisciplinaDAO"%>
<%
    if (request.getSession().getAttribute("userbean") == null || ((UsersBean) request.getSession().getAttribute("userbean")).getUsername() == null) {
        response.sendRedirect(response.encodeRedirectURL("../login/login.jsp"));
    }
%>
<BODY >
    <table class="titlu">
        <tr>
            <td valign=top>
                <jsp:include page="../leftMenu.jsp" flush="true"/>
            </td><td width=10%>
                &nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;
            </td><td>
                <br>

                <h2 align=center>Administrare Disciplina</h2>
                <br>
                <input type="button" name="add" value="Adauga"
                       onClick="document.location = 'add.jsp'" >
                <br/><br>
                <P>

                <table width="320" border="0" cellpadding="0">
                    <tr>
                        <th cellspan=3 cellpadding="3" >Denumire Disciplina</th>
                    </tr>
                    <%
                        DisciplinaBean ua = new DisciplinaBean();
                        DisciplinaDAO DisciplinaDAO = new DisciplinaDAO();

                        //            ro.sam.dao.DisciplinaDAO uDAO = new ro.sam.dao.DisciplinaDAO();
                        if (request.getParameter("Del") != null) {
                            if (request.getParameter("id") != null) {
                                Object[] s = new Object[1];
                                s[0] = request.getParameter("id");
                                ua = (DisciplinaBean) DisciplinaDAO.getByPK(s).get(0);
                            }
                            DisciplinaDAO.delete(ua.getId());
                        }
                        if (request.getParameter("Add") != null) {
                            ua.setDen(request.getParameter("den"));
                            DisciplinaDAO.insert(ua);
                        } else if (request.getParameter("Save") != null) {
                            if (request.getParameter("id") != null) {
                                Object[] s = new Object[1];
                                s[0] = request.getParameter("id");
                                ua = (DisciplinaBean) DisciplinaDAO.getByPK(s).get(0);
                            }
                            ua.setDen(request.getParameter("den"));
                            DisciplinaDAO.update(ua);
                        }

                        //    String count = "" + DisciplinaDAO.getCount();
                        List elements = DisciplinaDAO.getALL();

                        if (elements != null)
                            for (int i = 0; i < elements.size(); i++) {
                                DisciplinaBean sb = (DisciplinaBean) elements.get(i);
                    %>
                    <tr>
                        <td colspan=3><%=sb.getDen() != null ? sb.getDen() : ""%>&nbsp;</td>
                        <td align="center">
                            <input type="button" name="Init" value="Modifica"
                                   onClick="document.location = 'edit.jsp?id=<%=sb.getId()%>'" >
                        </td>
                        <%--            <td align="center">--%>
                        <%--            <input type="button" name="Init" value="Sterge"--%>
                        <%--                onClick="document.location='del.jsp?id=<%=sb.getId()%>'" >--%>
                        <%--            </td>--%>
                        <%--        </tr>--%>
                        <%
                            }
                        %>
                </table>
            </td>
        </tr>
    </table>

