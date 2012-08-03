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
							<li><a href="http://www.google.com.br">Google</a></li>
							<li><a href="http://www.bing.com">Bing</a></li>
							<li><a href="http://www.wikipedia.com">Wikipedia</a></li>
							<li><a href="http://www.ufscar.br">UFSCar</a></li>
							<li><a href="http://www.moodle.ufscar.br">Moodle</a></li>
							<li><a href="http://www.w3c.com">World Wide Web Consortium</a></li>
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