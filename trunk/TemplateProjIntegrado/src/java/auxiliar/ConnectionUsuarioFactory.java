package auxiliar;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.Statement;
import modelo.UsuarioDAOException;

public class ConnectionUsuarioFactory {

    public static Connection getConnection() throws UsuarioDAOException {
        try {
            Class.forName("com.microsoft.jdbc.sqlserver.SQLServerDriver").newInstance();
            //String conexao = "jdbc:sqlserver://shelton.sor.ufscar.br:1433;database=labbd06"; //192.168.12.4
            //String usuario = "labbd06", senha = "turma06";
            
            String conexao = "jdbc:sqlserver://5.133.123.253:1433;databaseName=labbd01"; //192.168.12.4
            //String conexao = "jdbc:sqlserver://localhost:1433;databaseName=labbd01"; //192.168.12.4
            String usuario = "sa", senha = "admin";
            Connection conn = DriverManager.getConnection(conexao, usuario, senha);
            return conn;
        } catch (Exception e) {
            throw new UsuarioDAOException(e.getMessage());
        }
    }

    public static void closeConnection(Connection conn, Statement stmt, ResultSet rs) throws UsuarioDAOException {
        close(conn, stmt, rs);
    }

    public static void closeConnection(Connection conn, Statement stmt)
            throws UsuarioDAOException {
        close(conn, stmt, null);
    }

    public static void closeConnection(Connection conn)
            throws UsuarioDAOException {
        close(conn, null, null);
    }

    private static void close(Connection conn, Statement stmt, ResultSet rs)
            throws UsuarioDAOException {
        try {
            if (rs != null) {
                rs.close();
            }
            if (stmt != null) {
                stmt.close();
            }
            if (conn != null) {
                conn.close();
            }
        } catch (Exception e) {
            throw new UsuarioDAOException(e.getMessage());
        }
    }
}
