import java.util.ArrayList;
import java.util.Calendar;
import java.util.List;

public class VendaDriver implements StubProdutoVendido,StubComprador{
    public void test(){
       int erro = 0;
        Calendar cal = Calendar.getInstance();
        int date = cal.get(Calendar.DATE);
        int hour = cal.get(Calendar.HOUR);

        List<ProdutoVendido> produtoVendidoList = new ArrayList<>();
        produtoVendidoList.add(new ProdutoVendido(1,2,5));

        Comprador comprador = new Comprador(
        "Ana Carla", "344.553.245-43",
                21,2,2002,
            'F',"2222442224");

       Venda venda = new Venda(date,hour,produtoVendidoList,comprador);

       if(venda.vendaAutorizada(17)) erro = 0;
       if(this.getIdade() < 18) erro = 1;
       if(venda.getDia() != date) erro = 2;
       if(venda.getHora() != hour) erro = 3;
       if(!this.getCpf().equals("344.553.245-43")) erro = 4;
       if(this.getSexo() != 'F') erro = 5;
       if(!this.getNumeroCartao().equals("2222442224")) erro = 6;
       if(this.getDia() != 21) erro = 7;
       if(this.getMes() != 2) erro = 8;
       if(this.getAno() != 2002) erro = 9;
       if(this.getCodigoProduto() != 1) erro = 10;
       if(this.getQtd() != 2) erro = 11;
       if(this.getPreco() != 5) erro = 12;

       if(erro == 0){
            System.out.println("Não possui erros!");
       }else{
            System.out.println("Erro número: " + erro);
       }// End else
    }// End test()

    @Override
    public String getNome() { return "Ana Carla"; }
    @Override
    public String getNumeroCartao() { return "2222442224"; }
    @Override
    public String getCpf() { return "344.553.245-43"; }
    @Override
    public int getDia() { return 21; }
    @Override
    public int getMes() { return 2; }
    @Override
    public int getAno() { return 2002; }
    @Override
    public char getSexo() { return 'F'; }
    @Override
    public int getIdade() { return 17; }
    @Override
    public int getCodigoProduto(){ return 1; }
    @Override
    public int getQtd() { return 2; }
    @Override
    public double getPreco() { return 5; }
}// End VendaDriver
