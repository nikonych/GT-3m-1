package com.example.gt_3m_1;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.net.Uri;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;

public class MainActivity extends AppCompatActivity {

    private EditText ed_email;
    private EditText ed_theme;
    private EditText ed_brief;
    private Button btn_send;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        initView();
        initListener();
    }

    private void initListener() {
        btn_send.setOnClickListener(view -> {
            if(!ed_email.getText().toString().isEmpty() && !ed_theme.getText().toString().isEmpty() && !ed_brief.getText().toString().isEmpty()) {
                Intent email = new Intent(Intent.ACTION_SEND);
                email.putExtra(Intent.EXTRA_EMAIL, new String[]{ed_email.getText().toString()});
                email.putExtra(Intent.EXTRA_SUBJECT, ed_theme.getText().toString());
                email.putExtra(Intent.EXTRA_TEXT, ed_brief.getText().toString());

                email.setType("message/*");

                startActivity(email);
            } else {
                Toast.makeText(MainActivity.this, "fill the forms", Toast.LENGTH_LONG).show();
            }
        });
    }


    private void initView() {
        ed_email = findViewById(R.id.ed_email);
        ed_theme = findViewById(R.id.ed_theme);
        ed_brief = findViewById(R.id.ed_brief);
        btn_send = findViewById(R.id.btn_send);
    }
}