read -p "Enter the principle value: " p
read -p "Enter the rate of interest: " r
read -p "Enter the time period: " t

i=` expr $p \* $t \* $r `
i=` expr $i / 100 `
 
echo "Simple Interest is: $i"
