<%@ page import="java.util.List,
                 java.util.ArrayList,
                 ro.utils.DateUtils"%>
<%@ page import="ro.auto.beans.*" %>
<%@ page import="ro.dirigentie.dao.*" %>
<%
    if(request.getSession().getAttribute("userbean")== null || ((UsersBean) request.getSession().getAttribute("userbean")).getUsername()== null)
    {
        response.sendRedirect(response.encodeRedirectURL("../login/login.jsp"));
        return;
    }
%>
<BODY BACKGROUND="../img/background.jpg">
<table class="titlu">

<%  UsersBean ub = ((UsersBean) request.getSession().getAttribute("userbean"));
    List e = null;
    PaginiDAO pgDAO = new PaginiDAO();
    String id_grupa = request.getParameter("id_grupa");
    String id_disciplineprofesori = request.getParameter("id_disciplineprofesori");
    DisciplineprofesoriDAO discprofDAO = new DisciplineprofesoriDAO();
    DisciplineprofesoriBean dpBean = null;
    UsersgrupeBean ugb = null;

    e = pgDAO.getALL();


    String text = "";

%>

<tr><td valign=top>
        <jsp:include page="../menupagina.jsp" flush="true"/>
</td><td width=10%>
        &nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;
        <br>
</td><td>
        <br>
            </td>
            <td colspan=1>
        <br><br>
        <br>
            <%=text%>

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

                    DisciplineprofesoriBean ua = new DisciplineprofesoriBean();
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

                    if (e!=null) {
                        System.out.println("siiiize"+e.size());

                    for (int i = 0; i < e.size(); i++) {
                        PaginiBean pBean = (PaginiBean) e.get(i);
                        dpBean = (DisciplineprofesoriBean )discprofDAO.getByPK(new String[] {pBean.getId_disciplineprofesori() + ""}).get(0);                %>
                <tr>

                <tr>
                    <td width="182" align="center">
                        <%=request.getSession().getAttribute("denan")%>
                    </td>
                    <td  align="center"><%=((ClasaBean)new ClasaDAO().getByPK(dpBean.getId_clasa()+"").get(0)).getDen()%>&nbsp;</td>
                    <td colspan=1 align="center"><%= ((DisciplinaBean)dDao.getByPK(dpBean.getId_disciplina()+"").get(0)).getDen()%>&nbsp;</td>
                    <td width="182" align="center"><%=pBean.getGrupa()%></td>
                    <td align="center">
                        <input type="button" name="Init" value="Vizualizeaza"
                            onClick="document.location='list.jsp?id_grupa=<%=pBean.getGrupa()%>&id_disciplineprofesori=<%=pBean.getId_disciplineprofesori()%>'" >
                    </td>
                </tr>
                <%
                    }
                }
                %>
                </table>
</td></tr>
</table>

