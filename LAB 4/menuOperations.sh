echo ""
i=0
ch=0

read -p "Enter number 1: " a
read -p "Enter number 2: " b

while [ $ch != 5 ] 
do 
	echo "1. Addition"
	echo "2. Subtraction"
	echo "3. Multiplication"
	echo "4. Division"
	echo "5. Exit"
	read -p "Choose your option & enter corresponding value: " ch
	echo "";

    case "$ch" in
		1) echo "Addition: `expr $a + $b`";;
		2) echo "Subtraction: `expr $a - $b`";;
		3) echo "Multiplication: `expr $a \* $b`";;
		4) echo "Division: `expr $a / $b`";;
		5) exit;;
		*) echo "PLEASE Enter valid choice";;
	esac
	echo "";
	
done
