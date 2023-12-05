package com.example.myloginapp.activities;

import androidx.appcompat.app.AppCompatActivity;
import androidx.appcompat.widget.Toolbar;
import android.os.Bundle;
import android.view.View;
import android.widget.AdapterView;
import android.widget.ArrayAdapter;
import android.widget.Spinner;
import android.widget.TextView;
import com.example.myloginapp.R;
import android.app.AlertDialog;
import android.app.ProgressDialog;
import android.os.Bundle;
import android.os.Handler;
import android.view.View;
import android.widget.Button;
import android.widget.Toast;
import androidx.appcompat.app.AppCompatActivity;
import androidx.appcompat.widget.Toolbar;


public class PaymentActivity extends AppCompatActivity {

    Toolbar toolbar;
    TextView subTotal, discount, shipping, total;
    Spinner couponSpinner;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_payment);


        // Toolbar
        toolbar = findViewById(R.id.payment_toolbar);
        setSupportActionBar(toolbar);
        getSupportActionBar().setDisplayHomeAsUpEnabled(true);

        toolbar.setNavigationOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                finish();
            }
        });

        // Obter o valor do subtotal do Intent
        double amount = getIntent().getDoubleExtra("amount", 0.0);

        // Referências às TextViews
        subTotal = findViewById(R.id.sub_total);
        discount = findViewById(R.id.textView17);
        shipping = findViewById(R.id.textView18);
        total = findViewById(R.id.total_amt);

        // Spinner para escolher o tipo de cupom
        couponSpinner = findViewById(R.id.coupon_spinner);

        // Popula o Spinner com tipos de cupom
        ArrayAdapter<CharSequence> adapter = ArrayAdapter.createFromResource(
                this, R.array.coupon_types, android.R.layout.simple_spinner_item);
        adapter.setDropDownViewResource(android.R.layout.simple_spinner_dropdown_item);
        couponSpinner.setAdapter(adapter);

        // Listener para calcular desconto quando um item do Spinner é selecionado
        couponSpinner.setOnItemSelectedListener(new AdapterView.OnItemSelectedListener() {
            @Override
            public void onItemSelected(AdapterView<?> parentView, View selectedItemView, int position, long id) {
                // Obtém o tipo de cupom selecionado
                String couponType = parentView.getItemAtPosition(position).toString();

                // Calcula o desconto com base no tipo de cupom
                double discountAmount = calculateDiscount(amount, couponType);

                // Atualiza as TextViews
                updateTextViews(amount, discountAmount);
            }

            @Override
            public void onNothingSelected(AdapterView<?> parentView) {
                // Nada a fazer aqui
            }
        });

        // Exibe o valor do subtotal
        subTotal.setText(String.format("%.2f$", amount));
    }

    private double calculateDiscount(double subtotal, String couponType) {
        // Implementa a lógica de cálculo de desconto com base no tipo de cupom
        switch (couponType) {
            case "Cupom1":
                return subtotal * 0.05; // 5% de desconto
            case "Cupom2":
                return subtotal * 0.1;  // 10% de desconto
            case "Cupom3":
                return subtotal * 0.15; // 15% de desconto
            case "Cupom4":
                return subtotal * 0.2;  // 20% de desconto
            case "Cupom5":
                return subtotal * 0.25; // 25% de desconto
            default:
                return 0.0; // Sem desconto
        }
    }

    private void updateTextViews(double subtotal, double discountAmount) {
        // Exibe os valores nas TextViews
        discount.setText(String.format("%.2f$", discountAmount));
        // Adicione lógica para custos de envio ou outros cálculos se necessário
        // ...
        double totalAmount = subtotal - discountAmount; // Subtrai o desconto do subtotal
        total.setText(String.format("%.2f$", totalAmount));
    }
}


