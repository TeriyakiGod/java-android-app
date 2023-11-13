package com.kacper.calculator;

import android.os.Bundle;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;

import androidx.appcompat.app.AppCompatActivity;

public class CalculatorView extends AppCompatActivity {

    EditText inputFieldA, inputFieldB;
    TextView resultField;
    Button addButton, subtractButton, multiplyButton, divideButton;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        Menu menu = new Menu(this, findViewById(R.id.drawer_layout), findViewById(R.id.toolbar));

        inputFieldA = findViewById(R.id.inputFieldA);
        inputFieldB = findViewById(R.id.inputFieldB);
        resultField = findViewById(R.id.resultField);
        addButton = findViewById(R.id.buttonAdd);
        subtractButton = findViewById(R.id.buttonSub);
        multiplyButton = findViewById(R.id.buttonMul);
        divideButton = findViewById(R.id.buttonDiv);

        addButton.setOnClickListener(v -> add());
        subtractButton.setOnClickListener(v -> subtract());
        multiplyButton.setOnClickListener(v -> multiply());
        divideButton.setOnClickListener(v -> divide());
    }

    public void add() {
        double a = Double.parseDouble(inputFieldA.getText().toString());
        double b = Double.parseDouble(inputFieldB.getText().toString());
        double result = a + b;
        resultField.setText(Double.toString(result));
    }

    public void subtract() {
        double a = Double.parseDouble(inputFieldA.getText().toString());
        double b = Double.parseDouble(inputFieldB.getText().toString());
        double result = a - b;
        resultField.setText(Double.toString(result));
    }

    public void multiply() {
        double a = Double.parseDouble(inputFieldA.getText().toString());
        double b = Double.parseDouble(inputFieldB.getText().toString());
        double result = a * b;
        resultField.setText(Double.toString(result));
    }

    public void divide() {
        double a = Double.parseDouble(inputFieldA.getText().toString());
        double b = Double.parseDouble(inputFieldB.getText().toString());
        if (b == 0) {
            resultField.setText(R.string.error_zero_division);
            return;
        }
        double result = a / b;
        resultField.setText(Double.toString(result));
    }


}