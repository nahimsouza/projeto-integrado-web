
<%@page import="java.util.List"%>
<%@page import="java.util.ArrayList"%>
<h2>Inserir Tipo</h2>
<p> 
    
<form id="search-form" method="post" action="VerificarSolicitacoes" onload="chamaServlet(carregaCategorias,'carregaCategorias'); "/>
    <fieldset> 
        (*) = Preenchimento obrigatório<br><br>
        Categoria*<br />
        <select id="categ" name="categ" onblur="document.getElementById('catid').value = this[this.selectedIndex].value; "/>
        </select>

        <br /><br />
        Tipo* <br />

        <input type="text" id="ntipo" name="display" onblur="document.getElementById('tipoid').value = this.value; "/>
        <input type="button" value="Adicionar" onclick="VerificaIns(); "/>
        <br /><br />
        <select id ="categoriass" name="categorias" size="5" >
        </select>

        <input type="button" value="Remover" onclick="tipoCatListRemove();"/>

        <br /><br />
        
        <input type="button" value="Confirmar" onclick="VerificaTipo()" />

    </fieldset>
</form>