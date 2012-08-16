package modelo;

import auxiliar.*;
import java.sql.*;
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
            //String SQL = "SELECT email, nome FROM usuario WHERE tipo_usuario = 'Usuario'";
            String SQL = "EXEC usp_cons_novos_usuarios";
            conn = this.conn;
            ps = conn.prepareStatement(SQL);
            rs = ps.executeQuery();
            List<UsuarioBean> list = new ArrayList<UsuarioBean>();
            while (rs.next()) {
                String login = rs.getObject("email").toString();
                String nome = rs.getObject("nome").toString();
                UsuarioBean uB = new UsuarioBean();
                uB.setLogin(login);
                uB.setNome(nome);
                uB.setTipo("Usuario");
                list.add(uB);
            }

            return list;

        } catch (SQLException sqle) {
            throw new UsuarioDAOException(sqle);
        } finally {
            ConnectionUsuarioFactory.closeConnection(conn, ps, rs);
        }
    }

    public UsuarioBean consultarUsuario(String email) throws UsuarioDAOException {
        PreparedStatement ps = null;
        Connection conn = null;
        ResultSet rs = null;
        UsuarioBean usuario = null;

        try {
            String SQL = "EXEC usp_cons_usuario '" + email + "'";
            conn = this.conn;
            ps = conn.prepareStatement(SQL);
            rs = ps.executeQuery();

            while (rs.next()) {

                String nome = rs.getObject("nome").toString();
                String e_mail = rs.getObject("email").toString();
                String dataNasc = rs.getObject("data_nasc").toString();

                String[] dataNascimento = dataNasc.split("-");
                String data = dataNascimento[2] + "/" + dataNascimento[1] + "/" + dataNascimento[0];

                usuario = new UsuarioBean(nome, e_mail, data);
            }

            return usuario;

        } catch (SQLException sqle) {
            throw new UsuarioDAOException(sqle);
        } finally {
            ConnectionUsuarioFactory.closeConnection(conn, ps, rs);
        }
    } // fim 

    public UsuarioBean consultarColaborador(String email) throws UsuarioDAOException {
        PreparedStatement ps = null;
        Connection conn = null;
        ResultSet rs = null;
        UsuarioBean usuario = null;

        try {
            String SQL = "EXEC usp_cons_colaborador";
            conn = this.conn;
            ps = conn.prepareStatement(SQL);
            rs = ps.executeQuery();

            while (rs.next()) {

                String nome = rs.getObject("nome").toString();
                String e_mail = rs.getObject("email").toString();
                String dataNasc = rs.getString("data_nasc");

                String[] dataNascimento = dataNasc.split("-");
                String data = dataNascimento[2] + "/" + dataNascimento[1] + "/" + dataNascimento[0];

                usuario = new UsuarioBean(nome, e_mail, data);
            }

            return usuario;

        } catch (SQLException sqle) {
            throw new UsuarioDAOException(sqle);
        } finally {
            ConnectionUsuarioFactory.closeConnection(conn, ps, rs);
        }
    } // fim 

    public String getTipo(String email) throws UsuarioDAOException {

        PreparedStatement ps = null;
        Connection conn = null;
        ResultSet rs = null;
        String ret = "";

        try {
            //String sql = "SELECT tipo_usuario FROM usuario where  email='" + email + "'";
            String SQL = "EXEC usp_cons_tipo_usuario '" + email + "'";
            conn = this.conn;
            ps = conn.prepareStatement(SQL);
            rs = ps.executeQuery();
            String tipo;
            while (rs.next()) {
                tipo = rs.getString("tipo_usuario");

                if (tipo.equals("Colaborador")) {
                    ret = "Colaborador";
                } else if (tipo.equals("Usuario")) {
                    ret = "Usuario";
                } else {
                    ret = "Administrador";
                }
            }

        } catch (SQLException sqle) {
            throw new UsuarioDAOException(sqle);
        } finally {
            ConnectionUsuarioFactory.closeConnection(conn, ps, rs);
        }
        return ret;
    }

    public void aceitarUsuario(String email) throws UsuarioDAOException {
        PreparedStatement ps = null;
        Connection conn = null;
        ResultSet rs = null;

        try {
            //String sql = "UPDATE usuario SET tipo_usuario='Colaborador' WHERE email='" + email + "'";
            String SQL = "EXEC usp_aceitar_usuario '" + email + "'";
            conn = this.conn;
            ps = conn.prepareStatement(SQL);
            ps.executeUpdate();

        } catch (SQLException sqle) {
            throw new UsuarioDAOException(sqle);
        } finally {
            ConnectionUsuarioFactory.closeConnection(conn, ps, rs);
        }
    }

    public void rejeitarUsuario(String email) throws UsuarioDAOException {
        PreparedStatement ps = null;
        Connection conn = null;
        ResultSet rs = null;

        try {
            //String sql = "DELETE FROM usuario WHERE email ='" + email + "'";
            String SQL = "EXEC usp_rem_usuario '" + email + "'";
            conn = this.conn;
            ps = conn.prepareStatement(SQL);
            ps.executeUpdate();

            // realiza uma consulta para confirmar se foi excluido -- é necessario?
          /*
             * SQL = "EXEC usp_cons_usuario '" + email + "'"; ps =
             * conn.prepareStatement(SQL); rs = ps.executeQuery();
             * if(rs.next()!=null){ FAZ ALGUMA COISA QUE RETORNE QUE A OPERAÇÃO
             * NÃO FOI REALIZADA }
             *
             */
        } catch (SQLException sqle) {
            throw new UsuarioDAOException(sqle);
        } finally {
            ConnectionUsuarioFactory.closeConnection(conn, ps, rs);
        }
    }

    public int inserirUsuario(UsuarioBean u) throws UsuarioDAOException {
        PreparedStatement ps = null;
        Connection conn = null;
        ResultSet rs = null;

        try {
            String nome = u.getNome();
            String email = u.getLogin();
            String senha = u.getSenha();
            String dataNasc = u.getDataNasc();
            String tipo = u.getTipo();

            String[] dataNascimento = dataNasc.split("/");
            String data = dataNascimento[2] + "-" + dataNascimento[1] + "-" + dataNascimento[0];

            String sql = "EXEC usp_ins_usuario '" + nome + "', '" + email + "', '" + senha + "', '" + data + "' ";
            //String sql2 = "SELECT * FROM usuario WHERE email = '" + email + "'";
            String sql2 = "EXEC usp_cons_usuario '" + email + "'";
            conn = this.conn;
            ps = conn.prepareStatement(sql2);
            rs = ps.executeQuery();
            if (rs.next()) {
                return 0;
            }
            ps = conn.prepareStatement(sql);
            ps.executeUpdate();
            return 1;

        } catch (SQLException sqle) {
            throw new UsuarioDAOException(sqle);
        } finally {
            ConnectionUsuarioFactory.closeConnection(conn, ps, rs);
        }
    }

    public void alterarUsuario(UsuarioBean u, String e) throws UsuarioDAOException {
        PreparedStatement ps = null;
        Connection conn = null;
        ResultSet rs = null;

        try {
            String nome = u.getNome();
            String email = u.getLogin();
            String senha = u.getSenha();
            String dataNasc = u.getDataNasc();
            List<String> sql = new ArrayList<String>();
            
            if (nome != "") {
                sql.add("UPDATE usuario SET nome='" + nome + "' WHERE email='" + e + "'");
            }
            if (email != "") {
                sql.add("UPDATE usuario SET email='" + email + "' WHERE email='" + e + "'");
            }
            if (senha != "") {
                sql.add("UPDATE usuario SET senha='" + senha + "' WHERE email='" + e + "'");
            }
            if (dataNasc != "") {
                String[] dataNascimento = dataNasc.split("/");
                String data = dataNascimento[2] + "-" + dataNascimento[1] + "-" + dataNascimento[0];
                sql.add("UPDATE usuario SET data_nasc='" + data + "' WHERE email='" + e + "'");
            }

            conn = this.conn;
            for(int i = 0;i<sql.size();i++){
                ps = conn.prepareStatement(sql.get(i));
                ps.executeUpdate();
            }
        
        } catch (SQLException sqle) {
            throw new UsuarioDAOException(sqle);
        } finally {
            ConnectionUsuarioFactory.closeConnection(conn, ps, rs);
        }
    }

    public boolean isUsuarioValido(String usuario, String senha) throws UsuarioDAOException {

        PreparedStatement ps = null;
        Connection conn = null;
        ResultSet rs = null;


        try {
            String SQL = "EXEC usp_login '" + usuario + "', '" + senha + "'";
            conn = this.conn;
            ps = conn.prepareStatement(SQL);
            rs = ps.executeQuery();
            rs.next();
            boolean ret = rs.getBoolean(1);
            return (ret);

            /*
             * while (rs.next()) { String email = rs.getString("email"); String
             * s = rs.getString("senha");
             *
             * if ((usuario.equals(email)) && (senha.equals(s))) { return true;
             * } }
             */

        } catch (SQLException sqle) {
            throw new UsuarioDAOException(sqle);
        } finally {
            ConnectionUsuarioFactory.closeConnection(conn, ps, rs);
        }
    }

    public String getNome(String email) throws UsuarioDAOException {

        PreparedStatement ps = null;
        Connection conn = null;
        ResultSet rs = null;
        String ret = "";

        try {
            //String sql = "SELECT nome FROM usuario where  email='" + email + "'";
            String SQL = "EXEC usp_cons_nome '" + email + "'";
            conn = this.conn;
            ps = conn.prepareStatement(SQL);
            rs = ps.executeQuery();
            String name;
            while (rs.next()) {
                name = rs.getString("nome");
                ret = name + "";
            }

        } catch (SQLException sqle) {
            throw new UsuarioDAOException(sqle);
        } finally {
            ConnectionUsuarioFactory.closeConnection(conn, ps, rs);
        }
        return ret;
    }
}