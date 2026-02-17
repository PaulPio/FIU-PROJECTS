.data
    result_msg: .asciiz "Sum of odd factorials: "
    newline:    .asciiz "\n"

.text
.globl main

# ------------------------------------------------------------------
# Main function
# ------------------------------------------------------------------
main:
    li $a0, 7           # n = 7
    jal sum_odd_factorial # call sum_odd_factorial(n)
    move $t0, $v0       # result = sum_odd_factorial(n)

    # Print prompt message
    li $v0, 4           # syscall code for print_string
    la $a0, result_msg  # load address of message
    syscall             # print "Sum of odd factorials: "

    # Print integer result
    li $v0, 1           # syscall code for print_int
    move $a0, $t0       # move result to $a0
    syscall             # print result

    # Print newline
    li $v0, 4           # syscall code for print_string
    la $a0, newline     # load address of newline
    syscall             # print "\n"

    # Exit program
    li $v0, 10          # syscall code for exit
    syscall             # exit program

# ------------------------------------------------------------------
# int sum_odd_factorial(int n)
# ------------------------------------------------------------------
sum_odd_factorial:
    # Prologue
    addi $sp, $sp, -16  # adjust stack for 4 items
    sw $ra, 0($sp)      # save return address
    sw $s0, 4($sp)      # save $s0 (sum)
    sw $s1, 8($sp)      # save $s1 (n)
    sw $s2, 12($sp)     # save $s2 (i)

    move $s1, $a0       # $s1 = n
    li $s0, 0           # sum = 0
    li $s2, 1           # i = 1

loop_sum:
    bgt $s2, $s1, end_sum # if i > n, exit loop

    move $a0, $s2       # argument = i
    jal factorial       # call factorial(i)

    add $s0, $s0, $v0   # sum += factorial(i)

    addi $s2, $s2, 2    # i += 2
    j loop_sum          # jump to loop_sum

end_sum:
    move $v0, $s0       # return value = sum

    # Epilogue
    lw $s2, 12($sp)     # restore $s2
    lw $s1, 8($sp)      # restore $s1
    lw $s0, 4($sp)      # restore $s0
    lw $ra, 0($sp)      # restore return address
    addi $sp, $sp, 16   # restore stack pointer
    jr $ra              # return to caller

# ------------------------------------------------------------------
# int factorial(int n)
# ------------------------------------------------------------------
factorial:
    li $v0, 1           # rv = 1
    li $t0, 1           # i = 1

loop_fact:
    bgt $t0, $a0, end_fact # if i > n, exit loop

    mul $v0, $v0, $t0   # rv *= i
    addi $t0, $t0, 1    # i++
    j loop_fact         # jump to loop_fact

end_fact:
    jr $ra              # return to caller
