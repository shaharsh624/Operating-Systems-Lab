read -p "How many numbers do you want to sum up : " N

i=1
sum=0

while [ $i -le $N ]
do
  read -p "Enter number $i : " num
  sum=$((sum + num))
  i=$((i + 1))
done

echo "Sum :" $sum
