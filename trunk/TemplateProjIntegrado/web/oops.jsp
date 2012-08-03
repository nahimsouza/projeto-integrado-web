<%-- 
    Document   : login
    Created on : 03/08/2012, 15:11:12
    Author     : Fernando
--%>

<%@page contentType="text/html" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
    <%@include file="include_files/head.jsp" %>
    <%@include file="include_files/userHeader.jsp" %>
    <body>
         <section id="content">
            <div class="top">
                <div class="container">
                    <div class="clearfix">
                        <section id="gallery">
                            <div class="pics">
                                <img src="images/oops.jpg" alt="" width="495" height="329">
                            </div>
                        </section>
                        <section id="intro">
                            <div class="inner">
                                <p>
                                <h2>
                                    Acesso negado!
                                </h2>
                                <h3>
                                <span>
                                    Faça login acima ou <a href="cadastro.jsp">cadastre-se</a> gratuitamente.
                                </span>
                                </h3>
                                </p>
                                <br/>
                                <br/>
                                <a href="sobre.jsp" class="extra-button">Saiba mais</a>
                            </div>
                        </section>
                    </div>
                </div>
            </div>

    </body>

    <%@include file="include_files/bottom.jsp" %>
    <%@include file="include_files/footer.jsp" %>
</html>
