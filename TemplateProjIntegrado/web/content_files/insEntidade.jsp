
<%@page import="java.util.List"%>
<%@page import="java.util.ArrayList"%>
<h2>Inserir Entidade</h2>
<p> 

    <%
        List<String> l = (List<String>) request.getSession().getAttribute("list_aux");
        if(l == null){
            List<String> list_aux = new ArrayList<String>();
            request.getSession().setAttribute("list_aux", list_aux);
        }
    %>
<form id="search-form" action="VerificarSolicitacoes" method="post">
    (*) = Preenchimento obrigatório
    <br /><br />
    Displayname (nome da entidade) * <br /> 
    <input id="displayname" name="displayname" type="text" size="50" maxlength="50"/>
    <br /><br /> 

    Descrição <br /> <textarea id="description" name ="descricao" cols="35" rows="5"></textarea>
    <br /><br /> 

    Wikikey <br /><input id="wiki" name="wikikey" type="text" size="28" maxlength="30"/> <input type="button" value="Adicionar" onclick="wikiListInsere();"/>
    <br /><br />
    <select id ="wikis" name="wikis" size="5">
    </select>
    <input type="button" value="Remover" onclick="wikiListRemove()"/>

    <br /><br />Categoria/Tipo * <br /> <!-- Precisa pegar do BD -->

    <select id="categoria" name="categoria" onchange="chamaServlet(carregaTipos,'carregaTipos')">

    </select>

    <!-- Precisa pegar do BD -->
    <select id="tipo" name="tipo">

    </select>
    <input type="button" name="tipoButton" value="Adicionar" onclick="tipoListInsere();"/>
    <br /><br />
    <select id="listaTipos" name="tipos" size="5">
    </select>
    <input type="button" value="Remover" onclick="tipoListRemove();"/>

    <br /><br /><br /><br />
    <input type="hidden" name="acao" id="acao" value="insEntidade" />
    <input type="hidden" name="tipoid" id="tipoid" />
    <input type="hidden" name="catid" id="catid" />
    <input type="hidden" name="catnome" id="catnome" />
    <input type="hidden" name="selected" id="selected" />
    <input type="hidden" name="metodo" id="metodo" />
    <input type="button" value="Confirmar" onclick="inserirEntidade();"/>
    <input type="reset" value="Cancelar" />
</form>
