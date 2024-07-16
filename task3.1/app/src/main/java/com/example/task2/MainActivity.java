package com.example.task2;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;

public class MainActivity extends AppCompatActivity {
    TextView tvInfo;
    EditText etInput;
    Button bControl;
    int num;
    boolean isFinished;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        tvInfo = findViewById(R.id.TextView);
        etInput = findViewById(R.id.editText);
        bControl = findViewById(R.id.button);
        num = (int)(Math.random()*100);
        isFinished = false;
    }


    public void onClick(View v) {
        if (!isFinished) {
            int inp = Integer.parseInt(etInput.getText().toString());
            if (inp > num)
                tvInfo.setText(getResources().getString(R.string.ahead));
            if (inp < num)
                tvInfo.setText(getResources().getString(R.string.behind));
            if (inp == num) {
                tvInfo.setText(getResources().getString(R.string.hit));
                bControl.setText(getResources().getString(R.string.play_more));
                isFinished = true;
            }
        } else {
            num = (int) (Math.random() * 100);
            bControl.setText(getResources().getString(R.string.input_value));
            tvInfo.setText(getResources().getString(R.string.try_to_guess));
            isFinished = false;
        }
        etInput.setText("");
    }
}