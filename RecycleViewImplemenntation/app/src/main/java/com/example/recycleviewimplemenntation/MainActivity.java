package com.example.recycleviewimplemenntation;

import androidx.appcompat.app.AppCompatActivity;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

import java.util.ArrayList;

public class MainActivity extends AppCompatActivity {

    ArrayList<RecycleViewData>arrayList;
    RecyclerView arrayRecycleView ;
    RecyclerView.Adapter myRecycleViewAdapter;
    RecyclerView.LayoutManager recyclerLayoutManager;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        arrayList = new ArrayList<>();

        arrayList.add(new RecycleViewData(R.drawable.ic_launcher_background , "data"));
        arrayList.add(new RecycleViewData(R.drawable.ic_launcher_background , "data"));
        arrayList.add(new RecycleViewData(R.drawable.ic_launcher_background , "data"));
        arrayList.add(new RecycleViewData(R.drawable.ic_launcher_background , "data"));
        arrayList.add(new RecycleViewData(R.drawable.ic_launcher_background , "data"));

        arrayRecycleView = findViewById(R.id.rcv);
        arrayRecycleView.setHasFixedSize(true);

        recyclerLayoutManager = new LinearLayoutManager(getBaseContext(), LinearLayoutManager.VERTICAL, false);
        arrayRecycleView.setLayoutManager(recyclerLayoutManager);

        myRecycleViewAdapter = new RecycleViewAdapter(getBaseContext(),arrayList);
        arrayRecycleView.setAdapter(myRecycleViewAdapter);
    }
}