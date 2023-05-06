read -p "Enter number: " num

# Binary finding function
binary() {
	array=()
	n=$1
	rem=0
	while [ $n -gt 0 ]
	do
		rem=$((n%2))
		n=$((n/2))
		length=${#array[@]}
		array[$length]=$rem
	done
	
	echo -n "Binary Converted: "
	for ((i=$((length+1)) ; i>=0 ; i--)) 
	do
	echo -n "${array[$i]}"
	done
	echo ""
}


# Octal Conversion
octal() {
	array=()
	n=$1
	rem=0
	while [ $n -gt 0 ]
	do
		rem=$((n%8))
		n=$((n/8))
		length=${#array[@]}
		array[$length]=$rem
	done
	
	echo -n "Octal Converted: "
	for ((i=$((length+1)) ; i>=0 ; i--)) 
	do
	echo -n "${array[$i]}"
	done
	echo ""
}

# Fibonacci function
fibonacci() {
	n=$num
	f=0
	for ((i=2 ; i<=$(expr n/2) ; i++))
	do
		if [ $((n%i)) -eq 0 ]
		then
			f=1
		fi
	done

	if [ $f -eq 1 ]
	then
		echo "$num is not prime."
		octal $num
	else
		echo "$num is prime."
		binary $num
	fi
}

fibonacci $num
