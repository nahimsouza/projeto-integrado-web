package controle;

import java.io.IOException;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;
import modelo.*;

public class ValidarAltCadastro extends HttpServlet {

    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        String nome = request.getParameter("cadNome");
        String email = request.getParameter("cadEMail");
        String senha = request.getParameter("cadSenha");
        String dataNasc = request.getParameter("cadData");
        String emailOriginal = null;
        String tipo = "Colaborador";
        try {
            HttpSession sessao = request.getSession(false);
            UsuarioBean log = null;
            if (sessao != null) {
                log = (UsuarioBean) sessao.getAttribute("Usuario");
                emailOriginal = log.getLogin();
            }
        } catch (NullPointerException e) {
            emailOriginal = null;
        }

        UsuarioBean u = new UsuarioBean(nome, email, senha, dataNasc, tipo);

        try {
            UsuarioDAO user = new UsuarioDAO();
            user.alterarUsuario(u, emailOriginal);
            try {
                HttpSession sessao = request.getSession(false);
                UsuarioBean log = null;
                if (sessao != null) {
                    log = (UsuarioBean) sessao.getAttribute("Usuario");
                    if(nome != "")
                        log.setNome(nome);
                    if(email != "")
                        log.setLogin(email);
                }
            } catch (NullPointerException e) {
            }
            response.sendRedirect("sucessoAlt.jsp");

        } catch (UsuarioDAOException e) {
            response.sendRedirect("erroAlt.jsp");
        }
    }
}