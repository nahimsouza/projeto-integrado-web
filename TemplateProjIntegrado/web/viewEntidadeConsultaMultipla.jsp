<%@page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<%@page import="modelo.EntidadeBean" %>
<%@page import="java.util.*" %>

<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
<title>Visão da Entidade</title>
</head>
<body>
    <%
    List<EntidadeBean> listaEntidade=(List<EntidadeBean>)request.getAttribute("EntidadeBean");

    if (listaEntidade.isEmpty()){

%>
<h2> Não existem itens cadastrados!!! </h2>
<% } // fim do if
    else { // caso existam registros

    %>

     <h2> Resultado da consulta: </h2>
   <table border=1>
      <tr>
         <td> Descrição </td>
         <td> Displayname  </td>
      </tr>

   <% for(Iterator i=listaEntidade.iterator(); i.hasNext();){
         EntidadeBean l=(EntidadeBean)i.next(); %>
      
         <tr>
             <td><%= l.getDescricao() %></td>
             <td><%= l.getDisplayname() %></td>
             
         </tr>
         <% } %>

  </table>
 <% } %>
       <p><a href="consulta_user.jsp"> Principal </a> </p>

</body>
</html>

