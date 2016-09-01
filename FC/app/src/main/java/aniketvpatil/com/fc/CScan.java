package aniketvpatil.com.fc;

import android.app.AlertDialog;
import android.content.Context;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.telephony.TelephonyManager;
import android.util.Log;
import android.view.Menu;
import android.view.MenuItem;
import android.widget.Toast;

import com.google.zxing.Result;

import me.dm7.barcodescanner.zxing.ZXingScannerView;


public class CScan extends AppCompatActivity implements ZXingScannerView.ResultHandler{
    private ZXingScannerView mScanner;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_cscan);
        mScanner = new ZXingScannerView(this);   // Programmatically initialize the scanner view
        setContentView(mScanner);
        mScanner.setResultHandler(this); // Register ourselves as a handler for scan results.
        mScanner.startCamera();// Start camera
    }

    @Override
    public void onPause() {
        super.onPause();
        mScanner.stopCamera();   // Stop camera on pause
    }

    @Override
    public void handleResult(Result rawResult) {
        String scanString=getScan(rawResult);// Toast.makeText(this, "The scan result is stored in the variable scanresult  having value "+scanresult, Toast.LENGTH_SHORT ).show();
        String imei=getCellId();
        Toast.makeText(this, "IMEI No. is " + imei, Toast.LENGTH_LONG).show();
        getPHPConnection(scanString,imei);
    }
    private String getScan(Result scanRaw){
        String scanresult;
        Log.e("handler", scanRaw.getText()); // Prints scan results
        Log.e("handler", scanRaw.getBarcodeFormat().toString()); // Prints the scan format (qrcode)

        // show the scanner result into dialog box.
        AlertDialog.Builder builder = new AlertDialog.Builder(this);
        builder.setTitle("Scan Result");
        builder.setMessage(scanRaw.getText());
        AlertDialog alert1 = builder.create();
        alert1.show();
        mScanner.resumeCameraPreview(this);
        scanresult=scanRaw.getText().toString();
        return scanresult;
    }

    private String getCellId(){
        TelephonyManager telephonyManager = (TelephonyManager)getSystemService(Context.TELEPHONY_SERVICE);
        String cell_id=telephonyManager.getDeviceId();
        return cell_id;
    }

    private void getPHPConnection(String scan,String device_id) {
        new PHPConnection().execute(scan, device_id);



    }
    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        // Inflate the menu; this adds items to the action bar if it is present.
        getMenuInflater().inflate(R.menu.menu_cscan, menu);
        return true;
    }
    @Override
    public boolean onOptionsItemSelected(MenuItem item) {
        // Handle action bar item clicks here. The action bar will
        // automatically handle clicks on the Home/Up button, so long
        // as you specify a parent activity in AndroidManifest.xml.
        int id = item.getItemId();
        //noinspection SimplifiableIfStatement
        if (id == R.id.action_settings) {
            return true;
        }
        return super.onOptionsItemSelected(item);
    }

}

