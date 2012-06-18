package controle;

import java.io.IOException;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.RequestDispatcher;
import java.util.List;
import modelo.UsuarioBean;
import modelo.UsuarioDAO;

public class VerificarSolicitacao extends HttpServlet {

    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {

        acaoConsultarMultipla(request, response);

    }

    private void acaoConsultarMultipla(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        try {
            UsuarioDAO usuario = new UsuarioDAO();
            List<UsuarioBean> lista = (List<UsuarioBean>) usuario.solicitacoes();
            request.setAttribute("usuarioBean", lista);
        } catch (Exception sqle) {
            request.setAttribute("usuarioBean", null);
        }
        RequestDispatcher rd = null;

        rd = request.getRequestDispatcher("/solicitacoes.jsp");

        rd.forward(request, response);

    }
}