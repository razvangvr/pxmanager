<%@ page import="java.util.List"%>
<%@ page import="ro.dirigentie.dao.*" %>
<%@ page import="ro.auto.beans.*" %>
<HTML>
<HEAD>
<SCRIPT language='javascript'>

function PickListRoles(value, text) {
    this.val = value;
    this.text = text;
 }
function sortByText(a, b) {
    var x = a.text;
    var y = b.text;
    return ((x < y) ? -1 : ((x > y) ? 1 : 0));
}

function moveOrizontal(fbox1, tbox1) {

	 var fbox=document.getElementsByName(fbox1)[0];
	 var tbox=document.getElementsByName(tbox1)[0];
     var arrFbox = new Array();
     var arrTbox = new Array();

     var i;
     for(i=0; i<tbox.options.length; i++) {
		  arrTbox[i]=new PickListRoles (tbox.options[i].value,tbox.options[i].text);
     }

     var fLength = 0;
     var tLength = arrTbox.length

	 for(i=0; i<fbox.options.length; i++) {
          if(fbox.options[i].selected && fbox.options[i].value != "") {
			   arrTbox[tLength] = new PickListRoles(fbox.options[i].value,fbox.options[i].text);
               tLength++;
          } else {
			   arrFbox[fLength]= new PickListRoles( fbox.options[i].value, fbox.options[i].text);
               fLength++;
          }
     }
     arrFbox.sort(sortByText);
     arrTbox.sort(sortByText);
     fbox.length = 0;
     tbox.length = 0;
     var c;
     for(c=0; c<arrFbox.length; c++) {
          var no = new Option();
          no.value = arrFbox[c].val;
          no.text = arrFbox[c].text;
          fbox[c] = no;
     }

     for(c=0; c<arrTbox.length; c++) {
     	var no = new Option();
     	no.value =  arrTbox[c].val;
     	no.text = arrTbox[c].text;
     	tbox[c] = no;
     }

}


function moveVertical(fBox1,to)
{
	var fBox=document.getElementById(fBox1);

	var index=fBox.selectedIndex;

	var total = fBox.options.length-1;
	if (index == -1) return false;
	if (to == +1 && index == total) return false;
	if (to == -1 && index == 0) return false;
	var items = new Array;
	var values = new Array;
	for (i = total; i >= 0; i--) {
		items[i] = fBox.options[i].text;
		values[i] = fBox.options[i].value;
	}
	for (i = total; i >= 0; i--) {
		if (index == i) {
			fBox.options[i + to] = new Option(items[i],values[i + to], 0, 1);
			fBox.options[i] = new Option(items[i + to], values[i]);
			i--;
		}
		else {
			fBox.options[i] = new Option(items[i], values[i]);
	   }
	}
	fBox.focus();
}

function selectAll(box) {
     for(var i=0; i < box.length; i++) {
         box[i].selected = true;
     }
}
</SCRIPT>
</HEAD>

<BODY >
<BODY BACKGROUND="../img/background.jpg">
<table class="titlu">
    <tr><td valign=top>
        <jsp:include page="../menu.jsp" flush="true"/>
    </td>
    <td width=10%>
        &nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;<BR>
    </td>
    <td><br>

<%  int len = 0;
    int grupa = Integer.parseInt(request.getParameter("id_grupa"));
    DisciplineprofesoriBean ua = new DisciplineprofesoriBean();
    DisciplineprofesoriDAO discprofDAO = new DisciplineprofesoriDAO();
    DisciplinaDAO dDao = new DisciplinaDAO();
    String[] params = new String[1];
    params[0]=request.getParameter("id");
    List l = discprofDAO.getByPK(params);
    DisciplineprofesoriBean dpb = (DisciplineprofesoriBean)l.get(0);
%>

