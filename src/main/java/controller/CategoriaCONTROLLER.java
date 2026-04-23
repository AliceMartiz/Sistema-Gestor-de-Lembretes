package controller;

import java.util.ArrayList;
import model.dao.CategoriaDAO;
import model.entity.Categoria;
import model.entity.Usuario;

public class CategoriaCONTROLLER 
{
    CategoriaDAO cd = new CategoriaDAO();
    Categoria c = new Categoria();
    public void adicionar(String nome, String descricao, Usuario logado)
    {
        c.setNome(nome);
        c.setDescricao(descricao);
        c.setUsuario(logado);
        cd.adicionar(c);
    }
    public ArrayList<Categoria> buscarTudo(Usuario logado)
    {
        c.setUsuario(logado);   
        return cd.buscarTudo(c);
    }
    public boolean verificarCategoria(Usuario logado, int categoria)
    {
        c.setUsuario(logado);
        c.setId(categoria);
        return cd.verificarCategoria(c);
    }
    public void editar(String nome, String descricao, int id, Usuario logado)
    {
        c.setNome(nome);
        c.setDescricao(descricao);
        c.setId(id);
        c.setUsuario(logado);
        cd.editar(c);
    }
    public void excluir(int id, Usuario logado) throws Exception {
        c.setId(id);
        c.setUsuario(logado);
        cd.excluir(c);
    }
    public Categoria pegarPorIdCategoria (int id)
    {
        c.setId(id);
        return cd.pegarPorId(c);
    }
}
