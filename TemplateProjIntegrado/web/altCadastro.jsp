<%-- 
    De modo semelhante à página de consultas, esta página deve 
    exibir as opções de alteração (entidade, tipo ou categoria)

    : falta arrumar as divs que indicam qual alteração será feita
        - alt. entidade, tipo, categoria

--%>

<%@page import="modelo.UsuarioBean"%>
<%@page contentType="text/html" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html lang="en">
    <%@include file="include_files/head.jsp" %>
    <body>
        <% //Recupera a Session
            try {
                HttpSession sessao = request.getSession(false);
                UsuarioBean log = null;
                if (sessao != null) {
                    log = (UsuarioBean) sessao.getAttribute("Usuario");
                    String tipo = log.getTipo();
            if (tipo.equals("Colaborador")) {
        %>   
                <jsp:include page="include_files/colabHeaderAlt.jsp" />  
        <% 
            } else if (tipo.equals("Administrador")) {
        %>   
                <jsp:include page="include_files/adminHeaderAlt.jsp" />  
            <%} }   
           } catch (NullPointerException e) {
                 response.sendRedirect("oops.jsp");
            }%> 

    
        <section id="content"> 
            <div class="middle">
                <div class="container">
                    <h2>Insira os Dados à Serem Alterados</h2>
                    <br>(*) = Preenchimento Obrigatório
                    <form id="search-form" method="post" action="">
                        <br><br><br>Nome Completo * :<br><input name="cadNome" id="cadNome" type="text" size="25" />
                        <br><br> E-Mail  :<br><input name="cadEMail" id="cadEMail" type="text" size="25" />
                        <br><br> Senha  :<br><input name="cadSenha" id="cadSenha" type="password" maxlength="20" size="25" />
                        deve conter no mínimo 6 dígitos
                        <br><br><br> Corfimar a Senha  :<br><input name="cadRSenha" id="cadRSenha" type="password" maxlength="20" size="25" />
                        <br><br> Data de nascimento  :<br><input name="cadData" id="cadData" type="text" size="10"/>
                        dd/mm/aaaa
                        <br><br><br> <input type="button" value="Cadastrar" onclick="VerificaAltCadastro();" /> 
                    </form>
                </div>
            </div>
            <%@include file="include_files/bottom.jsp" %>
        </section>
        <%@include file="include_files/footer.jsp" %>
    </body>
</html>
