<%@page import="javax.swing.text.Document"%>
<%@page import="sun.swing.PrintColorUIResource"%>
<%@page import="modelo.UsuarioBean"%>
<%@page language="java" contentType="text/html; charset=ISO-8859-1"
        pageEncoding="ISO-8859-1"%>
<%@page import="modelo.EntidadeBean" %>
<%@page import="java.util.*" %>

<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
    <%@include file="include_files/head.jsp" %> <%-- inserido --%>
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
                    } else if (tipo.equals("Administrador")) {
        %>   
        <jsp:include page="include_files/adminHeaderUsuario.jsp" />  
        <%}
                }
            } catch (NullPointerException e) {
                response.sendRedirect("oops.jsp");
            }%>
    <section id="content"><%-- inserido --%>
        <div class="middle"><%-- inserido --%>
            <div class="container"><%-- inserido --%>
                <div class="wrapper"><%-- inserido --%> 
                    <form id="search-form" action="ValidarUsuario" method="post">
                        <%
                            UsuarioBean objUsuario = (UsuarioBean) request.getAttribute("UsuarioBean");

                            if (objUsuario == null) {

                        %>
                        <h2> Ação Ineficaz </h2>
                        <% } else {%>

                        <h2> Dados Usuário: </h2>

                        <p> Nome: <%=objUsuario.getNome()%> </p>
                        <p> e-mail: <%=objUsuario.getEmail()%> </p>
                        <p> Data Nascimento: <%=objUsuario.getDataNasc()%> </p>
                        <%
                            }
                        %>
                        
                        <input type="button" value="Alterar senha" onClick="acaoAlterarSenha()">
                        <input type="button" value="Excluir usuário" onClick="acaoExcluirUsuario()">
                        
                    </form>
                    
                    <div id="teste" name="teste"><br><br>
                        <p><a href="usuarios.jsp"> Nova Consulta </a> </p>
                    </div>
                </div><%-- inserido --%>
            </div><%-- inserido --%>
        </div><%-- inserido --%>

        <%@include file="include_files/bottom.jsp" %><%-- inserido --%>
    </section><%-- inserido --%>
    <%@include file="include_files/footer.jsp" %><%-- inserido --%>
</body>
</html>



