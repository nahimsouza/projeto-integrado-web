<%-- 
    Página de Inserção de Tipos

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
                    <div class="grid9" id="insTipo">
                        <h2>Inserir Tipo</h2>
                        <p> 
                        <form id="search-form">
                            <fieldset> 
                                <p>
                                    Tipo: <input type="text" id="ntipo" name="display" onmouseover="helpText(16)" onmouseout="helpText(12)"/>
                                </p>
                                <p> Categoria:
                                    <select id="categ" name="categ" onmouseover="helpText(13)" onmouseout="helpText(12)">
                                        <option> Selecione uma categoria </option>
                                        <option> Sports </option>
                                        <option> Music </option>
                                        <option> Book </option>
                                        <option> History </option>
                                    </select>
                    
                                </p>
                                <p>
                                   <input type="submit" value="Confirmar">
                                </p>
                               
                            </fieldset>
                        </form>
                        </p>
                    </div>
                </div>
		
            </div>
	</div>
</body>
</html>