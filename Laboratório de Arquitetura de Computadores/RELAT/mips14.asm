.text

.globl main

main:
addi $t0,$zero,0x1001
sll $t0,$t0,16
ori $t0,$t0,0x0000

addi $t4,$t0,4
addi $t5,$t0,8

lw $t1,0($t0)
lw $t2,0($t4)
lw $t3,0($t5)

slt $t6,$t1,$t2
beq $t6,$zero,swap1
nop

swap1:
sw $t2,0($t0)
lw $t1,0($t0)
sw $t1,0($t4)
lw $t2,0($t4)

slt $t6,$t2,$t3
beq $t6,$zero,swap2
nop

swap2:
sw $t3,0($t4)
lw $t2,0($t4)
sw $t2,0($t5)
lw $t3,0($t5)
nop

lw $s0,0($t4)
sw $s0,12($t0)

.data
A: .word 23
B: .word 98
C: .word 17

 
