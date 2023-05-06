#!/bin/bash
if [ $# -eq 1 ]
then
    Num=$1
else
    echo -n "Enter a Number : "
    read Num
fi

Fibonacci()
{
case $1 in
	0|1) printf "$1 " ;;
	*) echo -n "$(( $(Fibonacci $(($1-2)))+$(Fibonacci $(($1-1))) )) ";;
esac
}

echo "The Fibonacci sequence for the number $Num is : "

for (( i=0; i<=$Num; i++ ))
do
	Fibonacci $i    
done

echo


