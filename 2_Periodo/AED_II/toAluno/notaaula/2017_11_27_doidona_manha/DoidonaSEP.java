class Doidona {
   private int t1[];
   private int t3[];
   private No raizT3;
   private No raizT2;
   private Celula primeiroT2, ultimoT2;

   private int tamT1 = 10;
   private int tamT3 = 11;
   private int NULO = -1;

   public Doidona () {
      t1 = new int[tamT1];
      t3 = new int[tamT3];
      for(int i = 0; i < tamT1; i++){
         t1[i] = NULO;
      }
      for(int i = 0; i < tamT3; i++){
         t3[i] = NULO;
      }
      raizT3 = raizT2 = null;
      primeiroT2 = ultimoT2 = new Celula();
   }

   int hashT1(int x){ /* ... */ }
   int hashT2(int x){ return (x % 3); }
   int hashT3(int x){ /* ... */ }
   int rehashT3(int x){ /* ... */ }

   void inserir(int x){
      if (x == NULO){
         //erro
      } else if (t1[hashT1(x)] == NULO){
         t1[hashT1(x)] = x;
      } else if(hashT2(x) == 0){
         if(t3[hashT3(x)] == NULO){
            t3[hashT3(x)] = x;
         } else if(t3[rehashT3(x)] == NULO){
            t3[rehashT3(x)] = x;
         } else {
            inserir(raizT3, x);
         }
      } else if(hashT2(x) == 1){
         inserir(primeiroT2, ultimoT2, x);
      } else { //if(hashT2(x) == 2)
            inserir(raizT2, x);
      }
   }
   void inserir(No i, int x){
      //Inserir da arvore
   }
   void inserir(Celula primeiro, Celula ultimo, int x){
      //Algum inserir da lista
      //veja a questao dos retornos de ponteiro
   }
}
