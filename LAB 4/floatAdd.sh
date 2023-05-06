# Program to add 2 Float nos

echo "";
echo "Program to add 2 Float nos"

read -p "Enter number 1: " a
read -p "Enter number 2: " b

echo -n "Sum : $a + $b = "
echo "$a + $b" | bc

