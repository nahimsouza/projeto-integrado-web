package controle;

import java.io.IOException;
import java.util.ArrayList;
import java.util.Iterator;
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
import modelo.UsuarioDAO;

public class VerificarSolicitacoes extends HttpServlet {

    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        String displayname = request.getParameter("nomeEntidade");
        String pag = request.getParameter("pag");
        acaoConsultarEntidadeR(request, response, displayname, pag);

    }

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
        } else if (acao.compareTo("conTipo") == 0) {
            String descTipo = request.getParameter("nomeTipo");
            acaoConsultarTipo(request, response, descTipo);
        } else if (acao.compareTo("conCategoria") == 0) {
            String desCat = request.getParameter("nomeCategoria");
            acaoConsultarCategoria(request, response, desCat);
        } else if (acao.compareTo("conAvancada") == 0) {
            int in = Integer.parseInt(request.getParameter("catIn"));
            int not = Integer.parseInt(request.getParameter("catNot"));
            acaoConsultaAvancada(request, response, in, not);
        } else if (acao.compareTo("usuarios") == 0) {
            acaoConsultarUsuario(request, response, "");
        } else if (acao.compareTo("carregaCategorias") == 0) {
            acaoCarregaCategorias(request, response);
        } else if (acao.compareTo("carregaTipos") == 0) {
            int idcat = Integer.parseInt(request.getParameter("cat"));
            acaoCarregaTipos(request, response, idcat);
        } else if (acao.compareTo("carregaTiposConsulta") == 0) {
            acaoCarregaTiposConsulta(request, response);
        } else if (acao.compareTo("insCategoria") == 0) {
            String[] insCat;
            List<CategoriaTipoBean> list = new ArrayList<CategoriaTipoBean>();
            insCat = request.getParameterValues("listaCategorias");
            if (insCat != null) {
                for (int i = 0; i < insCat.length; i++) {
                    list.add(new CategoriaTipoBean(insCat[i]));
                }
            }
            acaoInserirTipo(request, response, list);
        }else if (acao.compareTo("insTipo") == 0) {
            String[] insTipo;
            String[] temp;
            List<CategoriaTipoBean> list = new ArrayList<CategoriaTipoBean>();
            insTipo = request.getParameterValues("categoriass");
            if (insTipo != null) {
                for (int i = 0; i < insTipo.length; i++) {
                    temp =insTipo[i].split("/");
                    list.add(new CategoriaTipoBean(temp[1],temp[2]));//falta descobrir como separar as strings
                }
            }
            acaoInserirTipo(request, response, list);
        } else if (acao.compareTo("conUsuario") == 0) {
            acaoCarregaUsuario(request, response);
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

    }

    private void acaoConsultarEntidadeR(HttpServletRequest request, HttpServletResponse response, String displayname)
            throws ServletException, IOException {

        try {
            EntidadeDAO entidade = new EntidadeDAO();
            List<EntidadeBean> lista = (List<EntidadeBean>) entidade.listaEntidadesR(displayname);
            request.setAttribute("EntidadeBean", lista);
            request.setAttribute("dn", displayname);

        } catch (Exception sqle) {
            request.setAttribute("EntidadeBean", null);
        }
        RequestDispatcher rd = null;

        rd = request.getRequestDispatcher("/viewEntidadeConsultaMultipla.jsp");

        rd.forward(request, response);

    }

    private void acaoConsultarEntidadeR(HttpServletRequest request, HttpServletResponse response, String displayname, String pag)
            throws ServletException, IOException {

        try {
            EntidadeDAO entidade = new EntidadeDAO();
            List<EntidadeBean> lista = (List<EntidadeBean>) entidade.listaEntidadesR(displayname);
            request.setAttribute("EntidadeBean", lista);
            request.setAttribute("pag", pag);
            request.setAttribute("dn", displayname);
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

    private void acaoConsultarUsuario(HttpServletRequest request, HttpServletResponse response, String displayname)
            throws ServletException, IOException {

        try {
            UsuarioDAO usuario = new UsuarioDAO();
            List<UsuarioBean> lista = (List<UsuarioBean>) usuario.solicitacoes();
            request.setAttribute("UsuarioBean", lista);

        } catch (Exception sqle) {
            request.setAttribute("UsuarioBean", null);
        }
        RequestDispatcher rd = null;

        rd = request.getRequestDispatcher("/viewSolicitacoes.jsp");

        rd.forward(request, response);

    }

    private void acaoCarregaCategorias(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {

        List<CategoriaTipoBean> lista = null;

        try {
            CategoriaTipoDAO categoria = new CategoriaTipoDAO();
            lista = (List<CategoriaTipoBean>) categoria.listaTodasCategorias();
            request.setAttribute("CategoriaTipoBean", lista);

        } catch (Exception sqle) {
            request.setAttribute("CategoriaTipoBean", null);
        }

        String html = "<option value=''></option>";
        for (Iterator i = lista.iterator(); i.hasNext();) {
            CategoriaTipoBean l = (CategoriaTipoBean) i.next();
            html += "<option value=" + l.getIdCategoria() + ">" + l.getCategoria() + "</option>";
        }

        response.getWriter().write(html);
    }

    private void acaoCarregaTipos(HttpServletRequest request, HttpServletResponse response, int idcat)
            throws ServletException, IOException {

        List<CategoriaTipoBean> lista = null;

        try {
            CategoriaTipoDAO categoria = new CategoriaTipoDAO();
            lista = (List<CategoriaTipoBean>) categoria.listaTipoPorCategoria(idcat);
            request.setAttribute("CategoriaTipoBean", lista);

        } catch (Exception sqle) {
            request.setAttribute("CategoriaTipoBean", null);
        }

        String html = "<option value=''></option>";
        for (Iterator i = lista.iterator(); i.hasNext();) {
            CategoriaTipoBean l = (CategoriaTipoBean) i.next();
            html += "<option value=" + l.getIdTipo() + ">" + l.getTipo() + "</option>";
        }

        response.getWriter().write(html);
    }

    private void acaoCarregaTiposConsulta(HttpServletRequest request, HttpServletResponse response) throws IOException {
        List<CategoriaTipoBean> lista = null;

        try {
            CategoriaTipoDAO categoria = new CategoriaTipoDAO();
            lista = (List<CategoriaTipoBean>) categoria.listaTodosTipos();
            request.setAttribute("CategoriaTipoBean", lista);

        } catch (Exception sqle) {
            request.setAttribute("CategoriaTipoBean", null);
        }

        String html = "<option value=''></option>";
        for (Iterator i = lista.iterator(); i.hasNext();) {
            CategoriaTipoBean l = (CategoriaTipoBean) i.next();
            html += "<option value=" + l.getIdTipo() + ">" + l.getTipo() + "</option>";
        }

        response.getWriter().write(html);
    }

    private void acaoInserirConsulta(HttpServletRequest request, HttpServletResponse response, List<CategoriaTipoBean> list)  throws IOException {


        try {
            CategoriaTipoDAO categoria = new CategoriaTipoDAO();
            categoria.inserirCategoria(list);


        } catch (Exception sqle) {
        }




    }
    private void acaoInserirTipo(HttpServletRequest request, HttpServletResponse response, List<CategoriaTipoBean> list)  throws IOException {


        try {
            CategoriaTipoDAO categoria = new CategoriaTipoDAO();
            categoria.inserirTipo(list);


        } catch (Exception sqle) {
        }




    }
    private void acaoCarregaUsuario(HttpServletRequest request, HttpServletResponse response, String displayname)  throws IOException {


       try {
            UsuarioDAO usuario = new UsuarioDAO();
            List<UsuarioBean> lista = (List<UsuarioBean>) usuario.funcao();
            request.setAttribute("UsuarioBean", lista);

        } catch (Exception sqle) {
            request.setAttribute("UsuarioBean", null);
        }
        RequestDispatcher rd = null;

        rd = request.getRequestDispatcher("/viewUsuario.jsp");

        rd.forward(request, response);


    }
}