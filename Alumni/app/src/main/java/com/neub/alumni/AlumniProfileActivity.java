package com.neub.alumni;

import androidx.annotation.NonNull;
import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.widget.TextView;

import com.google.firebase.FirebaseApp;
import com.google.firebase.auth.FirebaseAuth;
import com.google.firebase.auth.FirebaseUser;
import com.google.firebase.database.DataSnapshot;
import com.google.firebase.database.DatabaseError;
import com.google.firebase.database.DatabaseReference;
import com.google.firebase.database.FirebaseDatabase;
import com.google.firebase.database.ValueEventListener;
import com.neub.alumni.R;

public class AlumniProfileActivity extends AppCompatActivity {

    FirebaseAuth mAuth;
    FirebaseUser user;
    DatabaseReference profileRef;

    TextView pName, pEmail, pPhone;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_alumni_profile);

        FirebaseApp.initializeApp(this);
        mAuth = FirebaseAuth.getInstance();
        user = mAuth.getCurrentUser();

        //profileImage = findViewById(R.id.profileImage);
        pName = findViewById(R.id.alumni_name);
        pEmail = findViewById(R.id.alumni_email);
        pPhone = findViewById(R.id.alumni_phone);


        profileRef = FirebaseDatabase.getInstance().getReference().child("Users").child("Alumni").child(user.getUid());
        profileRef.addValueEventListener(new ValueEventListener() {
            @Override
            public void onDataChange(@NonNull DataSnapshot dataSnapshot) {
                //String picture = dataSnapshot.child("url").getValue().toString();
                String name = dataSnapshot.child("name").getValue().toString();
                String phone = dataSnapshot.child("phone_no").getValue().toString();
                String email = dataSnapshot.child("email").getValue().toString();


                //Picasso.get().load(picture).into(profileImage);

                pName.setText(name);
                pPhone.setText(phone);
                pEmail.setText(email);
            }

            @Override
            public void onCancelled(@NonNull DatabaseError databaseError) {

            }
        });
    }
}