
<%@page import="modelo.UsuarioBean"%>
<%@page contentType="text/html" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html lang="en">
    <%@include file="include_files/head.jsp" %>

    <body  onload="chamaServlet(carregaCategorias,'carregaCategorias')">
        <% //Recupera a Session
            try {
                HttpSession sessao = request.getSession(false);
                UsuarioBean log = null;
                if (sessao != null) {
                    log = (UsuarioBean) sessao.getAttribute("Usuario");
                    String tipo = log.getTipo();
                    if (tipo.equals("Colaborador")) {
        %>   
        <jsp:include page="include_files/colabHeaderIns.jsp" />  
        <%        } else if (tipo.equals("Administrador")) {
        %>   
        <jsp:include page="include_files/adminHeaderIns.jsp" />  
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
                                <li><a href="javascript:void(0)" onclick="showDiv( 'insEntidade', true );
                                    showDiv( 'insCategoria', false );
                                    showDiv( 'insTipo', false ); document.getElementById('acao').value ='insEntidade';">Inserir Entidade</a></li>

                                <li><a href="javascript:void(0)" onclick="showDiv( 'insEntidade', false );
                                    showDiv( 'insCategoria', true );
                                    showDiv( 'insTipo', false ); document.getElementById('acao').value ='insCategoria'; ">Inserir Categoria</a></li>

                                <li><a href="javascript:void(0)" onclick="showDiv( 'insEntidade', false );
                                    showDiv( 'insCategoria', false );
                                    showDiv( 'insTipo', true ); document.getElementById('acao').value ='insTipo';">Inserir Tipo</a></li>
                            </ul>
                        </div>
                        
                        <% if(((String)request.getSession().getAttribute("janela")) == null){ %>
                            <div class="grid9" id="insEntidade">
                                <script type="text/javascript">
                                    document.getElementById('acao').value = 'insEntidade';
                                </script>
                                    <%@include file="content_files\insEntidade.jsp" %>
                            </div>
                        <% }else{ %>
                            <div class="grid9" id="insEntidade" style="display: none">
                                <%@include file="content_files\insEntidade.jsp" %>
                            </div>
                        <%} if((String)request.getSession().getAttribute("janela") == "a"){ %>
                            <div class="grid9" id="insCategoria">
                                  <script type="text/javascript">
                                    document.getElementById('acao').value = 'insCategoria';
                                </script>
                                <%@include file="content_files\insCategoria.jsp" %>
                            </div>
                        <% }else{ %>
                            <div class="grid9" id="insCategoria" style="display: none">
                                <%@include file="content_files\insCategoria.jsp" %>
                            </div>
                         <% }if((String)request.getSession().getAttribute("janela") == "b"){ %>
                            <div class="grid9" id="insTipo">
                                  <script type="text/javascript">
                                    document.getElementById('acao').value = 'insTipo';
                                </script>
                                <%@include file="content_files\insTipo.jsp" %>
                            </div>
                        <% }else{ %>
                            <div class="grid9" id="insTipo" style="display: none">
                                <%@include file="content_files\insTipo.jsp" %>
                            </div>
                        <% } %>
                    </div>
                </div>
            </div>

            <%@include file="include_files/bottom.jsp" %>
        </section>
        <%@include file="include_files/footer.jsp" %>  
    <input type="hidden" name="selectedCat" id="selectedCat" />
    </body>
</html>
