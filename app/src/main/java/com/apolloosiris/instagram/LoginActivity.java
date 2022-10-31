package com.apolloosiris.instagram;

import android.content.Intent;
import android.os.Bundle;
import android.os.Parcelable;
import android.text.TextUtils;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;
import android.widget.Toast;

import androidx.appcompat.app.AppCompatActivity;


public class LoginActivity extends AppCompatActivity {

    private EditText email;
    private EditText password;
    private Button login;
    private TextView registerUser;
    private User user;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_login);

        email = findViewById(R.id.email);
        password = findViewById(R.id.password);
        login = findViewById(R.id.login);
        registerUser = findViewById(R.id.register_user);



        registerUser.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                startActivity(new Intent(LoginActivity.this , RegisterActivity.class).addFlags(Intent.FLAG_ACTIVITY_CLEAR_TASK));
            }
        });

        login.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {

                String txt_email = email.getText().toString();
                String txt_password = password.getText().toString();

                if (TextUtils.isEmpty(txt_email) || TextUtils.isEmpty(txt_password)){
                    Toast.makeText(LoginActivity.this, "Empty Credentials!", Toast.LENGTH_SHORT).show();
                } else {
                    loginUser(txt_email , txt_password);
                }
            }
        });
    }

    private void loginUser(String email, String password) {
        System.out.println(email);

        Database_Utill database_utill=new Database_Utill();
        user=database_utill.loadData(this,email);



        if(user==null){
            Toast.makeText(LoginActivity.this, "Error login check email ", Toast.LENGTH_SHORT).show();
            Intent intent = new Intent(LoginActivity.this , LoginActivity.class);
            intent.addFlags(Intent.FLAG_ACTIVITY_CLEAR_TASK | Intent.FLAG_ACTIVITY_CLEAR_TOP);
            startActivity(intent);
            finish();
        }
        else{

            if(user.getPassword().equals(password)){
            Toast.makeText(LoginActivity.this, "Update the profile " +
                    "for better expereince", Toast.LENGTH_SHORT).show();
            Intent intent = new Intent(LoginActivity.this , MainActivity.class);
            intent.putExtra("user",  user);
            intent.addFlags(Intent.FLAG_ACTIVITY_CLEAR_TASK | Intent.FLAG_ACTIVITY_CLEAR_TOP);
            startActivity(intent);
            finish();}

            else{
                Toast.makeText(LoginActivity.this, "Error login check password ", Toast.LENGTH_SHORT).show();
                Intent intent = new Intent(LoginActivity.this , LoginActivity.class);
                intent.addFlags(Intent.FLAG_ACTIVITY_CLEAR_TASK | Intent.FLAG_ACTIVITY_CLEAR_TOP);
                startActivity(intent);
                finish();
            }
        }



        //unsucessful
        //Toast.makeText(LoginActivity.this, e.getMessage(), Toast.LENGTH_SHORT).show();




    }
}
