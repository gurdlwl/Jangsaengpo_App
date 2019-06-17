package kr.hs.dgsw.jangsengpoapp;

import android.app.Activity;
import android.content.Intent;
import android.content.pm.ActivityInfo;
import android.net.Uri;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.webkit.WebChromeClient;
import android.webkit.WebSettings;
import android.webkit.WebView;
import android.widget.Toast;

public class VideoPlayActivity extends AppCompatActivity {

    String[] strings;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_video_play);

        setRequestedOrientation(ActivityInfo.SCREEN_ORIENTATION_LANDSCAPE);

        String title = getIntent().getExtras().getString("title");

        chkTitle(title);
    }

    private void chkTitle(String title){
        strings = getResources().getStringArray(R.array.titles);

        if(title.equals(strings[0])){ // 장생포 옛마을
            // https://youtu.be/lgqrEgJlixI

        } else if(title.equals(strings[1])){ // 고래 조각공원
            // https://youtu.be/jFrHcW8qUx0

        } else if(title.equals(strings[2])){ // 로이 체프먼 앤드류스
            // https://youtu.be/NrD3jym9zxs

        } else if(title.equals(strings[3])){ // 동해수호대
            // https://youtu.be/G0LSKlItpNg

        } else if(title.equals(strings[4])){ // [VR] 돌고래
            // https://youtu.be/tKF2jHOKEj4

        } else if(title.equals(strings[5])){ // [VR] 고래
            // https://youtu.be/c19YnG2g3kc

        }
    }
}
