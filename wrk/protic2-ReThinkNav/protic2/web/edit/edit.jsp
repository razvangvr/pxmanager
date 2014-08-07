<%@ page import="java.util.ArrayList,
                 java.util.List,
                 ro.auto.beans.*,
                 ro.dirigentie.dao.UserDAO,
                 ro.dirigentie.dao.ElevDAO,
                 ro.utils.DateUtils,
                 ro.dirigentie.dao.PaginiDAO"%>
<%@ page import="ro.dirigentie.dao.UserigrupeDAO" %>

<%
    if(request.getSession().getAttribute("userbean")== null || ((UsersBean) request.getSession().getAttribute("userbean")).getUsername()== null)
    {
        response.sendRedirect(response.encodeRedirectURL("../login/login.jsp"));
        return;
    }
%>
<!DOCTYPE HTML PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN"
"http://www.w3.org/TR/html4/loose.dtd">
<BODY BACKGROUND="../img/background.jpg">
<table class="titlu">
    <tr><td valign=top>
        <jsp:include page="../menupagina.jsp" flush="true"/>
    </td>
    <td width=10%>
        &nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;<BR>
    </td>
    <td><br>

<%
    if(request.getSession().getAttribute("userbean")== null || ((UsersBean) request.getSession().getAttribute("userbean")).getUsername()== null)
        response.sendRedirect(response.encodeRedirectURL("../login/login.jsp"));
    UsersBean ub = ((UsersBean) request.getSession().getAttribute("userbean"));
    UsersgrupeBean ugb = null;

    String id_grupa = request.getParameter("id_grupa");
    String id_disciplineprofesori = request.getParameter("id_disciplineprofesori");

    if(ub.getUsertype().equals("PROFESOR") || ub.getUsertype().equals("ADMIN"))
    {
    }
    if(id_grupa == null)
    {
        UserigrupeDAO userigrupeDAO = new UserigrupeDAO();
        List l = userigrupeDAO.getByUsername(ub.getUsername());
        if(l==null || l.size() == 0)
            throw new Exception("User neasignat " + ub.getUsername());
    
        ugb = (UsersgrupeBean)l.get(0);
    }

    PaginiDAO pgDAO = new PaginiDAO();
    List elements = pgDAO.getByGrupa( ((id_grupa != null) ? Integer.parseInt(id_grupa) : ugb.getGrupa()) + "", ((id_disciplineprofesori != null) ? Integer.parseInt(id_disciplineprofesori) : ugb.getId_disciplineprofesori())+"");
    String text = "Editati continutul paginii !";
    if (elements!=null && elements.size() > 0)
    {
        PaginiBean sb = (PaginiBean) elements.get(0);
        text = sb.getContinut();
    }

%>
<h2 align=center>Editare Pagina</h2>

<script type="text/javascript" src="../jscripts/tiny_mce/tiny_mce.js"></script>
<script type="text/javascript">
var tinyMCEImageList = new Array(
	// Name, URL
	["Logo 1", "media/logo.jpg"]
);
	tinyMCE.init({
		// General options
		mode : "textareas",
		theme : "advanced",
		plugins : "autolink,lists,pagebreak,style,layer,table,save,advhr,advimage,advlink,emotions,iespell,inlinepopups,insertdatetime,preview,media,searchreplace,print,contextmenu,paste,directionality,fullscreen,noneditable,visualchars,nonbreaking,xhtmlxtras,template,wordcount,advlist,autosave",

		// Theme options
		theme_advanced_buttons1 : "save,newdocument,|,bold,italic,underline,strikethrough,|,justifyleft,justifycenter,justifyright,justifyfull,styleselect,formatselect,fontselect,fontsizeselect",
		theme_advanced_buttons2 : "cut,copy,paste,pastetext,pasteword,|,search,replace,|,bullist,numlist,|,outdent,indent,blockquote,|,undo,redo,|,link,unlink,anchor,image,cleanup,help,code,|,insertdate,inserttime,preview,|,forecolor,backcolor",
		theme_advanced_buttons3 : "tablecontrols,|,hr,removeformat,visualaid,|,sub,sup,|,charmap,emotions,iespell,media,advhr,|,print,|,ltr,rtl,|,fullscreen",
		theme_advanced_buttons4 : "insertlayer,moveforward,movebackward,absolute,|,styleprops,|,cite,abbr,acronym,del,ins,attribs,|,visualchars,nonbreaking,template,pagebreak,restoredraft",
		theme_advanced_toolbar_location : "top",
		theme_advanced_toolbar_align : "left",
		theme_advanced_statusbar_location : "bottom",
		theme_advanced_resizing : true,

		// Example content CSS (should be your site CSS)
		content_css : "css/content.css",

		// Drop lists for link/image/media/template dialogs
		template_external_list_url : "lists/template_list.js",
		external_link_list_url : "lists/link_list.js",
		external_image_list_url : "lists/image_list.js",
		media_external_list_url : "lists/media_list.js",

		// Style formats
		style_formats : [
			{title : 'Bold text', inline : 'b'},
			{title : 'Red text', inline : 'span', styles : {color : '#ff0000'}},
			{title : 'Red header', block : 'h1', styles : {color : '#ff0000'}},
			{title : 'Example 1', inline : 'span', classes : 'example1'},
			{title : 'Example 2', inline : 'span', classes : 'example2'},
			{title : 'Table styles'},
			{title : 'Table row 1', selector : 'tr', classes : 'tablerow1'}
		],

		// Replace values for the template plugin
		template_replace_values : {
			username : "Some User",
			staffid : "991234"
		}
	});
