package com.example.myloginapp.activities;

import android.os.Bundle;
import android.view.View;
import android.widget.AdapterView;
import android.widget.ArrayAdapter;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Spinner;
import android.widget.TextView;

import androidx.appcompat.app.AppCompatActivity;

import com.example.myloginapp.R;

import java.util.HashMap;
import java.util.Map;

public class DescontoActivity extends AppCompatActivity {

    private EditText editTextGrams;
    private Spinner spinnerMineralType;
    private Button buttonCalculateDiscount;
    private TextView textViewDiscountResult;

    private Map<String, Double> mineralDiscountMap;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_desconto);

        editTextGrams = findViewById(R.id.editTextGrams);
        spinnerMineralType = findViewById(R.id.spinnerMineralType);
        buttonCalculateDiscount = findViewById(R.id.buttonCalculateDiscount);
        textViewDiscountResult = findViewById(R.id.textViewDiscountResult);

        // Populate the spinner with mineral types
        ArrayAdapter<CharSequence> adapter = ArrayAdapter.createFromResource(
                this, R.array.mineral_types, android.R.layout.simple_spinner_item);
        adapter.setDropDownViewResource(android.R.layout.simple_spinner_dropdown_item);
        spinnerMineralType.setAdapter(adapter);

        // Initialize the mineral discount map
        initializeMineralDiscountMap();

        // Set a listener for the Calculate Discount button
        buttonCalculateDiscount.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                calculateDiscount();
            }
        });
    }

    private void initializeMineralDiscountMap() {
        mineralDiscountMap = new HashMap<>();
        mineralDiscountMap.put("SILICIO", 0.2);
        mineralDiscountMap.put("ALUMINIO", 5.0);
        mineralDiscountMap.put("COBRE", 0.3);
        mineralDiscountMap.put("OURO", 1.0);
        mineralDiscountMap.put("PRATA", 0.2);
    }

    private void calculateDiscount() {
        // Get user input
        String gramsString = editTextGrams.getText().toString();
        String mineralType = spinnerMineralType.getSelectedItem().toString();

        if (!gramsString.isEmpty()) {
            double grams = Double.parseDouble(gramsString);

            if (mineralDiscountMap.containsKey(mineralType)) {
                double discountRate = mineralDiscountMap.get(mineralType);
                double discount = grams / discountRate;

                // Display the discount result
                String resultMessage = String.format("Desconto: %.2f%%", discount);
                textViewDiscountResult.setText(resultMessage);

                // Generate and display a discount coupon
                String couponMessage = String.format("Cupom de desconto: %s%.2f",
                        mineralType.substring(0, 3), discount);
                // You may want to save this coupon for later use or display it to the user.
                // For simplicity, we are just displaying it in the TextView.
                textViewDiscountResult.append("\n" + couponMessage);
            } else {
                textViewDiscountResult.setText("Tipo de mineral inválido.");
            }
        } else {
            textViewDiscountResult.setText("Digite a quantidade em gramas.");
        }
    }
}