
<h2>Inserir Entidade</h2>
<p> 
<form id="search-form">
    Displayname <br> <input id="displayname" name="displayname" type="text" size="50" maxlength="50"/>
    <br><br> Descri��o <br> <textarea id="description" cols="35" rows="5"></textarea>
    <br><br> Wikikey <br><input id="wiki" type="text" size="28" maxlength="30"/> <input type="button" value="Adicionar" onclick="wikiListInsere();"/>
    <br><br><select id ="wikis" name="wikis" size="5">

    </select>
    <input type="button" value="Remover" onclick="wikiListRemove()"/>

    <br><br>Categoria/Tipo<br> <!-- Precisa pegar do BD -->
    
    <select id="categoria" name="categoria"  onchange="chamaServlet(carregaTipos,'carregaTipos')">
 
    </select>
    
    <!-- Precisa pegar do BD -->
    <select id="tipo" name="tipo">

    </select>
    <input type="button" name="tipoButton" value="Adicionar" onclick="tipoListInsere();"/>
    <br><br><select id="listaTipos" name="tipos" size="5">

    </select>
    <input type="button" value="Remover" onclick="tipoListRemove();"/>

    <br><br><br><br>
    <input type="submit" value="Confirmar" onclick="inserirEntidade();"/>
    <input type="reset" value="Cancelar" />
</form>
