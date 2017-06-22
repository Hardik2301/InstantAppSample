package com.imac.insantappsample.register;

import android.content.Intent;
import android.net.Uri;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.util.Log;
import android.view.View;
import android.widget.Button;

public class DetailActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_detail);

        Intent appLinkIntent = getIntent();
        if(appLinkIntent != null) {
            String appLinkAction = appLinkIntent.getAction();
            if (appLinkAction != null && appLinkAction.equalsIgnoreCase("android.intent.action.VIEW")) {
                Uri appLinkData = appLinkIntent.getData();
                Log.e("Deep Link: Received", appLinkData.toString());
            }
        }

        Button btn_getApp =(Button)findViewById(R.id.btn_getApp);
        btn_getApp.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent(Intent.ACTION_VIEW,Uri.parse("market://details?id="+getPackageName()));
                startActivity(intent);
                //InstantApps.showInstallPrompt();
            }
        });
    }
}
