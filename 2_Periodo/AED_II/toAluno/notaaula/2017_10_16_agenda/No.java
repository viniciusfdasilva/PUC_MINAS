class No {
   public char letra;
   public Celula primeiro, ultimo;
   public No esq, dir;

   public No (char letra){
      this(letra, null, null);
   }
   public No (char letra, No esq, No dir){
      this.letra = letra;
      this.primeiro = this.ultimo = new Celula();
      this.esq = esq;
      this.dir = dir;
   }
}
