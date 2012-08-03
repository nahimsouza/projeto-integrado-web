package controle;

import java.io.IOException;
import java.util.ArrayList;
import java.util.List;
import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import modelo.CategoriaTipoBean;
import modelo.CategoriaTipoDAO;
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
        if (acao.compareTo("conEntidadeR") == 0) {
            String displayname = request.getParameter("nomeEntidade");
            acaoConsultarEntidadeR(request, response, displayname);
        }
        else if(acao.compareTo("conTipo") == 0) {
            String descTipo = request.getParameter("nomeTipo");
            acaoConsultarTipo(request, response, descTipo);
        }
         else if(acao.compareTo("conCategoria") == 0) {
            String desCat = request.getParameter("nomeCategoria");
            acaoConsultarCategoria(request, response, desCat);
        }
         else if(acao.compareTo("conAvancada") == 0) {
             int in = Integer.parseInt(request.getParameter("catIn"));
             int not = Integer.parseInt(request.getParameter("catNot"));
             acaoConsultaAvancada(request, response, in, not);
         }

    }

    private void acaoConsultarEntidade(HttpServletRequest request, HttpServletResponse response, String displayname)
            throws ServletException, IOException {

        try {
            EntidadeDAO entidade = new EntidadeDAO();
            List<EntidadeBean> lista = (List<EntidadeBean>) entidade.listaEntidades(displayname);
            request.setAttribute("EntidadeBean", lista);

        } catch (Exception sqle) {
            request.setAttribute("EntidadeBean", null);
        }
        RequestDispatcher rd = null;

        rd = request.getRequestDispatcher("/viewEntidadeConsultaMultipla.jsp");

        rd.forward(request, response);

    } private void acaoConsultarEntidadeR(HttpServletRequest request, HttpServletResponse response, String displayname)
            throws ServletException, IOException {

        try {
            EntidadeDAO entidade = new EntidadeDAO();
            List<EntidadeBean> lista = (List<EntidadeBean>) entidade.listaEntidadesR(displayname);
            request.setAttribute("EntidadeBean", lista);

        } catch (Exception sqle) {
            request.setAttribute("EntidadeBean", null);
        }
        RequestDispatcher rd = null;

        rd = request.getRequestDispatcher("/viewEntidadeConsultaMultipla.jsp");

        rd.forward(request, response);

    }

    private void acaoConsultarTipo(HttpServletRequest request, HttpServletResponse response, String descTipo)
            throws ServletException, IOException {

        try {
            CategoriaTipoDAO tipo = new CategoriaTipoDAO();
            List<CategoriaTipoBean> lista = (List<CategoriaTipoBean>) tipo.listaTipo(descTipo);
            request.setAttribute("CategoriaTipoBean", lista);

        } catch (Exception sqle) {
            request.setAttribute("CategoriaTipoBean", null);
        }
        RequestDispatcher rd = null;

        rd = request.getRequestDispatcher("/viewTipoConsultaMultipla.jsp");

        rd.forward(request, response);

    }

    private void acaoConsultarCategoria(HttpServletRequest request, HttpServletResponse response, String desCat)
            throws ServletException, IOException {

        try {
            CategoriaTipoDAO categoria = new CategoriaTipoDAO();
            List<CategoriaTipoBean> lista = (List<CategoriaTipoBean>) categoria.listaCategoria(desCat);
            request.setAttribute("CategoriaTipoBean", lista);

        } catch (Exception sqle) {
            request.setAttribute("CategoriaTipoBean", null);
        }
        RequestDispatcher rd = null;

        rd = request.getRequestDispatcher("/viewCategoriaConsultaMultipla.jsp");

        rd.forward(request, response);

    }
    private void acaoConsultaAvancada(HttpServletRequest request, HttpServletResponse response, int in, int not)
            throws ServletException, IOException {

        try {
            EntidadeDAO entidade = new EntidadeDAO();
            List<EntidadeBean> lista = (List<EntidadeBean>) entidade.listaAvancada(in, not);
            request.setAttribute("EntidadeBean", lista);

        } catch (Exception sqle) {
            request.setAttribute("EntidadeBean", null);
        }
        RequestDispatcher rd = null;

        rd = request.getRequestDispatcher("/viewEntidadeConsultaMultipla.jsp");

        rd.forward(request, response);

    }
}