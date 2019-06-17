package kr.hs.dgsw.jangsengpoapp;

import android.content.Intent;
import android.graphics.Color;
import android.os.Handler;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.widget.Toast;

import com.igalata.bubblepicker.BubblePickerListener;
import com.igalata.bubblepicker.adapter.BubblePickerAdapter;
import com.igalata.bubblepicker.model.BubbleGradient;
import com.igalata.bubblepicker.model.PickerItem;
import com.igalata.bubblepicker.rendering.BubblePicker;

import org.jetbrains.annotations.NotNull;

public class VideoActivity extends AppCompatActivity {

    BubblePicker bubblePicker;
    String[] titles;
    int[] images;
    int color = R.color.colorPrimaryDark;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_video);

        titles = getResources().getStringArray(R.array.titles);
        // images = getResources().obtainTypedArray(R.array.images);
        // color = getResources().obtainTypedArray(R.array.colors);

        bubblePicker = findViewById(R.id.picker);
        bubblePicker.setAdapter(new BubblePickerAdapter() {
            @Override
            public int getTotalCount() {
                return titles.length;
            }

            @NotNull
            @Override
            public PickerItem getItem(int i) {
                PickerItem item = new PickerItem();

                item.setTitle(titles[i]);
                item.setGradient(new BubbleGradient(color, color, BubbleGradient.HORIZONTAL));
                item.setTextColor(Color.BLACK);

                return item;
            }
        });

        bubblePicker.setCenterImmediately(true);
        bubblePicker.setBubbleSize(100);
        bubblePicker.setListener(new BubblePickerListener() {
            @Override
            public void onBubbleSelected(@NotNull PickerItem pickerItem) {
                new Handler().postDelayed( new Runnable() {
                    @Override
                    public void run() {
                        Intent intent = new Intent(VideoActivity.this, VideoPlayActivity.class);
                        intent.putExtra("title", pickerItem.getTitle());
                        startActivity(intent);
                    }
                }, 600 );
            }

            @Override
            public void onBubbleDeselected(@NotNull PickerItem pickerItem) {
                // None
            }
        });
    }

    @Override
    protected void onResume() {
        super.onResume();
        bubblePicker.onResume();
    }

    @Override
    protected void onPause(){
        super.onPause();
        bubblePicker.onPause();
    }

    private int randomNum(){
        double randomVlaue = Math.random();
        int num = (int)(randomVlaue * 100) + 50;
        return num;
    }
}
