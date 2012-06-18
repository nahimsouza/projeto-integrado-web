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
            <%@include file="colabHeader.jsp" %>
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
            
            <%@include file = "bottom.jsp" %>
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