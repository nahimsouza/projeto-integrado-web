package controle;

import java.io.IOException;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;
import auxiliar.*;
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
        if (Validacao.isUsuarioValido(email, senha)) {
            String tipo = UsuarioDAO.getTipo(email, senha);
            if(tipo.equals("Usuario"))
                response.sendRedirect("userIndex.jsp");
            else{
                HttpSession session = request.getSession();
                UsuarioBean user = new UsuarioBean();
                user.setLogin(email);
                user.setTipo(tipo);
                session.setAttribute("Usuario", user);
                response.sendRedirect("index.jsp");
            }
        }
        else {
            response.sendRedirect("erro.jsp");
        }
    }//fim login 
}
