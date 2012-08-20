<%@page import="java.util.List"%>
<h2>Inserir Categoria</h2>

<form id="search-form" method="post" action="VerificarSolicitacoes">
    <fieldset> 
        (*) = Preenchimento obrigatório<br><br>
        Categoria* <br />
        <input type="text" id="ncateg" onblur="document.getElementById('catnome').value = this.value;"/>
        <input type="button" value="Adicionar" onclick="VerificaCatIns();" />

        <br /><br />
        <select id="listaCategorias" name="listaCategorias" size="5">
            <%
                List<String> lista_a = ( List<String>) request.getSession().getAttribute("list_cat");
                if(lista_a != null){ 
                    for(String i : lista_a){
            %>
            <option value='<%=i%>' SELECTED><%=i%></option>               
            <% } } %>
        </select>

        <input type="button" value="Remover" onclick="catListRemove();" />
       
        <br /><br /> 
        <input type="button" value="Confirmar" onclick="VerificaCategoria()" />
        <input type="hidden" value="insCategoria" name="acao"/>
        
    </fieldset>
</form>