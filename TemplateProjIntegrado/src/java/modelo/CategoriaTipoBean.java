/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package modelo;

/**
 *
 * @author fguira
 */
public class CategoriaTipoBean {
    private int idTipo;
    private int idCategoria;
    private String categoria;
    private String tipo;

    public CategoriaTipoBean() {
    }

    public void setIdTipo(int idTipo) {
        this.idTipo = idTipo;
    }

    public void setIdCategoria(int idCategoria) {
        this.idCategoria = idCategoria;
    }
    
    public CategoriaTipoBean(String tipo) {
        this.tipo = tipo;
        this.categoria = tipo; // gambiarra? para poder utilizar o mesmo construtor
    }
    
    public CategoriaTipoBean(int idTipo, String tipo) {
        this.idTipo = idTipo;
        this.tipo = tipo;
    }

    public CategoriaTipoBean(String categoria, int idCategoria) {
        this.idCategoria = idCategoria;
        this.categoria = categoria;
    }
    public CategoriaTipoBean(String categoria, String Tipo) {
        this.tipo = Tipo;
        this.idCategoria = Integer.parseInt(categoria);
    }
    public String getCategoria() {
        return categoria;
    }

    public String getTipo() {
        return tipo;
    }

    public int getIdCategoria() {
        return idCategoria;
    }

    public int getIdTipo() {
        return idTipo;
    }

    public void setCategoria(String categoria) {
        this.categoria = categoria;
    }

    public void setTipo(String tipo) {
        this.tipo = tipo;
    }
    
}
