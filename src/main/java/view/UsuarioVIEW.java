package view;

import controller.UsuarioCONTROLLER;

import java.util.InputMismatchException;
import java.util.Scanner;
import model.entity.Usuario;

public class UsuarioVIEW 
{
    public static final String VERDE = "\u001B[32m";
    public static final String RESET = "\u001B[0m";
    Scanner leia = new Scanner(System.in);
    int acesso = 0;
    String usuario, senha;
    public Usuario telaInicial()
    {
        boolean repetir;
        UsuarioCONTROLLER uc = new UsuarioCONTROLLER();
        do
        {
            repetir = true;
            System.out.println();
            System.out.println("Informe a opção desejada\n1 - Login\n2 - Novo Usuário");
            System.out.print("--> ");
            try
            {
                acesso = leia.nextInt();
                switch(acesso)
                {
                    case 1:
                        System.out.println("\nInforme o usuário: ");
                        System.out.print("--> ");
                        usuario = leia.next();
                        System.out.println("\nInforme a senha: ");
                        System.out.print("--> ");
                        senha = leia.next();
                        leia.nextLine();
                        if(uc.verificarUsuario(usuario, senha) != null)
                        {
                            System.out.println();
                            System.out.println(VERDE + "Conectado com sucesso!" + RESET);
                            repetir = false;
                            return uc.verificarUsuario(usuario, senha);
                        }
                        else
                        {
                            System.err.println("Erro ao conectar, tente novamente!");
                        }
                        break;
                    case 2:
                        do
                        {
                            System.out.println("\nInforme o novo usuário: ");
                            System.out.print("--> ");
                            usuario = leia.next();
                            if(usuario.length() < 3)
                            {
                                System.out.println("\n* Informe um usuário que seja maior ou igual a 3.");
                            }
                        }while(usuario.length() < 3);
                        do
                        {
                            System.out.println("\nInforme sua senha: ");
                            System.out.print("--> ");
                            senha = leia.next();
                            if(senha.length() < 6)
                            {
                                System.out.println("\n* A senha deve ser maior ou igual a 6.");
                            }
                        }while(senha.length() < 6);
                        break;
                    default:
                        System.err.println("Erro! Insira uma opção válida!");
                        System.out.println();
                        break;
                }
            }
            catch (InputMismatchException e)
            {
                System.err.println("Não informe um caractere!");
                System.out.println();
                leia.nextLine();
            }
        }while(repetir);
        return null;
    }
}
