<%-- 
    Página do administrador para consultar usuários

    : falta modificar as páginas de solicitacoes e consultas
        - arrumar as divs

--%>

<%@page import="modelo.UsuarioBean"%>
<%@page import="java.util.List"%>
<%@page import="java.util.Iterator"%>
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
                        response.sendRedirect("oops.jsp");
                    } else if (tipo.equals("Administrador")) {%>
        <jsp:include page="include_files/adminHeaderUsuario.jsp" />
        <% }
                }
            } catch (NullPointerException e) {
                response.sendRedirect("oops.jsp");
            }%> 

        <section id="content">
            <div class="middle">
                <div class="container">
                    <div class="wrapper">
                        <div class="grid3 first">
                            <ul class="categories">
                                <li><a href="usuarios.jsp" onclick="showDiv( 'solicitacoes', false);
                                    showDiv( 'conUsuario', false );">Novas Solicitações</a></li>

                                <li><a href="javascript:void(0)" onclick="showDiv( 'solicitacoes', false );
                                    showDiv( 'conUsuario', true );">Consultar Usuários</a></li>
                            </ul>
                        </div>
                        <div class="grid9" id="solicitacoes">
                            <section id="content">
                                <div>
                                    <div class="container">
                                        <div class="wrapper">
                                            <div class="grid9" id="conEntidade" style="display: none">
                                                <h2>Operação realizada com sucesso!</h2>
                                                <p><h3><a href="viewSolicitacoes.jsp"> Voltar à página de solicitações </a></h3> </p>
                                            </div>
                                        </div>

                                    </div>
                                </div>


                        </div>
                        
                        <div class="grid9" id="consulta" style="display: none">
                            <%@include file="content_files/conUsuario.jsp" %>
                        </div>
                        <div class="grid9" id="conUsuario" >
                            <form id="search-form" action="ValidarUsuario" method="post">
                                <input type="hidden" name="tipo" id="tipo" >
                                <input type="hidden" name="user" id="user" >
                                <%
                                    UsuarioBean objUsuario = (UsuarioBean) request.getAttribute("UsuarioBean");

                                    if (objUsuario == null) {

                                %>
                                <h2> Usuário não encontrado! </h2>
                                <% } else {%>

                                <h2> Dados Usuário: </h2>

                                <p> Nome: <%=objUsuario.getNome()%> </p>
                                <p> e-mail: <%=objUsuario.getEmail()%> </p>
                                <p> Data Nascimento: <%=objUsuario.getDataNasc()%> </p>


                                <input type="button" value="Alterar senha" onClick="alterarSenha('<%=objUsuario.getEmail()%>')">
                                <input type="button" value="Excluir usuário" onClick="excluirUsuario('<%=objUsuario.getEmail()%>')">
                                <%
                                    }
                                %>
                            </form>

                            <div id="teste" name="teste"><br><br>
                                <p><h3><a href="javascript:void(0)" onclick="showDiv( 'conUsuario', false );
                                    showDiv( 'consulta', true );"> Nova Consulta </a></h3> </p>
                            </div>
                        </div><%-- inserido --%>
                    </div><%-- inserido --%>
                </div>
            </div>
        </div>
    </div>
    <%@include file="include_files/bottom.jsp" %>
</section>
<%@include file="include_files/footer.jsp" %>
</body>
</html>
