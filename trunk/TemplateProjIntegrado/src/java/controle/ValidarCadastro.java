package controle;

import java.io.IOException;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;
import auxiliar.*;
import modelo.*;

public class ValidarCadastro extends HttpServlet {

    protected void doPost(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        String nome = request.getParameter("cadNome");
        String email = request.getParameter("cadEMail");
        String senha = request.getParameter("cadSenha");
        String dataNasc = request.getParameter("cadData");
        boolean tipo = true;
        UsuarioBean u = new UsuarioBean(nome, email, senha, dataNasc, tipo);

        if (Validacao.inserirUsuario(u)) {
            response.sendRedirect("index.jsp");
        }//fim if
        else {
            response.sendRedirect("erroCad.jsp");
        }

    }
}