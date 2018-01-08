package com.example.endrit.finalproject.activities;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;

import com.example.endrit.finalproject.R;
import com.example.endrit.finalproject.activities.CustomViewActivity;

public class MainActivity extends AppCompatActivity {
    Button btnCustomView, btnMathView, btnPagerView, btnLoadWebView;
    EditText urlText;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        loadComponents();
        loadCustomView();
        loadMathView();
        loadPagerView();
        loadInputUrl();
    }

    private void loadInputUrl() {
        btnLoadWebView.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                String url = String.valueOf(urlText.getText());
                if(!url.matches("")) {
                    System.out.println(url);
                    Intent intent = new Intent(getApplicationContext(), WebViewActivity.class);
                    intent.putExtra("url_value", url);
                    startActivity(intent);
                } else {
                    Toast.makeText(getApplicationContext(), "URL input should be filled !", Toast.LENGTH_LONG).show();
                }
            }
        });
    }

    private void loadPagerView() {
        btnPagerView.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent intent = new Intent(getApplicationContext(), MainPagerActivity.class);
                startActivity(intent);
            }
        });
    }

    private void loadMathView() {
        btnMathView.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent intent = new Intent(getApplicationContext(), MathActivity.class);
                startActivity(intent);
            }
        });
    }

    private void loadComponents() {
        btnCustomView = (Button) findViewById(R.id.btn_custom_view);
        btnMathView = (Button) findViewById(R.id.btn_math);
        btnPagerView = findViewById(R.id.btn_pager);
        btnLoadWebView = findViewById(R.id.load_web_url);
        urlText = findViewById(R.id.web_view_url);
    }

    private void loadCustomView() {
        btnCustomView.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent intent = new Intent(getApplicationContext(), CustomViewActivity.class);
                startActivity(intent);
            }
        });
    }




}
