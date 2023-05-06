#!/bin/bash

content=$(cat file1.txt)
touch -c file2.txt
sum=0

for i in $content;
do
	sum=$((sum+i))
	echo $i >> file2.txt
done

sleep 1
open file2.txt

