#!bin/bash

content=$(cat file1.txt)
sum=0
for i in $content;
do
	sum=$((sum+i))
done

touch -c file2.txt
echo $sum > file2.txt

