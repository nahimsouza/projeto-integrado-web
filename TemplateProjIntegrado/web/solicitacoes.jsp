<%-- 
    Página de Solicitações para ser colaborador

    : falta criar os campos

--%>

<%@page import="java.util.Iterator"%>
<%@page import="modelo.UsuarioBean"%>
<%@page import="java.util.List"%>
<%@page contentType="text/html" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html lang="en">
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <title>ChicoBase</title>
        <meta charset="utf-8">
        <link rel="stylesheet" href="css/reset.css" type="text/css" media="all">
        <link rel="stylesheet" href="css/grid.css" type="text/css" media="all">
        <link rel="stylesheet" href="css/style.css" type="text/css" media="all">
        <link rel="stylesheet" href="css/jquery-ui-1.8.5.custom.css" type="text/css" media="all">
        <script type="text/javascript" src="js/jquery-1.4.2.min.js" ></script>
        <script type="text/javascript" src="js/jquery.cycle.all.js"></script>
        <script type="text/javascript" src="js/jquery-ui-1.8.5.custom.min.js"></script>
        <script type="text/javascript" src="js/my-javascript.js"></script>
        <!--[if lt IE 9]>
                <script type="text/javascript" src="js/html5.js"></script>
        <![endif]-->
    </head>

    <body>
        <section id="content">
            <div>
                <div class="container">
                    <div class="wrapper">
                        <div class="grid9" id="conEntidade">
                            <h2>Novas Solicitações</h2>
                            <p> 
                            <form id="search-form">
                                <fieldset> 
                                    <%
                                        if(request.getAttribute("usuarioBean") == null){ %>
                                            <h3> Não existem usuários pendentes!! </h3>
                                        <%}else{
                                        List<UsuarioBean> listaUsuario = (List<UsuarioBean>) request.getAttribute("usuarioBean");

                                        if (listaUsuario.isEmpty()) {

                                    %>
                                    <h2> Não existem usuários pendentes!! </h2>
                                    <% } // fim do if
                                    else { // caso existam registros

                                    %>

                                    <h2> Usuários pendentes: </h2>
                                    <table border=1>
                                        <tr>
                                            <td> Login </td>
                                        </tr>

                                        <% for (Iterator i = listaUsuario.iterator(); i.hasNext();) {
                                            UsuarioBean l = (UsuarioBean) i.next();%>

                                        <tr>
                                            <td><%= l.getLogin() %></td>

                                        </tr>
                                        <% }%>

                                    </table>
                                    <% }}%>
                                </fieldset>
                            </form>
                            </p>
                        </div>
                    </div>

                </div>
            </div>
    </body>
</html>