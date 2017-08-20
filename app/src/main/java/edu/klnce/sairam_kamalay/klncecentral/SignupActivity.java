package edu.klnce.sairam_kamalay.klncecentral;

import android.support.annotation.NonNull;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.text.TextUtils;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;

import com.google.android.gms.tasks.OnCompleteListener;
import com.google.android.gms.tasks.Task;
import com.google.firebase.auth.AuthResult;
import com.google.firebase.auth.FirebaseAuth;

public class SignupActivity extends AppCompatActivity implements View.OnClickListener {

    //firebase objects
    private FirebaseAuth mAuth;

    //email and password objects
    private EditText editTextemail;
    private EditText editTextpassword;



    @Override
    protected void onCreate(Bundle savedInstanceState) {
        Button signupbtn;

        super.onCreate(savedInstanceState);
        setContentView(R.layout.signup_activity);

        mAuth = FirebaseAuth.getInstance();

        editTextemail = (EditText) findViewById(R.id.id_email);

        editTextpassword =(EditText) findViewById(R.id.id_password);

        signupbtn = (Button) findViewById(R.id.idsignupbtn);

        signupbtn.setOnClickListener(this);

    }

    private void registerUser(){
        String nuemail = editTextemail.getText().toString().trim();
        String nupassword = editTextpassword.getText().toString().trim();

        if(TextUtils.isEmpty(nuemail)){
            Toast.makeText(this,"Enter email",Toast.LENGTH_LONG).show();
            return;
        }

        if(TextUtils.isEmpty(nupassword)){
            Toast.makeText(this,"Enter password",Toast.LENGTH_LONG).show();
            return;
        }

        if(nupassword.length()<5){
            Toast.makeText(this,"Weak Password",Toast.LENGTH_LONG).show();
            return;
        }

        mAuth.createUserWithEmailAndPassword(nuemail,nupassword)
                .addOnCompleteListener(this, new OnCompleteListener<AuthResult>() {

                    @Override
                    public void onComplete(@NonNull Task<AuthResult> task) {
                        if (task.isSuccessful())
                        {
                            Toast.makeText(SignupActivity.this,"Successfully Registered",Toast.LENGTH_LONG).show();
                            editTextemail.setText(null);
                        }
                        else{
                            Toast.makeText(SignupActivity.this,"Registration error",Toast.LENGTH_LONG).show();
                            editTextemail.setText(null);
                        }
                    }
                });
    }


    @Override
    public void onClick(View v) {
        registerUser();
    }


}
