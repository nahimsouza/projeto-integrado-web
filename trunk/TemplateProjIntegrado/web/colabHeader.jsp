<%@page import="modelo.UsuarioBean"%>
<nav>
    <div class="container">
        <div class="wrapper">
            <h1><a href="index.jsp"><b>Chico</b>Base</a></h1>
            <ul>
                <li><a href="index.jsp">in�cio</a></li>
                <li><a href="consulta.jsp" class="current">consultas</a></li>
                <li><a href="insercao.jsp">inser��o</a></li>
                <li><a href="alteracao.jsp">altera��o</a></li>
                <li><a href="remocao.jsp">remo��o</a></li>
                <li><a href="usuarios.jsp">usuarios</a></li> 
                <li><a href="cadastro.jsp">Cadastre-se</a></li>
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
            %>
            <fieldset>
                <input type="submit" value="logout"/>
                <input type="hidden" name="tipo" value="logout">
            </fieldset>
            <h2><%="Bem vindo, " + tipo%> </h2>
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
<!-- <section class="adv-content">
        <div class="container">
                <form action="" id="email-form">
                        <fieldset>
                                email <input type="text" value=""><!--<input type="submit" value="">-->
<!-- senha <input type="password" value="">
 <input type="submit" value="ir">
</fieldset>
</form>
</div>
</section> --><div class="ic">More Website Templates at TemplateMonster.com!</div>