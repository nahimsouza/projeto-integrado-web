<%@page import="modelo.UsuarioBean"%>
<%@page import="modelo.CategoriaTipoBean"%>
<%@page language="java" contentType="text/html; charset=ISO-8859-1"
        pageEncoding="ISO-8859-1"%>
<%@page import="modelo.EntidadeBean" %>
<%@page import="java.util.*" %>

<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
    <%@include file="include_files/head.jsp" %> <%-- inserido --%>
    <body>
       <% //Recupera a Session
            try {
                HttpSession sessao = request.getSession(false);
                UsuarioBean log = null;
                if (sessao != null) {
                    log = (UsuarioBean) sessao.getAttribute("Usuario");
                    String tipo = log.getTipo();
            if (tipo.equals("Colaborador")) {
        %>   
                <jsp:include page="include_files/colabHeaderConsulta.jsp" />  
        <% 
            } else if (tipo.equals("Administrador")) {
        %>   
                <jsp:include page="include_files/adminHeaderConsulta.jsp" />  
            <%} }   
           } catch (NullPointerException e) {%>
                 <jsp:include page="include_files/userHeaderConsulta.jsp" />
        <% }%>
        
    <section id="content"><%-- inserido --%>
        <div class="middle"><%-- inserido --%>
            <div class="container"><%-- inserido --%>
                <div class="wrapper"><%-- inserido --%>
                        <%
                            List<CategoriaTipoBean> listaCategoria = (List<CategoriaTipoBean>) request.getAttribute("CategoriaTipoBean");

                            if (listaCategoria.isEmpty()) {

                        %>
                        <h2> Não existem itens cadastrados!!! </h2>
                        <% } // fim do if
                        else { // caso existam registros

                        %>

                        <h2> Resultado da consulta: </h2>
                        <table border=1>
                            <tr>
                                <td> Id Categoria </td>
                                <td> Categoria  </td>
                            </tr>

                            <% for (Iterator i = listaCategoria.iterator(); i.hasNext();) {
                                    CategoriaTipoBean l = (CategoriaTipoBean) i.next();%>

                            <tr>
                                <td><%= l.getIdCategoria() %></td>
                                <td><%= l.getCategoria() %></td>

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





