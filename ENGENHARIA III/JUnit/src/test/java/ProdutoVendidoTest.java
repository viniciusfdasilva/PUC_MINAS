import org.junit.Test;

import static org.junit.Assert.*;

public class ProdutoVendidoTest{
    @Test
    public void testGetCodigoProduto(){
        System.out.println("Teste GetCodigoProduto");

        ProdutoVendido produtoVendido = new ProdutoVendido(1,2,5);

        int codigo = 1;

        assertEquals(codigo,produtoVendido.getCodigoProduto());
    }// End testCodigoProduto()

    @Test
    public void testGetQtd(){
        System.out.println("Teste GetQtd");

        ProdutoVendido produtoVendido = new ProdutoVendido(1,2,5);

        int qtd = 2;
        assertEquals(qtd,produtoVendido.getQtd());
    }// End  testGetQtd()

    @Test
    public void testGetPreco(){
        System.out.println("Teste GetPreco");

        ProdutoVendido produtoVendido = new ProdutoVendido(1,2,5);

        double preco = 5;

        assertEquals(preco,produtoVendido.getPreco(),-1);
    }// End testGetPreco()
}// End ProdutoVendidoTest