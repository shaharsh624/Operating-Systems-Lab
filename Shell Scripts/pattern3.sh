# Diamond

n=8
k=$n-1
for ((i=0 ; i<=$n ; i++))
do
	for ((j=$n ; j>$i ; j--))
	do
		echo -n " "
	done
	
	for ((j=0 ; j<$((2 * i))-1 ; j++))
	do
		if [ $j -eq 0 -o $j -eq $((2 * i - 2)) ]
		then
			echo -n "*"
		else
			echo -n " "
		fi
	done
	echo ""
done

k=1
for ((i=1 ; i<n ; i++))
do
	for ((j=0 ; j<$i ; j++))
	do
		echo -n " "
	done
	
	for ((j=$((2 * $((n-i)) - 1)) ; j>0 ; j--))
	do
		if [ $j -eq 1 -o $j -eq $((2 * $((n-i)) - 1)) ]
		then
			echo -n "*"
		else
			echo -n " "
		fi
	done
	echo ""
done
