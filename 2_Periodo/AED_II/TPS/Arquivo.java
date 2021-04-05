import java.io.RandomAccessFile;
import java.util.*;
/**
 * Arquivo
 * @author Vinicius Francisco da Silva
 * @version 1 08/2017
 */
public class Arquivo{
	public static void main(String[] args) throws Exception{
		String str;
		RandomAccessFile randomaccessfile = new RandomAccessFile("outarq","rw");
		int n = MyIO.readInt();
		random(n,randomaccessfile);
	}// End main()

	/*
     * Metodo publico escreve n valores em um arquivo
     * fecha o mesmo e realiza a leitura do final do
     * arquivo até o inicio
     * @param int n com a quantidade de valores a serem
     * lido, RandomAccessFile com um ponteiro que está
     * apontando para o endereço onde está localizado o 
     * arquivo
     * @return void
     */
	public static void random(int n,RandomAccessFile randomaccessfile) throws Exception{
		for(int i = 0; i < n; i++){
			randomaccessfile.writeDouble(MyIO.readDouble());
		}// End for
		long j = randomaccessfile.getFilePointer();
		double dbl;
		randomaccessfile.close();
		randomaccessfile = new RandomAccessFile("outarq","r"); 
		j = j-8;
		while(j >= 0){
			randomaccessfile.seek(j);
			dbl = randomaccessfile.readDouble();
			if(dbl - (int)dbl == 0){
				MyIO.println((int)dbl);
			}// End if
			else{
				MyIO.println(dbl);
			}// End else
			j = j-8;
		}// End while
		randomaccessfile.close();
	}// End random()
}// End class Arquivo
