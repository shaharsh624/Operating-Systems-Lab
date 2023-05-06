#!/bin/sh

num=87654321
rev=""
rem=0

temp=$num

while [ $temp -gt 0 ] 
do
    rem=`expr $temp % 10`
    temp=`expr $temp / 10`
    rev+=$rem
done

echo "${rev} "


