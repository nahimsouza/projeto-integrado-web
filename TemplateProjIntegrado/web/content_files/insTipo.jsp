
<%@page import="java.util.List"%>
<%@page import="java.util.ArrayList"%>
<h2>Inserir Tipo</h2>
<p> 
    
<form id="search-form" method="post" action="VerificarSolicitacoes" onload="chamaServlet(carregaCategorias,'carregaCategorias'); "/>
    <fieldset> 
        (*) = Preenchimento obrigatório<br><br>
        Categoria*<br />
        <select id="categ" name="categ" onblur="document.getElementById('catid').value = this.selectedIndex; document.getElementById('catnome').value = this[this.selectedIndex].value; "/>
        </select>

        <br /><br />
        Tipo* <br />

        <input type="text" id="ntipo" name="display" onblur="document.getElementById('tipoid').value = this.value; "/>
        <input type="button" value="Adicionar" onclick="VerificaIns(); "/>
        <br /><br />
        <select id ="categoriass" name="categorias" size="5" >
            <%
                List<String> lista_a = ( List<String>) request.getSession().getAttribute("list_aux");
                if(lista_a != null){ 
                    for(String i : lista_a){
                        String[] a = i.split(",");
                        String b = "/"+a[2]+"/"+a[1];
            %>
            <option value='<%=i%>' SELECTED><%=b%></option>               
            <% } } %>
        
        </select>

        <input type="button" value="Remover" onclick="tipoCatListRemove();"/>

        <br /><br />
        
        <input type="button" value="Confirmar" onclick="VerificaTipo();" />

    </fieldset>
</form>