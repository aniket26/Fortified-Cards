<?php
	$imei = $_GET["mobile_id"];
	$credit_card_number = $_GET["cc_id"];
	[COM_DOT_NET] extension=php_com_dotnet.dll
	$variab = $_REQUEST['VARIABLE'];
	$conn = new COM("ADODB.Connection") or die("Oops!");
	$conn->Open("DRIVER={Microsoft Access Driver (*.mdb)};DBQ=http://aniketvpatil.com/CreditCard.mdb");
	$query = mysql_query("SELECT IMEI, Balance, card_no FROM Table1 WHERE card_no='".$credit_card_number."'");
	if (!$query) {
		echo 'Could not run the query' .mysql_error();
	}
	$row = mysql_fetch_row($query);
	/*echo $row[0]; //imei
	echo $row[1]; //balance
	echo $row[2]; //credit card number
	*/
	if ($imei==$row[0] AND $credit_card_number==$row[2]){
		echo "Authorized Phone";
	}
	else{
			echo "Not Authorized Phone";
	}
?>  