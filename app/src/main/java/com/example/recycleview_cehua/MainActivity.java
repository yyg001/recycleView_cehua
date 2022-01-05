package com.example.recycleview_cehua;

import androidx.appcompat.app.AppCompatActivity;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import android.os.Bundle;
import android.widget.Toast;

import java.util.ArrayList;
import java.util.List;

public class MainActivity extends AppCompatActivity implements MyAdapter.OnButtonClickListener{
    private RecyclerView recyclerView;
    private List<String> lovePhotos=new ArrayList<>();
    private String aa[]=new String[10];


    MyAdapter myAdapter;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        lovePhotos.add("a0");
        lovePhotos.add("a1");
        lovePhotos.add("a2");
        lovePhotos.add("a3");
        lovePhotos.add("a4");
        lovePhotos.add("a5");
        lovePhotos.add("a6");
        lovePhotos.add("a7");
        lovePhotos.add("a8");
        lovePhotos.add("a9");

        setContentView(R.layout.activity_main);
        recyclerView=findViewById(R.id.rv_love);
        myAdapter=new MyAdapter(this,lovePhotos);
        myAdapter.setOnClickListener(this);
        recyclerView=findViewById(R.id.rv_love);
        recyclerView.setAdapter(myAdapter);
        recyclerView.setLayoutManager(new LinearLayoutManager(this));
    }

    @Override
    protected void onSaveInstanceState(Bundle outState) {
        super.onSaveInstanceState(outState);

        // Only if you need to restore open/close state when
        // the orientation is changed
        if (myAdapter != null) {
            myAdapter.saveStates(outState);
        }
    }

    @Override
    protected void onRestoreInstanceState(Bundle savedInstanceState) {
        super.onRestoreInstanceState(savedInstanceState);

        // Only if you need to restore open/close state when
        // the orientation is changed
        if (myAdapter != null) {
            myAdapter.restoreStates(savedInstanceState);
        }
    }

    @Override
    public void onItemClick(String lovePhoto, int position) {
                Toast.makeText(this,"你点击了第"+(position+1)+"文字",Toast.LENGTH_SHORT).show();
    }

}