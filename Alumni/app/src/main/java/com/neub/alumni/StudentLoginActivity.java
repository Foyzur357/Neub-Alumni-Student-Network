package com.neub.alumni;

import androidx.annotation.NonNull;
import androidx.annotation.RequiresApi;
import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Build;
import android.os.Bundle;
import android.util.Patterns;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;

import com.google.android.gms.tasks.OnCompleteListener;
import com.google.android.gms.tasks.Task;
import com.google.firebase.auth.AuthResult;
import com.google.firebase.auth.FirebaseAuth;

public class StudentLoginActivity extends AppCompatActivity implements View.OnClickListener{

    private EditText user_name_et, password_et;

    private FirebaseAuth mAuth;


    @RequiresApi(api = Build.VERSION_CODES.KITKAT)
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_student_login);

        this.setTitle("Student Login");

        mAuth = FirebaseAuth.getInstance();


        Button btn_sign_in = findViewById(R.id.btn_sign_in_id);
        password_et = findViewById(R.id.password_et_id);
        user_name_et = findViewById(R.id.user_name_et_id);

        btn_sign_in.setOnClickListener(this);

    }

    @Override
    public void onClick(View v) {

        switch (v.getId()){

            case R.id.btn_sign_in_id:
                userLogin();
                break;
        }

    }

//    private void checkRole(){
//        DatabaseReference rootRef = FirebaseDatabase.getInstance().getReference().child("Users");
//        rootRef.child("Alumni").addListenerForSingleValueEvent(new ValueEventListener() {
//            @Override
//            public void onDataChange(DataSnapshot snapshot) {
//                if (snapshot.hasChild(user_id)) {
//                    userRole = 1;
//                }
//            }
//
//            @Override
//            public void onCancelled(@NonNull DatabaseError error) {
//
//            }
//        });
//
//        rootRef.child("Student").addListenerForSingleValueEvent(new ValueEventListener() {
//            @Override
//            public void onDataChange(DataSnapshot snapshot) {
//                if (snapshot.hasChild(user_id)) {
//                    userRole = 2;
//                }
//            }
//
//            @Override
//            public void onCancelled(@NonNull DatabaseError error) {
//
//            }
//        });
//
//        rootRef.child("Faculti").addListenerForSingleValueEvent(new ValueEventListener() {
//            @Override
//            public void onDataChange(DataSnapshot snapshot) {
//                if (snapshot.hasChild(user_id)) {
//                    userRole = 3;
//                }
//            }
//
//            @Override
//            public void onCancelled(@NonNull DatabaseError error) {
//
//            }
//        });
//    }

    private void userLogin(){
        String email = user_name_et.getText().toString().trim();
        String password = password_et.getText().toString().trim();


        if (email.isEmpty()){
            user_name_et.setError("Enter an email address");
            user_name_et.requestFocus();
            return;
        }

        if (!Patterns.EMAIL_ADDRESS.matcher(email).matches()){
            user_name_et.setError("Enter a valid email address");
            user_name_et.requestFocus();
            return;
        }

        if (password.isEmpty()){
            password_et.setError("Enter password");
            password_et.requestFocus();
            return;
        }

        if(password.length()<6){
            password_et.setError("Minimum length of password should be 6");
            password_et.requestFocus();
            return;
        }

        mAuth.signInWithEmailAndPassword(email,password).addOnCompleteListener(new OnCompleteListener<AuthResult>() {
            @RequiresApi(api = Build.VERSION_CODES.KITKAT)
            @Override
            public void onComplete(@NonNull Task<AuthResult> task) {


                if(task.isSuccessful()){
                    finish();
                    Intent intent1 = new Intent(getApplicationContext(), StudentProfileActivity.class);
                    intent1.addFlags(Intent.FLAG_ACTIVITY_CLEAR_TOP);
                    startActivity(intent1);
                }
            }
        });


    }
}