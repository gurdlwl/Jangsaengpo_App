package kr.hs.dgsw.jangsengpoapp;

import android.app.Activity;
import android.content.Intent;
import android.content.res.Resources;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.util.Log;
import android.view.View;
import android.widget.ImageView;
import android.widget.Toast;

import java.lang.reflect.Array;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class MainActivity extends AppCompatActivity implements ListClickListener {

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

        menuList = findViewById(R.id.MenuList);
        layoutManager = new LinearLayoutManager(this);
        adapter = new ListAdapter((ArrayList<String>) data,this);

        layoutManager.setOrientation(LinearLayoutManager.HORIZONTAL);
        menuList.setLayoutManager(layoutManager);
        menuList.setAdapter(adapter);
    }

    @Override
    public void onItemClick(View v, int position){
        Toast.makeText(this, position + ", Click!", Toast.LENGTH_LONG).show();

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
