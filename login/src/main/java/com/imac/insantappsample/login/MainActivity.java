package com.imac.insantappsample.login;

import android.content.Intent;
import android.net.Uri;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.widget.Toast;

import java.util.ArrayList;
import java.util.List;

public class MainActivity extends AppCompatActivity {

    RecyclerView recyclerView;
    List<String> mList;
    RecyclerviewAdapter mAdapter;
    private List<String> itemlist;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        recyclerView = (RecyclerView) findViewById(R.id.recyclerview);
        mList = new ArrayList<String>();
        mList = getItemlist();

        mAdapter = new RecyclerviewAdapter(this, mList);
        recyclerView.setAdapter(mAdapter);
        recyclerView.setLayoutManager(new LinearLayoutManager(this));

        mAdapter.setItemClickListener(new RecyclerviewAdapter.itemClickListener() {
            @Override
            public void onItemSelect(int position) {
                Toast.makeText(getApplicationContext(), mList.get(position), Toast.LENGTH_SHORT).show();
                startActivity(new Intent(getApplicationContext(), DetailActivity.class));
            }
        });

        Intent appLinkIntent = getIntent();
        String appLinkAction = appLinkIntent.getAction();
        Uri appLinkData = appLinkIntent.getData();
    }

    public List<String> getItemlist() {

        List<String> mTemplist = new ArrayList<String>();
        for(int i = 0;i< 10;i++){
            mTemplist.add("Sample Text "+i);
        }

        return mTemplist;
    }
}
