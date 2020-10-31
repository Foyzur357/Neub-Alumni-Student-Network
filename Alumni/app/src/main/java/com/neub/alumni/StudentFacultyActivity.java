package com.neub.alumni;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;

import com.neub.alumni.R;

public class StudentFacultyActivity extends AppCompatActivity implements View.OnClickListener {

    private Button student, faculty, alumni;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_student_faculty);


        Button student = findViewById(R.id.student);
        Button faculty = findViewById(R.id.faculty);
        Button alumni = findViewById(R.id.alumni);

        student.setOnClickListener(this);
        alumni.setOnClickListener(this);
        faculty.setOnClickListener(this);


    }

    @Override
    public void onClick(View v) {

        switch (v.getId()){

            case R.id.student:
                Intent intent = new Intent(getApplicationContext(), StudentsActivity.class );
                startActivity(intent);

            case R.id.faculty:
                Intent intent1 = new Intent(getApplicationContext(), FacultysActivity.class );
                startActivity(intent1);

            case R.id.alumni:
                Intent intent2 = new Intent(getApplicationContext(), AlumnisActivity.class );
                startActivity(intent2);


        }

    }
}