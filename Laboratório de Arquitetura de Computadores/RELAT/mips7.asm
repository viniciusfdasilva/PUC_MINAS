# A[ 12 ] = h + A [ 8 ];

.text
.globl main

main:
addi $t0,$zero,0x1001
sll $t0,$t0,16
ori $t0,$t0,0x0000

addi $s0,$zero,0xA
lw $t1,0($t0)
add $t2,$s0,$t1
sw $t2,12($t0)


.data
A: .word 23

