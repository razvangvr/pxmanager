<%@ page import="java.util.List,
                 java.util.ArrayList,
                 ro.dirigentie.dao.ElevDAO,
                 ro.auto.beans.ElevBean,
                 ro.auto.beans.UsersBean,
                 ro.utils.DateUtils"%>
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

        <h2 align=center>Administrare Elevi</h2>

        <br>

            <input type="button" name="add" value="Adauga"
            onClick="document.location='add.jsp'" >
        <br/><br>
        <P>

        <table width="450" border="0" cellpadding="0">
        <tr>
            <th width=70 nowrap>Nr. matr.</th>
            <th width=140 nowrap>Nume I. prenume</th>
<%--            <th width=140 nowrap>Email</th>--%>
            <th width=100 nowrap>Localitate</th>
<%--            <th width=100 nowrap>Judet</th>--%>
            <th width=120 nowrap>Telefon</th>
            <th>&nbsp;</th>
            <th>&nbsp;</th>
            <th>&nbsp;</th>
            <th>&nbsp;</th>
        </tr>
        <%

            ElevBean ua = new ElevBean();
            ElevDAO eleviDAO = new ElevDAO();

            if(request.getParameter("Del")!= null) {
//                if(request.getParameter("user")!= null)
//                    eleviDAO.deleteUser(request.getParameter("user"));
            }
            if(request.getParameter("Add")!= null) {
                ua.setDatan(DateUtils.getDate(request.getParameter("datan")));
                ua.setNume(request.getParameter("nume"));
                ua.setSex(request.getParameter("sex"));
                ua.setMatr(new Integer(request.getParameter("nrmat")).intValue());
                ua.setAdr(request.getParameter("adr"));
                ua.setCodp(new Integer(request.getParameter("cod")).intValue());
                ua.setLoc(request.getParameter("loc"));
                ua.setJud(request.getParameter("jud"));
                ua.setTel(request.getParameter("tel"));
//                System.out.println("statut "+ request.getParameter("statut"));
                ua.setEmail(request.getParameter("email"));
                ua.setStatut(request.getParameter("statut"));
                ua.setNat(request.getParameter("nat"));

                eleviDAO.insert(ua);
            } else if(request.getParameter("Save")!= null) {
                if(request.getParameter("id")!= null) {
                    Object [] s = new Object[1];
                    s[0] = request.getParameter("id");
                    ua = (ElevBean) eleviDAO.getByPK(s).get(0);
                }
                ua.setDatan(DateUtils.getDate(request.getParameter("datan")));
                ua.setNume(request.getParameter("nume"));
                ua.setSex(request.getParameter("sex"));
                ua.setMatr(new Integer(request.getParameter("nrmat")).intValue());
                ua.setAdr(request.getParameter("adr"));
                ua.setCodp(new Integer(request.getParameter("cod")).intValue());
                ua.setLoc(request.getParameter("loc"));
                ua.setJud(request.getParameter("jud"));
                ua.setTel(request.getParameter("tel"));
//                System.out.println("statut "+ request.getParameter("statut"));
                ua.setEmail(request.getParameter("email"));
                ua.setStatut(request.getParameter("statut"));
                ua.setNat(request.getParameter("nat"));
                eleviDAO.update(ua);
            }

        //    String count = "" + eleviDAO.getCount();
            List elements = eleviDAO.getALL();

            if (elements!=null)
            for (int i = 0; i < elements.size(); i++) {
                ElevBean sb = (ElevBean) elements.get(i);
        %>
        <tr>
            <td cellpading=7><%=sb.getMatr()!=0?sb.getMatr():""%>&nbsp;</td>
            <td  width=140 nowrap><%=sb.getNume()!=null?sb.getNume():""%>&nbsp;</td>
<%--            <td><%=sb.getEmail()!=null?sb.getEmail():""%>&nbsp;</td>--%>
            <td><%=sb.getLoc()!=null?sb.getLoc():""%>&nbsp;</td>
<%--            <td><%=sb.getJud()!=null?sb.getJud():""%>&nbsp;</td>--%>
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
           <input type="button" name="parinti" value="Parinti"
            onClick="document.location='../parinte/list.jsp?id_elev=<%=sb.getId()%>'" >
</td>
    <td width="201">
           <input type="button" name="medii" value="Medii"
            onClick="document.location='../media/list.jsp?id_elev=<%=sb.getId()%>'" >
</td>
    <td width="201">
           <input type="button" name="medii" value="Absente"
            onClick="document.location='../absente/list.jsp?id_elev=<%=sb.getId()%>'" >
</td>
        </tr>
        <%
            }
        %>
        </table>
</td></tr>
</table>

