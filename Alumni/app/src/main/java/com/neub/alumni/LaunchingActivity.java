package com.neub.alumni;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.TextView;

import com.neub.alumni.R;

public class LaunchingActivity extends AppCompatActivity implements View.OnClickListener {

    TextView sign_up_tv;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_launching);


        Button btn_sign_in = findViewById(R.id.btn_sign_in);
        sign_up_tv = findViewById(R.id.sign_up_tv);


        btn_sign_in.setOnClickListener(this);
        sign_up_tv.setOnClickListener(this);

    }

    @Override
    public void onClick(View v) {

        switch (v.getId()) {

            case R.id.btn_sign_in:
                Intent intent = new Intent(getApplicationContext(), LoginChoiseActivity.class);
                startActivity(intent);
                break;

            case R.id.sign_up_tv:
                Intent intent1 = new Intent(getApplicationContext(), RegisterActivity.class);
                startActivity(intent1);
                break;


        }

    }
}