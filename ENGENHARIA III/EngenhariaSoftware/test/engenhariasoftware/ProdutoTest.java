/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package engenhariasoftware;

import org.junit.After;
import org.junit.AfterClass;
import static org.junit.Assert.assertEquals;
import org.junit.Before;
import org.junit.BeforeClass;
import org.junit.Test;

/**
 *
 * @author john
 */
public class ProdutoTest {
    
    public ProdutoTest() {
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
    public void testProduto01()
    {
        Produto p = new Produto(0, "Biscoito", 1.99);
        Produto resultadoEsperado = p;
        assertEquals(resultadoEsperado, p);
    }
    
    @Test(expected = Exception.class)
    public void testProduto02()
    {
        Produto p = new Produto(-1, "Biscoito", 1.99);               
    }
    
    @Test(expected = Exception.class)
    public void testProduto03()
    {
        Produto p = new Produto(0, "0", 1.99);              
    }
    
    public void testProduto04()
    {
        Produto p = new Produto(0, "0.1", 1.99); 
        Produto resultadoEsperado = p;
        assertEquals(resultadoEsperado, p);
    }

    @Test
    public void testProduto05()
    {
        Produto p = new Produto(0, "!@#&", 1.99);   
        Produto resultadoEsperado = p;
        assertEquals(resultadoEsperado, p);
    }
    
    @Test(expected = Exception.class)
    public void testProduto06()
    {
        Produto p = new Produto(0, "999999999999999999999", 1.99);       
    }
    
    @Test(expected = Exception.class)
    public void testProduto07()
    {
        Produto p = new Produto(0, "-999999999999999999999", 1.99);       
    }

    @Test
    public void testProduto08()
    {
        Produto p = new Produto(0, "abcde", 1.99);   
        Produto resultadoEsperado = p;
        assertEquals(resultadoEsperado, p);
    }
    
    @Test(expected = Exception.class)
    public void testProduto09()
    {
        Produto p = new Produto(0, null, 1.99);   
    }
    
    @Test(expected = Exception.class)
    public void testProduto010()
    {
        Produto p = new Produto(0, "", 1.99);
    }
    
    @Test(expected = Exception.class)
    public void testProduto011()
    {
        Produto p = new Produto(0, "abcde", 0);
    }
    
    public void testProduto012()
    {
        Produto p = new Produto(0, "abcde", 0.1);
        Produto resultadoEsperado = p;
        assertEquals(resultadoEsperado, p);
    }
    
    @Test(expected = Exception.class)
    public void testProduto013()
    {
        Produto p = new Produto(0, "abcde", -1);

    }

    
}
