/* Exemplo de Programa na linguagem L */

integer n;
string nome;
boolean naoTerminou;
const MAXITER=10;

/* Programa Principal */
main
  write('Digite seu nome: ');
  readln(nome);
  boolean valor = false;

  /* teste 1 */
  if(valor) valor = true;
  
  naoTerminou=true;
  n=0;
  while (naoTerminou) begin
    writeln('Ola',nome);
    n=n+1;
    naoTerminou=n<MAXITER;
  end
end
/* Final do programa */