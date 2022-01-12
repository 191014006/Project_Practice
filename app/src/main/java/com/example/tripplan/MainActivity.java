package com.example.tripplan;

import androidx.appcompat.app.AppCompatActivity;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.ImageView;

import com.example.tripplan.adapter.RecentsAdapter;
import com.example.tripplan.adapter.TopPlacesAdapter;
import com.example.tripplan.model.RecentsData;
import com.example.tripplan.model.TopPlacesData;
import com.google.firebase.auth.FirebaseAuth;

import java.util.ArrayList;
import java.util.List;

public class MainActivity extends AppCompatActivity {

    RecyclerView recentRecycler, topPlacesRecycler;
    RecentsAdapter recentsAdapter;
    TopPlacesAdapter topPlacesAdapter;

    private FirebaseAuth auth;
    ImageView imgLogout;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);


        auth = FirebaseAuth.getInstance();
        imgLogout = findViewById(R.id.logout);
        imgLogout.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                FirebaseAuth.getInstance().signOut();
                finish();
                Intent intent = new Intent(getApplicationContext(),LoginActivity.class);
                startActivity(intent);
            }
        });


        List<RecentsData> recentsDataList = new ArrayList<>();
        recentsDataList.add(new RecentsData("AM Lake","India","From $200",R.drawable.recentimage1));
        recentsDataList.add(new RecentsData("Nilgiri Hills","India","From $300",R.drawable.recentimage2));
        recentsDataList.add(new RecentsData("AM Lake","India","From $200",R.drawable.recentimage1));
        recentsDataList.add(new RecentsData("Nilgiri Hills","India","From $300",R.drawable.recentimage2));
        recentsDataList.add(new RecentsData("AM Lake","India","From $200",R.drawable.recentimage1));
        recentsDataList.add(new RecentsData("Nilgiri Hills","India","From $300",R.drawable.recentimage2));

        setRecentRecycler(recentsDataList);

        List<TopPlacesData> topPlacesDataList = new ArrayList<>();
        topPlacesDataList.add(new TopPlacesData("Kasimir Hill","India","$200 - $500",R.drawable.topplaces));
        topPlacesDataList.add(new TopPlacesData("Kasimir Hill","India","$200 - $500",R.drawable.topplaces));
        topPlacesDataList.add(new TopPlacesData("Kasimir Hill","India","$200 - $500",R.drawable.topplaces));
        topPlacesDataList.add(new TopPlacesData("Kasimir Hill","India","$200 - $500",R.drawable.topplaces));
        topPlacesDataList.add(new TopPlacesData("Kasimir Hill","India","$200 - $500",R.drawable.topplaces));

        setTopPlacesRecycler(topPlacesDataList);

    }


    private  void setRecentRecycler(List<RecentsData> recentsDataList){

        recentRecycler = findViewById(R.id.recent_recycler);
        RecyclerView.LayoutManager layoutManager = new LinearLayoutManager(this, RecyclerView.HORIZONTAL, false);
        recentRecycler.setLayoutManager(layoutManager);
        recentsAdapter = new RecentsAdapter(this, recentsDataList);
        recentRecycler.setAdapter(recentsAdapter);

    }

    private  void setTopPlacesRecycler(List<TopPlacesData> topPlacesDataList){

        topPlacesRecycler = findViewById(R.id.top_places_recycler);
        RecyclerView.LayoutManager layoutManager = new LinearLayoutManager(this, RecyclerView.VERTICAL, false);
        topPlacesRecycler.setLayoutManager(layoutManager);
        topPlacesAdapter = new TopPlacesAdapter(this, topPlacesDataList);
        topPlacesRecycler.setAdapter(topPlacesAdapter);

    }
}