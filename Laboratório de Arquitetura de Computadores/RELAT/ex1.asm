# a = 10;
# b = -1;
# a = a + 1;
# c = a + b;

# ASSOCIAÇÃO
# a -> $s0
# b -> $s1
# c -> $s2

.text
.globl main

main:
addi $s0,$zero,10
addi $s1,$zero,-1
addi $s0,$s0,1
add $s2,$s0,$s1