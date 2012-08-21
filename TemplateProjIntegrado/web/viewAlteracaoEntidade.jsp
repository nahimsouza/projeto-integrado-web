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
        %>   
        <jsp:include page="include_files/colabHeaderConsulta.jsp" />  
        <%        } else if (tipo.equals("Administrador")) {
        %>   
        <jsp:include page="include_files/adminHeaderConsulta.jsp" />  
        <%}
                }
            } catch (NullPointerException e) {%>
        <jsp:include page="include_files/userHeaderConsulta.jsp" />
        <% }%>


    <section id="content"><%-- inserido --%>
        <div class="middle"><%-- inserido --%>
            <div class="container"><%-- inserido --%>
                <div class="wrapper"><%-- inserido --%>
                    <input type="hidden" name="acao" id="acao" value="<%= request.getAttribute("tipoConsulta")%>" />
                    <%
                        List<EntidadeBean> listaEntidade = (List<EntidadeBean>) request.getAttribute("EntidadeBean");
                        int pag = request.getParameter("pag") == null ? 1 : Integer.parseInt(request.getParameter("pag"));
                        String displayname = request.getAttribute("dn").toString();
                        int totalLinhas = listaEntidade.size();
                        int limite = 10;
                        int totalPaginas = (totalLinhas % limite > 0) ? (totalLinhas / limite) + 1 : (totalLinhas / limite);

                        //out.println("olha aqui: " + totalPaginas);

                        if (listaEntidade == null) {

                    %>
                    <h2> Não existem itens cadastrados!!! </h2>
                    <% } // fim do if
                    else if (listaEntidade.isEmpty()) {

                    %>
                    <h2> Não existem itens cadastrados!!! </h2>
                    <% } // fim do if
                    else { // caso existam registros

                    %>

                    <h2> Resultado da consulta: </h2>
                    <table border=8>
                        <tr>
                            <th> Descrição </th>
                            <th> Displayname  </th>
                        </tr>

                        <%
                            Iterator i = listaEntidade.listIterator((pag * limite) - limite);
                            for (int j = 0; j < limite && i.hasNext(); j++) {
                                EntidadeBean l = (EntidadeBean) i.next();

                        %>

                        <tr>
                            <td><%= l.getDescricao()%></td>
                            <td><%= l.getDisplayname()%></td>

                        </tr>
                        <tr></tr>
                        <% }%>

                    </table>
                    <% }%>
                    <br>
                    <% 
                    String tipoConsulta = request.getAttribute("tipoConsulta").toString();
                        if (pag > 1) {
                            String cons = "<a href=?acao=" + tipoConsulta + "&nomeEntidade=" + displayname + "&pag=" + (pag - 1) + ">Anterior</a>";
                            out.print(cons);
                        } else {
                            out.print("Anterior");
                        }
                        String espaco = "&nbsp&nbsp&nbsp&nbsp&nbsp&nbsp&nbsp&nbsp&nbsp&nbsp";
                        out.print(espaco + "Página " + pag + " de " + totalPaginas + espaco);
                        if (pag * limite < listaEntidade.size()) {
                            String cons = "<a href=?acao=" + tipoConsulta + "&nomeEntidade=" + displayname + "&pag=" + (pag + 1) + ">Proximo</a>";
                            out.print(cons);
                        } else {
                            out.print("Proximo");
                        }
                        out.print(espaco + "Ir para a página: ");
                        out.print("<input type='text' id='npag'  size='1' maxlength='3' />");
                        out.print("<input type='button' onclick='mudaPagina(&#39;" + displayname + "&#39;)' value='ok!'/>");
                    %>

                    <div id="teste" name="teste"><br><br>
                        <p><a href="consulta.jsp"> Nova Consulta </a> </p>
                    </div>
                </div><%-- inserido --%>
            </div><%-- inserido --%>
        </div><%-- inserido --%>

        <%@include file="include_files/bottom.jsp" %><%-- inserido --%>
    </section><%-- inserido --%>
    <%@include file="include_files/footer.jsp" %><%-- inserido --%>
</body>
</html>



