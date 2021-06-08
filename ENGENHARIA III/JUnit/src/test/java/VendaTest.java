import org.junit.Test;

import java.util.ArrayList;
import java.util.Calendar;
import java.util.List;

import static org.junit.Assert.*;

public class VendaTest{
    @Test
    public void testGetDia(){
        System.out.println("Teste GetDia");

        List<ProdutoVendido> produtoVendidoList = new ArrayList<>();
        produtoVendidoList.add(new ProdutoVendido(1,2,5));

        Comprador comprador = new Comprador(
                "Ana Carla", "344.553.245-43",
                21,2,2002,
                'F',"2222442224");

        Calendar calendar = Calendar.getInstance();
        int hora = calendar.get(Calendar.HOUR);
        int dia = calendar.get(Calendar.DATE);

        Venda venda = new Venda(hora,dia,produtoVendidoList,comprador);

        assertEquals(dia,venda.getDiaVendido());
    }// End testGetDia()

    @Test
    public void testGetHora(){
        System.out.println("Teste GetHora");

        List<ProdutoVendido> produtoVendidoList = new ArrayList<>();
        produtoVendidoList.add(new ProdutoVendido(1,2,5));

        Comprador comprador = new Comprador(
                "Ana Carla", "344.553.245-43",
                21,2,2002,
                'F',"2222442224");

        Calendar calendar = Calendar.getInstance();
        int hora = calendar.get(Calendar.HOUR);
        int dia = calendar.get(Calendar.DATE);

        Venda venda = new Venda(hora,dia,produtoVendidoList,comprador);

        assertEquals(hora,venda.getHoraVendida());
    }// End testGetHora()

    @Test
    public void testVendaAutorizada(){
        System.out.println("Teste VendaAutorizada");

        List<ProdutoVendido> produtoVendidoList = new ArrayList<>();
        produtoVendidoList.add(new ProdutoVendido(1,2,5));

        Comprador comprador = new Comprador(
                "Ana Carla", "344.553.245-43",
                21,2,2002,
                'F',"2222442224");

        Calendar calendar = Calendar.getInstance();
        int hora = calendar.get(Calendar.HOUR);
        int dia = calendar.get(Calendar.DATE);
        int ano = calendar.get(Calendar.YEAR);
        boolean resposta = false;
        Venda venda = new Venda(hora,dia,produtoVendidoList,comprador);

        assertEquals(venda.vendaAutorizada((ano-2002)),resposta);
    }// End testVendaAutorizada()
}// End VendaTest