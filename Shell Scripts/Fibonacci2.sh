# Print Fibonacci between fib1 and fib2

# Range
fib1=3
fib2=55

a=1
b=1

while [ $b -le $fib2 ]
do
    if [ $b -ge $fib1 ]
    then
        printf "$b " 
    fi

    temp=$b
    b=$(($a+$b))
    a=$temp  
done

