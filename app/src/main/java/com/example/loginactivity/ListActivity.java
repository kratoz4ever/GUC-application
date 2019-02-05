package com.example.loginactivity;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.AdapterView;
import android.widget.ArrayAdapter;
import android.widget.ListView;
import android.widget.TextView;
import android.content.Intent;

public class ListActivity extends AppCompatActivity {
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_list);
        ArrayAdapter<String> adapter=new ArrayAdapter<String>(ListActivity.this, android.R.layout.simple_list_item_1, getResources().getStringArray(R.array.os));
        ListView list= (ListView) findViewById(R.id.mylist);
        list.setAdapter(adapter);
        list.setOnItemClickListener(new AdapterView.OnItemClickListener() {
            @Override
            public void onItemClick(AdapterView<?> parent, View view, int position, long id) {
                Intent intent1=new Intent(ListActivity.this,DeviceDetailActivity.class);
                startActivity(intent1);



            }
        });
    }



}
