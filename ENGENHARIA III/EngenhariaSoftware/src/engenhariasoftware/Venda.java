package engenhariasoftware;

import java.util.ArrayList;
import java.util.Calendar;
import java.util.Date;
import java.util.HashMap;


public class Venda
{
    private int dia;
    private int hora;
                            
    private int quantProdutosVendidos;
    
    private HashMap<Long, ArrayList<Produto>> mapaCodigoProduto;
    
    public Venda()
    {
        Date data = new Date();
        Calendar calendar = Calendar.getInstance();
        calendar.setTime(data);
       
        this.dia = calendar.get(Calendar.DAY_OF_MONTH);
        this.hora = calendar.get(Calendar.HOUR_OF_DAY);     
       
        this.quantProdutosVendidos = 0;
        
        this.mapaCodigoProduto = new HashMap<>();
    }


    public void inserirProduto(Produto p)
    {
        long codigo = p.getCodigo();
        if(!this.mapaCodigoProduto.containsKey(codigo))
        {
            this.mapaCodigoProduto.put(codigo, new ArrayList<>());
        }
        
        this.mapaCodigoProduto.get(codigo).add(p);  
        this.quantProdutosVendidos++;
    }
    
    public Produto getProduto(long codigo)
    {   
        return this.mapaCodigoProduto.get(codigo).get(0);
    }
    
    public String getNomeProduto(long codigo)
    {
        Produto p = getProduto(codigo);
        return p.getNome();
    }
    
    public double getPrecoProduto(long codigo)
    {
        Produto p = getProduto(codigo);
        return p.getPreco();
    }
    

    public int getDia() {
        return dia;
    }

    public int getHora() {
        return hora;
    }
    
    public int getQuantProdutosVendidos()
    {
        return quantProdutosVendidos;
    }  

}
