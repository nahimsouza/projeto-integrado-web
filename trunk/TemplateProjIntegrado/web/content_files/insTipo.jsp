
<%@page import="java.util.List"%>
<%@page import="java.util.ArrayList"%>
<h2>Inserir Tipo</h2>
<p> 
    
    <%
            List<String> list_aux = new ArrayList<String>();
            request.getSession().setAttribute("list_aux", list_aux);
    %>
    
<form id="search-form" method="post" action="VerificarSolicitacoes" onload="chamaServlet(carregaCategorias,'carregaCategorias')">
    <fieldset> 
        (*) = Preenchimento obrigatório<br><br>
        Categoria*<br />
        <select id="categ" name="categ">
        </select>

        <br /><br />
        Tipo* <br />

        <input type="text" id="ntipo" name="display" />
        <input type="button" value="Adicionar" onclick="VerificaIns();
        
        <%
            String tipo_lista = request.getParameter("display");
            if(tipo_lista != ""){
                List<String> list = (List<String>)request.getSession().getAttribute("list_aux");
                String categoria_lista = request.getParameter("categ");
                list.add(categoria_lista + "," + tipo_lista);
                request.getSession().setAttribute("list_aux", list);
            }
        %>

        "/>
        
        <br /><br />
        <select id ="categoriass" name="categorias" size="5" >
        </select>

        <input type="button" value="Remover" onclick="tipoCatListRemove();"/>

        <br /><br />
        
        <input type="button" value="Confirmar" onclick="VerificaTipo()" />

    </fieldset>
</form>