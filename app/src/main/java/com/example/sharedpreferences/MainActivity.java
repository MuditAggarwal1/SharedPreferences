package com.example.sharedpreferences;

import androidx.appcompat.app.AppCompatActivity;

import android.content.SharedPreferences;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;

public class MainActivity extends AppCompatActivity {
    TextView textView;
    EditText editText;
    Button button;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        editText = findViewById(R.id.editText);
        textView = findViewById(R.id.textView);
        button = findViewById(R.id.button);
        button.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                String val = editText.getText().toString();
                SharedPreferences sP = getSharedPreferences("MyPref", MODE_PRIVATE);
                SharedPreferences.Editor ed = sP.edit();
                ed.putString("name",val);
                ed.apply();
                textView.setText(val);
            }
        });
        SharedPreferences sP = getSharedPreferences("MyPref", MODE_PRIVATE);
        String editVal = sP.getString("name", "No value as of now");
        textView.setText(editVal);
    }
}