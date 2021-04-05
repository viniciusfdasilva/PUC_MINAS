import java.util.Scanner;
public class Unidade02pg40{
	public static void main(String[] args){
		Scanner scanner = new Scanner(System.in);
		int integer = scanner.nextInt();
		letraA(integer);
		letraB(integer);
		letraC(integer);
		letraE(integer);
		letraF(integer);
	}// End main()

	public static void letraA(int n){
		int i = 0;
		int a = n;
		int b = Integer.MAX_VALUE;
		int c = (Integer.MAX_VALUE / n);
		while(i < n){
			a--;
			b--;
			c--;
			i++;
		}// End while
		int a = n;
		int b = Integer.MAX_VALUE;
		for(int i = 0; i < n; i++){
			for(int j = 0; j < n; j++){
				a--;
				b--;
			}// End for
		}// End for
	}// End letraA()

	public static void letraB(int n){
		int i = 0;
		int a = n;
		int b = Integer.MAX_VALUE;
		int c = (Integer.MAX_VALUE / n);
		int d = 69;
		int e = 69/Integer.MAX_VALUE;
		while(i < n){
			a--;
			b--;
			c--;
			d--;
			e--;
			i++;
		}// End while
		int a = n;
		int b = Integer.MAX_VALUE;
		for(int i = 0; i < n; i++){
			for(int j = 0; j < n; j++){
				for(int j = 0; j < n; j++){
					a--; b--;c--;d--;
				}// End for
			}// End for
		}// End for
	}// End letraB()

	public static void letraC(int n){
		int a = n;
		for(int i = n; i < 0; i >> 2){
			a--;
		}// End for
		a = n;
		for(int i = 0; i < n; i++){
			a--;
		}// End for
	}// End letraC()

	public static void letraD(int n){
		int a = n;
		int b = n*n;
		int c = 40;
		int d = 200;
		int e = (int)('a');
		for(int i = 0; i < n; i++){
			for(int i = 0; i < n; i++){
				for(int i = 0; i < n; i++){
					a--;b--;
				}// End for
			}// End for
		}// End for
		a = n;
		b = n*n;
		a--;b--;c--;d--;e--;
	}// End letraD()

	public static void letraE(int n){
		int a = n;
		int b = n*n;
		int c = n+n;
		int d = n<<2;
		int e = n+n*n;
		int f = n;
		int g = n*n;
		int h = n+n;
		int i = n<<2;
		for(int i = 0; i < n; i++){
			for(int i = 0; i < n; i++){
				for(int i = 0; i < n; i++){
					for(int i = 0; i < n; i++){
						a--;b--;c--;d--;e--;f--;g--;h--;i--;
					}// End for
				}// End for
			}// End for
		}// End for
		int a = n;
		int b = n*n;
		int c = n+n;
		int d = n<<2;
		int e = n+n*n;
		for(int i = 0; i < n;i++){
			for(int i = 0; i < n;i++){
				a--;b--;c--;d--;e--;
			}// End for
		}// End for
		a = n;
		for(int i = 0; i < n/2;i++){
			a--;
		}// End for
	}// End letraE()

	public static void letraF(int n){
		int a = n;
		int b = n*n;
		int c = n+n;
		int d = Integer.MAX_VALUE;
		int e = Integer.MAX_VALUE * n;
		for(int i = n; i > 0;i >> 2){
			a--;
		}// End for
		for(int i = n; i > 0;i >> 2){
			a--;b--;c--;d--;e--;
		}// End for
	}// End letraF()
}// End class Unidade02pg40