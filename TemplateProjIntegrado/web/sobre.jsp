<%-- 
    Página de 'sobre'

    : escrever algo sobre o site

--%>

<%@page contentType="text/html" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html lang="en">
    <%@include file="include_files/head.jsp" %>

    <body>
        <%@include file = "include_files/userHeader.jsp" %>
        <section id="content">
            <div class="middle">
                <div class="container">
                    <h2>Sobre o ChicoBase</h2>
                    <div class="wrapper">
                        Chicobase é uma grande base de conhecimento colaborativa.
                        É uma recolha de dados estruturados online colhidas de várias fontes, inclusive a contribuição 'wiki'.
                        O objetivo da Chicobase, é criar um recurso global que permita as pessoas (e máquinas) acessar informação comum, mais efetivamente. 
                        É desenvolvido por um grupo de alunos de ciência da computação da UFSCar campus Sorocaba.
                        
                    </div>
                </div>
            </div>


            <%@include file="include_files/bottom.jsp" %>
        </section>
        <%@include file="include_files/footer.jsp" %>

    </body>
</html>