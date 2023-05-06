#!/bin/sh
# Optimized Bubble Sort

declare -a arr

# Input
read -p "Enter size: " n
for ((i=0 ; i<$n ; i++))
do
	read -p "Enter number: " arr[$i]
done

# arr=(10 8 20 100 12)
echo "Array Before Sorting: "
echo ${arr[*]}

flag=1
for ((i=0 ; i<$n ; i++))
do
	flag=0
	for ((j=0 ; j<$(($n-i-1)) ; j++))
	do
		if [ ${arr[$j]} -gt ${arr[$((j+1))]} ]
		then
			temp=${arr[$j]}
			arr[$j]=${arr[$((j+1))]}
			arr[$((j+1))]=$temp
			flag=1
		fi
	done

	if [ $flag -eq 0 ]
	then
		break
	fi
done

echo "Array After Sorting: "
echo ${arr[*]}

