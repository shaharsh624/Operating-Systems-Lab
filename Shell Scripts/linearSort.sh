read -p "Enter number: " n
declare -a array

# Input
for ((i=0 ; i<$n ; i++))
do
	read -p "Enter number: " array[$i]
done


for ((i=0 ; i<$n ; i++))
do
	for ((j=i ; j<$((n-i-1)) ; j++))
	do
		if ${array[$((i-1))]} -gt ${array[$i]}
		then
			temp = ${array[$i]}
			${array[$i]} = ${array[$((i-1))]}
			${array[$i]} = $temp
		fi
	done
done




# Output
for i in ${array[@]}
do
	echo $i
done






