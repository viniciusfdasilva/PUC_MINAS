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
#48 clk = ~clk;
end
endmodule // clock ( )

module Exercicio5;
wire clk;
clock CLK1 ( clk );
initial begin
$dumpfile ( "Exercicio_05.vcd" );
$dumpvars;
#120 $finish;
end
endmodule // Exercicio5 ( )
