


.text
.globl main

main:
addi $t0,$zero,100

addi $t2,$zero,0
addi $t1,$zero,0
addi $s0,$zero,1

do:
add  $t1,$zero,$t2
add  $t2,$zero,$s0
add  $s0,$t1,$t2
slt  $t3,$s0,$t0
beq  $t3,$zero,end
j do

end:
nop
