# h = A [ i ] ;
# A[ i ] = A [ i + 1] ; 
# A [ i + 1] = h ;

.text 
.globl main


main:
addi $t0,$zero,0x1001
sll $t0,$t0,16
ori $t0,$t0,0x0000

lw $s0,0($t0)
lw $t3,4($t0)
sw $t3,0($t0)
sw $s0,4($t0)

.data
A: 20
B: 15 