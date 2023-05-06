echo ""

echo -n "Enter some text: "
read text

echo "$text" | tr '[:lower:]' '[:upper:]'
