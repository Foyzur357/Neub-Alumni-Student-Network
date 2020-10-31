package com.neub.alumni;

import androidx.annotation.NonNull;
import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.util.Log;
import android.widget.TextView;
import com.google.firebase.auth.FirebaseAuth;
import com.google.firebase.auth.FirebaseUser;
import com.google.firebase.database.DataSnapshot;
import com.google.firebase.database.DatabaseError;
import com.google.firebase.database.DatabaseReference;
import com.google.firebase.database.FirebaseDatabase;
import com.google.firebase.database.ValueEventListener;

public class StudentProfileActivity extends AppCompatActivity {

    FirebaseAuth mAuth;
    FirebaseUser user;
    DatabaseReference profileSRef;

    TextView pSName, pSEmail, pSPhone;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_student_profile);

        mAuth = FirebaseAuth.getInstance();
        user = mAuth.getCurrentUser();

        //profileImage = findViewById(R.id.profileImage);
        pSName = findViewById(R.id.student_profile_name_id);
        pSEmail = findViewById(R.id.student_profile_email_id);
        pSPhone = findViewById(R.id.student_profile_phone_id);


        profileSRef = FirebaseDatabase.getInstance().getReference().child("Users").child("Student").child(user.getUid());
        profileSRef.addValueEventListener(new ValueEventListener() {
            @Override
            public void onDataChange(@NonNull DataSnapshot dataSnapshot) {
                //String picture = dataSnapshot.child("url").getValue().toString();
                String name = dataSnapshot.child("name").getValue().toString();
                String phone = dataSnapshot.child("phone_no").getValue().toString();
                String email = dataSnapshot.child("email").getValue().toString();
                Log.i("NAme", name);


                //Picasso.get().load(picture).into(profileImage);

                pSName.setText(name);
                pSPhone.setText(phone);
                pSEmail.setText(email);
            }

            @Override
            public void onCancelled(@NonNull DatabaseError databaseError) {

            }
        });
    }
}