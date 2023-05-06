read -p "Enter number: " num

n=$num
length=${#num}
rem=0
sum=0

while [ $n -gt 0 ]
do
	rem=$((n%10))
	a=$((rem ** length))
	sum=$((sum+a))
	n=$((n/10))
done

if [ $sum -eq $num ]
then
	echo "$num is an armstrong number"
else
	echo "$num is not an armstrong number"
fi

