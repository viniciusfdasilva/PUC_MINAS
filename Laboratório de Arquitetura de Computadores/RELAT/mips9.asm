# A [ j ] = h + A [ i ] ;

.text

.globl main

main:
addi $t0,$zero,0x1001
sll $t0,$t0,16
ori $t0,$t0,0x0000

addi $s0,$zero,0x1
sll  $s0,$s0,2
add $s0,$s0,$t0

addi $s1,$zero,0x2
sll  $s1,$s1,2
add $s1,$s1,$t0

addi $s2,$zero,5

lw $t1,0($s0)
add $t1,$t1,$s2
sw $t1,0($s1)


.data
A: .word 0
B: .word 20
