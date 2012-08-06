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

    public void inserirCategoria(List<CategoriaTipoBean> c) throws CategoriaTipoDAOException, UsuarioDAOException {
        
       PreparedStatement ps = null;
        Connection conn = null;
        ResultSet rs = null;
        
         try {//falta terminar
            String SQL = "";
            conn = this.conn;
            ps = conn.prepareStatement(SQL);
            rs = ps.executeQuery();
            
            
         } catch (SQLException sqle) {
            throw new CategoriaTipoDAOException(sqle);
        } finally {
            ConnectionUsuarioFactory.closeConnection(conn, ps, rs);
        }
    }
    public void inserirTipo(List<CategoriaTipoBean> t) throws CategoriaTipoDAOException, UsuarioDAOException {
        
       PreparedStatement ps = null;
        Connection conn = null;
        ResultSet rs = null;
        
         try {//falta terminar
            String SQL = "";
            conn = this.conn;
            ps = conn.prepareStatement(SQL);
            rs = ps.executeQuery();
            
            
         } catch (SQLException sqle) {
            throw new CategoriaTipoDAOException(sqle);
        } finally {
            ConnectionUsuarioFactory.closeConnection(conn, ps, rs);
        }
    }
}
// inclui filme no BD
 /*   public void salvar(CategoriaTipoBean entidade, CategoriaTipoBean categoria) throws CategoriaTipoDAOException {
        PreparedStatement ps = null;
        Connection conn = null;
        ResultSet rs = null;
        if (entidade == null) {
            throw new CategoriaTipoDAOException("O valor passado não pode ser nulo");
        }

        try {

            String nomeEntidade = entidade.getDisplayname();
            String descEntidade = entidade.getDescricao();
            String SQL = "INSERT INTO entidade(displayname,descricao)"
                    + "values ('" + titulo + "','" + categoria + "')";
            conn = this.conn;
            ps = conn.prepareStatement(SQL, ps.RETURN_GENERATED_KEYS);
            ps.executeUpdate();
            rs = ps.getGeneratedKeys();
            if (rs.next()) {
                categoria.setIdEntidade(rs.getInt("nomeEntidade"));
            } else {
                throw new SQLException("Creating user failed, no generated key obtained.");
            }

        } catch (SQLException sqle) {
            throw new CategoriaTipoDAOException("Erro ao inserir dados " + sqle);
        } finally {
            ConnectionUsuarioFactory.closeConnection(conn, ps);

        }
    }// fim salvar

    // consulta filmes por código
    public CategoriaTipoBean consultar(int cod) throws CategoriaTipoDAOException {
        PreparedStatement ps = null;
        Connection conn = null;
        ResultSet rs = null;
        CategoriaTipoBean novo = null;

        try {
            String SQL = "Select * from LocaLuciana where codigo=" + cod;
            conn = this.conn;
            ps = conn.prepareStatement(SQL);
            rs = ps.executeQuery();

            while (rs.next()) {

                String titulo = rs.getObject("titulo").toString();
                int ano_prod = (Integer) rs.getObject("ano");
                double preco = rs.getDouble("preco");
                String categoria = rs.getObject("categoria").toString();
                novo = new CategoriaTipoBean(cod, titulo, categoria, ano_prod, preco);
            }

            return novo;

        } catch (SQLException sqle) {
            throw new CategoriaTipoDAOException(sqle);
        } finally {
            ConnectionUsuarioFactory.closeConnection(conn, ps, rs);
        }
    } // fim 
*/