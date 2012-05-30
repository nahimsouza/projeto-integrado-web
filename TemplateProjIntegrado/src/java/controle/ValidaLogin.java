package controle;

import java.io.IOException;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;
import auxiliar.*;
import modelo.*;

public class ValidaLogin extends HttpServlet {

    protected void doPost(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        String tipo = request.getParameter("tipo");
        if (tipo.compareTo("login") == 0) {    
        login(request, response);
        }
    }

    private void logout(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
    }

    private void login(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
                    String email = request.getParameter("email");
            String senha = request.getParameter("senha");
            if(Validacao.isUsuarioValido(email, senha)){
                HttpSession session = request.getSession();
                UsuarioBean user = new UsuarioBean();
                user.setLogin(email);
                session.setAttribute("Usuario", user);
                response.sendRedirect("erro.html");
            }//fim if
            else{
                response.sendRedirect("erro.html");
            }
        }//fim login
}
