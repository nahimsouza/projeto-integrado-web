package controle;

import java.io.IOException;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;
import modelo.*;

public class VerificarSolicitacoes extends HttpServlet {

    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        String acao = request.getParameter("acao");
        System.out.print(acao);

        if (acao.compareTo("conEntidade") == 0) {
            String displayname = request.getParameter("nomeEntidade");
            String pag = request.getParameter("pag");
            acaoConsultarEntidade(request, response, displayname, pag);
        } else if (acao.compareTo("conEntidadeR") == 0) {
            String displayname = request.getParameter("nomeEntidade");
            String pag = request.getParameter("pag");
            acaoConsultarEntidadeR(request, response, displayname, pag);
        } else if (acao.compareTo("conAvancada") == 0) {
            int tipoP = Integer.parseInt(request.getParameter("tipoP"));
            int tipoNP = Integer.parseInt(request.getParameter("tipoNP"));
            String pag = request.getParameter("pag");
            acaoConsultaAvancada(request, response, tipoP, tipoNP, pag);
        }



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
            int tipoP = Integer.parseInt(request.getParameter("tipoP"));
            int tipoNP = Integer.parseInt(request.getParameter("tipoNP"));
            acaoConsultaAvancada(request, response, tipoP, tipoNP);
        } else if (acao.compareTo("usuarios") == 0) {
            acaoConsultarUsuario(request, response, "");
        } else if (acao.compareTo("carregaCategorias") == 0 || acao.compareTo("carregaCategoriasConsulta") == 0) {
            acaoCarregaCategorias(request, response);
        } else if (acao.compareTo("carregaTipos") == 0 || acao.compareTo("carregaTiposConsulta") == 0) {
            int idcat = Integer.parseInt(request.getParameter("cat"));
            acaoCarregaTipos(request, response, idcat);
        } else if (acao.compareTo("insCategoria") == 0) {
            try {
                acaoInserirCategoria(request, response);
            } catch (UsuarioDAOException ex) {
                Logger.getLogger(VerificarSolicitacoes.class.getName()).log(Level.SEVERE, null, ex);
            }
        } else if (acao.compareTo("insTipo") == 0) {
            List<String> insTipo;
            String[] temp;
            List<CategoriaTipoBean> list = new ArrayList<CategoriaTipoBean>();
            insTipo = (List<String>) request.getSession().getAttribute("list_aux");
            if (insTipo != null && !insTipo.isEmpty()) {
            for (String i : insTipo) {
                    temp = i.split(",");
                    list.add(new CategoriaTipoBean(temp[0],temp[1]));
                } 
                acaoInserirTipo(request, response, list);
            } else {
                response.sendRedirect("index.jsp");
            }

            /*  String[] insTipo;
             String[] temp;
             List<CategoriaTipoBean> list = new ArrayList<CategoriaTipoBean>();
             insTipo = request.getParameterValues("categorias");
             if (insTipo != null) {
             for (int i = 0; i < insTipo.length; i++) {
             temp = insTipo[i].split("/");
             list.add(new CategoriaTipoBean(temp[0], temp[1]));//falta descobrir como separar as strings
             }
             acaoInserirTipo(request, response, list);
             }
             else{
             acaoInserirTipo(request, response, null);
             }*/

        } else if (acao.compareTo("consUsuarioEmail") == 0) {
            String email = request.getParameter("email");
            acaoConsultarUsuarioEmail(request, response, email);
        } else if (acao.compareTo("insEntidade") == 0) {
            String displayname = (String) request.getParameter("displayname");
            String descricao = (String) request.getParameter("descricao");
            EntidadeBean e = new EntidadeBean(displayname, descricao);
            acaoInserirEntidade(request, response, e);
        } else if (acao.compareTo("altCategoria") == 0) {
            String desCat = request.getParameter("nomeCategoria");
            acaoConsultaAlterarCategoria(request, response, desCat);
        } else if (acao.compareTo("altResultadoCategoria") == 0) {
            String desCat = request.getParameter("ncateg");
            //acaoAlterarCategoria(request, response, desCat);
        } else if (acao.compareTo("altTipo") == 0) {
            String desTipo = request.getParameter("nomeTipo");
            acaoConsultaAlterarTipo(request, response, desTipo);
        } else if (acao.compareTo("altResultadoTipo") == 0) {
            String desTipo = request.getParameter("nTipo");
            //acaoAlterarCategoria(request, response, desCat);
        }else if (acao.compareTo("remTipo") == 0) {
            String desTipo = request.getParameter("nomeTipo");
            acaoConsultaRemoverTipo(request, response, desTipo);
        }else if (acao.compareTo("remCategoria") == 0) {
            String desCat = request.getParameter("nomeCategoria");
            acaoConsultaRemoverCategoria(request, response, desCat);
        }
        else if (acao.compareTo("remResultadoCategoria") == 0) {
            String desCat = request.getParameter("name");
                    try {
                        acaoRemoverCategoria(request, response, desCat);
                    } catch (UsuarioDAOException ex) {
                        Logger.getLogger(VerificarSolicitacoes.class.getName()).log(Level.SEVERE, null, ex);
                    }
        }else if (acao.compareTo("remResultadoTipo") == 0) {
            String desTipo = request.getParameter("valor");
                    try {
                        acaoRemoverTipo(request, response, desTipo);
                    } catch (UsuarioDAOException ex) {
                        Logger.getLogger(VerificarSolicitacoes.class.getName()).log(Level.SEVERE, null, ex);
                    }
        }
    }

    private void acaoConsultarEntidade(HttpServletRequest request, HttpServletResponse response, String displayname)
            throws ServletException, IOException {

        try {
            EntidadeDAO entidade = new EntidadeDAO();
            List<EntidadeBean> lista = (List<EntidadeBean>) entidade.listaEntidades(displayname);
            request.setAttribute("EntidadeBean", lista);
            request.setAttribute("tipoConsulta", "conEntidade");
            request.setAttribute("dn", displayname);

        } catch (Exception sqle) {
            request.setAttribute("EntidadeBean", null);
        }
        RequestDispatcher rd = null;

        rd = request.getRequestDispatcher("/viewEntidadeConsultaMultipla.jsp");

        rd.forward(request, response);

    }

        private void acaoConsultarEntidade(HttpServletRequest request, HttpServletResponse response, String displayname, String pag)
            throws ServletException, IOException {

        try {
            EntidadeDAO entidade = new EntidadeDAO();
            List<EntidadeBean> lista = (List<EntidadeBean>) entidade.listaEntidades(displayname);
            request.setAttribute("EntidadeBean", lista);
            request.setAttribute("tipoConsulta", "conEntidade");
            request.setAttribute("dn", displayname);
            request.setAttribute("pag", pag);

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
            request.setAttribute("tipoConsulta", "conEntidadeR");

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

    private void acaoConsultaAvancada(HttpServletRequest request, HttpServletResponse response, int tipoP, int tipoNP, String pag)
            throws ServletException, IOException {

        try {
            EntidadeDAO entidade = new EntidadeDAO();
            List<EntidadeBean> lista = (List<EntidadeBean>) entidade.listaAvancada(tipoP, tipoNP);
            request.setAttribute("EntidadeBean", lista);
            request.setAttribute("pag", pag);
            request.setAttribute("tipoP", tipoP);
            request.setAttribute("tipoNP", tipoNP);

        } catch (Exception sqle) {
            request.setAttribute("EntidadeBean", null);
        }
        RequestDispatcher rd = null;

        rd = request.getRequestDispatcher("/viewConsultaAvancada.jsp");

        rd.forward(request, response);

    }

    private void acaoConsultaAvancada(HttpServletRequest request, HttpServletResponse response, int tipoP, int tipoNP)
            throws ServletException, IOException {

        try {
            EntidadeDAO entidade = new EntidadeDAO();
            List<EntidadeBean> lista = (List<EntidadeBean>) entidade.listaAvancada(tipoP, tipoNP);
            request.setAttribute("EntidadeBean", lista);
            request.setAttribute("tipoP", tipoP);
            request.setAttribute("tipoNP", tipoNP);

        } catch (Exception sqle) {
            request.setAttribute("EntidadeBean", null);
        }
        RequestDispatcher rd = null;

        rd = request.getRequestDispatcher("/viewConsultaAvancada.jsp");

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
            html += "<option name='" + l.getIdCategoria() + "' value='" + l.getCategoria() +"'>" + l.getCategoria() + "</option>";
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

    private void acaoConsultarUsuarioEmail(HttpServletRequest request, HttpServletResponse response, String email)
            throws ServletException, IOException {
        try {
            UsuarioDAO usuario = new UsuarioDAO();
            UsuarioBean user = usuario.consultarUsuario(email);
            request.setAttribute("UsuarioBean", user);

        } catch (Exception sqle) {
            request.setAttribute("UsuarioBean", null);
        }
        RequestDispatcher rd = null;

        rd = request.getRequestDispatcher("/viewUsuarioConsultaMultipla.jsp");

        rd.forward(request, response);
    }

    private void acaoInserirCategoria(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException, UsuarioDAOException {


        String[] insCat;
        List<CategoriaTipoBean> list = new ArrayList<CategoriaTipoBean>();
        insCat = request.getParameterValues("listaCategorias");

        if (insCat != null) {
            for (int i = 0; i < insCat.length; i++) {
                list.add(new CategoriaTipoBean(insCat[i]));
            }
        }
        for (CategoriaTipoBean categ : list) {
            String c = categ.getCategoria();
            try {

                CategoriaTipoDAO cat = new CategoriaTipoDAO();
                cat.inserirCategoria(c); //temos que verificar com o Nahim o que é isso???
                request.setAttribute("CategoriaTipoBean", categ);

            } catch (CategoriaTipoDAOException e) {
                request.setAttribute("CategoriaTipoBean", null);
            }
            //UsuarioBean user = usuario.consultarUsuario(email);
            //request.setAttribute("UsuarioBean", user);

        }

        RequestDispatcher rd = null;

        rd = request.getRequestDispatcher("/sucessoCad.jsp");

        rd.forward(request, response);

    }

    private void acaoInserirEntidade(HttpServletRequest request, HttpServletResponse response, EntidadeBean e)
            throws ServletException, IOException {

        RequestDispatcher rd = null;
        try {
            EntidadeDAO entidade = new EntidadeDAO();
            entidade.inserirEntidade(e);
            rd = request.getRequestDispatcher("/sucessoCad.jsp");


        } catch (Exception sqle) {
            rd = request.getRequestDispatcher("/oops.jsp");
        }

        rd.forward(request, response);

    }

    private void acaoConsultaAlterarCategoria(HttpServletRequest request, HttpServletResponse response, String desCat)
            throws ServletException, IOException {

        try {
            CategoriaTipoDAO categoria = new CategoriaTipoDAO();
            List<CategoriaTipoBean> lista = (List<CategoriaTipoBean>) categoria.listaCategoria(desCat);
            request.setAttribute("CategoriaTipoBean", lista);

        } catch (Exception sqle) {
            request.setAttribute("CategoriaTipoBean", null);
        }
        RequestDispatcher rd = null;

        rd = request.getRequestDispatcher("/viewAlteracaoCategoria.jsp");

        rd.forward(request, response);

    }

    private void acaoAlterarCategoria(HttpServletRequest request, HttpServletResponse response, String desCat)
            throws ServletException, IOException, UsuarioDAOException {

        HttpSession sessao = request.getSession(false);
        CategoriaTipoBean categ = new CategoriaTipoBean(desCat);
        CategoriaTipoBean oldcateg = new CategoriaTipoBean(sessao.getAttribute("Categoria").toString());
        sessao.removeAttribute("Categoria");


        try {

            CategoriaTipoDAO cat = new CategoriaTipoDAO();
            cat.alterarCategoria(categ, oldcateg);

            request.setAttribute("CategoriaTipoBean", categ);

        } catch (CategoriaTipoDAOException e) {
            request.setAttribute("CategoriaTipoBean", null);
        }
        //UsuarioBean user = usuario.consultarUsuario(email);
        //request.setAttribute("UsuarioBean", user);



    }

    private void acaoConsultaAlterarTipo(HttpServletRequest request, HttpServletResponse response, String desTipo)
            throws ServletException, IOException {

        try {
            CategoriaTipoDAO tipo = new CategoriaTipoDAO();
            List<CategoriaTipoBean> lista = (List<CategoriaTipoBean>) tipo.listaTipo(desTipo);
            request.setAttribute("CategoriaTipoBean", lista);

        } catch (Exception sqle) {
            request.setAttribute("CategoriaTipoBean", null);
        }
        RequestDispatcher rd = null;

        rd = request.getRequestDispatcher("/viewAlteracaoTipo.jsp");

        rd.forward(request, response);

    }

    private void acaoAlterarTipo(HttpServletRequest request, HttpServletResponse response, String desTipo)
            throws ServletException, IOException, UsuarioDAOException {


        HttpSession sessao = request.getSession(false);
        CategoriaTipoBean tip = new CategoriaTipoBean(desTipo);
        CategoriaTipoBean oldtip = new CategoriaTipoBean(sessao.getAttribute("Tipo").toString());
        sessao.removeAttribute("Tipo");


        try {

            CategoriaTipoDAO tipo = new CategoriaTipoDAO();
            tipo.alterarTipo(tip, oldtip); //temos que verificar com o Nahim o que é isso???

            request.setAttribute("CategoriaTipoBean", tip);

        } catch (CategoriaTipoDAOException e) {
            request.setAttribute("CategoriaTipoBean", null);
        }

    }

    private void acaoInserirTipo(HttpServletRequest request, HttpServletResponse response, List<CategoriaTipoBean> l)
            throws ServletException, IOException {

        RequestDispatcher rd = null;
        try {
            CategoriaTipoDAO tipo = new CategoriaTipoDAO();
            tipo.inserirTipo(l);
            rd = request.getRequestDispatcher("/sucessoCad.jsp");
            request.getSession().setAttribute("list_aux", null);
            request.getSession().setAttribute("janela", null);


        } catch (Exception sqle) {
            rd = request.getRequestDispatcher("/oops.jsp");
            request.getSession().setAttribute("list_aux", null);
            request.getSession().setAttribute("janela", null);
        }

        rd.forward(request, response);

    }

    private void acaoConsultaRemoverTipo(HttpServletRequest request, HttpServletResponse response, String desTipo)
            throws ServletException, IOException {

        try {
            CategoriaTipoDAO tipo = new CategoriaTipoDAO();
            List<CategoriaTipoBean> lista = (List<CategoriaTipoBean>) tipo.listaTipo(desTipo);
            request.setAttribute("CategoriaTipoBean", lista);

        } catch (Exception sqle) {
            request.setAttribute("CategoriaTipoBean", null);
        }
        RequestDispatcher rd = null;

        rd = request.getRequestDispatcher("/viewRemocaoTipo.jsp");

        rd.forward(request, response);

    }

    private void acaoConsultaRemoverCategoria(HttpServletRequest request, HttpServletResponse response, String desCat)
            throws ServletException, IOException {

        try {
            CategoriaTipoDAO categoria = new CategoriaTipoDAO();
            List<CategoriaTipoBean> lista = (List<CategoriaTipoBean>) categoria.listaCategoria(desCat);
            request.setAttribute("CategoriaTipoBean", lista);

        } catch (Exception sqle) {
            request.setAttribute("CategoriaTipoBean", null);
        }
        RequestDispatcher rd = null;

        rd = request.getRequestDispatcher("/viewRemocaoCategoria.jsp");

        rd.forward(request, response);

    }
    
       private void acaoRemoverTipo(HttpServletRequest request, HttpServletResponse response, String desTipo)
            throws ServletException, IOException, UsuarioDAOException{


       
        CategoriaTipoBean tip = new CategoriaTipoBean(desTipo);
        
      


        try {

            CategoriaTipoDAO tipo = new CategoriaTipoDAO();
            tipo.removerTipo(tip); //temos que verificar com o Nahim o que é isso???

            request.setAttribute("CategoriaTipoBean", tip);

        } catch (CategoriaTipoDAOException e) {
            request.setAttribute("CategoriaTipoBean", null);
        }
 


    }
       private void acaoRemoverCategoria(HttpServletRequest request, HttpServletResponse response, String desCat)
            throws ServletException, IOException , UsuarioDAOException{


        
        CategoriaTipoBean categoria = new CategoriaTipoBean(desCat);
       


        try {

            CategoriaTipoDAO cat = new CategoriaTipoDAO();
            cat.removerCategoria(categoria); //temos que verificar com o Nahim o que é isso???

            request.setAttribute("CategoriaTipoBean", categoria);

        } catch (CategoriaTipoDAOException e) {
            request.setAttribute("CategoriaTipoBean", null);
        }
    }


}
