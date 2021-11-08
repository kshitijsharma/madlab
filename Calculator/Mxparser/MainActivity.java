package com.example.ex2_calculator;

import androidx.appcompat.app.AppCompatActivity;
import androidx.appcompat.app.AppCompatDelegate;
import org.mariuszgromada.math.mxparser.*;


import android.os.Bundle;
import android.text.TextUtils;
import android.view.View;
import android.widget.Button;
import android.widget.TextView;

public class MainActivity extends AppCompatActivity {
    int count=0;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        AppCompatDelegate.setDefaultNightMode(AppCompatDelegate.MODE_NIGHT_NO);
        TextView result= findViewById(R.id.result);
        TextView temp=findViewById(R.id.temp);
        result.setEnabled(false);
        temp.setEnabled(false);

        Button ac= findViewById(R.id.ac);
        ac.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                result.setText("");
                temp.setText("");
            }
        });

        Button clr= findViewById(R.id.clr);
        clr.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                if(!TextUtils.isEmpty(result.getText())) {
                    String txt = result.getText().toString();
                    txt = txt.substring(0, txt.length() - 1);
                    result.setText(txt);
                }
            }
        });

        Button power= findViewById(R.id.power);
        power.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                String txt=result.getText().toString();
                txt+="^";
                result.setText(txt);
            }
        });

        Button div= findViewById(R.id.div);
        div.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                String txt=result.getText().toString();
                txt+="/";
                result.setText(txt);
            }
        });

        Button seven= findViewById(R.id.seven);
        seven.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                String txt=result.getText().toString();
                txt+="7";
                result.setText(txt);
            }
        });

        Button eight= findViewById(R.id.eight);
        eight.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                String txt=result.getText().toString();
                txt+="8";
                result.setText(txt);
            }
        });

        Button nine= findViewById(R.id.nine);
        nine.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                String txt=result.getText().toString();
                txt+="9";
                result.setText(txt);
            }
        });

        Button mul= findViewById(R.id.mul);
        mul.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                String txt=result.getText().toString();
                txt+="*";
                result.setText(txt);
            }
        });

        Button four= findViewById(R.id.four);
        four.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                String txt=result.getText().toString();
                txt+="4";
                result.setText(txt);
            }
        });

        Button five= findViewById(R.id.five);
        five.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                String txt=result.getText().toString();
                txt+="5";
                result.setText(txt);
            }
        });

        Button six= findViewById(R.id.six);
        six.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                String txt=result.getText().toString();
                txt+="6";
                result.setText(txt);
            }
        });

        Button sub= findViewById(R.id.sub);
        sub.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                String txt=result.getText().toString();
                txt+="-";
                result.setText(txt);
            }
        });

        Button one= findViewById(R.id.one);
        one.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                String txt=result.getText().toString();
                txt+="1";
                result.setText(txt);
            }
        });

        Button two= findViewById(R.id.two);
        two.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                String txt=result.getText().toString();
                txt+="2";
                result.setText(txt);
            }
        });

        Button three= findViewById(R.id.three);
        three.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                String txt=result.getText().toString();
                txt+="3";
                result.setText(txt);
            }
        });

        Button add= findViewById(R.id.add);
        add.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                String txt=result.getText().toString();
                txt+="+";
                result.setText(txt);
            }
        });

        Button percent= findViewById(R.id.percent);
        percent.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                String txt=result.getText().toString();
                txt+="%";
                result.setText(txt);
            }
        });

        Button zero= findViewById(R.id.zero);
        zero.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                String txt=result.getText().toString();
                txt+="0";
                result.setText(txt);
            }
        });

        Button decimal= findViewById(R.id.decimal);
        decimal.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                String txt=result.getText().toString();
                txt+=".";
                result.setText(txt);
            }
        });

        Button equal= findViewById(R.id.equal);
        equal.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                String txt=result.getText().toString();
                temp.setText(txt);

                Expression exp= new Expression(txt);

                Double val=Double.valueOf(exp.calculate());
                String res;
                if(val%1==0) {
                    Integer a=val.intValue();
                    res=a.toString();
                }
                else
                    res=val.toString();

                result.setText(res);
            }
        });
    }
}