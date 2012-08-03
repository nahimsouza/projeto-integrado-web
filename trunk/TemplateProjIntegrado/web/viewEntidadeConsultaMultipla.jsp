<%@page import="modelo.UsuarioBean"%>
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
                            List<EntidadeBean> listaEntidade = (List<EntidadeBean>) request.getAttribute("EntidadeBean");

                            if (listaEntidade.isEmpty()) {

                        %>
                        <h2> Não existem itens cadastrados!!! </h2>
                        <% } // fim do if
                        else { // caso existam registros

                        %>

                        <h2> Resultado da consulta: </h2>
                        <table border=8>
                            <tr>
                                <th> Descrição </th>
                                <th> Displayname  </th>
                            </tr>

                            <%int j = 0;
                            for (Iterator i = listaEntidade.iterator(); i.hasNext();) {
                            //for (Iterator i = listaEntidade.iterator(); j < 10 && i.hasNext(); j++) {
                                    EntidadeBean l = (EntidadeBean) i.next();%>

                            <tr>
                                <td><%= l.getDescricao()%></td>
                                <td><%= l.getDisplayname()%></td>

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



