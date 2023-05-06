read -p "Hello user, Enter a number to check whether it is odd or even: " num
if [ "$(expr $num % 2)" -eq 0 ]
then
	echo "$num is even"
else
	echo "$num is odd"
fi
