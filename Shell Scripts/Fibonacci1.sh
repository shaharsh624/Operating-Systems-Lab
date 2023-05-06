#!/bin/bash
n=10
a=1
b=1

echo -n "$a $b "

for ((i=2 ; i<=n ; i++))
do
	temp=$b
	b=$(($a+$b))
	a=$temp
	echo -n "$a "
done
echo ""
