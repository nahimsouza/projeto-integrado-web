package modelo;

import auxiliar.*;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.List;
import java.util.ArrayList;

public class EntidadeDAO {

    private Connection conn;

    public EntidadeDAO() throws EntidadeDAOException {
        try {
            this.conn = ConnectionUsuarioFactory.getConnection();

        } catch (Exception e) {
            throw new EntidadeDAOException("Erro: "
                    + ":\n" + e.getMessage());
        }
    }

    public List<EntidadeBean> listaEntidades(String displayname) throws EntidadeDAOException, UsuarioDAOException {
        PreparedStatement ps = null;
        Connection conn = null;
        ResultSet rs = null;

        try {
            // Busca ABSOLUTA por entidade:
            //String SQL = "SELECT displayname, descricao FROM entidade WHERE displayname = '" + displayname + "'";
            String SQL = "EXEC usp_cons_busca_absoluta'" + displayname + "'";
            conn = this.conn;
            ps = conn.prepareStatement(SQL);
            rs = ps.executeQuery();
            List<EntidadeBean> list = new ArrayList<EntidadeBean>();
            while (rs.next()) {
                String name = rs.getObject("displayname").toString(); // o nome entre aspas é o nome do campo no BD
                String desc = rs.getObject("descricao").toString();

                list.add(new EntidadeBean(name, desc));
            }

            return list;

        } catch (SQLException sqle) {
            throw new EntidadeDAOException(sqle);
        } finally {
            ConnectionUsuarioFactory.closeConnection(conn, ps, rs);
        }
    } // fim

    public List<EntidadeBean> listaEntidadesR(String displayname) throws EntidadeDAOException, UsuarioDAOException {
        PreparedStatement ps = null;
        Connection conn = null;
        ResultSet rs = null;

        try {
            // Busca ABSOLUTA por entidade:
            //String SQL = "SELECT displayname, descricao FROM entidade WHERE displayname = '" + displayname + "'";
            String SQL = "EXEC usp_cons_busca_relativa'" + displayname + "'";
            conn = this.conn;
            ps = conn.prepareStatement(SQL);
            rs = ps.executeQuery();
            List<EntidadeBean> list = new ArrayList<EntidadeBean>();
            while (rs.next()) {
                String name = rs.getObject("displayname").toString(); // o nome entre aspas é o nome do campo no BD
                String desc = rs.getObject("descricao").toString();

                list.add(new EntidadeBean(name, desc));
            }

            return list;

        } catch (SQLException sqle) {
            throw new EntidadeDAOException(sqle);
        } finally {
            ConnectionUsuarioFactory.closeConnection(conn, ps, rs);
        }
    } // fim

    public List<EntidadeBean> listaAvancada(int tipoP,int tipoNP) throws EntidadeDAOException, UsuarioDAOException {
        PreparedStatement ps = null;
        Connection conn = null;
        ResultSet rs = null;

        try {
            // Busca avancada:
            //String SQL = "SELECT displayname, descricao FROM entidade WHERE displayname = '" + displayname + "'";
            String SQL = "EXEC usp_cons_xdify " +  tipoP + "," + tipoNP;
            conn = this.conn;
            ps = conn.prepareStatement(SQL);
            rs = ps.executeQuery();
            List<EntidadeBean> list = new ArrayList<EntidadeBean>();
            while (rs.next()) {
                String name = rs.getObject("displayname").toString(); // o nome entre aspas é o nome do campo no BD
                String desc = rs.getObject("descricao").toString();
                list.add(new EntidadeBean(name, desc));
            }

            return list;

        } catch (SQLException sqle) {
            throw new EntidadeDAOException(sqle);
        } finally {
            ConnectionUsuarioFactory.closeConnection(conn, ps, rs);
        }
    } // fim
}
