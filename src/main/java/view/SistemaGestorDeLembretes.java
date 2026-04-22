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
                        lv.adicionar(logado);
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

/*
CREATE TABLE Usuario(
nome varchar,
senha varchar,
id serial primary key
)
CREATE TABLE Categoria(
name varchar,
descricao varchar,
id_usu int references Usuario(id),
id serial primary key
)
CREATE TABLE Lembrete(
titulo varchar,
prioridade int,
status int,
nivelEsforco int,
data date,
id_usu int references Usuario(id),
id_categoria int references Categoria(id),
id serial primary key
)

select * from Lembrete
select * from Categoria
select * from Usuario

select * from Usuario where nome = 'Alice' and senha = '12345'

drop table Usuario
drop table Categoria
drop table Lembrete
	
INSERT INTO Usuario (nome, senha) VALUES 
('Alice', '12345'),
('Joao', 'admin123');

INSERT INTO Categoria (name, descricao) VALUES 
('Faculdade', 'Trabalhos, provas e projetos da UCDB'),
('Trabalho', 'Tarefas do estágio e reuniões'),
('Pessoal', 'Lembretes de saúde, lazer e	 casa');
*/