<%@ page import="java.util.List,
                 java.util.ArrayList,
                 ro.dirigentie.dao.EleviclaseDAO,
                 ro.utils.DateUtils,
                 ro.dirigentie.dao.DisciplinaDAO,
                 ro.dirigentie.dao.ElevDAO,
                 ro.auto.beans.*"%>
<%@ page import="ro.dirigentie.dao.ClasaDAO" %>
<%
    if(request.getSession().getAttribute("userbean")== null || ((UsersBean) request.getSession().getAttribute("userbean")).getUsername()== null)
        response.sendRedirect(response.encodeRedirectURL("../login/login.jsp"));

    ClasaDAO clasaDAO = new ClasaDAO();
    List clase = clasaDAO.getByPK(new Object[] {request.getParameter("id_clasa")});

%>
<BODY BACKGROUND="../img/background.jpg">
<table class="titlu">
<tr><td valign=top>
        <jsp:include page="../menu.jsp" flush="true"/>
</td><td width=10%>
        &nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;
</td><td>
        <br>
        <h2 align=center>Elevii clasei <%= ((ClasaBean)clase.get(0)).getDen() %></h2>
        <br>
            <input type="button" name="add" value="Asociaza elevi"
            onClick="document.location='picklist.jsp?id_clasa=<%=request.getParameter("id_clasa")%>'" >
            <input type="button" name="back" value="Inapoi"
            onClick="document.location='../clasa/list.jsp'" >
        <br/><br>
        <P>
        <table width="450" border="0" cellpadding="0">
        <tr>
            <th width=70 nowrap>Nr. matr.</th>
            <th width=140 nowrap>Nume I. prenume</th>
            <th width=140 nowrap>Email</th>
            <th width=100 nowrap>Localitate</th>
            <th width=100 nowrap>Judet</th>
            <th width=120 nowrap>Telefon</th>
        </tr>
        <%

            EleviclasaBean ua = new EleviclasaBean();
            EleviclaseDAO eleviclaseDAO = new EleviclaseDAO();

            if(request.getParameter("Save")!= null)
                eleviclaseDAO.deleteAllClasa(request.getParameter("id_clasa"));
            if(request.getParameter("list2")!= null) {
                String[] list = request.getParameterValues("list2");
                EleviclasaBean eb = new EleviclasaBean();
                for (int i = 0; i < list.length; i++) {
//                    eb.setId(-1);
                    eb = new EleviclasaBean();
                    eb.setId_elev(new Long(list[i]).longValue());
                    eb.setId_clasa(new Long(request.getParameter("id_clasa")).longValue());
                    eleviclaseDAO.insert(eb);
                }
            }


            ElevDAO eDao = new ElevDAO();
            List e = eleviclaseDAO.getByClasa(request.getParameter("id_clasa"));
            if (e!=null) {
            for (int i = 0; i < e.size(); i++) {
                ElevBean sb =((ElevBean)eDao.getByPK(((EleviclasaBean)e.get(i)).getId_elev()+"").get(0));
        %>
        <tr>
<%--            <td width="182" align="center">--%>
<%--                <%=request.getSession().getAttribute("denan")%>--%>
<%--            </td>--%>
            <td cellpading=7><%=sb.getMatr()!=0?sb.getMatr():""%>&nbsp;</td>
            <td  width=140 nowrap><%=sb.getNume()!=null?sb.getNume():""%>&nbsp;</td>
            <td><%=sb.getEmail()!=null?sb.getEmail():""%>&nbsp;</td>
            <td><%=sb.getLoc()!=null?sb.getLoc():""%>&nbsp;</td>
            <td><%=sb.getJud()!=null?sb.getJud():""%>&nbsp;</td>
            <td><%=sb.getTel()!=null?sb.getTel():""%>&nbsp;</td>

        </tr>
        <%
            }
        }
        %>
        </table>
</td></tr>
</table>

