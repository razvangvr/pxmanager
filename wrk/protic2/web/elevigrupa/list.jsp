<%@ page import="java.util.List,
                 java.util.ArrayList,
                 ro.utils.DateUtils,
                 ro.auto.beans.*"%>
<%@ page import="ro.dirigentie.dao.*" %>
<%
    if(request.getSession().getAttribute("userbean")== null || ((UsersBean) request.getSession().getAttribute("userbean")).getUsername()== null)
        response.sendRedirect(response.encodeRedirectURL("../login/login.jsp"));

    DisciplineprofesoriDAO discprofDAO = new DisciplineprofesoriDAO();
    DisciplinaDAO dDao = new DisciplinaDAO();
    String[] params = new String[1];
    params[0]=request.getParameter("id");
    List l = discprofDAO.getByPK(params);
    DisciplineprofesoriBean dpb = (DisciplineprofesoriBean)l.get(0);

    System.out.println("dpb list size:" + l.size());
%>
<BODY BACKGROUND="../img/background.jpg">
<table class="titlu">
<tr><td valign=top>
        <jsp:include page="../menu.jsp" flush="true"/>
</td><td width=10%>
        &nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;
</td><td>
        <br>
    <h2 align=center>Grupa nr. <%=request.getParameter("id_grupa") %>, profesor <%=((ProfesorBean)new ProfesorDAO().getByPK(dpb.getId_profesor()+"").get(0)).getNume()%> disciplina <%=((DisciplinaBean)dDao.getByPK(dpb.getId_disciplina()+"").get(0)).getDen()%></h2>
        <br>
            <input type="button" name="add" value="Asociaza elevi"
            onClick="document.location='picklist.jsp?id=<%= request.getParameter("id")%>&id_grupa=<%=request.getParameter("id_grupa")%>'" >
            <input type="button" name="back" value="Inapoi"
            onClick="document.location='listgrupestandard.jsp?id=<%= request.getParameter("id")%>'" >
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
            ElevigrupeDAO elevigrupeDAO = new ElevigrupeDAO();

            if(request.getParameter("Save")!= null)
            {
                elevigrupeDAO.deleteAllGrupa(dpb.getId(), Integer.parseInt(request.getParameter("id_grupa")));
            }
            if(request.getParameter("list2")!= null) {
                String[] list = request.getParameterValues("list2");
                ElevigrupeBean eb = new ElevigrupeBean();
                for (int i = 0; i < list.length; i++) {
                    eb = new ElevigrupeBean();
                    eb.setId_elev(new Long(list[i]).longValue());
                    eb.setGrupa(new Long(request.getParameter("id_grupa")).intValue());
                    eb.setId_disciplineprofesori(new Long(request.getParameter("id")).intValue());
                    elevigrupeDAO.insert(eb);
                }
            }
            System.out.println("deleted 12");
            ElevDAO eDao = new ElevDAO();
            int grupa = Integer.parseInt(request.getParameter("id_grupa"));
            List e = elevigrupeDAO.getByIdDscprofAndGrupa(dpb.getId()+"",grupa);
            if (e!=null) {
            for (int i = 0; i < e.size(); i++) {
                ElevBean sb =((ElevBean)eDao.getByPK(((ElevigrupeBean)e.get(i)).getId_elev()+"").get(0));
        %>
        <tr>
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
