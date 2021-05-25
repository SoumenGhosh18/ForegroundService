package com.example.foregroundservice;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.EditText;

public class MainActivity extends AppCompatActivity {

    private EditText editTextInput;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        editTextInput= findViewById(R.id.edit_text_input);

    }

    public void startService(View view) {
        String input = editTextInput.getText().toString();

        Intent serviceIntent1 = new Intent(this,ExampleService.class);
        serviceIntent1.putExtra("soumen",input);
        startService(serviceIntent1);
    }

    public void stopService(View view) {

        Intent serviceIntent = new Intent(this,ExampleService.class);
        stopService(serviceIntent);

    }
}
