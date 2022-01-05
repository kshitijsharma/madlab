package com.example.currencyconvertor;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.RadioButton;

public class MainActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        RadioButton inr = findViewById(R.id.inr);
        RadioButton euro = findViewById(R.id.euro);
        RadioButton usd = findViewById(R.id.usd);

        RadioButton inro = findViewById(R.id.inro);
        RadioButton euroo = findViewById(R.id.euroo);
        RadioButton usdo = findViewById(R.id.usdo);

        EditText inp = findViewById(R.id.icu);
        EditText out = findViewById(R.id.ocu);

         Button cur = findViewById(R.id.convert);
         cur.setOnClickListener(new View.OnClickListener() {
             @Override
             public void onClick(View v) {
                 if(inr.isChecked() && inro.isChecked()){
                     float number = Float.valueOf(inp.getText().toString());
                     out.setText(String.valueOf(number));
                 }

                 if(inr.isChecked() && euroo.isChecked()){
                     float number = Float.valueOf(inp.getText().toString());
                     number =number / new Float(110.5);
                     out.setText(String.valueOf(number));
                 }

                 if(inr.isChecked() && usdo.isChecked()){
                     float number = Float.valueOf(inp.getText().toString());
                     number =number / new Float(70.5);
                     out.setText(String.valueOf(number));
                 }

                 if(euro.isChecked() && inro.isChecked()){
                     float number = Float.valueOf(inp.getText().toString());
                     number =number * new Float(110.5);
                     out.setText(String.valueOf(number));
                 }

                 if(euro.isChecked() && euroo.isChecked()){
                     float number = Float.valueOf(inp.getText().toString());
                     out.setText(String.valueOf(number));
                 }

                 if(euro.isChecked() && usdo.isChecked()){
                     float number = Float.valueOf(inp.getText().toString());
                     number =number * new Float(100.5) / new Float(70.5);
                     out.setText(String.valueOf(number));
                 }

                 if(usd.isChecked() && inro.isChecked()){
                     float number = Float.valueOf(inp.getText().toString());
                     number =number * new Float(70.5);
                     out.setText(String.valueOf(number));
                 }

                 if(usd.isChecked() && euroo.isChecked()){
                     float number = Float.valueOf(inp.getText().toString());
                     number =number * new Float(70.5) / new Float(110.5);
                     out.setText(String.valueOf(number));
                 }

                 if(usd.isChecked() && usdo.isChecked()){
                     float number = Float.valueOf(inp.getText().toString());
                     out.setText(String.valueOf(number));
                 }

             }
         });
    }
}