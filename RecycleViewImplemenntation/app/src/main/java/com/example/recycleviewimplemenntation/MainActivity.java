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

    TextView tvSeeAll ;
    protected void onCreate(LayoutInflater inflater , ViewGroup container , Bundle savedInstanceState) {

        View rootView = inflater.inflate(R.layout.activity_main , container , false);
        arrayList = new ArrayList<>();
        arrayList.add(new RecycleViewData(R.drawable.ic_launcher_background , "data"));
        arrayList.add(new RecycleViewData(R.drawable.ic_launcher_background , "data"));
        arrayList.add(new RecycleViewData(R.drawable.ic_launcher_background , "data"));
        arrayList.add(new RecycleViewData(R.drawable.ic_launcher_background , "data"));
        arrayList.add(new RecycleViewData(R.drawable.ic_launcher_background , "data"));

    }
}