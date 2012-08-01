<%-- 
    Página de Consulta de Entidades
--%>

<%--
        <section id="content">
        <div>
            <div class="container">
                <div class="wrapper">
                    <div class="grid9" id="conEntidade"> 


<%@page import="modelo.EntidadeBean" %>
<%@page import="java.util.*" %>


//  ESTÁ COM PROBLEMA NOS DOIS IMPORTS ACIMA: PRECSISA DO IMPORT POR CAUSA DAS LISTAS,
    MAS NÃO FUNCIONA NEM COM ELES E NEM SEM ELES.

    - A QUESTÃO É VER COMO FICARÁ O RETORNO DA CONSULTA, ISTO É, COMO MONTAR A 'VIEW'.

--%>

<%@page import="modelo.EntidadeBean" %>
<%@page import="java.util.*" %>



<h2>Consulta por Entidade</h2>
<p> 
<form id="search-form" method="post" action="VerificarSolicitacoes">
    <fieldset> 
        <input type="text" name="nomeEntidade" value="" />
        <input type="submit" value="Consultar" />
        <input type="hidden" value="conEntidade" name="acao" />
    </fieldset>
    <%--
    <%
    
        List<EntidadeBean> listaEntidade = (List<EntidadeBean>) request.getAttribute("entidadeBean");

        if (listaEntidade.isEmpty()) {

    %>
    <h2> Nenhum resultado encontrado </h2>
    <% } // fim do if
    else { // caso existam registros

    %>

    <h2> Entidades encontradas: </h2>
    <table border=1>
        <tr>
            <th> Displayname </th>
            <th> Descrição  </th>
        </tr>

        <% for (Iterator i = listaEntidade.iterator(); i.hasNext();) {
                    EntidadeBean l = (EntidadeBean) i.next();%>

        <tr>
            <td><%= l.getDisplayname()%></td>
            <td><%= l.getDescricao()%></td>
        </tr>
        <% }%>

    </table>
    <% }%> --%>
    <br />

</form>
</p>



<%--</div>
</div>

</div>
</div>
--%>