<%@ page import="java.util.List,
                 java.util.ArrayList,
                 ro.dirigentie.dao.AbsenteDAO,
                 ro.auto.beans.AbsenteBean,
                 ro.auto.beans.UsersBean,
                 ro.utils.DateUtils,
                 java.math.BigDecimal,
                 ro.auto.beans.DisciplinaBean,
                 ro.dirigentie.dao.DisciplinaDAO"%>
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
        <h2 align=center>Numar Absente</h2>
        <br>
            <input type="button" name="add" value="Adauga"
            onClick="document.location='add.jsp?id_elev=<%=request.getParameter("id_elev")%>'" >
            <input type="button" name="back" value="Inapoi"
            onClick="document.location='../elev/list.jsp?id=<%=request.getParameter("id_elev")%>'" >
        <br/><br>
        <P>
        <table width="450" border="0" cellpadding="0">
        <tr>
            <th width=80 nowrap>An scolar</th>
            <th width=80 nowrap>Semestru</th>
            <th width=160 nowrap>Motivat</th>
            <th width=60 nowrap>Nemotivat</th>
            <th>&nbsp;</th>
            <th>&nbsp;</th>
        </tr>
        <%
             AbsenteBean ua = new AbsenteBean();
            AbsenteDAO absDAO = new AbsenteDAO();
        try {


            if(request.getParameter("Del")!= null) {
//                if(request.getParameter("user")!= null)
                    absDAO.delete(new Integer(request.getParameter("id")).intValue());
            }
            if(request.getParameter("Add")!= null) {
                ua.setId_elev(new Integer(request.getParameter("id_elev")).intValue());
                ua.setMotivat(new Integer(request.getParameter("mot")).intValue());
                ua.setNemotivat(new Integer(request.getParameter("nemot")).intValue());
                ua.setSemestru(request.getParameter("sem"));
                ua.setId_an(new Long(request.getSession().getAttribute("idan")+"").longValue());
                absDAO.insert(ua);
            } else if(request.getParameter("Save")!= null) {
                if(request.getParameter("id")!= null) {
                    Object [] s = new Object[1];
                    s[0] = request.getParameter("id");
                    ua = (AbsenteBean) absDAO.getByPK(s).get(0);
                }
                ua.setId_elev(new Integer(request.getParameter("id_elev")).intValue());
                ua.setMotivat(new Integer(request.getParameter("mot")).intValue());
                ua.setNemotivat(new Integer(request.getParameter("nemot")).intValue());
                ua.setSemestru(request.getParameter("sem"));
                ua.setId_an(new Long(request.getSession().getAttribute("idan")+"").longValue());
                absDAO.update(ua);
            }
        } catch (Exception e) {
            e.printStackTrace();
            //    String count = "" + absDAO.getCount();
        }
            String[] params = new String[1];
            params[0]=request.getParameter("id_elev");
            List elements = absDAO.getByElevAn(request.getParameter("id_elev"),request.getSession().getAttribute("idan")+"");

            if (elements!=null)
            for (int i = 0; i < elements.size(); i++) {
                AbsenteBean sb = (AbsenteBean) elements.get(i);
        %>
        <tr>
            <td width="182" align="center">
                <%=request.getSession().getAttribute("denan")%>
            </td>
            <td align=center>
                <%=sb.getSemestru()!=null?sb.getSemestru():""%>&nbsp;
            </td>
            <td colspan=1><%=sb.getMotivat()%>&nbsp;</td>
            <td align=right><%=sb.getNemotivat()%>&nbsp;</td>
            <td align="center">
            <input type="button" name="Init" value="Modifica"
                onClick="document.location='edit.jsp?id=<%=sb.getId()%>&id_elev=<%=request.getParameter("id_elev")%>'" >
            </td>
            <td align="center">
            <input type="button" name="Init" value="Sterge"
                onClick="document.location='del.jsp?id=<%=sb.getId()%>&id_elev=<%=request.getParameter("id_elev")%>'" >
            </td>
        </tr>
        <%
            }
        %>
        </table>
</td></tr>
</table>

