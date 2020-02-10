package com.pentakotavishu.lab02texts;

import androidx.appcompat.app.AppCompatActivity;

import android.content.res.Resources;
import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;

public class MainActivity extends AppCompatActivity {
    Button submitButton;
    TextView displayText;
    TextView displayText2;
    EditText responseText;
    int counter = 0;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        submitButton=findViewById(R.id.clickButton);
        displayText=findViewById(R.id.textBox2);
        displayText2=findViewById(R.id.textBox3);
        responseText=findViewById(R.id.responseEditText);

        responseText.setOnFocusChangeListener(new View.OnFocusChangeListener() {
            @Override
            public void onFocusChange(View v, boolean hasFocus) {
                if(!hasFocus) {
                        displayText2.setText(""+responseText.getText());

                }
            }
        });

        submitButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Resources res = getResources();
                String[] secrets = res.getStringArray(R.array.secret_array);

                displayText2.setText("Hello "+responseText.getText() + "!");

                if(counter>3)
                {
                    counter = 0;
                }
                displayText.setText(secrets[counter]);
                Log.i("testButton", "Secret Message: "+ secrets[counter]);
                counter = counter + 1;


            }
        });
    }
}