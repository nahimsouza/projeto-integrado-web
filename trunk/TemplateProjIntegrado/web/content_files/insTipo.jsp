<%-- 
    Página de Inserção de Tipos

    : falta criar os campos

--%>

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
                                    Categoria:<br>
                                    <select id="categ" name="categ" onmouseover="helpText(13)" onmouseout="helpText(12)">
                                        <option> Selecione uma categoria </option>
                                        <option> Sports </option>
                                        <option> Music </option>
                                        <option> Book </option>
                                        <option> History </option>
                                    </select>
                                </p>
                             
                                <table>  <tr>
                                    
                                <td> Tipo: <br><input type="text" id="ntipo" name="display" onmouseover="helpText(16)" onmouseout="helpText(12)"/>
                                    <input type="button" value="Adicionar" onclick="tipoCatListInsere();"/>
                                   
                                </td>
    </tr></tr>
                                        <tr>
                                                           
                                       
                                            <td>
                                                <select id ="categoriass" name="categorias" size="5" >
                        
                                                </select>
                                                <input type="button" value="Remover" onclick="tipoCatListRemove();"/>
                                            </td>
                                        </tr></table>
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