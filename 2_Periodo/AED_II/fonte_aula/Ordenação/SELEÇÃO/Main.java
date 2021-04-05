public class Main{
	public static void main(String[] args){
		int[] vetor = new int[4];
		vetor[0] = 1;
		vetor[1] = 2;
		vetor[2] = 3;
		vetor[3] = 4;
 		boolean resp = Ordenacao.binarySearchRec(vetor,19);
 		System.out.println(resp); 
	}
}