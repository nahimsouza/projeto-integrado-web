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
                <jsp:include page="include_files/colabHeaderAlt.jsp" />  
        <% 
            } else if (tipo.equals("Administrador")) {
        %>   
                <jsp:include page="include_files/adminHeaderAlt.jsp" />  
            <%} }   
           } catch (NullPointerException e) {
                 response.sendRedirect("oops.jsp");
         }%>
        
    <section id="content"><%-- inserido --%>
        <div class="middle"><%-- inserido --%>
            <div class="container"><%-- inserido --%>
                <div class="wrapper"><%-- inserido --%>
                        <%
                            List<CategoriaTipoBean> listaCategoria = (List<CategoriaTipoBean>) request.getAttribute("CategoriaTipoBean");

                          if (listaCategoria == null) {

                        %>
                        <h2> Não existem itens cadastrados!!! </h2>
                        <% } // fim do if
                        else if (listaCategoria.isEmpty()) {

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

                            <% for (Iterator i = listaCategoria.iterator(); i.hasNext();) {
                                    CategoriaTipoBean l = (CategoriaTipoBean) i.next();%>

                            <tr>
                                <td><%= l.getIdTipo() %></td>
                                <td><%= l.getTipo() %></td>
                                <td><% session.setAttribute("Tipo", l.getTipo());
                                out.println("<a href='altResultadoTipo.jsp'>Alterar</a>");%></td>

                            </tr>
                            <% }%>

                        </table>
                        <% }%>
                        <br>
                        <p><a href="consulta.jsp"> Nova Consulta </a> </p>


                </div><%-- inserido --%>
            </div><%-- inserido --%>
        </div><%-- inserido --%>

        <%@include file="include_files/bottom.jsp" %><%-- inserido --%>
    </section><%-- inserido --%>
    <%@include file="include_files/footer.jsp" %><%-- inserido --%>
</body>
</html>





