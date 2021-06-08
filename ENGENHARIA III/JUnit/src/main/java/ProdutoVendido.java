public class ProdutoVendido{
    private int codigoProduto;
    private int qtd;
    private double preco;

    public ProdutoVendido(int codigoProduto, int qtd, double preco){
        this.codigoProduto = codigoProduto;
        this.qtd = qtd;
        this.preco = preco;
    }// End ProdutoVentido

    public int getCodigoProduto(){ return codigoProduto; }// End getCodigoProduto()
    public void setCodigoProduto(int codigoProduto){ this.codigoProduto = codigoProduto; }// End setCodigoProduto()
    public int getQtd(){ return qtd; }// End getQtd()
    public void setQtd(int qtd){ this.qtd = qtd; }// End setQtd()
    public double getPreco(){ return preco; }// End getPreco()
    public void setPreco(double preco){ this.preco = preco; }// End setPreco()
}// End ProdutoVendido



