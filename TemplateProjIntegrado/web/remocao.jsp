<%-- 
    De modo semelhante à página de consultas, esta página deve 
    exibir as opções de remoção (entidade, tipo ou categoria)

    : falta arrumar as divs que indicam qual remoção será feita
        - alt. entidade, tipo, categoria

--%>

<%@page contentType="text/html" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html lang="en">
    <%@include file="include_files/head.jsp" %>

<body>
             <%@include file = "include_files/colabHeaderRem.jsp" %>
	<section id="content">
		<div class="middle">
			<div class="container">
				<div class="wrapper">
					<div class="grid3 first">
						<ul class="categories">
							<li><a href="javascript:void(0)" onclick="showDiv( 'remEntidade', true );
                                                                                                  showDiv( 'remCategoria', false );
                                                                                                  showDiv( 'remTipo', false );">Remover Entidade</a></li>
                                                        
							<li><a href="javascript:void(0)" onclick="showDiv( 'remEntidade', false );
                                                                                                  showDiv( 'remCategoria', true );
                                                                                                  showDiv( 'remTipo', false );">Remover Categoria</a></li>
                                                        
                                                        <li><a href="javascript:void(0)" onclick="showDiv( 'remEntidade', false );
                                                                                                  showDiv( 'remCategoria', false );
                                                                                                  showDiv( 'remTipo', true );">Remover Tipo</a></li>
						</ul>
					</div>
					<div class="grid9" id="remEntidade">
                                            <%@include file="content_files\remEntidade.jsp" %>
					</div>
                                        <div class="grid9" id="remCategoria" style="display: none">
                                            <%@include file="content_files\remCategoria.jsp" %>
					</div>
                                        <div class="grid9" id="remTipo" style="display: none">
                                            <%@include file="content_files\remTipo.jsp" %>
                                    	</div>
				</div>
			</div>
		</div>
                                            <%@include file="include_files/bottom.jsp" %>
	</section>
                                            <%@include file="include_files/footer.jsp" %>
</body>
</html>