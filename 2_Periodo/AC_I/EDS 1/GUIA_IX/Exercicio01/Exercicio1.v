// ---------------------------
// -- test clock generator (1)
// ---------------------------
module clock ( output clk );
reg clk;

initial
begin
clk = 1'b0;
end
always
begin
#12 clk = ~clk;
end
endmodule // clock ( )

module Exercicio1;
wire clk;
clock CLK1 ( clk );
initial begin
$dumpfile ( "Exercici0_01.vcd" );
$dumpvars;
#120 $finish;
end
endmodule // Exemplo_0901 ( )
