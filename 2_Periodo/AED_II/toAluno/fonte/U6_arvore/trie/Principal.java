class Principal {
   public static void main (String[] args) throws Exception {
      ArvoreTrie arv = new ArvoreTrie();

      String array[] = new String[8];
      array[0] = "ABACAXI";
      array[1] = "BALA";
      array[2] = "BOLO";
      array[3] = "ABACATE";
      array[4] = "galo";
      array[5] = "pata";
      array[6] = "pato";
      array[7] = "gato";

      for(int i = 0; i < array.length; i++){
         arv.inserir(array[i]);
      }
      arv.mostrar();
   }
}
