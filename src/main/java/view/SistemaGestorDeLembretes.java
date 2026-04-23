package view;

import java.util.Scanner;
import model.entity.Usuario;


public class SistemaGestorDeLembretes 
{
    public static void main(String[] args) 
    {   
        UsuarioVIEW uv = new UsuarioVIEW();
        CategoriaVIEW cv = new CategoriaVIEW();
        LembreteVIEW lv = new LembreteVIEW();
        Scanner leia = new Scanner(System.in);
        Usuario logado = uv.telaInicial();
        if(logado != null)
        {
            System.out.println("\n\t******* Olá " + logado.getNome() + "! *******");
            int op;
            do
            {

                System.out.println("\n\t--------- Menu Principal ---------");
                System.out.println("\nInforme a opção desejada: \n1 - Editar Categorias\n2 - Editar Lembretes\n3 - Emitir Relatório \n0 -  Sair");
                System.out.printf("--> ");
                op = leia.nextInt();
                switch(op)
                {
                    case 1:
                        cv.menuCategorias(logado);
                        break;
                    case 2:
                        lv.menuLembrete(logado);
                        break;
                    case 3:
                        break;
                    default:
                }
            }
            while(op != 0);
        }
        else
        {
            System.out.println("Ocorreu um erro ao acessar a tela principal, tente novamente.");
        }
        System.out.println("Programa Finalizado com sucesso!");
    }
}
