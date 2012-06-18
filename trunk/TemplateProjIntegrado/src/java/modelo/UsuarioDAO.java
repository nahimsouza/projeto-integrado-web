package modelo;

import auxiliar.*;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.List;
import java.util.ArrayList;

public class UsuarioDAO {

    private Connection conn;

    public UsuarioDAO() throws UsuarioDAOException {
        try {
            this.conn = ConnectionUsuarioFactory.getConnection();

        } catch (Exception e) {
            throw new UsuarioDAOException("Erro: "
                    + ":\n" + e.getMessage());
        }
    }

    public List<UsuarioBean> solicitacoes() throws UsuarioDAOException {
        PreparedStatement ps = null;
        Connection conn = null;
        ResultSet rs = null;


        try {
            String SQL = "Select * from UsuariosPendentes";
            conn = this.conn;
            ps = conn.prepareStatement(SQL);
            rs = ps.executeQuery();
            List<UsuarioBean> list = new ArrayList<UsuarioBean>();
            while (rs.next()) {
                String login = rs.getObject("email").toString();
                UsuarioBean uB = new UsuarioBean();
                uB.setLogin(login);
                uB.setTipo(true);
                list.add(uB);
            }

            return list;

        } catch (SQLException sqle) {
            throw new UsuarioDAOException(sqle);
        } finally {
            ConnectionUsuarioFactory.closeConnection(conn, ps, rs);
        }
    } // fim
}
