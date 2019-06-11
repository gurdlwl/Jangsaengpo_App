package kr.hs.dgsw.jangsengpoapp;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.LinearSnapHelper;
import android.support.v7.widget.RecyclerView;
import android.support.v7.widget.SnapHelper;
import android.view.View;
import android.widget.ImageView;
import android.widget.Toast;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

import kr.hs.dgsw.jangsengpoapp.RecyclerView.ListAdapter;
import kr.hs.dgsw.jangsengpoapp.RecyclerView.ListClickListener;

public class MainActivity extends AppCompatActivity implements ListClickListener {

    SnapHelper snapHelper;
    RecyclerView menuList;
    LinearLayoutManager layoutManager;
    ListAdapter adapter;
    ImageView bgImg1;
    ImageView bgImg2;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        String[] dataRes = getResources().getStringArray(R.array.menuList);
        List<String> data = new ArrayList<String>(Arrays.asList(dataRes));

        bgImg1 = findViewById(R.id.BgColor1);
        bgImg2 = findViewById(R.id.BgColor2);

        snapHelper = new LinearSnapHelper();

        menuList = findViewById(R.id.MenuList);
        layoutManager = new LinearLayoutManager(this);
        adapter = new ListAdapter((ArrayList<String>) data,this);

        layoutManager.setOrientation(LinearLayoutManager.HORIZONTAL);
        menuList.setLayoutManager(layoutManager);
        menuList.setAdapter(adapter);

        snapHelper.attachToRecyclerView(menuList);
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
}
