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
                int id = rs.getInt("1");
                list.add(new EntidadeBean(name, desc, id));
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

    public List<EntidadeBean> listaAvancada(int tipoP, int tipoNP) throws EntidadeDAOException, UsuarioDAOException {
        PreparedStatement ps = null;
        Connection conn = null;
        ResultSet rs = null;

        try {
            // Busca avancada:
            //String SQL = "SELECT displayname, descricao FROM entidade WHERE displayname = '" + displayname + "'";
            String SQL = "EXEC usp_cons_xdify " + tipoP + "," + tipoNP;
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
    }

    public void inserirEntidade(EntidadeBean e, List<String> wiki, List<CategoriaTipoBean> l) throws EntidadeDAOException, UsuarioDAOException, CategoriaTipoDAOException {
        PreparedStatement ps = null;
        Connection conn = null;
        if (e.getDisplayname() == null) {
            throw new EntidadeDAOException("O valor passado não pode ser nulo");
        }

        try {
            String SQL = "EXEC usp_ins_entidade'" + e.getDisplayname() + "','" + e.getDescricao() + "'";
            conn = this.conn;
            ps = conn.prepareStatement(SQL);
            ps.executeUpdate();
            int id_ent = this.getIdEntidade(e);
            for (String k : wiki) {
                SQL = "EXEC usp_ins_wiki " + id_ent + ",'" + k + "'";
                conn = this.conn;
                ps = conn.prepareStatement(SQL);
                ps.executeUpdate();
            }
            CategoriaTipoDAO tipo = new CategoriaTipoDAO();
            tipo.inserirTipo(l);
            for (CategoriaTipoBean a : l) {
                tipo = new CategoriaTipoDAO();
                int id_tipo = tipo.getIdTipo(a);
                tipo.inserirTipoEntidade(id_ent, id_tipo);
            }


        } catch (SQLException sqle) {
            throw new EntidadeDAOException("Erro ao inserir dados " + sqle);
        } finally {
            ConnectionUsuarioFactory.closeConnection(conn, ps);
        }
    }

    public int getIdEntidade(EntidadeBean e) throws EntidadeDAOException, UsuarioDAOException {
        PreparedStatement ps = null;
        Connection conn = null;
        ResultSet rs = null;
        try {
            String SQL = "EXEC usp_cons_id_entidade '" + e.getDisplayname() + "'";
            conn = this.conn;
            ps = conn.prepareStatement(SQL);
            rs = ps.executeQuery();
            int id = 0;
            while (rs.next()) {
                id = (Integer) rs.getObject("id_ent");
            }
            return id;

        } catch (SQLException sqle) {
            throw new EntidadeDAOException("Erro ao inserir dados " + sqle);
        } finally {
            ConnectionUsuarioFactory.closeConnection(conn, ps);
        }
    }

    public void removerEntidade(EntidadeBean tipo) throws EntidadeDAOException, UsuarioDAOException {
        PreparedStatement ps = null;
        Connection conn = null;



        try {
            String SQL = "";
            conn = this.conn;
            ps = conn.prepareStatement(SQL);
            ps.executeUpdate();

        } catch (SQLException sqle) {
            throw new EntidadeDAOException("Erro ao inserir dados " + sqle);
        } finally {
            ConnectionUsuarioFactory.closeConnection(conn, ps);
        }
    }
}
