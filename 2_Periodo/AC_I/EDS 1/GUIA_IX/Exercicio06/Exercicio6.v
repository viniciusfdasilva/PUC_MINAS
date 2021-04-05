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
endmodule // clock ()

module pulse( signal,clock );
input clock;
output signal;
reg
signal;
always@(posedge clock)
begin
signal = 1'b1;
#2 signal = 1'b0;
#2 signal = 1'b1;
#2 signal = 1'b0;
end
endmodule // pulse

module Exercicio6;
wire clk;
wire singal;
clock CLK1 (clk);
pulse PLS1(signal,clk);
initial begin
$dumpfile ( "Exercicio_6.vcd" );
$dumpvars;
#120 $finish;
end
endmodule // Exercicio6 ( )
