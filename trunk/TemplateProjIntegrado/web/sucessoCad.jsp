<%@page import="modelo.UsuarioBean"%>
<%@page contentType="text/html" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html lang="en">
    <%@include file="include_files/head.jsp" %>

    <body>
    <% //Recupera a Session
            try {
                HttpSession sessao = request.getSession(false);
                UsuarioBean log = null;
                if (sessao != null) {
                    log = (UsuarioBean) sessao.getAttribute("Usuario");
                    String tipo = log.getTipo();
            if (tipo.equals("Colaborador")) {
                response.sendRedirect("oops.jsp");
            } else if (tipo.equals("Administrador")) {
                response.sendRedirect("oops.jsp");
                } 
            }   
           } catch (NullPointerException e) { %>
                 <jsp:include page="include_files/userHeaderCadastro.jsp" />  
            <% }%> 

        <section id="content"> 
            <div class="middle">
                <div class="container">
                    <h2>Cadastro efetuado com sucesso!</h2>
                </div>
            </div>
            <%@include file="include_files/bottom.jsp" %>
        </section>
        <%@include file="include_files/footer.jsp" %>
    </body>
</html>
