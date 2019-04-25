package kr.hs.dgsw.jangsengpoapp;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.widget.ImageView;

public class MainActivity extends AppCompatActivity {

    RecyclerView menuList;
    LinearLayoutManager layoutManager;
    ListAdapter adapter;
    ImageView bgImg1;
    ImageView bgImg2;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        bgImg1 = findViewById(R.id.BgColor1);
        bgImg2 = findViewById(R.id.BgColor2);

        menuList = findViewById(R.id.MenuList);
        layoutManager = new LinearLayoutManager(this);
        adapter = new ListAdapter();

        layoutManager.setOrientation(LinearLayoutManager.HORIZONTAL);
        menuList.setLayoutManager(layoutManager);
        menuList.setAdapter(adapter);
    }
}
