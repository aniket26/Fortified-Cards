package com.example.sayli.fortifiedcards;

import android.app.ProgressDialog;
import android.content.Intent;
import android.net.Uri;
import android.support.v7.app.ActionBarActivity;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.Menu;
import android.view.MenuItem;
import android.view.View;
import android.widget.Button;

public class MainActivity extends ActionBarActivity {

    Button btnGetStarted;
    Button btnHelp;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);

        final ProgressDialog progDailog = ProgressDialog.show(this,
                "Loading",
                "Please wait...", true);
        new Thread() {
            public void run() {
                try {
                    // sleep the thread, whatever time you want.
                    sleep(2000);
                } catch (Exception e) {
                }
                progDailog.dismiss();
            }
        }.start();

        setContentView(R.layout.activity_main);

        btnGetStarted = (Button)findViewById(R.id.btnGetStarted);
        btnHelp = (Button)findViewById(R.id.btnHelp);

    }

    public void onGetStarted(View v)
    {
        if (v == btnGetStarted)
        {
            Boolean isFirstRun = getSharedPreferences("PREFERENCE", MODE_PRIVATE).getBoolean("isfirstrun", true);

            if (isFirstRun)
            {
                //show tutorial
                startActivity(new Intent(this, Intro1.class));

                //After a person has seen the tutorial at first launch of the app, he/she shouldn't see it again
                getSharedPreferences("PREFERENCE", MODE_PRIVATE).edit().putBoolean("isfirstrun", false).commit();
            }
            else
            {
                startActivity(new Intent(this, CScan.class));
            }
        }
    }

    public void onHelp(View v)
    {
        if (v == btnHelp)
        {
            startActivity(new Intent(this, Intro1.class));
        }
    }

    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        getMenuInflater().inflate(R.menu.items, menu);
        return true;
    }
    @Override
    public boolean onOptionsItemSelected(MenuItem item) {
        switch (item.getItemId()) {
            case R.id.Feedback:
                startActivity(new Intent(this, Feedback.class));
                return true;
            case R.id.uninstall:
                Uri packageUri = Uri.parse("package:com.example.sayli.fortifiedcards");
                Intent uninstallIntent = new Intent(Intent.ACTION_DELETE, packageUri);
                startActivity(uninstallIntent);
                return true;
            default:
                return super.onOptionsItemSelected(item);
        }
    }
}