package controle;

import java.io.IOException;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import modelo.*;

public class ValidarAltCadastro extends HttpServlet {

    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        String nome = request.getParameter("cadNome");
        String email = request.getParameter("cadEMail");
        String senha = request.getParameter("cadSenha");
        String dataNasc = request.getParameter("cadData");
        String tipo = "Usuario";
        UsuarioBean u = new UsuarioBean(nome, email, senha, dataNasc, tipo);

        try {
            UsuarioDAO user = new UsuarioDAO();
            int v = user.alterarUsuario(u);

            if (v == 1) {
                response.sendRedirect("sucessoCad.jsp");
            }else {
                response.sendRedirect("erroCad2.jsp");
            }
        } catch (UsuarioDAOException e) {
            response.sendRedirect("erroCad.jsp");
        }
    }
}