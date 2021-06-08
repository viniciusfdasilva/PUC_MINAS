package engenhariasoftware;


public class Produto 
{
    private long codigo;
    String nome;
    private double preco;

    public Produto(long codigo, String nome, double preco)
    {
        this.codigo = codigo;
        this.nome = nome;
        this.preco = preco;
    }
    
    public long getCodigo()
    {
        return this.codigo;
    }
    
    public double getPreco()
    {
        return this.preco;
    }
    
    public String getNome()
    {
        return this.nome;
    }
}
