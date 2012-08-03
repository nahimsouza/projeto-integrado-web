<%-- 
    De modo semelhante à página de consultas, esta página deve 
    exibir as opções de inserção (entidade, tipo ou categoria)

    : falta arrumar as divs que indicam qual insercao será feita
        - ins. entidade, tipo, categoria

--%>

<%@page contentType="text/html" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html lang="en">
    <%@include file="include_files/head.jsp" %>

    <body>
        <%@include file = "include_files/colabHeader.jsp" %>
        <section id="content">
            <!--		<div class="top">
                             <div class="container">
                                     <div class="clearfix">
                                             <section id="gallery">
                                                     <div class="pics">
                                                             <img src="images/slide1.jpg" alt="" width="495" height="329">
                                                             <img src="images/slide3.jpg" alt="" width="495" height="329">
                                                             <img src="images/slide2.jpg" alt="" width="495" height="329">
                                                             <img src="images/slide4.jpg" alt="" width="495" height="329">
                                                             <img src="images/slide5.jpg" alt="" width="495" height="329">
                                                     </div>
                                                     <a href="#" id="prev"></a>
                                                     <a href="#" id="next"></a>
                                             </section>
                                             <section id="intro">
                                                     <div class="inner">
                                                             <h2>Conhecimento<br /> & Colaboração<span>participe!</span></h2>
                                                             <p>Um mundo cheio de conhecimento e você aí parado?<br /> Você tem muita coisa a aprender e, com certeza, muita coisa para ensinar também! Por que não compartilhar todo o seu conhecimento com o mundo e com as próximas gerações?  </p>
                                                             <a href="#" class="extra-button">Saiba mais</a>
                                                     </div>
                                             </section>
                                     </div>
                             </div>
                     </div>
            --> 
            <div class="middle">
                <div class="container">
                    <div class="wrapper">
                        <div class="grid3 first">
                            <ul class="categories">
                                <li><a href="javascript:void(0)" onclick="showDiv( 'insEntidade', true );
                                       showDiv( 'insCategoria', false );
                                       showDiv( 'insTipo', false );">Inserir Entidade</a></li>

                                <li><a href="javascript:void(0)" onclick="showDiv( 'insEntidade', false );
                                           showDiv( 'insCategoria', true );
                                           showDiv( 'insTipo', false );">Inserir Categoria</a></li>

                                <li><a href="javascript:void(0)" onclick="showDiv( 'insEntidade', false );
                                           showDiv( 'insCategoria', false );
                                           showDiv( 'insTipo', true );">Inserir Tipo</a></li>


                                <!--	<li><a href="#">Communications</a></li>
                                            <li><a href="#">Education and Research</a></li>
                                            <li><a href="#">Engineering and Construction</a></li>
                                            <li><a href="#">High Technology</a></li>
                                            <li><a href="#">Industrial Manufacturing</a></li>  -->
                            </ul>
                        </div>
                        <div class="grid9" id="insEntidade">
                            <%@include file="content_files\insEntidade.jsp" %>
                        </div>
                        <div class="grid9" id="insCategoria" style="display: none">
                            <%@include file="content_files\insCategoria.jsp" %>
                        </div>
                        <div class="grid9" id="insTipo" style="display: none">
                            <%@include file="content_files\insTipo.jsp" %>
                        </div>
                    </div>
                </div>
            </div>

            <%@include file="include_files/bottom.jsp" %>
        </section>
            <%@include file="include_files/footer.jsp" %>
    </body>
</html>