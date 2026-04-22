package model.dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.util.ArrayList;
import model.entity.Categoria;

public class CategoriaDAO 
{
    public void adicionar(Categoria categoria)
    {
        try
        {
            Connection conexao = ConectaBanco.getConnection();
            String sql = "insert into Categoria values(?, ?, ?)";
            PreparedStatement statement = conexao.prepareStatement(sql);
            statement.setString(1, categoria.getNome());
            statement.setString(2, categoria.getDescricao());
            statement.setInt(3, categoria.getUsuario().getId());
            statement.execute();
            statement.close();
            conexao.close();
        }
        catch(Exception e)
        {
            e.printStackTrace();
        }
    }
    public ArrayList<Categoria> buscarTudo(Categoria categoria)
    {
        ArrayList<Categoria> categorias = new ArrayList();
        try
        {
            Connection conexao = ConectaBanco.getConnection();
            String sql = "select * from Categoria where id_usu = ?";
            PreparedStatement statement = conexao.prepareStatement(sql);
            statement.setInt(1, categoria.getUsuario().getId());
            ResultSet rs = statement.executeQuery();
            while(rs.next())
            {
                categoria = new Categoria();
                categoria.setId(rs.getInt("id"));
                categoria.setNome(rs.getString("nome"));
                categoria.setDescricao(rs.getString("descricao"));     
                categorias.add(categoria);
            }
            statement.close();
            conexao.close();
        }
        catch(Exception e)
        {
            e.printStackTrace();
        }
        return categorias;
    }
    //select * from Categoria where id_usu = 5 and id = 2
    public boolean verificarCategoria(Categoria categoria)
    {
        try
        {
            Connection conexao = ConectaBanco.getConnection();
            String sql = "select * from Categoria where id_usu = ? and id = ?";
            PreparedStatement statement = conexao.prepareStatement(sql);
            statement.setInt(1, categoria.getUsuario().getId());
            statement.setInt(2, categoria.getId());
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
    public void editar(Categoria categoria)
    {
        try
        {
            Connection conexao = ConectaBanco.getConnection();
            String sql = "UPDATE Categoria SET nome = ?, descricao = ? WHERE id = ? and id_usu = ?";
            PreparedStatement statement = conexao.prepareStatement(sql);
            statement.setString(1, categoria.getNome());
            statement.setString(2, categoria.getDescricao());
            statement.setInt(3, categoria.getId());
            statement.setInt(4, categoria.getUsuario().getId());
            statement.execute();
            statement.close();
            conexao.close();
        }
        catch(Exception e)
        {
            e.printStackTrace();
        }
    }
    public void excluir(Categoria categoria) throws Exception
    {
        Connection conexao = ConectaBanco.getConnection();
        String sql = "DELETE FROM Categoria WHERE id = ? and id_usu = ?";
        PreparedStatement statement = conexao.prepareStatement(sql);
        statement.setInt(1, categoria.getId());
        statement.setInt(2, categoria.getUsuario().getId());
        statement.execute();
        statement.close();
        conexao.close();
    }
}
