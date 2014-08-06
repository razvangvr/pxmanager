<%@ page import="ro.auto.beans.UsersBean"%>
<!DOCTYPE HTML PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN"
"http://www.w3.org/TR/html4/loose.dtd">
<head>
<style>

th {
	font-family: Arial, Helvetica, sans-serif;
	font-size: 14px;
	text-decoration: none;
	font-weight: bold;
	color: #2A416F;
	height: 15px;
	margin-left: 9px;
	padding-left: 6px;
	background-color: #ffecac;
}

.denumire {
	font-family: Arial, Helvetica, sans-serif;
	font-size: 15px;
	text-decoration: none;
	font-weight: bold;
	color: #08017F;
	height: 15px;
	margin-left: 9px;
	padding-left: 6px;
}

.import {
	font-family: Arial, Helvetica, sans-serif;
	font-size: 11px;
	text-decoration: none;
	font-weight: bold;
	color: #000000;
	height: 12px;
	margin-left: 9px;
	padding-left: 6px;
}


<!--
body {
        font-family: Arial, Helvetica, sans-serif;
        margin: 0;
        font-size: 80%;
        font-weight: bold;
      background-image: url(../img/background.bmp);
      backgroundColor:"blue";
        }

h2 {
        font: bold 15px  Verdana, Arial, Helvetica;
        color: #000;
        margin: 0px;
        padding: 0px 0px 0px 15px;
}

ul {    font-weight: bold ;
        font-size: 12px;

        list-style: none;
        margin: 0;
        padding: 0;
        }

img {
    border: none;
}


/*- Menu 2--------------------------- */

#menu2 {
        width: 180px;
        height: 22px;
        margin: 10px;
        border-style: solid solid none solid;
        border-color: #D8D5D1;
        border-size: 1px;
        border-width: 1px;
        }

#menu2 li a {
        height: 32px;
          voice-family: "\"}\"";
          voice-family: inherit;
          height: 24px;
        text-decoration: none;
        }

#menu2 li a:link, #menu2 li a:visited {
        color: #3688BA;
        display: block;
        background:  url(../menu2.gif);
        padding: 8px 0 0 30px;
        }

#menu2 li a:hover, #menu2 li #current {
        color: #3688BA;
        background:  url(../menu2.gif) 0 -32px;
        padding: 8px 0 0 32px;
        }
-->

</style>

</head>

<div id="menu2">
<ul>

<%
    if(request.getSession().getAttribute("userbean")!= null && ((UsersBean) request.getSession().getAttribute("userbean")).getUsername()!= null ) {
%>
<li class='sec leftmenu_linie'><a href='../rapoarte/clase.jsp' >Situatii clase</a></li>
<% } %>


<%
    if(request.getSession().getAttribute("userbean")!= null && ((UsersBean) request.getSession().getAttribute("userbean")).getUsername()!= null ) {
%>
<li ><a href='../rapoarte/elevi.jsp' >Situatii elevi</a></li>
<% } %>


</ul>
</div>
