class No {
   public char letra;
   public No[] filho;
   public boolean fim;
   public static final TAMALFABETO = 255;
   public No (){
      this(' ');
   }
   public No (char letra){
      this.letra = letra;
      this.fim = false;
      filho = new No[TAMALFABETO];
      for(int i = 0; i < TAMALFABETO; i++){
         filho[i] = null;
      }
   }
   public int hash(char letra){
      return ((int)letra);
   }
}
