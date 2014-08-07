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
<BODY BACKGROUND="../img/background.jpg" STYLE="background-repeat: no-repeat;">
<table class="titlu">

<%  UsersBean ub = ((UsersBean) request.getSession().getAttribute("userbean"));
    List elements = null;
    PaginiDAO pgDAO = new PaginiDAO();
    String id_grupa = request.getParameter("id_grupa");
    String id_disciplineprofesori = request.getParameter("id_disciplineprofesori");
    DisciplineprofesoriDAO discprofDAO = new DisciplineprofesoriDAO();
    DisciplineprofesoriBean dpBean = null;
    UsersgrupeBean ugb = null;
    if(id_grupa == null && id_disciplineprofesori == null)
    {
        if(ub.getUsertype().equals("PROFESOR") || ub.getUsertype().equals("ADMIN"))
        {
            response.sendRedirect(response.encodeRedirectURL("pageslist.jsp"));
            return;
        }


        UserigrupeDAO userigrupeDAO = new UserigrupeDAO();
        List l = userigrupeDAO.getByUsername(ub.getUsername());


        if(l==null || l.size() == 0)
            throw new Exception("Utilizator neasignat " + ub.getUsername());
        ugb = (UsersgrupeBean)l.get(0);

        elements = pgDAO.getByGrupa( ugb.getGrupa() + "", ugb.getId_disciplineprofesori()+"");
        dpBean = (DisciplineprofesoriBean )discprofDAO.getByPK(new String[] {ugb.getId_disciplineprofesori()+""}).get(0);
    }
    else
    {
        elements = pgDAO.getByGrupa( id_grupa, id_disciplineprofesori);
        dpBean = (DisciplineprofesoriBean )discprofDAO.getByPK(new String[] {id_disciplineprofesori}).get(0);
    }

    String text = "";
    if(request.getParameter("elm1") != null )
        text = request.getParameter("elm1");
    else if (elements!=null && elements.size() > 0)
    {
        text = ((PaginiBean) elements.get(0)).getContinut();
    }



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
        <h2 align=center>Pagina clasa <%= ((ClasaBean)new ClasaDAO().getByPK(dpBean.getId_clasa()+"").get(0)).getDen()%> anul <%=request.getSession().getAttribute("denan")%> disciplina <%= ((DisciplinaBean)new DisciplinaDAO().getByPK(dpBean.getId_disciplina()+"").get(0)).getDen()%> grupa nr. <%=(id_grupa != null) ? Integer.parseInt(id_grupa) : ugb.getGrupa()%></h2>
        <br>
            <%=text%>
            <%    if(ub.getUsertype().equals("ELEV")) {%>
                <input type="button" name="Init" value="Editare" onClick="document.location='edit.jsp'" >
            <%}%>
        <table width="450" border="0" cellpadding="0">
        <%
            if(request.getParameter("Del")!= null) {
            // if(request.getParameter("user")!= null)
            // eleviDAO.deleteUser(request.getParameter("user"));
            }
            if(request.getParameter("Save")!= null) {
                PaginiBean sb = new PaginiBean();
                sb.setContinut(text);
                sb.setGrupa((id_grupa != null) ? Integer.parseInt(id_grupa) : ugb.getGrupa());
                sb.setId_disciplineprofesori(id_disciplineprofesori != null ? Integer.parseInt(id_disciplineprofesori) : ugb.getId_disciplineprofesori());
                if (elements!=null && elements.size() > 0)
                {
                    sb.setId(((PaginiBean) elements.get(0)).getId());
                    pgDAO.update(sb);
                }
                    pgDAO.insert(sb);
            }
        %>

        </table>
</td></tr>
</table>

