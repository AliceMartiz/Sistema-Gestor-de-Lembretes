package model.dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import model.entity.Usuario;

public class UsuarioDAO 
{
    public void adicionar(Usuario usuario)
    {
        try
        {
            Connection conexao = ConectaBanco.getConnection();
            String sql = "insert into Usuario values(?, ?)";
            PreparedStatement statement = conexao.prepareStatement(sql);
            statement.setString(1, usuario.getNome());
            statement.setString(2, usuario.getSenha());
            statement.execute();
            statement.close();
            conexao.close();
        }
        catch(Exception e)
        {
            e.printStackTrace();
        }
    }
    public Usuario pegarTudo(Usuario usuario)
    {
        try
        {
            Connection conexao = ConectaBanco.getConnection();
            String sql = "select * from Usuario where nome = ? and senha = ?";
            PreparedStatement statement = conexao.prepareStatement(sql);
            statement.setString(1, usuario.getNome());
            statement.setString(2, usuario.getSenha());
            ResultSet rs = statement.executeQuery();
            if(rs.next())
            {
                usuario.setId(rs.getInt("id"));
                usuario.setNome(rs.getString("nome"));
                return usuario;
            }
            statement.close();
            conexao.close();
        }
        catch(Exception e)
        {
            e.printStackTrace();
        }
        return null;
    }
    public Boolean pegarNome(Usuario usuario)
    {
        try
        {
            Connection conexao = ConectaBanco.getConnection();
            String sql = "select * from Usuario where nome = ?";
            PreparedStatement statement = conexao.prepareStatement(sql);
            statement.setString(1, usuario.getNome());
            ResultSet rs = statement.executeQuery();
            if(rs.next())
            {
                return true;
            }
            statement.close();
            conexao.close();
        }
        catch(Exception e)
        {
            e.printStackTrace();
        }
        return false;
    }
}
