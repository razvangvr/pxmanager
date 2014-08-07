<%@ page import="java.util.List,
                 java.util.ArrayList,
                 ro.auto.beans.UseradminsBean,
                 ro.sam.dao.UseradminsDAO,
                 ro.auto.beans.BusBean,
                 ro.sam.dao.BusDAO"%>
<%
    if(request.getSession().getAttribute("userbean")== null || ((UseradminsBean) request.getSession().getAttribute("userbean")).getUsername()== null)
        response.sendRedirect(response.encodeRedirectURL("../login/login.jsp"));
%>

<table class="titlu">
<tr><td valign=top>
        <jsp:include page="../menu.jsp" flush="true"/>
</td><td valign=top>
        &nbsp;&nbsp;&nbsp;&nbsp;
</td><td>
        <br>
        <h2 align=center>Administrare Busuri</h2>
        <br>
            <input type="button" name="Add" value="Adauga"
            onClick="document.location='add.jsp'" >
        <br><br>
        <%--<%@taglib uri="/WEB-INF/tlds/c.tld" prefix="c" %>--%>
        <%--<c:out value="${listElementsCount}"/>--%>
        <table border=1 cellpadding="3" cellspacing="0" width="90%">
        <tr>
            <th>Denumire</th>
            <th>Bucati</th>
            <th>Tara Import</th>
            <th>Text 1</th>
            <th>Text 2</th>
            <th>Text 3</th>
            <th>&nbsp;</th>
            <th>&nbsp;</th>
            <th>&nbsp;</th>
        </tr>
        <%

            BusBean ua = new BusBean();
//            BusDAO userDAO = new UseradminsDAO();

            BusDAO uDAO = new ro.sam.dao.BusDAO();

            if(request.getParameter("Del")!= null) {
                if(request.getParameter("Id")!= null)
                    uDAO.delete(Integer.parseInt(request.getParameter("Id")));

            } if(request.getParameter("Add")!= null) {
                ua.setAn_fab(request.getParameter("An_fab"));
                ua.setBuc(request.getParameter("Buc"));
                ua.setCategorie(request.getParameter("Categorie"));
                ua.setDenumire(request.getParameter("Denumire"));
                ua.setInaltime(request.getParameter("Inaltime"));
                ua.setLatime(request.getParameter("Latime"));
                ua.setLungime(request.getParameter("Lungime"));
                ua.setNr_locuri(request.getParameter("Nr_locuri"));
                ua.setTaraimport(request.getParameter("Taraimport"));
                ua.setText1(request.getParameter("Text1"));
                ua.setText2(request.getParameter("Text2"));
                ua.setText3(request.getParameter("Text3"));
                ua.setText4(request.getParameter("Text4"));
                uDAO.insert(ua);

            } else if(request.getParameter("Save")!= null) {
                if(request.getParameter("Id")!= null) {
                    Object [] s = new Object[1];
                    s[0] = request.getParameter("Id");
                    ua = (BusBean) uDAO.getByPK(s).get(0);
                }

                ua.setAn_fab(request.getParameter("An_fab"));
                ua.setBuc(request.getParameter("Buc"));
                ua.setCategorie(request.getParameter("Categorie"));
                ua.setDenumire(request.getParameter("Denumire"));
                ua.setInaltime(request.getParameter("Inaltime"));
                ua.setLatime(request.getParameter("Latime"));
                ua.setLungime(request.getParameter("Lungime"));
                ua.setNr_locuri(request.getParameter("Nr_locuri"));
                ua.setTaraimport(request.getParameter("Taraimport"));
                ua.setText1(request.getParameter("Text1"));
                ua.setText2(request.getParameter("Text2"));
                ua.setText3(request.getParameter("Text3"));
                ua.setText4(request.getParameter("Text4"));
                uDAO.update(ua);

            }

        //    String count = "" + userDAO.getCount();
            List elements = uDAO.getALL();

            if (elements!=null)
            for (int i = 0; i < elements.size(); i++) {
                BusBean sb = (BusBean) elements.get(i);
        %>
        <tr>
            <td width=100 nowrap><%=sb.getDenumire()!=null?sb.getDenumire():""%>&nbsp;</td>
            <td><%=sb.getBuc()!=null?sb.getBuc():""%>&nbsp;</td>
            <td width=110 nowrap><%=sb.getTaraimport()!=null?sb.getTaraimport():""%>&nbsp;</td>
            <td width=130 nowrap><%=sb.getText1()!=null?sb.getText1():""%>&nbsp;</td>
            <td width=130 nowrap><%=sb.getText2()!=null?sb.getText2():""%>&nbsp;</td>
            <td width=130 nowrap><%=sb.getText3()!=null?sb.getText3():""%>&nbsp;</td>

            <td align="center">
            <input type="button" name="Init" value="Modifica"
                onClick="document.location='edit.jsp?id=<%=sb.getId()%>'" >
            </td>
            <td align="center">
            <input type="button" name="Init" value="Sterge"
                onClick="document.location='del.jsp?id=<%=sb.getId()%>'" >
            </td>
            <td align="center">
            <input type="button" name="Upload" value="Imagini"
                onClick="document.location='upload1.jsp?id=<%=sb.getId()%>'" >
            </td>
        </tr>
        <%
            }
        %>
        </table>
</td></tr>
</table>

