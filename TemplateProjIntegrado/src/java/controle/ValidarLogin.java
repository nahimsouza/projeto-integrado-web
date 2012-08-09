package controle;

import java.io.IOException;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;
import modelo.*;

public class ValidarLogin extends HttpServlet {

    protected void doPost(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        String tipo = request.getParameter("tipo");
        if (tipo.compareTo("login") == 0) {
            login(request, response);
        } else if (tipo.compareTo("logout") == 0) {
            logout(request, response);
        }
    }

    private void logout(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        HttpSession session = request.getSession(false);
        session.invalidate();
        response.sendRedirect("index.jsp");
    }

    private void login(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        String email = request.getParameter("email");
        String senha = request.getParameter("senha");
        boolean v;
        UsuarioDAO u = null;
        try {
            u = new UsuarioDAO();
            v = u.isUsuarioValido(email, senha);
        } catch (UsuarioDAOException ex) {
            v = false;
        }
        if (v) {
            try {
                u = new UsuarioDAO();
                String tipo = u.getTipo(email);
                u = new UsuarioDAO();
                String nome = u.getNome(email);
                if (tipo.equals("Usuario")) {
                    response.sendRedirect("aguarde.jsp");
                } else {
                    HttpSession session = request.getSession();
                    UsuarioBean user = new UsuarioBean();
                    user.setLogin(email);
                    user.setTipo(tipo);
                    user.setNome(nome);
                    session.setAttribute("Usuario", user);
                    response.sendRedirect("index.jsp");
                }
            } catch (UsuarioDAOException e) {
                response.sendRedirect("erro.jsp");
            }
        } else {
            response.sendRedirect("erro.jsp");
        }
    }//fim login 
}
