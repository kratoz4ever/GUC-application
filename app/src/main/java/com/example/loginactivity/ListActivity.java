package com.example.loginactivity;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.view.ViewGroup;
import android.widget.AdapterView;
import android.widget.BaseAdapter;
import android.widget.ImageView;
import android.widget.ListView;
import android.widget.TextView;
import android.content.Intent;

public class ListActivity extends AppCompatActivity {
    String [] Names={"Android","Iphone","Windows","Blackberry","Linux"};
    int [] images={R.drawable.android,R.drawable.iphone,R.drawable.windows,R.drawable.blackberry,R.drawable.linux};
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_list);
        CustomAdapter customAdapter=new CustomAdapter();
        ListView list= (ListView) findViewById(R.id.mylist);
        list.setAdapter(customAdapter);
        list.setOnItemClickListener(new AdapterView.OnItemClickListener() {
            @Override
            public void onItemClick(AdapterView<?> parent, View view, int position, long id) {
                Intent intent1=new Intent(ListActivity.this,DeviceDetailActivity.class);
                startActivity(intent1);



            }
        });
    }
class CustomAdapter extends BaseAdapter{

    @Override
    public int getCount() {
        return images.length;
    }

    @Override
    public Object getItem(int position) {
        return null;
    }

    @Override
    public long getItemId(int position) {
        return 0;
    }

    @Override
    public View getView(int position, View convertView, ViewGroup parent) {
        View view=getLayoutInflater().inflate(R.layout.customlayout,null);
        ImageView myImageView=(ImageView) view.findViewById(R.id.imageView);
        TextView myTextView=(TextView) view.findViewById(R.id.textview);
        myImageView.setImageResource(images[position]);
        myTextView.setText(Names[position]);
        return view;
    }
}



}
