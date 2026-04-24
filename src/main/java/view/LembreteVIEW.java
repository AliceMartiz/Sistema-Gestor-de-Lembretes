package view;
import controller.CategoriaCONTROLLER;
import controller.LembreteCONTROLLER;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Date;
import java.util.Scanner;

import model.entity.Categoria;
import model.entity.Lembrete;
import model.entity.Usuario;
import model.util.LembreteUtils;

public class LembreteVIEW
{
    Scanner leia = new Scanner(System.in);
    public void adicionar(Usuario logado)
    {
        SimpleDateFormat formato = new SimpleDateFormat("dd/MM/yyyy");
        CategoriaVIEW cv = new CategoriaVIEW();
        LembreteCONTROLLER lc = new LembreteCONTROLLER();
        CategoriaCONTROLLER cc = new CategoriaCONTROLLER();
        String titulo, dataTexto;
        Date dataConvertida = null;
        int prioridade, status, nivelEsforco, categoria;
        do //do while entre as perguntas pra não mandar o usuário pra tela principal
        {
            System.out.println("\nInforme o titulo do lembrete: ");
            System.out.print("--> ");
            titulo = leia.nextLine();
            if(titulo.isEmpty())
            {
                System.out.println("\n*Informe um titulo válido!");
            }
        }while(titulo.isEmpty());
        do
        {
            System.out.println("\nInforme a prioridade do lembrete: \n1 - P0 (Alta)\n2 - P1(Média)\n3 - P2 (Baixa)");
            System.out.print("--> ");
            prioridade = leia.nextInt();
            leia.nextLine();
            if(prioridade < 1 || prioridade > 3)
            {
                System.out.println("\n*Informe uma opção válida!");
            }
        }while(prioridade < 1 || prioridade > 3);
        do
        {
            System.out.println("\nInforme o status do lembrete: \n1 - Backlog \n2 - A fazer\n3 - Fazendo\n4 - Feito");
            System.out.print("--> ");
            status = leia.nextInt();
            leia.nextLine();
            if(status < 1 || status > 4)
            {
                System.out.println("\n*Informe uma opção válida!");
            }
        }while(status < 1 || status > 4);
        do
        {
            System.out.println("\nInforme o nivel de esforço do lembrete: \n1 - XS\n2 - S\n3 - M\n4 - XL");
            System.out.print("--> ");
            nivelEsforco = leia.nextInt();
            leia.nextLine();
            if(nivelEsforco < 1 || nivelEsforco > 4)
            {
                System.out.println("\n*Informe uma opção válida!");
            }
        }while(nivelEsforco < 1 || nivelEsforco > 4);
        do
        {
            System.out.println("\nInforme a categoria do lembrete: ");
            cv.buscarTudo(logado);
            System.out.print("--> ");
            categoria = leia.nextInt();
            if(!cc.verificarCategoria(logado, categoria))
            {
                System.out.println("\n*Informe uma categoria existente!"); //Como podem existem vários id's de categoria, isto aqui serve pra o usuário não consiga 
                                                                        //utilizar categoria que um outro usuário criou, apenas o dele mesmo.
            }
        }while(!cc.verificarCategoria(logado, categoria));
        leia.nextLine();
        do{
            System.out.println("\nInforme a data do lembrete (dd/mm/aaaa): ");
            System.out.print("--> ");
            dataTexto = leia.next();
            leia.nextLine();
            try
            {
                dataConvertida = formato.parse(dataTexto);
            } 
            catch (Exception e) 
            {
                System.out.println("\n*Formato de data incorreto!");
                dataConvertida = null;
            }
        }while(dataConvertida == null);
        lc.adicionar(titulo, prioridade, status, nivelEsforco, categoria, dataConvertida, logado);
        System.out.println("Lembrete realizado com sucesso!");
    }
    int op;
    /*
    e. remover um lembrete;
    f. listar lembretes com filtros (categoria, estado, prioridade, data);
    g. ordenar lembretes por data;
    h. alterar estados dos lembretes;
    i. identificar lembretes atrasados;
    j. identificar lembretes próximos;
    k. gerar estatísticas para relatórios.
     */
    public void menuLembrete(Usuario logado)
    {
        System.out.println("\n\t--------- Menu Lembretes ---------");
        do
        {
            System.out.println("\nInforme a opção desejada: \n1 - Adicionar Lembretes\n2 - Listar Lembretes\n3 - Editar Lembretes\n0 -  Voltar");
            System.out.print("--> ");
            op = leia.nextInt();
            switch(op)
            {
                case 1:
                    this.adicionar(logado);
                    break;
                case 2:
                    this.menuListarLembretes(logado);
                    break;
                case 3:
                    this.editarLembretes(logado);
                    break;
                case 0:
                    System.out.println("<-");
                    break;
                default:
                    System.out.println("Informe uma opção válida!");
            }

        }while(op != 0);
    }
    public void listarLembretes (Usuario logado)
    {

        LembreteCONTROLLER lc = new LembreteCONTROLLER();
        CategoriaCONTROLLER cc = new CategoriaCONTROLLER();
        ArrayList<Lembrete> lembretes = lc.buscarLembretes(logado);
        int cont = 0;
        System.out.println("-".repeat(80));
        System.out.printf("%-3s %-12s %-12s %-8s %-15s %-12s %-12s%n",
                "*","Título", "Prioridade", "Status", "Nível Esforço", "Data", "Categoria");
        for(Lembrete lembrete : lembretes)
        {
            String titulo = lembrete.getTitulo();
            if(titulo.length() > 9)
            {
                titulo =  titulo.substring(0, 9) + "...";
            }
            cont++;
            System.out.printf("%-3d %-12s %-12s %-8s %-15s %-12s %-12s%n",
                    cont,
                    titulo,
                    LembreteUtils.prioridadeToString(lembrete.getPrioridade()),
                    LembreteUtils.statusToString(lembrete.getStatus()),
                    LembreteUtils.esforcoToString(lembrete.getNivelEsforco()),
                    lembrete.getData(),
                    cc.pegarPorIdCategoria(lembrete.getCategoria().getId()).getNome()
            );
        }
        System.out.println("-".repeat(80));
    }
    public void menuListarLembretes(Usuario logado)
    {
        this.listarLembretes(logado);
        System.out.println("\n\t--------- Menu de Listagem ---------");
        do
        {
            System.out.println("\nInforme a opção desejada: \n1 - Listar por Categoria\n2 - Listar por Estado\n3 - Listar por Prioridade\n4 - Listar por Data\n0 -  Voltar");
            System.out.print("--> ");
            op = leia.nextInt();
            switch (op)
            {
                case 1:
                    this.listarPorCategoria(logado);
                    break;
                case 2:
                    this.listarPorEstado(logado);
                    break;
                case 3:
                    break;
                case 4:
                    break;
                case 0:
                    this.menuLembrete(logado);
                    break;
                default:
                    System.out.println("Informe uma opção válida!");
            }
        }while(op != 0);
    }
    public void listarPorCategoria (Usuario logado)
    {
        System.out.println("\n\t--------- Listar por Categorias ---------");
        CategoriaCONTROLLER cc = new CategoriaCONTROLLER();
        LembreteCONTROLLER lc = new LembreteCONTROLLER();
        ArrayList<Categoria> categorias = cc.buscarTudo(logado);
        for(Categoria categoria : categorias)
        {
            int cont = 0;
            ArrayList<Lembrete> lembretes = lc.buscarLembretesPorCategoria(logado, categoria.getId());
            System.out.println();
            System.out.println("-".repeat(80));
            System.out.println("Categoria: " + categoria.getNome());
            System.out.println("-".repeat(80));
            System.out.printf("%-3s %-12s %-12s %-8s %-15s %-12s%n",
                    "*","Título", "Prioridade", "Status", "Nível Esforço", "Data");
            for(Lembrete lembrete : lembretes)
            {
                String titulo = lembrete.getTitulo();
                if(titulo.length() > 9)
                {
                    titulo =  titulo.substring(0, 9) + "...";
                }
                cont++;
                System.out.printf("%-3d %-12s %-12s %-8s %-15s %-12s%n",
                        cont,
                        titulo,
                        LembreteUtils.prioridadeToString(lembrete.getPrioridade()),
                        LembreteUtils.statusToString(lembrete.getStatus()),
                        LembreteUtils.esforcoToString(lembrete.getNivelEsforco()),
                        lembrete.getData()
                );
            }
        }
        System.out.println("-".repeat(80));
    }
    public void listarPorEstado (Usuario logado)
    {
        LembreteCONTROLLER lc = new LembreteCONTROLLER();
        ArrayList<Lembrete> lembretes = lc.buscarLembretes(logado);
        int[] status = {1, 2, 3, 4};
        for(int s : status)
        {
            CategoriaCONTROLLER cc = new CategoriaCONTROLLER();
            System.out.println();
            System.out.println("-".repeat(80));
            System.out.println("Estado: " + LembreteUtils.statusToString(s));
            System.out.println("-".repeat(80));
            System.out.printf("%-3s %-12s %-12s %-8s %-15s %-12s%n",
                    "*","Título", "Prioridade", "Status", "Nível Esforço", "Data");
            int cont = 0;
            for(Lembrete lembrete : lembretes)
            {
                if(lembrete.getStatus() == s)
                {
                    cont++;
                    System.out.printf("%-3d %-12s %-12s %-8s %-15s %-12s%n",
                            cont,
                            lembrete.getTitulo(),
                            LembreteUtils.prioridadeToString(lembrete.getPrioridade()),
                            LembreteUtils.statusToString(lembrete.getStatus()),
                            LembreteUtils.esforcoToString(lembrete.getNivelEsforco()),
                            lembrete.getData(),
                            lembrete.getCategoria().getNome(),
                            cc.pegarPorIdCategoria(lembrete.getCategoria().getId()).getNome()
                    );
                }
            }
            if(cont == 0) System.out.println("\n\tNenhum lembrete foi vinculado a esse status.");
        }
    }
    public void editarLembretes (Usuario logado)
    {
        System.out.println("\n\t--------- Menu de Edição ---------");
        do
        {

        }while(true);
    }

}
