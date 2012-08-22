
<%@page import="java.util.List"%>
<%@page import="java.util.ArrayList"%>
<h2>Inserir Entidade</h2>
<p> 

    <%
        List<String> l = (List<String>) request.getSession().getAttribute("list_aux");
        List<String> l2 = (List<String>) request.getSession().getAttribute("list_cat");
        if(l == null){
            List<String> list_aux = new ArrayList<String>();
            request.getSession().setAttribute("list_aux", list_aux);
        }
        if(l2 == null){
            List<String> list_cat = new ArrayList<String>();
            request.getSession().setAttribute("list_cat", list_cat);
        }

        String obj = (String)request.getSession().getAttribute("displayname");
        String z;
        if(obj!= null && obj != ""){
            z = obj;
        }else{
            z="";
        }
        
        String obj1 = (String)request.getSession().getAttribute("descricao");
        String q;
        if(obj1!= null && obj1 != ""){
            q = obj1;
        }else{
            q="";
        }

    %>
<form id="search-form" action="VerificarSolicitacoes" method="post">
    (*) = Preenchimento obrigatório
    <br /><br />
    Displayname (nome da entidade) * <br /> 
    <input id="displayname" name="displayname" type="text" size="50" maxlength="50" value="<%=z %>"/>
    <br /><br /> 

    Descrição <br /> <textarea id="description" name ="descricao" cols="35" rows="5"><%=q%></textarea>
    <br /><br /> 

    Wikikey <br /><input id="wiki" name="wikikey" type="text" size="28" maxlength="30" onblur="document.getElementById('catnome').value = this.value;" /> 
    <input type="button" value="Adicionar" onclick="VerificaWikiIns();"/>
    <br /><br />
    <select id ="wikis" name="wikis" size="5">
            <%
                List<String> lista_a = ( List<String>) request.getSession().getAttribute("list_cat");
                if(lista_a != null){ 
                    for(String i : lista_a){
            %>
            <option value='<%=i%>' SELECTED><%=i%></option>               
            <% } } %>
    </select>
    <input type="button" value="Remover" onclick="wikiListRemove()"/>

    <br /><br />Categoria/Tipo * <br /> <!-- Precisa pegar do BD -->

    <select id="categoria" name="categoria" onchange="chamaServlet2(carregaTipos, 'carregaTipos');" onblur="document.getElementById('catid').value = this.selectedIndex; document.getElementById('catnome').value = this[this.selectedIndex].value;" >

    </select>

    <!-- Precisa pegar do BD -->
    <select id="tipo" name="tipo" onblur="document.getElementById('tiponome').value = this[this.selectedIndex].value;">

    </select>
    <input type="button" name="tipoButton" value="Adicionar" onclick="VerificaListIns();"/>
    <br /><br />
    <select id="listaTipos" name="tipos" size="5">
            <%
                List<String> lista_b = ( List<String>) request.getSession().getAttribute("list_aux");
                if(lista_b != null){ 
                    for(String i : lista_b){
                        String[] a = i.split(",");
                        String b = "/"+a[2]+"/"+a[3];
            %>
            <option value='<%=i%>' SELECTED><%=b%></option>               
            <% } } %>
    </select>
    <input type="button" value="Remover" onclick="tipoListRemove();"/>

    <br /><br /><br /><br />
    <input type="hidden" name="acao" id="acao" value="insEntidade" />
    <input type="hidden" name="tipoid" id="tipoid" />
    <input type="hidden" name="tiponome" id="tiponome" />
    <input type="hidden" name="catid" id="catid" />
    <input type="hidden" name="catnome" id="catnome" />
    <input type="hidden" name="selected" id="selected" />
    <input type="hidden" name="metodo" id="metodo" />
    <input type="button" value="Confirmar" onclick="inserirEntidade();"/>
    <input type="reset" value="Cancelar" />
</form>
