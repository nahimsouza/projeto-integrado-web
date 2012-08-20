package modelo;

import auxiliar.*;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.List;
import java.util.ArrayList;

public class CategoriaTipoDAO {

    private Connection conn;

    public CategoriaTipoDAO() throws CategoriaTipoDAOException {
        try {
            this.conn = ConnectionUsuarioFactory.getConnection();

        } catch (Exception e) {
            throw new CategoriaTipoDAOException("Erro: "
                    + ":\n" + e.getMessage());
        }
    }

    public List<CategoriaTipoBean> listaTipo(String tipo) throws CategoriaTipoDAOException, UsuarioDAOException {
        PreparedStatement ps = null;
        Connection conn = null;
        ResultSet rs = null;

        try {
            // Busca ABSOLUTA por entidade:
            //String SQL = "SELECT displayname, descricao FROM entidade WHERE displayname = '" + displayname + "'";
            String SQL = "EXEC usp_cons_busca_absoluta_tipo'/" + tipo + "'";
            conn = this.conn;
            ps = conn.prepareStatement(SQL);
            rs = ps.executeQuery();
            List<CategoriaTipoBean> list = new ArrayList<CategoriaTipoBean>();
            while (rs.next()) {
                int idTipo = (Integer) rs.getObject("id_tipo"); // o nome entre aspas é o nome do campo no BD
                String nome = rs.getObject("tipo").toString();

                list.add(new CategoriaTipoBean(idTipo, nome));
            }

            return list;

        } catch (SQLException sqle) {
            throw new CategoriaTipoDAOException(sqle);
        } finally {
            ConnectionUsuarioFactory.closeConnection(conn, ps, rs);
        }
    } // fim

    public List<CategoriaTipoBean> listaCategoria(String cat) throws CategoriaTipoDAOException, UsuarioDAOException {
        PreparedStatement ps = null;
        Connection conn = null;
        ResultSet rs = null;

        try {
            // Busca ABSOLUTA por entidade:
            //String SQL = "SELECT displayname, descricao FROM entidade WHERE displayname = '" + displayname + "'";
            String SQL = "EXEC usp_cons_busca_absoluta_categoria'/" + cat + "'";
            conn = this.conn;
            ps = conn.prepareStatement(SQL);
            rs = ps.executeQuery();
            List<CategoriaTipoBean> list = new ArrayList<CategoriaTipoBean>();
            while (rs.next()) {
                String categoria = rs.getObject("categoria").toString(); // o nome entre aspas é o nome do campo no BD
                int idCategoria = (Integer) rs.getObject("id_cat");

                list.add(new CategoriaTipoBean(categoria, idCategoria));
            }

            return list;

        } catch (SQLException sqle) {
            throw new CategoriaTipoDAOException(sqle);
        } finally {
            ConnectionUsuarioFactory.closeConnection(conn, ps, rs);
        }
    } // fim

    public List<CategoriaTipoBean> listaTodasCategorias() throws CategoriaTipoDAOException, UsuarioDAOException {
        PreparedStatement ps = null;
        Connection conn = null;
        ResultSet rs = null;

        try {
            String SQL = "EXEC usp_cons_categoria";
            conn = this.conn;
            ps = conn.prepareStatement(SQL);
            rs = ps.executeQuery();
            List<CategoriaTipoBean> list = new ArrayList<CategoriaTipoBean>();
            while (rs.next()) {
                String categoria = rs.getObject("categoria").toString(); // o nome entre aspas é o nome do campo no BD
                int idCategoria = (Integer) rs.getObject("id_cat");
                list.add(new CategoriaTipoBean(categoria, idCategoria));
            }

            return list;

        } catch (SQLException sqle) {
            throw new CategoriaTipoDAOException(sqle);
        } finally {
            ConnectionUsuarioFactory.closeConnection(conn, ps, rs);
        }
    }// fim

    public List<CategoriaTipoBean> listaTipoPorCategoria(int idcat) throws CategoriaTipoDAOException, UsuarioDAOException {
        PreparedStatement ps = null;
        Connection conn = null;
        ResultSet rs = null;

        try {
            String SQL = "EXEC usp_cons_tipos_cat " + idcat;
            conn = this.conn;
            ps = conn.prepareStatement(SQL);
            rs = ps.executeQuery();
            List<CategoriaTipoBean> list = new ArrayList<CategoriaTipoBean>();
            while (rs.next()) {
                int idTipo = (Integer) rs.getObject("id_tipo");
                String tipo = rs.getObject("tipo").toString(); // o nome entre aspas é o nome do campo no BD
                list.add(new CategoriaTipoBean(idTipo, tipo));
            }

            return list;

        } catch (SQLException sqle) {
            throw new CategoriaTipoDAOException(sqle);
        } finally {
            ConnectionUsuarioFactory.closeConnection(conn, ps, rs);
        }
    }// fim

