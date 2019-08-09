package com.example.myapplication;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.text.TextUtils;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;

import static com.example.myapplication.R.id.t4;

public class MainActivity extends AppCompatActivity {
    private Button button;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        final EditText e1 = (EditText) findViewById(R.id.editText);
        final EditText e2 = (EditText) findViewById(R.id.editText2);
        final TextView tv5 = (TextView) findViewById(R.id.tv5);
        button = (Button) findViewById(R.id.button);
        button.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                String str1 = e1.getText().toString();
                String str2 = e2.getText().toString();

                if (TextUtils.isEmpty(str1)) {
                    e1.setError("Please enter your height");
                    e1.requestFocus();
                    return;
                }

                if (TextUtils.isEmpty(str2)) {
                    e2.setError("Please enter your weight");
                    e2.requestFocus();
                    return;
                }
                float weight = Float.parseFloat(str1);
                float height = Float.parseFloat(str2) / 100;
                float bmiValue = calculateBMI(weight, height);
                String bmiInterpretation = interpretBMI(bmiValue);
                tv5.setText(String.valueOf(bmiValue + "-" + bmiInterpretation));


                openActivity2();
            }
        });


    }

    public void openActivity2() {
        Intent intent = new Intent(this, Activity2.class);
        startActivity(intent);


    }


    private float calculateBMI (float weight, float height) {
        return (float) (weight / (height * height));
    }
    private String interpretBMI(float bmiValue) {

        if (bmiValue < 16) {
            return "Severely underweight";
        } else if (bmiValue < 18.5) {

            return "Underweight";
        } else if (bmiValue < 25) {

            return "Normal";
        } else if (bmiValue < 30) {

            return "Overweight";
        } else {
            return "Obese";
        }
    }
}
