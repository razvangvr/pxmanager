<%@ page import="java.util.List,
                 java.util.ArrayList,
                 ro.dirigentie.dao.DisciplineprofesoriDAO,
                 ro.utils.DateUtils,
                 ro.dirigentie.dao.DisciplinaDAO"%>
<%@ page import="ro.dirigentie.dao.ProfesorDAO" %>
<%@ page import="ro.auto.beans.*" %>
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
        <h2 align=center>Discipline profesor <%=((ProfesorBean)new ProfesorDAO().getByPK(request.getParameter("id_profesor")).get(0)).getNume()%></h2>
        <br>
            <input type="button" name="add" value="Adauga"
            onClick="document.location='add.jsp?id_profesor=<%=request.getParameter("id_profesor")%>'" >
            <input type="button" name="back" value="Inapoi"
            onClick="document.location='../profesor/list.jsp?id=<%=request.getParameter("id_profesor")%>'" >
        <br/><br>
        <P>
        <table width="450" border="0" cellpadding="0">
        <tr>
            <th width=80 nowrap>An scolar</th>
            <th width=80 nowrap>Clasa</th>
            <th width=160 nowrap>Disciplina</th>
            <th width=60 nowrap>Ore</th>
            <th>&nbsp;</th>
            <th>&nbsp;</th>
        </tr>
        <%

            DisciplineprofesoriBean ua = new DisciplineprofesoriBean();
            DisciplineprofesoriDAO discprofDAO = new DisciplineprofesoriDAO();

            if(request.getParameter("Del")!= null) {
//                if(request.getParameter("user")!= null)
                    discprofDAO.delete(new Long (request.getParameter("id")).longValue() );
            }
            if(request.getParameter("Add")!= null) {
                ua.setId_profesor(new Integer(request.getParameter("id_profesor")).intValue());
                ua.setId_clasa(new Integer(request.getParameter("idclasa")).intValue());
                ua.setId_disciplina(new Integer(request.getParameter("iddisc")).intValue());
                ua.setOre(new Long(request.getParameter("ore")).longValue());
                discprofDAO.insert(ua);
            } else if(request.getParameter("Save")!= null) {
                if(request.getParameter("id")!= null) {
                    Object [] s = new Object[1];
                    s[0] = request.getParameter("id");
                    ua = (DisciplineprofesoriBean) discprofDAO.getByPK(s).get(0);
                }
                ua.setId_profesor(new Integer(request.getParameter("id_profesor")).intValue());
                ua.setId_clasa(new Integer(request.getParameter("idclasa")).intValue());
                ua.setId_disciplina(new Integer(request.getParameter("iddisc")).intValue());
                ua.setOre(new Long(request.getParameter("ore")).longValue());
                discprofDAO.update(ua);
            }

        //    String count = "" + discprofDAO.getCount();
            DisciplinaDAO dDao = new DisciplinaDAO();
            String[] params = new String[1];
            params[0]=request.getParameter("id_profesor");
            List e = discprofDAO.getByProfAn(request.getParameter("id_profesor"), request.getSession().getAttribute("idan")+"");
            System.out.println(request.getParameter("id_profesor"));
            System.out.println(request.getSession().getAttribute("idan")+"");

            if (e!=null) {
                System.out.println("siiiize"+e.size());

            for (int i = 0; i < e.size(); i++) {
                List res = (List) e.get(i);
                DisciplineprofesoriBean sb = (DisciplineprofesoriBean) res.get(0);
                ClasaBean cb = (ClasaBean) res.get(1);
        %>
        <tr>

        <tr>
            <td width="182" align="center">
                <%=request.getSession().getAttribute("denan")%>
            </td>
            <td>
                <%=cb.getDen()!=null?cb.getDen():""%>&nbsp;
            </td>
            <td colspan=1><%=((DisciplinaBean)dDao.getByPK(sb.getId_disciplina()+"").get(0)).getDen()%>&nbsp;</td>
            <td align=right><%=sb.getOre()%>&nbsp;</td>
<%--            <td><%=sb.getEmail()!=null?sb.getEmail():""%>&nbsp;</td>--%>
<%--            <td><%=sb.getLoc()!=null?sb.getLoc():""%>&nbsp;</td>--%>
<%--            <td><%=sb.getJud()!=null?sb.getJud():""%>&nbsp;</td>--%>
<%--            <td><%=sb.getTel()!=null?sb.getTel():""%>&nbsp;</td>--%>

            <td align="center">
            <input type="button" name="Init" value="Modifica"
                onClick="document.location='edit.jsp?id=<%=sb.getId()%>&id_profesor=<%=request.getParameter("id_profesor")%>'" >
            </td>
            <td align="center">
            <input type="button" name="Init" value="Grupe"
                onClick="document.location='../elevigrupa/listgrupestandard.jsp?id=<%=sb.getId()%>'" >
            </td>
            <!--td align="center">
            <input type="button" name="Init" value="Sterge"
                onClick="document.location='del.jsp?id=<%=sb.getId()%>&id_profesor=<%=request.getParameter("id_profesor")%>'" >
            </td-->
        </tr>
        <%
            }
        }
        %>
        </table>
</td></tr>
</table>

