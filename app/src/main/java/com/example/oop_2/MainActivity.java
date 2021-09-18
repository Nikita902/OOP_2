package com.example.oop_2;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.RadioButton;
import android.widget.RadioGroup;
import android.widget.Spinner;
import android.widget.TextView;

import java.util.HashMap;
import java.util.Map;

public class MainActivity extends AppCompatActivity {

     EditText kg;
     EditText hg;
     EditText year;
     TextView pole;
     Button result;
     Spinner spinner;

     Double weight;
     Double height;
     Double age;
     Calculator calculator;
     Sex sex = Sex.Male;
     Activ activ = Activ.Sitting;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        kg = findViewById(R.id.kg);
        hg = findViewById(R.id.hg);
        year = findViewById(R.id.year);
        pole = findViewById(R.id.pole);
        result = findViewById(R.id.result);
        spinner = findViewById(R.id.spinner);

        calculator = new Calculator();

        View.OnClickListener bnt = new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                weight = Double.parseDouble(String.valueOf(kg.getText().toString()));
                height = Double.parseDouble(String.valueOf(hg.getText().toString()));
                age = Double.parseDouble(String.valueOf(year.getText().toString()));
                activ = Activ.values()[spinner.getSelectedItemPosition()];

                Button result = (Button) findViewById(R.id.result);
                calculator.Height = height;
                calculator.Weight = weight;
                calculator.Age = age;
                pole.setText(String.valueOf(calculator.answer(sex, activ)));
            }
        };
        result.setOnClickListener(bnt);
    }

    public void SSex(View radioButton) {
        sex = Sex.valueOf((String) radioButton.getTag());
    }


}

enum Sex
{
    Male,
    Female,
}

enum Activ
{
    Sitting,
    Middle,
    Activity,
}




