For the first extra credit at the beginning of each recursive call to solve,
a boolean array usedDigits is created to track
which digits (0-9) have already been assigned to a variable in the current path.

Inside the for loop that iterates from digit = 0 to 9,
the condition if (!usedDigits[digit]) checks if the digit is available
before attempting to assign it.
If the digit is already in use, the loop skips it and moves to the next one

For the second extra credit, is inside the solve method,
immediately after the unique digit check.
The condition if (digit == 0 && isFirstLetter(unassignedVariable)) is checked.
after that it calls the helper method isFirstLetter(char c), which
returns true if the given character is the first letter of any operand
or the result word (and the word is longer than one character).
If both conditions are true (the digit is 0 and the letter is a leading letter),
the program skips that assignment and continues to the next digit in the loop.