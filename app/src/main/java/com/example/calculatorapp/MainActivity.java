 package com.example.calculatorapp;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;

import org.w3c.dom.Text;

 public class MainActivity extends AppCompatActivity {

     public static final int SETTINGS_SELECTION = 1;

     //used to hold the current mode of the calculator
     private String calculatorMode = "length";

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        Button calculate = (Button) findViewById(R.id.calculateButton);
        Button clear = (Button) findViewById(R.id.clearButton);
        Button mode = (Button) findViewById(R.id.modeButton);
        Button settings = (Button) findViewById(R.id.settingsButton);

        EditText fromTextBox = (EditText) findViewById(R.id.fromTextBox);
        EditText toTextBox = (EditText) findViewById(R.id.toTextBox);

        TextView fromUnits = (TextView) findViewById(R.id.fromUnits);
        TextView toUnits = (TextView) findViewById(R.id.toUnits);


        //settings button
        settings.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent intent = new Intent(MainActivity.this, settingsActivity.class);
                startActivityForResult(intent,SETTINGS_SELECTION);
            }
        });

        //clear button
        clear.setOnClickListener(v -> {
            fromTextBox.setText(" ");
            toTextBox.setText(" ");});

        //mode button
        mode.setOnClickListener(v -> {
            if(calculatorMode.equals("length")){
                calculatorMode = "volume";
                fromUnits.setText("liters");
                toUnits.setText("gallons");

            }
            else {
                calculatorMode = "length";
                fromUnits.setText("meters");
                toUnits.setText("yards");
            }
        });


    }

    @Override
    protected void onActivityResult(int requestCode, int resultCode, Intent data){
        if(resultCode == SETTINGS_SELECTION){

            //set the from units label
            TextView fromUnits = (TextView) findViewById(R.id.fromUnits);
            fromUnits.setText(data.getStringExtra("unit"));

            //set the to units label
            TextView toUnits = (TextView) findViewById(R.id.toUnits);
            toUnits.setText(data.getStringExtra("unit"));
        }
    }
}
