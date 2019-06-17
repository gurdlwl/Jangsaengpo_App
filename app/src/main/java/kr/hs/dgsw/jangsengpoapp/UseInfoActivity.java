package kr.hs.dgsw.jangsengpoapp;

import android.content.Intent;
import android.net.Uri;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;

public class UseInfoActivity extends AppCompatActivity {

    final String url = "http://www.whalecity.kr/EgovPageLink.do?link=city/info/fee";

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_use_info);
    }

    public void onFeeTextClick(View v){
        Intent intent = new Intent(Intent.ACTION_VIEW, Uri.parse(url));
        startActivity(intent);
    }
}
