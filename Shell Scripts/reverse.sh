read -p "Enter a number: " num
n=$num

rem=0
result=0

while [ $n -gt 0 ]
do
	rem=$((n%10))
	n=`expr $n / 10`
	result=`expr $rem + $((result * 10))`
done

echo "Reversed number: $result"


