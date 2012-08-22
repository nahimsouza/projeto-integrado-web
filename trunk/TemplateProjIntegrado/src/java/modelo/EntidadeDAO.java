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
        PreparedStatement ps2 = null;
        ResultSet rs2 = null;

        try {
            // Busca ABSOLUTA por entidade:
            //String SQL = "SELECT displayname, descricao FROM entidade WHERE displayname = '" + displayname + "'";
            //String SQL = "SELECT id_ent, displayname, descricao FROM entidade WHERE displayname='" + displayname +"'";
             String SQL = "EXEC usp_cons_absoluta_entidade'" + displayname + "'";
            conn = this.conn;
            ps = conn.prepareStatement(SQL);
            rs = ps.executeQuery();
        
            
            List<EntidadeBean> list = new ArrayList<EntidadeBean>();
            while (rs.next()) {
                String name = rs.getObject("displayname").toString(); // o nome entre aspas é o nome do campo no BD
                String desc = rs.getObject("descricao").toString();
                //String id = rs.getObject("id_ent").toString();
                //id = Integer.parseInt(a);
                int id = 0;//rs.getInt("1");
                ps2 = conn.prepareStatement("usp_cons_id_entidade '" + name + "'");
                rs2 = ps2.executeQuery();
                while(rs2.next()){
                    id = rs2.getInt(1);
                }
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
            String SQL = "EXEC usp_ins_entidade '" + e.getDisplayname() + "','" + e.getDescricao() + "'";
            conn = this.conn;
            ResultSet rs = null;
            ps = conn.prepareStatement(SQL);
            ps.executeUpdate();
            SQL = "usp_cons_id_entidade '" + e.getDisplayname() + "'";
            int id_ent = 0;
            ps = conn.prepareStatement(SQL);
            rs = ps.executeQuery();
            while (rs.next()) {
                id_ent = rs.getInt(1);
            }
            for (int i = 0; i < wiki.size(); i++) {
                //for (String k : wiki) {
                SQL = "EXEC usp_ins_wiki " + id_ent + ", '" + wiki.get(i) + "'";
                //SQL = "INSERT INTO entWiki (id_ent, wikikey) VALUES ("+id_ent+",'"+ wiki.get(i)+"')";
                conn = this.conn;
                ps = conn.prepareStatement(SQL);
                ps.executeUpdate();
            }

            //CategoriaTipoDAO tipo = new CategoriaTipoDAO();
            //for (CategoriaTipoBean a : l) {
            for (int i = 0; i < l.size(); i++) {
                //tipo = new CategoriaTipoDAO();
                //int id_tipo = tipo.getIdTipo(a.getTipo());
                //tipo.inserirTipoEntidade(id_ent, id_tipo);
                SQL = "EXEC usp_ins_tipo_entidade " + id_ent + ", '" + l.get(i).getIdTipo() + "'";
                conn = this.conn;
                ps = conn.prepareStatement(SQL);
                ps.executeUpdate();
            }
        } catch (SQLException sqle) {
            throw new EntidadeDAOException("Erro ao inserir dados " + sqle);
        } finally {
            ConnectionUsuarioFactory.closeConnection(conn, ps);
        }
    }

    public int getIdEntidade(String displayname) throws EntidadeDAOException, UsuarioDAOException {
        PreparedStatement ps = null;
        Connection conn = null;
        ResultSet rs = null;
        try {
            //String SQL = "EXEC usp_cons_id_entidade '" + e.getDisplayname() +"'";
            String SQL = "SELECT id_ent FROM entidade WHERE displayname= '" + displayname + "'";
            conn = this.conn;
            ps = conn.prepareStatement(SQL);
            rs = ps.executeQuery();
            while (rs.next()) {
                int a = rs.getInt("id_ent");
                return a;
            }
            return 0;

        } catch (SQLException sqle) {
            throw new EntidadeDAOException("Erro ao inserir dados " + sqle);
        } finally {
            ConnectionUsuarioFactory.closeConnection(conn, ps);
        }
    }

    public void removerEntidade(EntidadeBean enti) throws EntidadeDAOException, UsuarioDAOException {
        PreparedStatement ps = null;
        Connection conn = null;



        try {
            String SQL = "EXEC usp_rem_entidade "+enti.getIdEntidade()+"";
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
