
<h2>Consulta Avançada</h2>
<p> 
<form id="search-form" method="post" action="VerificarSolicitacoes">
    <fieldset> 
        Pertence ao tipo  <br />
        <select id="catP" name="catP" onchange="chamaServletConsulta(carregaTiposConsultaP,'carregaTiposConsulta','catP')">
        </select> 
        <br />
        <select id="tipoP" name="tipoP">
        </select> 

        <br /><br />

        Não pertence ao tipo  <br />
        <select id="catNP" name="catNP" onchange="chamaServletConsulta(carregaTiposConsultaNP,'carregaTiposConsulta','catNP')">
        </select>
        <br />
        <select id="tipoNP" name="tipoNP">
        </select> 

        <br /><br />
        <input type="submit" value="Consultar">
        <input type="hidden" value="conAvancada" name="acao" />
    </fieldset>
</form>