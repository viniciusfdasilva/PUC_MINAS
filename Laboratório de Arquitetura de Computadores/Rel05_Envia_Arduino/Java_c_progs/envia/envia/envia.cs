using System;
using System.IO.Ports;
using System.Diagnostics;

namespace envia
{
	class Program
	{
		static int Main(string[] args)
		{
			String porta, velocidade, p1, p2, p3, p4, p5, envia, tempo, dados;
			int vel, recebe;
			velocidade = "9600";
			envia="n";
			porta = "COM3";
			p1 = "1";
			p2 = "1";
			p3 = "1";
			p4 = "1";
			p5 = "1";
			dados = p1+" "+p2+" "+p3+" "+p4+" "+p5+"\n";
			tempo = "100";
			try{
				
				if (args.Length == 0)
				{
					Console.WriteLine ("Uso do programa:\nenvia <porta dado1 dado2 dado3 dado4 dado5>\n- porta default = com3 \n- dados default = 1 1 1 1 1  \n- velocidade default=9600");
					Console.WriteLine ("\n A porta sempre devera ser fornecida, COM1, COM2, etc");
					Console.WriteLine ("\n Nao e obrigatorio enviar 5 dados, pode-se enviar:\n-apenas dado1 (Ex.: envia COMx X) ou \n-o dado1 e o dado2 (Ex.: envia COMx X Y) ou\n-os 3 dados (Ex.: envia COMx X Y Z) e assim por diante");
					Console.WriteLine ("\n Uma mudanca de linha (um \\n) sempre sera inserida apos o ultimo dado.");
					Console.WriteLine ("\n Ex.: Uma chamada do tipo: <envia COM5 9> \nenvia uma string 9 para COM5 na velocidade de 9600");
					Console.WriteLine ("\n Uma chamada <envia 1> entra no modo interativo.");
					
					
					string[] ports = SerialPort.GetPortNames();
					
					Console.WriteLine("\nObs.: Para verificar em qual porta o arduino estah, execute o programa antes\n e depois de conectar o arduino e observe as portas disponiveis.\nSeguintes portas disponiveis nessa maquina:");
					
					foreach (string port in ports)
					{
						Console.WriteLine(port);
					}
					Console.ReadKey();
					return 0;
					
				}
				else
				{
					if (args.Length == 1 && args[0]=="1")
					{ 
						Console.WriteLine("\n Modo interativo, \ndigitar -1 para sair do modo iterativo:\n");
						Console.WriteLine("\n Porta?\n");
						porta = Console.ReadLine();
						Console.WriteLine("\n Velocidade?\n");
						velocidade = Console.ReadLine();
						Console.WriteLine("\n Timeout? Se o valor for 0 ele apenas envia\n");
						tempo=Console.ReadLine();
						
						vel = int.Parse(velocidade);
						
						SerialPort sp = new SerialPort(porta, vel);
						if (sp != null)
						{
							if (sp.IsOpen)
							{
								sp.Close();
								Console.WriteLine ( "Porta ja aberta\n");
								return 0;
							}
							else
							{
								
								sp.Open();
								sp.ReadTimeout = int.Parse(tempo);
							}
							
							recebe=0;
							p1="1";
							while (p1!="-1")
							{
								Console.WriteLine ("\nDigite valor a ser enviado\n");
								p1=Console.ReadLine();					
								sp.Write(p1);
								if (tempo!="0")
								{
									try{
										recebe=sp.ReadByte();
										Console.WriteLine("\nValor recebido= ", recebe);
										Console.WriteLine(recebe);
									}
									catch (SystemException){}			
								}			
							}
						}
						sp.Close();
						return 0;
					}
					
				}
			}
			
			catch (SystemException){}
			
			if (args.Length == 2) 
			try{
				porta = args[0];
				p1 = args[1];
				dados=p1+"\n";
			}
			catch (SystemException){}
			
			if (args.Length == 3) 
			try{
				porta = args[0];
				p1 = args[1];
				p2 = args[2];
				dados = p1+" "+p2+"\n";
			}
			catch (SystemException){}
			
			if (args.Length == 4) 
			try{
				porta = args[0];
				p1 = args[1];
				p2 = args[2];
				p3 = args[3];
				dados = p1+" "+p2+" "+p3+"\n";
				
			}
			catch (SystemException){}
			
			if (args.Length == 5) 
			try{
				porta = args[0];
				p1 = args[1];
				p2 = args[2];
				p3 = args[3];
				p4 = args[4];
				dados = p1+" "+p2+" "+p3+" "+p4+"\n";

			}
			catch (SystemException){}
			
			if (args.Length == 6) 
			try{
				porta = args[0];
				p1 = args[1];
				p2 = args[2];
				p3 = args[3];
				p4 = args[4];
				p5 = args[5];
				dados = p1+" "+p2+" "+p3+" "+p4+" "+p5+"\n";

			}
			catch (SystemException){}
			
			if (args.Length == 7) 
			try{
				porta = args[0];
				p1 = args[1];
				p2 = args[2];
				p3 = args[3];
				p4 = args[4];
				p5 = args[5];
				dados = p1+" "+p2+" "+p3+" "+p4+" "+p5+"\n";
				tempo= args[6];

				
			}
			catch (SystemException){}
			
			if (args.Length != 0)
			{
				vel = int.Parse(velocidade);
				
				SerialPort sp = new SerialPort(porta, vel);
				if (sp != null)
				{
					if (sp.IsOpen)
					{
						sp.Close();
						Console.WriteLine ( "Porta ja aberta\n");
						return 0;
					}
					else
					{
						
						sp.Open();
						sp.ReadTimeout = int.Parse(tempo);
					}
				}
				recebe=0;
				//				Console.WriteLine(dados);
				//				Console.WriteLine(porta);
				//				Console.WriteLine(envia);
				//				Console.WriteLine(vel);
				//				Console.WriteLine(tempo);
				//				Console.ReadKey();
				sp.Write(dados);
				
				try{
					if (envia=="s")
					{
						recebe=sp.ReadByte();
						sp.Close();
						return(recebe);
					}
				}
				catch (SystemException){}
				sp.Close();
			}
			return 1;
		}
	}
}