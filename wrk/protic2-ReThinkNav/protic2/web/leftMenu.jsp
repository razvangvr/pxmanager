<%@ page import="ro.auto.beans.UsersBean"%>
<!DOCTYPE HTML PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN"
"http://www.w3.org/TR/html4/loose.dtd">


<div id="menu2">
<ul>
<%
    if(request.getSession().getAttribute("userbean")!= null && ((UsersBean) request.getSession().getAttribute("userbean")).getUsername()!= null ) {
%>
<li class='sec leftmenu_linie'><a href='../anscolar/list.jsp' >Ani Scolari</a></li>
<% } %>
<%
    if(request.getSession().getAttribute("userbean")!= null && ((UsersBean) request.getSession().getAttribute("userbean")).getUsername()!= null ) {
%>
<li class='sec leftmenu_linie'><a href='../disciplina/list.jsp' >Discipline</a></li>
<% } %>

 <%
    if(request.getSession().getAttribute("userbean")!= null && ((UsersBean) request.getSession().getAttribute("userbean")).getUsername()!= null ) {
%>
<li class='sec leftmenu_linie'><a href='../specializare/list.jsp' >Specializari</a></li>
<% } %>
<%
    if(request.getSession().getAttribute("userbean")!= null && ((UsersBean) request.getSession().getAttribute("userbean")).getUsername()!= null ) {
%>
<li class='sec leftmenu_linie'><a href='../profil/list.jsp' >Profile</a></li>
<% } %>
<%
    if(request.getSession().getAttribute("userbean")!= null && ((UsersBean) request.getSession().getAttribute("userbean")).getUsername()!= null ) {
%>
<li class='sec leftmenu_linie'><a href='../elev/list.jsp' >Elevi</a></li>
<% } %>
<%
    if(request.getSession().getAttribute("userbean")!= null && ((UsersBean) request.getSession().getAttribute("userbean")).getUsername()!= null ) {
%>
<li class='sec leftmenu_linie'><a href='../profesor/list.jsp' >Profesori</a></li>
<% } %>
<%
    if(request.getSession().getAttribute("userbean")!= null && ((UsersBean) request.getSession().getAttribute("userbean")).getUsername()!= null ) {
%>
<li class='sec leftmenu_linie'><a href='../clasa/list.jsp' >Clase</a></li>
<% } %>
<%
    if(request.getSession().getAttribute("userbean")!= null && ((UsersBean) request.getSession().getAttribute("userbean")).getUsername()!= null ) {
%>
<li class='sec leftmenu_linie'><a href='../diriginte/list.jsp' >Diriginti</a></li>
<% } %>
<%
    if(request.getSession().getAttribute("userbean")!= null && ((UsersBean) request.getSession().getAttribute("userbean")).getUsername()!= null && ((UsersBean) request.getSession().getAttribute("userbean")).getUsertype().equals("ADMIN")) {
%>
<li ><a href='../useradmins/list.jsp' >Utilizatori</a></li>
<% } %>

<%--<%--%>
<%--    if(request.getSession().getAttribute("userbean")!= null && ((UseradminsBean) request.getSession().getAttribute("userbean")).getUsername()!= null && ((UseradminsBean) request.getSession().getAttribute("userbean")).getUsertype().equals("ADMIN")) {--%>
<%--%>--%>
<%--<li ><a href='../fileupload/uploadFile.jsp' >Adauga Fisier</a></li>--%>
<%--<% } %>--%>
<%--<%--%>
<%--    if(request.getSession().getAttribute("userbean")!= null && ((UsersBean) request.getSession().getAttribute("userbean")).getUsername()!= null) {--%>
<%--%>--%>
<%--<li ><a href='../login/login.jsp?logout=1' >Logout</a></li>--%>
<%--<% } %>--%>
</ul>
</div>
