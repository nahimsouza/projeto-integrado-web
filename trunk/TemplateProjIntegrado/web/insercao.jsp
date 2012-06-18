<%-- 
    De modo semelhante à página de consultas, esta página deve 
    exibir as opções de inserção (entidade, tipo ou categoria)

    : falta arrumar as divs que indicam qual insercao será feita
        - ins. entidade, tipo, categoria

--%>

<%@page contentType="text/html" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html lang="en">
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <title>ChicoBase</title>
        <meta charset="utf-8">
        <link rel="stylesheet" href="css/reset.css" type="text/css" media="all">
        <link rel="stylesheet" href="css/grid.css" type="text/css" media="all">
        <link rel="stylesheet" href="css/style.css" type="text/css" media="all">
        <link rel="stylesheet" href="css/jquery-ui-1.8.5.custom.css" type="text/css" media="all">
        <script type="text/javascript" src="js/jquery-1.4.2.min.js" ></script>
        <script type="text/javascript" src="js/jquery.cycle.all.js"></script>
        <script type="text/javascript" src="js/jquery-ui-1.8.5.custom.min.js"></script>
        <script type="text/javascript" src="js/my-javascript.js"></script>
        <!--[if lt IE 9]>
                <script type="text/javascript" src="js/html5.js"></script>
        <![endif]-->
    </head>

    <body>
        <header>
            <%@include file = "colabHeader.jsp" %>
        </header>
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
                            <%@include file="insEntidade.jsp" %>
                        </div>
                        <div class="grid9" id="insCategoria" style="display: none">
                            <%@include file="insCategoria.jsp" %>
                        </div>
                        <div class="grid9" id="insTipo" style="display: none">
                            <%@include file="insTipo.jsp" %>
                        </div>
                    </div>
                </div>
            </div>

            <div class="bottom">
                <div class="container">
                    <div class="wrapper">
                        <div class="grid3 first">
                            <h3>Compartilhe</h3>
                            <ul class="list1">
                                <li><a href="#">facebook.com/chicobase</a></li>
                                <li><a href="#">@chicobase</a></li>
                                <li><a href="#"></a></li>
                            </ul>
                        </div>
                        <div class="grid3">
                            <h3>Links Úteis</h3>
                            <ul class="list2">
                                <li><a href="#">Google</a></li>
                                <li><a href="#">Bing</a></li>
                                <li><a href="#">Wikipedia</a></li>
                                <li><a href="#">UFSCar</a></li>
                                <li><a href="#">Moodle</a></li>
                                <li><a href="#">World Wide Web Consortium</a></li>
                                <li><a href="#">FAQs</a></li>
                            </ul>
                        </div>
                        <div class="grid3">
                            <h3>Mais buscados</h3>
                            <ul class="list2">
                                <li><a href="#">Washington</a></li>
                                <li><a href="#">UFSCar</a></li>
                                <li><a href="#">SQL Server 2008</a></li>
                                <li><a href="#">NetBeans</a></li>
                                <li><a href="#">Virtualization</a></li>
                                <li><a href="#">IV SeCoT</a></li>
                                <li><a href="#">Maratona de Programação</a></li>
                            </ul>
                        </div>
                        <div class="grid3">
                            <div id="datepicker"></div>
                        </div>
                    </div>
                </div>
            </div>
        </section>
        <footer>
            <div class="container">
                <div class="wrapper">
                    <div class="copy">ChicoBase (c) 2012	|	<a href="index-4.html">Privacy policy</a></div>
                    <address class="phone">
                        Ficamos felizes em ajudá-lo! Entre em contato conosco. <strong>contato@chicobase.com</strong>
                    </address>
                </div>
            </div>
        </footer>
        <script type="text/javascript">
            $(document).ready(function() {
                $('.pics').cycle({
                    fx: 'toss',
                    next:	 '#next', 
                    prev:	 '#prev' 
                });
			
                // Datepicker
                $('#datepicker').datepicker({
                    inline: true
                });
			
            });
        </script>
    </body>
</html>