package com.launcher.rndioslauncher;

import android.animation.LayoutTransition;
import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.ImageView;
import android.widget.LinearLayout;
import android.widget.TextView;

import androidx.appcompat.app.AppCompatActivity;

import com.launcher.rndioslauncher.myVIew.VerticalSlider;

public class MainActivity extends AppCompatActivity {

    private VerticalSlider vScroller;
    private ImageView ivClick;
    private LinearLayout llContainer;
    private TextView tvTvAddContainer;
    private TextView tvRefresh;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        vScroller = findViewById(R.id.vScroller);
        ivClick = findViewById(R.id.ivClick);
        llContainer = findViewById(R.id.llContainer);
        tvTvAddContainer = findViewById(R.id.tvTvAddContainer);
        tvRefresh = findViewById(R.id.tvRefresh);
        tvRefresh.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                llContainer.removeAllViews();
            }
        });
//        vScroller.setCornerRadius(20);
        vScroller.setOnValueChangedListener(new VerticalSlider.OnValueChangedListener() {
            @Override
            public void onValueChanged(int value) {
                Log.d("VerticalSlider", "Slider value changed: " + value);

            }
        });

        ivClick.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                v.animate().scaleX(0.9f).scaleY(0.9f).setDuration(100).withEndAction(new Runnable() {
                    @Override
                    public void run() {
                        v.animate().scaleX(1f).scaleY(1f).setDuration(100).start();
                    }
                }).start();
            }
        });

        tvTvAddContainer.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
               /* LayoutTransition transition = new LayoutTransition();
                llContainer.setLayoutTransition(transition);*/

                View viewToAdd = getLayoutInflater().inflate(R.layout.xml_test_container, null);
                llContainer.addView(viewToAdd);
                LinearLayout llBlockContainer = llContainer.findViewById(R.id.llBlockContainer);

                llBlockContainer.animate().scaleX(0.9f).scaleY(0.9f).setDuration(200).withEndAction(new Runnable() {
                    @Override
                    public void run() {
                        llBlockContainer.animate().scaleX(1f).scaleY(1f).setDuration(200).start();
                    }
                }).start();
            }
        });


    }
}