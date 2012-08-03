<%-- 
    Página de 'sobre'

    : escrever algo sobre o site

--%>

<%@page import="modelo.UsuarioBean"%>
<%@page contentType="text/html" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html lang="en">
    <%@include file="include_files/head.jsp" %>

    <body><% //Recupera a Session
        try {
            HttpSession sessao = request.getSession(false);
            UsuarioBean log = null;
            if (sessao != null) {
                log = (UsuarioBean) sessao.getAttribute("Usuario");
                String tipo = log.getTipo();
                if (tipo.equals("Colaborador")) {
        %>   
        <jsp:include page="include_files/colabHeaderSobre.jsp" />  
        <%        } else if (tipo.equals("Administrador")) {
        %>   
        <jsp:include page="include_files/adminHeaderSobre.jsp" />  
        <%}
                }
            } catch (NullPointerException e) {%>
        <jsp:include page="include_files/userHeaderSobre.jsp" />
        <% }%>


        <section id="content">
            <div class="middle">
                <div class="container">
                    <h2>Sobre o ChicoBase</h2>
                    <div class="wrapper">
                        Chicobase é uma grande base de conhecimento colaborativa.
                        É uma recolha de dados estruturados online colhidas de várias fontes, inclusive a contribuição 'wiki'.
                        O objetivo da Chicobase, é criar um recurso global que permita as pessoas (e máquinas) acessar informação comum, mais efetivamente. 
                        É desenvolvido por um grupo de alunos de ciência da computação da UFSCar campus Sorocaba.

                    </div>
                </div>
            </div>


            <%@include file="include_files/bottom.jsp" %>
        </section>
        <%@include file="include_files/footer.jsp" %>

    </body>
</html>