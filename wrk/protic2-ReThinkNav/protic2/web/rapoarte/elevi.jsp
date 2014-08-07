<%@ page import="java.util.ArrayList,
                 java.util.List,
                 ro.auto.beans.*,

                 ro.dirigentie.dao.*,
                 ro.servlets.init.InitServlet,
                 java.io.FileOutputStream,
                 java.io.File,
                 java.util.Date,
                 java.math.BigDecimal,
                 java.util.Hashtable,
                 java.math.BigInteger"%>


<%     if(request.getSession().getAttribute("userbean")== null || ((UsersBean) request.getSession().getAttribute("userbean")).getUsername()== null)
        response.sendRedirect(response.encodeRedirectURL("../login/login.jsp"));

//    ClasaDAO cDao = new ClasaDAO();
//    cDao.getByAn(request.getSession().getAttribute("idan")+"");

        DisciplinaDAO disDAO = new DisciplinaDAO();


        if(request.getParameter("Save")!= null) {
        Hashtable ms1 = new Hashtable();
        Hashtable ms2 = new Hashtable();
        float mgen = 0;
        int absm = 0;
        int absnem = 0;


        RapoarteDAO rd = new RapoarteDAO();
        ElevDAO eDao = new ElevDAO();
        EleviclaseDAO eleviclaseDAO = new EleviclaseDAO();
        ElevBean elev =((ElevBean)eDao.getByPK(request.getParameter("id_e")).get(0));
        String res = "\r\n\t\t Situatie elev " + elev.getNume() +" in anul scolar "+ request.getSession().getAttribute("denan") +"\r\n";

        String s = "S1";

        List mediielev = rd.getMedii(elev.getId()+"", s, request.getSession().getAttribute("idan")+"");
        if(mediielev.size() > 0)
            res += "\r\n\t\t Sem. I \t Sem. II \t Generala ";
//        + (request.getParameter("sem").equalsIgnoreCase("s1")?"intai":"al doilea");
        float m = 0;
        for (int k = 0; k < mediielev.size(); k++)
            ms1.put(((MediaBean)mediielev.get(k)).getId_disc()+"", ((MediaBean)mediielev.get(k)).getMedia());
        s = "S2";
        mediielev = rd.getMedii(elev.getId()+"", s, request.getSession().getAttribute("idan")+"");
        for (int k = 0; k < mediielev.size(); k++) {
            ms2.put(((MediaBean)mediielev.get(k)).getId_disc()+"", ((MediaBean)mediielev.get(k)).getMedia());
        }

        float man = 0;
        float meds1 = 0;
        float meds2 = 0;
        int idxman = 0;

        List disc = disDAO.getALL();
        for (int k = 0; k < disc.size(); k++) {
            DisciplinaBean db = (DisciplinaBean) disc.get(k);
            res += "\r\n"+ db.getDen() + "\t\t'";
            mgen = 0;
            BigDecimal b = (BigDecimal) ms1.get(db.getId()+"");
            if(b != null) {
                res += b.floatValue();
                mgen += b.floatValue();
                meds1 += b.floatValue();
            }
            res+= "\t'";
            b = (BigDecimal) ms2.get(db.getId()+"");
            if(b != null) {
                res += b.floatValue();
                mgen += b.floatValue();
                if(ms1.get(db.getId()+"") != null)
                    mgen = mgen/2;
                meds2 += b.floatValue();
            }
            if(mgen > 0) {
                res += "\t'"+mgen;
                idxman ++;
                man += mgen;
            }

        }

        if(meds1!=0)
            meds1 = meds1/ms1.size();
        if(meds2!=0)
            meds2 = meds2/ms2.size();

        if(idxman > 0) {
            res += "\r\n\r\n Media generala \t\t'"+ (meds1>0?meds1:"") +"\t'"+ (meds2>0?meds2:"") +"\t'" + (man/idxman>0?man/idxman:"");
        }

        res += "\r\n\r\n\t\t Sem. I \t Sem. II \t Total ";

            s = "S1";
            List abselev = rd.getAbsente(elev.getId()+"", s, request.getSession().getAttribute("idan")+"");
            for (int k = 0; k < abselev.size(); k++) {
                AbsenteBean ab = (AbsenteBean)abselev.get(k);
                absm+= ab.getMotivat();
                absnem+= ab.getNemotivat();
            }

            int absm2 = 0;
            int absnem2 = 0;
            s = "S2";
            abselev = rd.getAbsente(elev.getId()+"", s, request.getSession().getAttribute("idan")+"");
              for (int k = 0; k < abselev.size(); k++) {
                  AbsenteBean ab = (AbsenteBean)abselev.get(k);
                  absm2+= ab.getMotivat();
                  absnem2+= ab.getNemotivat();
              }

        res +="\r\nAbsente motivate\t\t'" + absm +"\t'" +absm2 +"\t'" +(absm +absm2);
        res +="\r\nAbsente nemotivate\t\t'" + absnem +"\t'" +absnem2 +"\t'"  +(absnem +absnem2);;
        res +="\r\nTotal\t\t'" + (absnem + absm)+"\t'" + (absm2+absnem2) +"\t'"  +(absm +absm2+absnem +absnem2);

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


<h2 align=center>Situatie Elevi</h2>
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
        <td width="201" valign=top>Elev : </td>
        <td cellspan=3 cellpadding="3" >
    <select name=id_e>
        <%  List es = new EleviclaseDAO().getByAn(request.getSession().getAttribute("idan")+"");
            ElevDAO edao = new ElevDAO();
            if (es!=null)
            for (int i = 0; i < es.size(); i++) {
                List res = (List)es.get(i);
                EleviclasaBean b = (EleviclasaBean) res.get(0);
        %>
           <option name="DA" type="text"  value="<%=b.getId_elev()%>"  ><%=((ElevBean)edao.getByPK(b.getId_elev()+"").get(0)).getNume()%></option>
        <%}%>
    </select>
        </td>
    </tr>

<%--        <tr>--%>
<%--        <td width="201">Semestru : </td>--%>
<%--        <td cellspan=3 cellpadding="3" >--%>
<%--    <select name=sem>--%>
<%--           <option name="S1" type="text"  value="S1" >S1</option>--%>
<%--           <option name="S2" type="text"  value="S2" >S2</option>--%>
<%--    </select>      --%>
<%--    </td>--%>
<%--    </tr>--%>

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
