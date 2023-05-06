echo "Enter a string"
read str

array=($(echo "$str" | fold -w1))

n=${#array[@]}
for ((i=0;i<n/2;i++))
do
	if((${array[i]}!=${array[n-i-1]}))
	then
	echo "$str is not a palindrome"
	exit 0
fi
done

echo "$str is a palindrome"


