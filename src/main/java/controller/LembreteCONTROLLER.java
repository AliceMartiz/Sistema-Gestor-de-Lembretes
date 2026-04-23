
package controller;

import java.util.ArrayList;
import java.util.Date;
import model.dao.CategoriaDAO;
import model.dao.LembreteDAO;
import model.entity.Categoria;
import model.entity.Lembrete;
import model.entity.Usuario;

public class LembreteCONTROLLER 
{
    Lembrete l = new Lembrete();
    LembreteDAO ld = new LembreteDAO();
    Categoria c = new Categoria();
    public void adicionar(String titulo, int prioridade, int status, int nivelEsforco, int categoria, Date data, Usuario logado)
    {
        l.setTitulo(titulo);
        l.setPrioridade(prioridade);
        l.setStatus(status);
        l.setNivelEsforco(nivelEsforco);
        c.setId(categoria);
        l.setCategoria(c);
        l.setData(data);
        l.setUsuario(logado);
        ld.adicionar(l);
    }
    public Lembrete buscarPorIdCategoria(int id)
    {
        c.setId(id);
        l.setCategoria(c);
        return ld.Buscar(l);
    }
    public ArrayList<Lembrete> buscarLembretes(Usuario logado)
    {
        l.setUsuario(logado);
        return ld.buscarLembretes(l);
    }
}
