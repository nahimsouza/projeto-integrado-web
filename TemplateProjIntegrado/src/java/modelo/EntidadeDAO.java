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
                
                list.add(new EntidadeBean(name,desc));
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
                
                list.add(new EntidadeBean(name,desc));
            }

            return list;

        } catch (SQLException sqle) {
            throw new EntidadeDAOException(sqle);
        } finally {
            ConnectionUsuarioFactory.closeConnection(conn, ps, rs);
        }
    } // fim
        
        public List<EntidadeBean> listaAvancada(int in, int not) throws EntidadeDAOException, UsuarioDAOException {
        PreparedStatement ps = null;
        Connection conn = null;
        ResultSet rs = null;

        try {
            // Busca avancada:
            //String SQL = "SELECT displayname, descricao FROM entidade WHERE displayname = '" + displayname + "'";
            String SQL = "EXEC usp_cons_xdify " + in + "," + not;
            conn = this.conn;
            ps = conn.prepareStatement(SQL);
            rs = ps.executeQuery();
            List<EntidadeBean> list = new ArrayList<EntidadeBean>();
            while (rs.next()) {
                String name = rs.getObject("displayname").toString(); // o nome entre aspas é o nome do campo no BD
                String desc = rs.getObject("descricao").toString();
                
                list.add(new EntidadeBean(name,desc));
            }

            return list;

        } catch (SQLException sqle) {
            throw new EntidadeDAOException(sqle);
        } finally {
            ConnectionUsuarioFactory.closeConnection(conn, ps, rs);
        }
    } // fim
}


    // inclui filme no BD
 /*   public void salvar(EntidadeBean entidade, CategoriaTipoBean categoria) throws EntidadeDAOException {
        PreparedStatement ps = null;
        Connection conn = null;
        ResultSet rs = null;
        if (entidade == null) {
            throw new EntidadeDAOException("O valor passado não pode ser nulo");
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
            throw new EntidadeDAOException("Erro ao inserir dados " + sqle);
        } finally {
            ConnectionUsuarioFactory.closeConnection(conn, ps);

        }
    }// fim salvar

    // consulta filmes por código
    public EntidadeBean consultar(int cod) throws EntidadeDAOException {
        PreparedStatement ps = null;
        Connection conn = null;
        ResultSet rs = null;
        EntidadeBean novo = null;

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
                novo = new EntidadeBean(cod, titulo, categoria, ano_prod, preco);
            }

            return novo;

        } catch (SQLException sqle) {
            throw new EntidadeDAOException(sqle);
        } finally {
            ConnectionUsuarioFactory.closeConnection(conn, ps, rs);
        }
    } // fim 
*/