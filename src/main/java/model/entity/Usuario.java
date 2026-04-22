package model.entity;

import java.util.ArrayList;

public class Usuario 
{
    private String nome, senha;
    private int id;
    private ArrayList<Lembrete> listaLembrete;
    private ArrayList<Categoria> listaCategoria;

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

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public ArrayList<Lembrete> getListaLembrete() {
        return listaLembrete;
    }

    public void setListaLembrete(ArrayList<Lembrete> listaLembrete) {
        this.listaLembrete = listaLembrete;
    }

    public ArrayList<Categoria> getListaCategoria() {
        return listaCategoria;
    }

    public void setListaCategoria(ArrayList<Categoria> listaCategoria) {
        this.listaCategoria = listaCategoria;
    }
    
    
}

