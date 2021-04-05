// descricao de testes (benchmarking)
module test_adders;
// definir dados independentes
   reg  a = 0;
   reg  b = 0;

// definir valores dependentes
   wire s0, s1;

// definir relacoes de dependencia
   assign s0 = a^b;
   assign s1 = a&b;

// bloco de acoes sequenciais (principal)
   initial
   begin: main
      $display ( "a b s1 s0" );
 #1 // aguardar 1 unidade de tempo
      $display ( "%b %b  %b  %b", a,b, s1,s0 );
   end
endmodule // test_adders