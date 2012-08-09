<%-- 
    Página de Consulta de Usuários

    : falta criar os campos

--%>


	<section id="content">
      	<div>
            <div class="container">
		<div class="wrapper">
                    <div class="grid9" id="conUsuario" >
			<h2>Consultar Usuários</h2>
                        <h3>Digite o email do usuário</h3>
                        <p> 
                            <form id="search-form" method="post" action="VerificarSolicitacoes">
                                <fieldset> 
                                    <input type="text" name="email" value="">
                                    <input type="submit" value="Consultar">
                                    <input type="hidden" name="acao" value ="consUsuarioEmail">
                                </fieldset>
                            </form>
                        </p>
                    </div>
        	</div>
		
            </div>
	</div>
