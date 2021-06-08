# j = 0;
# i = 10;
# do
# {
#  j = j + 1;
# }
# while ( j != i );

.text

.globl main

main:
addi $s0,$zero,0x0
addi $s1,$zero,0xA

do:
addi $s0,$s0,1
bne $s0,$s1,do
nop