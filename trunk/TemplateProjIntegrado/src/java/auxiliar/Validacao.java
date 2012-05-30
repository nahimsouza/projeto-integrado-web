package auxiliar;

import java.beans.Statement;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;

public class Validacao {

    public static boolean isUsuarioValido(String usuario, String senha) {

     /*   //Objeto que guarda informacoes da conexao com o SGBD.
        Connection conn;
        //Objeto usado para enviar comandos SQL no SGBD
        java.sql.Statement stmt;

        String sql = "SELECT email, senha FROM Cliente438359 where  email='" + usuario + "' AND senha='" + senha + "'";

       try {
            Class.forName("").newInstance();
            String conexao = "";
            String user = "", password = "";

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
            System.out.println("Erro");
        }
    
        return false; */
        
        return true;
    }
}
