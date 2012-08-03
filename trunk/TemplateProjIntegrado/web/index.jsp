<%-- 
    Pagina Inicial do site
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
        <jsp:include page="include_files/colabHeader.jsp" />  
        <%        } else if (tipo.equals("Administrador")) {
        %>   
        <jsp:include page="include_files/adminHeader.jsp" />  
        <%}
                }
            } catch (NullPointerException e) {%>
        <jsp:include page="include_files/userHeader.jsp" />
        <% }%>


        <section id="content">
            <div class="top">
                <div class="container">
                    <div class="clearfix">
                        <section id="gallery">
                            <div class="pics">
                                <img src="images/slide1.jpg" alt="" width="495" height="329">
                                <img src="images/slide3.jpg" alt="" width="495" height="329">
                                <img src="images/slide2.jpg" alt="" width="495" height="329">
                                <img src="images/slide4.jpg" alt="" width="495" height="329">
                                <img src="images/slide5.jpg" alt="" width="495" height="329">
                            </div>
                            <a href="#" id="prev"></a>

                            <a href="#" id="next"></a>
                        </section>
                        <section id="intro">
                            <div class="inner">
                                <h2>Conhecimento<br /> & Colaboração<span>participe!</span></h2>
                                <p>Um mundo cheio de conhecimento e você aí parado?<br /> Você tem muita coisa a aprender e, com certeza, muita coisa para ensinar também! Por que não compartilhar todo o seu conhecimento com o mundo e com as próximas gerações?  </p>
                                <a href="sobre.jsp" class="extra-button">Saiba mais</a>
                            </div>
                        </section>
                    </div>
                </div>
            </div>

            <%@include file = "include_files/bottom.jsp" %>
        </section>
        <%@include file="include_files/footer.jsp" %>
    </body>
</html>