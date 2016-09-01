<?php
$variab = $_REQUEST['VARIABLE'];
$conn = new COM("ADODB.Connection") or die("Oops!");
$conn->Open("DRIVER={Microsoft Access Driver (*.mdb)};DBQ=A:\AndroidProjects(Studio)\FC\db\CreditCard.mdb");
$query = "SELECT * FROM table WHERE (Variable = '".$variab."')";
$data = $conn->Execute($query);

while (!$data->EOF)
{
    echo $data ->Fields[0]->value . ":";
    //echo $data ->Fields[1]->value . " \n";

    $data ->MoveNext();
}
?>  