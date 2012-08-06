package controle;

/*
 * To change this template, choose Tools | Templates and open the template in
 * the editor.
 */
import java.io.IOException;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import auxiliar.*;
import javax.servlet.RequestDispatcher;
import java.util.List;
import javax.servlet.http.HttpSession;
import modelo.*;

public class ValidarUsuario extends HttpServlet {

    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {

        String tipo = request.getParameter("tipo");

        if (tipo.compareTo("aceitar") == 0) {
            acaoSalvar(request, response);
        }

        if (tipo.compareTo("rejeitar") == 0) {
            acaoRejeitar(request, response);
        }
    }

    private void acaoSalvar(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        
        HttpSession sessao = request.getSession(false);
        UsuarioBean objUsuario = (UsuarioBean) sessao.getAttribute("usuario");
        UsuarioDAO.aceitarUsuario(objUsuario.getLogin());
        List<UsuarioBean> list;
        try {
            UsuarioDAO u = new UsuarioDAO();
            list = (List<UsuarioBean>) u.solicitacoes();
        } catch (UsuarioDAOException e) {
            list = null;
        }
        if (list != null) {
            list.remove(objUsuario);
            request.setAttribute("UsuarioBean", list);
        }

        RequestDispatcher rd = null;

        rd = request.getRequestDispatcher("/viewSolicitacoes.jsp");

        rd.forward(request, response);
    }

        private void acaoRejeitar(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        
        HttpSession sessao = request.getSession(false);
        UsuarioBean objUsuario = (UsuarioBean) sessao.getAttribute("usuario");
        UsuarioDAO.rejeitarUsuario(objUsuario.getLogin());
        List<UsuarioBean> list;
        try {
            UsuarioDAO u = new UsuarioDAO();
            list = (List<UsuarioBean>) u.solicitacoes();
        } catch (UsuarioDAOException e) {
            list = null;
        }
        if (list != null) {
            list.remove(objUsuario);
            request.setAttribute("UsuarioBean", list);
        }

        RequestDispatcher rd = null;

        rd = request.getRequestDispatcher("/viewSolicitacoes.jsp");

        rd.forward(request, response);
    }
}
