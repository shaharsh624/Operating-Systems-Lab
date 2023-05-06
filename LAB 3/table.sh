echo "--- Enter Number to Generate Multiplication Table ---"
read -p "Enter the number : " num

i=1
while [ $i -le 10 ]
do
echo " $num * $i = `expr $num \* $i ` "
i=`expr $i + 1`
done
