.data
    result_msg: .asciiz "Result: "
    newline:    .asciiz "\n"

.text
.globl main

# ------------------------------------------------------------------
# Main function
# ------------------------------------------------------------------
main:
    li $a0, 10                  # n = 10 (test value)
    jal nested_loop_test        # call nested_loop_test(n)
    move $t0, $v0               # result = nested_loop_test(n)

    # Print prompt message
    li $v0, 4                   # syscall: print_string
    la $a0, result_msg          # load address of message
    syscall                     # print "Result: "

    # Print integer result
    li $v0, 1                   # syscall: print_int
    move $a0, $t0               # move result to $a0
    syscall                     # print result

    # Print newline
    li $v0, 4                   # syscall: print_string
    la $a0, newline             # load address of newline
    syscall                     # print "\n"

    # Exit program
    li $v0, 10                  # syscall: exit
    syscall                     # exit

# ------------------------------------------------------------------
# int nested_loop_test(int n)
# ------------------------------------------------------------------
nested_loop_test:
    addi $sp, $sp, -20          # adjust stack for 5 items
    sw $ra, 0($sp)              # save return address
    sw $s0, 4($sp)              # save $s0 (n)
    sw $s1, 8($sp)              # save $s1 (rv)
    sw $s2, 12($sp)             # save $s2 (i)
    sw $s3, 16($sp)             # save $s3 (j)

    move $s0, $a0               # $s0 = n
    li $s1, 1                   # rv = 1
    li $s2, 1                   # i = 1

loop_outer:
    bge $s2, $s0, end_outer     # if (i >= n) break loop_outer

    move $s3, $s2               # j = i

loop_inner:
    blt $s3, $zero, end_inner   # if (j < 0) break loop_inner

    andi $t0, $s3, 1            # $t0 = j & 1 (check if j is odd)
    bne $t0, $zero, else_block  # if (j % 2 != 0) goto else_block

    add $t1, $s2, $s3           # $t1 = i + j
    add $s1, $s1, $t1           # rv += (i + j)
    j update_inner              # continue to next iteration

else_block:
    sll $t2, $s2, 1             # $t2 = 2 * i
    sll $t3, $s3, 1             # $t3 = 2 * j
    add $t3, $t3, $s3           # $t3 = 3 * j (2*j + j)
    sub $t4, $t2, $t3           # $t4 = (2*i) - (3*j)
    add $s1, $s1, $t4           # rv += (2*i - 3*j)

update_inner:
    addi $s3, $s3, -1           # j--
    j loop_inner                # jump back to loop_inner

end_inner:
    sll $s2, $s2, 1             # i *= 2
    j loop_outer                # jump back to loop_outer

end_outer:
    move $v0, $s1               # return rv

    lw $s3, 16($sp)             # restore $s3
    lw $s2, 12($sp)             # restore $s2
    lw $s1, 8($sp)              # restore $s1
    lw $s0, 4($sp)              # restore $s0
    lw $ra, 0($sp)              # restore return address
    addi $sp, $sp, 20           # restore stack pointer
    jr $ra                      # return
