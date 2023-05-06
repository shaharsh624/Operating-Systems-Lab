a=`cat file1.txt` 
sum=0
for num in $a; do
	sum=$((sum+num))
done
echo $sum
