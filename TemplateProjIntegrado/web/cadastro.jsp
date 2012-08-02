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
                    <div class="grid12">(*) = Preenchimento Obrigatório <br>Datas devem estar no formato dd/mm/aaaa <br> A senha deve conter no mínimo 6 dígitos</div>
                    <form id="search-form" method="post" action="ValidarCadastro">
                        <br><br><br>Nome Completo * :<br><input name="cadNome" id="cadNome" type="text" size="25" />
                        <br><br> E-Mail * :<br><input name="cadEMail" id="cadEMail" type="text" size="25" />
                        <br><br> Senha * :<br><input name="cadSenha" id="cadSenha" type="password" maxlength="20" size="25" />
                        <br><br> Corfimar a Senha * :<br><input name="cadRSenha" id="cadRSenha" type="password" maxlength="20" size="25" />
                        <br><br> Data de nascimento * :<br><input name="cadData" id="cadData" type="text" size="10"/>
                        <br><br> <input type="button" value="Cadastrar" onclick="VerificaCadastro();" /> 
                    </form>
                </div>
            </div>
            <%@include file="include_files/bottom.jsp" %>
        </section>
        <%@include file="include_files/footer.jsp" %>
    </body>
</html>
