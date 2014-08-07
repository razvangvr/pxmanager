<%@ page import="java.util.List,
                 java.util.ArrayList,
                 ro.auto.beans.UsersBean,
                 ro.auto.beans.DiriginteBean,
                 ro.dirigentie.dao.DiriginteDAO,
                 ro.dirigentie.dao.ClasaDAO,
                 ro.dirigentie.dao.ProfesorDAO,
                 ro.auto.beans.ClasaBean,
                 ro.auto.beans.ProfesorBean"%>
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

        <h2 align=center>Administrare Diriginti</h2>
        <br>
            <input type="button" name="add" value="Adauga"
            onClick="document.location='add.jsp'" >
        <br/><br>
        <P>

        <table width="350" border="0" cellpadding="0">
        <tr>
            <th  width="80" nowrap cellpadding="3" >An Scolar</th>
            <th  width="80" nowrap  cellpadding="3" >Clasa</th>
            <th   width="180" nowrap cellpadding="3" >Diriginte</th>
        </tr>
        <%

            DiriginteBean ua = new DiriginteBean();
            DiriginteDAO DiriginteDAO = new DiriginteDAO();

//            ro.sam.dao.DiriginteDAO uDAO = new ro.sam.dao.DiriginteDAO();

            if(request.getParameter("Del")!= null) {
                if(request.getParameter("id")!= null) {
                    Object [] s = new Object[1];
                    s[0] = request.getParameter("id");
                    ua = (DiriginteBean) DiriginteDAO.getByPK(s).get(0);
                }
                DiriginteDAO.delete(ua.getId());            }
            if(request.getParameter("Add")!= null) {
                ua.setObs(request.getParameter("obs"));
//                ua.setId_an(new Long(request.getSession().getAttribute("idan")+"").longValue());
                ua.setId_profesor(new Integer(request.getParameter("idprof")).intValue());
                ua.setId_clasa(new Integer(request.getParameter("idclasa")).intValue());
                ua.setUsername(request.getParameter("iduser"));
                DiriginteDAO.insert(ua);
            } else if(request.getParameter("Save")!= null) {
                if(request.getParameter("id")!= null) {
                    Object [] s = new Object[1];
                    s[0] = request.getParameter("id");
                    ua = (DiriginteBean) DiriginteDAO.getByPK(s).get(0);
                }
                ua.setObs(request.getParameter("obs"));
//                ua.setId_an(new Long(request.getSession().getAttribute("idan")+"").longValue());
                ua.setId_profesor(new Integer(request.getParameter("idprof")).intValue());
                ua.setId_clasa(new Integer(request.getParameter("idclasa")).intValue());
                ua.setUsername(request.getParameter("iduser"));
                DiriginteDAO.update(ua);
            }

        //    String count = "" + DiriginteDAO.getCount();
            List elements = DiriginteDAO.getByAn(request.getSession().getAttribute("idan")+"");

            ClasaDAO cdao = new ClasaDAO();
            ProfesorDAO pdao = new ProfesorDAO();
            if (elements!=null)
            for (int i = 0; i < elements.size(); i++) {

                                List res = (List) elements.get(i);
                DiriginteBean sb = (DiriginteBean) res.get(0);
        %>
        <tr>
            <td width="182" align="center">
                <%=request.getSession().getAttribute("denan")%>
            </td>
            <td colspan=1><%=((ClasaBean)cdao.getByPK(sb.getId_clasa()+"").get(0)).getDen()%>&nbsp;</td>
            <td colspan=1><%=((ProfesorBean)pdao.getByPK(sb.getId_profesor()+"").get(0)).getNume()%>&nbsp;</td>
            <td><input type="button" name="Init" value="Modifica"
                onClick="document.location='edit.jsp?id=<%=sb.getId()%>'" >
            </td>
            <td align="center">
            <input type="button" name="Init" value="Sterge"
                onClick="document.location='del.jsp?id=<%=sb.getId()%>'" >
            </td>
        </tr>
        <%
            }
        %>
        </table>
</td></tr>
</table>

