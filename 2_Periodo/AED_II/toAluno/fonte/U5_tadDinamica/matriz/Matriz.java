class Matriz {
   private Celula inicio;
   private int linha, coluna;

   public Matriz (){
      this.linha = this.coluna = 3;

      //alocar a matriz com this.linha linhas e this.coluna colunas
   }

   public Matriz (int linha, int coluna){
      this.linha = linha;
      this.coluna = coluna;

      //alocar a matriz com this.linha linhas e this.coluna colunas
   }

   public Matriz soma (Matriz m) {
      Matriz resp = null;

      if(this.linha == m.linha && this.coluna == m.coluna){
         //...
      }

      return resp;
   }

   public Matriz multiplicacao (Matriz m) {
      Matriz resp = null;

      if(){
         //...
      }

      return resp;
   }

   public boolean isQuadrada(){
      boolean (this.linha == this.coluna);
   }

   public void mostrarDiagonalPrincipal (){
      if(isQuadrada() == true){

      }
   }

   public void mostrarDiagonalSecundaria (){
      if(isQuadrada() == true){

      }
   }
}
