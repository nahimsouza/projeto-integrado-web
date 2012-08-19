
<%@page import="modelo.UsuarioBean"%>
<%@page import="modelo.CategoriaTipoBean"%>
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
        %>   
        <jsp:include page="include_files/colabHeaderAlt.jsp" />  
        <%        } else if (tipo.equals("Administrador")) {
        %>   
        <jsp:include page="include_files/adminHeaderAlt.jsp" />  
        <%}
                }
            } catch (NullPointerException e) {
                response.sendRedirect("oops.jsp");
                }%>

    <section id="content"><%-- inserido --%>
        <div class="middle"><%-- inserido --%>
            <div class="container"><%-- inserido --%>
                <div class="wrapper"><%-- inserido --%>

                    <h2>Alterar Tipo</h2>

                    <form id="search-form" method="post" action="VerificarSolicitacoes">
                        <fieldset> 
                            (*) = Preenchimento obrigatório<br><br>
                            Tipo* <br />
                            <% String temp []= session.getAttribute("Tipo").toString().split("/");
                            out.println("<input type='text' id='ntipo' value="+ temp[1] + "/>");%>
                            <input type="submit" value="Alterar"  />
                            <input type="hidden" value="altResultadoTipo" name="acao"/>

                        </fieldset>
                    </form>

                </div><%-- inserido --%>
            </div><%-- inserido --%>
        </div><%-- inserido --%>

        <%@include file="include_files/bottom.jsp" %><%-- inserido --%>
    </section><%-- inserido --%>
    <%@include file="include_files/footer.jsp" %><%-- inserido --%>
</body>
</html>





