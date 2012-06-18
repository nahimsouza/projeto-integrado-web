<%-- 
    Página de Inserção de Entidades

    : falta criar os campos

--%>

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
                            <h2>Inserir Entidade</h2>
                            <p> 
                            <form id="search-form">
                                Displayname <br> <input id="displayname" name="displayname" type="text" size="50" maxlength="50"/>
                                <br><br> Descrição <br> <textarea id="description" cols="35" rows="5"></textarea>
                                <br><br> Wikikey <br><input id="wiki" type="text" size="28" maxlength="30"/> <input type="button" value="Adicionar" onclick="wikiListInsere();"/>
                                <br><br><select id ="wikis" name="wikis" size="5">

                                </select>
                                <input type="button" value="Remover" onclick="wikiListRemove()"/>

                                <br><br>Categoria/Tipo<br> <!-- Precisa pegar do BD -->
                                <select id="categoria" name="tipo">

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
                            </p>
                        </div>
                    </div>

                </div>
            </div>
    </body>
</html>
