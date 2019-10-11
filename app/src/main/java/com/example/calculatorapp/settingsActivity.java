package com.example.calculatorapp;

import android.content.Intent;
import android.os.Bundle;

import com.google.android.material.floatingactionbutton.FloatingActionButton;

import androidx.appcompat.app.AppCompatActivity;

import android.view.View;
import android.widget.AdapterView;
import android.widget.ArrayAdapter;
import android.widget.Spinner;

public class settingsActivity extends AppCompatActivity {

    private String toSelection = " ";
    private String fromSelection = " ";

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_settings);
        //Toolbar toolbar = findViewById(R.id.toolbar);
        //setSupportActionBar(toolbar);

        FloatingActionButton fab = findViewById(R.id.fab);
        Spinner fromUnitsSpinner = (Spinner) findViewById(R.id.fromUnitsSpinner);
        Spinner toUnitsSpinner = (Spinner) findViewById(R.id.toUnitsSpinner);

        //fab button
        fab.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                //Snackbar.make(view, "Replace with your own action", Snackbar.LENGTH_LONG)
                        //.setAction("Action", null).show();
                Intent intent = new Intent();
                //send the user selected to and from units
                intent.putExtra("fromUnit", fromSelection);
                intent.putExtra("toUnit", toSelection);

                setResult(MainActivity.SETTINGS_SELECTION,intent);
                finish();
            }
        });

        //set up the proper units for the spinners
        ArrayAdapter<CharSequence> lengthUnits = ArrayAdapter.createFromResource(this,
                R.array.lengthUnits, android.R.layout.simple_spinner_item);

        ArrayAdapter<CharSequence> volumeUnits = ArrayAdapter.createFromResource(this,
                R.array.volumeUnits, android.R.layout.simple_spinner_item);

        //populate spinners with the units based on the current mode
        if(MainActivity.calculatorMode == "length"){
            lengthUnits.setDropDownViewResource(android.R.layout.simple_spinner_dropdown_item);
            fromUnitsSpinner.setAdapter(lengthUnits);
            toUnitsSpinner.setAdapter(lengthUnits);
        }
        else {
            volumeUnits.setDropDownViewResource(android.R.layout.simple_spinner_dropdown_item);
            fromUnitsSpinner.setAdapter(volumeUnits);
            toUnitsSpinner.setAdapter(volumeUnits);

        }


        //from units spinner
        fromUnitsSpinner.setOnItemSelectedListener(new AdapterView.OnItemSelectedListener() {
            @Override
            public void onItemSelected(AdapterView<?> adapterView, View view, int i, long l) {
                fromSelection = (String) adapterView.getItemAtPosition(i);
            }

            @Override
            public void onNothingSelected(AdapterView<?> parent) {

            }
        });

        //to units spinner
        toUnitsSpinner.setOnItemSelectedListener(new AdapterView.OnItemSelectedListener() {
            @Override
            public void onItemSelected(AdapterView<?> adapterView, View view, int i, long l) {
                //if toLabel/fromLabel isVisible()
                toSelection = (String) adapterView.getItemAtPosition(i);
            }

            @Override
            public void onNothingSelected(AdapterView<?> parent) {

            }
        });
    }

}
