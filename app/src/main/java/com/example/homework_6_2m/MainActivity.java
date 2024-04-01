package com.example.homework_6_2m;

import android.graphics.Color;
import android.os.Bundle;
import android.text.Editable;
import android.text.TextWatcher;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;
import android.widget.Toast;

import androidx.activity.EdgeToEdge;
import androidx.appcompat.app.AppCompatActivity;
import androidx.core.content.ContextCompat;
import androidx.core.graphics.Insets;
import androidx.core.view.ViewCompat;
import androidx.core.view.WindowInsetsCompat;

public class MainActivity extends AppCompatActivity {
    private TextView Entrance;
    private TextView Registration;
    private TextView Registration2;
    private EditText Email;
    private EditText Password;
    private Button Come;
    private TextView Forget;
    private TextView Click;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        Entrance = findViewById(R.id.tv_vhod2);
        Registration = findViewById(R.id.tv_vhod);
        Registration2 = findViewById(R.id.tv_registr);
        Email = findViewById(R.id.et_pochta);
        Password = findViewById(R.id.et_parol);
        Come = findViewById(R.id.voyti);
        Forget = findViewById(R.id.tv_password);
        Click = findViewById(R.id.tv_click);

        Password.addTextChangedListener(new TextWatcher() {
            @Override
            public void beforeTextChanged(CharSequence s, int start, int count, int after) {

            }

            @Override
            public void onTextChanged(CharSequence s, int start, int before, int count) {

            }

            @Override
            public void afterTextChanged(Editable s) {
                if (Email.getText().toString().isEmpty()) {
                    Come.setBackgroundColor(ContextCompat.getColor(MainActivity.this, R.color.grey));
                } else {
                    Come.setBackgroundColor(ContextCompat.getColor(MainActivity.this, R.color.orange));
                }
            }
        });
        Email.addTextChangedListener(new TextWatcher() {
            @Override
            public void beforeTextChanged(CharSequence s, int start, int count, int after) {

            }

            @Override
            public void onTextChanged(CharSequence s, int start, int before, int count) {

            }

            @Override
            public void afterTextChanged(Editable s) {
                if (Email.getText().toString().isEmpty()) {
                    Come.setBackgroundColor(Color.GRAY);
                } else {
                    Come.setBackgroundColor(ContextCompat.getColor(MainActivity.this, R.color.orange));
                }

            }
        });
        Come.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                if (Email.getText().toString().equals("admin") &&
                        Password.getText().toString().equals("admin")) {
                    Entrance.setVisibility(View.GONE);
                    Registration.setVisibility(View.GONE);
                    Registration2.setVisibility(View.GONE);
                    Email.setVisibility(View.GONE);
                    Password.setVisibility(View.GONE);
                    Come.setVisibility(View.GONE);
                    Forget.setVisibility(View.GONE);
                    Click.setVisibility(View.GONE);
                    Toast.makeText(MainActivity.this, "Вы успешно зарегистрировались",
                            Toast.LENGTH_SHORT).show();
                }else {
                    Toast.makeText(MainActivity.this, "Неправильный логин или пароль",
                            Toast.LENGTH_SHORT).show();
                }
            }
        });
    }
}