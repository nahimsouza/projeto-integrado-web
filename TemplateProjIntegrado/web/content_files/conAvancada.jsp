
<h2>Consulta Avançada</h2>
<p> 
<form id="search-form" method="post" action="VerificarSolicitacoes">
    <fieldset> 

        Pertence ao tipo 
        <select id="tipoP" name="catIn">
            <option value=""> Selecione um tipo </option>
            <option value="sports"> Sports </option>
            <option value="music"> Music </option>
            <option value="book"> Book </option>
            <option value="history"> History </option>
        </select> 
        Não pertence ao tipo 
        <select id="tipoNP" name="catNot">
            <option value=""> Selecione um tipo </option>
            <option value="sports"> Sports </option>
            <option value="music"> Music </option>
            <option value="book"> Book </option>
            <option value="history"> History </option>
        </select>
        <input type="submit" value="Consultar">
        <input type="hidden" value="conAvancada" name="acao" />
    </fieldset>
</form>