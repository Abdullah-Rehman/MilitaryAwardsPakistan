package com.abdullah_rehman.militaryawardspakistan;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.support.v7.widget.ListViewCompat;
import android.support.v7.widget.Toolbar;
import android.view.View;
import android.widget.AdapterView;
import android.widget.ListView;

import java.util.List;

public class MainActivity extends AppCompatActivity {

    Toolbar mToolbar;
    ListView mListVIew;

    String[] awardNames= {
            "Nishan-I-Haider",
            "Hilal-I-Jurat",
            "Sitara-I-Jurat",
            "Tamgha-I-Jurat"};//for Names

    int[] awardImages = {
            R.mipmap.nishan_e_heider1,
            R.mipmap.hilal_i_jurat,
            R.mipmap.sitara_e_jurat,
            R.mipmap.tamgha_e_imtiaz};//for images

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        mToolbar =(Toolbar) findViewById(R.id.toolbar);
        mToolbar.setTitle(getResources().getString(R.string.app_name));
        mListVIew=(ListView) findViewById(R.id.listView);
        MyAdapter myAdapter = new MyAdapter(MainActivity.this,awardNames,awardImages);
        mListVIew.setAdapter(myAdapter);
        mListVIew.setOnItemClickListener(new AdapterView.OnItemClickListener() {
            @Override
            public void onItemClick(AdapterView<?> adapterView, View view, int i, long l) {

                Intent mIntent = new Intent(MainActivity.this,DetailActivity.class );
                mIntent.putExtra("awardNames",awardNames[i]);
                mIntent.putExtra("awardImages",awardImages[i]);
                startActivity(mIntent);
            }
        });


    }
}
