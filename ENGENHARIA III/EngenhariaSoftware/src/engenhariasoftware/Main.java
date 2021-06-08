package engenhariasoftware;

import java.util.ArrayList;
import java.util.Scanner;


public class Main 
{
    public static void main(String[] args) 
    {    
        Scanner input = new Scanner(System.in);
        System.out.println("Codigo: ");
        long valor = input.nextLong();
        System.out.println("Nome: ");
        input.next();
        String nome = input.nextLine();
        System.out.println("Preco: ");
        double preco = input.nextDouble();
        Produto p = new Produto(valor, nome, preco);
    }
}
