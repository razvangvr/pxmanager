<%@ page import="java.util.List,
                 java.util.ArrayList,
                 ro.dirigentie.dao.MediaDAO,
                 ro.auto.beans.MediaBean,
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
        <h2 align=center>Medii</h2>
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
            <th width=160 nowrap>Disciplina</th>
            <th width=60 nowrap>Media</th>
            <th>&nbsp;</th>
            <th>&nbsp;</th>
        </tr>
        <%

            MediaBean ua = new MediaBean();
            MediaDAO mediaDAO = new MediaDAO();

            if(request.getParameter("Del")!= null) {
                mediaDAO.delete(new Integer(request.getParameter("id")).intValue());
            }
            if(request.getParameter("Add")!= null) {
                ua.setId_elev(new Integer(request.getParameter("id_elev")).intValue());
                ua.setId_disc(new Integer(request.getParameter("iddisc")).intValue());
                ua.setMedia(new BigDecimal(request.getParameter("med")));
                ua.setSemestru(request.getParameter("sem"));
                ua.setId_an(new Long(request.getSession().getAttribute("idan")+"").longValue());
                mediaDAO.insert(ua);
            } else if(request.getParameter("Save")!= null) {
                if(request.getParameter("id")!= null) {
                    Object [] s = new Object[1];
                    s[0] = request.getParameter("id");
                    ua = (MediaBean) mediaDAO.getByPK(s).get(0);
                }
                ua.setId_elev(new Integer(request.getParameter("id_elev")).intValue());
                ua.setId_disc(new Integer(request.getParameter("iddisc")).intValue());
                ua.setMedia(new BigDecimal(request.getParameter("med")));
                ua.setSemestru(request.getParameter("sem"));
                ua.setId_an(new Long(request.getSession().getAttribute("idan")+"").longValue());
                mediaDAO.update(ua);
            }

        //    String count = "" + mediaDAO.getCount();
            String[] params = new String[1];
            params[0]=request.getParameter("id_elev");
            List elements = mediaDAO.getByElevAn(request.getParameter("id_elev"),request.getSession().getAttribute("idan")+"");

            if (elements!=null)
            for (int i = 0; i < elements.size(); i++) {
                MediaBean sb = (MediaBean) elements.get(i);
        %>
        <tr>
            <td width="182" align="center">
                <%=request.getSession().getAttribute("denan")%>
            </td>
            <td align=center>
                <%=sb.getSemestru()!=null?sb.getSemestru():""%>&nbsp;
            </td>
            <td colspan=1><%=((DisciplinaBean)new DisciplinaDAO().getByPK(sb.getId_disc()+"").get(0)).getDen()%>&nbsp;</td>
            <td align=right><%=sb.getMedia()%>&nbsp;</td>
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

