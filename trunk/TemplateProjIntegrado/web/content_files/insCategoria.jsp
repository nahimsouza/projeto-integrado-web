<%-- 
    Página de Inserção de Categorias

    : falta criar os campos

--%>

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
                                        Categoria: <br><input type="text" id="ncateg" />
                                        <input type="button" value="Adicionar" onclick="catListInsere();"/>
                                    </p>
                                    <table>

                                        <tr>

                                            <td>
                                                <select id="listaCategorias"  size="5">

                                                </select>
                                                <input type="button" value="Remover" onclick="catListRemove();"/>
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