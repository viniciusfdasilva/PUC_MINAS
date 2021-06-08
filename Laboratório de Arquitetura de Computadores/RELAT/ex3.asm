# x = 3;
# y = x * 1025;


.text
.globl main

main:
addi $s0,$zero,3
sll $s1,$s0,0xA
addi $s1,$s1,3

