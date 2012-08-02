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
        String tipo = "Usuario";
        UsuarioBean u = new UsuarioBean(nome, email, senha, dataNasc, tipo);

        int v = Validacao.inserirUsuario(u);
        
        if (v == 1) {
            response.sendRedirect("sucessoCad.jsp");
        }else if(v == -1) {
            response.sendRedirect("erroCad.jsp");
        }
        else
            response.sendRedirect("erroCad2.jsp");
    }
}