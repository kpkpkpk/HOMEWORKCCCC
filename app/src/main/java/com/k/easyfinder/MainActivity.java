package com.k.easyfinder;

import androidx.annotation.MainThread;
import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.graphics.Color;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.ImageButton;
import android.widget.TextView;
import android.widget.Toast;

import org.w3c.dom.Text;

public class MainActivity extends AppCompatActivity {
    private EditText editTextA;
    private EditText editTextB;
    private EditText editTextC;
    private Button resultButton;
    private TextView xResult;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        //находим наши EditText, TextView, Button
        editTextA=(EditText) findViewById(R.id.editTextA);
        editTextB=(EditText) findViewById(R.id.editTextB);
        editTextC=(EditText) findViewById(R.id.editTextC);
        resultButton=(Button) findViewById(R.id.resultButton);
        xResult=(TextView) findViewById(R.id.xResult);
        //объявляю слушатель нажатий для кнопки
        View.OnClickListener listener = new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                switch (view.getId()){
                    case R.id.resultButton:
                        //проверка на нелинейность функции, в случае 0 мы просим вводить коэффициент а
                        if(Double.valueOf(editTextA.getText().toString())==0){
                            xResult.setTextColor(Color.RED);
                            xResult.setText(R.string.error_coefficient);
                        }else{
                            Equation ex = new Equation(Double.valueOf(editTextA.getText().toString()), Double.valueOf(editTextB.getText().toString()), Double.valueOf(editTextC.getText().toString()));
                            xResult.setTextColor(Color.GREEN);
                            xResult.setText(ex.solve());
                        }
                }
            }
        };
        //присовоение нажатия
        resultButton.setOnClickListener(listener);

    }
}