ping=$(cat test.log | grep ping | cut -d: -f2)
down=$(cat test.log | grep download | cut -d: -f2)
up=$(cat test.log | grep upload | cut -d: -f2)

echo "ping : "$ping
echo "down : "$down
echo "up : "$up

curl --request POST 'http://localhost:8080/nas-app/insertdata' --data "ping=$ping" --data "up=$up" --data "do=$down"
$ret=$?

echo $ret

