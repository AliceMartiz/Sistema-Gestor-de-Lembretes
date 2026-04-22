
package model.entity;

import java.util.ArrayList;

public class Categoria 
{
    private String nome, descricao;
    private int id;
    private Usuario usuario;
    private ArrayList<Lembrete> lista;

    public Usuario getUsuario() {
        return usuario;
    }

    public void setUsuario(Usuario usuario) {
        this.usuario = usuario;
    }
    
    public ArrayList<Lembrete> getLista() {
        return lista;
    }

    public void setLista(ArrayList<Lembrete> lista) {
        this.lista = lista;
    }
    public String getNome() {
        return nome;
    }

    public void setNome(String nome) {
        this.nome = nome;
    }

    public String getDescricao() {
        return descricao;
    }

    public void setDescricao(String descricao) {
        this.descricao = descricao;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }
}
