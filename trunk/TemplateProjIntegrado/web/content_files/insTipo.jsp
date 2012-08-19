
<h2>Inserir Tipo</h2>
<p> 
<form id="search-form" method="post" action="VerificarSolicitacoes" onload="chamaServlet(carregaCategorias,'carregaCategorias')">
    <fieldset> 
        (*) = Preenchimento obrigatório<br><br>
        Categoria*<br />
        <select id="categ" name="categ">
        </select>

        <br /><br />
        Tipo* <br />

        <input type="text" id="ntipo" name="display" />
        <input type="button" value="Adicionar" onclick="VerificaIns();"/>

        <br /><br />
        <select id ="categoriass" name="categorias" size="5" >
        </select>

        <input type="button" value="Remover" onclick="tipoCatListRemove();"/>

        <br /><br />
        
        <input type="button" value="Confirmar" onclick="VerificaTipo()" />

    </fieldset>
</form>