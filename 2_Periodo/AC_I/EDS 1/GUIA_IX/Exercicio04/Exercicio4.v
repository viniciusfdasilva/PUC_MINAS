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
#24 clk = ~clk;
end
endmodule // clock ( )

module pulse ( signal, clock );
input clock;
output signal;
reg
signal;
always
begin
signal = 1'b1;
#3 signal = 1'b0;
#3 signal = 1'b1;
#3 signal = 1'b0;
end
endmodule // pulse

module Exercicio4;
wire clk;
wire signal;
clock CLK1 ( clk );
pulse PULSE1(signal,clock);
initial begin
$dumpfile ( "Exercicio_4.vcd" );
$dumpvars;
#120 $finish;
end
endmodule // Exercicio4 ( )
