package com.example.conversion;

import android.annotation.SuppressLint;
import android.os.Bundle;
import android.view.View;
import android.widget.EditText;
import android.widget.RadioButton;
import android.widget.TextView;
import androidx.appcompat.app.AppCompatActivity;

public class MainActivity extends AppCompatActivity {

    EditText editFloat;
    RadioButton radioEuroToDinar, radioDinarToEuro;
    TextView txtResult;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        // Bind the UI elements
        editFloat = findViewById(R.id.edit_float);
        radioEuroToDinar = findViewById(R.id.radio_euro_to_dinar);
        radioDinarToEuro = findViewById(R.id.radio_dinar_to_euro);
        txtResult = findViewById(R.id.txt_result);
    }

    @SuppressLint({"SetTextI18n", "DefaultLocale"})
    public void auClic(View view) {
        String input = editFloat.getText().toString();

        if (input.isEmpty()) {
            txtResult.setText("Veuillez entrer une valeur");
            return;
        }

        try {
            double value = Double.parseDouble(input);
            double result;

            if (radioEuroToDinar.isChecked()) {
                result = value * 230; // Example: 1 Euro = 230 DZD
                txtResult.setText(value + " € = " + result + " DA");
            } else if (radioDinarToEuro.isChecked()) {
                result = value / 230;
                txtResult.setText(value + " DA = " + String.format("%.2f", result) + " €");
            } else {
                txtResult.setText("Veuillez choisir une conversion");
            }

        } catch (NumberFormatException e) {
            txtResult.setText("Valeur invalide");
        }
    }
}