<h2 align=center>Asociaza  utilizatori grupa nr. <%=request.getParameter("id_grupa") %>, profesor <%=((ProfesorBean)new ProfesorDAO().getByPK(dpb.getId_profesor()+"").get(0)).getNume()%> disciplina <%=((DisciplinaBean)dDao.getByPK(dpb.getId_disciplina()+"").get(0)).getDen()%></h2>
<form name="form1" method="post" action="listuserigrupe.jsp"
onSubmit="MM_validateForm('prDesignCode', 'Design Code', 'R', 'prCurrencyCode', 'Currency Code', 'R', 'prType', 'Instrument Type', 'R', 'prDescription', 'Description', 'R', 'prPDCode', 'POSA/Distributor', 'R', 'prCPCode', 'Content Provider', 'R', 'prCode', 'Code', 'R', 'prAmount','Amount','int','prQuantity','Quantity','int');return document.MM_returnValue">

<table width="400" border="0" cellpadding="0">
  <tr>
    <td>
        <BR>
    </td>
  </tr>
  <tr>
    <td colspan="2" align="left" >
        <P/><input type="submit" name="Save" value="Salveaza"  onClick="selectAll(this.form.list2);">
    <input type="button" name="cancel" value="Inapoi" onClick="document.location='listuserigrupe.jsp?id=<%=request.getParameter("id")%>&id_grupa=<%=request.getParameter("id_grupa")%>'">
        <input type="hidden" name="id_grupa" value="<%=request.getParameter("id_grupa")%>">
        <input type="hidden" name="id" value="<%=request.getParameter("id")%>">
    </td>
  </tr>
  <tr>
    <td>
        <BR>
    </td>
  </tr>
<tr>
    <td>
        <select multiple size="10" name="list1" style="width:150" id='list1' onDblClick="moveOrizontal('list1','list2')">
<%
            UserDAO usersDAO = new UserDAO();
            UserigrupeDAO UsersgrupeDAO = new UserigrupeDAO();
            List elements = usersDAO.getByType("ELEV");
            System.out.println("elements list clasa size " + elements.size());
            if (elements!=null)
            for (int i = 0; i < elements.size(); i++) {
                UsersBean sb = (UsersBean) elements.get(i);
                List selected = UsersgrupeDAO.getByIdDscprofAnduser(dpb.getId()+"", sb.getUsername());
                if(selected == null || selected.size()  == 0) {   %>
                    <option name="DA" type="text"  value="<%=((UsersBean)usersDAO.getByPK(new String [] {sb.getUsername()}).get(0)).getUsername()%>"><%=((UsersBean)usersDAO.getByPK(new String [] {sb.getUsername()}).get(0)).getUsername()%></option>
<%              }
            }
%>
        </select>
    </td>
<td align="center" valign="middle">
<input type="button" onClick="moveOrizontal('list2','list1')" value="<<" id=button1 name=button1>
<input type="button" onClick="moveOrizontal('list1','list2')" value=">>" id=button2 name=button2>
</td>
<td>
        <select multiple size="10" name="list2" id="list2" style="width:150" onDblClick="moveOrizontal('list2','list1')">
            <%
                List e = UsersgrupeDAO.getByIdDscprofAndGrupa(dpb.getId()+"",grupa);
                if (e!=null) {
                    for (int i = 0; i < e.size(); i++) {
                    UsersBean sb =((UsersBean)usersDAO.getByPK(new String [] {((UsersgrupeBean)e.get(i)).getUsername()}).get(0));

            %>
               <option name="DA" type="text"  value="<%=sb.getUsername()%>"><%=sb.getUsername()%></option>
            <%
                   }
                }
            %>
        </select>
</td>
<td valign="middle">
<%--<input type="button" value="&uarr;" onClick="moveVertical('list2',-1)"><br><br>--%>
<%--<input type="button" value="&darr;" onClick="moveVertical('list2',+1)">--%>
</td>
</tr>
<tr><td align="center" colspan="4">
<%--<input type="submit" name="submit_button" value="Submit" onClick="selectAll('list2');">--%>
</td></tr>
</table>
</form>
</td></tr>
</table>
</BODY>
</HTML>
