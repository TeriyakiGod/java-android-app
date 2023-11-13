package com.kacper.calculator;

import com.kacper.calculator.R;

import android.os.Bundle;
import android.widget.GridView;

import androidx.appcompat.app.AppCompatActivity;

import java.util.Arrays;
import java.util.List;

public class GalleryView extends AppCompatActivity {

    private GridView gridView;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_gallery);

        Menu menu = new Menu(this, findViewById(R.id.drawer_layout), findViewById(R.id.toolbar));

        gridView = findViewById(R.id.gridView);

        // Create a list of image resource IDs
        List<Integer> imageIds = Arrays.asList(
                R.drawable.pic01,
                R.drawable.pic02,
                R.drawable.pic03,
                R.drawable.pic04,
                R.drawable.pic05,
                R.drawable.pic06,
                R.drawable.pic07,
                R.drawable.pic08,
                R.drawable.pic09,
                R.drawable.pic10,
                R.drawable.pic11,
                R.drawable.pic12,
                R.drawable.pic13,
                R.drawable.pic14,
                R.drawable.pic15
                );
        // Create and set the adapter
        ImageAdapter adapter = new ImageAdapter(this, imageIds);
        gridView.setAdapter(adapter);
    }
}
