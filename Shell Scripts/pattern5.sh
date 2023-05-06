n=5
count=21
for ((i=1 ; i<=$((2*n)) ; i=$i+2))
do
	for ((j=1 ; j<=$((i/2)) ; j++))
	do
		echo -n "   "
	done
	
	for ((j=1 ; j<=$((2*n-i)); j++))
	do
		echo -n "$count "
		count=$((count+1))
	done
	echo ""
done

for ((i=1 ; i<$n ; i++))
do
	for ((j=1 ; j<=$((n-i-1)) ; j++))
	do
		echo -n "   "
	done
	
	for ((j=1 ; j<$((2*$((i+1)))); j++))
	do
		echo -n "$count "
		count=$((count+1))
	done
	echo ""
done

