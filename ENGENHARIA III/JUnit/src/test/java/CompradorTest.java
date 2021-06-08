import org.junit.Test;

import static org.junit.Assert.*;

public class CompradorTest{
    @Test
    public void testGetNome(){
        System.out.println("Teste GetNome");

        Comprador comprador = new Comprador(
                "Ana Carla", "344.553.245-43",
                21,2,2002,
                'F',"2222442224");

        String nome = "Ana Clara";
        assertEquals(nome,comprador.getNome());
    }// End testGetNome()

    @Test
    public void testGetCpf(){
        System.out.println("Teste GetCpf");

        Comprador comprador = new Comprador(
                "Ana Carla", "344.553.245-43",
                21,2,2002,
                'F',"2222442224");

        String cpf = "344.553.245-43";
        assertEquals(cpf,comprador.getCpf());
    }// End testGetCpf()

    @Test
    public void testGetDia(){
        System.out.println("Teste GetDia");

        Comprador comprador = new Comprador(
                "Ana Carla", "344.553.245-43",
                21,2,2002,
                'F',"2222442224");

        int dia = 21;
        assertEquals(dia,comprador.getDia());
    }// End testGetDia()

    @Test
    public void testGetMes(){
        System.out.println("Teste GetMes");

        Comprador comprador = new Comprador(
                "Ana Carla", "344.553.245-43",
                21,2,2002,
                'F',"2222442224");

        int mes = 2;

        assertEquals(mes,comprador.getMes());
    }// End testGetMes()

    @Test
    public void testGetAno(){
        System.out.println("Teste GetAno");

        Comprador comprador = new Comprador(
                "Ana Carla", "344.553.245-43",
                21,2,2002,
                'F',"2222442224");

        int ano = 2002;

        assertEquals(ano,comprador.getAno());
    }// End testGetAno()

    @Test
    public void testGetSexo(){
        System.out.println("Teste GetSexo");

        Comprador comprador = new Comprador(
                "Ana Carla", "344.553.245-43",
                21,2,2002,
                'F',"2222442224");

        char sexo = 'F';

        assertEquals(sexo,comprador.getSexo());
    }// End testGetSexo()

    @Test
    public void testNumeroCartao(){
        System.out.println("Teste GetNumeroCartao");

        Comprador comprador = new Comprador(
                "Ana Carla", "344.553.245-43",
                21,2,2002,
                'F',"2222442224");

        String numeroCartao = "2222442224";

        assertEquals(numeroCartao,comprador.getNumeroCartao());
    }// End testNumeroCartao()
}// End CompradorTest