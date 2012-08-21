/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package modelo;

/**
 *
 * @author fguira
 */
public class EntidadeBean {
    private int idEntidade;
    private String displayname;
   // private String mid;
    private String descricao;
    
    // construtor sem parâmetros:
    public EntidadeBean(){
    }
    
    // construtor com parâmetros
    public EntidadeBean (String displayname, String descricao){
        this.displayname = displayname;
        this.descricao = descricao;
    }
    public EntidadeBean (String displayname, String descricao,int idEntidade){
        this.displayname = displayname;
        this.descricao = descricao;
        this.idEntidade=idEntidade;
    }
    public EntidadeBean (int idEntidade){
        
        this.idEntidade=idEntidade;
    }
    
    public String getDescricao() {
        return descricao;
    }

    public void setDescricao(String descricao) {
        this.descricao = descricao;
    }

    public String getDisplayname() {
        return displayname;
    }

    public void setDisplayname(String displayname) {
        this.displayname = displayname;
    }
    
    

    public int getIdEntidade() {
        return idEntidade;
    }
/*
    public String getMid() {
        return mid;
    }

    public void setMid(String mid) {
        this.mid = mid;
    }
    */
}