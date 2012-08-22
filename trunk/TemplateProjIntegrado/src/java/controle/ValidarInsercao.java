package controle;

import java.io.IOException;
import java.util.List;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import modelo.*;

public class ValidarInsercao extends HttpServlet {

    protected void doPost(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {

        String metodo = (String) request.getParameter("metodo");

        if (metodo.equals("insere")) {
            insere(request, response);
        } else if (metodo.equals("remove")) {
            remove(request, response);
        } else if (metodo.equals("insereCat")) {
            insereCat(request, response);
        } else if (metodo.equals("removeCat")) {
            removeCat(request, response);
        } else if (metodo.equals("insereWiki")) {
            insereWiki(request, response);
        } else if (metodo.equals("removeWiki")) {
            removeWiki(request, response);
        } else if (metodo.equals("insereCatTipo")) {
            insereCatTipo(request, response);
        } else if (metodo.equals("removeCatTipo")) {
            removeCatTipo(request, response);
        }
    }

    private void insere(HttpServletRequest request, HttpServletResponse response) throws IOException {
        String tipo_lista = request.getParameter("tipoid");
        List<String> list = (List<String>) request.getSession().getAttribute("list_aux");
        String categoria_lista = request.getParameter("catid");
        String categorianome = request.getParameter("catnome");
        categorianome = categorianome.split("/")[1];
        list.add(categoria_lista + "," + tipo_lista + "," + categorianome);
        request.getSession().setAttribute("list_aux", list);
        request.getSession().setAttribute("janela", "b");
        response.sendRedirect("insercao.jsp");
    }

    private void remove(HttpServletRequest request, HttpServletResponse response) throws IOException {
        String tipo_lista = (String) request.getParameter("selected");
        List<String> list = (List<String>) request.getSession().getAttribute("list_aux");
        list.remove(tipo_lista);
        request.getSession().setAttribute("list_aux", list);
        request.getSession().setAttribute("janela", "b");
        response.sendRedirect("insercao.jsp");
    }

    private void insereCat(HttpServletRequest request, HttpServletResponse response) throws IOException {
        List<String> list = (List<String>) request.getSession().getAttribute("list_cat");
        String categoria = request.getParameter("catnome");
        list.add(categoria);
        request.getSession().setAttribute("list_cat", list);
        request.getSession().setAttribute("janela", "a");
        response.sendRedirect("insercao.jsp");
    }

    private void removeCat(HttpServletRequest request, HttpServletResponse response) throws IOException {
        String cat_lista = (String) request.getParameter("selected");
        List<String> list = (List<String>) request.getSession().getAttribute("list_cat");
        list.remove(cat_lista);
        request.getSession().setAttribute("list_cat", list);
        request.getSession().setAttribute("janela", "a");
        response.sendRedirect("insercao.jsp");
    }

    private void insereWiki(HttpServletRequest request, HttpServletResponse response) throws IOException {
        String displayname = request.getParameter("displayname");
        String descricao = request.getParameter("descricao");
        request.getSession().setAttribute("descricao", descricao);
        request.getSession().setAttribute("displayname", displayname);
        List<String> list = (List<String>) request.getSession().getAttribute("list_cat");
        String wiki = request.getParameter("catnome");
        list.add(wiki);
        request.getSession().setAttribute("list_cat", list);
        request.getSession().setAttribute("janela", null);
        response.sendRedirect("insercao.jsp");
    }

    private void removeWiki(HttpServletRequest request, HttpServletResponse response) throws IOException {
        String displayname = request.getParameter("displayname");
        String descricao = request.getParameter("descricao");
        request.getSession().setAttribute("descricao", descricao);
        request.getSession().setAttribute("displayname", displayname);
        String cat_lista = (String) request.getParameter("selected");
        List<String> list = (List<String>) request.getSession().getAttribute("list_cat");
        list.remove(cat_lista);
        request.getSession().setAttribute("list_cat", list);
        request.getSession().setAttribute("janela", null);
        response.sendRedirect("insercao.jsp");
    }
    
    private void insereCatTipo(HttpServletRequest request, HttpServletResponse response) throws IOException {
        String displayname = request.getParameter("displayname");
        String descricao = request.getParameter("descricao");
        request.getSession().setAttribute("descricao", descricao);
        request.getSession().setAttribute("displayname", displayname);
        String tiponome = request.getParameter("tiponome");
        List<String> list = (List<String>) request.getSession().getAttribute("list_aux");
        String categoria_lista = request.getParameter("catid");
        String categorianome = request.getParameter("catnome");
        categorianome = categorianome.split("/")[1];
        tiponome = tiponome.split("/")[1];
        list.add(categoria_lista + "," + tiponome + "," + categorianome);
        request.getSession().setAttribute("list_aux", list);
        request.getSession().setAttribute("janela", null);
        response.sendRedirect("insercao.jsp");
    }

    private void removeCatTipo(HttpServletRequest request, HttpServletResponse response) throws IOException {
        String displayname = request.getParameter("displayname");
        String descricao = request.getParameter("descricao");
        request.getSession().setAttribute("descricao", descricao);
        request.getSession().setAttribute("displayname", displayname);
        String tipo_lista = (String) request.getParameter("selected");
        List<String> list = (List<String>) request.getSession().getAttribute("list_aux");
        list.remove(tipo_lista);
        request.getSession().setAttribute("list_aux", list);
        request.getSession().setAttribute("janela", null);
        response.sendRedirect("insercao.jsp");
    }
}