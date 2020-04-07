package com.example.bmicalculator;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.view.View;
import android.widget.EditText;
import android.widget.TextView;

public class MainActivity extends AppCompatActivity {
    private EditText height;
    private EditText weight;
    private TextView result;
    private EditText glycemie;
    private TextView bilan;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        height = (EditText) findViewById(R.id.height);
        weight = (EditText) findViewById(R.id.weight);
        result = (TextView) findViewById(R.id.result);
        glycemie = (EditText) findViewById(R.id.glycemie);
       bilan = (TextView) findViewById(R.id.bilan);
    }
    public void calculateBMI(View v) {
        String heightStr = height.getText().toString();
        String weightStr = weight.getText().toString();
        String glycemieStr =glycemie.getText().toString();

        if (heightStr != null && !"".equals(heightStr) && weightStr != null  &&  !"".equals(weightStr) && glycemieStr != null && !"".equals(glycemieStr) ) {
            float heightValue = Float.parseFloat(heightStr) / 100;
            float weightValue = Float.parseFloat(weightStr);
            float gly = Float.parseFloat(glycemieStr);

            float bmi = weightValue / (heightValue * heightValue);


            displayBMI(bmi);
            displayglycemie(gly) ;
        }

    }
    private void displayBMI(float bmi) {
        String bmiLabel = "";

        if (Float.compare(bmi, 15f) <= 0) {
            bmiLabel = getString(R.string.very_severely_underweight);
        } else if (Float.compare(bmi, 15f) > 0  &&  Float.compare(bmi, 16f) <= 0) {
            bmiLabel = getString(R.string.severely_underweight);
        } else if (Float.compare(bmi, 16f) > 0  &&  Float.compare(bmi, 18.5f) <= 0) {
            bmiLabel = getString(R.string.underweight);
        } else if (Float.compare(bmi, 18.5f) > 0  &&  Float.compare(bmi, 25f) <= 0) {
            bmiLabel = getString(R.string.normal);
        } else if (Float.compare(bmi, 25f) > 0  &&  Float.compare(bmi, 30f) <= 0) {
            bmiLabel = getString(R.string.overweight);
        } else if (Float.compare(bmi, 30f) > 0  &&  Float.compare(bmi, 35f) <= 0) {
            bmiLabel = getString(R.string.obese_class_i);
        } else if (Float.compare(bmi, 35f) > 0  &&  Float.compare(bmi, 40f) <= 0) {
            bmiLabel = getString(R.string.obese_class_ii);
        } else {
            bmiLabel = getString(R.string.obese_class_iii);
        }
        bmiLabel = bmi + "\n\n" + bmiLabel;
        result.setText(bmiLabel);
    }

    private void  displayglycemie(float gly){
        String glyLabel = "";
        if (Float.compare(gly, 0.7f) < 0) {
            glyLabel = getString(R.string.Hypoglycemie);
        } else if (Float.compare(gly, 0.7f) >= 0  &&  Float.compare(gly, 1f) <= 0) {
            glyLabel = getString(R.string.glycemie_normale);
        }
        else if (Float.compare(gly, 1f) > 0  &&  Float.compare(gly, 1.26f) <= 0) {
            glyLabel = getString(R.string.hyperglycemie_moderer);
        }
        else {
            glyLabel = getString(R.string.diabete);
        }
        bilan.setText(glyLabel);
}}
