package controle;

/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */


import java.io.IOException;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import auxiliar.*;
import javax.servlet.RequestDispatcher;
import java.util.List;
import modelo.*;

public class ValidarUsuario extends HttpServlet {

    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {

        String tipo = request.getParameter("tipo");

        if (tipo.compareTo("aceitar") == 0) {
            acaoSalvar(request, response);
        }
    }

    private void acaoSalvar(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        
        UsuarioBean objUsuario = (UsuarioBean) request.getAttribute("usuario");
        //try {
        //UsuarioDAO user = new UsuarioDAO();
        //user.salvar(objUsuario);
        List<UsuarioBean> list = (List<UsuarioBean>) request.getAttribute("usuarioBean");
        if(list != null){
            list.remove(objUsuario);
            request.setAttribute("usuarioBean", list);
        }

        /*
         * } catch (UsuarioDAOException e) { request.setAttribute("usuarioBean",
         * null);
        }
         */

        RequestDispatcher rd = null;

        rd = request.getRequestDispatcher("/solicitacoes.jsp");

        rd.forward(request, response);
    }
}
