<%-- 
    Página do administrador para consultar usuários

    : falta modificar as páginas de solicitacoes e consultas
        - arrumar as divs

--%>

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
        %>   
                <jsp:include page="include_files/adminHeaderUsuario.jsp" />  
            <%} }   
           } catch (NullPointerException e) {
                 response.sendRedirect("oops.jsp");
            }%>
        <section id="content">
            <div class="middle">
                <div class="container">
                    <div class="wrapper">
                        <div class="grid3 first">
                            <ul class="categories">
                                <li><a href="javascript:void(0)" onclick="showDiv( 'solicitacoes', true );
                                    showDiv( 'conUsuario', false );">Novas Solicitações</a></li>

                                <li><a href="javascript:void(0)" onclick="showDiv( 'solicitacoes', false );
                                    showDiv( 'conUsuario', true );">Consultar Usuários</a></li>
                            </ul>
                        </div>
                        
                        <div class="grid9" id="solicitacoes">    
                           <form id="formulario" nome ="formulario" method="post" action="VerificarSolicitacoes" >
                               <input type="hidden" value="usuarios" name="acao" />
                               <script language="JavaScript">document.forms['formulario'].submit();</script> 
                            </form>
                        </div>
                        
                        <div class="grid9" id="conUsuario" style="display: none">
                            <%@include file="content_files/conUsuario.jsp" %>
                        </div>
                    </div>
                </div>
            </div>

            <%@include file="include_files/bottom.jsp" %>
        </section>
        <%@include file="include_files/footer.jsp" %>
    </body>
</html>