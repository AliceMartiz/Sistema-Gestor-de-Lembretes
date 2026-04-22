package controller;

import model.dao.UsuarioDAO;
import model.entity.Usuario;

public class UsuarioCONTROLLER 
{
    Usuario u = new Usuario();
    UsuarioDAO ud = new UsuarioDAO();
    public Usuario verificarUsuario(String nome, String senha)
    {
        u.setNome(nome);
        u.setSenha(senha);
        if(ud.pegarTudo(u) != null)
        {
            return ud.pegarTudo(u);
        }
        else
        {
            return null;
        }
    }
    public void pegarTudo(String nome, String senha)
    {
        u.setNome(nome);
        u.setSenha(senha);
        ud.pegarTudo(u);
    }
    public void adicionar(String nome, String senha)
    {
        u.setNome(nome);
        u.setSenha(senha);
        ud.adicionar(u);
    }
    public boolean pegarNome(String nome)
    {
        u.setNome(nome);
        return ud.pegarNome(u);
    }
}
