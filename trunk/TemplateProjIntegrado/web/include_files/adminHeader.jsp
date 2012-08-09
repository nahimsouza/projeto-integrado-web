<%@page import="modelo.UsuarioBean"%>
<header>
    <nav>
        <div class="container">
            <div class="wrapper">
                <h1><a href="index.jsp"><b>Chico</b>Base</a></h1>
                <ul>
                    <li><a href="index.jsp" class="current">in�cio</a></li>
                    <li><a href="consulta.jsp">consultas</a></li>
                    <li><a href="insercao.jsp">inser��o</a></li>
                    <li><a href="alteracao.jsp">altera��o</a></li>
                    <li><a href="remocao.jsp">remo��o</a></li>
                    <li><a href="usuarios.jsp">usuarios</a></li> 
                    <li><a href="sobre.jsp">sobre</a></li>
                </ul> 
            </div>
        </div>
    </nav>
    <section class="adv-content">
        <div class="container">
            <form id="email-form" method="post" action="ValidarLogin" >
                <% //Recupera a Session
                    try {
                        HttpSession s = request.getSession(false);
                        UsuarioBean login = null;
                        if (s != null) {
                            login = (UsuarioBean) s.getAttribute("Usuario");
                            String tipo = login.getTipo();
                            String nome = login.getNome();
                %>
                <fieldset>
                    <input type="submit" value="logout"/>
                    <input type="hidden" name="tipo" value="logout">
                </fieldset>
                <h2><%="Bem vindo(a), " + tipo + "(a) " + nome %> </h2>
                <% }
            } catch (NullPointerException e) {%>
                <fieldset>
                    email <input type="text" value="" name="email"><!--<input type="submit" value="">-->
                    senha <input type="password" value="" name="senha">
                    <input type="submit" value="ir"/>
                    <input type="hidden" name="tipo" value="login">
                </fieldset>
                <% }%>

            </form>
        </div>
    </section>
</header>