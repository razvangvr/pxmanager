<%@ page import="java.util.List,
                 java.util.ArrayList,
                 ro.auto.beans.UsersBean,
                 ro.auto.beans.ProfesorBean,
                 ro.dirigentie.dao.ProfesorDAO"%>
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

        <h2 align=center>Administrare Profesori</h2>
        <br>
            <input type="button" name="add" value="Adauga"
            onClick="document.location='add.jsp'" >
        <br/><br>
        <P>

        <table width="550" border="0" cellpadding="0">
        <tr>
            <th width=140 nowrap cellspan=3 cellpadding="3" >Nume </th>
            <th width=100 nowrap>Localitate</th>
            <th width=100 nowrap>Email</th>
            <th width=120 nowrap>Telefon</th>
            <th>&nbsp;</th>
            <th>&nbsp;</th>
            <th>&nbsp;</th>
        </tr>
        <%

            ProfesorBean ua = new ProfesorBean();
            ProfesorDAO ProfesorDAO = new ProfesorDAO();

//            ro.sam.dao.ProfesorDAO uDAO = new ro.sam.dao.ProfesorDAO();

            if(request.getParameter("Del")!= null) {
                if(request.getParameter("id")!= null) {
                    Object [] s = new Object[1];
                    s[0] = request.getParameter("id");
                    ua = (ProfesorBean) ProfesorDAO.getByPK(s).get(0);
                }
                ProfesorDAO.delete(ua.getId());            }
            if(request.getParameter("Add")!= null) {
                ua.setNume(request.getParameter("num"));
                ua.setAdr(request.getParameter("adr"));
                ua.setLoc(request.getParameter("loc"));
                ua.setJud(request.getParameter("jud"));
                ua.setTel(request.getParameter("tel"));
//                System.out.println("statut "+ request.getParameter("statut"));
                ua.setEmail(request.getParameter("email"));
                ProfesorDAO.insert(ua);
            } else if(request.getParameter("Save")!= null) {
                if(request.getParameter("id")!= null) {
                    Object [] s = new Object[1];
                    s[0] = request.getParameter("id");
                    ua = (ProfesorBean) ProfesorDAO.getByPK(s).get(0);
                }
                ua.setNume(request.getParameter("num"));
                ua.setAdr(request.getParameter("adr"));
                ua.setLoc(request.getParameter("loc"));
                ua.setJud(request.getParameter("jud"));
                ua.setTel(request.getParameter("tel"));
//                System.out.println("statut "+ request.getParameter("statut"));
                ua.setEmail(request.getParameter("email"));
                ProfesorDAO.update(ua);
            }

        //    String count = "" + ProfesorDAO.getCount();
            List elements = ProfesorDAO.getALL();

            if (elements!=null)
            for (int i = 0; i < elements.size(); i++) {
                ProfesorBean sb = (ProfesorBean) elements.get(i);
        %>
        <tr>
            <td><%=sb.getNume()!=null?sb.getNume():""%>&nbsp;</td>
            <td><%=sb.getNume()!=null?sb.getLoc():""%>&nbsp;</td>
            <td><%=sb.getEmail()!=null?sb.getEmail():""%>&nbsp;</td>
             <td><%=sb.getTel()!=null?sb.getTel():""%>&nbsp;</td>

            <td align="center">
            <input type="button" name="Init" value="Modifica"
                onClick="document.location='edit.jsp?id=<%=sb.getId()%>'" >
            </td>
<%--            <td align="center">--%>
<%--            <input type="button" name="Init" value="Sterge"--%>
<%--                onClick="document.location='del.jsp?id=<%=sb.getId()%>'" >--%>
<%--            </td>--%>

            <td width="201">
           <input type="button" name="parinti" value="Discipline"
            onClick="document.location='../disciplineprofesori/list.jsp?id_profesor=<%=sb.getId()%>'" >
            </td>
            </tr>
        <%
            }
        %>
        </table>
</td></tr>
</table>

