<h2>Inserir Categoria</h2>

<form id="search-form">
    <fieldset> 

        Categoria: <br>
        <input type="text" id="ncateg" />
        <input type="button" value="Adicionar" onclick="catListInsere();"/>

        <br /><br />
        <select id="listaCategorias"  size="5">
        </select>

        <input type="button" value="Remover" onclick="catListRemove();"/>
        
        <br /><br />
        <input type="submit" value="Confirmar">
    </fieldset>
</form>
