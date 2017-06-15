package com.pusilkom.training.day2;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;

import com.pusilkom.training.day2.task.PostActivityTask;

public class Login extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_login);

        final EditText password = (EditText) findViewById(R.id.text_password);
        final EditText username = (EditText) findViewById(R.id.text_username);

        Button login = (Button) findViewById(R.id.button_login);
        login.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                new PostActivityTask(Login.this).execute(password.getText().toString(), username.getText().toString());

                Log.d("TAG","Selesai");
            }
        });
    }
}
