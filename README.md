# Fortified-Cards

Team-mates:
Aniket Patil
Sayli Pradhan

Description:

Fortified Cards is our Final Masters Project under Dr. Birgit Penzenstadler. It is an Android Application to perform secure credit/debit card transactions. We have envisioned the existence of encrypted QR codes on credit/debit cards which will have its card number associated with it. In order to pay at a grocery store/gas station, the customer has to scan his/her credit/debit card with our app. Then scan the vendor's QR code which is associated with his/her bank account. Now, the vendor will enter the due amount on his/her cellphone. This due amount will pop up in customer's app and upon confirmation, the transaction is done. 

Only your cellphone will be able to scan the QR code of your card by using the concept of unique IMEI numbers of the cellphone. So, even if you lose one of your cellphone or credit/debit card, no worries! We have got you covered! :)

Implementation:

Generating QR Codes - http://www.qrstuff.com/ 

QR Code Scanner - ZXing Library.Downloaded from https://github.com/zxing/zxing

Connecting online backend database - Used php for establishing connection between Android app and MYSQL, phpMyAdmin.

Things stored in DB - It is basically a dummy bank database containing customer's card number, name, IMEI number, balance, etc.

Communication between 2 mobile devices - Used Socket Programming using IP addresses. Also, used the concept of TCP/IP i.e. the synchronous communication betweem customer and vendor's cellphone. The vendor has to enter the due amount before the customer scans the vendor's QR code so that a proper connection is established.


