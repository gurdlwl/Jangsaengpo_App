package kr.hs.dgsw.jangsengpoapp;

import android.content.Intent;
import android.net.Uri;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.LinearSnapHelper;
import android.support.v7.widget.RecyclerView;
import android.support.v7.widget.SnapHelper;
import android.view.View;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

import kr.hs.dgsw.jangsengpoapp.MainRecyclerView.MainListAdapter;
import kr.hs.dgsw.jangsengpoapp.MainRecyclerView.MainListClickListener;

public class MainActivity extends AppCompatActivity implements MainListClickListener{

    SnapHelper snapHelper;
    RecyclerView mainList;
    LinearLayoutManager layoutManager;
    MainListAdapter mainListAdapter;

    String[] dataRes;
    List<String> data;

    final String HomePageUrl ="http://www.whalecity.kr/";
    final String AppUrl = "https://play.google.com/store/apps/details?id=com.twombgame.ulsan.beacon&hl=ko";

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        createMainRecycler();
    }

    private void createMainRecycler(){
        dataRes = getResources().getStringArray(R.array.menuList);
        data = new ArrayList<String>(Arrays.asList(dataRes));

        snapHelper = new LinearSnapHelper();

        mainList = findViewById(R.id.MainList);
        layoutManager = new LinearLayoutManager(this);
        mainListAdapter = new MainListAdapter((ArrayList<String>) data,this);

        layoutManager.setOrientation(LinearLayoutManager.HORIZONTAL);
        mainList.setLayoutManager(layoutManager);
        mainList.setAdapter(mainListAdapter);

        snapHelper.attachToRecyclerView(mainList);
    }

    @Override
    public void onItemClick(View v, int position){
        if(position == 0){
            startActivity(new Intent(this, StorytellingActivity.class));
        } else if(position == 1){
            startActivity(new Intent(this, VideoActivity.class));
        } else if(position == 2){
            startActivity(new Intent(this, StampActivity.class));
        } else if(position == 3){
            startActivity(new Intent(this, MapActivity.class));
        }
    }

    public void onUseInfoClick(View v){
        Intent intent = new Intent(getApplicationContext(), UseInfoActivity.class);
        startActivity(intent);
    }

    public void onHomePageClick(View v){
        Intent intent = new Intent(Intent.ACTION_VIEW, Uri.parse(HomePageUrl));
        startActivity(intent);
    }

    public void onAppDownloadClick(View v){
        Intent intent = new Intent(Intent.ACTION_VIEW, Uri.parse(AppUrl));
        startActivity(intent);
    }
}