package modelo;

public class UsuarioBean {

    private String login;
    private boolean tipo;

    public UsuarioBean() {
    }

    public String getTipo() {
        if (tipo) {
            return "Colaborador";
        } else {
            return "Administrador";
        }
    }

    public void setTipo(boolean tipo) {
        this.tipo = tipo;
    }

    public String getLogin() {
        return login;
    }

    public void setLogin(String login) {
        this.login = login;
    }
}
