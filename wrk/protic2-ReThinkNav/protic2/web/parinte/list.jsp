<%@ page import="java.util.List,
                 java.util.ArrayList,
                 ro.dirigentie.dao.ParinteDAO,
                 ro.auto.beans.ParinteBean,
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
        <h2 align=center>Parinti</h2>
        <br>
            <input type="button" name="add" value="Adauga"
            onClick="document.location='add.jsp?id_elev=<%=request.getParameter("id_elev")%>'" >
            <input type="button" name="back" value="Inapoi"
            onClick="document.location='../elev/list.jsp?id=<%=request.getParameter("id_elev")%>'" >
        <br/><br>
        <P>
        <table width="450" border="0" cellpadding="0">
        <tr>

            <th nowrap>Nume si prenume</th>
            <th width=100 nowrap>Localitate</th>
            <th width=120 nowrap>Adresa</th>
            <th width=70 nowrap>Judet</th>
            <th width=50 nowrap>Cod</th>
            <th width=70 nowrap>Telefon</th>
            <th width=140 nowrap>Email</th>
            <th>&nbsp;</th>
            <th>&nbsp;</th>
        </tr>
        <%

            ParinteBean ua = new ParinteBean();
            ParinteDAO userDAO = new ParinteDAO();

            if(request.getParameter("Del")!= null) {
//                if(request.getParameter("user")!= null)
                    userDAO.delete(request.getParameter("id"));
            }
            if(request.getParameter("Add")!= null) {
                ua.setId_elev(new Integer(request.getParameter("id_elev")).intValue());

                ua.setNume(request.getParameter("locmnc"));
                ua.setProfesie(request.getParameter("prof"));
                ua.setLoc_munca(request.getParameter("sex"));
                ua.setAdr(request.getParameter("adr"));
                ua.setCodp(new Integer(request.getParameter("cod")).intValue());
                ua.setIntara(request.getParameter("intr"));
                ua.setLoc(request.getParameter("loc"));
                ua.setJud(request.getParameter("jud"));
                ua.setTel(request.getParameter("tel"));
//                System.out.println("statut "+ request.getParameter("statut"));
                ua.setEmail(request.getParameter("email"));
                ua.setStatut(request.getParameter("statut"));
                ua.setObs(request.getParameter("obs"));

                userDAO.insert(ua);
            } else if(request.getParameter("Save")!= null) {
                if(request.getParameter("id")!= null) {
                    Object [] s = new Object[1];
                    s[0] = request.getParameter("id");
                    ua = (ParinteBean) userDAO.getByPK(s).get(0);
                }
                ua.setId_elev(new Integer(request.getParameter("id_elev")).intValue());
                ua.setNume(request.getParameter("nume"));
                ua.setProfesie(request.getParameter("prof"));
                ua.setLoc_munca(request.getParameter("locmnc"));
                ua.setAdr(request.getParameter("adr"));
                ua.setCodp(new Integer(request.getParameter("cod")).intValue());
                ua.setIntara(request.getParameter("intr"));
                ua.setLoc(request.getParameter("loc"));
                ua.setJud(request.getParameter("jud"));
                ua.setTel(request.getParameter("tel"));
//                System.out.println("statut "+ request.getParameter("statut"));
                ua.setEmail(request.getParameter("email"));
                ua.setStatut(request.getParameter("statut"));
                ua.setObs(request.getParameter("obs"));
                userDAO.update(ua);
            }

        //    String count = "" + userDAO.getCount();
            String[] params = new String[1];
            params[0]=request.getParameter("id_elev");
            List elements = userDAO.getByElevId(params);

            if (elements!=null)
            for (int i = 0; i < elements.size(); i++) {
                ParinteBean sb = (ParinteBean) elements.get(i);
        %>
        <tr>
            <td><%=sb.getNume()!=null?sb.getNume():""%>&nbsp;</td>
            <td><%=sb.getLoc()!=null?sb.getLoc():""%>&nbsp;</td>
            <td><%=sb.getAdr()!=null?sb.getAdr():""%>&nbsp;</td>
            <td><%=sb.getJud()!=null?sb.getJud():""%>&nbsp;</td>
            <td><%=sb.getCodp()!=0?sb.getCodp():""%>&nbsp;</td>
            <td><%=sb.getTel()!=null?sb.getTel():""%>&nbsp;</td>
            <td><%=sb.getEmail()!=null?sb.getEmail():""%>&nbsp;</td>
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

