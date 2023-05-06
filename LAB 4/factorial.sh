echo -n "Enter a number: "
read num

fact=1
for ((i = num; i > 0; i --))
do
	fact=$((fact*i))
done
echo "Factorial of $num: $fact"	