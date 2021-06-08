# x = 3;
# y = x * 4 ;

# ASSOCIAÇÃO
# x -> $s0
# y -> $s1

.text
.globl main

main:
addi $s0,$zero,3
sll  $s1,$s0,2
