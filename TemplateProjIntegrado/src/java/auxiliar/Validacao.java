package auxiliar;

import java.beans.Statement;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import modelo.UsuarioBean;

public class Validacao {

    public static boolean isUsuarioValido(String usuario, String senha) {

        //Objeto que guarda informacoes da conexao com o SGBD.
        Connection conn;
        //Objeto usado para enviar comandos SQL no SGBD
        java.sql.Statement stmt;

        String sql = "SELECT email, senha FROM usuario where  email='" + usuario + "' AND senha='" + senha + "'";

        try {
            Class.forName("com.microsoft.jdbc.sqlserver.SQLServerDriver").newInstance();
            String conexao = "jdbc:sqlserver://5.176.252.221:1433;databaseName=labbd01";
            String user = "sa", password = "admin";

            conn = DriverManager.getConnection(conexao, user, password);
            stmt = conn.createStatement();
            ResultSet rs = stmt.executeQuery(sql);
            while (rs.next()) {
                String email = rs.getString("email");
                String s = rs.getString("senha");

                if ((usuario.equals(email)) && (senha.equals(s))) {
                    return true;
                }
            }
            conn.close();
        } catch (Exception e) {
            e.printStackTrace();
            System.out.println("Erro.");
        }

        return false;
    }

    public static boolean getTipo(String email, String senha) {
        //Objeto que guarda informacoes da conexao com o SGBD.
        Connection conn;
        //Objeto usado para enviar comandos SQL no SGBD
        java.sql.Statement stmt;

        String sql = "SELECT tipo_usuario FROM usuario where  email='" + email + "' AND senha='" + senha + "'";

        try {
            Class.forName("com.microsoft.jdbc.sqlserver.SQLServerDriver").newInstance();
            String conexao = "jdbc:sqlserver://5.176.252.221:1433;databaseName=labbd01";
            String user = "sa", password = "admin";

            conn = DriverManager.getConnection(conexao, user, password);
            stmt = conn.createStatement();
            ResultSet rs = stmt.executeQuery(sql);
            while (rs.next()) {
                String tipo = rs.getString("tipo_usuario");

                if (tipo.equals("Colaborador")) {
                    return true;
                }
                else
                    return false;
            }
            conn.close();
        } catch (Exception e) {
            e.printStackTrace();
            System.out.println("Erro.");
        }

        return false;

    }

    public static boolean inserirUsuario(UsuarioBean u) {

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
        
        String sql = "INSERT INTO usuario(tipo_usuario, nome, email, senha, data_nasc) VALUES ( '" + tipo + "', '" + nome + "', '" + email + "', '" + senha + "', '"+ data + "')";


        try {
            Class.forName("com.microsoft.jdbc.sqlserver.SQLServerDriver").newInstance();
            String conexao = "jdbc:sqlserver://5.176.252.221:1433;databaseName=labbd01";
            String user = "sa", password = "admin";

            conn = DriverManager.getConnection(conexao, user, password);
            stmt = conn.createStatement();
            stmt.executeUpdate(sql);
            conn.close();
            return true;
        } catch (Exception e) {
            e.printStackTrace();
            System.out.println("Erro.");
        }

        return false;
    }
}
