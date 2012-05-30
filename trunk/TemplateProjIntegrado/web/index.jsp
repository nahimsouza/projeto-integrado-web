<%-- 
    Pagina Inicial do site
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
		<nav>
			<div class="container">
				<div class="wrapper">
					<h1><a href="index.jsp"><b>Chico</b>Base</a></h1>
					<ul>
						<li><a href="index.jsp" class="current">início</a></li>
						<li><a href="consulta.jsp">consultas</a></li>
                                        <!--    <li><a href="index-1.html">inserção</a></li>
						<li><a href="index-2.html">alteração</a></li>
						<li><a href="index-3.html">remoção</a></li>
                                                <li><a href="index-1.html">usuarios</a></li> 
                                        -->     <li><a href="javascript:" onclick="abrirPag('cadUsuario.html')">Cadastre-se</a></li>
                                                <li><a href="index-1.html">sobre</a></li>
					</ul> 
				</div>
			</div>
		</nav>
		<section class="adv-content">
			<div class="container">
				<ul class="breadcrumbs">
					<li>Início</li>
				</ul>
                                <form id="email-form" method="post" action="ValidarLogin" >
					<fieldset>
                                                email <input type="text" value="" name="email"><!--<input type="submit" value="">-->
                                                senha <input type="password" value="" name="senha">
                                                <input type="submit" value="ir"/>
                                                <input type="hidden" name="tipo" value="login">
					</fieldset>
				</form>
			</div>
		</section><div class="ic">More Website Templates at TemplateMonster.com!</div>
	</header>
	<section id="content">
		<div class="top">
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
            <!--
		<div class="middle">
			<div class="container">
				<div class="wrapper">
					<div class="grid3 first">
						<ul class="categories">
							<li><a href="#">Aerospace</a></li>
							<li><a href="#">Automotive</a></li>
							<li><a href="#">Chemicals</a></li>
							<li><a href="#">Communications</a></li>
							<li><a href="#">Consumer Products</a></li>
							<li><a href="#">Education and Research</a></li>
							<li><a href="#">Engineering and Construction</a></li>
							<li><a href="#">High Technology</a></li>
							<li><a href="#">Industrial Manufacturing</a></li>
						</ul>

            </div>
					<div class="grid9">
						<h2>Grow service revenue with world-class<br /> lifecycle service and support.</h2>
						<p>Fusce euismod consequat ante. Lorem ipsum dolor sit amet, consectetuer adipiscing elit. Pellentesque sed dolor. Aliquam congue fermentum nisl. Mauris accumsan nulla vel diam. Sed in lacus ut enim adipiscing aliquet. Nulla venenatis. In pede m aliquet sit amet, euismod in, auctor ut, ligula. Aliquam dapibus tincidunt metus. Praesent justo dolor, lobortis quis, lobortisissim, pulvinar ac, lorem. Vestibulum sed ante. Donec sagittis euismod purus.Lorem ipsum dolor sit amet, consectetuer adipiscing elit. Praesent vestibulum molestie lacus. Aenean nonummy hendrerit mauris. Phasellus porta. </p>
						<p><a href="#" class="more">Read More</a></p>
						<section class="images">
							<figure><a href="#"><img src="images/1page-img1.jpg" alt=""></a></figure>
							<figure><a href="#"><img src="images/1page-img2.jpg" alt=""></a></figure>
							<figure><a href="#"><img src="images/1page-img3.jpg" alt=""></a></figure>
						</section>
					</div>
				</div>

            </div>
		</div>
            -->
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