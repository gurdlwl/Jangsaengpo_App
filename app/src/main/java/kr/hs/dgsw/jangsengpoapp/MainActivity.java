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
import kr.hs.dgsw.jangsengpoapp.SubRecyclerView.SubListAdapter;
import kr.hs.dgsw.jangsengpoapp.SubRecyclerView.SubListClickListener;

public class MainActivity extends AppCompatActivity implements MainListClickListener, SubListClickListener {

    SnapHelper snapHelper;
    RecyclerView mainList;
    RecyclerView subList;
    LinearLayoutManager layoutManager;
    MainListAdapter mainListAdapter;
    SubListAdapter subListAdapter;

    String[] dataRes;
    List<String> data;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        createMainRecycler();
        createSubRecycler();
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

    private void createSubRecycler(){
        dataRes = getResources().getStringArray(R.array.subList);
        data = new ArrayList<String>(Arrays.asList(dataRes));

        snapHelper = new LinearSnapHelper();

        subList = findViewById(R.id.SubList);
        layoutManager = new LinearLayoutManager(this);
        subListAdapter = new SubListAdapter((ArrayList<String>) data, this);

        layoutManager.setOrientation(LinearLayoutManager.HORIZONTAL);
        subList.setLayoutManager(layoutManager);
        subList.setAdapter(subListAdapter);

        snapHelper.attachToRecyclerView(subList);
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

    @Override
    public void onItemClick2(View v, int position){
        String url = "http://www.whalecity.kr";

        if(position == 0){
        } else if(position == 1){
            Intent intent = new Intent(Intent.ACTION_VIEW, Uri.parse(url));
            startActivity(intent);
        } else if(position == 2){

        } else if(position == 3){

        }
    }
}
