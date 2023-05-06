#!/bin/bash

read -p "Enter the number: " n
c=0
while [ $n -gt 0 ]
do
a=`expr $n % 10 `
n=`expr $n / 10 `
c=`expr $c \* 10 + $a`
done
echo "Reversed number: $c"

