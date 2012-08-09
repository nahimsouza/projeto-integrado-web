package auxiliar;

import java.sql.*;
import modelo.UsuarioDAOException;

public class Validacao {

    public static boolean isUsuarioValido(String usuario, String senha) throws UsuarioDAOException {

        PreparedStatement ps = null;
        Connection conn = null;
        ResultSet rs = null;


        try {
            String SQL = "EXEC usp_login '" + usuario + "', '" + senha + "'";
            try {
                conn = ConnectionUsuarioFactory.getConnection();
            } catch (Exception e) {
                throw new UsuarioDAOException("Erro: "
                        + ":\n" + e.getMessage());
            }
            ps = conn.prepareStatement(SQL);
            rs = ps.executeQuery();
            rs.next();
            boolean ret = rs.getBoolean(1);
            return (ret);
            
            /*while (rs.next()) {
                String email = rs.getString("email");
                String s = rs.getString("senha");

                if ((usuario.equals(email)) && (senha.equals(s))) {
                    return true;
                }
             }
            */
            
        } catch (SQLException sqle) {
            throw new UsuarioDAOException(sqle);
        } finally {
            ConnectionUsuarioFactory.closeConnection(conn, ps, rs);
        }
    }
}
