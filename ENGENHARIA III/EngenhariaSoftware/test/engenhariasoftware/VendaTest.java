/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package engenhariasoftware;

import java.util.ArrayList;
import org.junit.After;
import org.junit.AfterClass;
import org.junit.Before;
import org.junit.BeforeClass;
import org.junit.Test;
import static org.junit.Assert.*;

/**
 *
 * @author john
 */
public class VendaTest {
    
    public VendaTest() {
    }
    
    @BeforeClass
    public static void setUpClass() {
    }
    
    @AfterClass
    public static void tearDownClass() {
    }
    
    @Before
    public void setUp() {
    }
    
    @After
    public void tearDown() {
    }

    @Test
    public void testGetProduto01() {
        System.out.println("getProduto");
                
        Produto p1 = new Produto(0, "Biscoito", 3.99);
        
        Venda venda = new Venda();
        venda.inserirProduto(p1);
       
        // Vamos consultar um produto cujo o codigo nao foi inserido no sistema
        long codigo = 1000L;
        Produto resultadoEsperado = null;
        Produto resultadoObtido = venda.getProduto(codigo);
        assertEquals(resultadoEsperado, resultadoObtido);
    }

    
    @Test
    public void testGetProduto02() {
        System.out.println("getProduto");
        
        Produto p1 = new Produto(0, "Biscoito", 3.99);
        
        Venda venda = new Venda();
        venda.inserirProduto(p1);
       
        // Vamos consultar um produto cujo o codigo foi inserido no sistema
        long codigo = 0L;
        Produto resultadoEsperado = p1;
        Produto resultadoObtido = venda.getProduto(codigo);
        assertEquals(resultadoEsperado, resultadoObtido);
    }
    
  
    @Test
    public void testGetNomeProduto() {
        System.out.println("getNomeProduto");

        Produto p1 = new Produto(0, "Biscoito", 3.99);
        
        Venda venda = new Venda();
        venda.inserirProduto(p1);
               
        long codigo = 0L;
        String resultadoEsperado = "Biscoito";
        String resultadoObtido = venda.getNomeProduto(codigo);
        assertEquals(resultadoEsperado, resultadoObtido);
    }

    @Test
    public void testGetPrecoProduto() {
        System.out.println("getPrecoProduto");
        
        Produto p1 = new Produto(0, "Biscoito", 3.99);
        
        Venda venda = new Venda();
        venda.inserirProduto(p1);
        
        long codigo = 0L;
        double resultadoEsperado = 3.99;        
        double resultadoObtido = venda.getPrecoProduto(codigo);
        
        assertEquals(resultadoEsperado, resultadoObtido, 0.0);
    }


    @Test
    public void testGetDia() {
        System.out.println("getDia");
        
        
        Produto p1 = new Produto(0, "Biscoito", 3.99);
        
        Venda venda = new Venda();
        venda.inserirProduto(p1);
        
        // Hoje e' dia 5
        int resultadoEsperado = 5;
        int resultadoObtido = venda.getDia();
        assertEquals(resultadoEsperado, resultadoObtido);
    }


    @Test
    public void testGetHora() {
        System.out.println("getHora");
        
        Produto p1 = new Produto(0, "Biscoito", 3.99);
        
        Venda venda = new Venda();
        venda.inserirProduto(p1);
        
        // Agora sao 14 horas
        int resultadoEsperado = 14;
        int resultadoObtido = venda.getHora();
        assertEquals(resultadoEsperado, resultadoObtido);
    }

    
    @Test
    public void testGetQuantProdutosVendidos01() {
        System.out.println("getQuantProdutosVendidos01");
        
        Venda venda = new Venda();
        
        int resultadoEsperado = 0;
        int resultadoObtido = venda.getQuantProdutosVendidos();
        assertEquals(resultadoEsperado, resultadoObtido);
    }
    
    
    @Test
    public void testGetQuantProdutosVendidos02() {
        System.out.println("getQuantProdutosVendidos02");
        
        Produto p1 = new Produto(0, "Biscoito", 3.99);
        
        Venda venda = new Venda();
        venda.inserirProduto(p1);
        
        int resultadoEsperado = 1;
        int resultadoObtido = venda.getQuantProdutosVendidos();
        assertEquals(resultadoEsperado, resultadoObtido);
    }
    

    @Test
    public void testGetQuantProdutosVendidos03() {
        System.out.println("getQuantProdutosVendidos03");
        
        Venda venda = new Venda();
        
        Produto p1 = new Produto(0, "Biscoito", 3.99);       Produto p2 = new Produto(1, "Televisao", 1499.00);
        Produto p3 = new Produto(2, "Nescau", 1.99);         Produto p4 = new Produto(3, "Xbox", 2399.00);
        Produto p5 = new Produto(4, "PlayStation", 2400.00); Produto p6 = new Produto(5, "Tenis", 200.00);
        Produto p7 = new Produto(6, "Mesa", 100.00);         Produto p8 = new Produto(7, "Notebook", 999.00);
        Produto p9 = new Produto(8, "Travesseiro", 30.00);   Produto p10 = new Produto(9, "Caderno", 10.00);
        
        venda.inserirProduto(p1); venda.inserirProduto(p2);
        venda.inserirProduto(p3); venda.inserirProduto(p4);
        venda.inserirProduto(p5); venda.inserirProduto(p6);
        venda.inserirProduto(p7); venda.inserirProduto(p8);
        venda.inserirProduto(p9); venda.inserirProduto(p10);
        
        int resultadoEsperado = 10;
        int resultadoObtido = venda.getQuantProdutosVendidos();
        assertEquals(resultadoEsperado, resultadoObtido);

    }
}
