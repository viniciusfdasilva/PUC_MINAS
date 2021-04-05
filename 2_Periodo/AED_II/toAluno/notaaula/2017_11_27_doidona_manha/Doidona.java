class Doidona {
   private int t1[];
   private int t3[];
   private ArvoreBinaria arvT3;
   private ArvoreBinaria arvT2;
   private Lista listaT2;

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
      arvT3 = new ArvoreBinaria(); 
      arvT2 = new ArvoreBinaria(); 
      listaT2 = new Lista();
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
            arvT3.inserir(x);
         }
      } else if(hashT2(x) == 1){
         listaT2.inserir(x);
      } else { //if(hashT2(x) == 2)
         arvT2.inserir(x);
      }
   }

   void mostrar(){
      for(int i = 0; i < tamT1; i++){
         if(t1[i] != NULO){
            System.out.println(t1[i]);
         }
      }
      for(int i = 0; i < tamT3; i++){
         if(t3[i] != NULO){
            System.out.println(t3[i]);
         }
      }
      arvT3.mostrarCentral();
      listaT2.mostrar();
      arvT2.mostrarCentral();
   }
}
