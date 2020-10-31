package com.neub.alumni;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;

import com.neub.alumni.R;

public class DepartmentActivity extends AppCompatActivity implements View.OnClickListener {

    Button deptCse, deptBba, deptEng, deptLaw;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_department);
        this.setTitle("Department");

        Button deptCse = findViewById(R.id.deptCse);
        Button deptBba = findViewById(R.id.deptBba);
        Button deptLaw = findViewById(R.id.deptLaw);
        Button deptEng = findViewById(R.id.deptEng);


        deptBba.setOnClickListener(this);
        deptCse.setOnClickListener(this);
        deptEng.setOnClickListener(this);
        deptLaw.setOnClickListener(this);


    }

    @Override
    public void onClick(View v) {

        switch (v.getId()){

            case R.id.deptEng:
            case R.id.deptBba:
            case R.id.deptLaw:    


            case R.id.deptCse:
                Intent intent= new Intent(getApplicationContext(),StudentFacultyActivity.class);
                startActivity(intent);
                break;



        }


    }
}