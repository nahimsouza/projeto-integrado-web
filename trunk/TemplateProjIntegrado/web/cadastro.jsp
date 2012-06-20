<%-- 
    Página do cadastro de usuários

    : falta criar os campos

--%>

<%@page contentType="text/html" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html lang="en">
    <%@include file="head.jsp" %>

    <body>
        <%@include file="colabHeader.jsp" %>


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
            <%@include file="bottom.jsp" %>
        </section>
        <%@include file="footer.jsp" %>
        <script type="text/javascript">
            $(document).ready(function() {
                $('.pics').cycle({
                    fx: 'toss',
                    next:	 '#next', 
                    prev:	 '#prev' 
                });
			
                // Datepicker
                $('#datepicker').datepicker({
                    inline: true
                });
			
            });
        </script>
    </body>
</html>
