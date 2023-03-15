package com.example.otpcheck;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.TextView;
import android.widget.Toast;

import com.google.firebase.auth.FirebaseAuth;
import com.google.firebase.auth.FirebaseUser;

public class SignIn extends AppCompatActivity {

    TextView phoneNumberTextView;

    Button signOut;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_sign_in);

        phoneNumberTextView = findViewById(R.id.phoneTextView);
        signOut = findViewById(R.id.sign_out);

        FirebaseUser user= FirebaseAuth.getInstance().getCurrentUser();
        try{
            phoneNumberTextView.setText(user.getPhoneNumber());
        } catch (Exception e)
        {
            Toast.makeText(this,"Phone number not found",
                    Toast.LENGTH_LONG).show();
        }

        signOut.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                FirebaseAuth.getInstance().signOut();
                startActivity(new Intent(SignIn.this,
                        MainActivity.class));
                finish();

            }
        });

    }
}