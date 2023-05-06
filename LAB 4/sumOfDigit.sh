echo -n "Enter a number: "
read num

temp=$num
sum=0
while ((num > 0))
do
	sum=$((num%10+sum))
	num=$((num/10))
done
echo "Sum of digits of $temp is $sum"