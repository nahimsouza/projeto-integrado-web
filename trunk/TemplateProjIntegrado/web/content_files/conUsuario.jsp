
<h2>Consultar Usu�rios</h2>
<h3>Digite o email do usu�rio</h3>
<p> 
<form id="search-form" name="conUsuario" method="post" action="VerificarSolicitacoes">
    <fieldset> 
        <input type="text" name="email" id="email" value="">
        <input type="button" value="Consultar" onclick="VerificaEMail();" />
        <input type="hidden" name="acao" value ="consUsuarioEmail">
    </fieldset>
</form>
