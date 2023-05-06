read -p "Enter Num1 : " num1
read -p "Enter Num2 : " num2
read -p "Enter Num3 : " num3

if [ $num1 -gt $num2 ] && [ $num1 -gt $num3 ]
then
    echo "The largest numbers among $num1, $num2, $num3 is : "$num1
elif [ $num2 -gt $num1 ] && [ $num2 -gt $num3 ]
then
    echo "The largest numbers among $num1, $num2, $num3 is : "$num2
else
    echo "The largest numbers among $num1, $num2, $num3 is : "$num3
fi
