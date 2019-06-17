package kr.hs.dgsw.jangsengpoapp;

import android.content.Intent;
import android.net.Uri;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.text.SpannableString;
import android.text.style.UnderlineSpan;
import android.view.View;
import android.widget.TextView;

public class UseInfoActivity extends AppCompatActivity {

    final String url = "http://www.whalecity.kr/EgovPageLink.do?link=city/info/fee";
    TextView tv;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_use_info);

        SpannableString text = new SpannableString(getString(R.string.fee_info));
        text.setSpan(new UnderlineSpan(), 0, text.length(), 0);
        tv.setText(text);
    }

    public void onFeeTextClick(View v){
        Intent intent = new Intent(Intent.ACTION_VIEW, Uri.parse(url));
        startActivity(intent);
    }
}
