echo "";
i=0
while [ $i != 6 ]
do
	echo "1. Display calender of current Month"
	echo "2. Display current date and time"
	echo "3. Display usernames of those who are currently logged in the system"
	echo "4. Display your name at given x, y position"
	echo "5. Display Terminal Number"
	echo "6. Exit"
	read -p "Choose your option & enter corresponding value: " ch
	echo "";

	case "$ch" in
		1) cal;;
		2) date;;
		3) whoami;;
		4) row=$(tput lines)
		   col=$(tput cols)
		   echo "Terminal Window has Rows: $row Cols: $col"
			
		   read -p "X position: " x
		   read -p "Y position: " y
		   read -p "Enter name: " name
		   tput cup $x $y
		   echo "$name";;
		5) tty;;
		6) exit;;
		*) echo "Enter valid choice";;
	esac
	echo "";
done
