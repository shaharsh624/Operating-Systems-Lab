a=10
b=2
c=12
d=5

sum=$(( a + b + c + d))
# sum=`expr $a + $b + $c + $d`

avg=`echo $sum / 4 | bc -l`

printf %0.3f "$avg"
printf "\n"
