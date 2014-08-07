<%@ page import="java.util.List,
                 ro.dirigentie.dao.EleviclaseDAO,
                 ro.auto.beans.EleviclasaBean,
                 ro.auto.beans.ElevBean,
                 ro.dirigentie.dao.ElevDAO"%>
<%@ page import="ro.auto.beans.ClasaBean" %>
<%@ page import="ro.dirigentie.dao.ClasaDAO" %>
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
    ClasaDAO clasaDAO = new ClasaDAO();
    List clase = clasaDAO.getByPK(new Object[] {request.getParameter("id_clasa")});
%>


<h2 align=center>Asociaza  elevi clasei <%= ((ClasaBean)clase.get(0)).getDen() %></h2>
<form name="form1" method="post" action="list.jsp"
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
    <input type="button" name="cancel" value="Inapoi" onClick="document.location='list.jsp?id_clasa=<%=request.getParameter("id_clasa")%>'">
    <input type="hidden" name="id_clasa" value="<%=request.getParameter("id_clasa")%>">
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
 <%         ElevBean ua = new ElevBean();
            ElevDAO eleviDAO = new ElevDAO();
             EleviclaseDAO eleviclaseDAO = new EleviclaseDAO();
            List elements = eleviDAO.getALL();

            if (elements!=null)
            for (int i = 0; i < elements.size(); i++) {
                ElevBean sb = (ElevBean) elements.get(i);
                List l = eleviclaseDAO.getByElevAn(sb.getId()+"",request.getSession().getAttribute("idan")+"");
                if(l.size()  == 0 ) {
%>
        <option name="DA" type="text"  value="<%=sb.getId()%>"><%=sb.getNume()%></option>
<%}}%>
        </select>
    </td>
<td align="center" valign="middle">
<input type="button" onClick="moveOrizontal('list2','list1')" value="<<" id=button1 name=button1>
<input type="button" onClick="moveOrizontal('list1','list2')" value=">>" id=button2 name=button2>
</td>
<td>
<select multiple size="10" name="list2" id="list2" style="width:150" onDblClick="moveOrizontal('list2','list1')">
    <%  ElevDAO eDao = new ElevDAO();

        List e = eleviclaseDAO.getByClasa(request.getParameter("id_clasa"));
        System.out.println(request.getParameter("id_clasa"));
        System.out.println(request.getSession().getAttribute("idan")+"");

        if (e!=null) {
            for (int i = 0; i < e.size(); i++) {
            ElevBean sb =((ElevBean)eDao.getByPK(((EleviclasaBean)e.get(i)).getId_elev()+"").get(0));

    %>
       <option name="DA" type="text"  value="<%=sb.getId()%>"><%=sb.getNume()%></option>
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
