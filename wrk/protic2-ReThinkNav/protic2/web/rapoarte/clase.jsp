<%@ page import="java.util.ArrayList,
                 java.util.List,
                 ro.auto.beans.*,

                 ro.dirigentie.dao.*,
                 ro.servlets.init.InitServlet,
                 java.io.FileOutputStream,
                 java.io.File,
                 java.util.Date,
                 java.math.BigDecimal"%>


<%     if(request.getSession().getAttribute("userbean")== null || ((UsersBean) request.getSession().getAttribute("userbean")).getUsername()== null)
        response.sendRedirect(response.encodeRedirectURL("../login/login.jsp"));

//    ClasaDAO cDao = new ClasaDAO();
//    cDao.getByAn(request.getSession().getAttribute("idan")+"");

    DisciplinaDAO disDAO = new DisciplinaDAO();
    long idpurtare = disDAO.getIdPurtare();
//    List elements = userDAO.getByPK(new Object[] {request.getParameter("id")});
//    ua = (DiriginteBean) elements.get(0);

    if(request.getParameter("Save")!= null) {
    int[] mediigenerale = new int[7];
    int[] mediipurtare = new int[7];
    int absm = 0;
    int absnem = 0;

    RapoarteDAO rd = new RapoarteDAO();
    ElevDAO eDao = new ElevDAO();
    EleviclaseDAO eleviclaseDAO = new EleviclaseDAO();
    List e = eleviclaseDAO.getByClasa(request.getParameter("id_clasa"));
        if (e!=null)
        for (int i = 0; i < e.size(); i++) {
            ElevBean elev =((ElevBean)eDao.getByPK(((EleviclasaBean)e.get(i)).getId_elev()+"").get(0));
            List mediielev = rd.getMedii(elev.getId()+"", request.getParameter("sem"), request.getSession().getAttribute("idan")+"");
                float m = 0;
                for (int k = 0; k < mediielev.size(); k++) {
                    m+=(((MediaBean)mediielev.get(k)).getMedia()).floatValue();
                    if(new Long(((MediaBean)mediielev.get(k)).getId_disc()).toString().equals(new Long(idpurtare).toString())) {
                            if((((MediaBean)mediielev.get(k)).getMedia()).floatValue()< 5)
                                mediipurtare[0]++;
                            else
                                mediipurtare[((int)(((MediaBean)mediielev.get(k)).getMedia()).floatValue())-4]++;
                    }
                }
                System.out.println("med generala "+m/mediielev.size());
            if(mediielev.size() > 0)
                if(m/mediielev.size()< 5)
                    mediigenerale[0]++;
                else
                    mediigenerale[((int)m/mediielev.size())-4]++;

            List abselev = rd.getAbsente(elev.getId()+"", request.getParameter("sem"), request.getSession().getAttribute("idan")+"");
            for (int k = 0; k < abselev.size(); k++) {
                AbsenteBean ab = (AbsenteBean)abselev.get(k);
                absm+= ab.getMotivat();
                absnem+= ab.getNemotivat();
            }

        }


        List es = new ClasaDAO().getByPK(request.getParameter("id_clasa"));
        ;


        String res = "\r\n\t\t Situatie clasa " + ((ClasaBean) es.get(0)).getDen() +" in anul scolar "+ request.getSession().getAttribute("denan") +" semestrul " + (request.getParameter("sem").equalsIgnoreCase("s1")?"I":"II") +

                "\r\n\r\n\t\t  < 5\t [ 5, 6) \t [ 6, 7 ) \t [ 7, 8 )\t [ 8, 9 )\t [ 9, 10 )\t 10";
        res +="\r\nMedii \t\t";


        for (int i = 0; i < mediigenerale.length; i++)
            res += mediigenerale[i] +"\t";

        res += "\r\n\r\n\t\t  < 5\t 5 \t 6 \t 7\t 8\t 9\t 10";

        res +="\r\nMedii purtare\t\t";
        for (int i = 0; i < mediipurtare.length; i++)
            res += mediipurtare[i] +"\t";

        res +="\r\n\r\nAbsente motivate\t\t" + absm;
        res +="\r\nAbsente nemotivate\t\t" + absnem;
        ;

        long time = new Date().getTime();
        String f = InitServlet.tempreportsdir+ File.separator + time +".xls";
        FileOutputStream fo = new FileOutputStream(f);
        fo.write(res.getBytes());
        fo.close();
        response.sendRedirect(response.encodeRedirectURL("../"+InitServlet.tempreportsdir.substring(InitServlet.tempreportsdir.lastIndexOf("/")) + "/"+time +".xls"));
        return;
    }

