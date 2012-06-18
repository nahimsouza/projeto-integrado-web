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
                        <div class="grid9" id="insEntidadeE">
                            <h2>Inserir Entidade</h2>
                            <p> 
                            <form id="search-form">
                                <fieldset> 
                                    <table>
                                        <tr>
                                            <td>
                                                Dysplayname: 
                                            </td>
                                            <td> 
                                                <input id="displayname" name="displayname" type="text" size="30" maxlength="30" onmouseover="helpText(9)" onmouseout="helpText(12)"/>
                        
                                            </td>
                                        </tr>
                                        <tr>
                                            <td>
                                                <label>Description: </label>
                                            </td>
                                            <td>
                                                <textarea id="description" cols="35" rows="5" onmouseover="helpText(10)" onmouseout="helpText(12)"></textarea>
                                            </td>
                                        </tr>
                                        <tr>
                                            <td>
                                                Wikikey: 
                                            </td>
                                            <td>
                                                <input id="wiki" type="text" size="28" maxlength="30" onmouseover="helpText(11);" onmouseout="helpText(12)"/>
                                                <input type="button" value="Adicionar" onclick="wikiListInsere();"/>
                                            </td>
                                        </tr>
                                        <tr>
                                            <td>
                    
                                            </td>
                                            <td>
                                                <select id ="wikis" name="wikis" size="5">
                        
                                                </select>
                                                <input type="button" value="Remover" onclick="wikiListRemove()"/>
                                            </td>
                                        </tr>
                                        <tr>
                                            <td>
                                                Categoria:
                                            </td>
                                            <td> 
                                                <select id="categoria" name="tipo" onmouseover="helpText(13)" onmouseout="helpText(12)">
                                                    <option value="tipo1">tipo1</option>
                                                    <option value="tipo2">tipo2 </option>
                                                    <option value="tipo3">tipo3 </option>
                                                    <option value="tipo4">tipo4 </option>
                                                </select>
                                            </td>
                                        </tr>
                                        <tr>
                                            <td>Tipo:
                                            </td>
                                            <td>
                                                <select id="tipo" name="tipo" onmouseover="helpText(14)" onmouseout="helpText(12)">
                                                    <option value="tipo1">tipo1</option>
                                                    <option value="tipo2">tipo2 </option>
                                                    <option value="tipo3">tipo3 </option>
                                                    <option value="tipo4">tipo4 </option>
                                                </select>
                                                <input type="button" name="tipoButton" value="OK" onclick="tipoListInsere();"/>
                                            </td>
                                        </tr>
                                        <tr>
                                            <td>
                                            </td>
                                            <td>
                                                <select id="listaTipos" name="tipos" size="5">
                        
                                                </select>
                                                <input type="button" value="Remover" onclick="tipoListRemove();"/>
                                            </td>
                                        </tr>
                                        <tr>
                                            <td>
                    
                                            </td>
                    
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