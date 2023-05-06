
echo "";
echo "Program to print Fibonacci Sequence of n numbers"
fib1=1
fib2=1
fib3=1

read -p "Enter the number of terms : " n
echo -n "Fibonacci Sequence : 1 1 "

for ((i=2 ; i<n ; i++))
do
    fib1=`expr $fib2`
    fib2=`expr $fib3`
    fib3=`expr $fib1 + $fib2`
    echo -n "$fib3 "
done
echo "";
echo "";
