package com.example.endrit.finalproject.activities;

import android.app.Activity;
import android.os.Bundle;
import android.text.Editable;
import android.text.TextWatcher;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;

import com.example.endrit.finalproject.R;

/**
 * Created by endrit on 1/7/2018.
 */

public class MathActivity extends Activity {
    EditText numberInput, secondNumberInput;
    TextView numberOutput, secondNumberOutput;
    Button btnResult;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_math);
        loadViews();
        eventListener();
    }

    private void eventListener() {
        numberInput.addTextChangedListener(new TextWatcher() {
            @Override
            public void beforeTextChanged(CharSequence charSequence, int i, int i1, int i2) {

            }

            @Override
            public void onTextChanged(CharSequence charSequence, int i, int i1, int i2) {
                numberOutput.setText("The number of your input is: "+ charSequence);
            }

            @Override
            public void afterTextChanged(Editable editable) {

            }
        });

        btnResult.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                secondNumberOutput.setText("The second number is: "+ secondNumberInput.getText());
            }
        });
    }

    private void loadViews() {
        numberInput = (EditText) findViewById(R.id.number_input);
        numberOutput = (TextView) findViewById(R.id.number_output);
        secondNumberInput = findViewById(R.id.second_number_input);
        secondNumberOutput = findViewById(R.id.second_number_output);
        btnResult = (Button) findViewById(R.id.btn_result);
    }

    @Override
    protected void onSaveInstanceState(Bundle outState) {
        super.onSaveInstanceState(outState);
        outState.putString("input_number", String.valueOf(secondNumberInput.getText()));
    }

    @Override
    protected void onRestoreInstanceState(Bundle savedInstanceState) {
        super.onRestoreInstanceState(savedInstanceState);
        String text = "The number you typed is: "+ savedInstanceState.getString("input_number");
        secondNumberOutput.setText(text);
    }
}
