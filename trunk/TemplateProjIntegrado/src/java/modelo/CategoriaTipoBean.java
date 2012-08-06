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
    public CategoriaTipoBean(String tipo) {
        this.tipo = tipo;
    }
    public CategoriaTipoBean(int idTipo, String tipo) {
        this.idTipo = idTipo;
        this.tipo = tipo;
    }
    

    public CategoriaTipoBean(String categoria, int idCategoria) {
        this.idCategoria = idCategoria;
        this.categoria = categoria;
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
