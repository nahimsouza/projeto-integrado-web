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
            String SQL = "SELECT email, nome FROM usuario WHERE tipo_usuario = 'Usuario'";
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

    public static String getTipo(String email) {
        //Objeto que guarda informacoes da conexao com o SGBD.
        Connection conn;
        //Objeto usado para enviar comandos SQL no SGBD
        java.sql.Statement stmt;

        String sql = "SELECT tipo_usuario FROM usuario where  email='" + email + "'";
        String ret = "";
        try {
            Class.forName("com.microsoft.jdbc.sqlserver.SQLServerDriver").newInstance();
            String conexao = "jdbc:sqlserver://5.176.252.221:1433;databaseName=labbd01";
            String user = "sa", password = "admin";

            conn = DriverManager.getConnection(conexao, user, password);
            stmt = conn.createStatement();
            ResultSet rs = stmt.executeQuery(sql);
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
            conn.close();
        } catch (Exception e) {
            e.printStackTrace();
            System.out.println("Erro.");
        }

        return ret;

    }

    public static void aceitarUsuario(String email) {
        //Objeto que guarda informacoes da conexao com o SGBD.
        Connection conn;
        //Objeto usado para enviar comandos SQL no SGBD
        java.sql.Statement stmt;

        String sql = "UPDATE usuario SET tipo_usuario='Colaborador' WHERE email ='" + email + "'";

        try {
            Class.forName("com.microsoft.jdbc.sqlserver.SQLServerDriver").newInstance();
            String conexao = "jdbc:sqlserver://5.176.252.221:1433;databaseName=labbd01";
            String user = "sa", password = "admin";

            conn = DriverManager.getConnection(conexao, user, password);
            stmt = conn.createStatement();
            stmt.executeUpdate(sql);
            conn.close();
        } catch (Exception e) {
            e.printStackTrace();
            System.out.println("Erro.");
        }
    }

    public static void rejeitarUsuario(String email) {
        //Objeto que guarda informacoes da conexao com o SGBD.
        Connection conn;
        //Objeto usado para enviar comandos SQL no SGBD
        java.sql.Statement stmt;

        String sql = "DELETE FROM usuario WHERE email ='" + email + "'";

        try {
            Class.forName("com.microsoft.jdbc.sqlserver.SQLServerDriver").newInstance();
            String conexao = "jdbc:sqlserver://5.176.252.221:1433;databaseName=labbd01";
            String user = "sa", password = "admin";

            conn = DriverManager.getConnection(conexao, user, password);
            stmt = conn.createStatement();
            stmt.executeUpdate(sql);
            conn.close();
        } catch (Exception e) {
            e.printStackTrace();
            System.out.println("Erro.");
        }
    }

    public static int inserirUsuario(UsuarioBean u) {

        //Objeto que guarda informacoes da conexao com o SGBD.
        Connection conn;
        //Objeto usado para enviar comandos SQL no SGBD
        java.sql.Statement stmt;


        String nome = u.getNome();
        String email = u.getLogin();
        String senha = u.getSenha();
        String dataNasc = u.getDataNasc();
        String tipo = u.getTipo();

        String[] dataNascimento = dataNasc.split("/");
        String data = dataNascimento[2] + "-" + dataNascimento[1] + "-" + dataNascimento[0];

        String sql = "EXEC usp_ins_usuario '" + nome + "', '" + email + "', '" + senha + "', '" + data + "' ";
        String sql2 = "SELECT * FROM usuario WHERE email = '" + email + "'";


        try {
            Class.forName("com.microsoft.jdbc.sqlserver.SQLServerDriver").newInstance();
            String conexao = "jdbc:sqlserver://5.176.252.221:1433;databaseName=labbd01";
            String user = "sa", password = "admin";

            conn = DriverManager.getConnection(conexao, user, password);
            stmt = conn.createStatement();
            ResultSet rs = stmt.executeQuery(sql2);
            if (rs.next()) {
                return 0;
            }
            stmt.executeUpdate(sql);
            conn.close();
            return 1;
        } catch (Exception e) {
            e.printStackTrace();
            System.out.println("Erro.");
        }

        return -1;
    }
}
