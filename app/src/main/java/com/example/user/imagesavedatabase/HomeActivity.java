package com.example.user.imagesavedatabase;

import android.content.Intent;
import android.graphics.Paint;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;

public class HomeActivity extends AppCompatActivity {
    private Button btnTeruskan, btnMaintenance;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_home);

        btnTeruskan = (Button) findViewById(R.id.btnNext);
        btnMaintenance = (Button) findViewById(R.id.btnMaintenance);
        btnMaintenance.setPaintFlags(btnMaintenance.getPaintFlags() | Paint.UNDERLINE_TEXT_FLAG);

        btnTeruskan.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent(HomeActivity.this,MainActivity.class);
                startActivity(intent);
            }
        });
        btnMaintenance.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent(HomeActivity.this,GetAllUsersActivity.class);
                startActivity(intent);
            }
        });
    }
}
