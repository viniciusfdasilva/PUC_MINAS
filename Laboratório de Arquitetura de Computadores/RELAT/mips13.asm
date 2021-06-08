.text
.globl main

main:
addi $t3,$zero,50
addi $t4,$zero,100
addi $t5,$zero,150
addi $t6,$zero,200

addi $t0,$zero,0x1001
sll $t0,$t0,16
ori $t0,$t0,0x0000

lw $t1,0($t0)
slt $t2,$t3,$t1
bne $t2,$zero,se1
beq $t1,$t3,se1
j se2
nop

se1:
slt $t2,$t4,$t1,
bne $t2,$zero,true
beq $t1,$t4,true
j se2
nop

se2:
slt $t2,$t1,$t5,
bne $t2,$zero,se3
beq $t1,$t5,se3
j else
nop

se3:
slt $t2,$t1,$t6
bne $t2,$zero,true
beq $t1,$t6,true
j else
nop

true:
addi $s0,$zero,1
nop

else:
addi $s0,$zero,0
nop
.data
A: .word 200