package kr.hs.dgsw.jangsengpoapp;

import android.graphics.Color;
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
    String[] titles ={
            "test","test","test","test","test","test","test"
    };
    //getResources().getStringArray(R.array.titles);
    int[] images = {

    };
    // getResources().obtainTypedArray(R.array.images);
    int[] color = {
        R.color.colorPrimaryDark
    };
    //getResources().obtainTypedArray(R.array.colors);

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_video);

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
                item.setGradient(new BubbleGradient(color[0], color[0], BubbleGradient.HORIZONTAL));
                item.setTextColor(Color.BLACK);

                return item;
            }
        });

        // bubblePicker.setCenterImmediately(true);
        bubblePicker.setBubbleSize(100);
        bubblePicker.setListener(new BubblePickerListener() {
            @Override
            public void onBubbleSelected(@NotNull PickerItem pickerItem) {
                Toast.makeText(getApplicationContext(), "Click!", Toast.LENGTH_SHORT).show();
            }

            @Override
            public void onBubbleDeselected(@NotNull PickerItem pickerItem) {

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
}
