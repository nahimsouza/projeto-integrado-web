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

        String sql = "EXEC usp_login '" + usuario + "', '" + senha + "'";

        try {
            Class.forName("com.microsoft.jdbc.sqlserver.SQLServerDriver").newInstance();
            String conexao = "jdbc:sqlserver://5.176.252.221:1433;databaseName=labbd01";
            String user = "sa", password = "admin";

            conn = DriverManager.getConnection(conexao, user, password);
            stmt = conn.createStatement();
            ResultSet rs = stmt.executeQuery(sql);
            rs.next();
           
            boolean ret = rs.getBoolean(1);
            conn.close();
            
            return (ret);
            /*while (rs.next()) {
                String email = rs.getString("email");
                String s = rs.getString("senha");

                if ((usuario.equals(email)) && (senha.equals(s))) {
                    return true;
                }
            }*/
            
        } catch (Exception e) {
            e.printStackTrace();
            System.out.println("Erro.");
        }

        return false;
    }
}
