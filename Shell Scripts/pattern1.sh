n=5

for ((i=1 ; i<=$n ; i++))
do
	for ((j=1 ; j<=2*$((n-i)) ; j++))
	do
		echo -n " "
	done
	for ((j=1 ; j<=$i ; j++))
	do
		echo -n "$j "
	done
	for ((j=$i-1 ; j>0 ; j--))
	do
		echo -n "$j "
	done
	echo ""
done

