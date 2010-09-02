<%-- 
    Document   : index
    Created on : Jun 27, 2010, 4:31:10 PM
    Author     : razvan
--%>

<%@page contentType="text/html" pageEncoding="UTF-8"%>
<!DOCTYPE HTML PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN"
    "http://www.w3.org/TR/html4/loose.dtd">

<%@ page import="raz.pex.beans.UserBean,
         raz.pex.dao.DAOFactoryMySQL,
         raz.pex.dao.UserDAO"%>

<%
            UserDAO userDAO = DAOFactoryMySQL.getInstance().getUserDAO();
            UserBean user = userDAO.findUserById(1);
%>




<html>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <title>ExpenseManager</title>
    </head>
    <body>
        <h1>Welcome to PersonalExpenseManager!</h1>
        <%= user.getName()%>
    </body>
</html>
