public class Fatorial{
	public static void main(String[] args){
		int fat = 5;
		System.out.println(fatorial(fat));
	}// End main()

	public static int fatorial(int fat){
		if(fat == 0) return 1;
		else return fat * fatorial(fat-1);
	}// End fatorial()
}// End Fatorial()

