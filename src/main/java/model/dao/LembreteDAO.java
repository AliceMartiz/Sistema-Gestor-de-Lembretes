
package model.dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.util.ArrayList;

import model.entity.Categoria;
import model.entity.Lembrete;

public class LembreteDAO 
{
    public void adicionar(Lembrete lembrete)
    {
        try
        {
            Connection conexao = ConectaBanco.getConnection();
            String sql = "insert into Lembrete values(?, ?, ?, ?, ?, ?, ?)";
            PreparedStatement statement = conexao.prepareStatement(sql);
            statement.setString(1, lembrete.getTitulo());
            statement.setInt(2, lembrete.getPrioridade());
            statement.setInt(3, lembrete.getStatus());
            statement.setInt(4, lembrete.getNivelEsforco());
            statement.setDate(5, new java.sql.Date(lembrete.getData().getTime()));
            statement.setInt(6, lembrete.getUsuario().getId());
            statement.setInt(7, lembrete.getCategoria().getId());
            statement.execute();
            statement.close();
            conexao.close();
        }
        catch(Exception e)
        {
            e.printStackTrace();
        }
    }
    public Lembrete Buscar(Lembrete lembrete)
    {
        try
        {
            Connection conexao = ConectaBanco.getConnection();
            String sql = "select * from Lembrete where id_categoria = ?";
            PreparedStatement statement = conexao.prepareStatement(sql);
            statement.setInt(1, lembrete.getCategoria().getId());
            ResultSet rs = statement.executeQuery();
            while(rs.next())
            {
                lembrete = new Lembrete();
                lembrete.setTitulo(rs.getString("titulo"));
            }
            statement.close();
            conexao.close();
        }
        catch(Exception e)
        {
            e.printStackTrace();
        }
        return lembrete;
    }
}
