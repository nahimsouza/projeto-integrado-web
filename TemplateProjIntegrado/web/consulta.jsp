<%-- 
    Pagina de consulta para os usuarios comuns
--%>

<%@page contentType="text/html" pageEncoding="UTF-8"%>
<%@page import="modelo.EntidadeBean" %>
<%@page import="java.util.*" %>
<!DOCTYPE html>
<html lang="en">
    <%@include file="include_files/head.jsp" %>
    <body>
        <%@include file = "include_files/colabHeader.jsp" %>
        <section id="content">
            <div class="middle">
                <div class="container">
                    <div class="wrapper">
                        <div class="grid3 first">
                            <ul class="categories">
                                       <li><a href="javascript:void(0)" onclick="showDiv( 'conEntidade', true );
                                                            showDiv( 'conCategoria', false );
                                                            showDiv( 'conTipo', false );
                                                            showDiv( 'conAvancada', false );">Consulta por Entidade</a></li>

                                       <li><a href="javascript:void(0)" onclick="showDiv( 'conEntidade', false );
                                                            showDiv( 'conCategoria', true );
                                                            showDiv( 'conTipo', false );
                                                            showDiv( 'conAvancada', false );">Consulta por Categoria</a></li>

                                       <li><a href="javascript:void(0)" onclick="showDiv( 'conEntidade', false );
                                                            showDiv( 'conCategoria', false );
                                                            showDiv( 'conTipo', true );
                                                            showDiv( 'conAvancada', false );">Consulta por Tipo</a></li>

                                       <li><a href="javascript:void(0)" onclick="showDiv( 'conEntidade', false );
                                                            showDiv( 'conCategoria', false );
                                                            showDiv( 'conTipo', false );
                                                            showDiv( 'conAvancada', true );">Consulta Avançada</a></li>
                            </ul>
                        </div>
                        <div class="grid9" id="conEntidade">
                            <%@include file="content_files/conEntidade.jsp" %>
                        </div>
                        <div class="grid9" id="conCategoria" style="display: none">
                            <%@include file="content_files/conCategoria.jsp" %>
                        </div> 
                        <div class="grid9" id="conTipo" style="display: none">
                            <%@include file="content_files/conTipo.jsp" %>
                        </div> 
                        <div class="grid9" id="conAvancada" style="display: none" >
                            <%@include file="content_files/conAvancada.jsp"  %>
                        </div> 
                    </div>
                </div>
            </div>

            <%@include file="include_files/bottom.jsp" %>
        </section>
        <%@include file="include_files/footer.jsp" %>
    </body>
</html>