package com.example.sayli.fortifiedcards;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;

public class Feedback extends AppCompatActivity {

    Button b1;
    EditText t1, t2;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_feedback);
        b1 = (Button) findViewById(R.id.button2);
        t1 = (EditText) findViewById(R.id.editText2);
        t2 = (EditText) findViewById(R.id.editText);
            b1.setOnClickListener(new View.OnClickListener() {
                    @Override
                    public void onClick(View view) {
                        Toast.makeText(Feedback.this, "Thank you for your feedback", Toast.LENGTH_SHORT).show();
                    }
            });
        }
    }


