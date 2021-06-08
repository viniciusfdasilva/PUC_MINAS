import java.io.*;

public class teste_envia_java
{
  public static void main (String [] args)
  throws Exception
  {

   ProcessBuilder pb;
	Process p;
	int j, tempo=500;
	String x;
   Long start_time;
   Long diff_time;

	for(int i=0;i<5;i++)
		{
 			j=1+i%2;
			x = "0"+" "+"0"+" "+j;
  			pb = new ProcessBuilder("envia.exe","com31",x);
			p = pb.start();
//       start_time = System.nanoTime();
//       p.waitFor( );
//       diff_time = (System.nanoTime() - start_time)/1000000;

   		try { Thread.sleep(tempo); }
					catch(Exception e)
					{ 	System.out.println("Ups!"); }

//   		System.out.println("i= "+i+" j= "+j+" x= "+x+" "+diff_time);
    		System.out.println("i= "+i+" j= "+j+"-- O que foi enviado: envia.exe com... "+x);
		}


	}
}