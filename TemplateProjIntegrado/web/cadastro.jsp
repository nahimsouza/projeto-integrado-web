<%@page contentType="text/html" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html lang="en">
    <%@include file="include_files/head.jsp" %>

    <body>
        <%@include file="include_files/userHeader.jsp" %>


        <section id="content"> 
            <div class="middle">
                <div class="container">
                    <h2>Insira seus Dados</h2>
                    <div class="grid12">* Preenchimento Obrigatório</div>
                    <form id="search-form">
                        <br>Nome Completo * :<br><input id="cadNome" type="text" size="25" />
                        <br><br> E-Mail * :<br><input id="cadEMail" type="text" size="25" />
                        <br><br> Senha * :<br><input id="cadSenha" type="password" maxlength="20" size="25" />
                        <br><br> Corfimar a Senha * :<br><input id="cadRSenha" type="password" maxlength="20" size="25" />
                        <br><br> Data de nascimento * :<br><input id="cadData" type="text" size="10"/>
                        <br><br> <input type="button" value="Cadastrar" onclick="VerificaCadastro();" />
                    </form>
                </div>
            </div>
            <%@include file="include_files/bottom.jsp" %>
        </section>
        <%@include file="include_files/footer.jsp" %>
    </body>
</html>