</script>
<!-- /TinyMCE -->

</head>
<body>


<script type="text/javascript">
if (document.location.protocol == 'file:') {
	alert("The examples might not work properly on the local file system due to security settings in your browser. Please use a real webserver.");
}
</script>

<form name="form1" method="post" action="list.jsp"
onSubmit="MM_validateForm('prDesignCode', 'Design Code', 'R', 'prCurrencyCode', 'Currency Code', 'R', 'prType', 'Instrument Type', 'R', 'prDescription', 'Description', 'R', 'prPDCode', 'POSA/Distributor', 'R', 'prCPCode', 'Content Provider', 'R', 'prCode', 'Code', 'R', 'prAmount','Amount','int','prQuantity','Quantity','int');return document.MM_returnValue">

<table width="400" border="0" cellpadding="0">
  <tr>
    <td colspan="2" align="left" >
        <P/>
	<div>
		<div>
			<textarea id="elm1" name="elm1" rows="15" cols="80" style="width: 80%">
				&lt;p&gt;
				<%=text%>
                &lt;/p&gt;
			</textarea>
		</div>

		<!-- Some integration calls -->
<%--		<a href="javascript:;" onclick="tinyMCE.get('elm1').show();return false;">[Show]</a>--%>
<%--		<a href="javascript:;" onclick="tinyMCE.get('elm1').hide();return false;">[Hide]</a>--%>
<%--		<a href="javascript:;" onclick="tinyMCE.get('elm1').execCommand('Bold');return false;">[Bold]</a>--%>
<%--		<a href="javascript:;" onclick="alert(tinyMCE.get('elm1').getContent());return false;">[Get contents]</a>--%>
<%--		<a href="javascript:;" onclick="alert(tinyMCE.get('elm1').selection.getContent());return false;">[Get selected HTML]</a>--%>
<%--		<a href="javascript:;" onclick="alert(tinyMCE.get('elm1').selection.getContent({format : 'text'}));return false;">[Get selected text]</a>--%>
<%--		<a href="javascript:;" onclick="alert(tinyMCE.get('elm1').selection.getNode().nodeName);return false;">[Get selected element]</a>--%>
<%--		<a href="javascript:;" onclick="tinyMCE.execCommand('mceInsertContent',false,'<b>Hello world!!</b>');return false;">[Insert HTML]</a>--%>
<%--		<a href="javascript:;" onclick="tinyMCE.execCommand('mceReplaceContent',false,'<b>{$selection}</b>');return false;">[Replace selection]</a>--%>

		<br />
        <%    if(ub.getUsertype().equals("ELEV")) {%>
		    <input type="submit" name="Save" value="Salveaza" />
        <%}%>
<%--		<input type="reset" name="reset" value="Reset" />--%>
<%--        <input type="button" name="cancel" value="Inapoi" onClick="document.location='list.jsp'">--%>
	</div>
        </td>
  </tr>
</table>
</form>
</td></tr>
<%--    <tr>--%>
<%--    <td width="201">--%>
<%--           <input type="button" name="parinti" value="Parinti elev"--%>
<%--            onClick="document.location='../parinte/list.jsp?id_elev=<%=request.getParameter("id")%>'" >--%>
<%--</td></tr>--%>
<%--</tr>--%>
<%--    <tr>--%>
<%--    <td width="201">--%>
<%--           <input type="button" name="medii" value="Medii elev"--%>
<%--            onClick="document.location='../media/list.jsp?id_elev=<%=request.getParameter("id")%>'" >--%>
<%--</td></tr>--%>
<%--    <tr>--%>
<%--    <td width="201">--%>
<%--           <input type="button" name="medii" value="Absente elev"--%>
<%--            onClick="document.location='../absente/list.jsp?id_elev=<%=request.getParameter("id")%>'" >--%>
<%--</td></tr>--%>
</table>
