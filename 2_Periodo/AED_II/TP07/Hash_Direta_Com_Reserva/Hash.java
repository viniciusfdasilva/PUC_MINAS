public class Hash {
   Serie tabela[];
   int m1, m2, m, reserva;
   int posicao;
  
   public Hash(){
      this(13,7);
   }// End Hash()

   public Hash(int m1,int m2){
      this.m1 = m1;
      this.m2 = m2;
      this.m = m1 + m2;
      this.tabela = new Serie[this.m];
      for(int i = 0; i < m; i++){
         tabela[i] = null;
      }// End for
      reserva = posicao = 0;
   }// End Hash()

   public boolean inserir(Serie serie){
      boolean resp = false;
      if(serie != null){
         int pos = valorAsciinome(serie.getNome().trim());
         if(tabela[pos] == null){
            tabela[pos] = serie;
            resp = true;
         }// End if
         else if(reserva < m2){
            tabela[m1+reserva] = serie;
            reserva++;
            resp = true;
         }// End else if
      }// End if
      return resp;
   }// End inserir()

   public int valorAsciinome(String str){
		int cont = 0;
		for(int i = 0; i < str.length(); i++){
			cont += (int)str.charAt(i);
		}// End for
		return cont % this.m1; 
	}// End valorAsciinome() 

   public int getposicao(){
   	return this.posicao;
   }// End getposicao()

   public boolean pesquisar(String str){
      boolean resp = false;
      int pos = valorAsciinome(str);
      if(tabela[pos] != null && tabela[pos].getNome().trim().equals(str)){
         this.posicao = pos;
         resp = true;
      }// End if
      else{
         for(int i = 0; i < reserva; i++){
            if(tabela[m1+i].getNome().trim().equals(str)){
               this.posicao = m1+i;
               resp = true;
               i = reserva;
            }// End if
         }// End for
      }// End else
      return resp;
   }// End pesquisar()
}// End Hash
