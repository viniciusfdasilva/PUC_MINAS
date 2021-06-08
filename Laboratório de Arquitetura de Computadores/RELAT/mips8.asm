# h = k + A [ i ] ;

.text
.globl main

main:
addi $t0,$zero,0x1001
sll $t0,$t0,16
ori $t0,$t0,0x0000

addi $s1,$t0,0x4
addi $s0,$zero,0xA

lw $t1,0($s1)
add $s0,$s0,$t1



.data
A: .word 0
B: .word 22
