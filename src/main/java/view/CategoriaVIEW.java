package view;

import controller.CategoriaCONTROLLER;

import java.util.ArrayList;
import java.util.InputMismatchException;
import java.util.Scanner;

import controller.LembreteCONTROLLER;
import model.entity.Usuario;
import model.entity.Categoria;

public class CategoriaVIEW 
{
    Scanner leia = new Scanner(System.in);
    int op = 0;
    public void menuCategorias(Usuario logado)
    {
        System.out.println("\n\t--------- Menu Categoria ---------");
        do
        {
            System.out.println("\nInforme a opção desejada: \n1 - Criar Categorias\n2 - Editar Categorias\n3 - Excluir Categorias\n4 - Listar Categorias\n0 -  Voltar");
            System.out.print("--> ");
            op = leia.nextInt();
            leia.nextLine();
            switch(op)
            {
                case 1:
                    this.adicionar(logado);
                    break;
                case 2:
                    this.editar(logado);
                    break;
                case 3:
                    this.excluir(logado);
                    break;
                case 4:
                    this.listar(logado);
                    break;
                case 0:
                    System.out.println("<-");
                    break;
                default:
                    System.out.println("Informe uma opção válida!");
            }
        }while(op != 0 );
    }
    public void listar(Usuario logado)
    {
        CategoriaCONTROLLER cc = new CategoriaCONTROLLER();
        ArrayList<Categoria> categorias = cc.buscarTudo(logado);
        if(!categorias.isEmpty())
        {
            for(Categoria categoria : categorias)
            {
                System.out.println("\n(" + categoria.getId() + ")\n*Titulo: "
                        + categoria.getNome() + "\n*Descrição: " + categoria.getDescricao());
            }
        }
        else
        {
            System.out.println("\nVocê não possui categorias criadas!");
        }
    }
    public void excluir(Usuario logado)
    {
        CategoriaCONTROLLER cc = new CategoriaCONTROLLER();
        LembreteCONTROLLER lc = new LembreteCONTROLLER();
        ArrayList<Categoria> categorias = cc.buscarTudo(logado);
        Categoria c = new Categoria();
        int id = 0;
        if(!categorias.isEmpty()) //Categorias não vazias
        {
            for (Categoria categoria : categorias)
            {
                System.out.println("\n(" + categoria.getId() + ")\n*Titulo: "
                        + categoria.getNome() + "\n*Descrição: " + categoria.getDescricao());
                c.setId(categoria.getId());
                if (lc.buscar(categoria.getId()).getTitulo() != null) {
                    System.out.println("Relacionado a: " + lc.buscar(categoria.getId()).getTitulo());
                } else {
                    System.out.println("** Sem lembretes relacionados.** ");
                }
            }
            do
            {
                System.out.println("\nInforme o ID da categoria para excluir: ");
                System.out.print("--> ");
                try
                {
                    id = leia.nextInt();
                    leia.nextLine();
                    if(!cc.verificarCategoria(logado, id))
                    {
                        System.err.println("Informe um ID válido!");
                    }
                    else
                    {
                        cc.excluir(id, logado);
                        System.out.println("Exclusão feita com sucesso!");
                        this.menuCategorias(logado);
                    }
                }
                catch(InputMismatchException e)
                {
                    System.err.println("Por favor selecione um ID válido, sem caracteres.");
                    leia.nextLine();
                }
                catch (Exception e)
                {
                    System.err.println("Ops! Esta categoria está associada a um lembrete.");
                }

            }while(!cc.verificarCategoria(logado, id));
        }
        else
        {
            categoriaCriada(logado); //Metodo pra perguntar se o usuário quer criar uma nova categoria, caso não possua
        }
    }
    private void categoriaCriada(Usuario logado) {
        System.out.println("\nVocê não possui categorias criadas, deseja criar? \n1 - Sim\n2 - Não");
        System.out.print("--> ");
        op = leia.nextInt();
        leia.nextLine();
        if(op == 1)
        {
            this.adicionar(logado);
        }
        else
        {
            this.menuCategorias(logado);
        }
    }
    public void editar(Usuario logado)
    {
        CategoriaCONTROLLER cc = new CategoriaCONTROLLER();
        int id;
        String nome, descricao;
        ArrayList<Categoria> categorias = cc.buscarTudo(logado);
        if(!categorias.isEmpty())
        {
            for (Categoria categoria : categorias)
            {
                System.out.println("*Categoria (" + categoria.getId() + ")\n*Titulo: " + categoria.getNome() + "\n*Descrição: " + categoria.getDescricao());
            }
            do
            {
                System.out.println("\nInforme o ID da categoria para editar: ");
                System.out.print("--> ");
                id = leia.nextInt();
                leia.nextLine();
                if(!cc.verificarCategoria(logado, id))
                {
                    System.err.println("Informe um ID válido!");
                }
            }while(!cc.verificarCategoria(logado, id));
            do
            {
                System.out.println("\nInforme o novo nome da Categoria: ");
                System.out.print("--> ");
                nome = leia.nextLine();
                if(nome.isEmpty())
                {
                    System.out.println("Informe um nome válido!");
                }
            }while(nome.isEmpty());
            System.out.println("\nInforme a nova descricao da Categoria: ");
            System.out.print("--> ");
            descricao = leia.nextLine();
            cc.editar(nome, descricao, id, logado);
            System.out.println("Categoria atualizada com sucesso!");
        }
        else
        {
            categoriaCriada(logado);
        }
    }
    public void adicionar(Usuario logado)
    {
        CategoriaCONTROLLER cc = new CategoriaCONTROLLER();
        String nome, descricao;
        System.out.println("\nInforme a nova categoria: ");
        System.out.print("--> ");
        nome = leia.nextLine();
        System.out.println("\nInforme sua descrição: ");
        System.out.print("--> ");
        descricao = leia.nextLine();
        cc.adicionar(nome, descricao, logado);
    }
    public void buscarTudo(Usuario logado)
    {
        CategoriaCONTROLLER cc = new CategoriaCONTROLLER();
        ArrayList<Categoria> categorias = cc.buscarTudo(logado);
        if(!categorias.isEmpty())
        {
            for (Categoria categoria : categorias)
            {
                System.out.println("*Categoria (" + categoria.getId() + ")\n*Titulo: " + categoria.getNome() + "\n*Descrição: " + categoria.getDescricao());
            }
        }
        else
        {
            categoriaCriada(logado);
        }
    }
}
