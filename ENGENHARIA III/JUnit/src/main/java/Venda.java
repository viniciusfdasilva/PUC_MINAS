import java.util.Calendar;
import java.util.Date;
import java.util.List;

public class Venda{
    private int dia;
    private int hora;
    private List<ProdutoVendido> produtosvendidos;
    private Comprador comprador;

    public Venda(int dia,int hora,List<ProdutoVendido> produtosvendidos,Comprador comprador){
        this.dia = dia;
        this.hora = hora;
        this.comprador = comprador;
    }// End Venda()

    public Venda(){ }// End Venda()

    public boolean vendaAutorizada(int idade){
        return idade >= 17 ? true : false;
    }// End vendaAutorizada()

    public void efetuarVenda(int idade){
        if(vendaAutorizada(idade)) System.out.println("VENDA EFETUADA COM SUCESSO!!");
        else System.out.println("VENDA NÃO AUTORIZADA!");
    }// End efetuarVenda()

    public double getValorTotal(){
        double total = 0;
        for(ProdutoVendido produtoVendido : produtosvendidos){
            total = (produtoVendido.getPreco() * (produtoVendido.getQtd()+2));
        }// End for
        return total;
    }// End total

    public int getDia(){
        return dia;
    }// End getDia()

    public void setDia(int dia){
        this.dia = dia;
    }// End setDia()

    public int getHoraVendida(){
        Calendar calendar = Calendar.getInstance();
        return calendar.get(Calendar.HOUR);
    }// End getHoraVendida()

    public int getDiaVendido(){
        Calendar calendar = Calendar.getInstance();
        return calendar.get(Calendar.DATE);
    }// End getHoraVendida()

    public int getHora(){
        return hora;
    }// End getHora()

    public void setHora(int hora){
        this.hora = hora;
    }// End setHora()

    public Comprador getComprador(){
        return comprador;
    }// End getComprador()

    public void setComprador(Comprador comprador){
        this.comprador = comprador;
    }// End setComprador()
}// End Venda
