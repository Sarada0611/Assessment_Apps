package com.example.myapplication;



import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;

import androidx.activity.EdgeToEdge;
import androidx.appcompat.app.AppCompatActivity;

public class MainActivity extends AppCompatActivity {

    private EditText editTextUserName, editTextPassword;
    private Button submitButton;




    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        EdgeToEdge.enable(this);
        setContentView(R.layout.activity_main);
        editTextUserName = findViewById(R.id.editTextUserNameValue);
        editTextPassword = findViewById(R.id.editTextPasswordValue);
        submitButton = findViewById(R.id.Submitbutton);

        submitButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {

                String username = editTextUserName.getText().toString();
                String password = editTextPassword.getText().toString();

                if(password.equals("1234")){
                    Intent intent = new Intent(MainActivity.this, UserNameCheckActivity.class );
                    intent.putExtra("username",username);
                    startActivity(intent);
                }
                else{
                    Toast.makeText(MainActivity.this,"Password Incorrect",Toast.LENGTH_SHORT).show();
                }

            }
        });


    }
}