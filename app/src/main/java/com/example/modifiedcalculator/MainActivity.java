package com.example.modifiedcalculator;

import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;
import android.widget.Toast;
import androidx.appcompat.app.AppCompatActivity;
import java.util.Random;

public class MainActivity extends AppCompatActivity implements View.OnClickListener {

    private TextView tvNum1, tvNum2, tvOperation, tvAnswer;
    private EditText etResult;
    private int num1, num2, correctAnswer;
    private String operation;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        tvNum1 = findViewById(R.id.tvNum1);
        tvNum2 = findViewById(R.id.tvNum2);
        tvOperation = findViewById(R.id.tvOperation);
        etResult = findViewById(R.id.etResult);
        tvAnswer = findViewById(R.id.tvAnswer);
        Button btnPlus = findViewById(R.id.btnPlus);
        Button btnMinus = findViewById(R.id.btnMinus);
        Button btnMultiply = findViewById(R.id.btnMultiply);
        Button btnDivide = findViewById(R.id.btnDivide);
        btnPlus.setOnClickListener(this);
        btnMinus.setOnClickListener(this);
        btnMultiply.setOnClickListener(this);
        btnDivide.setOnClickListener(this);
        generateRandomValues();
    }
    @Override
    public void onClick(View view) {
        if (etResult.getText().toString().isEmpty()) {
            etResult.setError("Please enter a result");
            return;
        }
        int userResult = Integer.parseInt(etResult.getText().toString());
        if (userResult == correctAnswer) {
            tvAnswer.setText("True");
        } else {
            tvAnswer.setText("False");
        }
        generateRandomValues();
    }
    private void generateRandomValues() {
        Random random = new Random();
        num1 = random.nextInt(10) + 1;
        num2 = random.nextInt(10) + 1;
        int operationIndex = random.nextInt(4);
        switch (operationIndex) {
            case 0:
                operation = "+";
                correctAnswer = num1 + num2;
                break;
            case 1:
                operation = "-";
                correctAnswer = num1 - num2;
                break;
            case 2:
                operation = "*";
                correctAnswer = num1 * num2;
                break;
            case 3:
                operation = "/";
                correctAnswer = num1 / num2;
                break;
        }
        tvNum1.setText(String.valueOf(num1));
        tvNum2.setText(String.valueOf(num2));
        tvOperation.setText(operation);
    }
}