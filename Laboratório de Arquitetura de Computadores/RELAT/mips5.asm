#x = 305419896;

.text
.globl main

main:
addi $t0,$zero,0x1234
sll $t0,$t0,16
ori $s0,$t0,0x5678

