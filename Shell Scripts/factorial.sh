#!/bin/bash

# define the factorial function
factorial () {
	if [ "$1" -eq 0 ]
	then
		echo 1
	elif [ "$1" -lt 0 ]
	then
		echo "Factorial not possible for negative numbers"
	else
		prev=$(factorial $(($1 - 1)))
		echo $(($1 * $prev))
	fi
}

# call the factorial function with argument
read -p "Enter number: " n
echo "$n! = $(factorial $n)"