    public List<CategoriaTipoBean> listaTodosTipos() throws CategoriaTipoDAOException, UsuarioDAOException {
        PreparedStatement ps = null;
        Connection conn = null;
        ResultSet rs = null;

        try {
            String SQL = "SELECT * from tipo";
            conn = this.conn;
            ps = conn.prepareStatement(SQL);
            rs = ps.executeQuery();
            List<CategoriaTipoBean> list = new ArrayList<CategoriaTipoBean>();
            while (rs.next()) {
                int idTipo = (Integer) rs.getObject("id_tipo");
                String tipo = rs.getObject("tipo").toString(); // o nome entre aspas é o nome do campo no BD
                list.add(new CategoriaTipoBean(idTipo, tipo));
            }

            return list;

        } catch (SQLException sqle) {
            throw new CategoriaTipoDAOException(sqle);
        } finally {
            ConnectionUsuarioFactory.closeConnection(conn, ps, rs);
        }
    }// fim


    public void inserirTipo(List<CategoriaTipoBean> t) throws CategoriaTipoDAOException, UsuarioDAOException {

        PreparedStatement ps = null;
        Connection conn = null;
        ResultSet rs = null;
        CategoriaTipoBean temp;
        try {//falta terminar
            for (int i = 0; i < t.size(); i++) {
                temp = t.get(i);
                String SQL = "EXEC usp_ins_tipo '" + temp.getTipo() + "'," + temp.getIdCategoria();
                conn = this.conn;
                ps = conn.prepareStatement(SQL);
                ps.executeUpdate();
            }

        } catch (SQLException sqle) {
            throw new CategoriaTipoDAOException(sqle);
        } finally {
            ConnectionUsuarioFactory.closeConnection(conn, ps, rs);
        }
    }

    public void inserirCategoria(String categoria) throws CategoriaTipoDAOException, UsuarioDAOException {
        PreparedStatement ps = null;
        Connection conn = null;
        if (categoria == null) {
            throw new CategoriaTipoDAOException("O valor passado não pode ser nulo");
        }

        try {
            String SQL = "EXEC usp_ins_categoria'" + categoria + "'";
            conn = this.conn;
            ps = conn.prepareStatement(SQL);
            ps.executeUpdate();

        } catch (SQLException sqle) {
            throw new CategoriaTipoDAOException("Erro ao inserir dados " + sqle);
        } finally {
            ConnectionUsuarioFactory.closeConnection(conn, ps);
        }
    }
     public void alterarCategoria(CategoriaTipoBean novaCategoria,CategoriaTipoBean categoria) throws CategoriaTipoDAOException, UsuarioDAOException {
        PreparedStatement ps = null;
        Connection conn = null;
        
        if (categoria == null) {
            throw new CategoriaTipoDAOException("O valor passado não pode ser nulo");
        }

        try {
           String SQL = "UPDATE categoria SET categoria='"+ novaCategoria.getCategoria() +"' WHERE categoria='" + categoria.getCategoria() + "'";
            conn = this.conn;
            ps = conn.prepareStatement(SQL);
            ps.executeUpdate();

        } catch (SQLException sqle) {
            throw new CategoriaTipoDAOException("Erro ao inserir dados " + sqle);
        } finally {
            ConnectionUsuarioFactory.closeConnection(conn, ps);
        }
    }
       public void alterarTipo(CategoriaTipoBean novoTipo,CategoriaTipoBean tipo) throws CategoriaTipoDAOException, UsuarioDAOException {
        PreparedStatement ps = null;
        Connection conn = null;
        
        if (novoTipo == null) {
            throw new CategoriaTipoDAOException("O valor passado não pode ser nulo");
        }

        try {
           String SQL = "UPDATE tipo SET tipo='"+ novoTipo.getTipo() +"' WHERE tipo='" + tipo.getTipo() + "'";
            conn = this.conn;
            ps = conn.prepareStatement(SQL);
            ps.executeUpdate();

        } catch (SQLException sqle) {
            throw new CategoriaTipoDAOException("Erro ao inserir dados " + sqle);
        } finally {
            ConnectionUsuarioFactory.closeConnection(conn, ps);
        }
    }
}
