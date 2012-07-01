package controle;

import java.io.IOException;
import java.util.ArrayList;
import java.util.List;
import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import modelo.EntidadeBean;
import modelo.EntidadeDAO;
import modelo.UsuarioBean;

public class VerificarSolicitacoes extends HttpServlet {

    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {

        String acao = request.getParameter("acao");

        if (acao.compareTo("conEntidade") == 0) {
            String displayname = request.getParameter("nomeEntidade");
            acaoConsultarEntidade(request, response, displayname);
        }

    }

    private void acaoConsultarEntidade(HttpServletRequest request, HttpServletResponse response, String displayname)
            throws ServletException, IOException {

        try {
            EntidadeDAO entidade = new EntidadeDAO();
            List<EntidadeBean> lista = (List<EntidadeBean>) entidade.listaEntidades(displayname);
            request.setAttribute("entidadeBean", this);
            
        } catch (Exception sqle) {
            request.setAttribute("entidadeBean", null);
        }
        RequestDispatcher rd = null;

        rd = request.getRequestDispatcher("/testeVIEW.jsp");

        rd.forward(request, response);

    }

    private void acaoConsultarMultipla(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        try {
            //UsuarioDAO usuario = new UsuarioDAO();
            //List<UsuarioBean> lista = (List<UsuarioBean>) usuario.solicitacoes();
            List<UsuarioBean> lista = new ArrayList<UsuarioBean>();
            UsuarioBean b = new UsuarioBean();
            b.setLogin("Gabriela Lisboa");
            lista.add(b);
            request.setAttribute("usuarioBean", lista);
        } catch (Exception sqle) {
            request.setAttribute("usuarioBean", null);
        }
        request.setAttribute("retorno", true);

        RequestDispatcher rd = null;

        rd = request.getRequestDispatcher("/solicitacoes.jsp");

        rd.forward(request, response);

    }
}