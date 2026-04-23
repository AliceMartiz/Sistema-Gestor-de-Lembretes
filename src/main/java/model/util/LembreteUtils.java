package model.util;

public class LembreteUtils
{
    public static String prioridadeToString(int prioridade)
    {
        switch (prioridade)
        {
            case 1: return "P0 (Alta)";
            case 2: return "P1 (Média)";
            case 3: return "P2 (Baixa)";
            default: return "Desconhecida";
        }
    }
    public static String statusToString(int status)
    {
        switch (status)
        {
            case 1: return "Backlog";
            case 2: return "A fazer";
            case 3: return "Fazendo";
            case 4: return "Feito";
            default: return "Desconhecido";
        }
    }
    public static String esforcoToString(int esforco)
    {
        switch (esforco)
        {
            case 1: return "XS";
            case 2: return "S";
            case 3: return "M";
            case 4: return "XL";
            default: return "Desconhecido";
        }
    }
}
