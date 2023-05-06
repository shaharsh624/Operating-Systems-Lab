# Prime between a and b

read -p "Enter number 1: " a
read -p "Enter number 2: " b


for ((j=$a ; j<=$b ; j++))
do
    if [ $j -eq 0 -o $j -eq 1 ]; 
    then
        continue
    fi

    f=1
    for ((i=2 ; i<=$j/2 ; i++))
    do
        if [ $(expr $j % $i) -eq 0 ]; 
        then
            f=0
            break
        fi
    done
    
    if [ $f -eq 1 ]
    then
        echo "$j"
    fi
done
