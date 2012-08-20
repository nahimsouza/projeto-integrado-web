package controle;

import java.io.IOException;
import java.util.List;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import modelo.*;

public class ValidarInsercao extends HttpServlet {

    protected void doPost(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        
        String tipo_lista = request.getParameter("tipoid");
        List<String> list = (List<String>) request.getSession().getAttribute("list_aux");
        String categoria_lista = request.getParameter("catid");
        String categorianome = request.getParameter("catnome");
        categorianome = categorianome.split("/")[1];
        list.add(categoria_lista + "," + tipo_lista + "," + categorianome);
        request.getSession().setAttribute("list_aux", list);
        response.sendRedirect("insercao.jsp");
    }
}