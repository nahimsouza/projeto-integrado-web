<%-- 
    Página de Inserção de Categorias

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
                        <div class="grid9" id="insCategoria">
                            <h2>Inserir Categoria</h2>
                            <p> 
                            <form id="search-form">
                                <fieldset> 
                                    <p>
                                        Categoria: <input type="text" id="ncateg" name="display" onmouseover="helpText(15);" onmouseout="helpText(12)"/>
                                        <input type="button" value="Adicionar"/>
                                    </p>
                                    <table>

                                        <tr>

                                            <td>
                                                <select id="listaCategorias" name="tipos" size="5">

                                                </select>
                                                <input type="button" value="Remover" />
                                            </td>
                                        </tr>
                                        <tr>
                                            <td>
                                                <input type="submit" value="Confirmar">
                                            </td>
                                        </tr>
                                    </table>

                                </fieldset>
                            </form>
                            </p>
                        </div>
                    </div>

                </div>
            </div>
    </body>
</html>