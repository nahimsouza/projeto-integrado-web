
<h2>Consulta Avan�ada</h2>
<p> 
<form id="search-form" method="post" action="VerificarSolicitacoes" onclick="chamaServlet(carregaTiposConsulta,'carregaTiposConsulta')">
    <fieldset> 

        Pertence ao tipo  <br />
        <select id="tipoP" name="catIn">
        </select> 

        <br /><br />
        
        N�o pertence ao tipo  <br />
        <select id="tipoNP" name="catNot">
        </select>
        
        <br /><br />
        <input type="submit" value="Consultar">
        <input type="hidden" value="conAvancada" name="acao" />
    </fieldset>
</form>