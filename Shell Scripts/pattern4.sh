n=5
count=11
for ((i=1 ; i<=$n ; i++))
do
	for ((j=1 ; j<=$i ; j++))
	do
		echo -n " $count"
		count=$((count+1))
	done
	echo ""
done

for ((i=1 ; i<=$n ; i++))
do
	for ((j=$n ; j>i ; j--))
	do
		echo -n " $count"
		count=$((count+1))
	done
	echo ""
done