%>
<BODY BACKGROUND="../img/background.jpg">
<table class="titlu">
    <tr><td valign=top>
        <jsp:include page="../menusit.jsp" flush="true"/>
    </td>
    <td width=10%>
        &nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;<BR>
    </td>
    <td><br>


<h2 align=center>Situatie Clasa</h2>
<form name="form1" method="post"
onSubmit="MM_validateForm('prDesignCode', 'Design Code', 'R', 'prCurrencyCode', 'Currency Code', 'R', 'prType', 'Instrument Type', 'R', 'prDescription', 'Description', 'R', 'prPDCode', 'POSA/Distributor', 'R', 'prCPCode', 'Content Provider', 'R', 'prCode', 'Code', 'R', 'prAmount','Amount','int','prQuantity','Quantity','int');return document.MM_returnValue">

<table width="400" border="0" cellpadding="0">
  <tr>
    <td colspan="2" align="left" >
        <P/><input type="submit" name="Save" value="Genereaza">
<%--        <input type="button" name="cancel" value="Inapoi" onClick="document.location='list.jsp'">--%>
    </td>
  </tr>
  <tr>
    <td colspan="2" align="left" >
    &nbsp;</td>
  </tr>


  <tr>
    <td width="201">An scolar curent : </td>
    <td width="282">
    <%=request.getSession().getAttribute("denan")%>
    </td>
  </tr>

    <tr>
        <td width="201" valign=top>Clasa : </td>
        <td cellspan=3 cellpadding="3" >
    <select name=id_clasa>
        <%        List es = new ClasaDAO().getByAn(request.getSession().getAttribute("idan")+"");
            if (es!=null)
            for (int i = 0; i < es.size(); i++) {
                ClasaBean b = (ClasaBean) es.get(i);
        %>
           <option name="DA" type="text"  value="<%=b.getId()%>"  ><%=b.getDen()%></option>
        <%}%>
    </select>
        </td>
    </tr>

        <tr>
        <td width="201">Semestru : </td>
        <td cellspan=3 cellpadding="3" >
    <select name=sem>
           <option name="S1" type="text"  value="S1" >S1</option>
           <option name="S2" type="text"  value="S2" >S2</option>
    </select>        </td>
    </tr>

<%--    <tr>--%>
<%--        <td width="201">Utilizator : </td>--%>
<%--        <td cellspan=3 cellpadding="3" >--%>
<%--    <select name=iduser>--%>
<%--        <%        List c = new UserDAO().getALL();--%>
<%--            if (c!=null)--%>
<%--            for (int i = 0; i < c.size(); i++) {--%>
<%--                UsersBean b = (UsersBean) c.get(i);--%>
<%--        %>--%>
<%--           <option name="DA" type="text"  value="<%=b.getUsername()%>" <%=b.getUsername()==ua.getUsername()?"Selected":""%>><%=b.getName()%></option>--%>
<%--        <%}%>--%>
<%--    </select>--%>
<%--        </td>--%>
<%--    </tr>--%>
<%--     <tr>--%>
<%--    <td width="201">Observatii : </td>--%>
<%--    <td width="282">--%>
<%--    <input name="obs" type="text" size="30" value="">--%>
<%--    </td>--%>
<%--  </tr>--%>

</table>
</form>
</td></tr>
</table>
