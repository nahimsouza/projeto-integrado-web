
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
        %>   
        <jsp:include page="include_files/colabHeaderAlt.jsp" />  
        <%        } else if (tipo.equals("Administrador")) {
        %>   
        <jsp:include page="include_files/adminHeaderAlt.jsp" />  
        <%}
                }
            } catch (NullPointerException e) {
                response.sendRedirect("oops.jsp");
                }%> 

        <section id="content">
            <div class="middle">
                <div class="container">
                    <div class="wrapper">
                        <div class="grid3 first">
                            <ul class="categories">
                                <li><a href="javascript:void(0)" onclick="showDiv( 'altEntidade', true );
                                    showDiv( 'altCategoria', false );
                                    showDiv( 'altTipo', false );">Alterar Entidade</a></li>

                                <li><a href="javascript:void(0)" onclick="showDiv( 'altEntidade', false );
                                    showDiv( 'altCategoria', true );
                                    showDiv( 'altTipo', false );">Alterar Categoria</a></li>

                                <li><a href="javascript:void(0)" onclick="showDiv( 'altEntidade', false );
                                    showDiv( 'altCategoria', false );
                                    showDiv( 'altTipo', true );">Alterar Tipo</a></li>
                            </ul>
                        </div>
                        <div class="grid9" id="altEntidade">
                            <%@include file="content_files\altEntidade.jsp" %>
                        </div>
                        <div class="grid9" id="altCategoria" style="display: none">
                            <%@include file="content_files\altCategoria.jsp" %>
                        </div>
                        <div class="grid9" id="altTipo" style="display: none">
                            <%@include file="content_files\altTipo.jsp" %>
                        </div>
                    </div>
                </div>
            </div>

            <%@include file="include_files/bottom.jsp" %>
        </section>
        <%@include file="include_files/footer.jsp" %>
    </body>
</html>