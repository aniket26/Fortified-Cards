package com.example.sayli.fortifiedcards;

import android.os.Bundle;
import android.support.v7.app.ActionBarActivity;
import android.support.v7.app.AppCompatActivity;
import android.view.Menu;
import android.view.MenuItem;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;

import java.util.concurrent.ExecutionException;


public class EnterAmount extends AppCompatActivity {
    private Button btn_click;
    private EditText txt_amount;
    String c_cc_no=CScan.getCardNo();
    String v_cc_no=VScan.getShopkeeper_card_no();



    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_enter_amount);
        btn_click=(Button)findViewById(R.id.btn_Submit);

    }

    public void onCallButton(View v){
        if(v==btn_click){
            String[]i= CScan.check_imei_statically();
            double vendor_balance=getVPHPConnection(VScan.getShopkeeper_card_no());
            double bal_vendor= vendor_balance;
            double user_balance=Double.parseDouble(i[1]);
            double bal_user= user_balance;
            txt_amount=(EditText)findViewById(R.id.edit_text_due_amount);
            String txt_amount_string=txt_amount.getText().toString();
            double due_amt=Double.parseDouble(txt_amount_string);
            bal_vendor=bal_vendor+due_amt;
            bal_user=bal_user-due_amt;
            Toast.makeText(this, "Vendor Balance: "+bal_vendor + " & " + " Customer Balance: "+bal_user, Toast.LENGTH_LONG).show();
            Toast.makeText(this, "Customer Card No"+c_cc_no+"Vendor Card No"+v_cc_no,Toast.LENGTH_LONG).show();
            getAPHPConnection(c_cc_no, v_cc_no, String.valueOf(bal_user), String.valueOf(bal_vendor));
        }
    }
    private void getAPHPConnection(String w, String x, String y, String z) {
        try {
            String t=new APHPConnection().execute(w, x, y, z).get().toString();
            Toast.makeText(this,t,Toast.LENGTH_LONG).show();
        } catch (InterruptedException e) {
            e.printStackTrace();
        } catch (ExecutionException e) {
            e.printStackTrace();
        }
    }

    private Double getVPHPConnection(String scan) {
        Double t= null;
        try {
            t = Double.valueOf(new VPHPConnection().execute(scan).get().toString());
        } catch (InterruptedException | ExecutionException e) {
            e.printStackTrace();
        }
        return t;
    }
    /*@Override
    public boolean onCreateOptionsMenu(Menu menu) {
        // Inflate the menu; this adds items to the action bar if it is present.
        getMenuInflater().inflate(R.menu.menu_enter__amount, menu);
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
*/
}