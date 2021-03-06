package com.imac.insantappsample.login;

import android.content.Intent;
import android.net.Uri;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.view.View;
import android.widget.EditText;
import android.widget.Toast;

import com.imac.insantappsample.baseUtil;

public class SignInActivity extends AppCompatActivity {

    EditText ed1;
    EditText ed2;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_sign_in);

        Intent appLinkIntent = getIntent();
        String appLinkAction = appLinkIntent.getAction();
        Uri appLinkData = appLinkIntent.getData();

        ed1=(EditText)findViewById(R.id.editText);
        ed2=(EditText)findViewById(R.id.editText2);
    }

    public void OnSignInClick(View view){

        if(baseUtil.checkLogin(ed1.getText().toString(),ed2.getText().toString())) {
            startActivity(new Intent(getApplicationContext(), MainActivity.class));
        }else{
            Toast.makeText(getApplicationContext(),"Invalid Credential",Toast.LENGTH_SHORT).show();
        }
    }

    public void OnRegisterClick(View view){
        Intent intent=new Intent(Intent.ACTION_VIEW,Uri.parse("https://imac.com/register"));
        startActivity(intent);
    }
}
