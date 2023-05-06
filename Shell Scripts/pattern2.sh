# Diamond

n=8
k=$n-1
for ((i=0 ; i<$n ; i++))
do
	for ((j=0 ; j<$k ; j++))
	do
		echo -n " "
	done
	
	k=$((k-1))
	
	for ((j=0 ; j<$((i+1)) ; j++))
	do
		echo -n "* "
	done
	echo ""
done

k=1
for ((i=n-1 ; i>0 ; i--))
do
	for ((j=0 ; j<$k ; j++))
	do
		echo -n " "
	done
	
	k=$((k+1))
	
	for ((j=1 ; j<$((i+1)) ; j++))
	do
		echo -n "* "
	done
	echo ""
done
