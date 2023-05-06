#!/bin/bash

file="file1.txt"
content=$(cat "$file")

sum=0
for item in "${content[@]}"; do
    sum=`expr $sum + $item`
done

echo $sum
