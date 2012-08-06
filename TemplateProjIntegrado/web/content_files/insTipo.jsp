
<h2>Inserir Tipo</h2>
<p> 
<form id="search-form">
    <fieldset> 
        Categoria:<br />
        <select id="categ" name="categ" onchange="chamaServlet(carregaCategorias,'carregaCategorias')"  >
        </select>

        <br /><br />
        Tipo: <br />

        <input type="text" id="ntipo" name="display" />
        <input type="button" value="Adicionar" onclick="tipoCatListInsere();"/>

        <br /><br />
        <select id ="categoriass" name="categorias" size="5" >
        </select>

        <input type="button" value="Remover" onclick="tipoCatListRemove();"/>

        <br /><br />
        <input type="submit" value="Confirmar">

    </fieldset>
</form>