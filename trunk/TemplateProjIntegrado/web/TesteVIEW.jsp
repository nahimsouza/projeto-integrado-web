<%-- 
    Document   : TesteVIEW
    Created on : 30/06/2012, 17:27:36
    Author     : nah.000
--%>

<%@page contentType="text/html" pageEncoding="UTF-8"%>
<%@page import="modelo.EntidadeBean" %>
<%@page import="java.util.*" %>

<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
        <title>Testando a consulta por entidade</title>
    </head>
    <body>
        <%
            List<EntidadeBean> listaEntidade = (List<EntidadeBean>) request.getAttribute("entidadeBean");

            if (listaEntidade.isEmpty()) {

        %>
        <h2> Nenhum dado encontrado </h2>
        <% } // fim do if
        else { // caso existam registros

        %>

        <h2> Resultado da consulta: </h2>
        <table border=1>
            <tr>
                <th> Displayname </th>
                <th> Descrição  </th>
            
            </tr>

            <% for (Iterator i = listaEntidade.iterator(); i.hasNext();) {
                    EntidadeBean l = (EntidadeBean) i.next();%>

            <tr>
                <td><%= l.getDisplayname()%></td>
                <td><%= l.getDescricao()%></td>
            </tr>
            <% }%>

        </table>
        <% }%>

    </body>
</html>


