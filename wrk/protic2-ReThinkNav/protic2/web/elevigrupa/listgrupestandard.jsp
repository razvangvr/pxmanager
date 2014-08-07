<%@ page import="java.util.List,
                 java.util.ArrayList,
                 ro.dirigentie.dao.DisciplineprofesoriDAO,
                 ro.utils.DateUtils,
                 ro.dirigentie.dao.DisciplinaDAO,
                 ro.dirigentie.dao.ProfesorDAO"%>
<%@ page import="ro.auto.beans.*" %>
<%
    if(request.getSession().getAttribute("userbean")== null || ((UsersBean) request.getSession().getAttribute("userbean")).getUsername()== null)
        response.sendRedirect(response.encodeRedirectURL("../login/login.jsp"));
    DisciplineprofesoriBean ua = new DisciplineprofesoriBean();
    DisciplineprofesoriDAO discprofDAO = new DisciplineprofesoriDAO();
    DisciplinaDAO dDao = new DisciplinaDAO();
    String[] params = new String[1];
    params[0]=request.getParameter("id");
    List l = discprofDAO.getByPK(params);
    DisciplineprofesoriBean dpb = (DisciplineprofesoriBean)l.get(0);
%>
<BODY BACKGROUND="../img/background.jpg">
<table class="titlu">
<tr><td valign=top>
        <jsp:include page="../menu.jsp" flush="true"/>
</td><td width=10%>
        &nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;
</td><td>
        <br>
        <h2 align=center>Grupe <%=((ProfesorBean)new ProfesorDAO().getByPK(dpb.getId_profesor()+"").get(0)).getNume()%> disciplina <%=((DisciplinaBean)dDao.getByPK(dpb.getId_disciplina()+"").get(0)).getDen()%></h2>
        <br>
            <input type="button" name="back" value="Inapoi"
            onClick="document.location='../disciplineprofesori/list.jsp?id_profesor=<%=dpb.getId_profesor()%>'" >
        <br/><br>
        <P>
        <table width="450" border="0" cellpadding="0">
        <tr>
            <th width=80 nowrap>An scolar</th>
            <th width=80 nowrap>Clasa</th>
            <th width=160 nowrap>Disciplina</th>
            <th width=60 nowrap>Grupa</th>
            <th>&nbsp;</th>
            <th>&nbsp;</th>
        </tr>
        <%


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

            List e = discprofDAO.getByProfAn(dpb.getId_profesor() + "", request.getSession().getAttribute("idan")+"");
            if (e!=null)
            {
            for (int i = 1; i <= 6; i++) {
                List res = (List) e.get(0);
                System.out.println("res siiiize"+res.size());
                DisciplineprofesoriBean sb = (DisciplineprofesoriBean) res.get(0);
                ClasaBean cb = (ClasaBean) res.get(1);
            %>
        <tr>
        <tr>
            <td width="182" align="center">
                <%=request.getSession().getAttribute("denan")%>
            </td>
            <td align="center">
                <%=cb.getDen()!=null?cb.getDen():""%>&nbsp;
            </td>
            <td colspan=1 align="center"><%=((DisciplinaBean)dDao.getByPK(sb.getId_disciplina()+"").get(0)).getDen()%>&nbsp;</td>
            <td align=right colspan="2" nowrap="true">Grupa Nr.<%=i%>&nbsp;</td>
            <td align="center">
            </td>
            <td align="center">
            <input type="button" name="Init" value="Elevi"
                onClick="document.location='../elevigrupa/list.jsp?id=<%=sb.getId()%>&id_grupa=<%=i%>'" >
            </td>
            <td align="center">
            <input type="button" name="Init" value="Utilizatori"
                onClick="document.location='../elevigrupa/listuserigrupe.jsp?id=<%=sb.getId()%>&id_grupa=<%=i%>'" >
            </td>
        </tr>
        <%
            }
        }
        %>
        </table>
</td></tr>
</table>

