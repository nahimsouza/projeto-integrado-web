package modelo;

public class UsuarioBean {

    private String nome;
    private String email;
    private String senha;
    private String dataNasc;
    private String tipo;

    public UsuarioBean(){
        
    }

    public UsuarioBean(String nome, String email, String dataNasc) {
        this.nome = nome;
        this.email = email;
        this.dataNasc = dataNasc;
    }
    
    public UsuarioBean(String nome, String email, String senha, String dataNasc, String tipo) {
        this.nome = nome;
        this.email = email;
        this.senha = senha;
        this.dataNasc = dataNasc;
        this.tipo = tipo;
    }

    public String getDataNasc() {
        return dataNasc;
    }

    public void setDataNasc(String dataNasc) {
        this.dataNasc = dataNasc;
    }

    public String getNome() {
        return nome;
    }

    public void setNome(String nome) {
        this.nome = nome;
    }

    public String getSenha() {
        return senha;
    }

    public void setSenha(String senha) {
        this.senha = senha;
    }

    public String getTipo() {
        return tipo;
    }

    public void setTipo(String tipo) {
        this.tipo = tipo;
    }

    public String getLogin() {
        return email;
    }

    public void setLogin(String login) {
        this.email = login;
    }
}
