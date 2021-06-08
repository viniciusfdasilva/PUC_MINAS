# x = -1;
# y = x / 32 ;

.text
.globl main

main:
addi $s0,$zero,-1
sra  $s1,$s0,5
