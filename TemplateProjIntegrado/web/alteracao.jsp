<%-- 
    De modo semelhante à página de consultas, esta página deve 
    exibir as opções de alteração (entidade, tipo ou categoria)

    : falta arrumar as divs que indicam qual alteração será feita
        - alt. entidade, tipo, categoria

--%>

<%@page contentType="text/html" pageEncoding="UTF-8"%>
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
                            <%@include file="altEntidade.jsp" %>
                        </div>
                        <div class="grid9" id="altCategoria" style="display: none">
                            <%@include file="altCategoria.jsp" %>
                        </div>
                        <div class="grid9" id="altTipo" style="display: none">
                            <%@include file="altTipo.jsp" %>
                        </div>
                    </div>
                </div>
            </div>

            <%@include file="include_files/bottom.jsp" %>
        </section>
        <%@include file="include_files/footer.jsp" %>
    </body>
</html>