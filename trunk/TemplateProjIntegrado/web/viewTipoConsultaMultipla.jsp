<%@page import="modelo.CategoriaTipoBean"%>
<%@page language="java" contentType="text/html; charset=ISO-8859-1"
        pageEncoding="ISO-8859-1"%>
<%@page import="modelo.EntidadeBean" %>
<%@page import="java.util.*" %>

<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
    <%@include file="include_files/head.jsp" %> <%-- inserido --%>
    <body>
        <%@include file = "include_files/userHeader.jsp" %><%-- inserido --%>
    <section id="content"><%-- inserido --%>
        <div class="middle"><%-- inserido --%>
            <div class="container"><%-- inserido --%>
                <div class="wrapper"><%-- inserido --%>
                        <%
                            List<CategoriaTipoBean> listaTipo = (List<CategoriaTipoBean>) request.getAttribute("CategoriaTipoBean");

                            if (listaTipo.isEmpty()) {

                        %>
                        <h2> Não existem itens cadastrados!!! </h2>
                        <% } // fim do if
                        else { // caso existam registros

                        %>

                        <h2> Resultado da consulta: </h2>
                        <table border=1>
                            <tr>
                                <td> Id Tipo </td>
                                <td> Tipo  </td>
                            </tr>

                            <% for (Iterator i = listaTipo.iterator(); i.hasNext();) {
                                    CategoriaTipoBean l = (CategoriaTipoBean) i.next();%>

                            <tr>
                                <td><%= l.getIdTipo() %></td>
                                <td><%= l.getTipo() %></td>

                            </tr>
                            <% }%>

                        </table>
                        <% }%>
                        <br>
                        <p><a href="consulta_user.jsp"> Nova Consulta </a> </p>


                </div><%-- inserido --%>
            </div><%-- inserido --%>
        </div><%-- inserido --%>

        <%@include file="include_files/bottom.jsp" %><%-- inserido --%>
    </section><%-- inserido --%>
    <%@include file="include_files/footer.jsp" %><%-- inserido --%>
</body>
</html>





