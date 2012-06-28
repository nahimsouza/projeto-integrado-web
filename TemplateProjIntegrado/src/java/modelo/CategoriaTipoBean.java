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
    private String Categoria;
    private String Tipo;



    public String getCategoria() {
        return Categoria;
    }

    public String getTipo() {
        return Tipo;
    }

    public int getIdCategoria() {
        return idCategoria;
    }

    public int getIdTipo() {
        return idTipo;
    }

    public void setCategoria(String Categoria) {
        this.Categoria = Categoria;
    }

    public void setTipo(String Tipo) {
        this.Tipo = Tipo;
    }
    
}
